package ch04.Ex4_02;

public class SimpleSortHarness implements SortHarness{

	private Object[] values;
	private final SortMetrics curMetrics = new SortMetrics();

	@Override
	public void doSort() {
		// TODO Auto-generated method stub
		for(int i = 0; i < getDataLength(); i++){
			for ( int j = i + 1; j < getDataLength(); j++){
				if (compare(i,j) > 0)
					swap(i,j);
			}
		}	
	}
	public final SortMetrics sort(Object[] data){
		values = data;
		curMetrics.init();
		doSort();
		return getMetrics();
	}
	public final SortMetrics getMetrics(){
		return curMetrics.clone();
	}
	public final int getDataLength(){
		return values.length;
	}
	public final Object probe(int i){
		curMetrics.incrementProbeCnt();
		return values[i];
	}
	
	public final int compare(int i, int j){
		curMetrics.incrementCompareCnt();
		Comparable d1 = (Comparable) values[i];
		Comparable d2 = (Comparable) values[j];
		if(d1.compareTo(d2) == 0)
			return 0;
		else
			return (d1.compareTo(d2) < 0 ? -1 : 1);
	}
	
	public final void swap(int i, int j){
		curMetrics.incrementSwapCnt();
		Object tmp = values[i];
		values[i] = values[j];
		values[j] = tmp;
	}
	
}
