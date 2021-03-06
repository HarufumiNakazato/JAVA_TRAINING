package ch23.Ex23_03;

import java.io.*;
import java.util.*;

public class StreamConnector {
	Process proc;
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
				PrintStream osw = new PrintStream(out);
				osw.println(sb);
		}
	}
	public static void main(String[] args) {
		if(args.length <= 0)
			throw new IllegalArgumentException();
		
		
		Process proc = null;
		
		String stop = "This";
		
		//command line param to array
		String cmd = "";
		for(int i = 0; i < args.length;i++) {
			cmd += args[i];
			if(i != args.length - 1)
				cmd += " ";
		}
		try {
			proc = Runtime.getRuntime().exec(cmd);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StreamConnector sc = new StreamConnector(proc);
		sc.plugTogether(proc.getInputStream(),System.out, stop);
	}
	public StreamConnector(Process proc) {
		this.proc = proc;
	}
	public void plugTogether(InputStream in, OutputStream out, String stop) {
		if(in == null || out == null)
			throw new IllegalArgumentException();
		
		//read
		InputStreamReader sr = new InputStreamReader(in);
		LineNumberReader lr = new LineNumberReader(sr);
		StringBuilder sb = new StringBuilder();
		String thisLine;
		
		try {
			while((thisLine = lr.readLine()) != null) {
				sb.append(lr.getLineNumber() + ":");
				sb.append(thisLine);
				sb.append(System.getProperty("line.separator"));
			    if(sb.toString().contains(stop))
			    	proc.destroy();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//output
		WriteThread wt = new WriteThread(sb,out);
		wt.start();
	}
}
