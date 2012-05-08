package ch04.Ex4_02;

interface SortHarness {
	
	SortMetrics sort(Object[] data);
	
	Object probe(int i);
	
	int compare(int i, int j);
	
	void swap(int i, int j);
	
	void doSort();
	
}
