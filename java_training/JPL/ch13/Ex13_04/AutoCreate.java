package ch13.Ex13_04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

enum ClassType{
	Integer,
	Short,
	Long,
	Byte,
	Float,
	Double,
	Boolean,
	Character,
}
public class AutoCreate {
	private String currentDir;
	private ArrayList<Object> list;
	private ArrayList<String> slist;
	
	public void AutoCreate(){
		currentDir = new File(".").getAbsoluteFile().getParent();
	}
	public void read(){
		try {
			slist = new ArrayList<String>();
			FileReader is = new FileReader("/Users/harunpen/git/JAVA_TRAINING/java_training/JPL/ch13/Ex13_04/text.txt");
            BufferedReader br = new BufferedReader(is);
            String line;
            while ((line = br.readLine()) != null) {
            	slist.add(line);
            }
            br.close();
            is.close(); 
        } catch (IOException e) {
            System.out.println(e);
        }
	}
	public void add(){
		this.read();
		for(int i = 0;i<slist.size();i++){
			String[] tv = slist.get(i).split(" ");
			
		}
		
	}
	
	public static void main(String[] args){
		AutoCreate ac = new AutoCreate();
		ac.read();
	}
}
