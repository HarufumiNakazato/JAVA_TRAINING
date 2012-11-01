package ch23.Ex23_01;

import java.io.*;
import java.util.*;

public class StreamConnector {
	class WriteThread extends Thread{
		private StringBuilder sb;
		private OutputStream out;
		WriteThread(StringBuilder sb,OutputStream out){
			this.sb = sb;
			this.out = out;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			((PrintStream) out).println(sb);
		}
	}
	public static void main(String[] args) {
		StreamConnector sc = new StreamConnector();
		Process proc = null;
		
		try {
			proc = Runtime.getRuntime().exec("ls -l");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.plugTogether(proc.getInputStream(),System.out);
	}
	public void plugTogether(InputStream in, OutputStream out) {
		if(in == null || out == null)
			throw new IllegalArgumentException();
		
		
		//read
		char[] buff = new char[1024];
		int b = 0;
		InputStreamReader sr = new InputStreamReader(in);
		int c = 0;
		StringBuilder sb = new StringBuilder();
		
		try {
			while(0 <= (b = sr.read(buff))) {
				sb.append(buff,0,b);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(sb);
		//output
		WriteThread wt = new WriteThread(sb,out);
		wt.start();
	}
}
