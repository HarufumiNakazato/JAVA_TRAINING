package ch21.Ex21_5;

import java.util.AbstractList;

public class ArrayBunchList<E> extends AbstractList<E>{

	private final E[][] arrays;
	private final int size;
	
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

}
