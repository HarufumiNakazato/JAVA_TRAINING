package ch14.Ex14_05;

public class Count {
	private static double num;
	
	public Count(){	}
	public static double add(double d){
		System.out.println(num += d);
		return num;
	}
	public double sub(double d){
		System.out.println(num -= d);
		return num;
	}
}
