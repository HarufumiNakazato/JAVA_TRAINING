package ch20.Ex20_03;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class DecryptInputStream extends FilterReader{

	private ArrayList<Integer> decoded;
	private int key;
	
	public static void main(String[] args){
		int key = 10;
		byte[] encoded;
		byte[] decoded;
		StringReader enc = new StringReader(args[0]);
		EncryptOutputStream eos = new EncryptOutputStream(enc);
		eos.setKey(key);
		try {
			encoded = eos.encode();
			try {
				String ecnd = new String(encoded,"UTF-8");
				System.out.println("à√çÜâªÅF" + ecnd);
				
				DecryptInputStream dis = new DecryptInputStream(new StringReader(ecnd));
				dis.setKey(key);
				decoded = dis.decode();
				System.out.println("ïúçÜâªÅF" + new String(decoded,"UTF-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected DecryptInputStream(Reader in) {
		super(in);
		decoded = new ArrayList<Integer>();

		// TODO Auto-generated constructor stub
	}
	public void setKey(int key){
		this.key = key;
	}
	public byte[] decode() throws IOException{
		int c;
		try {
			while((c = read()) != (-1^key)){
				decoded.add(c);
			}
			byte[] result = new byte[decoded.size()];
			for(int i = 0;i<result.length;i++)
				result[i] = decoded.get(i).byteValue();
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
