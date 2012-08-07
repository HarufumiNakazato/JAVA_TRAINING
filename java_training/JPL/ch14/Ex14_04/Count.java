package ch14.Ex14_04;

public class Count {
	private static double num;
	
	public Count(){	}
	public synchronized static double add(double n){
		System.out.println(num += n);
		return num;
	}
}
