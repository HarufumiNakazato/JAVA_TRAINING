package ch10.Ex10_05;

public class DispString {
	public static void main(String[] args) {
		DispString ds = new DispString();
		char s1 = 'c';
		char s2 = 'a';
		ds.dispBetween(s1, s2);
	}
	public void dispBetween(char s1, char s2) {
		if(s1 == s2)
			System.out.println("There is no string between s1 and s2.");
		
		if(s2 < s1) {
			char c;
			c = s2;
			s2 = s1;
			s1 = c;
		}
		
		while(s1 != s2-1) {
			System.out.println(++s1);
		}
	}
}
