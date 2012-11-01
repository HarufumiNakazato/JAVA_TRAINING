package ch22.Ex22_2;

import java.util.HashSet;

public class WhichChars {
	
	private HashSet<Character> charSet = new HashSet<Character>();
	public WhichChars(String str){
		for (int i = 0;i < str.length(); i++){
			charSet.add(str.charAt(i));
		}
	}
	public String toString(){
		String desc = "[";
		for(Character c:charSet)
			desc += c;
		
		return desc + "]";
	}
	
}
