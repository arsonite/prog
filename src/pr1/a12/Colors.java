package pr1.a12;

import java.io.PrintWriter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import schimkat.berlin.lernhilfe2016ws.io.DirtyFileReader;

final class Colors {
	
	public static void main(String[] args) {
		PrintWriter out = new PrintWriter (System.out, true);
		out.println(createByName("BLACK"));
		out.println(createByName("RED"));
		out.println(createByName("YELLOW"));
	}
	
	private static java.awt.Color awtColor (javafx.scene.paint.Color c) {
		return new java.awt.Color((float)(c.getRed()), (float)(c.getGreen()), (float)(c.getBlue()));		
	}
	
	public static java.awt.Color createByName(String fxColorName) {
		javafx.scene.paint.Color c = javafx.scene.paint.Color.valueOf(fxColorName);
		return awtColor(c);
	}
	
	public static java.awt.Color[] createColorsByName(String[] fxColorName) {
		java.awt.Color[] colors = new java.awt.Color[fxColorName.length]; 
		for(int i = 0; i<fxColorName.length; i++) {
			colors[i] = createByName(fxColorName[i]);
		}
		return colors;
	}
	
	public static Map<String,java.awt.Color> createMapByName(String[] fxColorName) {
		HashMap <String,java.awt.Color> map = new HashMap <String,java.awt.Color>();
		for(int i = 0; i<fxColorName.length; i++) {
			map.put(fxColorName[i], createByName(fxColorName[i]));
		}
		return map;
	}
	
	public static Map<String,java.awt.Color> createMapByFileName(String filename) {
		DirtyFileReader dfr = new DirtyFileReader(filename);
		Scanner in = new Scanner(dfr);
		HashMap <String,java.awt.Color> map = new HashMap <String,java.awt.Color>();
		while(in.hasNext()) {
			map.put(in.next(), new java.awt.Color(in.nextInt(), in.nextInt(), in.nextInt()));
		}
		in.close();
		return map;
	}
}