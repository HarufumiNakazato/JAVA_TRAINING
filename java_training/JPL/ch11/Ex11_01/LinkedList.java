package ch11.Ex11_01;

public class LinkedList<E> {
	private LinkedList<E> next;
	private E e;
	private int index;
	
	public LinkedList (){}
	public LinkedList(E e){
		this.e = e;
	}
	public void add(LinkedList<E> list){
		if(next == null){
			this.next = list;
			next.index = this.index + 1;
		}
		else
		{
			next.add(list);
		}
	}
	
	public void show(){
		System.out.println(e.toString());
		if(next!=null)
			next.show();
	}
	
	public int size(){
		if(next==null)
			return this.index + 1;
		else{
			return next.size();
		}
	}
	public E getElement(int index){
		if(this.index == index)
			return this.e;
		else
			return next.getElement(index);
	}
	public static void main(String[] args){
		LinkedList<String> list = new LinkedList<String>("a");
		list.add(new LinkedList<String>("b"));
		list.add(new LinkedList<String>("c"));
		
		list.show();
		System.out.println(list.size());
		System.out.println(list.getElement(1));
	}
	
}
