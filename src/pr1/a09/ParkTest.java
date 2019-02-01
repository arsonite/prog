package pr1.a09;

import schimkat.berlin.lernhilfe2016ws.graphics.DirtyPainter;

public class ParkTest {

	public static void main (String [] args) {
		DirtyPainter painter = new DirtyPainter();
		
		Park park = new Park();
		painter.add(park);
		painter.showDrawing();
		
//		double timeValue = 0;
//		
//		while(true) {
//			if(timeValue<24) {
//			timeValue++;
//			} else {
//			timeValue=0;
//			}
//		}
	}
}