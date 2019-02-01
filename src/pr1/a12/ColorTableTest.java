package pr1.a12;

import schimkat.berlin.lernhilfe2016ws.graphics.DirtyPainter;

public class ColorTableTest {
	
	public static void main(String[] args) {
		DirtyPainter painter = new DirtyPainter();
		
//		String[] color = new String[18];
//		
//		color[0]="BLACK";
//		color[1]="DARKGRAY";
//		color[2]="LIGHTGRAY";
//		color[3]="WHITE";
//		color[4]="RED";
//		color[5]="ORANGE";
//		color[6]="YELLOW";
//		color[7]="PINK";
//		color[8]="MAGENTA";
//		color[9]="DARKBLUE";
//		color[10]="BLUE";
//		color[11]="LIGHTBLUE";
//		color[12]="LIGHTGREEN";
//		color[13]="GREEN";
//		color[14]="DARKGREEN";
//		color[15]="DARKCYAN";
//		color[16]="CYAN";
//		color[17]="LIGHTCYAN";
		
		String[] color = {"BLACK", "DARKGRAY", "LIGHTGRAY", "WHITE", "RED", "ORANGE",
		"YELLOW", "PINK", "MAGENTA", "DARKBLUE", "BLUE", "LIGHTBLUE",};
		
		painter.add(new ColorTable(color));
		painter.showDrawing();
	}
}