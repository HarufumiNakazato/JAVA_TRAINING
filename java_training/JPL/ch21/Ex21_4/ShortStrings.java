package ch21.Ex21_4;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class ShortStrings implements ListIterator<String>{
	private ListIterator<String> strings;
	private String nextShort;
	private String previousShort;
	private final int maxLen;
	
	public ShortStrings(ListIterator<String> strings,int maxLen){
		this.strings = strings;
		this.maxLen = maxLen;
		nextShort = null;
		previousShort = null;
	}
	
	public boolean hasNext(){
		if (nextShort != null)
			return true;
		while(strings.hasNext()){
			nextShort = strings.next();
			if(nextShort.length() <= maxLen)
				return true;
		}
		nextShort = null;
		return false;
		
	}
	
	public String next(){
		if (nextShort == null && !hasNext())
			throw new NoSuchElementException();
		String n = nextShort;
		nextShort = null;
		return n;
	}
	
	public void remove(){
		throw new UnsupportedOperationException();
	}

	@Override
	public void add(String string) {
		// TODO Auto-generated method stub
		strings.add(string);
	}

	@Override
	public boolean hasPrevious() {
		// TODO Auto-generated method stub
		if (previousShort != null)
			return true;
		while(strings.hasPrevious()){
			previousShort = strings.previous();
			if(previousShort.length() <= maxLen)
				return true;
		}
		previousShort = null;
		return false;
	}

	@Override
	public int nextIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String previous() {
		// TODO Auto-generated method stub
		if (previousShort == null && !hasPrevious())
			throw new NoSuchElementException();
		String n = previousShort;
		previousShort = null;
		return n;
	}

	@Override
	public int previousIndex() {
		// TODO Auto-generated method stub
		return strings.previousIndex();
	}

	@Override
	public void set(String string) {
		// TODO Auto-generated method stub
		strings.set(string);
	}
}
