package ch01.Ex1_16;

import java.io.FileInputStream;
import java.io.IOException;

public class TestEx1_16 {
	public static void main(String[] args)
	throws BadDataSetException
	{
		String setName = "test_file";
		String file = setName+" .dset";
		
		FileInputStream in = null;
		try{
			in = new FileInputStream(file);
		}catch(IOException e){
			throw new BadDataSetException(e,file);
		}finally{
			try{
				if (in != null)
					in.close();
			}catch(IOException e){
				
			}
		}
	}

}
