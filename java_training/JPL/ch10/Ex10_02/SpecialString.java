package ch10.Ex10_02;

public class SpecialString {
	public static void main(String[] args){
		SpecialString ss = new SpecialString();
		System.out.println(ss.replaceSpecialString("A\rB"));
	}
	
	public String replaceSpecialString(String str){
		String result = null;
		for(int i=0;i<str.length();i++){
			switch(Special.toSpecial(String.valueOf(str.charAt(i)))){
			case QUOTE:
				result = this.insert(i, str, "\\");
				i += "\\".length() + 1;
				break;
			case LINE:
				result = this.insert(i, str, "\\");
				i += "\\".length() + 1;
				break;
			case RETURN:
				result = this.insert(i, str, "\\");
				i += "\\".length() + 1;
				break;
			case TAB:
				result = this.insert(i, str, "\\");
				i += "\\".length() + 1;
				break;
			case NOT_SPECIAL:
				
				break;
			}
		}
		return result;
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
