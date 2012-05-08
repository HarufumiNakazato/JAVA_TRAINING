package ch06.Ex6_05;

//codeが冗長になるので、定数固有メソッドは実装する必要なし
public enum Color {
	RED("RED"){
		String getColor(){
			return this.name;
		}
	},
	YELLOW("YELLOW"){
		String getColor(){
			return this.name;
		}
	},
	GREEN("GREEN"){
		String getColor(){
			return this.name;
		}
	};
	
	String name;
	Color(String name){
		this.name = name;
	}
	abstract String getColor();

	
	public static void main(String[] args){
		Color green = Color.GREEN;
		Color red = Color.RED;
		Color yellow = Color.YELLOW;
		
		System.out.println(green.getColor());
		System.out.println(red.getColor());
		System.out.println(yellow.getColor());
	}
}
