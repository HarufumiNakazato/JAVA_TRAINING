package ch14.Ex14_06;

import java.util.Date;

public class Display {
	private MessageThread messageThread;
	//private TimeThread timeThread;
	private long currentTime; 
	class MessageThread implements Runnable{
		private int interval;
		private String message;
		private int time;
		public MessageThread(int interval,String message){
			this.interval = interval;
			this.message = message;
			Thread t = new Thread(this);
			t.start();
			dispMessage();

		}

		@Override
		public void run() {
			dispTime();
		}
		synchronized void dispTime(){
			while(true){
				System.out.println((new Date().getTime() - currentTime)/1000 + " s...");
				try {
					Thread.sleep(1000);
					notifyAll();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		synchronized void dispMessage(){
			while(true){
				//System.out.println(message);
				try {
					time++;
					wait();
					System.out.println("notified");
					if(time%interval*1000 == 0)
						System.out.print(message);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public Display(){
		currentTime = new Date().getTime();
		messageThread = new MessageThread(15,"hogehoge");
	}

	public static void main(String[] args){
		Display d = new Display();
	}
}
