package pr1.a01;								   //Günaydin, 853872
import java.io.PrintWriter;
public class MoreMethods {
	
	public static void main(String [] args) {
		PrintWriter out = new PrintWriter (System.out, true);
		printAlphabet(out, true);
		printAlphabet(out, false); //false=Groß, true=Klein
		printCharSeries (out,'a',26); //a=Anfangsbuchstabe, 26=Anzahl der Zeichen
	}
	/* Aufgabe 1c.a) (Vor Vereinfachung - ohne Zusatzaufgabe)
	 public static void printAlphabet (PrintWriter out, boolean smallLetters) {
		for(char c='a'; c<='z'; c++) { 
			out.print(c + " ");		
		}
		out.println(); */
	
//Aufgabe 1c.c & 1c.d) Vereinfachung und Implentierung von "cA" und "pT" in "pA"
	public static void printAlphabet(PrintWriter out, boolean smallLetters) {
		printText(out,createAlphabet(smallLetters));
	}
	//Implementierung der Methode aus 1a.a)
	public static void printText(PrintWriter out, String Text) {
		out.println(Text);
	}
	//Aufgabe 1c.b)
	public static String createAlphabet(boolean smallLetters) {
		String Alphabet=""; //Zuweisung der Variable "Alphabet" zum Typ "String"
		if(smallLetters) { //Bedingung zur Kleinschreibung des String "Alphabet"
			for(char c='a';c<='z';c++) { //for-Schleife für Kleinschreibung
				Alphabet+=c; Alphabet+=" "; //Ausgabe des String "Alphabet"
			}
		}else { //Bedingung zur Großschreibung des String "Alphabet"
			for(char c='A';c<='Z';c++) { //for-Schleife für Großschreibung
				Alphabet+=c; Alphabet+=" ";
			}
		} return Alphabet; //Rückgabe des String "Alphabet" an "public static"
	}
	//Aufgabe 1c.e)
	public static String createCharSeries(char startChar, int Anzahl){
		System.out.println("***********"); //Zeichen zur Trennung beider Ausgaben
		String Zeichenkette="";
		int count = 0; //Stelle an der der Counter anfangen soll zu zählen
		for(char c=startChar;c<startChar+Anzahl;c++) {
			if((count+1)%10==0|count==Anzahl) {	// "%"=Modulo dividiert den Count durch 10 und sobald Count 10 erreicht und das Ergebnis ("==") als Rest 0 ergibt, wird die if-Bedingung erfüllt
				Zeichenkette+=c;
				Zeichenkette+="\n"; // "\n"=new line initiiert eine neue Zeile
				count++;
			}else {
				Zeichenkette+=c;
				count++;
			}
		} return Zeichenkette;
	}
	//Aufgabe 1c.f) Ausgabe mit der Methode printText und dem PW-Objekt
	public static void printCharSeries(PrintWriter out, char startChar, int Anzahl) {
		printText(out, createCharSeries(startChar, Anzahl));
	}
}