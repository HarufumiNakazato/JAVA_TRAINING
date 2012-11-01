package ch21.Ex21_5;

import java.util.*;

public class ArrayBunchList<E> extends AbstractList<E>{

	private final E[][] arrays;
	private final int size;
	
	private boolean canSet = false;
	
	public ArrayBunchList(E[][] arrays){
		this.arrays = arrays.clone();
		int s = 0;
		for (E[] array : arrays)
			s += array.length;
		size = s;
	}
	@Override
	public E get(int index) {
		int off = 0;
		for (int i = 0;i < arrays.length;i++){
			if (index < off + arrays[i].length)
				return arrays[i][index - off];
			off += arrays[i].length;
		}
		throw new ArrayIndexOutOfBoundsException(index);
	}
	
	public E set(int index,E value){
		if(value == null)
			throw new IllegalArgumentException();
		
		if(canSet)
			return null;
		
		int off = 0;
		for (int i = 0; i < arrays.length; i++){
			if (index < off + arrays[i].length){
				E ret = arrays[i][index - off];
				arrays[i][index - off] = value;
				return ret;
			}
			off += arrays[i].length;
		}
		throw new ArrayIndexOutOfBoundsException(index);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
	private class ABLIterator implements Iterator<E>{

		private int off;
		private int array;
		private int pos;
		
		ABLIterator(){
			off = 0;
			array = 0;
			pos = 0;
			for (array = 0; array < arrays.length; array++)
				if (arrays[array].length > 0)
					break;
		}
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public E next() {
			canSet = true;
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}

}
