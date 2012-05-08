package ch04.Ex4_04;

public interface Collection<E> {
	boolean add(E e);
	void clear();
	boolean contains(Object o);
	boolean equals(Object o);
	int hashCode();
	int size();
	Object[] toArray();
}
