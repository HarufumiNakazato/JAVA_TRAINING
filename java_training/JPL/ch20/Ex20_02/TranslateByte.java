package ch20.Ex20_02;

import java.io.FilterReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;

public class TranslateByte extends FilterReader{

	private byte from;
	private byte to;
	
	public static void main(String[] args){
		StringReader in = new StringReader(args[0]);

		TranslateByte tb = new TranslateByte(in);
		tb.setMapWord((byte)args[1].charAt(0), (byte)args[2].charAt(0));
		int c;
		try {
			while((c = tb.read()) != -1){
				System.out.print((char)c);	
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println();
		
	}
	protected TranslateByte(Reader in) {
		super(in);
		// TODO Auto-generated constructor stub
	}
	public void setMapWord(byte from, byte to){
		this.from = from;
		this.to = to;
	}
	public int read() throws IOException{
		int c = super.read();
		return (c == from? to : c);
	}
	public int read(char[] buf, int offset, int count)
		throws IOException
	{
		int nread = super.read(buf,offset,count);
		int last = offset + nread;
		for(int i = offset;i<last;i++)
			buf[i] = Character.toUpperCase(buf[i]);
		return nread;
	}
}
