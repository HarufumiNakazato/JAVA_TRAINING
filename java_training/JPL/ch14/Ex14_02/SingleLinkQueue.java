package ch14.Ex14_02;

public class SingleLinkQueue<E> {
	protected Cell<E> head;
	protected Cell<E> tail;
	private int length;
	public void add(E item){
		
		Cell<E> cell = new Cell<E>(item);
		if(tail == null){
			head = tail = cell;
			length++;
		}else{
			tail.setNext(cell);
			tail = cell;
			length++;
		}
	}
	public E remove(){
		if(head == null)
			return null;
		Cell<E> cell = head;
		head = head.getNext();
		length--;
		if(head == null)
			tail = null;
		return cell.getElement();
	}
	public int size(){
		return length;
	}
}

class Cell<E>{
	private Cell<E> next;
	private E element;
	private static int size;
	public Cell(E element){
		this.element = element;
		size++;
	}
	public Cell(E element,Cell<E> next){
		this.element = element;
		this.next = next;
	}
	public E getElement(){
		return element;
	}
	public void setElement(E element){
		this.element = element;
	}
	public Cell<E> getNext(){
		return next;
	}
	public void setNext(Cell<E> next){
		this.next = next;
	}
}