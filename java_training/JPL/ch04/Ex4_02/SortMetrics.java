package ch04.Ex4_02;

public class SortMetrics implements Cloneable{
	public long probeCnt,
				compareCnt,
				swapCnt;
	
	public void init(){
		probeCnt = swapCnt = compareCnt = 0;
	}
	
	public String toString(){
		return probeCnt + " probes " + compareCnt + " compares " + swapCnt + " swaps";
	}
	
	public SortMetrics clone(){
		try {
			return (SortMetrics) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			throw new InternalError(e.toString());
		}
	}
	
	public void incrementProbeCnt(){
		probeCnt++;
	}
	
	public void incrementCompareCnt(){
		compareCnt++;
	}
	
	public void incrementSwapCnt(){
		swapCnt++;
	}
}
