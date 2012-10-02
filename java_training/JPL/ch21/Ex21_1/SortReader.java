package ch21.Ex21_1;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;

public class SortReader {
	public static void main(String[] args)
		throws IOException	
		{
		ArrayList<String> list = new ArrayList<String>();
			if(args.length != 1)
				throw new IllegalArgumentException("need char and file");
			
			FileReader fileIn = new FileReader(args[0]);
			LineNumberReader in = new LineNumberReader(fileIn);
			
			String s;
			while((s = in.readLine()) != null){
				list.add(s);
				if(s.contains(args[0])){
					System.out.println(in.getLineNumber() + ":" + s);
				}else{
					System.out.println("  " + s);
				}
			}
			list = SortReader.sort(list);
		}
	private static ArrayList<String> sort(ArrayList<String> list){
		for(int j = 0; j < list.size(); j++) { 
			for(int i = j + 1; i < list.size(); i++) { 
			if(list.get(i).compareTo(list.get(j)) < 0) { 
			String t = list.get(j); 
			list.set(j, list.get(i)); 
			list.set(i, t);
					} 
				} 
			} 
		return list;
	}
}
