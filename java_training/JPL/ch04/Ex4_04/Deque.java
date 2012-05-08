package ch04.Ex4_04;

public interface Deque<E> extends Queue<E>{
	boolean add(E e);
	E element();
	E getFirst();
	E getLast();
	E pop();
	void push(E e);
	E remove();
}
