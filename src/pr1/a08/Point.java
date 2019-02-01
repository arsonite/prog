package pr1.a08;

import java.awt.Color;
import java.awt.Graphics;

public class Point {
	protected int x;
	protected int y;
	protected Color color;
	
	public Point (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point() {
	}
	
	public Point (Point p) {
		this(p.x, p.y);
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void moveAbs (int x, int y) {
		this.x = x;
		this.y = y;
	}
	public void moveRel (int dx, int dy) {
		x+=dx;
		y+=dy;
	}
	
	/*public String toString () {
		return String.format("[%3d, %3d]", x, y);
	}*/
		
	public void draw(Graphics g) {
		Color localColor = g.getColor();
		g.setColor(Color.BLACK);
	    g.fillOval(this.x - 3, this.y - 3, 7, 7);
	    g.setColor(this.color);
	    g.fillOval(this.x - 2, this.y - 2, 5, 5);
	    g.setColor(localColor);
	}
}