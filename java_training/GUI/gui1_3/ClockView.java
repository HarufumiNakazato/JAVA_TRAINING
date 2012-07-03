package gui1_3;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuComponent;
import java.awt.MenuItem;

public class ClockView extends Frame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int width = 200;
	private int height = 100;
	public static final Color DefaultBackgroundColor = Color.white;
	
	private String dispDate;
	private int fontStyle = Font.BOLD;//default �̃t�H���g
	private int fontSize = 20;//default�̃t�H���g�T�C�Y
	private String fontName = "Times New Roman";
	private Font f = new Font(fontName,fontStyle,fontSize);
	private MenuBar menuBar;
	private PropertyFrame property;
	private Color backgroundColor = DefaultBackgroundColor;
	private Color fontColor = Color.black;
	private FontMetrics fm;
	private int strHeight;
	private int strWidth;
	private boolean isResize = false;
	private Image imgBuffer;//buffer�p�̃C���[�W
	private Graphics gBuffer;//buffer�p��Graphics�N���X
	public static final GraphicsEnvironment ENV = GraphicsEnvironment.getLocalGraphicsEnvironment();
	private boolean isWindowWithSize = true;
	public static Dimension minimumDimension;
	
	public void createMainForm(){
		this.setMainForm();
		this.recieveCloseEvent();
		this.recieveResizeEvent();
		minimumDimension = this.getMinimumSize();
		property = new PropertyFrame(this,"Property",true);
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
	    
	    if(isResize){
	    	this.width = strWidth + minimumDimension.width;
	    	
	    	height = fm.getHeight() + 100;
	    	this.setSize(new Dimension(width, height));
	    }
	    gBuffer.drawString(dispDate, (getSize().width-strWidth)/2,(height - fm.getHeight())/2 + fm.getAscent() + 20);
	    
	    gr.drawImage(imgBuffer,0,0,this);

		isResize = false;
	}
	//double buffering �̂��߂̃I�[�o�[���C�h
	public void update(Graphics g){
		paint(g);
	}
	//����{�^���������̋���
	public void recieveCloseEvent(){
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
	//�T�C�Y�ύX�����Ƃ��̃C�x���g����
	private void recieveResizeEvent(){
		class MyComponentListener implements ComponentListener{

			private Image tempImgBuffer = createImage(width,height);//buffer�p�̃C���[�W
			private Graphics tempGBuffer = tempImgBuffer.getGraphics();
			private int optSize;
			 
			@Override
			public void componentHidden(ComponentEvent e) {
				// TODO �����������ꂽ���\�b�h�E�X�^�u
				
			}

			@Override
			public void componentMoved(ComponentEvent e) {
				// TODO �����������ꂽ���\�b�h�E�X�^�u
				
			}

			@Override
			public void componentResized(ComponentEvent e) {
				// TODO �����������ꂽ���\�b�h�E�X�^�u
				if(isWindowWithSize){
					width = getSize().width;
					height = getSize().height;
					this.calcFontSize(width,height);
					fontSize = optSize;
					System.out.println("[decide]optSize = " + optSize);
					f = new Font(fontName,fontStyle,fontSize);
				}
				isWindowWithSize = true;
				// TODO �t�H���g�T�C�Y��K�؂ȑ傫���ɂ���
			}

			@Override
			public void componentShown(ComponentEvent e) {
				// TODO �����������ꂽ���\�b�h�E�X�^�u
				
			}
			private void calcFontSize(int width, int height){

				System.out.println("calcFontSize");
				FontMetrics tfm = null;
				for(int i = 1; i < PropertyFrame.SIZES.length; i++){
					Font tf = new Font(fontName,fontStyle,Integer.parseInt(PropertyFrame.SIZES[i]));
					
					tempGBuffer.clearRect(0, 0, getSize().width, getSize().height);
					tempGBuffer.setFont(tf);
					
					tfm = tempGBuffer.getFontMetrics();
					System.out.println("optSize = " + optSize);
					if(getSize().width < tfm.stringWidth(dispDate) || getSize().height < (tfm.getHeight() + tfm.getAscent()))
					{
						System.out.println("width = " + width + ": tfm.stringWidth(dispDate) = " + tfm.stringWidth(dispDate));
						System.out.println("height = " + height+ ": tfm.stringWidth(dispDate) = " + (tfm.getHeight() + tfm.getAscent()));
						System.out.println("�͈͂ɂ͂����Ă�");
						break;
					}
					
					optSize = Integer.parseInt(PropertyFrame.SIZES[i]);
					
					System.out.println("[breaked]optSize = " + optSize);
				}
			}
		}
		addComponentListener(new MyComponentListener());
	}
	//Form�̃p�����[�^��ݒ�
	private void setMainForm(){
		
		this.setSize(new Dimension(width,height));
		this.setLocation(ENV.getMaximumWindowBounds().width/2,ENV.getMaximumWindowBounds().height/2);
		this.setTitle("Digital Clock");
		this.setResizable(true);
		this.setLayout(new FlowLayout());
		this.setBackground(backgroundColor);
		this.setMenuForm();
		this.setVisible(true);
	}
	

	//���j���[�o�[�ݒ�p
	private void setMenuForm(){

		 menuBar = new MenuBar();
	     this.setMenuBar(menuBar);
	     Menu menuSetting = new Menu("Window");
	     
	     menuBar.add(menuSetting);
	     MenuItem setProperty = new MenuItem("Property");
	     setProperty.setFont(new Font("Calibri",Font.PLAIN,10));
	     this.recieveSettingPropertyButtonEvent(setProperty);
	     menuSetting.add(setProperty);
	}
	public void setSetting(String fname,int fsize, Color fcolor, Color bcolor ){
		this.fontName = fname;
		this.fontSize = fsize;
		this.backgroundColor = bcolor;
		
		f = new Font(fontName,fontStyle,fontSize);
		
		this.fontColor = fcolor;
		
		this.setBackground(backgroundColor);
	}
	public void setDispDate(String date){
		dispDate = date;
	}
	public void setFontSyle(int style){
		this.fontStyle = style;
	}
	public void setFontSize(int size){
		this.fontSize = size;
	}
	//Setting-Property�{�^�����������Ƃ�����
	private void recieveSettingPropertyButtonEvent(MenuItem sproperty){
		class MyActionListener implements ActionListener{
			public void actionPerformed(ActionEvent arg0) {
				//property�{�^�����������Ƃ��̓�����L�q
				    property.setBeforeSetting(fontName,String.valueOf(fontSize),fontColor,backgroundColor);
					property.setVisible(true);
			}
		}
		sproperty.addActionListener(new MyActionListener());
	}

	public void setIsResize(boolean r){
		isResize = r;
		this.isWindowWithSize = !isResize;
	}
	public String getDefaultFontName(){
		return this.fontName;
	}
	public int getDefaultFontSize(){
		return this.fontSize;
	}
	public Color getDefaultFontColor(){
		return this.fontColor;
	}
	public Color getDefaultBackgroundColor(){
		return this.backgroundColor;
	}
}
