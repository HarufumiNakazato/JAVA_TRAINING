package ch03.Ex3_02;

public class X {
	protected int xMask = 0x00ff;
	protected int fullMask;
	
	{
		System.out.println("X�̃t�B�[���h��������");
        this.showX();
        this.showY();
    }
    
    public X() {
    	System.out.println("X�̃R���X�g���N�^�Ăяo����");
        this.showX();
        fullMask = xMask;
        
        System.out.println("X�̃R���X�g���N�^���s��");
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
    
    void showY(){
    	//Y�N���X��override�����Ă���̂ŁA�K���q�N���X��showY()���Ă΂��
    }
}
