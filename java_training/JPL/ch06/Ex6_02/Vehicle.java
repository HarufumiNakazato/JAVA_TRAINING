package ch06.Ex6_02;

public class Vehicle {

	private double speed;
	private double direction;
	private String owner;
	
	
	private  static long  nextID = 0;
	private final long selfID;
	
	public void changeSpeed(double a_speed){
		speed = a_speed;
	}
	public void stop(){
		speed = 0;
	}
	public void turn(double a_direction){
		direction += a_direction;
	}
	public void turn(TurnDirection A){
		switch (A){
			case LEFT:
				direction += Math.PI/4;
				break;
			case RIGHT:
				direction += -1 * Math.PI/4;
				break;
		}
	}
	public static void main(String[] args){
		Vehicle car = new Vehicle("hogehoge");
		car.setspeed(60);
		car.setdirection(Math.PI/4);
		
		System.out.println("直進中");
		System.out.println(car.toString());
		
		car.turn(Math.PI/8);
		System.out.println("カーブ");
		System.out.println(car.toString());
		
		car.turn(TurnDirection.LEFT);
		System.out.println("左折");
		System.out.println(car.toString());
		
		car.turn(TurnDirection.RIGHT);
		System.out.println("右折");
		System.out.println(car.toString());
	}
	public String toString(){
		return selfID + " (" + owner + ")" + "\n" + "speed = " + speed + "\n" + "direction = " + direction;
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
	public long getID(){
		return selfID;
	}
}
