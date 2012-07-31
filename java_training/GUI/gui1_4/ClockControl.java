package gui1_4;


public class ClockControl {
	private ClockModel model;
	private ClockView view;
	private  ClockRun cr;
	private Thread threadClock;
	
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
				//System.out.println("repaint");
				view.repaint();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}	
			}
		}
	}
	
	public ClockControl(){
		
		Setting setting = new Setting();
		//setting.clear();
		setting.loadAll();
		System.out.println("-------After loadAll()-------");
		Setting.show();
		model = new ClockModel();
		view = new ClockView();
	}
	public void startClock(){
		cr = new ClockRun();
		threadClock = new Thread(cr);
		threadClock.start();
	}
	public void closeClock(){
		cr.halt();
		view.dispose();
	}
	public static void main(String[] args){
		System.out.println("----------------");
		Setting.show();
		ClockControl control = new ClockControl();
		control.startClock();
	}
}
