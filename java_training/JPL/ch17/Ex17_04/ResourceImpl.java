package ch17.Ex17_04;

public class ResourceImpl implements Resource{
	int keyHash;
	boolean needsRelease = false;
	
	ResourceImpl(Object key){
		keyHash = System.identityHashCode(key);
		
		//�O�����\�[�X�̐ݒ�
		needsRelease = true;
		
	}
	public void use(Object key, Object...args){
		if (System.identityHashCode(key) != keyHash)
			throw new IllegalArgumentException("wrong key");
		
		//���\�[�X�̎g�p
	}
	
	public synchronized void release(){
		if(needsRelease){
			needsRelease = false;
			//���\�[�X�̉��
		}
	}
}
