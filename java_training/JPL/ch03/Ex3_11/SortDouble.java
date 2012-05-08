package ch03.Ex3_11;

abstract class SortDouble {
	private double[] values;
	private final SortMetrics curMetrics = new SortMetrics();
	
	public final SortMetrics sort(double[] data){
		values = data;
		curMetrics.init();
		doSort();
		return getMetrics();
	}
	
	public final SortMetrics getMetrics(){
		return curMetrics.clone();
	}
	
	protected final int getDataLength(){
		return values.length;
	}
	
	//Metricsのカウンターをprivateにして、メソッドによりインクリメントする。
	protected final double probe(int i){
		curMetrics.incrementProbeCnt();
		return values[i];
	}
	
	protected final int compare(int i, int j){
		curMetrics.incrementCompareCnt();
		double d1 = values[i];
		double d2 = values[j];
		if(d1 == d2)
			return 0;
		else
			return (d1 < d2 ? -1 : 1);
	}
	
	protected final void swap(int i, int j){
		curMetrics.incrementSwapCnt();
		double tmp = values[i];
		values[i] = values[j];
		values[j] = tmp;
	}
	
	protected abstract void doSort();
	
}
