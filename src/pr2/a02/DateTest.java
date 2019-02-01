package pr2.a02;

import java.io.PrintWriter;

public class DateTest {

    public static void main (String [] args) {
    	
        PrintWriter out = new PrintWriter (System.out, true);
        PrintWriter err = new PrintWriter (System.err, true);

        int [][] DMY = {
    		{91, 1, 1507},
    		{3, 9, 3099},
    		{31, 12, 2017},
    		{26, 10, 1692},
    		{30, 2, 1024},
			{9, 11, 1989},
    		{31, 4 ,2010},
			{1, 9, 1994},
    		{19, 45, 1945}
        };
        
        for (int i = 0; i < DMY.length; i++) {
            try {
                Date date = new Date(DMY[i][0], DMY[i][1], DMY[i][2]);
                out.println("Korrektes Datum: " + date);
            } catch (IllegalDateException ex) {
                err.printf("Falsches Datum: %02d.%02d.%04d -:- %s %n", DMY[i][0], DMY[i][1], DMY[i][2], ex.toString());
            }
        }
    }
}