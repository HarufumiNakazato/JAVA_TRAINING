package ch02.Ex2_13;

public class TestEx2_13 {
	public static void main(String[] args){
		Vehicle car = new Vehicle("hoge");
		car.setspeed(53.1);
		car.setdirection(Math.PI/3);
		
		System.out.println(car.toString());
		
	}
}
