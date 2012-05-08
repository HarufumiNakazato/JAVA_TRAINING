package ch02.Ex2_06;

public class LinkedList {
	public  Object object;
	public  LinkedList nextList;
	
	public LinkedList(){
		
	}
	public static void main(String[] args){

		Vehicle car = new Vehicle();
		Vehicle taxi = new Vehicle();
		
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
		
		list1.object = car;
		list2.object = taxi;
		list1.nextList = list2;
		
		System.out.println(list1.object);
		System.out.println(list1.nextList.object);
	}
}
