package ch14.Ex14_03;

public class Count {
	private double num;
	
	public Count(double num){
		this.num = num;
	}
	public void add(double n){
		System.out.println(num += n);
	}
}
