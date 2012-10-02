package ch22.Ex22_1;

import java.util.Arrays;

public class DispFloat {
	public static void main(String[] args){
		
	}
	
	public void show(float[] fs,int d){
		float[] sortf = new float[d];
		for(int i = 0;i < d;i++)
			sortf[i] = fs[i];
		
		Arrays.sort(sortf);
		for(float f:sortf)
			System.out.printf("%1$.2g ", f);
	}
}
