package ch16.Ex16_05;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassContents {
    public static void main(String[] args) {
        try {
            Class<?> c = Class.forName(args[0]);
            System.out.println(c);
            printMembers(c.getFields(),c);
            printMembers(c.getMethods(),c);
            printFields(c.getFields(),c);
            printMethods(c.getMethods(),c);
            printConstructors(c.getConstructors(),c);
        } catch (ClassNotFoundException e) {
            System.out.println("unknown class: " + args[0]);
        }
    }
    
    	private static void printMethods(Method[] ms, Class<?> c) {
		// TODO Auto-generated method stub
    	for (Method m : ms) {
        	if (m.getDeclaringClass() == Object.class)
        		continue;
        	if(m.getDeclaringClass() == m.getClass())
        		continue;
        	
        	String decl = m.toString();
        	System.out.print("    ");
        	System.out.println(strip(decl, "java.lang."));
        	showAnnotation(m.getDeclaredAnnotations());
    	}
	}

	private static void printMembers(Member[] mems, Class<?> c){
    	for (Member m : mems) {
        	if (m.getDeclaringClass() == Object.class)
        		continue;
        	if(m.getDeclaringClass() == c.getClass())
        		continue;
        	
        	String decl = m.toString();
        	System.out.print("    ");
        	System.out.println(strip(decl, "java.lang."));
    	}
    }
    private static void printFields(Field[] fs, Class<?> c){
    	for (Field f : fs) {
        	if (f.getDeclaringClass() == Object.class)
        		continue;
        	if(f.getDeclaringClass() == f.getClass())
        		continue;
        	
        	String decl = f.toString();
        	System.out.print("    ");
        	System.out.println(strip(decl, "java.lang."));
        	showAnnotation(f.getDeclaredAnnotations());
    	}
    }
    private static void printConstructors(Constructor[] cs,Class<?> c){
    	for (Constructor co : cs) {
        	if (co.getDeclaringClass() == Object.class)
        		continue;
        	if(co.getDeclaringClass() == co.getClass())
        		continue;
        	
        	String decl = co.toString();
        	System.out.print("    ");
        	System.out.println(strip(decl, "java.lang."));
        	showAnnotation(co.getDeclaredAnnotations());
    	}
    }
	 private static void showAnnotation(Annotation[] as){
    	if(as.length > 0){
    		System.out.print("[Annotation] ");
    		for(Annotation a:as)
    			System.out.println(a);
    	}
	 }
    // ... definition of strip ...
    private static String strip(String base,String remove){
    	return Pattern.compile(remove).matcher(base).replaceAll("");
    }
}