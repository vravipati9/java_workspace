import java.awt.Point;
class Aa {
	private static int counter = 0;
	public static int getInstanceCount() {
		return counter;
	}
	Aa() {
		counter++;
	}
}
public class InstanceCount {

	public static void main(String[] args) {
		Aa a1 = new Aa();Aa a2 = new Aa();Aa a3 = new Aa();
		System.out.println(Aa.getInstanceCount());
	}

}

class Line {
	void mTwo() {
		
	}
	public static class Point {
		void mOne() {
			
		}
	}
}

class Triangle {
	//Point p = new Point();
	Line.Point obj = new Line.Point();
	//Line l = new Line() ;
	//l.Point p = new l.Point();
}