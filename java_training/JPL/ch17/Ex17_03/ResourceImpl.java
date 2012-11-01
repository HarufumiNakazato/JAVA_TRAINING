package ch17.Ex17_03;

import java.lang.ref.*;

public class ResourceImpl implements Resource{
	boolean needsRelease = false;
	private WeakReference<Object> key;
	
	ResourceImpl(Object key){
		this.key = new WeakReference<Object>(key);
		//�O�����\�[�X�̐ݒ�
		needsRelease = true;
		
	}
	public void use(Object key, Object...args){
		//key���������ǂ������`�F�b�N���Ĉ������g�p�ł��Ȃ�
		if(!this.key.equals(key))
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
