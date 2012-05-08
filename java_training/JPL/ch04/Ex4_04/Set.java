package ch04.Ex4_04;

public interface Set<E> extends Collection<E>{
	boolean add(E e);
	void clear();
	int hashCode();
	boolean remove(Object o);
	int size();
	Object[] toArray();
}
