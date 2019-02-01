package pr2.a10;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SmileyController implements ActionListener {
	public SmileyModel m;
	private double angle;

	public SmileyController(SmileyModel m) {
		this.m = m;
	}

	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("false")) {
			m.setSmile(false);
		} else {
			m.setSmile(true);
		} try {
			angle = Double.parseDouble(cmd);
		} catch (Exception exc) {
			angle = 1.0;
		} finally {
			m.setAngle(angle);
		}
	}
}