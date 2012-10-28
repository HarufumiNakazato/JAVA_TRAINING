package ch13.Ex13_01;

public class Counter {
	public int countChar(String s,char c){
		int counter = 0;
		for(int i = 0;i<s.length();i++){
			if(s.charAt(i) == c)
				counter++;
		}
		return counter;
	}
	
	public int countStr(String s,String cs){		
		return s.split(cs).length-1;
	}
	
	public static void main(String args[]){
		Counter counter = new Counter();
		System.out.println(counter.countStr("abcdefbsdcbcaebef", "bc"));
	}
}
