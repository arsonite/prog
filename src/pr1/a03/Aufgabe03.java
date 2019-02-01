package pr1.a03;

import java.io.PrintWriter;
import java.util.Locale;
import java.util.Random;
import schimkat.berlin.lernhilfe2016ws.io.DirtyFileWriter;

public class Aufgabe03 {

	public static void main (String [] args) {
		Locale.setDefault(Locale.US);
		writeIntNumberFile("file./NumberFile.txt", 1000); //Int-Wert gibt an wieviele Zahlen erzeugt werden
		writeMixedNumberFile("file./MixedNumberFile.txt", 100, 10);
	}
	
	//Aufgabe 3c.1)
	public static void writeIntNumberFile (String filename, int numberCount) {
		DirtyFileWriter fout= new DirtyFileWriter(filename);
		PrintWriter out = new PrintWriter(fout, true);
		if(numberCount%2!=0) { //Prüfung ob numberCount ungerade ist (numberCount Modulo, Rest durch 2 ungleich 0)
			numberCount+=1; //Wenn numberCount ungerade ist, wird der Wert um 1 erhöht
		}
		for(int i=1; i<=numberCount; i++) {
			double random= Math.random()*1000; //*1000 = Zahlenbereich (hier 1-1000)
			out.printf("%-5d",(int) (random)); //linksbündige dezimale Zufallszahlen
			out.print(" "); //Leerzeichen zwischen Ausgaben
			if(i%10==0) { //Alle 10 Zeichen
				out.print("\n"); //Zeilenumbruch
			}
		}
		fout.flush();
		fout.close();
	}
	
	//Aufgabe 3c.2)
	public static void writeMixedNumberFile (String filename, int numberCount, int width) {
		DirtyFileWriter fout= new DirtyFileWriter(filename);
		PrintWriter out = new PrintWriter(fout, true);
		if(numberCount%2!=0) {
			numberCount+=1;
		}
		Random next = new Random();
		for(int i=1; i<=numberCount; i++) {
			double random = Math.random()*100;
			int ergebnis = next.nextInt(2); //Gleichmäßíg verteiler Int-Wert aus Pseudo-Zufallszahlszahlen (0-2)
			if(i%10==0){
				out.print("\n");
			}
			if(ergebnis==0) { //Wenn das Ergebnis aus dem nextInt(0-2), Null ergibt
				out.printf("%0" + width + "." + (width-5) + "f", random); //füll Leerraum mit Nullen, setze Komma an fünfte Stelle und wandle Gleitkommazahl in Fixpunktdarstellung um
			}else {
				out.printf("%0" + width + "d", (int) (random));//füll den Leerraum mit Nullen und wandle Gleitkommazahl in Dezimaldarstellung um
			}
			out.print(" ");
		}
		fout.flush();
		fout.close();
	}
}