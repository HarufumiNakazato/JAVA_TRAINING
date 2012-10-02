package ch22.Ex22_2;

import java.util.BitSet;
import java.util.HashSet;

public class WhichChars {
	private BitSet used = new BitSet();
	private HashSet charSet = new HashSet();
	public WhichChars(String str){
		for (int i = 0;i < str.length(); i++){
			charSet.add(str.charAt(i));
			used.set(str.charAt(i));
		}
	}
	public String toString(){
		String desc = "[";
		for(int i = used.nextSetBit(0);i >= 0; i = used.nextSetBit(i+1)){
			desc += (char)i;
		}
			return desc + "]";
	}
	
}
