package ch06.Ex6_04;

public enum Color {
	RED("RED"),
	YELLOW("YELLOW"),
	GREEN("GREEN");
	
	String name;
	Color(String name){
		this.name = name;
	}
	public String getColor()
	{
		return this.name;
	}
	
	public static void main(String[] args){
		Color green = Color.GREEN;
		Color red = Color.RED;
		Color yellow = Color.YELLOW;
		
		System.out.println(green.getColor());
		System.out.println(red.getColor());
		System.out.println(yellow.getColor());
	}
}
