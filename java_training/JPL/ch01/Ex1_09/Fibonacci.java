package ch01.Ex1_09;

public class Fibonacci {
	static final int MAX = 1000000;
	static final String Title = "Followings are the Fibonacci sequence";
	
	public static void main(String[] args){
		int lo=1;
		int hi=1;
		//“®“I”z—ñ‚ğg‚Á‚Ä‘‚«‚½‚¢
		int[] num_ary = new int[100];
		num_ary[0]=lo;
		int i =1;
		while(hi<MAX){
			//list.add(new Integer(hi));
			num_ary[i] = hi;
			i++;
			hi = lo + hi;
			lo = hi - lo;
			}
		for(int k = 0;k<num_ary.length;k++){
			if(num_ary[k]>0){
				System.out.println(num_ary[k]);
			}
		}
	}
}
