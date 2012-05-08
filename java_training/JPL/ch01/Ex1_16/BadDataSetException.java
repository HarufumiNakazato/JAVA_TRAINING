package ch01.Ex1_16;
import java.io.IOException;

public class BadDataSetException extends Exception {
	private static final long serialVersionUID = 1L;
	private String dataset;
	private IOException io;
	
	public BadDataSetException(IOException a_e, String a_dataset){
		io = a_e;
		dataset = a_dataset;
	}
	public String getDataset(){
		return dataset;
	}
	
	public IOException getIOException(){
		return io;
	}
}
