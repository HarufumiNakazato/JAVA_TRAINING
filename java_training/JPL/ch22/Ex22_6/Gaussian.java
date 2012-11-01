package ch22.Ex22_6;

import java.util.*;

public class Gaussian {
	public static void main(String[] args) {
		double[] data = new double[1024];
		Random r = new Random();
		for(int i = 0; i < data.length; i++)
			data[i] = r.nextGaussian();
		
		Gaussian g = new Gaussian();
		g.dispChart(data);
	}
	
	private int[] chart;
	public void dispChart(double[] data) {
		chart = new int[11];
		for(double d : data) {
			if(d<-1)
				chart[0]++;
			else if(d >=  -1 && d < -0.8)
				chart[1]++;
			else if(d >= -0.8 && d < -0.6)
				chart[2]++;
			else if(d >= -0.6 && d < -0.4)
				chart[3]++;
			else if(d >= -0.4 && d < -0.2)
				chart[4]++;
			else if(d >= -0.2 && d < 0)
				chart[5]++;
			else if(d >= 0 && d < 0.2)
				chart[6]++;
			else if(d >= 0.2 && d < 0.4)
				chart[7]++;
			else if(d >= 0.4 && d < 0.6)
				chart[8]++;
			else if(d >= 0.6 && d < 0.8)
				chart[9]++;
			else
				chart[10]++;
		}
		for(int i:chart) {
			//System.out.println(i);
			for(int k = 0; k < i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
