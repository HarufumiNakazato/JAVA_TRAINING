package ch20.Ex20_04;

import java.io.FilterReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;


public class LineReader extends FilterReader{

	public static void main(String[] args){
		StringReader sr = new StringReader("test\ntest");
		LineReader lr = new LineReader(sr);
		try {
			lr.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected LineReader(Reader in) {
		super(in);
		// TODO Auto-generated constructor stub
	}
	
	public void readLine() throws IOException{
		int c;
		StringBuilder sb = new StringBuilder();
		try {
			while((c = read()) != -1){
				sb.append(c);
				if(c =='\n'){
					System.out.println(sb);
					sb.setLength(0);
				}
			}
			System.out.println(sb);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	public int read() throws IOException{
		return super.read();
	}

}
