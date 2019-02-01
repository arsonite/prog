package pr1.a06;

import java.io.PrintWriter;
import java.util.Locale;
import pr1.a06.Person;
//import schimkat.berlin.lernhilfe2016ws.objectPlay.Person;

//Aufgabe 6c)
public class PersonTest {

	public static void main(String [] args) {
		PrintWriter out = new PrintWriter (System.out, true);
		Locale.setDefault(Locale.US);
		Person person = new Person ("Harald", "Abolfazel", 1969);
		Person pCopy = new Person (person);
		Person pImp = new Person (new schimkat.berlin.lernhilfe2016ws.objectPlay.Person("Burak", "Günaydin", 1994));

		out.println("Ausgabe durch 'toString': " + "\n" + "-------------------------");
		out.print(pImp.toString());
		out.println("\n");
		
		out.println(pCopy.toString());
		out.println("\n" + "*************************" + "\n");
		
		String vorname = person.getVorname();
		String nachname = person.getNachname();
		int geburtsjahr = person.getGeburtsjahr();
		out.printf("Ausgabe mithilfe von 'get': " + "%n" + "-------------------------" + "%n" + "%1$s._.%2$s_-_%3$d", vorname, nachname, geburtsjahr);
	}
}
