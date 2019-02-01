package pr1.a08;

import java.awt.Graphics;

import schimkat.berlin.lernhilfe2016ws.graphics.Drawable;

public class RotatingPoint extends Point implements ChangingWithTime, Drawable {
	
	protected double r;
	protected int y0;
	protected int x0;

	/*public RotatingPoint(Point p, double radius) {
		x = p.x; 
		y = p.y;
		r = radius;
	}*/

	public RotatingPoint(int x0, int y0, double r) {
		this.x0 = x0;
		this.y0= y0; 
		this.r = r;
	}

	public void changeTimeTo(double timeValue) {
		x = (int) (x0 + r* Math.cos(timeValue));
		y = (int) (y0 + r*Math.sin(timeValue));
	}

	public void draw(Graphics g) {
		g.fillOval(x, y, 10, 10);
	}
}