package ch19.Ex19_01;
/**
 * <code>LinkedList</code> �͐擪���疖���ւ̈�����Ƀ����N���Ă��郊�X�g���`����B
 * �ۑ�2-16�ō쐬����LinkedList�N���X�Ƀh�L�������e�[�V�����R�����g��ǉ�����B
 * 
 * @author Harufumi Nakazato
 * @version 1.0
 */
public class LinkedList {
	//nextList�ւ̕ύX�͋������ׂ��ł͂Ȃ��B���������āAsetter method�͒ǉ������ׂ��ł͂Ȃ��B
	private Object object;
	private  LinkedList nextList;

	/**
	 * 
	 * @param object	�{�̃I�u�W�F�N�g
	 */
	public LinkedList(Object object){
		this.object = object;
	}
	/**
	 * 
	 * @param object �{�̃I�u�W�F�N�g
	 * @param nextlist�@���̃I�u�W�F�N�g
	 */
	public LinkedList(Object object, LinkedList nextlist){
		this.object = object;
		this.nextList = nextlist;
	}
	/**
	 * 
	 * @return �����N���Ă���I�u�W�F�N�g�̐�
	 */
	public int size(){
		if(nextList == null){
			return 1;
		}else{
			return 1 + nextList.size();
		}
	}
	/**
	 * @return �{�̃I�u�W�F�N�g�̒l�̕�����^
	 */
	public String toString(){
		return "object = " + object;
	}
	/**
	 * �{�̃I�u�W�F�N�g���擾����B
	 * @see #setObject(Object)
	 * @return �{�̃I�u�W�F�N�g
	 */
	public Object getObject(){
		return object;
	}
	/**
	 * @see #getObject()
	 * @param object �{�̃I�u�W�F�N�g�ɐݒ肷��ϐ�
	 */
	public void setObject(Object object){
		this.object = object;
	}
	public LinkedList getNextList(){
		return nextList;
	}
}