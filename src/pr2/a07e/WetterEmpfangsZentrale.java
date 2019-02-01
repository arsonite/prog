package pr2.a07e;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WetterEmpfangsZentrale implements ActionListener {
	protected WetterModel wM;

	public WetterEmpfangsZentrale(WetterModel m) {
		wM = m;
	}

	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		wM.setWetter(Wetterzustand.valueOf(s));
	}
}
