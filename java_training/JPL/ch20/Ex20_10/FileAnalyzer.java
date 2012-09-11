package ch20.Ex20_10;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Map;

public class FileAnalyzer {
	public static void main(String[] args)
		throws IOException
	{
		StreamTokenizer in = new StreamTokenizer(new FileReader(new File(args[0])));
		HashMap<String,Integer> map = new HashMap<String, Integer>();
		while(in.nextToken() != StreamTokenizer.TT_EOF){
			if(in.ttype == StreamTokenizer.TT_WORD){
				Integer c = map.get(in.sval);
				if(c == null)
					map.put(in.sval, 1);
				else{
					map.remove(in.sval);
					map.put(in.sval, ++c);
				}
			}
		}
		//HashMapˆê——•\Ž¦
		for(Map.Entry<String, Integer> e : map.entrySet()) {
			System.out.println("key=" + e.getKey() + ", value=" + e.getValue());
		}
	}
}
