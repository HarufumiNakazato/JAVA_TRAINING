package ch22.Ex22_3;

import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;

public class WhichChars {
	private BitSet used = new BitSet();
	private HashMap<Character, BitSet> charMap = new HashMap();
	public WhichChars(String str){
		for (int i = 0;i < str.length(); i++){
			used.set(str.charAt(i));
		}
	}
	public String toString(){
		String desc = "[";
		for(int i = used.nextSetBit(0);i >= 0; i = used.nextSetBit(i+1)){
			
			charMap.put((char)i, new BitSet(i));
			desc += (char)i;
		}
			return desc + "]";
	}
	
}
