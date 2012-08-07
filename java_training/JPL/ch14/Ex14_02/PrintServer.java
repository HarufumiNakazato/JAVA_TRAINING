package ch14.Ex14_02;

public class PrintServer implements Runnable{
	private final PrintQueue requests = new PrintQueue();

	public PrintServer(){
		Thread mainThread = new Thread(this,"mainThread");
		mainThread.start();
	}
	
	public void print(PrintJob job){
		requests.add(job);
	}
	
	public void run(){
		if(Thread.currentThread().getName().equals("mainThread")){
		for(;;)
			try {
				System.out.println("run()");
				realPrint(requests.remove());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			System.out.println("Illegal thread");
		}
	}
	private void realPrint(PrintJob job){
		// do something
	}
	public static void main(String[] args){
		PrintServer ps = new PrintServer();
		ps.run();
	}
}
