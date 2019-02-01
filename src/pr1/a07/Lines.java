package pr1.a07;

import java.awt.Graphics;

import schimkat.berlin.lernhilfe2016ws.graphics.Drawable;

public class Lines implements Drawable  {

	public void draw(Graphics g) {
		g.drawLine(25, 35, 456, 234);
		g.drawLine(50, 321, 124, 224);
		g.drawLine(75, 34, 41, 122);
		g.drawLine(100, 55, 423, 234);	
	}
}