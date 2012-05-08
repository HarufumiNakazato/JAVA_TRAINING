package ch01.Ex1_15;
import java.util.ArrayList;



public class ImplementExtendLookUp implements ExtendLookUp{

	public  String[] names;
	public  Object[] values;

	public static void main(String[] args){
		ImplementExtendLookUp test = new ImplementExtendLookUp();
		String[] name_temp = {"primary","junior high","hi","university"};
		Object[] value_temp = {6,3,3,4};
		test.names = name_temp;
		test.values = value_temp;
		System.out.println("--default--");
		for(int i=0;i<test.names.length;i++){
			System.out.println(test.names[i] + ": " + test.values[i] + " years.");
		}
		System.out.println("\n--added--");
		test.add("graduate university", 2);
		for(int i=0;i<test.names.length;i++){
			System.out.println(test.names[i] + ": " + test.values[i] + " years.");
		}
		
		System.out.println("\n--removed--");
		test.remove("hi");
		for(int i=0;i<test.names.length;i++){
			System.out.println(test.names[i] + ": " + test.values[i] + " years.");
		}
	}
	public ImplementExtendLookUp(){
		
	}
	public Object find(String name){
		for(int i = 0;i<names.length;i++){
			if(names[i].equals(name))
				return values[i];
		}
		return null;
	}
	public void add(String a_name,Object a_value){
		
		Object[] new_values = new Object[values.length+1];
		String[] new_names = new String[names.length+1];
		for(int i = 0;i<new_values.length-1;i++){
			new_values[i] = values[i];
			new_names[i] = names[i];
		}
		new_values[new_values.length-1] = a_value;
		new_names[new_names.length-1] = a_name;
		values = new_values;
		names = new_names;
	}
	
	public void remove(String a_name){
		ArrayList<Object> valueList = new ArrayList<Object>();
		ArrayList<String> nameList = new ArrayList<String>();
		for(int k = 0;k<names.length;k++){
			if(!names[k].equals(a_name)){
				nameList.add(names[k]);
				valueList.add(values[k]);
			}
		}
		values = valueList.toArray();
		names = nameList.toArray(new String[nameList.size()]);
	}
}
