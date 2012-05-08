package ch03.Ex3_01;

public class PassengerVehicle extends Vehicle{
	private int seatNum;
	private int personNum;
	
	public int getSeatNum(){
		return seatNum;
	}
	public void setSeatNum(int value){
		seatNum = value;
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
	
	public static void main(String[] args){
		PassengerVehicle pv1 = new PassengerVehicle();
		PassengerVehicle pv2 = new PassengerVehicle();
		PassengerVehicle pv3 = new PassengerVehicle();
		
		pv1.setSeatNum(5);
		pv2.setSeatNum(4);
		pv3.setSeatNum(3);
		
		pv1.setPersonNum(4);
		pv2.setPersonNum(3);
		pv3.setPersonNum(2);
		
		System.out.println(pv1.toString());
		System.out.println(pv2.toString());
		System.out.println(pv3.toString());	
	}
}
