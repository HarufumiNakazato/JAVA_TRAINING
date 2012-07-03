package ch03.Ex3_07;

public class ColorAttr extends Attr{
	private ScreenColor myColor;
	
	public static void main(String[] args){
		ScreenColor sc1 = new ScreenColor(100);
		ScreenColor sc2 = new ScreenColor(2700);
		
		ColorAttr ca1 = new ColorAttr("RED", sc1);
		ColorAttr ca2 = new ColorAttr("BLUE", sc2);
		ColorAttr ca3 = new ColorAttr("YELLOW",sc1);
		
		
		System.out.println("ca1 = ca2? : " + ca1.equals(ca2));
		System.out.println("ca1 = ca3? : " + ca1.equals(ca3));
		
		System.out.println("hashCode ca1 : " + ca1.hashCode());
		System.out.println("hashCode ca2 : " + ca2.hashCode());
		System.out.println("hashCode ca3 : " + ca3.hashCode());
		
	}
	
	public ColorAttr(String name, Object value){
		super(name, value);
		decodeColor();
	}
	
	public ColorAttr(String name){
		this(name, "transparent");
	}

	public ColorAttr(String name, ScreenColor value){
		super(name, value.toString());
		myColor = value;
	}
	
	public Object setValue(Object newValue){
		Object retval = super.setValue(newValue);
		
		decodeColor();
		return retval;
	}
	
	public ScreenColor setValue(ScreenColor newValue){
		super.setValue(newValue.toString());
		ScreenColor oldValue = myColor;
		myColor = newValue;
		return oldValue;
	}
	
	public ScreenColor getColor(){
		return myColor;
	}
	
	protected void decodeColor(){
		if(getValue() == null)
			myColor = null;
		else
			myColor = new ScreenColor(getValue());
	}
	
	public boolean equals(ColorAttr obj){
		return (super.equals(obj)&&obj.getColor().equals(myColor));
	}
	
	public int hashCode(){
		return myColor.hashCode();
	}
}
