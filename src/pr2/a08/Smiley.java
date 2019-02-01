package pr2.a08;

import java.awt.Color;
import java.awt.Graphics;

import schimkat.berlin.lernhilfe2017ss.graphics.Drawable;

public class Smiley implements Drawable {

	protected int x;
	protected int y;
	protected int d;
	protected int r;
	protected int w;
	protected double angle;
	protected double bM;
	protected boolean smile;
	protected Color c;

	public Smiley(int x, int y, int d, double angle, boolean smile, Color c){
		this.x = x;
		this.y = y;
		this.d = d;
		this.r = d/2;
		this.w = r/2;
		this.angle = angle;
		this.bM = angle*Math.PI/180;
		this.smile = smile;
		this.c = c;
	}
	
	public void drawFace(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillOval(x, y, d, d);
	}

	public void drawEyes(Graphics g) {
		int r8 = r/8;
		int w3 = w/3;
		
		int lE = x + r/2 - r8;
		int rE = x + r + r8;
		int yE = y + r/2;
		int lP = (int) (lE + w3 - Math.cos(bM)*(r8));
		int yP = (int) (yE + w3 - Math.sin(bM)*(r8));
		int rP = (int) (rE + w3 - Math.cos(bM)*(r8));

		g.setColor(Color.white);
		g.fillOval(lE, yE, w, w);
		g.fillOval(rE, yE, w, w);
		g.setColor(c);
		g.fillOval(lP, yP, w3, w3);
		g.fillOval(rP, yP, w3, w3);
	}

	public void drawSmile(Graphics g) {
		g.setColor(Color.RED);
		if(smile){
            g.fillArc(x+r/2, y+r/4+r/2, r, r, 180, 180);
        }
		
        else{
            g.drawArc(x+r/2, y+r+r/4, r, r/2, 360, 180);
        }
	}
	
	public void draw(Graphics g){
		drawFace(g);
		drawEyes(g);
		drawSmile(g);
	}

	public void moveRelativ(int dx, int dy){
		this.x+= dx;
		this.y+= dy;
	}

	public void setPosition(int x ,int y){
		this.x = x;
		this.y = y;
	}

	public void setDiameter(int d) {
		this.d = d;
	}

	public void setSmile(boolean smile) {
		this.smile = smile;
	}

	public void setAngle(double angle) {
		this.angle = angle;
		bM = angle*Math.PI/180;
	}
}