package ch24.Ex24_02;

import java.util.*;

public class MoneyUnit {
	public static void main(String[] args) {
		MoneyUnit mu = new MoneyUnit();
		mu.dispUnitLocaleTalbe();
	}
	
	private Locale[] locales;
	private String[] symbols;
	
	public MoneyUnit() {
		Locale[] l = {
			Locale.CANADA,
			Locale.CHINA,
			Locale.ITALY,
			Locale.GERMANY,
			Locale.JAPAN,
			Locale.KOREA,
		};
		this.locales = l;
		symbols = new String[locales.length];
		for(int i = 0;i < locales.length; i++) {
			Currency c = Currency.getInstance(locales[i]);
			symbols[i]  = c.getSymbol(locales[i]);
		}
	}
	
	public void dispUnitLocaleTalbe() {
		System.out.println("Country | Symbol");
		for(int i = 0; i < locales.length; i++) {
			System.out.println(locales[i].getCountry() + " | " + symbols[i]);
		}
	}
}
