package ch05.Ex5_01;

public interface Attributed {
	//Attributed�Œ�`���ꂽ���\�b�h��Attr�I�u�W�F�N�g�ɑ΂��鑀����܂ނ̂ŁAAttr���l�X�g����ׂ��B
	public class Attr{
		private final String name;
		private Object value = null;
		

		public Attr(String name){
			this.name = name;
		}
		
		public Attr(String name, Object value){
			this.name = name;
			this.value = value;
		}
		
		public String getName(){
			return name;
		}
		
		public Object getValue(){
			return value;
		}
		
		public Object setValue(Object newValue){
			Object oldVal = value;
			value = newValue;
			return oldVal;
		}
		
		public String toString(){
			return name + "='" + value + "'";
		}
	}
		void add(Attr newAttr);
		Attr find(String attrName);
		Attr remove(String attrName);
		java.util.Iterator<Attr> attrs();
		
}
