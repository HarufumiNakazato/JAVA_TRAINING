package ch02.Ex2_09;

public class Vehicle {
	private double speed;
	private double direction;
	private String owner;
	
	public static long  nextID = 0;
	public final long selfID;
	
	public static long maxID(){
		return nextID-1;
	}
	public Vehicle(){
		selfID = nextID++;
	}
	public Vehicle(String a_owner){
		this();
		owner = a_owner;
	}
	
	public double getspeed(){
		return speed;
	}
	public double getdirection(){
		return direction;
	}
	public String getowner(){
		return owner;
	}
	public void setspeed(double a_speed){
		speed = a_speed;
	}
	public void setdirection(double a_direction){
		direction = a_direction;
	}
	public void setowner(String a_owner){
		owner = a_owner;
	}
	
}
