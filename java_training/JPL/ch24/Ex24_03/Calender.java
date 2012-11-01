package ch24.Ex24_03;

import java.text.*;
import java.util.*;

public class Calender {
	public static void main(String[] args) {
		
		/*
		 * yyyy -> 0����1�ŕ\������A���̒l���� *(-1) + 1�ŕ\�������
		 * MM -> 12�𒴂����1�ɖ߂��ĕ\�������
		 * dd -> ���̌��̊A���𒴂���ƁA���̌���1���ɂȂ��ĕ\�������. 0�͑O���̊A���\��
		 */
		String string = "2012/10/29";//yyyy/MM/dd�̌`���œ���
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
