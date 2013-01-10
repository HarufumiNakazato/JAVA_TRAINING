package ch22.Ex22_14;

import java.io.*;
import java.util.*;

public class AddDecimal {
	public static void main(String[] args) {
		String str = "";
		try{
            FileReader f = new FileReader(args[0]);
            BufferedReader b = new BufferedReader(f);
            String s;
            while((s = b.readLine())!=null){
            	str += s;
            }
        }catch(Exception e){
            System.out.println("ÉtÉ@ÉCÉãì«Ç›çûÇ›é∏îs");
        }
		System.out.println(str);
		StringTokenizer tokens = new StringTokenizer(str," ");
		float f = 0;
		while(tokens.hasMoreTokens())
			f += Float.valueOf(tokens.nextToken());
				
		System.out.println(f);
	}
}
