package chapter3.composition;

import chapter3.Color;
import chapter3.composition.ColorPoint;
import chapter3.composition.Point;

public class ColorPointTest {
	// Initialize UnitCircle to contain all Points on the unit circle
	public static void main(String[] args) {

		ColorPoint p1 = new ColorPoint(1, 2, Color.RED);
		Point p2 = new Point(1, 2);
		ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);
		System.out.printf("%s %s %s%n", p1.equals(p2), p2.equals(p3),
				p1.equals(p3));
		
		
	}
	

}
