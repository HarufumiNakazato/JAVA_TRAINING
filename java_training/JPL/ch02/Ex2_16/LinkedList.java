package ch02.Ex2_16;

public class LinkedList {
	//nextListへの変更は許されるべきではない。したがって、setter methodは追加されるべきではない。
	private Object object;
	private  LinkedList nextList;

	
	public LinkedList(Object a_object){
		object = a_object;
	}
	public LinkedList(Object a_object, LinkedList a_nextlist){
		object = a_object;
		nextList = a_nextlist;
	}
	
	public int size(){
		if(nextList == null){
			return 1;
		}else{
			return 1 + nextList.size();
		}
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