package pr1.a03;

import java.io.PrintWriter;

public class Hypothenuse {

	public static void main (String [] args) {
		PrintWriter out = new PrintWriter (System.out,true);
		//out.println(hypothenuse(1.5, 2.5));
		//printHypothenuse(5.0, 2.5, 10, 5, out);
		testHypothenuse(10, 5, out);
	}
	
	//Aufgabe 3b.2)
	public static double hypothenuse (double k1, double k2) {
		return Math.sqrt(Math.pow(k1, 2)+Math.pow(k2, 2));
	}
	
	//Aufgabe 3b.3)
	public static void printHypothenuse (double k1, double k2, int width, int precision, PrintWriter out) {
		out.printf("%" +  width + "." + precision + "f", hypothenuse (k1, k2));
	}
	
	//Aufgabe 3b.4)
	public static void testHypothenuse(int width, int precision, PrintWriter out) {
		for(int l=0; l<10; l++) { //l=length - Länge der Tabelle
			for(int w=0; w<10; w++) { //w=width - Breite der Tabelle
				printHypothenuse(l, w, width, precision, out);
				out.print("    "); //4 Leerzeichen zur eindeutigen Trennung der Hypothenusen
			}
			out.println(); // Äquivalenz zu "\n"
		}
	}
}
