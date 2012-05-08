package ch01.Ex1_10;

public class ImprovedFibonacci {
static final int MAX_INDEX=46;
	
	public static void main (String[] args){
		int lo = 1;
		int hi = 1;
		
		ImprovedFibonacciData[] nums_data= new ImprovedFibonacciData[MAX_INDEX];
		
		nums_data[0] = new ImprovedFibonacciData(lo);
		
		for (int i = 2;i<=MAX_INDEX; i++){
			
			nums_data[i-1] = new ImprovedFibonacciData(hi);

			hi = lo + hi;
			lo = hi - lo;
			
		}
		
		for(int k = 0;k<nums_data.length;k++){
			System.out.println(nums_data[k].Num() +" "+ nums_data[k].IsEven());
		}
		
	}
}
