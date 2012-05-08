package ch02.Ex2_14;

public class TestEx2_14 {
	public static void main(String[] args){
		LinkedList list1 = new LinkedList("hoge");
		LinkedList list2 = new LinkedList("fuga",list1);
		
		System.out.println("•ÏX‘O");
		System.out.println(list1.toString());
		System.out.println(list2.toString());
		
		list1.setobject(1);
		list2.setobject(2);
		
		System.out.println("•ÏXŒã");
		System.out.println(list1.toString());
		System.out.println(list2.toString());
	}

}
