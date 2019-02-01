package pr1.a02;

import java.io.PrintWriter;

public class SomeFunctions {

	public static void main(String [] args) {
		PrintWriter out = new PrintWriter (System.out, true);
		out.println((kreisUmfang (2.0)));
		out.println((rechteckUmfang (2.5,4.1)));
		out.println((rechteckFlaeche (5.2,3.35)));
		out.println(); //Zur Trennung von den Funktionen und den Schachbrettern
		
	}
	
	//Aufgabe 2.a)
	public static double kreisUmfang (double radius) {
		double ergebnis = 2.0*Math.PI*radius;
		return ergebnis;
	}
	
	public static double rechteckUmfang (double a, double b) {
		double ergebnis = 2.0*a+b;
		return ergebnis;
	}
	
	public static double rechteckFlaeche (double a, double b) {
		double ergebnis = a*b;
		return ergebnis;
	}
	
	
}
