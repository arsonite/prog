package pr1.a08;

import java.awt.Graphics;

import schimkat.berlin.lernhilfe2016ws.graphics.DirtyPainter;

public class PointTest {

	public static void main (String [] args, Graphics g) {
		DirtyPainter painter = new DirtyPainter();

		RotatingPoint rPoint = new RotatingPoint(250, 250, 100);
		RotatingPoint rPoint2 = new RotatingPoint(250, 250, -100);
		RotatingPoint rPoint3 = new RotatingPoint(250, 250, 0);
		RotatingPoint rPoint4 = new RotatingPoint(250, 250, 150);
		RotatingPoint rPoint5 = new RotatingPoint(250, 250, -150);
		painter.add(rPoint);
		painter.add(rPoint2);
		painter.add(rPoint3);
		painter.add(rPoint4);
		painter.add(rPoint5);

		double timeValue = 0;
		while(true) {
			rPoint.changeTimeTo(timeValue);
			rPoint2.changeTimeTo(timeValue);
			rPoint3.changeTimeTo(timeValue);
			rPoint4.changeTimeTo(timeValue);
			rPoint5.changeTimeTo(timeValue);
			timeValue +=0.5;
			painter.showDrawingAfterWaiting(1);
		}
	}
}