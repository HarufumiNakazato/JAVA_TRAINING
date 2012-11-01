package ch24.Ex24_01;

import java.util.*;

public class GlobalHello {
	public static void main(String[] args) {
		
		String bundle = "ch24.Ex24_01.GlobalRes_Fr";
		ResourceBundle res = 
				ResourceBundle.getBundle(bundle);
		
		String msg;
		if(args.length > 0)
			msg = res.getString(GlobalRes.GOODBYE);
		else
			msg = res.getString(GlobalRes.HELLO);
		
		System.out.println(msg);
		
		String key = GlobalRes.GOODBYE;
		ListGlobalRes lgr = new ListGlobalRes();
		ListGlobalRes_en lgr_en = new ListGlobalRes_en();
		Object[][] dic = lgr_en.getContents();
		for(int i = 0;i < dic.length;i++) {
			if(dic[i][0] == key) {
				System.out.println(dic[i][1]);
				return;
			}
		}
	}
}
