package ch01.Ex1_11;

public class StringDemo {

	public static void main(String[] args){
		String myName = "My name";
		String name = "Harufumi Nakazato";
		
		myName = myName + " is";
		myName += " ";
		myName += " " + name + ".";
		System.out.println("Self introduction: " + myName);
	}
}
