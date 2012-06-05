package ch07.Ex7_03;

public class PascalsTriangle {
	public static void main(String[] args){
		PascalsTriangle pt = new PascalsTriangle();
		int depth = 12;	    
	    pt.show(pt.calcTriangle(depth));
	}
	
	public int[][] calcTriangle(int depth){
		int[][] result = new int[depth][];
		for(int i = 0; i < depth; i++){
			result[i] = new int[i+1];
			result[i][0] = 1;
			result[i][i] = 1;
			if(i>=2){
				for(int l = 1; l < i; l++)
					result[i][l] = result[i-1][l-1] + result[i-1][l];
			}
		}
		
		return result;
	}
	
	public void show(int[][] triangle){
		for(int k = 0; k < triangle.length; k++){
			for(int l = 0; l < triangle[k].length; l++){
				System.out.print(triangle[k][l] + " ");
			}
			System.out.println("");
		}
	}
}
