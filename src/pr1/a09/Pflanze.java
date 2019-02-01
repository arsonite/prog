package pr1.a09;

import java.awt.Graphics;

import pr1.a08.ChangingWithTime;

import schimkat.berlin.lernhilfe2016ws.graphics.Drawable;

public abstract class Pflanze implements ChangingWithTime, Drawable {
	
	protected int x;
	protected int y;
	protected int h;
	protected int h2;
	protected int max;
	
	public Pflanze(int x, int y, int h, int h2, int max) {
		this.x = x;
		this.y = y;
		this.h = h;
		this.h2 = h2;
		this.max = max;
	}
	
	public void draw(Graphics g) {
		g.translate(x, y);
		drawAtOrigin(g);
		g.translate(-x, -y);
	}
	
	public void waechst() {
		if(h2<max) {
			h2++;
		}
	}
	
	public void schrumpft(){
		if(h2>=0) {
			h2--;
		}
	}

	@Override
	public void changeTimeTo(double timeValue) {
		if(timeValue>0) {
			waechst();
		} else {
			schrumpft();
		}
	}
	
	protected abstract void drawAtOrigin(Graphics g);
}
