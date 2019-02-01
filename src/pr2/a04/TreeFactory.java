package pr2.a04;

import java.io.FileNotFoundException;
import java.io.FileReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import schimkat.berlin.lernhilfe2015ss.tree.QadTree;

public class TreeFactory {

	public static void main (String[] args) throws FileNotFoundException {
		//buildTree();
		createTree("./files/tree").showInGUI();
	}

    public static String[] readLines(String path) throws FileNotFoundException {
		ArrayList<String> ls = new ArrayList<String>();
		
		FileReader reader = new FileReader (path);
		Scanner in = new Scanner(reader);
	    
		try {
			reader = new FileReader(path);
			while (in.hasNextLine()) {
				ls.add(in.nextLine());
			}
		} catch (FileNotFoundException e) {
        	System.err.println(e.toString());
		} finally {
			in.close();
		}

		String[] array = new String[ls.size()];
		ls.toArray(array);
		return array;
    }
    
    public static QadTree createTree(String[] lines) throws FileNotFoundException {
		QadTree tree = new QadTree(lines[0]);
		tree.setLogging(false);
        
		for (String line : lines) { //for-each loop for every line in the string-array "lines"
			//splits the string after every whitespace and puts it into the string array
			String[] s = line.split(" ");
			//the parent of every node is the string in the index 0 at the beginning of every new line
			String parent = s[0];
			//the child is the copy of the range of s-array with the beginning index >0 & <2 till its length
			tree.addChilds(parent, Arrays.copyOfRange(s, 1, s.length));
		}
		return tree;
	}
    
	public static QadTree createTree (String path) throws FileNotFoundException {
		//String[] lines = readLines(path);
		//QadTree tree = createTree(lines);
		return createTree(readLines(path));
    } 
    	
    public static QadTree buildTree () {
		QadTree tree = new QadTree("wurzel");
		tree.setLogging(false);
	    
	    tree.addChilds("wurzel", new String[] { "A", "B", "C", "D" });
	    tree.addChilds("A", new String[] { "A1", "A2", "A3" });
	    tree.addChilds("B", new String[] { "B1", "B2" });
	    tree.addChilds("C", new String[] { "C1", "C2", "C3" });
	    tree.addChilds("D", new String[] { "D1" });
	    tree.addChilds("C2", new String[] { "C2a", "C2b" });
	    
	    tree.showInGUI(10, 10, 300, 500);
	    
		return tree;
	}
}