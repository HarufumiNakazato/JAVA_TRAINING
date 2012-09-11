package ch20.Ex20_05;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;

public class WordSearcher {
	public static void main(String[] args)
		throws IOException	
	{
		if(args.length != 2)
			throw new IllegalArgumentException("need char and file");
		
		FileReader fileIn = new FileReader(args[1]);
		LineNumberReader in = new LineNumberReader(fileIn);
		
		String s;
		while((s = in.readLine()) != null){
			if(s.contains(args[0])){
				System.out.println(in.getLineNumber() + ":" + s);
			}else{
				System.out.println("  " + s);
			}
		}
	}
}
