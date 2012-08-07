import java.io.IOException;



public class TestSample {
	public TestSample(){}
	public TestSample(String s,int i){}
	public String a = "A";
	private int b = 2;
	private TestSample ts;
	private final int VALUE = 999;
	//private String[] str = new String[]{"t","e","s","t"};
	
	private void show(){
		System.out.println("test");
	}
	public void showMessage(String s){
		System.out.println(s);
	}
	public int testReturn(){
		return 1;
	}
	public int add(int a,int b){
		return a+b;
	}
	public void throwTest() throws IOException{
		throw new IOException();
	}
	public void throwParam(int a, String b) throws IOException{
		throw new IOException();
	}
	
}
