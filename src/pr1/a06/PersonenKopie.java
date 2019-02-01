package pr1.a06;

import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;
import java.util.Collection;

import java.util.ArrayList;
import java.util.HashSet;

/*import schimkat.berlin.lernhilfe2016ws.objectPlay.Person;
import schimkat.berlin.lernhilfe2016ws.objectPlay.PersonList;
import schimkat.berlin.lernhilfe2016ws.objectPlay.PersonSet;*/
import schimkat.berlin.lernhilfe2016ws.objectPlay.PersonFactory;
import schimkat.berlin.lernhilfe2016ws.io.DirtyFileWriter;
import schimkat.berlin.lernhilfe2016ws.io.DirtyFileReader;

//Aufgabe 6d)
public class PersonenKopie {
	
	public static void main (String [] args) {
		Locale.setDefault(Locale.US);
		aufgabeB();
		aufgabeC();
	}

	public static void aufgabeB () {
		PrintWriter out = new PrintWriter(System.out, true);
		ArrayList<Person> pList = createTestPersonList();
		HashSet<Person> pSet = createTestPersonSet();
		
		printPersons(pList, out);
		printPersons(pSet, out);	
		printPersons(pSet, "files./HashSet.txt");
	}
	
	public static void aufgabeC () {
		HashSet<Person> sf = getPersonsFrom("files./sportfreunde.txt");
		HashSet<Person> km = getPersonsFrom("files./kommilitonen.txt");
		HashSet<Person> ps = getPersonsFrom("files./HashSet.txt");
		HashSet<Person> SundK  = new HashSet<Person>(sf);
		HashSet<Person> KabernichtS = new HashSet<Person>(km);
		HashSet<Person> TvereinigtK = new HashSet<Person>(ps);
		
		SundK.retainAll(km);
		KabernichtS.removeAll(sf);
		TvereinigtK.addAll(km);

		printPersons(SundK, "listen./SundK.txt");
		printPersons(KabernichtS, "listen./KabernichtS.txt");
		printPersons(TvereinigtK, "listen./TvereinigtK.txt");
	}
	
	public static void printPersons(ArrayList<Person> persons, PrintWriter out) {
		out.println("Vorname, Nachname - Geburtsjahr" + "\n" + "-------------------------------");
		for(Person person : persons) {
			out.printf("%1$s, %2$s - %3$d \n", person.getVorname(), person.getNachname(), person.getGeburtsjahr());
		}		
		out.println();
	}
	
	public static void printPersons(HashSet<Person> persons, PrintWriter out) {
		for(Person person : persons) {
			out.printf("%1$s %2$s %3$d \n", person.getVorname(), person.getNachname(), person.getGeburtsjahr());
		}
		out.println();
	}
	
	public static void printPersons(HashSet<Person> persons, String filename) {
		PrintWriter fout = new PrintWriter(new DirtyFileWriter(filename));
		printPersons(persons, fout);
		fout.close();	
	}
	
	public static Person createPerson(Scanner dataSource) {
		return new Person(dataSource.next(), dataSource.next(), dataSource.nextInt());
	}

	public static HashSet<Person> getPersonsFrom(Scanner dataSource) {
		HashSet<Person> pSet = new HashSet<Person>();
		while(dataSource.hasNext()) {
			Person person = new Person(dataSource.next(), dataSource.next(), dataSource.nextInt());
			pSet.add(person);
		} return pSet;
	}
	
	public static HashSet<Person> getPersonsFrom(String filename){
		Scanner dfr = new Scanner(new DirtyFileReader(filename));
		HashSet<Person> pSet = new HashSet<Person>();
		while(dfr.hasNext()) {
			Person person = new Person(dfr.next(), dfr.next(), dfr.nextInt());
			pSet.add(person);
		} return pSet;
	}
	
	//Aufgabe 6e)
	public static ArrayList<pr1.a06.Person>createTestPersonList(){
		 ArrayList<pr1.a06.Person> list = new ArrayList<pr1.a06.Person>();
		 schimkat.berlin.lernhilfe2016ws.objectPlay.PersonList pList = PersonFactory.createTestPersonliste(); 
		 for(schimkat.berlin.lernhilfe2016ws.objectPlay.Person person : pList){
			Person Person = new Person(person);
			list.add(Person);
		 } return list;
	}
	
	public static HashSet<pr1.a06.Person>createTestPersonSet(){
		 HashSet<pr1.a06.Person> set = new HashSet<pr1.a06.Person>();
		 schimkat.berlin.lernhilfe2016ws.objectPlay.PersonSet pSet = PersonFactory.createTestPersonSet(); 
		 for(schimkat.berlin.lernhilfe2016ws.objectPlay.Person person : pSet){
			Person Person = new Person(person);
			set.add(Person);
		 } return set;
	}
}	