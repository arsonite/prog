package pr2.fin;

import java.awt.Color;
import java.awt.Graphics;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;

public class FirstSmileyPanel extends JPanel implements PropertyChangeListener {
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
	protected Color pupilColor;
	protected Color socketColor;
	protected Color faceColor;
	protected SmileyModel m;

	public FirstSmileyPanel(SmileyModel m){
		this.m = m;
		x = m.getX();
		y = m.getY();
		r = m.getRadius();
		pupilColor = m.getPupilColor();
		socketColor = m.getSocketColor();
		faceColor = m.getFaceColor();
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
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		drawFace(g);
		drawEyes(g);
		drawSmile(g);
	}

	public void propertyChange(PropertyChangeEvent e){
		if(e.getPropertyName().equals("MODEL_UPDATE")){
			x = m.getX();
			y = m.getY();
			r = m.getRadius();
			pupilColor = m.getPupilColor();
			socketColor = m.getSocketColor();
			faceColor = m.getFaceColor();
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
			repaint();
		}
	}

	public void drawFace(Graphics g) {
		g.setColor(faceColor);
		g.fillOval(x, y, d, d);
	}

	public void drawEyes(Graphics g) {
		g.setColor(socketColor);
		g.fillOval(lE, yE, w, w);
		g.fillOval(rE, yE, w, w);
		g.setColor(pupilColor);
		g.fillOval(lP, yP, w3, w3);
		g.fillOval(rP, yP, w3, w3);
	}

	public void drawSmile(Graphics g) {
		g.setColor(Color.RED);
		if(smile){
			g.fillArc(x+r/2, y+r/4+r/2, r, r, 180, 180);
		} else{
			g.drawArc(x+r/2, y+r+r/4, r, r/2, 360, 180);
		}
	}
}