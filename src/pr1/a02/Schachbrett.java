package pr1.a02;

import java.io.PrintWriter;

public class Schachbrett {

	public static void main (String [] args) {
		printSchachbrett();
		printSchachbrettReverse();
		
	}
	
	//Aufgabe 2b.c) Übergabe des Ausgabeobjekts als Parameter
		public static void printSchachbrett() {
			PrintWriter out = new PrintWriter (System.out,true);
			printSchachbrett(out);
			out.println();
		}
		
		//Aufgabe 2b.d) Übergabe des Ausgabeobjekts als Parameter
		public static void printSchachbrettReverse() {
			PrintWriter out = new PrintWriter (System.out,true);
			printSchachbrettReverse(out);
			out.println();
		}
		
		//Aufgabe 2b.a) Mit Implementierung der Aufgabe c
		public static void printSchachbrett(PrintWriter out) {
			for (int n = 8; n >= 1; n--) {  //Zuweisung des Parameters nummer n
				for (char z = 'A'; z <= 'H'; z++) { //Zuweisung der Variable zeichen z
					out.print(z + "" + n + " ");
				}
				out.println(); //Äquivalenz zu \n = newline
			}
		}
		
		//Aufgabe 2b.b) Mit Implementierung der Aufgabe d und Umkehrung der Parameter
		public static void printSchachbrettReverse(PrintWriter out) {
			for (int n = 1; n <= 8; n++) {
				for (char z = 'H'; z >= 'A'; z--) {
					out.print(z + "" + n + " ");
				}
				out.println();
			}
		}
}
