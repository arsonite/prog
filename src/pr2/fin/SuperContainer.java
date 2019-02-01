package pr2.fin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

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

		c.setLayout(new BorderLayout());
		
		c.add(fSP, BorderLayout.CENTER);
		c.add(gC, BorderLayout.WEST);

		m.addPropertyChangeListener(fSP);

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