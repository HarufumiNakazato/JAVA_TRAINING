package gui1_4;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.util.Locale;


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
	
	public static Color[] cr = {Color.black,Color.blue,Color.cyan,Color.darkGray,Color.gray,Color.green,Color.magenta,
			Color.orange,Color.pink,Color.red,Color.white,Color.yellow};
	public static String[] strCrs = {"Black","Blue","Cyan","DarkGray","Gray","Green","Magenta",
			"Orange","Pink","Red","White","Yellow"};
	public static final String[] SIZES = {"5","8","9","10","12","14","18","20","24","36","48","72","96","120","180","240","360"};
	private Button okButton;
	private Button cancelButton;
	
	private String beforeFontName;
	private String beforeFontSize;
	private Color beforeFontColor;
	private Color beforeBackgroundColor; 
	private GridBagLayout gbl = new GridBagLayout();
	
	enum Location{
		CENTER,NORTH,NORTHEAST,NORTHWEST,SOUTH,SOUTHEAST,SOUTHWEST,EAST,WEST;
	}
	public PropertyFrame(ClockView view, String title, boolean modal){
		super(view,title,modal);
		this.view = view;
		fontName = view.getDefaultFontName();
		fontSize = String.valueOf(view.getDefaultFontSize());
		fontColor = view.getDefaultFontColor();
		backgroundColor = view.getDefaultBackgroundColor();
		
		this.setLocation(view.getLocation().x , view.getLocation().y + 30);
		setSize(width,height);
		//this.setLocation(Setting.ENV.getMaximumWindowBounds().width/2 + view.getWidth(),
				//Setting.ENV.getMaximumWindowBounds().height/2);
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
		this.setLayout(gbl);
		
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
		
		this.addButton(labelName, 0, 0, 1, 1,Location.EAST);
		this.addButton(choiceName,1,0,1,1,Location.WEST);
		this.addButton(labelSize,0,1,1,1,Location.EAST);
		this.addButton(choiceSize, 1, 1, 1, 1,Location.WEST);
		this.addButton(labelFontColor, 0, 2, 1, 1,Location.EAST);
		this.addButton(choiceFontColor, 1, 2, 1, 1,Location.WEST);
		this.addButton(labelBackgroundColor, 0, 3, 1, 1,Location.EAST);
		this.addButton(choiceBackgroundColor, 1, 3, 1, 1,Location.WEST);
		this.addButton(okButton, 1, 4, 1, 1,Location.SOUTHEAST);
		this.addButton(cancelButton, 2, 4, 1, 1,Location.SOUTHEAST);
		
	}
	//GridBagLayoutにボタンを配置
	public void addButton(Component b, int x, int y,int w,int h,Location location){
		GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        
        switch(location){
        case CENTER:
        	gbc.anchor = GridBagConstraints.CENTER;
        	break;
        case NORTH:
        	gbc.anchor = GridBagConstraints.NORTH;
        	System.out.println("north");
        	break;
        case SOUTH:
        	gbc.anchor = GridBagConstraints.SOUTH;
        	break;
        case EAST:
        	gbc.anchor = GridBagConstraints.EAST;
        	System.out.println("EAST");
        	break;
        case WEST:
        	gbc.anchor = GridBagConstraints.WEST;
        	break;
        case NORTHEAST:
        	gbc.anchor = GridBagConstraints.NORTHEAST;
        	break;
        case NORTHWEST:
        	gbc.anchor = GridBagConstraints.NORTHWEST;
        	break;
        case SOUTHEAST:
        	gbc.anchor = GridBagConstraints.SOUTHEAST;
        	break;
        case SOUTHWEST:
        	gbc.anchor = GridBagConstraints.SOUTHWEST;
        	break;
        }
        
        gbl.setConstraints(b, gbc);
        
        add(b);
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
		choiceName.select(search(fs, this.fontName));
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
			System.out.println("SIZES[" + i + "] = " + SIZES[i]);
		}

		choiceSize.select(search(SIZES, this.fontSize));
		class MyItemListener implements ItemListener{
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				//　イベント発生時の処理
				
				fontSize = choiceSize.getSelectedItem();
			}
		}
		choiceSize.addItemListener(new MyItemListener());
	}
	private String search(String[] ary, String s){
		for(int i = 0;i<ary.length;i++){
			if(ary[i].equals(s))
			return ary[i];
		}
		return null;
		
	}
	//Font Colorをドロップリストに追加
	private void addItemsFontColor(){
		
		for(int i = 0; i < strCrs.length; i++){
			choiceFontColor.add(strCrs[i]);
		}
		
		choiceFontColor.select(search(strCrs, ClockView.colorToString(this.fontColor)));
		class MyItemListener implements ItemListener{
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				//　イベント発生時の処理
				fontColor = cr[indSearch(strCrs, choiceFontColor.getSelectedItem())];
			}
			private int indSearch(String[] ary, String s){
				for(int i = 0;i<strCrs.length;i++){
					if(strCrs[i].equals(choiceFontColor.getSelectedItem()))
						return i;
				}
				return -1;
			}
		}
		choiceFontColor.addItemListener(new MyItemListener());
	}
	//Background Colorをドロップリストに追加
	private void addItemsBackgroundColor(){
		for(int i = 0; i < strCrs.length; i++){
			choiceBackgroundColor.add(strCrs[i]);
		}
		choiceBackgroundColor.select(search(strCrs, ClockView.colorToString(this.backgroundColor)));
		class MyItemListener implements ItemListener{
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				//　イベント発生時の処理
				backgroundColor = cr[indSearch(strCrs, choiceBackgroundColor.getSelectedItem())];
			}
			private int indSearch(String[] ary, String s){
				for(int i = 0;i<strCrs.length;i++){
					if(strCrs[i].equals(choiceBackgroundColor.getSelectedItem()))
						return i;
				}
				return -1;
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
