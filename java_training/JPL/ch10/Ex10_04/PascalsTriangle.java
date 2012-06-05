package ch10.Ex10_04;

public class PascalsTriangle {
	public static void main(String[] args){
		PascalsTriangle pt = new PascalsTriangle();
		int depth = 12;	    
	    pt.show(pt.calcTriangle(depth));
	}
	
	public int[][] calcTriangle(int depth){
		int[][] result = new int[depth][];
		int i = 0;
		while(i < depth){
			result[i] = new int[i+1];
			result[i][0] = 1;
			result[i][i] = 1;
			if(i>=2){
				int l = 1;
				while(l < i){
					result[i][l] = result[i-1][l-1] + result[i-1][l];
					l++;
				}
			}
			i++;
		}
		
		return result;
	}
	
	public void show(int[][] triangle){
		int k = 0;
		while(k < triangle.length){
			int l = 0;
			while(l < triangle[k].length){
				System.out.print(triangle[k][l] + " ");
				l++;
			}
			System.out.println("");
			k++;
		}
	}
}
