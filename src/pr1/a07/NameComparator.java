package pr1.a07;

import java.util.Comparator;

import pr1.a06.Person;

public class NameComparator implements Comparator<Person> {

	public int compare(Person p1, Person p2) {
		String lastName1 = p1.getNachname();
		String lastName2 = p2.getNachname();
		return lastName1.compareTo(lastName2); //Aufsteigende Reihenfolge
		//return lastName2.compareTo(lastName1); //Absteigende Reihenfolge
	}
}
