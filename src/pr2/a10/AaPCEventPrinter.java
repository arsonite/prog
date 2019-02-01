package pr2.a10;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AaPCEventPrinter implements PropertyChangeListener, ActionListener {
	public long currentTime = System.currentTimeMillis();
	public long time;
	public ActionEvent e;
	public String s = "ActionEvent empfangen nach	";
	public String s2 = "PropertyChangeEvent nach	";
	public String s3 = "liefert ";

	public void actionPerformed(ActionEvent e) {
		this.e = e;
		time = (e.getWhen() - currentTime);
		System.out.printf("%s %10s[ms]: %s %n", s, time, e.getActionCommand());
	}

	public void propertyChange(PropertyChangeEvent evt) {
		time = (e.getWhen() - currentTime);
		System.out.printf("%s %10s[ms]: %s %s %s %n %n", s2, time, evt.getPropertyName(), s3, evt.getNewValue());
	}
}