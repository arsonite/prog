package pr1.a07;

import pr1.a07.Gitter;
import java.awt.Graphics;

import schimkat.berlin.lernhilfe2016ws.graphics.Drawable;


public class FirstGraphics implements Drawable  {

	public void draw(Graphics g) {
		g.drawOval(300, 250, 40, 40);
		g.drawOval(200, 250, 40, 40);
		g.drawOval(100, 250, 40, 40);
		
		//new Gitter(50,50).draw(g);
		//new Gitter(10,10).draw(g);
	}
}