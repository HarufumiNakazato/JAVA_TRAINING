package ch09.Ex9_02;

public class Count {
	public int bitCount(Integer n){
		int cnt=0;
		System.out.println(Integer.SIZE);
		for(int j=0;j<Integer.SIZE;j++){
			cnt += (n & 1);
			n = n >>> 1;
		}
		return cnt;		
	}
	
	public static void main(String[] args){
		Count c = new Count();
		System.out.println(c.bitCount(255));
	}
}
