package ch16.Ex16_03;

import java.lang.reflect.Member;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassContents {
    public static void main(String[] args) {
        try {
            Class<?> c = Class.forName(args[0]);
            System.out.println(c);
            printMembers(c.getFields(),c);
            printMembers(c.getConstructors(),c);
            printMembers(c.getMethods(),c);
        } catch (ClassNotFoundException e) {
            System.out.println("unknown class: " + args[0]);
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
    // ... definition of strip ...
    private static String strip(String base,String remove){
    	return Pattern.compile(remove).matcher(base).replaceAll("");
    }
}