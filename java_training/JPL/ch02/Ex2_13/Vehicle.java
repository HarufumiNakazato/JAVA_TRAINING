package ch02.Ex2_13;

public class Vehicle {
	// selfID�͕ύX�������Ă͂����Ȃ��̂ŁAsetter��ǉ����ׂ��ł͂Ȃ��B
	private double speed;
	private double direction;
	private String owner;
	
	private  static long  nextID = 0;
	private final long selfID;
	
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
