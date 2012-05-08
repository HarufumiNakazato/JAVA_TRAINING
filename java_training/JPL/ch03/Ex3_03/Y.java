package ch03.Ex3_03;

public class Y extends X{
	protected int yMask = 0xff00;
	
	{
		System.out.println("Yのフィールド初期化後");
		this.showY();
	}
	
	public Y(){
		System.out.println("Yのコンストラクタ呼び出し後");
		this.showY();

		//fullMask |= yMask;
		this.setFullMask();
		System.out.println("Yのコンストラクタ実行後");
		showY();
	}
	
	public void showY(){
		super.showX();
		System.out.println(" yMask = 0x" + Integer.toHexString(yMask));
	}
	
	public void setFullMask(){
		fullMask = yMask;
	}
	public static void main(String[] args){
		Y y = new Y();
		System.out.println("Y生成後");
		y.showY();
	}
}
