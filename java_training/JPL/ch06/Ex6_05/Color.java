package ch06.Ex6_05;

//code���璷�ɂȂ�̂ŁA�萔�ŗL���\�b�h�͎�������K�v�Ȃ�
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
