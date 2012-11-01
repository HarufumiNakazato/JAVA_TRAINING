package ch24.Ex24_01;

import java.util.*;

public class ListGlobalRes extends ListResourceBundle{

	public static final String HELLO = "hello";
	public static final String GOODBYE = "goodbye";
	
	private static final Object[][] contents = {
		{GlobalRes.HELLO, "Ciao"},
		{GlobalRes.GOODBYE,"Ciao"},
	};
	@Override
	protected Object[][] getContents() {
		return this.contents;
	}

}
