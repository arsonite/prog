package pr2.a09;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SmileyCommand implements ActionListener {
	public SmileyModel m;

	public SmileyCommand(SmileyModel m) {
		this.m = m;
	}

	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		try {
			if (cmd.equals("false")) {
				m.setSmile(false);
			} else if (cmd.equals("true")) {
				m.setSmile(true);
			} else {
				m.setAngle(Double.parseDouble(cmd));
			}
		} catch (Exception exc) {
			exc.printStackTrace(System.out);
		}
	}
}