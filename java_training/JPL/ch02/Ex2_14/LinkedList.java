package ch02.Ex2_14;

public class LinkedList {
	//nextList�ւ̕ύX�͋������ׂ��ł͂Ȃ��B���������āAsetter method�͒ǉ������ׂ��ł͂Ȃ��B
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
	public void setobject(Object a_object){
		object = a_object;
	}
	public LinkedList getnextList(){
		return nextList;
	}
}