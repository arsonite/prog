package pr2.a09;

import java.awt.Color;
import java.awt.Graphics;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;

import schimkat.berlin.lernhilfe2017ss.graphics.DirtyPainter;
import schimkat.berlin.lernhilfe2017ss.graphics.Drawable;

public class SmileyView extends JPanel implements Drawable, PropertyChangeListener {
	private static final long serialVersionUID = 1015852072807854606L;
	protected int x;
	protected int y;
	protected int d;
	protected int r;
	protected int w;
	protected int r8;
	protected int w3;
	protected int lE;
	protected int rE;
	protected int yE;
	protected int lP;
	protected int yP;
	protected int rP;
	protected double angle;
	protected double bM;
	protected boolean smile;
	protected Color c;
	protected SmileyModel m;
	protected DirtyPainter dP;

	public SmileyView(SmileyModel m){
		dP = new DirtyPainter();
		dP.add(this);
		this.x = m.getX();
		this.y = m.getY();
		this.r = m.getRadius();
		this.angle = m.getAngle();
		this.smile = m.isSmile();
		this.m = m;
	}
	
	public void draw(Graphics g){
		Smiley s = new Smiley();
		s.drawFace(g);
		s.drawEyes(g);
		s.drawSmile(g);
	}
	
	public void propertyChange(PropertyChangeEvent e){
		if(e.getPropertyName().equals("MODEL_UPDATE")){
			x = m.getX();
			y = m.getY();
			r = m.getRadius();
			c = m.getColor();
			angle = m.getAngle();
			smile = m.isSmile();
			bM = angle*Math.PI/180;
			d = r*2;
			w = r/2;
			r8 = r/8;
			w3 = w/3;
			lE = x + r/2 - r8;
			rE = x + r + r8;
			yE = y + r/2;
			lP = (int) (lE + w3 - Math.cos(bM)*(r8));
			yP = (int) (yE + w3 - Math.sin(bM)*(r8));
			rP = (int) (rE + w3 - Math.cos(bM)*(r8));
			dP.showDrawingAfterWaiting(1);
		}
	}

	public class Smiley {
		public Smiley() {
		}

		public void drawFace(Graphics g) {
			g.setColor(Color.YELLOW);
			g.fillOval(x, y, d, d);
		}

		public void drawEyes(Graphics g) {
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
	}
}