package ch03.Ex3_06;

public class Battery extends EnergySource{
	public double power = 90.2;

	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		return power <= 0;
	}
	
	public void setEnergy(double value){
		power = value;
	}
	
}
