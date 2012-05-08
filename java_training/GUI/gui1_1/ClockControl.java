package gui1_1;

public class ClockControl {
	private ClockModel model;
	private ClockView view;
	private  ClockRun cr;
	//private Thread threadClock;
	
	public class ClockRun implements Runnable{
		private boolean _halt = false;
		public void halt(){
			_halt = true;
			}
		
		public void run(){
			view.setDispDate(model.getNowTime());
			view.createMainForm();
			
			while(!_halt){
				view.setDispDate(model.getNowTime());
				view.repaint();
			}
		}
	}
	public ClockControl(){
		model = new ClockModel();
		view = new ClockView();
	}
	
	public void startClock(){
		//threadClock = new Thread(cr);
		//threadClock.start();
		cr = new ClockRun();
		cr.run();
	}
	public void closeClock(){
		cr.halt();
		view.dispose();
	}
	public static void main(String[] args){
		ClockControl control = new ClockControl();
		control.startClock();
	}
}
