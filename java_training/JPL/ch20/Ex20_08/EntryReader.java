package ch20.Ex20_08;

import java.io.*;
import java.util.*;

public class EntryReader {
	public static void main(String[] args) {
		String path = "/Users/harunpen/git/JAVA_TRAINING/java_training/JPL/ch20/Ex20_08/test.txt";
		EntryReader r = new EntryReader(path);
		r.read();
		r.dispRandom();
	}
	
	private File file;
	private String[] entry;
	
	public EntryReader(String path) {
		file = new File(path);
	}
	public void read() {
		ArrayList<String> list = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String thisLine;
			while((thisLine = br.readLine())!= null) {
				list.add(thisLine);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//%%‚ðdelete
		for(int i = list.size() - 1; i > 0 ; i--) {
			StringBuilder sb = new StringBuilder(list.get(i));
			if(sb.indexOf("%%") == 0)
				list.remove(i);
		}
		entry = (String[]) list.toArray(new String[0]);
	}
	
	public void dispRandom() {
		List<String> list = new ArrayList<String>();
		for(int i = 0;i < entry.length ; i++)
			list.add(entry[i]);
		
		Collections.shuffle(list);
		System.out.println(list.get(0));
	}
}
