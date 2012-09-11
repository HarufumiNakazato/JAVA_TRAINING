package ch20.Ex20_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {
	public static void main(String[] args)
		throws IOException
	{	
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		String s;
		int[] abc = {0,0,0};
		
		while((s=bin.readLine()) != null){
			String[] strs = s.split(" ");
			if(strs.length == 1){
				System.out.println("a = " + abc[0] +", b = " + abc[1] + ", c = " + abc[2]);
				break;
			}
			if(!(strs[0].equals("a")||strs[0].equals("b")||strs[0].equals("c")))
				throw new IllegalArgumentException("Input a/b/c");
			if(strs.length != 3)
				throw new IllegalArgumentException("Input is invalid.");
			int val = Integer.parseInt(strs[2]);
			
			if(strs[1].equals("+")){
				abc[strs[0].charAt(0) - 'a'] += val;
			}else if(strs[1].equals("-")){
				abc[strs[0].charAt(0) - 'a'] -= val;
			}else{
				abc[strs[0].charAt(0) - 'a'] = val;
			}
		}
	}
	
}
