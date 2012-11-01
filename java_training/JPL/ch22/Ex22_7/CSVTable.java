package ch22.Ex22_7;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class CSVTable {
	
	private int cells;
	public CSVTable(int cells) {
		this.cells = cells;
	}
	public  ArrayList<String[]>readCSVTable(Readable source) throws IOException{
		
		Scanner in = new Scanner(source);
		ArrayList<String[]> vals = new ArrayList<String[]>();
		String exp = "^(.*),(.*),(.*),(.*)";
		Pattern pat = Pattern.compile(exp, Pattern.MULTILINE);
		
		while(in.hasNextLine()) {
			String line = in.findInLine(pat);
			if(line != null) {
				String[] cells = new String[this.cells];
				MatchResult match = in.match();
				for(int i = 0;i < this.cells;i++) {
					cells[i] = match.group(i+1);
					vals.add(cells);
					in.nextLine();
				}
			}
			else {
				throw new IOException("input format error");
			}
		}
		
		IOException ex = in.ioException();
		if(ex != null)
			throw ex;
		
		return vals;
	}
}
