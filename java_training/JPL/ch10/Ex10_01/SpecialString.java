package ch10.Ex10_01;

public class SpecialString {
	public static void main(String[] args){
		SpecialString ss = new SpecialString();

		System.out.println(ss.replaceSpecialString("A\nB"));
	}
	
	public String replaceSpecialString(String str){
		String specials = "\"\n\t\b\r\f\\\'";

		for(int k = 0;k < str.length(); k++){
			if(specials.contains(String.valueOf(str.charAt(k)))){
				str = this.insert(k, str, "\\");
				break;
			}
		}
		return str;
	}
	public String insert(int k, String str, String is){
		if(k>=0 && k<str.length()){
			if(k==0)
				str = is + str;
			else{
				String temp = "";
				for(int i = 0; i < str.length() ; i++){
					if(i==k)
						temp += is;
					temp += String.valueOf(str.charAt(i));
				}
				str = temp;
			}
		}
		return str;
	}
}
