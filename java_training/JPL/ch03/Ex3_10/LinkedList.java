package ch03.Ex3_10;

public class LinkedList implements Cloneable{
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
	
	public static void main(String[] args){ 
	LinkedList item1 = new LinkedList("hoge");
    LinkedList item2 = new LinkedList("fuga");
    LinkedList item3 = new LinkedList("piyo");
    
    System.out.println("変更前");
    item1.show();
    
    // 複製
    LinkedList newList = item1.clone();
    
    // リストの順番入れ替えてみる
    item1.nextList = item3;
    item3.nextList = item2;
    item2.nextList = null;
    
    
    // それぞれ出力
    System.out.println("変更後");
    item1.show();
    System.out.println("変更前のクローン");
    newList.show();
		
	}
	public void show(){
		System.out.println(this);
		if(nextList != null){
			nextList.show();
		}
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
	public LinkedList clone(){
		LinkedList ll_cl;
		try {
			ll_cl = (LinkedList)super.clone();
			if(nextList != null){
				ll_cl.nextList = (LinkedList)nextList.clone();
			}
			
			return ll_cl;
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			throw new InternalError(e.toString());
		}
		
	}

}