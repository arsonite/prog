package pr1.a06;

//import schimkat.berlin.lernhilfe2016ws.objectPlay.Person;

//Aufgabe 6a)
public class Person {
	private String vorname;
	private String nachname;
	private int geburtsjahr;
	
	public Person (String vorname, String nachname, int geburtsjahr) { //Vollständiger Konstruktor
		this.vorname = vorname;
		this.nachname = nachname;
		this.geburtsjahr = geburtsjahr;
	}
	
	public Person (Person other) { //Copy-Konstruktor
		this(other.vorname, other.nachname, other.geburtsjahr);
	}
	
	public Person (schimkat.berlin.lernhilfe2016ws.objectPlay.Person imP) {	//Typkonvertierungskonstruktor
		this(imP.getVorname(), imP.getNachname(), imP.getGeburtsjahr());
	}
	
	//Getter-Methoden für alle Klassenattribute
	public String getVorname() {
		return vorname;
	}
	
	public String getNachname() {
		return nachname;
	}
	
	public int getGeburtsjahr() {
		return geburtsjahr;
	}
	
	public String toString() { //Darstellung als Zeichenkette
		return String.format("%1$s, %2$s - %3$d", vorname, nachname, geburtsjahr);		
	}
	
	//Aufgabe 6b) Erzeugung von hashCode() & equals()
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + geburtsjahr;
		result = prime * result + ((nachname == null) ? 0 : nachname.hashCode());
		result = prime * result + ((vorname == null) ? 0 : vorname.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (geburtsjahr != other.geburtsjahr)
			return false;
		if (nachname == null) {
			if (other.nachname != null)
				return false;
		} else if (!nachname.equals(other.nachname))
			return false;
		if (vorname == null) {
			if (other.vorname != null)
				return false;
		} else if (!vorname.equals(other.vorname))
			return false;
		return true;
	}
}
