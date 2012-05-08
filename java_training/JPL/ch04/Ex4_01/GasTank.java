package ch04.Ex4_01;

public class GasTank implements EnergySource{
	private double fuel = 89.3;

	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		return fuel <= 0;
	}
	
	public void setEnergy(double value){
		fuel = value;
	}
	
}
