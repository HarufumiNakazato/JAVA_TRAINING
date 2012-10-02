package gui2_1;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class ClockView extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int width = 200;
	private int height = 100;
	public static final Color DefaultBackgroundColor = Color.white;
	
	private String time;//時間
	private int fontStyle = Font.BOLD;//default のフォント
	private int fontSize = 20;//defaultのフォントサイズ
	private String fontName = "Times New Roman";
	private Font f = new Font(fontName,fontStyle,fontSize);
	private JMenuBar menuBar;
	private PropertyFrame property;
	private Color backgroundColor = DefaultBackgroundColor;
	private Color fontColor = Color.black;
	
	private FontMetrics fm;
	private int strHeight;
	private int strWidth;
	private boolean isResize = false;
	private Graphics gBuffer;//buffer用のGraphicsクラス
	public static final GraphicsEnvironment ENV = GraphicsEnvironment.getLocalGraphicsEnvironment();
	private boolean isWindowWithSize = true;
	public static Dimension minimumDimension;
	private JPanel panel;
	
	public JComponent comp;
	
	public ClockView(){
		panel = new DispPanel();
		this.setVisible(true);
		this.getContentPane().add(panel);
	}
	//paintComponent()のための内部クラス
	class DispPanel extends JPanel{
		private Font font = new Font("Serif",Font.PLAIN,30);
		private Color fontColor = Color.BLACK;
		private Color backgroundColor = Color.YELLOW;
		public DispPanel(){
			setBounds(0,0,200,200);
			//this.setSize(200, 400);
		}
		public void setFont(Font font){
			this.font = font;
		}
		public void setBackgroundColor(Color color){
			this.backgroundColor = color;
		}
		public void setFontColor(Color color){
			this.fontColor = color;
		}
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D)g;
			g2d.setFont(font);
			g2d.setBackground(backgroundColor);
			
			if(time!=null)
				g2d.drawString(time, 50,80);
		}
	}
	public void createMainForm(){
		this.setMainForm();
		this.recieveCloseEvent();
		minimumDimension = this.getMinimumSize();
		property = new PropertyFrame(this,"Property",true);
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
		this.setSize(new Dimension(width,height));
		this.setLocation(ENV.getMaximumWindowBounds().width/2,ENV.getMaximumWindowBounds().height/2);
		this.setTitle("Digital Clock");
		this.setResizable(true);
		this.setLayout(new FlowLayout());
		this.setBackground(backgroundColor);
		this.setMenuForm();
		this.setLayout(new GridLayout(2,2));
		//this.getContentPane().add(panel);//panelを追加
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(0, 0, 200, 200);
		this.setResizable(false);
		//this.setVisible(true);
		
	}
	

	//メニューバー設定用
	private void setMenuForm(){

		 menuBar = new JMenuBar();
		 this.add(menuBar);
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
	public void setFontSize(int size){
		this.fontSize = size;
	}
	//Setting-Propertyボタンを押したとき処理
	private void recieveSettingPropertyButtonEvent(MenuItem sproperty){
		class MyActionListener implements ActionListener{
			public void actionPerformed(ActionEvent arg0) {
				//propertyボタンを押したときの動作を記述
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
