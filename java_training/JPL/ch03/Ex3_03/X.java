package ch03.Ex3_03;

public class X {
	protected int xMask = 0x00ff;
	protected int fullMask;
	
	{
		System.out.println("Xのフィールド初期化後");
        this.showX();
    }
    
    public X() {
    	System.out.println("Xのコンストラクタ呼び出し後");
        this.showX();
        //fullMask = xMask;
        setFullMask();
        System.out.println("Xのコンストラクタ実行後");
        this.showX();
    }
    
    public int mask(int orig) {
        return orig & fullMask;
    }
    
    void showX() {
        System.out.println(" " 
            + "xMask = 0x" + Integer.toHexString(this.xMask) + " "
            + "fullMask = 0x" + Integer.toHexString(this.fullMask));
    }
    void setFullMask(){
    	this.fullMask = xMask;
    }
}
