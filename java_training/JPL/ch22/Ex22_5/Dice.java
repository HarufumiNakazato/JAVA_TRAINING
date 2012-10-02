package ch22.Ex22_5;

import java.util.HashMap;

public class Dice {
	public static void main(String[] args){
		
	}
	
	public HashMap<Integer, Double> makeDist(int n){
		HashMap<Integer,Double> dist = new HashMap<Integer,Double>();
		int[][] ns = new int[n][6];
		//”z—ñ‚É’l‚ðŠi”[
		for(int i = 0;i < ns.length;i++){
			for(int j = 0; j < ns[i].length;j++){
				ns[i][j] = j + 1;
			}
		}
		//Žæ‚è‚¤‚é˜a‚ð‹‚ß‚é
		
		return null;
		
	}
}
