package gui2_4;

import gui1_4.PropertyFrame.*;
import gui2_4.ClockView.DispPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.*;
import java.io.*;
import java.util.Arrays;

import javax.imageio.*;
import javax.swing.*;


public class PropertyFrame extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ClockView view;

	private int width = 400;
	private int height = 200;
	
	private String fontName = "Times New Roman";
	private String fontSize = "18";
	private Color fontColor;
	private Color backgroundColor;
	
	private JComboBox choiceName;
	private JComboBox choiceSize;
	private JComboBox choiceFontColor;
	private JComboBox choiceBackgroundColor;
	private JFrame colorTipFrame;
	
	private Label labelName;
	private Label labelSize;
	private JLabel labelFontColor;
	private Label labelBackgroundColor;
	
	private DispPanel panel;
	private JPanel colorPanel;
	
	private Color[] cr = {Color.black,Color.blue,Color.cyan,Color.darkGray,Color.gray,Color.green,Color.magenta,
			Color.orange,Color.pink,Color.red,Color.white,Color.yellow};
	private String[] strCrs = {"Black","Blue","Cyan","DarkGray","Gray","Green","Magenta",
			"Orange","Pink","Red","White","Yellow"};
	private GridBagLayout gbl = new GridBagLayout();

	public static final String[] SIZES = /*{"5","8","9","10","12","14",*/{"18","20","24","36","48","72","96","120","180","240","360"};
	private Button okButton;
	private Button cancelButton;
	
	private String beforeFontName;
	private String beforeFontSize;
	private Color beforeFontColor;
	private Color beforeBackgroundColor; 
	
	private BufferedImage image;
	enum Location{
		CENTER,NORTH,NORTHEAST,NORTHWEST,SOUTH,SOUTHEAST,SOUTHWEST,EAST,WEST;
	}
	class ComboLabel{
		String text;
		  Icon icon;

		  ComboLabel(String text, Icon icon){
		    this.text = text;
		    this.icon = icon;
		  }

		  public String getText(){
		    return text;
		  }

		  public Icon getIcon(){
		    return icon;
		  }
	}
	
	class MyCellRenderer extends JLabel implements ListCellRenderer {
		  public Component getListCellRendererComponent(
		            JList list,
		            Object value,
		            int index,
		            boolean isSelected,
		            boolean cellHasFocus){

		      ComboLabel data = (ComboLabel)value;
		      setText(data.getText());
		      setIcon(data.getIcon());

		    return this;
		  }
		}
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
		//this.setLayout(new GridLayout(5,3));
		this.setLayout(gbl);
		
		choiceName = new JComboBox();
		choiceSize = new JComboBox();
		choiceFontColor = new JComboBox();
		choiceBackgroundColor = new JComboBox();
		

		labelName = new Label("Font Name",Label.LEFT);
		labelSize = new Label("Font Size",Label.LEFT);
		labelFontColor = new JLabel("Font Color", Label.LEFT);
		labelBackgroundColor = new Label("Backgroud Color",Label.LEFT);
		
		
		
		labelName = new Label("Font Name",Label.LEFT);
		labelSize = new Label("Font Size",Label.LEFT);
		labelFontColor = new JLabel("Font Color", Label.LEFT);
		labelBackgroundColor = new Label("Backgroud Color",Label.LEFT);

		
		this.addItemsFontName();
		this.addItemsFontSize();
		this.addItemsFontColor();
		this.addItemsBackgroundColor();
		
		makeColorTips(choiceFontColor);
		makeColorTips(choiceBackgroundColor);
		//Buttonの配置
	    GridBagConstraints gbc = new GridBagConstraints();
	    	    
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

		//JlabelにColorチップを埋め込む関数
		
		this.createColorPanel();
		/*
		//this.recieveMouseMove();
		choiceFontColor.addFocusListener(new java.awt.event.FocusAdapter() {
	        public void focusGained(java.awt.event.FocusEvent e) {
	        	//Color Tip表示
	        	if(colorTipFrame.isVisible() == false)
	        		colorTipFrame.setVisible(true);
	        }//focus Gained
	});//addFocusListener
		choiceBackgroundColor.addFocusListener(new java.awt.event.FocusAdapter() {
	        public void focusGained(java.awt.event.FocusEvent e) {
	        	//Color Tip表示
	        	if(colorTipFrame.isVisible() == false)
	        		colorTipFrame.setVisible(true);
	        }//focus Gained
	});//addFocusListener
	*/
		choiceName.addMouseMotionListener(new MouseMotionListener(){
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub	
			}
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("moved");
			}
		});
	}
	private void makeColorTips(JComboBox combo) {
		// TODO Auto-generated method stub
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		
		for(int i = 0;i < cr.length;i++) {
			String path = makeColorRectungle(cr[i]);
			//アイコンを埋め込む
			Icon icon = new ImageIcon(path);
			model.addElement(new ComboLabel(strCrs[i],icon));
		}
		combo.setModel(model);
		MyCellRenderer renderer = new MyCellRenderer();
		combo.setRenderer(renderer);
	}
		private String makeColorRectungle(Color color) {
		// TODO Auto-generated method stub
			BufferedImage im = new BufferedImage(5,5,BufferedImage.TYPE_INT_RGB);
			Graphics g = im.getGraphics();
			g.setColor(color);
			System.out.println(color);
			g.fillRect(0,0,5,5);
			g.dispose();
			try {
				ImageIO.write(im,"png",new File("rect_" + color.hashCode() + ".png"));
			} catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return "rect_" + color.hashCode() + ".png";
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
	public void setTipVisible(boolean b){
		colorTipFrame.setVisible(b);
	}
	public void recieveMouseMove(){
		class MyMouseMotionListener implements MouseMotionListener{
			@Override
			public void mouseDragged(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseMoved(MouseEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("hi");
			}
		}
		addMouseMotionListener(new MyMouseMotionListener());
	}
	//閉じるボタンを押したときの処理
	public void recieveCloseEvent(){
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				setVisible(false);
				colorTipFrame.setVisible(false);
			}
		});
	}
	//Font名をドロップリストに追加
	private void addItemsFontName(){
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String[] fs = ge.getAvailableFontFamilyNames();
		
		for(int i = 0; i < fs.length; i++){
			choiceName.addItem(fs[i]);
		}
		choiceName.setSelectedItem(Arrays.binarySearch(fs, this.fontName));
		class MyItemListener implements ItemListener{
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				//　イベント発生時の処理
				fontName = (String) choiceName.getSelectedItem();
				//view.setSetting(fontName, Integer.parseInt(fontSize), fontColor, backgroundColor);
				view.setFontName(fontName);
				view.canResize = true;
			}
		}
		choiceName.addItemListener(new MyItemListener());
	}
	//Font sizeをドロップリストに追加
	private void addItemsFontSize(){
		
		for(int i = 0; i < SIZES.length; i++){
			choiceSize.addItem(SIZES[i]);
		}
		choiceSize.setSelectedItem(Arrays.binarySearch(SIZES, this.fontSize));
		class MyItemListener implements ItemListener{
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				//　イベント発生時の処理
				fontSize = (String) choiceSize.getSelectedItem();
				//view.setSetting(fontName, Integer.parseInt(fontSize), fontColor, backgroundColor);
				view.setFontSize(Integer.parseInt(fontSize));
				//panel.resizeWithString();
				view.canResize = true;
			}
		}
		choiceSize.addItemListener(new MyItemListener());
	}
	//Font Colorをドロップリストに追加
	private void addItemsFontColor(){
		
		for(int i = 0; i < strCrs.length; i++){
			choiceFontColor.addItem(strCrs[i]);
		}
		
		choiceFontColor.setSelectedItem(Arrays.binarySearch(strCrs, "Black"));
		class MyItemListener implements ItemListener{
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				//　イベント発生時の処理
				
				fontColor = cr[choiceFontColor.getSelectedIndex()];
				//view.setSetting(fontName, Integer.parseInt(fontSize), fontColor, backgroundColor);
				view.setColor(fontColor);
			}
		}
		choiceFontColor.addItemListener(new MyItemListener());
	}
	//Background Colorをドロップリストに追加
	private void addItemsBackgroundColor(){
		for(int i = 0; i < strCrs.length; i++){
			choiceBackgroundColor.addItem(strCrs[i]);
		}
		choiceBackgroundColor.setSelectedItem(Arrays.binarySearch(strCrs, "White"));
		class MyItemListener implements ItemListener{
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				//　イベント発生時の処理
				backgroundColor = cr[choiceBackgroundColor.getSelectedIndex()];
				//view.setSetting(fontName, Integer.parseInt(fontSize), fontColor, backgroundColor);
				view.setBackground(backgroundColor);
			}
		}
		choiceBackgroundColor.addItemListener(new MyItemListener());
	}
	//String choiceの項目が選択された時の処理
	private void recieveFontColorSelected(){
		
	}
	//OK Buttonを押したときの処理
	private void recieveokButtonEvent(){
		class MyActionListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//OKボタンを押したときの動作を記述
				//view.setSetting(fontName, Integer.parseInt(fontSize), fontColor, backgroundColor);
				setVisible(false);
			}
		}
		okButton.addActionListener(new MyActionListener());
	}
	private void createColorPanel(){
		colorPanel = new JPanel();
		this.colorTipFrame = new JFrame();
		colorPanel.setPreferredSize(new Dimension(150,150));
		//colorPanel.setVisible(false);
		colorPanel.setLayout(new GridLayout(6,2));
		colorTipFrame.setSize(new Dimension(150,150));
		for(int i = 0;i<this.strCrs.length;i++){
			Label col = new Label(strCrs[i]);
			col.setBackground(cr[i]);
			colorPanel.add(col);
		}
		colorTipFrame.add(colorPanel);
	}
	@Override
	public void setVisible(boolean b){
		super.setVisible(b);
	}
	//Cancel Buttonを押下
	private void recievecancelButtonEvent(){
		class MyActionListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Cancel Buttonを押したときの処理
				view.setSetting(beforeFontName, Integer.parseInt(beforeFontSize), beforeFontColor, beforeBackgroundColor);
				view.canResize = true;
				//選択項目を前の項目に戻す
				setVisible(true);
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
	
	public void setPanel(DispPanel panel){
		this.panel = panel;
	}
}
