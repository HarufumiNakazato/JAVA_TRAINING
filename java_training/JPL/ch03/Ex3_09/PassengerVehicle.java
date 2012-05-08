package ch03.Ex3_09;

public class PassengerVehicle extends Vehicle implements Cloneable{
	private int seatNum;
	private int personNum;
	
	public final int getSeatNum(){
		return seatNum;
	}
	public final void setSeatNum(int value){
		seatNum = value;
	}
	public static void main(String[] args){
		EnergySource gs = new GasTank();
		
		PassengerVehicle vh_gs = new PassengerVehicle(gs);
		vh_gs.setSeatNum(5);
		vh_gs.setPersonNum(3);

		PassengerVehicle vh_cl = vh_gs.clone();
		System.out.println(vh_gs.toString());
		System.out.println(vh_cl.toString());
	}
	public PassengerVehicle(EnergySource es){
		super(es);
	}
	public int getPersonNum(){
		return personNum;
	}
	public void setPersonNum(int value){
		personNum = value;
	}
	
	public String toString(){
		return super.toString() + "\n" + "seat = " + seatNum + "\n" + "person = " + personNum;
	}
	

	public PassengerVehicle clone(){
		return (PassengerVehicle)super.clone();
	}
}
