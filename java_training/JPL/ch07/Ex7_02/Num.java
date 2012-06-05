package ch07.Ex7_02;

public class Num {
	public static void main(String[] args){
		int tmpi=0;
		long tmpl=0;
		byte maxByte = Byte.MAX_VALUE;
		byte miniByte = Byte.MIN_VALUE;
		short maxShort = Short.MAX_VALUE;
		short miniShort = Short.MIN_VALUE;
		int maxInt = Integer.MAX_VALUE;
		int miniInt = Integer.MIN_VALUE;
		long maxLong = Long.MAX_VALUE;
		long miniLong = Long.MIN_VALUE;
		float maxFloat = Float.MAX_VALUE;
		float miniFloat = Float.MIN_VALUE;
		double maxDouble = Double.MAX_VALUE;
		double miniDouble = Double.MIN_VALUE;

		System.out.println(tmpi);
		System.out.println(tmpl);
		System.out.println(maxByte);
		System.out.println(miniByte);
		System.out.println(maxShort);
		System.out.println(miniShort);
		System.out.println(maxInt);
		System.out.println(miniInt);
		System.out.println(maxLong);
		System.out.println(miniLong);
		System.out.println(maxFloat);
		System.out.println(miniFloat);
		System.out.println(maxDouble);
		System.out.println(miniDouble);
		System.out.println(tmpi=(int)maxLong);//-1
		System.out.println(tmpi=(int)miniByte);
		System.out.println(tmpi=(int)miniShort);
		System.out.println(tmpi=(int)miniLong);//0
		System.out.println(tmpi=(int)miniFloat);//0
		System.out.println(tmpl=(int)miniDouble);//0
		System.out.println(tmpl=miniByte);
		System.out.println(tmpl=miniShort);
		System.out.println(tmpl=miniLong);
		
		System.out.println(tmpl=(long)miniFloat);//0
		System.out.println(tmpl=(long)miniDouble);//0
	}
}
