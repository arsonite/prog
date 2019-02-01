package pr1.a07;

import java.awt.Color;

import schimkat.berlin.lernhilfe2016ws.graphics.DirtyPainter;
import schimkat.berlin.lernhilfe2016ws.graphics.DirtyPainterTest;

public class Test {

	public static void main(String[] args) {
		//DirtyPainterTest.main(null);
		
		DirtyPainter painter = new DirtyPainter();
		painter.add(new FirstGraphics());
		painter.add(new Lines());
		painter.add(new Gitter(100, 100, Color.RED));
        painter.showDrawing();
	}
}