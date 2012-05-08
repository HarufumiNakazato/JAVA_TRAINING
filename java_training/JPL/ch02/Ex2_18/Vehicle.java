package ch02.Ex2_18;

public class Vehicle {
	public final int TURN_LEFT = 1;
	public final int TURN_RIGHT = -1;
	// selfID‚Í•ÏX‚ğ‹–‚µ‚Ä‚Í‚¢‚¯‚È‚¢‚Ì‚ÅAsetter‚ğ’Ç‰Á‚·‚×‚«‚Å‚Í‚È‚¢B
	private double speed;
	private double direction;
	private String owner;
	
	
	private  static long  nextID = 0;
	private final long selfID;
	
	public static void main(String[] args){
		for(int i = 0;i<args.length;i++){
		Vehicle car = new Vehicle(args[i]);
		System.out.println(car.toString());
		}
	}
	public void changeSpeed(double a_speed){
		speed = a_speed;
	}
	public void stop(){
		speed = 0;
	}
	public void turn(double a_direction){
		direction += a_direction;
	}
	public void turn(int A){
		if(A==this.TURN_LEFT||A==this.TURN_RIGHT){
			direction += A*Math.PI/4;
		}
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
