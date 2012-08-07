package ch16.Ex16_04;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class DispAnnotation {
	public static void main(String[] args){
		
		try {
			Class<?> cls = Class.forName(args[0]);
			DispAnnotation da = new DispAnnotation();
			da.dispAnnotation(cls);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void dispAnnotation(Class<?> cls){
		Annotation[] anotations = cls.getAnnotations();
		
		for(Annotation a:anotations)
			System.out.println(a.toString());
	}
}
