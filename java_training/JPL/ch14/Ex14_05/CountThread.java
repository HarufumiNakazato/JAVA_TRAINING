package ch14.Ex14_05;

public class CountThread implements Runnable{

	private double addNum;
	private static double total = 0;
	private Count c;
	
	public CountThread(double num){
		Thread calcThread = new Thread(this);
		
		this.addNum = num;
		calcThread.start();
	}
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0;i < 10;i++){
		    total = Count.add(addNum);
		}
	}
	
	public void sub(double d){
		synchronized(c){
			c.sub(d);
		}
	}
	public static void main(String[] args){
		CountThread thread1 = new CountThread(1);
		CountThread thread2 = new CountThread(2);
		CountThread thread3 = new CountThread(3);
	}

}
