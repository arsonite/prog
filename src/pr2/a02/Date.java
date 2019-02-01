package pr2.a02;

public class Date {
	
    protected int day;
    protected int month;
    protected int year;

    public Date (int day, int month, int year) throws IllegalDateException {
        this.day = day;
        this.month = month;
        this.year = year;

        boolean b;
        
        if (month==4 || month==6 || month==9 || month==11) {
            b = true;
        } else {
            b = false;
        }

        if (b && day>30) {
            throw new IllegalDateException("Unzulässiger Tag [>30]");
        }

        if (b == false && day>31) {
            throw new IllegalDateException("Unzulässiger Tag [>31]");
        }

        if (year > 2017) {
            throw new IllegalDateException("Unzulässiges Jahr [0-2017]");
        }

        if (month > 12) {
            throw new IllegalDateException("Unzulässiger Monat [>12]");
        }

        if (month==2 && day>28) {
            throw new IllegalDateException("Unzulässiger Tag [>28] - Der Februar hat nur 28 Tage (Schaltjahr ausgenommen)");
        }
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String toString () {
        return String.format("%02d.%02d.%04d", day, month, year);
    }
}