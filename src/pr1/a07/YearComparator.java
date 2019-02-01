package pr1.a07;

import java.util.Comparator;

import pr1.a06.Person;

public class YearComparator implements Comparator<Person> {


	public int compare (Person p1, Person p2) {
		//int year1 = p1.getGeburtsjahr();
		//int year2 = p2.getGeburtsjahr();
	    return p1.getGeburtsjahr() - p2.getGeburtsjahr();
	}	
}