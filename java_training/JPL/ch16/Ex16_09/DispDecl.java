package ch16.Ex16_09;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

public class DispDecl {
	public static void main(String[] args){
		args = new String[]{"java.util.HashMap"};
		try {
			Class<?> cls = Class.forName(args[0]);
			System.out.println(cls.getName());
			printConstructors(cls.getConstructors(),cls);
			printMethods(cls.getDeclaredMethods(),cls);
			printFields(cls.getDeclaredFields(),cls);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void printMethods(Method[] ms, Class<?> c) {
		// TODO Auto-generated method stub
    	for (Method m : ms) {
        	if (m.getDeclaringClass() == Object.class)
        		continue;
        	if(m.getDeclaringClass() == m.getClass())
        		continue;
        	
        	String decl = showDescr(m.toString(),c.getName());
        	System.out.print("    ");
        	System.out.println(strip(decl, "java.lang."));
        	showAnnotation(m.getDeclaredAnnotations());
    	}
	}
	
	private static String showDescr(String memberName,String classPath){
		String[] cpaths = classPath.split("\\.");
		String className = cpaths[cpaths.length-1];
		String rootPath = classPath.replace(className,"");
		String[] dec = memberName.split(" ");
		String result =  dec[dec.length-1].replace(rootPath, "");
		result = result.replace(className+".", "");

		return memberName.replace(dec[dec.length-1], result);
			
	}
	private static void printMembers(Member[] mems, Class<?> c){
    	for (Member m : mems) {
        	if (m.getDeclaringClass() == Object.class)
        		continue;
        	if(m.getDeclaringClass() == c.getClass())
        		continue;
        	
        	String decl = showDescr(m.toString(),c.getName());
        	System.out.print("    ");
        	System.out.println(strip(decl, "java.lang."));
    	}
    }
    private static void printFields(Field[] fs, Class<?> c){
    	for (Field f : fs) {
        	if (f.getDeclaringClass() == Object.class)
        		continue;
        	if(f.getDeclaringClass() == c.getClass())
        		continue;
        	
        	String decl = showDescr(f.toString(),c.getName());
        	System.out.print("    ");
        	System.out.println(strip(decl, "java.lang."));
        	showAnnotation(f.getDeclaredAnnotations());
    	}
    }
    private static void printConstructors(Constructor[] cs,Class<?> c){
    	for (Constructor co : cs) {
        	if (co.getDeclaringClass() == Object.class)
        		continue;
        	if(co.getDeclaringClass() == c.getClass())
        		continue;
        	
        	String decl = showDescr(co.toString(),c.getName());
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
