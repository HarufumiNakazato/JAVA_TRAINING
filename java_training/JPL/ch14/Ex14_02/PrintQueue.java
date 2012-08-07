package ch14.Ex14_02;

public class PrintQueue {
	private SingleLinkQueue<PrintJob> queue = new SingleLinkQueue<PrintJob>();
	
	public synchronized void add(PrintJob j){
		queue.add(j);
		notifyAll();
	}
	
	public synchronized PrintJob remove()
		throws InterruptedException
	{
		while(queue.size()==0)
			wait();
		return queue.remove();
	}
}
