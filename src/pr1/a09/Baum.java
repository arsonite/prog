package pr1.a09;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.Color;

public class Baum extends Pflanze {
	
	public Baum (int x, int y, int h, int h2, int max) {
		super(x, y, h, h2, max);
	}

	protected void drawAtOrigin(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		AffineTransform old = g2d.getTransform();
		g.setColor(new Color(75, 50, 0));
		g.fillRect(-35, 0, 75, 250);
		g.setColor(new Color(0, 100, 0));
			for(int i=0; i<25; i++) {
				g.setColor(new Color(0, 100, 0));
				g.fillOval(0, -100, h2+5, h2+5);
				g2d.rotate(Math.toRadians(20));
			}
		g2d.setTransform(old);
//		g.setColor(new Color(0, 100, 0));
//		g.fillOval(190, 145, h+35, h+35);
//		g.fillOval(170, 170, h+35, h+35);
//		g.fillOval(210, 170, h+35, h+35);
	}
}
