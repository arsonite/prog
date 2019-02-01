package pr1.a07;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;

import pr1.a06.Person;
/*import schimkat.berlin.lernhilfe2016ws.objectPlay.Person;
import schimkat.berlin.lernhilfe2016ws.objectPlay.PersonList;
import schimkat.berlin.lernhilfe2016ws.objectPlay.PersonSet;*/
import schimkat.berlin.lernhilfe2016ws.objectPlay.PersonFactory;

//Aufgabe 7a)
public class Personen {
	
	public static void main (String [] args) {
		PrintWriter out = new PrintWriter(System.out, true);
		Locale.setDefault(Locale.US);
		ArrayList<Person> pList = createTestPersonList();
		out.println("Sortierung nach Alter: " + "\n" + "----------------------");
		printPersons(Alter(pList),out);
		out.println("Sortierung nach Nachname: " + "\n" + "-------------------------");
		printPersons(Nachname(pList),out);
		out.println("Sortierung nach Vorname: " + "\n" + "------------------------");
		printPersons(Vorname(pList),out);
		
		//printPersons(pList, out);
		//printPersons(pList, out);	
		//printPersons(pList, "files./ArrayList.txt");
		
		/*ArrayList<Person> sf = getPersonsFrom("files./sportfreunde.txt");
		ArrayList<Person> km = getPersonsFrom("files./kommilitonen.txt");
		ArrayList<Person> ps = getPersonsFrom("files./ArrayList.txt");
		ArrayList<Person> SundK  = new ArrayList<Person>(sf);
		ArrayList<Person> KabernichtS = new ArrayList<Person>(km);
		ArrayList<Person> TvereinigtK = new ArrayList<Person>(ps);
		
		SundK.retainAll(km);
		KabernichtS.removeAll(sf);
		TvereinigtK.addAll(km);

		printPersons(SundK, "listen./SundK.txt");
		printPersons(KabernichtS, "listen./KabernichtS.txt");
		printPersons(TvereinigtK, "listen./TvereinigtK.txt");*/
	}
		
	public static void printPersons(ArrayList<Person> persons, PrintWriter out) {
		for(Person person : persons) {
			out.printf("%1$s %2$s %3$d \n", person.getVorname(), person.getNachname(), person.getGeburtsjahr());
		}		
		out.println();
	}
	
	//Ausnahme der Ersetzung durch "ArrayList"
	/*public static void printPersons(HashSet<Person> persons, PrintWriter out) {
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

	public static ArrayList<Person> getPersonsFrom(Scanner dataSource) {
		ArrayList<Person> pSet = new ArrayList<Person>();
		while(dataSource.hasNext()) {
			Person person = new Person(dataSource.next(), dataSource.next(), dataSource.nextInt());
			pSet.add(person);
		} return pSet;
	}
	
	public static ArrayList<Person> getPersonsFrom(String filename){
		Scanner dfr = new Scanner(new DirtyFileReader(filename));
		ArrayList<Person> pSet = new ArrayList<Person>();
		while(dfr.hasNext()) {
			Person person = new Person(dfr.next(), dfr.next(), dfr.nextInt());
			pSet.add(person);
		} return pSet;
	}*/
	
	public static ArrayList<pr1.a06.Person>createTestPersonList(){
		 ArrayList<pr1.a06.Person> list = new ArrayList<pr1.a06.Person>();
		 schimkat.berlin.lernhilfe2016ws.objectPlay.PersonList pList = PersonFactory.createTestPersonliste(); 
		 for(schimkat.berlin.lernhilfe2016ws.objectPlay.Person person : pList){
			Person Person = new Person(person);
			list.add(Person);
		 } return list;
	}
	
	/*public static ArrayList<pr1.a06.Person>createTestPersonSet(){
		 ArrayList<pr1.a06.Person> set = new ArrayList<pr1.a06.Person>();
		 schimkat.berlin.lernhilfe2016ws.objectPlay.PersonSet pSet = PersonFactory.createTestPersonSet(); 
		 for(schimkat.berlin.lernhilfe2016ws.objectPlay.Person person : pSet){
			Person Person = new Person(person);
			set.add(Person);
		 } return set;
	}*/
	
	public static ArrayList<Person> Alter(ArrayList<Person> persons) {
		Comparator<Person> age= new YearComparator();
			persons.sort(age);
			return persons;
		}
	
	public static ArrayList<Person> Nachname(ArrayList<Person> persons) {
		Comparator<Person> surname = new NameComparator();
		persons.sort(surname);
		return persons;
	}
	
	public static ArrayList<Person> Vorname(ArrayList<Person> persons) {
		Comparator<Person> firstname = new FirstNameComparator();
		persons.sort(firstname);
		return persons;
	}
}	