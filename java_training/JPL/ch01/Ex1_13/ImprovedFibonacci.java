package ch01.Ex1_13;
//—ûK–â‘è1.7

public class ImprovedFibonacci {
	static final int MAX_INDEX = 30;
	
	public static void main(String[] args){
		int lo = 1;
		int hi = 1;
		String mark;
		
		System.out.println("1: " + lo);
		for (int i=MAX_INDEX;i>=2;i--){
			
			if(hi%2==0)
				mark = " *";
			else
				mark = "";
			int temp = MAX_INDEX-i+2;
			
			System.out.printf(temp + ": " + hi + mark + "\n");
			hi = lo + hi;
			lo = hi - lo;
		}
	}
}
