package ch13.Ex13_03;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class DelimitedString {
	public String[] delimitedString(String str,char c1,char c2){
		//³‹K•\Œ»‚ÅSplit
		String regex = c1 + ".*?" + c2;
		Pattern p = Pattern.compile(regex);
		String[] stemp = p.split(str);

		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0;i<stemp.length;i++){
			str = str.replace(stemp[i], "/");
		}
		
		for(int j=0;j<str.split("/").length;j++)
			list.add(str.split("/")[j]);
		list.remove("");
		
		return (String[])list.toArray(new String[0]);
	}
	public static void main(String[] args){
		DelimitedString ds = new DelimitedString();
		String[] result = ds.delimitedString("abc<asdfa>abc<re>uig<>adfsdf", '<', '>');
		for(int i = 0;i<result.length;i++)
			System.out.println(result[i]);
	}
}
