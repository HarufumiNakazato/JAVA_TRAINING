package ch12.Ex12_01;

public class LinkedList<E>{
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
	public LinkedList<E> getLinkedList(int index){
		if(this.index == index)
			return this;
		else
			return next.getLinkedList(index);
	}
	public LinkedList<E> find(E e)
		throws ObjectNotFoundException
	{
			for(int i = 0;i<this.size();i++){
				if(this.getElement(i).equals(e))
					return this.getLinkedList(i);
			}
			
			throw new ObjectNotFoundException(e);
	}

	public static void main(String[] args)
			throws ObjectNotFoundException
	{
		LinkedList<String> list = new LinkedList<String>("a");
		list.add(new LinkedList<String>("b"));
		list.add(new LinkedList<String>("c"));
		
		try{
			LinkedList<String> p = list.find("d");
		}catch(ObjectNotFoundException e){
			System.out.println(e.toString());
		}
	}
	
}
