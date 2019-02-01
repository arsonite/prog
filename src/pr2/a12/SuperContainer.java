package pr2.a12;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import pr2.a11.AaPCEventPrinter;
import pr2.a10.FirstSmileyPanel;
import pr2.a10.SmileyModel;

public class SuperContainer {

	protected JFrame frame;

	public SuperContainer() {
		frame = new JFrame("Smiley-Generator V3");
		frame.getContentPane().setBackground(Color.YELLOW);
		frame.setBackground(Color.WHITE);
		
		Container c = frame.getContentPane();
		SmileyModel m = new SmileyModel();
		FirstSmileyPanel fSP = new FirstSmileyPanel(m);
		ZentralerController zC = new ZentralerController(m);
		GUICentral gC = new GUICentral(zC);
		
		zC.setLocale(new Locale("de", "DE"));

		JMenuBar menu = new Menu(zC);
		frame.setJMenuBar(menu);

		AaPCEventPrinter eP = new AaPCEventPrinter(m);

		c.setLayout(new BorderLayout());
		
		c.add(fSP, BorderLayout.CENTER);
		c.add(gC, BorderLayout.WEST);

		m.addPropertyChangeListener(fSP);
		m.addPropertyChangeListener(eP);

		fSP.setBackground(new Color(255, 100, 100));

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void display(boolean b) {
		if (b) {
			frame.setVisible(true);
		} else {
			frame.setVisible(false);
		}
	}

	public void setSize(int width, int height) {
		frame.setSize(width, height);
	}
}