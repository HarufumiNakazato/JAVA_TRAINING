package ch20.Ex20_09;

import java.io.File;
import java.io.IOException;

public class FileInformation {
	public static void main(String[] args)
		throws IOException
	{
		FileInformation fi = new FileInformation(args);
		fi.showInformation();
	}
	
	private File[] files;
	public FileInformation(String...paths){
		files = new File[paths.length];
		for(int i = 0;i < paths.length; i++)
			files[i] = new File(paths[i]);
	}
	
	public void showInformation()
		throws IOException
	{
		for(File file:files){
			System.out.println("Name : " + file.getName());
			System.out.println("Path : " + file.getPath());
			System.out.println("AbsolutePath : " + file.getAbsolutePath());
			System.out.println("CanonicalPath : " + file.getCanonicalPath());
			System.out.println("Parent : " + file.getParent());
			System.out.println("");
		}
	}
}
