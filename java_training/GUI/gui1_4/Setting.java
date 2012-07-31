package gui1_4;

import java.awt.GraphicsEnvironment;
import java.util.prefs.Preferences;
import java.util.prefs.BackingStoreException;

public class Setting {
	public static int sWidth = 100;
	public static int sHeight = 124;
	public static String sFont = "Times New Roman";
	public static int sFontSize = 20;
	public static String sColor = "Black";
	public static String sBackColor = "White";
	public static final GraphicsEnvironment ENV = GraphicsEnvironment.getLocalGraphicsEnvironment();
	
	public static int dispX = ENV.getMaximumWindowBounds().width/2;
	public static int dispY = ENV.getMaximumWindowBounds().height/2;
	
	private Preferences prefs;
	
	private static final String KEY_sWidth = "sWidth";
	private static final String KEY_sHeight = "sHeight";
	private static final String KEY_sFont = "sFont";
	private static final String KEY_sFontSize = "sFontSize";
	private static final String KEY_sColor = "sColor";
	private static final String KEY_sBackColor = "sBackColor";
	private static final String KEY_dispX = "dispX";
	private static final String KEY_dispY = "dispY";
	
	public Setting(){
		prefs = Preferences.userNodeForPackage(this.getClass());
	}
	
	public void saveAll(){
		try{
			prefs.putInt(KEY_sWidth,sWidth);
			prefs.putInt(KEY_sHeight,sHeight);
			prefs.putInt(KEY_dispX,dispX);
			prefs.putInt(KEY_dispY,dispY);
			prefs.putInt(KEY_sFontSize,sFontSize);
			prefs.put(KEY_sFont, sFont);
			prefs.put(KEY_sColor,sColor);
			prefs.put(KEY_sBackColor,sBackColor);
			
			prefs.flush();
		}catch(BackingStoreException ex){
			ex.printStackTrace();
		}
	}
	public void clear(){
		try {
			prefs.clear();
		} catch (BackingStoreException e) {
			// TODO é©ìÆê∂ê¨Ç≥ÇÍÇΩ catch ÉuÉçÉbÉN
			e.printStackTrace();
		}
	}
	public void loadAll(){
		sFont = prefs.get(KEY_sFont, "Times New Roman");
		sColor = prefs.get(KEY_sColor,"Black");
		sBackColor = prefs.get(KEY_sBackColor, "White");
		sWidth = prefs.getInt(KEY_sWidth,100);
		sHeight = prefs.getInt(KEY_sHeight, 124);
		dispX = prefs.getInt(KEY_dispX, 0);
		dispY = prefs.getInt(KEY_dispY, 0);
		sFontSize = prefs.getInt(KEY_sFontSize, 20);
	}
	public static void show(){
		System.out.println("Width:" + sWidth);
		System.out.println("Height:" + sHeight);
		System.out.println("Font:" + sFont);
		System.out.println("FontSize:" + sFontSize);
		System.out.println("FontColor:" + sColor);
		System.out.println("BackColor:" + sBackColor);
		System.out.println("X:" + dispX);
		System.out.println("Y:" + dispY);
	}
	
}
