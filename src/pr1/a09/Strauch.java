package pr1.a09;

import java.awt.Graphics;
import java.awt.Color;

public class Strauch extends Pflanze {
	
	public Strauch (int x, int y, int h, int h2, int max) {
		super(x, y, h, h2, max);
	}

	protected void drawAtOrigin(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(200, 200, 15+h, 35+h);
		g.setColor(Color.GREEN);
		g.fillOval(190, 145, h+35, h+35);
		g.fillOval(170, 170, h+35, h+35);
		g.fillOval(210, 170, h+35, h+35);
	}
	
	public void waechst() {
		while(h2<max) {
			h2++;
		}
	}
	
	@Override
	public void changeTimeTo(double timeValue) {
		double tageslicht = Math.sin(timeValue);
		
		if(tageslicht > 0) {
			waechst();
			tageslicht++;
		}
	}
}