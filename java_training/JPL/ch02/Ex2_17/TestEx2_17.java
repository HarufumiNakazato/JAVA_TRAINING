package ch02.Ex2_17;

public class TestEx2_17 {
	public static void main(String[] args){
		Vehicle car = new Vehicle("nakazato");
		car.setspeed(60);
		car.setdirection(Math.PI/4);
		
		System.out.println("直進中");
		System.out.println(car.toString());
		
		car.turn(Math.PI/8);
		System.out.println("カーブ");
		System.out.println(car.toString());
		
		car.turn(car.TURN_LEFT);
		System.out.println("左折");
		System.out.println(car.toString());
		
		car.turn(car.TURN_RIGHT);
		System.out.println("右折");
		System.out.println(car.toString());
	}
}
