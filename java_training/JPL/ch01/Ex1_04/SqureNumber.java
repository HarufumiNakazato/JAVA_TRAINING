package ch01.Ex1_04;
//—ûK–â‘è1.4
public class SqureNumber {
	static final int MAX = 50;
	public static void main(String[] args){
		System.out.println("Followings are Square numbers.");
		int num = 0;
		while(num<=MAX){
			System.out.print(num + ":");
			System.out.println(num*num);
			num++;
		}
	}
}
