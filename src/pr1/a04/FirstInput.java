package pr1.a04;							

import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;
import schimkat.berlin.lernhilfe2016ws.io.DirtyFileReader;
import schimkat.berlin.lernhilfe2016ws.io.DirtyFileWriter;

public class FirstInput {

	public static void main (String [] args){
		Locale.setDefault(Locale.US);
		scannerAusprobieren();
	}
	
	public static void scannerAusprobieren(){
		//Aufgabe 4.a) Lesen aus String Objekten
		PrintWriter out = new PrintWriter (System.out, true);
		String intNumbers = "10 21 32 43 54 65 76 87 98";
		String i = "intNumbers";
		String doubleNumbers = "1.1 2.2 3.3 4.4 5.5 6.6 7.7 8.8 9.9";
		String d = "doubleNumbers";
		String mixedNumbers = "1 2.3 4 5.67 8 9.1011";
		String m = "mixedNumbers";
		
		Scanner in1 = new Scanner (intNumbers);
		Scanner in2 = new Scanner (doubleNumbers);
		Scanner in3 = new Scanner (mixedNumbers);
		
		printOut (i, in1, out);
		printOut (d, in2, out);
		printOut (m ,in3, out);
		in1.close();
		in2.close();
		in3.close();
		
		//Aufgabe 4.b) Lesen aus Text-Dateien
		Scanner reader = new Scanner (new DirtyFileReader("data./testfiles/zahlen01.txt"));
		String dfr = "DirtyFileReader";
		printOut (dfr, reader, out);
		reader.close();
		
		//Geh�rt zu Aufgabe 4a.1) & 4a.2)
		Scanner count1 = new Scanner (intNumbers);
		Scanner count2 = new Scanner (doubleNumbers);
		Scanner count3 = new Scanner (mixedNumbers);
		out.println("Summe von (intNumbers) = " + countSumOf(count1));
		out.println("Summe von (doubleNumbers) = " + countSumOf(count2));
		out.println("Summe von (mixedNumbers) = " + countSumOf(count3));
		out.println("Summe von (DirtyFileWriter) = " + countSumOf("data./testfiles/zahlen01.txt"));
		System.out.println();
		count1.close();
		count2.close();
		count3.close();
		
		//Geh�rt zur Aufgabe 4a.3)
		String number = "00 11 22 33 44 55 66 77 88 99 100 111 122 133 144 155 166 177 188 199 200";
		Scanner printNumbers = new Scanner (number);
		printNumbersFrom(printNumbers, 10, 1, out);
		printNumbers.close();
		
		//Aufgabe 4b.1)
		Scanner dfr2 = new Scanner (new DirtyFileReader("file./MixedNumberFile.txt"));
		printNumbersFrom(dfr2, 10, 2, out);
		dfr2.close();
		
		//Geh�rt zur Aufgabe 4b.2)
		copyNumberFile("file./MixedNumberFile.txt", 10, 10, "data./testfiles/copiedNumbers");
	}
	
	public static void printOut (String s, Scanner in, PrintWriter out) {
		int count = 1;//Zahlenwert
		out.println("*************");
		out.println(s + "\n" + "-------------");
		while (in.hasNext()){
			if (in.hasNextInt()){ //nach Int-Werten scannen und ausgeben
				out.println(count + ". Zahl: " + in.nextInt());
				count++;
			}else{ //nach Double-Werten scannen und ausgeben
				out.printf(count + ". Zahl: %1.4f \n" ,in.nextDouble());
				count++;
			}
		}
	}
	
	//Aufgabe 4a.1) Summe aller Zahlen aus Scanner
	public static int countSumOf (Scanner in) {
		int sum = 0;
		while (in.hasNext()){
			if (in.hasNextInt()){
				sum = sum + in.nextInt();
			}else{
				int t = (int) in.nextDouble();//int-Typecast
				sum = sum + t;//eigentliche Rechnung
			}
		}
		System.out.println();
		return sum;
	}
	
	//Aufgabe 4a.2) Summe aus Datei
	public static int countSumOf (String filename) {
		Scanner dfr = new Scanner (new DirtyFileReader(filename));
		int i = countSumOf(dfr);//Aufruf der Methode countSumOf
		dfr.close();
		return i;
	}
	
	//Aufgabe 4a.3)
	public static void printNumbersFrom (Scanner in, int width, int precision, PrintWriter out) {
		int count = 0;
		while(in.hasNext()){
			out.printf("%" + width + "." + precision + "f", in.nextDouble());
			count++;
			if (count == 10){
				out.println();
				count = 0;//"Neustart" des Zeilenumbruchs
			}
		} System.out.println("\n");
	}
	
	//Aufgabe 4b.2)
	public static void copyNumberFile (String filenameImport, int width, int precision, String filenameExport) {
		Scanner imp = new Scanner (new DirtyFileReader (filenameImport));//zu importierende Zahlen
		PrintWriter exp = new PrintWriter (new DirtyFileWriter (filenameExport));//zu exportierende Zahlen
		printNumbersFrom(imp, width, precision, exp);
		imp.close();
		exp.close();
	}
}