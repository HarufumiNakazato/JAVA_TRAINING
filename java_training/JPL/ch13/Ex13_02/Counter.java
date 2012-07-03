package ch13.Ex13_02;

public class Counter {
	public int countChar(String s,char c){
		int counter = 0;
		for(int i = 0;i<s.length();i++){
			if(s.charAt(i) == c)
				counter++;
		}
		return counter;
	}
	
	public static void main(String args[]){
		Counter counter = new Counter();
		System.out.println(counter.countChar("nakazato", 'o'));
	}
}
