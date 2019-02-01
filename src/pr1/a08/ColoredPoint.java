package pr1.a08;

import java.awt.Color;
import java.awt.Graphics;

import pr1.a09.Drawable;

public class ColoredPoint extends Point implements Drawable {
	protected Color color;

	public ColoredPoint (int x, int y, Color color) {
		super (x,y);
		this.color = color;
	}
	
	public ColoredPoint (Point p, Color color) {
		this(p.x, p.y, color);
	}
	
	public ColoredPoint (ColoredPoint cp) {
		this(cp.x, cp.y, cp.color);
	}
	
	public String toString () {
		return "(" + super.toString() + color.toString() + ")";
	}
	
	public void draw(Graphics g) {
		final Color BORDER_COLOR = Color.BLACK;
		Color oldColor = g.getColor();
		int x1 = (int) x;
		int y1 = (int) y;
		g.setColor(BORDER_COLOR);
		g.drawOval(x1-2,  y1-2,  5, 5);
		g.setColor(color);
		g.fillOval(x1-2,  y1-2,  5,  5);
		g.setColor(oldColor);
	}
}
