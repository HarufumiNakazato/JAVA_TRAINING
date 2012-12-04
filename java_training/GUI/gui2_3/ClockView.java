package gui2_3;



import gui1_3.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ClockView extends JWindow{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int width = 100;
	private int height = 100;
	public static final Color DefaultBackgroundColor = Color.white;
	
	private String time;//時間
	private int fontStyle = Font.BOLD;//default のフォント
	private int fontSize = 24;//defaultのフォントサイズ
	private String fontName = "Arial Black";
	private Font f = new Font(fontName,fontStyle,fontSize);
	private JMenuBar menuBar;
	private PropertyFrame property;
	private Color backgroundColor = DefaultBackgroundColor;
	private Color fontColor = Color.black;
	private ClockView view;
	
	private boolean isResize = false;
	public static final GraphicsEnvironment ENV = GraphicsEnvironment.getLocalGraphicsEnvironment();
	public static Dimension minimumDimension;
	private JPanel panel;
	
	public boolean canResize = true;//外部から文字列に合わせてサイズを変更させるためのフラグ
	public JComponent comp;
	private Graphics2D g2d;
	private PopupMenu popMenu;
	
	private MouseEvent start;
	
	private Color[] cr = {Color.black,Color.blue,Color.cyan,Color.darkGray,Color.gray,Color.green,Color.magenta,
			Color.orange,Color.pink,Color.red,Color.white,Color.yellow};
	private String[] strCrs = {"Black","Blue","Cyan","DarkGray","Gray","Green","Magenta",
			"Orange","Pink","Red","White","Yellow"};
	public static final String[] SIZES = {"5","8","9","10","12","14","18","20","24","36","48","72","96","120","180","240","360"};
	public String[] fontNames;
	
	public ClockView(){
		view = this;
		this.getContentPane().setPreferredSize(new Dimension(width,height));
		//this.setSize(width, height);
		panel = new DispPanel();
		this.pack();
	}
	//paintComponent()のための内部クラス
	class DispPanel extends JPanel{
		int strWidth;
		int strHeight;
		{
			f = new Font(fontName,fontStyle,fontSize);
			System.out.println("f::" + f.getFontName());
		}
		public DispPanel(){
			//this.setPreferredSize(new Dimension(width,height));
			this.setSize(new Dimension(width,height));
		}
		public void setFont(Font font){
			f = font;
		}
		public void setFontColor(Color color){
			fontColor = color;
		}
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D)g;
			g2d.setColor(fontColor);
			g2d.setFont(f);
			g2d.setBackground(backgroundColor);
			
			if(time!=null)
				this.drawStringCenter(time, g2d);
		}
		private void drawStringCenter(String time,Graphics2D g2d){

			FontMetrics fm = g2d.getFontMetrics();
			strWidth = fm.stringWidth(time);
			strHeight = fm.getHeight();
			if(canResize) {
				System.out.println("sttt");
				resizeWithString();
			}
			g2d.drawString(time, (view.width - strWidth)/2, (view.getHeight())/2 - menuBar.getHeight());
		}
		public void resizeWithString(){
			if(time==null)
				return;
			
			int space = 30;//余白
			System.out.println(strWidth);
			view.width = strWidth + space * 2;
			view.height = strHeight + space * 2;
			view.getContentPane().setPreferredSize(new Dimension(view.width,view.height));
			System.out.println(width + ":" + height);
			//view.setSize(new Dimension(width,height));
			this.setPreferredSize(new Dimension(view.width,view.height));
			view.pack();
			canResize = false;
		}
	}
	public void createMainForm(){
		property = new PropertyFrame(this,"Property",true);
		property.setPanel((DispPanel)panel);
		property.setLocation(getX() + width, getY());
		this.setMainForm();
		this.recieveCloseEvent();
		minimumDimension = this.getMinimumSize();
		//AWTUtilities.setWindowShape(this,shape);
	}

	//閉じるボタン押下時の挙動
	public void recieveCloseEvent(){
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}

	//Formのパラメータを設定
	private void setMainForm(){
		System.setProperty("apple.laf.useScreenMenuBar", "true");
		this.setLocationRelativeTo(null);
		this.setName("Digital Clock");
		this.setLayout(new FlowLayout());
		this.setBackground(backgroundColor);
		this.setMenuForm();
		this.getContentPane().add(panel);//panelを追加
		this.setVisible(true);
		
		//mouse動作検知
		//MouseEvent start;
		addMouseListener(new MouseAdapter() {
			  Window window;
			@Override 
			  public void mousePressed(MouseEvent me) {
			    start = me;
			  }
			  public void mouseClicked(MouseEvent me) {
				   if(window == null) {
						  window = SwingUtilities.windowForComponent(me.getComponent());
				   }
				   if(me.getButton() == MouseEvent.BUTTON3){
						// 右クリックされた時の処理;
						popMenu.show(ClockView.this, me.getPoint().x + 10, me.getPoint().y);
					}
			  }
		});
	   addMouseMotionListener(new MouseAdapter() {
		   private Window window;
		   @Override 
		   public void mouseDragged(MouseEvent me) {
				  
				  if(window == null) {
					  window = SwingUtilities.windowForComponent(me.getComponent());
				  }
			    Point eventLocationOnScreen = me.getLocationOnScreen();
			    
			    setLocation(eventLocationOnScreen.x - start.getX(),
			                       eventLocationOnScreen.y - start.getY());
			  }
	   });
	}
	

	//メニューバー設定用
	private void setMenuForm(){
		 menuBar = new JMenuBar();
		 this.add(menuBar);
		
		 fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		 JMenuItem setting = new JMenuItem("Setting");
		 
		 popMenu = new PopupMenu();
	     Menu menuSetting = new Menu("Window");
	     Menu fontMenu = new Menu("Font");
	     Menu colorMenu = new Menu("Color");
	     Menu sizeMenu = new Menu("Size");
	     Menu backColor = new Menu("Back Color");

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
	     
	     MenuItem quit = new MenuItem("Quit");
	     popMenu.add(menuSetting);
	     popMenu.add(quit);
	     this.add(popMenu);
	     
	     recievePressQuitButtonEvent(quit);
	     recivePressFontButtonEvent(fontMenu,this);
	     recivePressFontColorButtonEvent(colorMenu,this);
	     recivePressBackColorButtonEvent(backColor,this);
	     recivePressFontSizeButtonEvent(sizeMenu,this);
	     
	     //無名クラスの中でPropertyダイアログを呼び出す処理
	     setting.addActionListener(new ActionListener(){
	    	 public void actionPerformed(ActionEvent evt){
	    		 System.out.println("test");
				 property.setBeforeSetting(fontName,String.valueOf(fontSize),fontColor,backgroundColor);
				 property.setVisible(true);
	    	 }
	     });
	}
	//Quitボタンが押された時の挙動を定義
	private void recievePressQuitButtonEvent(MenuItem quit){
		class MyActionListener implements ActionListener{
			public void actionPerformed(ActionEvent arg0) {
				//Quitボタンを押したときの動作を記述
				System.exit(0);
			}
		}
		quit.addActionListener(new MyActionListener());
	}
	
	//Fontが選択された時の挙動を定義
	private void recivePressFontButtonEvent(Menu fontMenu,ClockView w){
		class MyActionListener implements ActionListener{
			ClockView w;
			MyActionListener(ClockView w){
				this.w = w;
			}
			public void actionPerformed(ActionEvent e) {
				//Fontボタンを押したときの動作を記述
				System.out.println(e.getActionCommand());
				w.setSetting(e.getActionCommand(), w.fontSize, w.fontColor, w.backgroundColor);
			}
		}
		for(int k = 0;k < fontNames.length;k++)
			fontMenu.getItem(k).addActionListener(new MyActionListener(w));
	}
	//Font Colorが選択された時の挙動を定義
	private void recivePressFontColorButtonEvent(Menu colorMenu,ClockView w){
		class MyActionListener implements ActionListener{
			ClockView w;
			MyActionListener(ClockView w){
				this.w = w;
			}
			public void actionPerformed(ActionEvent e) {
				//Fontボタンを押したときの動作を記述
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
	//Font Colorが選択された時の挙動を定義
	private void recivePressBackColorButtonEvent(Menu backColor,ClockView w){
		class MyActionListener implements ActionListener{
			ClockView w;
			MyActionListener(ClockView w){
				this.w = w;
			}
			public void actionPerformed(ActionEvent e) {
				//Fontボタンを押したときの動作を記述
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
	//Font Sizeが選択された時の挙動を定義
	private void recivePressFontSizeButtonEvent(Menu sizeMenu,ClockView w){
		class MyActionListener implements ActionListener{
			ClockView w;
			MyActionListener(ClockView w){
				this.w = w;
			}
			public void actionPerformed(ActionEvent e) {
				//Fontボタンを押したときの動作を記述
				System.out.println(e.getActionCommand());
				w.setSetting(w.fontName, Integer.valueOf(e.getActionCommand()), w.fontColor, w.backgroundColor);
			}
		}
		for(int k = 0;k < SIZES.length;k++)
			sizeMenu.getItem(k).addActionListener(new MyActionListener(w));
	}

	public void setSetting(String fname,int fsize, Color fcolor, Color bcolor ){
		this.fontName = fname;
		this.fontSize = fsize;
		this.backgroundColor = bcolor;
		
		f = new Font(fontName,fontStyle,fontSize);
		
		this.fontColor = fcolor;
		
		this.setBackground(backgroundColor);
		canResize = true;
	}
	public void setDispDate(String date){
		time = date;
		panel.repaint();
	}
	public void setFontSyle(int style){
		this.fontStyle = style;
	}

	//Setting-Propertyボタンを押したとき処理
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
	public void setColor(Color c){
		this.fontColor = c;
	}
	public void setBackgroundColor(Color c){
		this.backgroundColor = c;
		panel.setBackground(c);
	}
	public void setFontName(String fontName){
		this.fontName = fontName;
		f = new Font(this.fontName,fontStyle,fontSize);	
	}
	public void setFontStyle(int fontStyle){
		this.fontStyle = fontStyle;
		f = new Font(fontName,this.fontStyle,fontSize);
	}
	public void setFontSize(int fontSize){
		this.fontSize = fontSize;
		f = new Font(fontName,fontStyle,this.fontSize);
	}
}
