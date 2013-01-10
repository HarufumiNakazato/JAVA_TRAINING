package gui2_4;



import gui2_4.ClockView.DispPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.prefs.Preferences;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JComponent;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class ClockView extends JFrame{
	
	/**
	 * 
	 */
	private Preferences prefs;
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
	
	public ClockView(){
		view = this;
		prefs = Preferences.userNodeForPackage(this.getClass());
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
			if(canResize)
				resizeWithString();
			g2d.drawString(time, (view.width - strWidth)/2, (view.getHeight())/2 - menuBar.getHeight());
		}
		public void resizeWithString(){
			if(time==null)
				return;
			
			int space = 30;//余白
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
		property.setLocation(getX()+ width, getY());
		this.setMainForm();
		this.recieveCloseEvent();
		minimumDimension = this.getMinimumSize();
	}

	//閉じるボタン押下時の挙動
	public void recieveCloseEvent(){
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				saveLocation();
				System.exit(0);
			}
		});
	}
	//Formのパラメータを設定
	private void setMainForm(){
		System.setProperty("apple.laf.useScreenMenuBar", "true");
		this.setLocationRelativeTo(null);
		Point p = loadLocation();
		if(p != null)
			this.setLocation(p);
		this.setTitle("Digital Clock");
		this.setResizable(true);
		this.setLayout(new FlowLayout());
		this.setBackground(backgroundColor);
		this.setMenuForm();
		this.getContentPane().add(panel);//panelを追加
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
	}
	

	//メニューバー設定用
	private void setMenuForm(){
		 menuBar = new JMenuBar();
		 this.add(menuBar);
		 JMenu setProperty = new JMenu("Property");
		 JMenuItem setting = new JMenuItem("Setting");
		 
	     setProperty.setFont(new Font("Times New Roman",Font.PLAIN,10));
	     setProperty.add(setting);
	     menuBar.add(setProperty);
	     setJMenuBar(menuBar);
	     //無名クラスの中でPropertyダイアログを呼び出す処理
	     setting.addActionListener(new ActionListener(){
	    	 public void actionPerformed(ActionEvent evt){
	    		 System.out.println("test");
				 property.setBeforeSetting(fontName,String.valueOf(fontSize),fontColor,backgroundColor);
				 property.setVisible(true);
	    	 }
	     });
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
	
	public void saveLocation() {
		prefs.putInt("x", this.getLocation().x);
		prefs.putInt("y", this.getLocation().y);
		System.out.println("Save complete");
	}
	public Point loadLocation() {
		int x = prefs.getInt("x", -100);
		int y = prefs.getInt("y", -100);
		if(x == -100)
			return null;
		if(y == -100)
			return null;
		return new Point(x,y);
	}
}
