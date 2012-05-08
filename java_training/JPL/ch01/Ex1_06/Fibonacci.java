package ch01.Ex1_06;
//—ûK–â‘è1.6

public class Fibonacci {
	static final int MAX = 1000000;
	static final String Title = "Followings are the Fibonacci sequence";
	
	public static void main(String[] args){
		int lo=1;
		int hi=1;
		System.out.println(Title);//—ûK–â‘è1.6
		System.out.println(lo);
		while(hi<MAX){
			System.out.println(hi);
			hi = lo + hi;
			lo = hi - lo;
		}
	}
}
