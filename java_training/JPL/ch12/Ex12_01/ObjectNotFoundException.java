package ch12.Ex12_01;

public class ObjectNotFoundException extends Exception{

	private Object object;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException(){}
	public ObjectNotFoundException(Object o){
		this.object = o;
	}
	public String toString(){
		return super.toString() + "\n" + "\"" + object.toString() + "\"" + " is not found.";
	}
}
