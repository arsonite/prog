package pr1.a09;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import pr1.a08.ChangingWithTime;

import schimkat.berlin.lernhilfe2016ws.graphics.DirtyPainter;
import schimkat.berlin.lernhilfe2016ws.graphics.Drawable;

public class Park implements Drawable, ChangingWithTime {
	
	protected int x;
	protected int y;
	
	public Park (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Park () {
		DirtyPainter painter = new DirtyPainter();
		
		List<Pflanze> list = new ArrayList<Pflanze>(); //als attribut
		list.add(new Baum(150, 250, 5, 0, 20)); 
		list.add(new Blume(500, 300, 0, 0, 20));
		
		painter.add(new Park(0,0));
		
		for (Drawable pflanze : list) {
			painter.add(pflanze);
		}
		painter.showDrawing();
		
		double timeValue = 0;
		
		while(true) {
			for (int i = 0; i<list.size(); i++) {
				Pflanze pflanze = list.get(i); //
				pflanze.changeTimeTo(timeValue); //Änderung aller Pflanzen
			}
			if(timeValue<24) {
				timeValue++;
			} else {
				timeValue = 0;
			}
			painter.showDrawingAfterWaiting(150);
			}
		}
	
	public void draw(Graphics g) {
		g.setColor(new Color(102, 178, 255));
		g.fillRect(0, 0, 2000, 2000);
		g.setColor(new Color(102, 204, 10));
		g.fillRect(0, 350, 2000, 2000);
		g.setColor(new Color(102, 51, 10));
		g.fillRect(0, 500, 2000, 2000);
		//aufrufen von allem
	}

	public void changeTimeTo (double timeValue) {
		//aufruf von allem
	}
}