package ch01.Ex1_08;

class TestPoint {
public static void main(String[] args){
		
		Point p_a = new Point();
		Point p_b = new Point();
		
		p_a.clear();
		p_b.x = 1.2;
		p_b.y = 2.5;
		
		System.out.println("‘ã“ü‘OF(" + p_a.x + "," + p_a.y + ")");
		p_a.setCoordinate(p_b);
		System.out.println("‘ã“üŒãF(" + p_a.x + "," + p_a.y + ")");
	}
}
