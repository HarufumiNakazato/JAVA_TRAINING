package ch02.Ex2_15;

public class TestEx2_15 {
	public static void main(String[] args){
		Vehicle motorcycle = new Vehicle("suzuki");
		
		motorcycle.setspeed(80.1);
		motorcycle.setdirection(Math.PI/4);
		
		System.out.println("running...");
		System.out.println(motorcycle.toString());
		
		motorcycle.changeSpeed(52.7);
		System.out.println("braking...");
		System.out.println(motorcycle.toString());
		
		motorcycle.stop();
		System.out.println("stop");
		System.out.println(motorcycle.toString());
	}
}
