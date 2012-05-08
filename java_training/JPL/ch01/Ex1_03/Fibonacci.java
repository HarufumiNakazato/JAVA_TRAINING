package ch01.Ex1_03;
//—ûK–â‘è1.3

public class Fibonacci {
	static final int MAX = 1000000;
	
	
	public static void main(String[] args){
		int lo=1;
		int hi=1;
		System.out.println("Ex.1.3:Followings are the Fibonacci sequence.");
		
		System.out.println(lo);
		while(hi<MAX){
			System.out.println(hi);
			hi = lo + hi;
			lo = hi - lo;
			
		}
	}

}
