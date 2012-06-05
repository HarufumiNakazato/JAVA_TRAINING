package ch10.Ex10_02;

public enum Special {
	QUOTE("\""),
	LINE("\n"),
	TAB("\t"),
	BREAK("\b"),
	RETURN("\r"),
	FEED("\f"),
	BACKSLASH("\\"),
	NOT_SPECIAL("");
	
	private final String name;
	
	private Special(String name){
		this.name = name;
	}
	
	public String toString(){
		return name;
	}
	
	public static Special toSpecial(String name){
		
		Special result = null;
		for(Special sp:values()){
			if(sp.toString().equals(name)){
				result = sp;
				break;
			}
		}
		
		return result != null ? result:NOT_SPECIAL;
	}
	
}
