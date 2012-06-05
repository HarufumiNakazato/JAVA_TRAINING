package ch10.Ex10_03;

public class Work {
	public static void main(String[] args){
		Work w = new Work();
		System.out.println(w.isWeekdayIfElse(Day.SUN));
		System.out.println(w.isWeekdaySwitch(Day.THR));
	}
	
	public boolean isWeekdayIfElse(Day day){
		return !(day.equals(Day.SUN) || day.equals(Day.SUT));
	}
	
	public boolean isWeekdaySwitch(Day day){
		switch(day){
		case SUN: return false;
		case SUT: return false;
		default:  return true;
		}
	}
}
