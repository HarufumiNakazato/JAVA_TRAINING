package ch02.Ex2_17;

public class TestEx2_17 {
	public static void main(String[] args){
		Vehicle car = new Vehicle("nakazato");
		car.setspeed(60);
		car.setdirection(Math.PI/4);
		
		System.out.println("���i��");
		System.out.println(car.toString());
		
		car.turn(Math.PI/8);
		System.out.println("�J�[�u");
		System.out.println(car.toString());
		
		car.turn(car.TURN_LEFT);
		System.out.println("����");
		System.out.println(car.toString());
		
		car.turn(car.TURN_RIGHT);
		System.out.println("�E��");
		System.out.println(car.toString());
	}
}
