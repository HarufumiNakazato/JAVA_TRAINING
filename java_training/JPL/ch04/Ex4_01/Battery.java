package ch04.Ex4_01;

public class Battery implements EnergySource{
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
