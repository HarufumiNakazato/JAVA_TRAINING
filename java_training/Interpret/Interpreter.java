
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class Interpreter extends Frame{
	private static final long serialVersionUID = 1L;
	private int width = 800;
	private int height = 300;
	public static final GraphicsEnvironment ENV = GraphicsEnvironment.getLocalGraphicsEnvironment();
	public static Color[] cr = {Color.magenta,Color.lightGray,Color.black,Color.blue,Color.cyan,Color.darkGray,Color.gray,Color.green,Color.magenta,
		Color.orange,Color.pink,Color.red,Color.white,Color.yellow};
	public static String[] strCrs = {"Magenta","LightGray","Black","Blue","Cyan","DarkGray","Gray","Green","Magenta",
		"Orange","Pink","Red","White","Yellow"};
	
	private TextField tf;
	private TextField fieldNameInputText;
	private TextField fieldValueInputText;
	private Button createObjectButton;
	private Button modifyValueButton;
	private TextArea dispArea;
	private TextField methodNameInputText;
	private Button executeButton;
	private Object createdObject;
	private TextField methodParamInputText;
	private TextField constructorNameInputText;
	private Button createInstanceButton;
	private TextField constParamsText;
	private TextField arrayTypeText;
	private TextField arraySizeText;
	private Button createArrayButton;
	
	private Object createdArray;
	private Button clear;
	private Button setElementButton;
	private Button getElementButton;
	
	private TextField getElementText;
	private TextField setElementText;
	
	private Type elementType;
	
	public static void main(String[] args){
		Interpreter interpret = new Interpreter();
		interpret.start();
	}
	public Interpreter(){
		
	}
	public void start(){
		this.setMainForm();
		this.setObject();
		this.recieveCloseEvent();
		
	}
	//Formのパラメータを設定
	public void setMainForm(){
		this.setSize(new Dimension(width,height));
		this.setLocation(ENV.getMaximumWindowBounds().width/2,ENV.getMaximumWindowBounds().height/2);
		this.setTitle("Interpreter");
		this.setResizable(true);
		this.setLayout(new FlowLayout());
		this.setBackground(Color.white);
		this.setVisible(true);
	}
	//Formにオブジェクトをセットする
	public void setObject(){
		//Object名入力フィールド
		this.setBackground(Color.lightGray);
		this.add(new Label("Create object"));
		tf = (TextField)add(new TextField(20));
		//createボタン
		createObjectButton = new Button("create");
		createObjectButton.setBackground(Color.lightGray);
		recieveCreateButtonEvent(this);
		this.add(createObjectButton);
		
		//Field名変更用入力フィールド
		this.add(new Label("Modify field"));
		fieldNameInputText = (TextField)add(new TextField(20));
		
		//Field値変更用入力フィールド
		fieldValueInputText = (TextField)add(new TextField(5));
		
		//modifyボタン
		modifyValueButton = new Button("modify");
		modifyValueButton.setBackground(Color.lightGray);
		recieveModifyButtonEvent(this);
		this.add(modifyValueButton);
		
		//method名入力エリア
		this.add(new Label("Execute method"));
		this.methodNameInputText = (TextField)add(new TextField(20));
		
		//param入力エリア
		methodParamInputText = (TextField)add(new TextField(10));
		
		//method実行ボタン
		this.executeButton = new Button("execute");
		executeButton.setBackground(Color.lightGray);
		recieveExecuteButtonEvent(this);
		this.add(executeButton);

		//Class.constructorname 入力フィールド
		this.add(new Label("Constructor"));
		constructorNameInputText = (TextField)add(new TextField(20));
		//params
		this.constParamsText = (TextField)add(new TextField(10));
		//コンストラクタ生成ボタン
		createInstanceButton = new Button("call");
		createInstanceButton.setBackground(Color.lightGray);
		recieveCallConstButtonEvent(this);
		this.add(createInstanceButton);
		
		//配列の生成ボタン
		this.add(new Label("Create array"));
		createArrayButton = new Button("Array");
		arrayTypeText = (TextField)add(new TextField(10));
		arraySizeText = (TextField)add(new TextField(5));
		recieveCreateArrayButtonEvent(this);
		this.add(createArrayButton);
		
		//配列値の取得設定
		this.add(new Label("Set element"));
		setElementText = (TextField)add(new TextField(5));
		setElementButton = new Button("set");
		recieveSetElementButtonEvent(this);
		this.add(setElementButton);
		
		this.add(new Label("Get element"));
		getElementText = (TextField)add(new TextField(5));
		getElementButton = new Button("get");
		recieveGetElementButtonEvent(this);
		this.add(getElementButton);
		//Object詳細表示エリア
		dispArea = new TextArea();
		this.add(dispArea);
		
		clear = new Button("Clear");
		recieveClearButtonEvent(this);
		this.add(clear);
		
		
	}
	//閉じるボタン押下時の挙動
	public void recieveCloseEvent(){
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
	//setElementボタン押下時の挙動
	public void recieveSetElementButtonEvent(final Interpreter interpret){
		class MyActionListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//createArray Buttonを押したときの処理
				if(!setElementText.getText().equals("") || setElementText.getText().split(",").length<2){
					int ind = Integer.parseInt(setElementText.getText().split(",")[0]);
					try{
						Array.set(createdArray, ind, returnValue(setElementText.getText().split(",")[1],elementType));
					}catch(ArrayIndexOutOfBoundsException e){
						dispArea.setText(e.toString());
					}
					dispArea.append("\n"+"[" + ind + "] = " + Array.get(createdArray,ind).toString());
				}else{
					dispArea.setText("Input array index or value");
				}
			}
		}
		setElementButton.addActionListener(new MyActionListener());
	}
	//getElementボタン押下時の挙動
		public void recieveGetElementButtonEvent(final Interpreter interpret){
			class MyActionListener implements ActionListener{
				@Override
				public void actionPerformed(ActionEvent arg0) {
					//createArray Buttonを押したときの処理
					int ind = Integer.parseInt(getElementText.getText());
					System.out.println(ind);
					if(elementType.getClass().isPrimitive()){
						try{
							dispArea.append("\n"+"[" + ind + "] = " + Array.get(createdArray,ind).toString());
						}catch(Exception e){
							dispArea.setText(e.toString());
						}
					}else{
						createdObject = Array.get(createdArray, ind);
						showContents(createdObject);
					}
				}
			}
			getElementButton.addActionListener(new MyActionListener());
		}
	//clearボタン押下時の挙動
	public void recieveClearButtonEvent(final Interpreter interpret){
		class MyActionListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//createArray Buttonを押したときの処理
				dispArea.setText("");
			}
		}
		clear.addActionListener(new MyActionListener());
	}
	//createArrayボタン押下時の挙動
	public void recieveCreateArrayButtonEvent(final Interpreter interpret){
		class MyActionListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//createArray Buttonを押したときの処理
				createdArray = null;
				int size = 0;
				if(!interpret.arrayTypeText.equals("")){
					
					if(!interpret.arraySizeText.equals(""))
						size = (Integer) returnValue(interpret.arraySizeText.getText(),int.class);
					try{
						try {
							elementType = returnType(interpret.arrayTypeText.getText());

						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							dispArea.setText(e.toString());
						}
						createdArray = Array.newInstance((Class<?>)elementType ,size);
						try {
							Class<?> cls = Class.forName(arrayTypeText.getText());
							if(!cls.isPrimitive())
								for(int k = 0;k<size;k++)
									try {
										Array.set(createdArray, k, cls.newInstance());
									} catch (ArrayIndexOutOfBoundsException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} catch (IllegalArgumentException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} catch (InstantiationException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} catch (IllegalAccessException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						dispArea.setText(interpret.arrayTypeText.getText() + "[" + size + "]");
					}catch(NullPointerException e){
						dispArea.setText("Input type is invalid.");
					}
					
				}else
					interpret.dispArea.setText("Input array type.");
			}
		}
		createArrayButton.addActionListener(new MyActionListener());
	}
	//callconstボタン押下時の挙動
	public void recieveCallConstButtonEvent(final Interpreter interpret){
		class MyActionListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//callconst Buttonを押したときの処理
				dispArea.setText("");
				Class<?> cls = null;
				try {
					cls = Class.forName(interpret.constructorNameInputText.getText());
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					dispArea.append("\n" + "throw " + e.getCause().toString());
				}
				Constructor defaultConst = null;
				ArrayList<Constructor> overLoadConsts = new ArrayList<Constructor>();
				
				if(!interpret.constructorNameInputText.getText().equals("")){
					
					if(interpret.constParamsText.getText().equals(""))//コンストラクタ引数がない場合
						try {
							createdObject = cls.newInstance();
						} catch (IllegalArgumentException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							dispArea.append("\n" + "throw " + e.getCause().toString());
						} catch (InstantiationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							dispArea.append("\n" + "throw " + e.getCause().toString());
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							dispArea.append("\n" + "throw " + e.getCause().toString());
						}
					else{//コンストラクタ引数が存在する場合
						String[] params = interpret.constParamsText.getText().split(",");
						String[] paramTypes = new String[params.length];
						String[] paramValues = new String[params.length];
						
						System.out.println(paramTypes.length);
						for(int j = 0;j<params.length;j++){
							paramTypes[j] = params[j].split(" ")[0];
							paramValues[j] = params[j].split(" ")[1];
						}
						
						Constructor[] cons = cls.getConstructors();
						for(Constructor c:cons){
							Type[] types = c.getGenericParameterTypes();
							if(types.length==0)
								defaultConst = c;
							else if(types.length == params.length)
								overLoadConsts.add(c);
						}
						boolean flag = true;
						Constructor result = null;
						Type[] resultType = null;
						for(int n = 0;n < overLoadConsts.size();n++){
							Type[] p = overLoadConsts.get(n).getGenericParameterTypes();
							for(int c = 0;c < p.length;c++){
								flag &= p[c].toString().contains(paramTypes[c]);
							}
							if(flag){
								result = overLoadConsts.get(n);
								resultType = p;
								break;
							}
						}
						System.out.println(resultType[1] + "----------------");
						Object[] obj = new Object[paramTypes.length];
						for(int m = 0; m < obj.length;m++){
							obj[m] = Interpreter.returnValue(paramValues[m], resultType[m]);
						}
						try {
							createdObject = result.newInstance(obj);
						} catch (IllegalArgumentException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							dispArea.append("\n" + "throw " + e.getCause().toString());
						} catch (InstantiationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							dispArea.append("\n" + "throw " + e.getCause().toString());
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							dispArea.append("\n" + "throw " + e.getCause().toString());
						} catch (InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							dispArea.append("\n" + "throw " + e.getCause().toString());
						}
					}
					Class<?> c = createdObject.getClass();
					interpret.showField(c.getDeclaredFields(),createdObject);
					interpret.showConstructor(c.getConstructors(), createdObject);
					interpret.showMethod(c.getDeclaredMethods(), createdObject);
				}else
					dispArea.setText("Constructor name is invalid.");
			}
		}
		createInstanceButton.addActionListener(new MyActionListener());
	}
	//excecuteボタン押下時の挙動
	public void recieveExecuteButtonEvent(final Interpreter interpret){
		class MyActionListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//execute Buttonを押したときの処理
				Method method = null;
				Type[] types = null;
				Type[] exceptions = null;
				String[] params = methodParamInputText.getText().split(",");
				String[] paramTypes = new String[0];
				String[] paramValues = new String[0];
				if(!methodParamInputText.getText().equals("")){
					paramTypes = new String[params.length];
					paramValues = new String[params.length];
					System.out.println(params.length);
					for(int i = 0;i<params.length;i++)
						paramTypes[i] = params[i].split(" ")[0];
					for(int i = 0;i<params.length;i++)
						paramValues[i] = params[i].split(" ")[1];
				}
				if(!interpret.methodNameInputText.getText().equals("")){
					Class t = createdObject.getClass();
					while(t != null){
						try {
							//method = createdObject.getClass().getMethod(interpret.methodNameInputText.getText());
							Method[] methods = t.getDeclaredMethods();
							//System.out.println(t.getName());
							for(Method m:methods){
								m.setAccessible(true);
								//System.out.println(m.getName());
								if(m.getName().equals(interpret.methodNameInputText.getText())){
									
									Type[] tps = m.getParameterTypes();
									System.out.println(m.getName() + ":" + tps.length);
									if(tps.length == paramTypes.length){
										boolean flag = true;
										for(int a = 0;a < tps.length;a++){
											flag &= tps[a].toString().contains(paramTypes[a]);
											System.out.println(tps[a].toString() +":" +paramTypes[a]);
										}
										
										if(flag){
											method = m;
											System.out.println(method.getParameterTypes().length);
											break;
										}
									}
								}
							}
							
							if(method != null){
								types = method.getGenericParameterTypes();
								exceptions = method.getGenericExceptionTypes();
								break;
							}else{
								t = t.getSuperclass();
							}
					}catch (SecurityException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							interpret.dispArea.setText(e.getMessage());
						}
					}
				
				//methodが引数をもたない場合
				if(method.getParameterTypes().length==0){
					try {
						
						Object o;
						try {
							o = method.invoke(createdObject, null);
							if(o!=null)
								dispArea.append("\n" + "return " + o.toString() + "\n");
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}catch (InvocationTargetException ite){
						for(Type et:exceptions)
							if(et == ite.getCause().getClass())
								dispArea.append("\n" + "throw " + ite.getCause().toString());
					}
				}else{//引数がある場合
					if(interpret.methodParamInputText.getText().equals(""))
						dispArea.setText("Input Parameters.");
					else{
							
							System.out.println(params.length);
							Object[] os = new Object[types.length];
							if(types.length != params.length)
								dispArea.setText("Parameters are invalid.");
							else{
								for(int i = 0; i<os.length; i++)
									os[i] = Interpreter.returnValue(paramValues[i], types[i]);
								try {
									Object o = method.invoke(createdObject, os);
									if(o!=null)
										dispArea.append("\n" + "return " + o.toString() + "\n");
								} catch (IllegalArgumentException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
									dispArea.setText(e.getMessage());
								} catch (IllegalAccessException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
									dispArea.setText(e.getMessage());
								} catch (InvocationTargetException ite) {
									// TODO Auto-generated catch block
									ite.printStackTrace();
									for(Type et:exceptions)
										if(et == ite.getCause().getClass())
											dispArea.append("\n" + "throw " + ite.getCause().toString());
								}
							}
						}
					}
				}else
					interpret.dispArea.setText("Input method name.");
			}
		}
		executeButton.addActionListener(new MyActionListener());
	}

	//createボタン押下時の挙動
	public void recieveCreateButtonEvent(final Interpreter interpret){
		class MyActionListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//create Buttonを押したときの処理
				String text = interpret.tf.getText();
				try {
					Class<?> cls = Class.forName(text);
					try {
						createdObject = cls.cast(cls.newInstance());
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						interpret.dispArea.setText(e.getMessage());
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					interpret.showField(cls.getDeclaredFields(),createdObject);
					interpret.showConstructor(cls.getConstructors(), createdObject);
					interpret.showMethod(cls.getDeclaredMethods(), createdObject);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					interpret.dispArea.setText(e.toString());
				}
			}
		}
		createObjectButton.addActionListener(new MyActionListener());
	}
	//modifyボタン押下時の挙動
	public void recieveModifyButtonEvent(final Interpreter interpret){
		
		class MyActionListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//modify Buttonを押したときの処理
				if(interpret.fieldNameInputText.getText() != ""){
					
					String newValue = interpret.fieldValueInputText.getText();
					try {
						Class<?> cls = createdObject.getClass();
						Field f = cls.getDeclaredField(interpret.fieldNameInputText.getText());
						
						f.setAccessible(true);
						try {
							System.out.println(f.getType());
							f.set(createdObject, returnValue(newValue,f.getType()));

							showField(cls.getDeclaredFields(),createdObject);
						} catch (IllegalArgumentException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							interpret.dispArea.setText(e.getMessage());
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							interpret.dispArea.setText(e.getMessage());
						}
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						interpret.dispArea.setText(e.getMessage());
					} catch (NoSuchFieldException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						interpret.dispArea.setText(e.getMessage());
					}
				}
			}
		}
		modifyValueButton.addActionListener(new MyActionListener());
	}
	
	//
	public void showContents(Object obj){
		Constructor[] cons = obj.getClass().getConstructors();
		Field[] fs = obj.getClass().getDeclaredFields();
		Method[] ms = obj.getClass().getDeclaredMethods();
		
		showConstructor(cons,obj);
		showField(fs,obj);
		showMethod(ms,obj);
	}
	//Constructorを表示させる
	public void showConstructor(Constructor[] cons,Object obj){
		for (Constructor c : cons) {
        	if (c.getDeclaringClass() == Object.class)
        		continue;
        	if(c.getDeclaringClass() == c.getClass())
        		continue;
        	
        	String decl = showDescr(c.toString(),obj.getClass().getName());
        	this.dispArea.append(decl + "\n");
    	}
	}
	//Fieldを表示させる
	public void showField(Field[] fs,Object obj){
		for (Field f : fs) {
        	if (f.getDeclaringClass() == Object.class)
        		continue;
        	try {
        		f.setAccessible(true);
				try {
					//if(!f.getType().isArray())
						this.dispArea.append(f.getType() + " " + f.getName() + " = " + f.get(obj) +"\n");
					/*
						else{//fieldが配列だった場合
						String temp = "{";
						Class<?> type = f.getClass().getComponentType();
						for(int k = 0;k<Array.getLength(f);k++){
							temp += Array.get(f, k).toString();
							if(k!=Array.getLength(f)-1)
								temp += ", ";
						}
						temp += "}";
						this.dispArea.append(f.getType() + " " + f.getName() + " = " + temp +"\n");
						
					}
					*/
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (IllegalArgumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	}
		this.dispArea.append("\n");
	}
	//Methodを表示させる
	public void showMethod(Method[] ms, Object obj){
		for (Method m : ms) {
        	if (m.getDeclaringClass() == Object.class)
        		continue;
        	if(m.getDeclaringClass() == m.getClass())
        		continue;
        	
        	String decl = showDescr(m.toString(),obj.getClass().getName());
        	this.dispArea.append(decl + "\n");
    	}
	}
	private static String showArray(Object array){
		if(array.getClass().isArray()){
			String s = "{";
			for(int l = 0;l<Array.getLength(array);l++){
				System.out.println(array.toString());
				Type a = (Type)Array.get(array, l);
				if(l != Array.getLength(array)-1)
					s+=a.toString() + ",";
			}
			return s + "}";
		}else{
			return "Not Array";
		}
	}
	private static String showDescr(String memberName,String classPath){
		String[] cpaths = classPath.split("\\.");
		String className = cpaths[cpaths.length-1];
		String rootPath = classPath.replace(className,"");
		String[] dec = memberName.split(" ");
		String result =  dec[dec.length-1].replace(rootPath, "");
		result = result.replace(className+".", "");

		return memberName.replace(dec[dec.length-1], result);
	}
	// ... definition of strip ...
    private static String strip(String base,String remove){
    	return Pattern.compile(remove).matcher(base).replaceAll("");
    }
	public static Object returnValue(String value, Type type){
		if(type == int.class){
			//System.out.println("Int");
			System.out.println(value);
			return Integer.parseInt(value);
		}
		else if(type == String.class){
			System.out.println("Called");
			return value;
		}
		else if(type == byte.class)
			return Byte.parseByte(value);
		else if(type == long.class)
			return Long.parseLong(value);
		else if(type == short.class)
			return Short.parseShort(value);
		else if(type == float.class)
			return Float.parseFloat(value);
		else if(type == boolean.class)
			return Boolean.parseBoolean(value);
		else if(type == Color.class){
			for(int i = 0;i<strCrs.length;i++){
				if(strCrs[i].toLowerCase().equals(value.toLowerCase())){
						return cr[i];
				}
			}
			return null;
		} 
		else
			return null;
	}
	public static Type returnType(String s) 
			throws ClassNotFoundException{
		if(int.class.toString().contains(s))
			return int.class;
		else if(String.class.toString().contains(s))
			return String.class;
		else if(byte.class.toString().contains(s))
			return byte.class;
		else if(float.class.toString().contains(s))
			return float.class;
		else if(long.class.toString().contains(s))
			return long.class;
		else if(short.class.toString().contains(s))
			return short.class;
		else if(Color.class.toString().contains(s))
			return Color.class;
		else if(Frame.class.toString().contains(s))
			return Frame.class;
		else if(TestSample.class.toString().contains(s))
			return TestSample.class;
		else
			return Class.forName(s);
	}
}
