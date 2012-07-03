package gui1_3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PopupMenu;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class ClockWindow extends Window{
	
	public ClockWindow(Frame owner) {
		super(owner);
		// TODO �����������ꂽ�R���X�g���N�^�[�E�X�^�u
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image imgBuffer;//buffer�p�̃C���[�W
	private Graphics gBuffer;//buffer�p��Graphics�N���X
	
	private int width = 100;
	private int height = 100;
	public static final Color DefaultBackgroundColor = Color.white;
	
	private String dispDate;
	private int fontStyle = Font.BOLD;//default �̃t�H���g
	private int fontSize = 20;//default�̃t�H���g�T�C�Y
	private String fontName = "Times New Roman";
	private Font f = new Font(fontName,fontStyle,fontSize);
	
	private Color backgroundColor = DefaultBackgroundColor;
	private Color fontColor = Color.black;
	
	private FontMetrics fm;
	
	private int strHeight;
	private int strWidth;
	
	public static final GraphicsEnvironment ENV = GraphicsEnvironment.getLocalGraphicsEnvironment();
	
	public static Dimension minimumDimension; 
	
	public boolean isResize = false;
	
	private PopupMenu popMenu;
	
	private Color[] cr = {Color.black,Color.blue,Color.cyan,Color.darkGray,Color.gray,Color.green,Color.magenta,
			Color.orange,Color.pink,Color.red,Color.white,Color.yellow};
	private String[] strCrs = {"Black","Blue","Cyan","DarkGray","Gray","Green","Magenta",
			"Orange","Pink","Red","White","Yellow"};
	public static final String[] SIZES = {"5","8","9","10","12","14","18","20","24","36","48","72","96","120","180","240","360"};
	public String[] fontNames;
	
	public void createMainForm(){
		minimumDimension = this.getMinimumSize();
		this.setMainForm();
		this.setMenuForm();
		this.receiveMouseEvent(this);
		
	}
	public void paint(Graphics gr){
		Dimension d = getSize();
		//buffering ����
		//Buffer�p�̃C���[�W������Ă��Ȃ����T�C�Y���ς�������蒼��
		if(imgBuffer == null || imgBuffer.getWidth(this) != d.width || imgBuffer.getHeight(this) != d.height || this.backgroundColor != this.DefaultBackgroundColor){
			imgBuffer = createImage(d.width,d.height);
			gBuffer = null;
		}
		//buffer�pGraphics���Ȃ���΍��
		if(gBuffer == null)
			gBuffer = imgBuffer.getGraphics();
		
		gBuffer.clearRect(0, 0, d.width, d.height);
		gBuffer.setFont(f);
		gBuffer.setColor(fontColor);
		
		fm = gBuffer.getFontMetrics();
	    strWidth = fm.stringWidth(dispDate);
	    strHeight = fm.getHeight();
	    //Font���ݒ肳�ꂽ�Ƃ��̂�Font�T�C�Y�ɍ��킹��Frame�T�C�Y��ύX����
	    
	    if(dispDate!=null){
	    	try{
	    		this.width = strWidth + minimumDimension.width;
	    	}
	    	catch(Exception e){
	    		System.out.println(minimumDimension.width);
	    	}
	    	height = fm.getHeight();
	    	this.setSize(new Dimension(width, height));
	    }
	    gBuffer.drawString(dispDate, (getSize().width-strWidth)/2,(height - fm.getHeight())/2 + fm.getAscent());
	    
	    gr.drawImage(imgBuffer,0,0,this);

		isResize = false;
		
	}
	public void setSetting(String fname,int fsize, Color fcolor, Color bcolor ){
		this.fontName = fname;
		this.fontSize = fsize;
		this.backgroundColor = bcolor;
		this.setBackground(backgroundColor);
		f = new Font(fontName,fontStyle,fontSize);
		
		this.fontColor = fcolor;
		
		
	}
	//Form�̃p�����[�^��ݒ�
	private void setMainForm(){
		this.setSize(new Dimension(width,height));
		this.setLocation(ENV.getMaximumWindowBounds().width/2,ENV.getMaximumWindowBounds().height/2);
		this.setLayout(new FlowLayout());
		this.setBackground(backgroundColor);
		this.setVisible(true);
	}
	
	public void setDispDate(String date){
		dispDate = date;
	}
	
	//���j���[�o�[�ݒ�p
	private void setMenuForm(){

		 popMenu = new PopupMenu();
	     Menu menuSetting = new Menu("Window");
	     Menu fontMenu = new Menu("Font");
	     Menu colorMenu = new Menu("Color");
	     Menu sizeMenu = new Menu("Size");
	     Menu backColor = new Menu("Back Color");

	     MenuItem quit = new MenuItem("Quit");
	     
	     GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		 fontNames = ge.getAvailableFontFamilyNames();

	     for(int i = 0;i < cr.length;i++){
	    	 colorMenu.add(new MenuItem(strCrs[i]));
	    	 backColor.add(new MenuItem(strCrs[i]));
	    	
	     }

	     for(int i = 0;i < this.SIZES.length;i++)
	    	 sizeMenu.add(new MenuItem(SIZES[i]));
	     

	     for(int i = 0;i < fontNames.length;i++){
	    	 fontMenu.add(new MenuItem(fontNames[i]));
	     }
	     
	     menuSetting.add(fontMenu);
	     menuSetting.add(colorMenu);
	     menuSetting.add(sizeMenu);
	     menuSetting.add(backColor);
	     
	     popMenu.add(menuSetting);
	     popMenu.add(quit);
	     this.add(popMenu);
	     
	     recievePressQuitButtonEvent(quit);
	     recivePressFontButtonEvent(fontMenu,this);
	     recivePressFontColorButtonEvent(colorMenu,this);
	     recivePressBackColorButtonEvent(backColor,this);
	     recivePressFontSizeButtonEvent(sizeMenu,this);

	}
	//Quit�{�^���������ꂽ���̋������`
	private void recievePressQuitButtonEvent(MenuItem quit){
		class MyActionListener implements ActionListener{
			public void actionPerformed(ActionEvent arg0) {
				//Quit�{�^�����������Ƃ��̓�����L�q
				System.exit(0);
			}
		}
		quit.addActionListener(new MyActionListener());
	}
	//Font���I�����ꂽ���̋������`
	private void recivePressFontButtonEvent(Menu fontMenu,ClockWindow w){
		class MyActionListener implements ActionListener{
			ClockWindow w;
			MyActionListener(ClockWindow w){
				this.w = w;
			}
			public void actionPerformed(ActionEvent e) {
				//Font�{�^�����������Ƃ��̓�����L�q
				System.out.println(e.getActionCommand());
				w.setSetting(e.getActionCommand(), w.fontSize, w.fontColor, w.backgroundColor);
			}
		}
		for(int k = 0;k < fontNames.length;k++)
			fontMenu.getItem(k).addActionListener(new MyActionListener(w));
	}
	//Font Color���I�����ꂽ���̋������`
	private void recivePressFontColorButtonEvent(Menu colorMenu,ClockWindow w){
		class MyActionListener implements ActionListener{
			ClockWindow w;
			MyActionListener(ClockWindow w){
				this.w = w;
			}
			public void actionPerformed(ActionEvent e) {
				//Font�{�^�����������Ƃ��̓�����L�q
				System.out.println(e.getActionCommand());
				int index = 0;
				for(int i = 0;i<strCrs.length;i++)
					if(strCrs[i].equals(e.getActionCommand())){
						index = i;
						break;
					}
				w.setSetting(w.fontName, w.fontSize, cr[index], w.backgroundColor);
			}
		}
		for(int k = 0;k < strCrs.length;k++)
			colorMenu.getItem(k).addActionListener(new MyActionListener(w));
	}
	//Font Color���I�����ꂽ���̋������`
	private void recivePressBackColorButtonEvent(Menu backColor,ClockWindow w){
		class MyActionListener implements ActionListener{
			ClockWindow w;
			MyActionListener(ClockWindow w){
				this.w = w;
			}
			public void actionPerformed(ActionEvent e) {
				//Font�{�^�����������Ƃ��̓�����L�q
				System.out.println(e.getActionCommand());
				int index = 0;
				for(int i = 0;i<strCrs.length;i++)
					if(strCrs[i].equals(e.getActionCommand())){
						index = i;
						break;
					}
				w.setSetting(w.fontName, w.fontSize, w.fontColor, cr[index]);
			}
		}
		for(int k = 0;k < strCrs.length;k++)
			backColor.getItem(k).addActionListener(new MyActionListener(w));
	}
	//Font Size���I�����ꂽ���̋������`
	private void recivePressFontSizeButtonEvent(Menu sizeMenu,ClockWindow w){
		class MyActionListener implements ActionListener{
			ClockWindow w;
			MyActionListener(ClockWindow w){
				this.w = w;
			}
			public void actionPerformed(ActionEvent e) {
				//Font�{�^�����������Ƃ��̓�����L�q
				System.out.println(e.getActionCommand());
				w.setSetting(w.fontName, Integer.valueOf(e.getActionCommand()), w.fontColor, w.backgroundColor);
			}
		}
		for(int k = 0;k < SIZES.length;k++)
			sizeMenu.getItem(k).addActionListener(new MyActionListener(w));
	}
	//�}�E�X���N���b�N�A�h���b�O�����Ƃ��̋������`
	
	public void receiveMouseEvent(Window w){
		class MouseDrag implements MouseMotionListener,MouseListener{

			private Point draggedPoint;
			private Point pressedPoint;
			private Point startPos;
			private Window w;
			public MouseDrag(Window w){
				this.w = w;
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO �����������ꂽ���\�b�h�E�X�^�u
					System.out.println("dragged");
					draggedPoint = MouseInfo.getPointerInfo().getLocation();
					/*windowPoint = getLocation();
					Point diff = new Point(draggedPoint.x-windowPoint.x, draggedPoint.y-windowPoint.y);

					System.out.println("diff:" + diff);
					//System.out.println("window:" + windowPoint);
					setLocation(draggedPoint.x-diff.x, draggedPoint.y-diff.y);
					*/
					 Point cursor = e.getLocationOnScreen();
					    int xdiff = cursor.x - draggedPoint.x;
					    int ydiff = cursor.y - draggedPoint.y;
					    //System.out.println(draggedPoint.x - xdiff);
					    w.setLocation(draggedPoint.x , draggedPoint.y);

			}

			@Override
			public void mouseMoved(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO �����������ꂽ���\�b�h�E�X�^�u
				if(e.getButton() == MouseEvent.BUTTON3){
					// �E�N���b�N���ꂽ���̏���;
					popMenu.show(w, e.getPoint().x + 10, e.getPoint().y);
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO �����������ꂽ���\�b�h�E�X�^�u
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO �����������ꂽ���\�b�h�E�X�^�u
				
			}

			Point getScreenLocation(MouseEvent e) {
			    Point p1 = e.getPoint();
			    Point p2 = w.getLocationOnScreen();
			    return new Point(p1.x+p2.x, p1.y+p2.y);
			  }
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO �����������ꂽ���\�b�h�E�X�^�u
				//pressedPoint  = getScreenLocation(e);
			    //startPos = w.getLocation();
			    
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO �����������ꂽ���\�b�h�E�X�^�u
				 //Point cursor = e.getLocationOnScreen();
				   // int xdiff = cursor.x - pressedPoint.x;
				    //int ydiff = cursor.y - pressedPoint.y;
				    //w.setLocation(startPos.x + xdiff, startPos.y + ydiff);
			}
		}
		this.addMouseMotionListener(new MouseDrag(w));
		this.addMouseListener(new MouseDrag(w));
	}
}
