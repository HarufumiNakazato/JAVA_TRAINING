package ch10.Ex10_04;

public class Count {
	public int bitCount(Integer n){
		int cnt=0;
		System.out.println(Integer.SIZE);
		int j = 0;
		while(j<Integer.SIZE){
			cnt += (n & 1);
			n = n >>> 1;
			j++;
		}
		return cnt;		
	}
	
	public static void main(String[] args){
		Count c = new Count();
		System.out.println(c.bitCount(255));
	}
}
