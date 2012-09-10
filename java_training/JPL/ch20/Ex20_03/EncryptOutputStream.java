package ch20.Ex20_03;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class EncryptOutputStream extends FilterReader{

	private ArrayList<Integer> encoded;
	private int key;
	protected EncryptOutputStream(Reader in) {
		super(in);
		encoded = new ArrayList<Integer>();
		// TODO Auto-generated constructor stub
	}
	public void setKey(int key){
		this.key = key;
	}
	public byte[] encode() throws IOException{
		int c;
		try {
			while((c = read()) != (-1^key)){
				encoded.add(c);
			}
			byte[] result = new byte[encoded.size()];
			for(int i = 0;i<result.length;i++)
				result[i] = encoded.get(i).byteValue();
			return result;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public int read() throws IOException{
		int c = super.read();
		
		return c^key;
	}

}
