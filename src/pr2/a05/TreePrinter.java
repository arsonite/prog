package pr2.a05;

import java.io.*;

import java.util.Iterator;

import javax.swing.tree.TreeNode;

import pr2.a04.TreeFactory;

import schimkat.berlin.lernhilfe2015ss.tree.*;

public class TreePrinter {
	
	public static void main(String[] args) throws FileNotFoundException {
		PrintWriter out = new PrintWriter (System.out, true);
		QadTree tree = TreeFactory.createTree("./files/tree-02.txt");
		//QadTree tree = TreeFactory.createTree("./files/mytree.txt");

		/*
		Iterator <TreeNode> pO	= QadTreeWalker.postorderIterator(tree);
		Iterator <TreeNode> prO = QadTreeWalker.preorderIterator(tree);
		Iterator <TreeNode> iO	= QadTreeWalker.inorderIterator(tree);
		
		printTree (pO, out);
		printTree (prO, out);
		printTree (iO, out);

		printTree(pO, out, 10, true);
		printTree(prO, out, 15, false);
		printTree(iO, out, 20, true);
		*/
		
		printTree(tree, out, 20);
	}
	
	public static void printTree (Iterator<TreeNode> iterator, PrintWriter out, int width, boolean skipLeafs) {
		while (iterator.hasNext()) {
	        TreeNode n = iterator.next();

            if (skipLeafs && n.isLeaf()) {
                continue;
            }
            
            //out.printf("%-s", n);
            out.printf("%-" + width + "s -	", n); //Parent-Print
            
            for (int i = 0; i < n.getChildCount(); i++) {
                out.printf("%-" + width + "s", n.getChildAt(i)); //Child-Print
            }
            out.println("\n");
        }
	}
	
	public static void printTree (QadTree tree, PrintWriter out, int width) {
		//preorderIterator wird benötigt um das Ausgabe-Format aus Aufgabe 4 zu replizieren
		printTree(QadTreeWalker.preorderIterator(tree), out, width, false);
	}
}