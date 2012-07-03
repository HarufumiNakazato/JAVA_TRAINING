package gui1_3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;


public class PropertyFrame extends Dialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ClockView view;

	private int width = 400;
	private int height = 200;
	
	private String fontName;
	private String fontSize;
	private Color fontColor;
	private Color backgroundColor;
	
	private Choice choiceName;
	private Choice choiceSize;
	private Choice choiceFontColor;
	private Choice choiceBackgroundColor;
	
	private Label labelName;
	private Label labelSize;
	private Label labelFontColor;
	private Label labelBackgroundColor;
	
	private Color[] cr = {Color.black,Color.blue,Color.cyan,Color.darkGray,Color.gray,Color.green,Color.magenta,
			Color.orange,Color.pink,Color.red,Color.white,Color.yellow};
	private String[] strCrs = {"Black","Blue","Cyan","DarkGray","Gray","Green","Magenta",
			"Orange","Pink","Red","White","Yellow"};
	public static final String[] SIZES = {"5","8","9","10","12","14","18","20","24","36","48","72","96","120","180","240","360"};
	private Button okButton;
	private Button cancelButton;
	
	private String beforeFontName;
	private String beforeFontSize;
	private Color beforeFontColor;
	private Color beforeBackgroundColor; 
	
	
	public PropertyFrame(ClockView view, String title, boolean modal){
		super(view,title,modal);
		this.view = view;
		fontName = view.getDefaultFontName();
		fontSize = String.valueOf(view.getDefaultFontSize());
		fontColor = view.getDefaultFontColor();
		backgroundColor = view.getDefaultBackgroundColor();
		
		setSize(width,height);
		this.setLocation(ClockView.ENV.getMaximumWindowBounds().width/2 + view.getWidth(),
				ClockView.ENV.getMaximumWindowBounds().height/2);
		setVisible(false);
		setTitle(title);
		setResizable(false);
		
		okButton = new Button("OK");
		okButton.setBackground(Color.lightGray);
		
		cancelButton = new Button("Cancel");
		cancelButton.setBackground(Color.lightGray);
		this.recieveCloseEvent();
		this.recieveokButtonEvent();
		this.recievecancelButtonEvent();
		this.setLayout(new GridLayout(5,1));
		
		choiceName = new Choice();
		choiceSize = new Choice();
		choiceFontColor = new Choice();
		choiceBackgroundColor = new Choice();
		
		
		
		labelName = new Label("Font Name",Label.LEFT);
		labelSize = new Label("Font Size",Label.LEFT);
		labelFontColor = new Label("Font Color", Label.LEFT);
		labelBackgroundColor = new Label("Backgroud Color",Label.LEFT);

		
		this.addItemsFontName();
		this.addItemsFontSize();
		this.addItemsFontColor();
		this.addItemsBackgroundColor();
		
		
		this.add(labelName);
		this.add(choiceName);
		this.add(labelSize);
		this.add(choiceSize);
		this.add(labelFontColor);
		this.add(choiceFontColor);
		this.add(labelBackgroundColor);
		this.add(choiceBackgroundColor);
		
		this.add(okButton);
		this.add(cancelButton);
		
	}
	
	//閉じるボタンを押したときの処理
	public void recieveCloseEvent(){
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				setVisible(false);
			}
		});
	}
	//Font名をドロップリストに追加
	private void addItemsFontName(){
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String[] fs = ge.getAvailableFontFamilyNames();
		
		for(int i = 0; i < fs.length; i++){
			choiceName.add(fs[i]);
		}
		choiceName.select(Arrays.binarySearch(fs, this.fontName));
		class MyItemListener implements ItemListener{
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				//　イベント発生時の処理
				fontName = choiceName.getSelectedItem();
			}
		}
		choiceName.addItemListener(new MyItemListener());
	}
	//Font sizeをドロップリストに追加
	private void addItemsFontSize(){
		
		for(int i = 0; i < SIZES.length; i++){
			choiceSize.add(SIZES[i]);
		}
		choiceSize.select(Arrays.binarySearch(SIZES, this.fontSize));
		class MyItemListener implements ItemListener{
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				//　イベント発生時の処理
				
				fontSize = choiceSize.getSelectedItem();
			}
		}
		choiceSize.addItemListener(new MyItemListener());
	}
	//Font Colorをドロップリストに追加
	private void addItemsFontColor(){
		
		for(int i = 0; i < strCrs.length; i++){
			choiceFontColor.add(strCrs[i]);
		}
		
		choiceFontColor.select(Arrays.binarySearch(strCrs, "Black"));
		class MyItemListener implements ItemListener{
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				//　イベント発生時の処理
				fontColor = cr[Arrays.binarySearch(strCrs, choiceFontColor.getSelectedItem())];
			}
		}
		choiceFontColor.addItemListener(new MyItemListener());
	}
	//Background Colorをドロップリストに追加
	private void addItemsBackgroundColor(){
		for(int i = 0; i < strCrs.length; i++){
			choiceBackgroundColor.add(strCrs[i]);
		}
		choiceBackgroundColor.select(Arrays.binarySearch(strCrs, "White"));
		class MyItemListener implements ItemListener{
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				//　イベント発生時の処理
				backgroundColor = cr[Arrays.binarySearch(strCrs, choiceBackgroundColor.getSelectedItem())];
			}
		}
		choiceBackgroundColor.addItemListener(new MyItemListener());
	}
	//OK Buttonを押したときの処理
	private void recieveokButtonEvent(){
		class MyActionListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//OKボタンを押したときの動作を記述
				//System.out.println(Integer.parseInt(fontSize));
				view.setIsResize(true);
				view.setSetting(fontName, Integer.parseInt(fontSize), fontColor, backgroundColor);

				setVisible(true);
			}
		}
		okButton.addActionListener(new MyActionListener());
	}
	//Cancel Buttonを押下
	private void recievecancelButtonEvent(){
		class MyActionListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Cancel Buttonを押したときの処理
				view.setIsResize(true);
				view.setSetting(beforeFontName, Integer.parseInt(beforeFontSize), beforeFontColor, beforeBackgroundColor);

				setVisible(false);
			}
		}
		cancelButton.addActionListener(new MyActionListener());
	}
	/* getter */
	public String getFontName() {
		return fontName;
	}

	/**
	 * @return fontSize
	 */
	public String getFontSize() {
		return fontSize;
	}

	/**
	 * @return fontColor
	 */
	public Color getFontColor() {
		return fontColor;
	}

	/**
	 * @return backgroundColor
	 */
	public Color getBackgroundColor() {
		return backgroundColor;
	}
	
	public void setBeforeSetting(String name, String size, Color col, Color bcol){
		this.beforeFontName = name;
		this.beforeFontSize = size;
		this.beforeFontColor = col;
		this.beforeBackgroundColor = bcol;
	}
	


}
