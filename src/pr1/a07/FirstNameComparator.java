package pr1.a07;

import java.util.Comparator;

import pr1.a06.Person;

public class FirstNameComparator implements Comparator<Person> {

	public int compare(Person p1, Person p2) {
		String firstName1 = p1.getVorname();
		String firstName2 = p2.getVorname();
		return firstName1.compareTo(firstName2); //Aufsteigende Reihenfolge
		//return firstName2.compareTo(firstName1); //Absteigende Reihenfolge
	}
}
