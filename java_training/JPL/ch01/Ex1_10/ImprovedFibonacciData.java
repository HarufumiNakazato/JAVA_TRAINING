package ch01.Ex1_10;

public class ImprovedFibonacciData {
	private int m_num;
	private boolean isEven;
	
	public ImprovedFibonacciData(int a_num){
		m_num = a_num;
		if(m_num%2==0)
			isEven = true;
		else
			isEven = false;
	}
	
	public boolean IsEven(){
		return isEven;
	}
	
	public int Num(){
		return m_num;
	}
	
}
