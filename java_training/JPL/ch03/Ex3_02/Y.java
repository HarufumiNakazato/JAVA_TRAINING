package ch03.Ex3_02;

public class Y extends X{
	protected int yMask = 0xff00;
	
	{
		System.out.println("Y�̃t�B�[���h��������");
		this.showY();
	}
	
	public Y(){
		System.out.println("Y�̃R���X�g���N�^�Ăяo����");
		this.showY();

		fullMask |= yMask;

		System.out.println("Y�̃R���X�g���N�^���s��");
		showY();
	}
	
	public void showY(){
		super.showX();
		System.out.println(" yMask = 0x" + Integer.toHexString(yMask));
	}
	
	public static void main(String[] args){
		Y y = new Y();
		System.out.println("Y������");
		y.showY();
	}
}
