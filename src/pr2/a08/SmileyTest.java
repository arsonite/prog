package pr2.a08;

import java.awt.Color;

import schimkat.berlin.lernhilfe2017ss.graphics.DirtyPainter;

public class SmileyTest {
	
	public static long time = System.currentTimeMillis();

	public static void main(String[] args) {
		DirtyPainter dP = new DirtyPainter();
		DirtyPainter dP2 = new DirtyPainter();
		DirtyPainter dP3 = new DirtyPainter();
		DirtyPainter dP4 = new DirtyPainter();

		Smiley smiley = new Smiley(100, 100, 300, 30.0, true, Color.BLACK);
		Smiley smiley2 = new Smiley(100, 350, 200, 110.0, false, Color.LIGHT_GRAY);
		Smiley smiley3 = new Smiley(500, 150, 100, 200.0, true, Color.BLUE);
		Smiley smiley4 = new Smiley(185, 100, 400, 310.0, false, Color.GREEN);
		
		double angle = 0;
		
		dP.add(smiley);
		dP2.add(smiley2);
		dP3.add(smiley3);
		dP4.add(smiley4);
		
		while (true) {
			angle = angle + 10;
			smiley.setAngle(angle);
			smiley2.setAngle(angle);
			smiley3.setAngle(angle);
			smiley4.setAngle(angle);
			dP.showDrawingAfterWaiting(10);
			dP2.showDrawingAfterWaiting(10);
			dP3.showDrawingAfterWaiting(10);
			dP4.showDrawingAfterWaiting(10);
		}
	}
}
