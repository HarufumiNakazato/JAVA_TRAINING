package ch13.Ex13_06;

public class Comma {
	public String insertComma(String s){
		
		StringBuilder sb = new StringBuilder();
		s = new StringBuilder(s).reverse().toString();
		int cnt = 0;
		for(int i = 0;i<s.length();i++){
			cnt++;
			sb.append(s.charAt(i));
			if(cnt%3 == 0 && i!=s.length()-1){
				sb.append(",");
			}
		}
		return sb.reverse().toString();
	}
	
	public String insertAny(String s,char c,int n){
		StringBuilder sb = new StringBuilder();
		s = new StringBuilder(s).reverse().toString();
		int cnt = 0;
		for(int i = 0;i<s.length();i++){
			cnt++;
			sb.append(s.charAt(i));
			if(cnt%n == 0 && i!=s.length()-1){
				sb.append(c);
			}
		}
		return sb.reverse().toString();
	}
	public static void main(String[] args){
		Comma c = new Comma();
		System.out.println(c.insertAny("1233456789",'\\',7));
	}
}
