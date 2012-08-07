package ch14.Ex14_09;

public class DispThreadGroup {
	public void dispThreadStructure(final ThreadGroup group){
		class DispThread implements Runnable{
			public DispThread(){
				Thread t = new Thread(this);
				t.start();
			}
			@Override
			public void run() {
				System.out.println("Parent:" + group.getParent());
				Thread[] threads = new Thread[Thread.activeCount()];
				group.enumerate(threads);
				regDisp(this.getRootGroup(Thread.currentThread().getThreadGroup()));
			}
			private ThreadGroup getRootGroup(ThreadGroup group){
				if(group.getParent()==null)
					return group;
				else
					return getRootGroup(group.getParent());
			}
			private void regDisp(ThreadGroup group){
				//そのスレッドが属するスレッドグループにあるスレッドを表示する
				if(group.activeGroupCount()>=1){
					ThreadGroup[] subs = new ThreadGroup[group.activeGroupCount()];
					group.enumerate(subs);
					for(ThreadGroup s:subs){
						System.out.println("subGroup:" + s.getName());
						regDisp(s);
					}
				}else{
					Thread[] threads = new Thread[group.activeCount()];
					group.enumerate(threads);
					for(Thread t:threads)
					System.out.println(t.getName());
				}
			}
		}
		DispThread dt = new DispThread();
	}
	
	public static void main(String[] args){
		DispThreadGroup dtg = new DispThreadGroup();
		dtg.dispThreadStructure(Thread.currentThread().getThreadGroup());
	}
}
