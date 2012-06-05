package ch10.Ex10_03;

public enum Day {
	SUN("Sunday"),
	MON("Monday"),
	TUE("Tuesday"),
	WED("Wednesday"),
	THR("Thursday"),
	FRI("Friday"),
	SUT("Saturday");
	
	private final String name;
	
	Day(String name){
		this.name = name;
	}
	public String toString(){
		return name;
	}
}
