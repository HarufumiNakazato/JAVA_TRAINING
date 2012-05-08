package ch02.Ex2_11;

public class LinkedList {
	private Object object;
	private  LinkedList nextList;

	
	public LinkedList(Object a_object){
		object = a_object;
	}
	public LinkedList(Object a_object, LinkedList a_nextlist){
		object = a_object;
		nextList = a_nextlist;
	}
	
	public String toString(){
		return "object = " + object;
	}
	public Object getobject(){
		return object;
	}
	
	public LinkedList getnextList(){
		return nextList;
	}
	public void setnextList(LinkedList a_list){
		nextList = a_list;
	}
}
