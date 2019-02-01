package pr1.a03;

import java.io.PrintWriter;
import pr1.a02.Schachbrett; //Import des Schachbretts aus Aufgabe 2
import schimkat.berlin.lernhilfe2016ws.io.DirtyFileWriter;

public class TestSchachbrett {

	public static void main (String args [] ) {
		printSchachbrett("file./SchachBrett.txt", false);
		printSchachbrett("file./SchachBrettReverse.txt",true);
	}
	
	//Aufgabe 3b.1)
	public static void printSchachbrett(String filename, boolean isReverse) {
		DirtyFileWriter fout = new DirtyFileWriter(filename);
		PrintWriter out = new PrintWriter(fout, true);
		if (isReverse == true) {		
			pr1.a02.Schachbrett.printSchachbrettReverse(out);
		} else {
			pr1.a02.Schachbrett.printSchachbrett(out);
		}
		fout.flush();
		fout.close();
	}
}