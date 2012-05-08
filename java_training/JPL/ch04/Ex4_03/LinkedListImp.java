package ch04.Ex4_03;

public class LinkedListImp implements LinkedList, Cloneable{

		private Object object;
		private  LinkedListImp nextList;

		
		public LinkedListImp(Object a_object){
			object = a_object;
		}
		public LinkedListImp(Object a_object, LinkedListImp a_nextlist){
			object = a_object;
			nextList = a_nextlist;
		}
		
		public static void main(String[] args){ 
			LinkedListImp item1 = new LinkedListImp("hoge");
			LinkedListImp item2 = new LinkedListImp("fuga");
			LinkedListImp item3 = new LinkedListImp("piyo");
	    
	    System.out.println("変更前");
	    item1.show();
	    
	    // 複製
	    LinkedListImp newList = item1.clone();
	    
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
		public LinkedListImp getnextList(){
			return nextList;
		}
		public LinkedListImp clone(){
			LinkedListImp ll_cl;
			try {
				ll_cl = (LinkedListImp)super.clone();
				if(nextList != null){
					ll_cl.nextList = (LinkedListImp)nextList.clone();
				}
				
				return ll_cl;
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				throw new InternalError(e.toString());
			}
			
		}
		@Override
		public Object getObject() {
			// TODO Auto-generated method stub
			return object;
		}
		@Override
		public void setObject(Object obj) {
			// TODO Auto-generated method stub
			object = obj;
		}
		@Override
		public LinkedList getNextList() {
			// TODO Auto-generated method stub
			return nextList;
		}

}
