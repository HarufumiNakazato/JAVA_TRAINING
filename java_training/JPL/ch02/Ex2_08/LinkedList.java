package ch02.Ex2_08;

//import Ex2_07.Vehicle;

public class LinkedList {
	public  Object object;
	public  LinkedList nextList;
	
	public LinkedList(Object a_o){
		object = a_o;
	}
	public static void main(String[] args){
		//Object型変数を初期化するためのコンストラクタが必要
		Vehicle car = new Vehicle();
		Vehicle taxi = new Vehicle();
		
		LinkedList list1 = new LinkedList(car);
		LinkedList list2 = new LinkedList(taxi);

		list1.nextList = list2;
		
		System.out.println(list1.object);
		System.out.println(list1.nextList.object);
	}
}
