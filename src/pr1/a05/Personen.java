package pr1.a05;

import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;
//import java.util.Collection;
import schimkat.berlin.lernhilfe2016ws.objectPlay.PersonFactory;
import schimkat.berlin.lernhilfe2016ws.objectPlay.PersonList;
import schimkat.berlin.lernhilfe2016ws.objectPlay.PersonSet;
import schimkat.berlin.lernhilfe2016ws.objectPlay.Person;
import schimkat.berlin.lernhilfe2016ws.io.DirtyFileWriter;
import schimkat.berlin.lernhilfe2016ws.io.DirtyFileReader;

public class Personen {
	
	public static void main (String [] args) {
		Locale.setDefault(Locale.US);
		aufgabeB();
		aufgabeC();
	}

	//für Aufgabe B)
	public static void aufgabeB () {
		PrintWriter out = new PrintWriter(System.out, true);
		PersonList pList = PersonFactory.createTestPersonliste(); //Erzeugung eines Objektes aus der Methode der Klasse PersonFactory
		PersonSet pSet = PersonFactory.createTestPersonSet();
		
		printPersons(pList, out);
		printPersons(pSet, out);	
		printPersons(pSet, "files./PersonSet.txt");
	}
	
	//für Aufgabe C) und D)
	public static void aufgabeC () {
		/*Test der Methoden
		PrintWriter out = new PrintWriter(System.out, true);
		Scanner s = new Scanner(new DirtyFileReader("files./sportfreunde.txt"));
		Scanner k = new Scanner(new DirtyFileReader("files./kommilitonen.txt"));
		out.println(createPerson(k) + "\n");
		out.println(getPersonsFrom(s) + "\n");
		out.println(getPersonsFrom("files./kommilitonen.txt") + "\n");
		out.flush();*/
		
		PersonSet sf = getPersonsFrom("files./sportfreunde.txt");
		PersonSet km = getPersonsFrom("files./kommilitonen.txt");
		PersonSet ps = getPersonsFrom("files./PersonSet.txt");
		PersonSet SundK  = new PersonSet(sf);
		PersonSet KabernichtS = new PersonSet(km);
		PersonSet TvereinigtK = new PersonSet(ps);
		
		SundK.retainAll(km); //bildet die Schnittmenge von "sf" & "km"
		KabernichtS.removeAll(sf); //entfernt alle Elemente die in "sf" stehen
		TvereinigtK.addAll(km); //nimmt die Elemente von "km" auf, die noch nicht "tp" vorkommen

		printPersons(SundK, "listen./SundK.txt");
		printPersons(KabernichtS, "listen./KabernichtS.txt");
		printPersons(TvereinigtK, "listen./TvereinigtK.txt");
	}
	
	//Aufgabe b.1)
	public static void printPersons(PersonList persons, PrintWriter out) {
		out.println("Vorname, Nachname - Geburtsjahr" + "\n" + "-------------------------------");
		for(Person person : persons) { //aus der Klasse "Person", aus der Liste "persons", beziehe Objekt "person"
			out.printf("%1$s, %2$s - %3$d \n", person.getVorname(), person.getNachname(), person.getGeburtsjahr());
		}		
		out.println();
	}
	
	//Aufgabe b.2)
	public static void printPersons(PersonSet persons, PrintWriter out) {
		for(Person person : persons) {
			out.printf("%1$s %2$s %3$d \n", person.getVorname(), person.getNachname(), person.getGeburtsjahr());
		}
		out.println();
	}
	
	//Aufgabe b.3)
	public static void printPersons(PersonSet persons, String filename) {
		PrintWriter fout = new PrintWriter(new DirtyFileWriter(filename));
		printPersons(persons, fout); //Methodenaufruf
		fout.close();	
	}
	
	//Aufgabe c.1)
	public static Person createPerson(Scanner dataSource) {
		String vorname = dataSource.next();
		String nachname = dataSource.next();
		int geburtsjahr = dataSource.nextInt();
		Person person = new Person(vorname, nachname, geburtsjahr);
		return person;
		
		//return new Person(dataSource.next(), dataSource.next(), dataSource.nextInt());
	}

	//Aufgabe c.2)
	public static PersonSet getPersonsFrom(Scanner dataSource) {
		PersonSet pSet = new PersonSet();
		while(dataSource.hasNext()) {
			Person person = new Person(dataSource.next(), dataSource.next(), dataSource.nextInt());
			pSet.add(person); //fügt die neue Person zur Menge hinzu
		} return pSet;
	}
	
	//Aufgabe c.3)
	public static PersonSet getPersonsFrom(String filename){
		Scanner dfr = new Scanner(new DirtyFileReader(filename));
		PersonSet pSet = new PersonSet();
		while(dfr.hasNext()) {
			Person person = new Person(dfr.next(), dfr.next(), dfr.nextInt());
			pSet.add(person);
		} return pSet;
	}								
}	