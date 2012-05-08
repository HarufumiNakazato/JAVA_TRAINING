package ch04.Ex4_04;

public interface SortedSet<E> extends Set<E>{
	E first();
	E last();
	SortedSet<E> subSet(E fromElement,E toElement);
	SortedSet<E> tailSet(E fromElement);
}
