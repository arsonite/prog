package pr2.a02;

public class IllegalDateException extends Exception {
	
    public IllegalDateException (String s) {
        super(s);
    }

    public String toString(){
        return getMessage();
    }
}