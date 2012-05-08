package ch03.Ex3_06;

public class Vehicle {
	public final int TURN_LEFT = 1;
	public final int TURN_RIGHT = -1;

	private double speed;
	private double direction;
	private String owner;
	
	private EnergySource energy;
	private  static long  nextID = 0;
	private final long selfID;
	
	public static void main(String[] args){
		
		EnergySource gs = new GasTank();
		EnergySource bt = new Battery();
		
		Vehicle vh_gs = new Vehicle(gs);
		Vehicle vh_bt = new Vehicle(gs);
		
		vh_gs.start();
		vh_bt.start();
		
		gs.setEnergy(0);
		bt.setEnergy(0);
		
		vh_gs.start();
		vh_bt.start();
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
	public Vehicle(EnergySource es){
		this();
		energy = es;
	}
	public void start(){
		if(energy.empty())
			System.out.println("not startable");
		else
			System.out.println("startable");
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
