package pr2.a11;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import pr2.a10.SmileyModel;

public class AaPCEventPrinter implements ActionListener, PropertyChangeListener {

	private SmileyModel m;
	private boolean smile;
	private double angle;
	
	public AaPCEventPrinter(SmileyModel m){
		this.m = m;
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.printf("Aenderung um %15s%n", e.getActionCommand());
		System.out.printf("Laecheln: %s Winkel: %f%n", Boolean.toString(smile), angle);
		System.out.printf("Durchmesser: %d Winkel: %f%n", m.getRadius(), m.getAngle());
	}

	public void propertyChange(PropertyChangeEvent pce) {
		System.out.printf("%n Aenderung um %15s%n", pce.getNewValue());
		System.out.printf("Laecheln: %s Winkel: %f%n", Boolean.toString(smile), angle);
		System.out.printf("Durchmesser: %d Winkel: %f%n", m.getRadius(), m.getAngle());
	}
}
