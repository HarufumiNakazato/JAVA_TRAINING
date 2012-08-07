package ch14.Ex14_04;

public class CountThread implements Runnable{

	private double addNum;
	private Count c;
	
	public CountThread(double num){
		Thread calcThread = new Thread(this);
		
		this.addNum = num;
		calcThread.start();
	}
	public void run() {
		for(int i = 0;i < 10;i++)
		    Count.add(addNum);
	}
	public static void main(String[] args){
		CountThread thread1 = new CountThread(1);
		CountThread thread2 = new CountThread(2);
		CountThread thread3 = new CountThread(3);
	}

}
