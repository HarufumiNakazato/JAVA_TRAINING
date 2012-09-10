package ch17.Ex17_01;

import java.util.ArrayList;

public class MemorySearch {
	public static void main(String[] args){
		Runtime rt = Runtime.getRuntime();
		System.out.println("Before : " + rt.freeMemory());
		int N = 3000000;
		ArrayList<Object> o = new ArrayList<Object>();
		for(int i = 0;i < N;i++){
			o.add(new Object());
		}
		
		System.out.println("After : " + rt.freeMemory());
	}
}
