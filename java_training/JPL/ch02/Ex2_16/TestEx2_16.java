package ch02.Ex2_16;

public class TestEx2_16 {
	public static void main(String[] args){
		LinkedList list1 = new LinkedList("hoge");
		LinkedList list2 = new LinkedList("fuga",list1);
		LinkedList list3 = new LinkedList("hage",list2);
		
		System.out.println(list3.size());
	}
}
