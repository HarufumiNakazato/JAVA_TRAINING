package ch03.Ex3_12;

public class TestSort {
	static Object[] testData = {
		"AB", "1.3e-2","7.9","CDE"
	};
	
	public static void main(String[] args){
		SortHarness bsort = new SimpleSortHarness();
		SortMetrics metrics = bsort.sort(testData);
		System.out.println("Metrics:" + metrics);
		
		for(int i = 0; i < testData.length; i++)
			System.out.println("\t" + testData[i]);
	}
}
