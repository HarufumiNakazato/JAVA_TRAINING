package ch02.Ex2_05;


public class Vehicle {
	public double speed;
	public double direction;
	public String owner;
	
	public static long  nextID = 0;
	public final long selfID;
	
	public Vehicle(){
		selfID = nextID++;
	}
	
	public static void main(String[] args){
		Vehicle car = new Vehicle();
		Vehicle taxi = new Vehicle();
		
		double car_speed = 80;
		double car_direction = 15;
		String car_owner = "Nakazato";
		car.speed = car_speed;
		car.direction = car_direction;
		car.owner = car_owner;
		
		double taxi_speed = 50;
		double taxi_direction = 180;
		String taxi_owner = "hoge";
		taxi.speed = taxi_speed;
		taxi.direction = taxi_direction;
		taxi.owner = taxi_owner;
		
		System.out.println("ID: " + car.selfID);
		System.out.println("speed: " + car.speed);
		System.out.println("direction: " + car.direction);
		System.out.println("owner: " + car.owner);
		
		System.out.println("ID: " + taxi.selfID);
		System.out.println("speed: " + taxi.speed);
		System.out.println("direction: " + taxi.direction);
		System.out.println("owner: " + taxi.owner);
		
	}

}
