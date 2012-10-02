package ch21.Ex21_6;

import java.io.*;
import java.util.*;

public class Concat {
	public static void main(String[] args)
		throws IOException
		{
			InputStream in;
			Enumeration<InputStream> files = null;
			if (args.length == 0){
				in = System.in;
			}else{
				InputStream fileIn, bufIn;
				List<InputStream> inputs = new ArrayList<InputStream>(args.length);
				for (String arg : args){
					fileIn = new FileInputStream(arg);
					bufIn = new BufferedInputStream(fileIn);
					inputs.add(bufIn);
				}
				files = Collections.enumeration(inputs);
				in = new SequenceInputStream(files);
			}
			int ch;				
			while((ch = in.read()) != -1)
				System.out.write(ch);
		
		}
}
