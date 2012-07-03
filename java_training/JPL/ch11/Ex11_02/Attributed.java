package ch11.Ex11_02;

public interface Attributed {
	<E> void add(Attr<E> newAttr);
	<E> Attr<E> find(String attrName);
	<E> Attr<E> remove(String attrName);
	<E> java.util.Iterator<Attr<E>> attrs();
}
