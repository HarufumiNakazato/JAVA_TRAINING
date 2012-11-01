package ch24.Ex24_01;

import java.util.*;

public class ListGlobalRes_en extends ListResourceBundle{

	private static final Object[][] contents = {
		{GlobalRes.HELLO,"Hello"},
		{GlobalRes.GOODBYE,"Goodbye"},
	};
	@Override
	protected Object[][] getContents() {
		// TODO Auto-generated method stub
		return contents;
	}

}
