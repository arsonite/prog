package pr2.a09;

import java.awt.Color;


import schimkat.berlin.lernhilfe2017ss.event.Timer;

public class SmileyTest {

	public static void main(String[] args){
		Timer t = new Timer(500, 100);
		Timer t2 = new Timer(500, 300);
		Timer t3 = new Timer(500, 200);
		Timer t4 = new Timer(500, 400);
		
		SmileyModel m = new SmileyModel(125, 35, 250, 30.0, true, Color.BLACK);
		SmileyView v = new SmileyView(m);	
		SmileyCommand c = new SmileyCommand(m);	

		m.addPropertyChangeListener(v);

		t.setActionCommand("false");
		t2.setActionCommand("true");
		t3.setActionCommand("180");
		t4.setActionCommand("360");

		t.addActionListener(c);
		t2.addActionListener(c);
		t3.addActionListener(c);
		t4.addActionListener(c);

		t.start();
		t2.start();
		t3.start();
		t4.start();
	}
}