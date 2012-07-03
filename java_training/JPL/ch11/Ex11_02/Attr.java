package ch11.Ex11_02;

public class Attr<E> {
	private final String name;
	private E value;
	
	public Attr(String name){
		this.name = name;
	}
	
	public Attr(String name, E value){
		this.name = name;
		this.value = value;
	}
	
	public String getName(){
		return name;
	}
	
	public E getValue(){
		return value;
	}
	
	public void setValue(E value){
		this.value = value;
	}
	
	public String toString(){
		return name + " ='" + value.toString() + "'";
		}
	
	public void show(){
		System.out.println(name + " : '" + value.toString() + "'");
	}
	
	public static void main(String[] args){
		Attr<Integer> attr = new Attr<Integer>("1st",2);
		System.out.println(attr.toString());
		attr.show();
	}
}
