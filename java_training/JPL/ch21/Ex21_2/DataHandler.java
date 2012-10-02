package ch21.Ex21_2;

import java.io.File;
import java.lang.ref.*;
import java.util.WeakHashMap;

public class DataHandler {

	private File lastFile;
	private WeakHashMap<Object, byte[]> lastData;
		
	byte[] readFile(File file){
		byte [] data;
		
		if(file.equals(lastFile)){
			data = lastData.get(lastData.size());
			if(data != null)
				return data;
		}
		
		data = readBytesFromFile(file);
		lastFile = file;
		lastData = new WeakHashMap<Object,byte[]>();
		lastData.put(file, data);
		return data;
	}
	byte[] readBytesFromFile(File file){
		return null;
	}
}
