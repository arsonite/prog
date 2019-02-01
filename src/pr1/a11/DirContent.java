package pr1.a11;

import java.io.File;
import java.io.PrintWriter;

public class DirContent {
	
	public static void main (String [] args) {
		File[] path = new File[] {new File("./bin/pr1/a06"), new File("./bin/pr1"), new File("./")};
		test(path);
	}
	
	public static void printAll (File path) {
		PrintWriter out = new PrintWriter (System.out, true);
		out.println("Verzeichnis: \t\t" + path.getAbsolutePath()); //"\t" - Tab
		printFilesOnly(path);
		printDirsOnly(path);
		out.println("\n");
	}
	
	public static void printAll (String path) {
		printAll (new File(path));
	}

	public static void printFilesOnly (File path) {
		File[] files = (path.listFiles());
		for(File file: files) {
			if(file.isFile()) { //Überprüfung ob es sich um Datei handelt
				System.out.println("Datei: \t\t\t" + file.getName());
			}
		}
	}
	
	public static void printDirsOnly (File path) {
		File[] files = path.listFiles();
		for(File dir: files) {
			if(dir.isDirectory()) { //Überprüfung ob es sich um ein Verzeichnis handelt
				System.out.println("Unterverzeichnis \t" + dir.getName());
			}
		}
	}
	
	public static void test (File[] path) {
		for(int i = 0; i<path.length; i++) {
			printAll(path[i]);
		}
	}
}
