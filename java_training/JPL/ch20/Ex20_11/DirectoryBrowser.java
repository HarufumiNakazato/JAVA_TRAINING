package ch20.Ex20_11;

import java.io.File;
import java.io.FilenameFilter;

public class DirectoryBrowser implements FilenameFilter{
	
	private String suffix;
	private File dir;
	
	public DirectoryBrowser(File dir,String suffix){
		this.dir = dir;
		this.suffix = suffix;
		
	}

	@Override
	public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub
		return name.endsWith(this.suffix);
	}
	
	public static void main(String[] args){
		File f = new File(args[0]);
		DirectoryBrowser db = new DirectoryBrowser(f, args[1]);
		String[] files = f.list(db);
		System.out.println(files.length + " dir(s) :");
		for(String file:files)
			System.out.println("\t" + file);
	}
	
}
