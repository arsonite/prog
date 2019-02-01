package pr1.a10;

import java.io.File;
import java.io.PrintWriter;
//import java.io.Serializable;

import java.lang.Character;

import java.util.Scanner;

import schimkat.berlin.lernhilfe2016ws.io.DirtyFileReader;

public class StringUtil {
	
	public static void main (String [] args) {
		PrintWriter out = new PrintWriter(System.out, true);
		out.println("Anzahl von Groﬂbuchstaben: " + countUpperCaseChar(createTestString01()[0]) + "\n"); //Index 0-5, statt 1-6
		out.println("Anteil von Whitespace-Zeichen: " + getRatioWhitespaceToAll(createTestString01()[0]) + "%" + "\n" + "------------------------------------");
		File textfile = new File("files./Strings.txt");
		out.println("Groﬂgeschriebene Buchstaben aus 'Strings.txt': " + countUpperCaseChar(textfile) + "\n");
		out.println("Anteil von Whitespace-Zeichen aus 'Strings.txt': " + getRatioWhitespaceToAll(textfile) + "%" + "\n");
	}
	
	public static int countUpperCaseChar (String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) { //liest von links nach recht, stoppt sobald das Wort zuende gelesen ist
			if (Character.isUpperCase(s.charAt(i))) { //wenn der char, an der Stelle "i", groﬂ ist, wird true ausgegeben
				count++;
			}
		}
		return count;
	}
	
	public static double getRatioWhitespaceToAll (String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (Character.isWhitespace(s.charAt(i))) { //wenn an der Stelle "i", whitespace ist, wird true ausgegeben
				count++;
			}
		}
		double ratio = (double) ((count*100.0) / s.length());
		return ratio;
	}

	public static String[] createTestString01() {
		String[] s = { "Der Die Das", "WiesoWeshalbWarum", "ae ei ou", "hubschrauberlandeplatzaufkleberbeauftragter", "CAPSLETTERS", "a bc def g h ij klmnopqrs tuvw xyz"};
		return s;
	}
	
	public static int countUpperCaseChar (File textfile) {
		DirtyFileReader dfr = new DirtyFileReader(textfile);
		Scanner in = new Scanner(dfr);
		int count = 0;
		while (in.hasNext()) {
			count += countUpperCaseChar(in.next());
		}
		in.close();
		dfr.close();
		return count;
	}
	
	public static double getRatioWhitespaceToAll (File textfile) {
		DirtyFileReader dfr = new DirtyFileReader(textfile);
		Scanner in = new Scanner(dfr);
		double count = 0.0;
		while (in.hasNextLine()) { //Fehlerbehebung aus dem Internet, funktioniert nur mit "hasNextLine"
			count += getRatioWhitespaceToAll(in.nextLine());
		}
		in.close();
		dfr.close();
		return count;
	}
}
