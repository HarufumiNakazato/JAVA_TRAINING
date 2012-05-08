package ch03.Ex3_09;

public class GasTank extends EnergySource{
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
