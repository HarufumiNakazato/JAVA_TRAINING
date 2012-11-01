package ch24.Ex24_03;

import java.text.*;
import java.util.*;

public class Calender {
	public static void main(String[] args) {
		
		/*
		 * yyyy -> 0だと1で表示され、負の値だと *(-1) + 1で表示される
		 * MM -> 12を超えると1に戻って表示される
		 * dd -> その月の晦日を超えると、次の月の1日になって表示される. 0は前月の晦日表示
		 */
		String string = "2012/10/29";//yyyy/MM/ddの形式で入力
		Locale locale = Locale.JAPAN;
		Format format = DateFormat.getDateTimeInstance(
				DateFormat.LONG, DateFormat.FULL, locale);
		try {
			Date date = DateFormat.getDateInstance(DateFormat.MEDIUM).parse(string);
		    System.out.println(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
