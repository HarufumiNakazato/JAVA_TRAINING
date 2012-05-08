package ch03.Ex3_05;

public class MethodBenchmark extends Benchmark{
	private int loopcnt;
	void benchmark(){
		for(int i = 0; i < loopcnt; i++);
	}
	
	public static void main(String[] args){
		int count;
		MethodBenchmark mb = new MethodBenchmark();
		try{
			count = Integer.parseInt(args[0]);
			mb.setLoopcnt(Integer.parseInt(args[1]));
			
		}catch(NumberFormatException e){
			count = 0;
			mb.setLoopcnt(0);
		}
		
		long time = mb.repeat(count);
		
		System.out.println(count + " mothods in " + time + " nanoseconds");
	}
	
	public void setLoopcnt(int value){
		loopcnt = value;
	}

}
