package ch02.Ex2_01;

public class TestEx2_01 {
	public static void main(String[] args){
		
		Vehicle car = new Vehicle();
		double t_speed = 80;
		double t_direction = Math.PI/4;
		String t_owner = "Nakazato";
		
		car.speed = t_speed;
		car.direction = t_direction;
		car.owner = t_owner;
		
		System.out.println("speed: " + car.speed);
		System.out.println("direction: " + car.direction);
		System.out.println("owner: " + car.owner);
	}
}
