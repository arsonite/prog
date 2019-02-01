package pr2.a07e;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class WetterModel {

	protected PropertyChangeSupport pcs;
	protected Wetterzustand wetterZustand;

	public WetterModel() {
		pcs = new PropertyChangeSupport(this);
	}
	
	public void setWetter(Wetterzustand wZ) {
		Wetterzustand oldWetterZustand = this.wetterZustand;
		this.wetterZustand = wZ;
		pcs.firePropertyChange("Wetterzustand", oldWetterZustand, wZ);
	}
	
	public Wetterzustand getWetter() {
		return wetterZustand;
	}
	
	public void addPropertyChangeListener(PropertyChangeListener I) {
		pcs.addPropertyChangeListener(I);
	}

	public void removePropertyChangeListener(PropertyChangeListener I) {
		pcs.removePropertyChangeListener(I);
	}

	public void firePropertyChangeEvent(PropertyChangeEvent e) {
		pcs.firePropertyChange(e);
	}
}