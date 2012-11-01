package ch21.Ex21_3;

import java.lang.ref.*;
import java.util.*;

public class WeakValueMap<K,V> {
	
	private HashMap<K,Object> map;
	private WeakReference<V> weakValue;
	
	public WeakValueMap() {
		map = new HashMap<K,Object>();
	}
	public V put(K key, V value) {
		weakValue = new WeakReference<V>(value);
		map.put(key,weakValue);
		return value;
	}
	public Object get(K key) {
		Object o = map.get(key);
		map.remove(key);
		return o;
	}
}
