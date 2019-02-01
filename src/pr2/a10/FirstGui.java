package pr2.a10;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.Timer;

public class FirstGui {
    public static void main(String[] args) {
		
        AaPCEventPrinter p = new AaPCEventPrinter();
		SmileyModel m = new SmileyModel();
        FirstSmileyPanel fSP = new FirstSmileyPanel(m);
		SmileyController c = new SmileyController(m);
        
        m.addPropertyChangeListener(fSP);
        m.addPropertyChangeListener(p);
        
        Timer t = new Timer(500, c);
		Timer t2 = new Timer(600, c);
		Timer t3 = new Timer(700, c);
		Timer t4 = new Timer(800, c);
		
		t.setActionCommand("false");
		t2.setActionCommand("true");
		t3.setActionCommand("180");
		t4.setActionCommand("360");
		
		t.addActionListener(p);
		t2.addActionListener(p);
		t3.addActionListener(p);
		t4.addActionListener(p);

		t.start();
		t2.start();
		t3.start();
		t4.start();
        JFrame frame = new JFrame("My \"First\" Gui - Animated Smiley");

		frame.add(fSP);
        frame.setSize(750, 600);
        frame.setVisible(true);
    }
}
