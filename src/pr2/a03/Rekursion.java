package pr2.a03;										//Günaydin, 853872

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.Scanner;

public class Rekursion {
	
	public static void main (String[] args) throws FileNotFoundException {
		Rekursion rec = new Rekursion();
		
		File file = new File("./files/array.txt");
		
		//test();beuth schim
		rec.test(file);
	}

	public static int[] createArray (Scanner in) {
	
		ArrayList<Integer> l = new ArrayList<Integer>();
		
		while (in.hasNext()) {
			l.add(in.nextInt());
		}
		
		int[] a = new int[l.size()];
		
		for (int i = 0; i < l.size(); i++) {
            a[i] = l.get(i);
		}
		
		in.close();
		return a;
	}
	
	public static int[] createArray (String file) throws FileNotFoundException {

        try {
        	FileReader fr = new FileReader(file);
			Scanner in = new Scanner(fr);
	        return createArray(in);
        } catch (FileNotFoundException e) {
        	System.err.println(e.toString());
        }
        
		return null;
	}
	
	public static int[] createArrayDirectFrom (String stringWithNumbers) {
		Scanner in = new Scanner(stringWithNumbers);
		return createArray(in);
	}
	
	public static void print (int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(i);
		}
	}

    public static int indexOfStandard(int number, int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (number == array[i]) {
                return i;
            }
        }
        return -1;
    }

    public static int indexOfRecursiv(int number, int [] array){
        return indexOfRecursiv(number, array, 0, array.length - 1);
    }

    public static int indexOfRecursiv(int number, int[] array, int startIndex, int endIndex) {
        if (startIndex > endIndex){
            return -1;
        }

        int pivot = (startIndex + endIndex) / 2;
        
        if (array[pivot] == number){
            return pivot;
        } else if (array[pivot] < number) {
            return indexOfRecursiv(number, array, pivot+1, endIndex);
        } else if (array[pivot] > number) {
            return indexOfRecursiv(number, array, startIndex, pivot-1);
        }
        
		return -1;
    }
	
	public static void test () {
		PrintWriter out = new PrintWriter (System.out, true);
		
		String s = "53 249 9120 78340 1082741023";
		String s2 = "1 2 3 4 5 6 7 8 9 10";
		String s3 = "1 2 4 5 10";
		
		out.println("Number at Index: " + indexOfStandard(35981, createArrayDirectFrom(s)));
		out.println("Number at Index: " + indexOfRecursiv(10, createArrayDirectFrom(s2)));
		out.println("Number at Index: " + indexOfRecursiv(10, createArrayDirectFrom(s3), 0, 3));
	}
	
	public void test (File dir) throws FileNotFoundException {
		PrintWriter out = new PrintWriter(System.out, true);
		
		int[] a = createArray(dir.getPath());
		
		for (int i : a) {
			out.println("Number	" + i + "	at Index:	" + indexOfRecursiv(i, a));
		}
	}
}