package ch02.Ex2_02;

public class TestEx2_02{
	public static void main(String[] args){
		Object test_o = 1;
		LinkedList ll = new LinkedList();
		LinkedList next = new LinkedList();
		ll.object = test_o;
		ll.nextList = next;
		
		System.out.println(ll.object);
		System.out.println(ll.nextList);
	}
}