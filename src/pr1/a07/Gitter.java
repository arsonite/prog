package pr1.a07;

import java.awt.Graphics;
import java.awt.Color;

import schimkat.berlin.lernhilfe2016ws.graphics.Drawable;

public class Gitter implements Drawable {
	
	protected int dx = 1000;
	protected int dy= 1000;
	protected Color color = Color.BLACK;

	public Gitter() {
	}
	
	public Gitter (int dx, int dy, Color color) {
		this.dx = dx;
		this.dy = dy;
		this.color = color;
	}
	
	public Gitter(Gitter net) {
		this(net.dx, net.dy, net.color);
	}
	
	//Vollständiger Konstruktur für FirstGraphics
	/*public Gitter(int dx, int dy) {
		this.dx = dx;
		this.dy = dy;
	}*/

	public int getDx() {
		return dx; 
	}
	
	public int getDy() {
		return dy;
	}
	
	public Color getColor() {
		return color;
	}
	
	public Color setColor(Color c) {
		return color=c;
	}

	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawLine(500,1000,500,0);
		g.drawLine(1000,0,0,1000);
		g.setColor(this.color);
		for(int x = dx+20; x<=1000; x+=dx) {
			g.drawLine(x, 0, x, 1000);
		}
		for(int y = dy+20; y<=1000; y+=dy) {
			g.drawLine(0, y, 1000, y);
		}
	}
	
}