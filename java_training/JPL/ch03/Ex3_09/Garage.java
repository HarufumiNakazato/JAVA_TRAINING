package ch03.Ex3_09;

public class Garage implements Cloneable {
	private Vehicle[] vehicles;
	
	public Vehicle[] getVehicles(){
		return vehicles;
	}
	
	public void setVehicles(Vehicle[] value){
		vehicles = value;
	}
	
	public static void main(String[] args){
		Vehicle[] vhs = new Vehicle[]{new Vehicle("hoge"), new Vehicle("fuga"), new Vehicle("piyo")};
		Vehicle[] vhtest = new Vehicle[]{new Vehicle("foo"), new Vehicle("bar")};
		Garage gr = new Garage();
		gr.setVehicles(vhs);

		Garage gr_cl = gr.clone();
		
		gr.setVehicles(vhtest);
		
		gr.show();
		gr_cl.show();
	}
	
	public void show(){
		if(vehicles.length > 0){
		for(int i = 0; i < vehicles.length; i++)
			System.out.println(vehicles[i].toString());
		}else{
			System.out.println("No vehicle.");
		}
	}
	public Garage clone(){
		Garage newGarage;
		try {
			newGarage = (Garage)super.clone();
			newGarage.setVehicles(vehicles.clone());
			return newGarage;
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			throw new InternalError(e.toString());
		}

	}
}
