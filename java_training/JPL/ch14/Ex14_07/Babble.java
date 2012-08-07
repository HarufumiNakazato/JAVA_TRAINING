package ch14.Ex14_07;

public class Babble extends Thread {
	static boolean doYield;
	static int howOften;
	private String word;
	
	Babble(String whatToSay){
		word = whatToSay;
	}
	
	public void run(){
		for(int i = 0; i< howOften; i++){
			System.out.println(word);
			if(doYield)
				Thread.yield();
		}
	}
	
	public static void main(String[] args){
		String[] test1 = {"true","2","Did","DidNot"};
			doYield = new Boolean(test1[0]).booleanValue();
			howOften = Integer.parseInt(test1[1]);
			
			for(int i = 2;i < args.length; i++)
				new Babble(test1[i]).start();
	}
}
