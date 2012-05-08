package ch03.Ex3_12;

public class SimpleSortHarness extends SortHarness{

	@Override
	protected void doSort() {
		// TODO Auto-generated method stub
		for(int i = 0; i < getDataLength(); i++){
			for ( int j = i + 1; j < getDataLength(); j++){
				if (compare(i,j) > 0)
					swap(i,j);
			}
		}	
	}
}
