package ch02.Ex2_09;

public class TestEx2_09{
	public static void main(String[] args){
		//1つも生成されていないときは-1を返す
		System.out.println(Vehicle.maxID());
		
		Vehicle vh1 = new Vehicle("hoge");
		System.out.println(vh1.getowner());
		System.out.println(Vehicle.maxID());
		
		Vehicle vh2 = new Vehicle("fuga");
		System.out.println(vh2.getowner());
		System.out.println(Vehicle.maxID());
	}
}
