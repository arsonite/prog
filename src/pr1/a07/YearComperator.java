package pr1.a07;

import java.util.Comparator;

import pr1.a06.Person;

public class YearComperator implements Comparator<Person> {


	public int compare (Person p1, Person p2) {
		int year1 = p1.getGeburtsjahr();
		int year2 = p2.getGeburtsjahr();
	       if (year1 > year2) { //
	           return -1; //Aufsteigende Reihenfolge falls 1
	       } else {
	    	   return 1; //Aufsteigende Reihenfole falls -1
	       }
	}
}