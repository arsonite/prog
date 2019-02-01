package pr1.a12;

import java.awt.Color;
import java.awt.Graphics;

import java.util.Map;

import schimkat.berlin.lernhilfe2016ws.graphics.Drawable;

public final class ColorTable implements Drawable {
	protected String[] fxColorNames;
	protected Map <String,Color> colormap;
	
	public ColorTable(String[] fxColorNames) {
		this.fxColorNames = fxColorNames;
		this.colormap = Colors.createMapByName(fxColorNames);
	}

	public void draw(Graphics g) {
		int h = 0;
		for(int i = 0; i<colormap.size(); i++) {
			g.setColor(colormap.get(fxColorNames[i]));
			g.fillRect(30, 30+h, 30, 30);
			g.drawString(fxColorNames[i], 65, 45+h);
			h+=30;
		}
	}
}