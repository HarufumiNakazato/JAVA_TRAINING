package ch03.Ex3_11;

public class SimpleSortDouble extends SortDouble{

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
