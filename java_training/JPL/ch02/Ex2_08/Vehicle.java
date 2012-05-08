package ch02.Ex2_08;


public class Vehicle {
	public double speed;
	public double direction;
	public String owner;
	
	public static long  nextID = 0;
	public final long selfID;
	
	public Vehicle(){
		selfID = nextID++;
	}
	public Vehicle(String a_owner){
		this();
		owner = a_owner;
	}
	
	public static void main(String[] args){
		Vehicle car = new Vehicle("Nakazato");
		Vehicle taxi = new Vehicle("hoge");
		
		double car_speed = 80;
		double car_direction = 15;
		
		car.speed = car_speed;
		car.direction = car_direction;
		
		
		double taxi_speed = 50;
		double taxi_direction = 180;
		
		taxi.speed = taxi_speed;
		taxi.direction = taxi_direction;
		
		
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
