package pr1.a09;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.Color;

public class Blume extends Pflanze {
	
	public Blume (int x, int y, int h, int h2, int max) {
		super(x, y, h, h2, max);
	}

	protected void drawAtOrigin(Graphics g) {
		g.setColor(new Color(75, 150, 0)); // Stängel
		g.fillRect(0, 0, 5+h, 200+h);
		g.setColor(new Color(102, 51, 0)); // Kopf
		g.fillOval(-22, -25, h2+25, h2+25);
		Graphics2D g2d = (Graphics2D)g;
		AffineTransform old = g2d.getTransform();
		g2d.rotate(Math.toRadians(45));
		g.setColor(new Color(75, 150, 0));
		g.fillOval(78, 100, h2+15, h2+1);
		g2d.rotate(Math.toRadians(90));
		g.fillOval(50, -100, h2+15, h2+1);
		g2d.setTransform(old);
			for(int i=0; i<25; i++) {
				if (i%2==0) {
					g.setColor(Color.YELLOW);
				} else {
					g.setColor(new Color(255, 125, 0));
				}
			g.fillOval(20, -10, h2+15, h2+1); //Blüten
			g2d.rotate(Math.toRadians(20));
		}
		g2d.setTransform(old);
	}
}