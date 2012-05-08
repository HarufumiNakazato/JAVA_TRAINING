package ch02.Ex2_03;

public class Vehicle {
	public double speed;
	public double direction;
	public String owner;
	
	public static long  nextID = 0;
	public final long selfID;
	
	public Vehicle(){
		selfID = nextID++;
	}

}
