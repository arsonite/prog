package pr2.a07;

import java.util.LinkedList;

import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class WetterModel {

    public LinkedList<String> wL;
    public PropertyChangeSupport pcs;
    
    public WetterModel() {
    	wL = new LinkedList<String>();
        pcs = new PropertyChangeSupport(this);
    }
    
    public void setWetter(String wetterZustand) {    
    	if (wL.size() > 1){    
            wL.add(wetterZustand);
            pcs.firePropertyChange("Wettermeldung", getWetterZustand(), wetterZustand);
        } else {
        	wL.add(wetterZustand);
        	pcs.firePropertyChange("Wettermeldung", "none", wetterZustand);
        }
    }

	public String getWetterZustand() {
        return wL.getLast();
    }
    
    public LinkedList<String> getWeatherList() {
        return wL;
    }
    
    public void addPropertyChangeListener(PropertyChangeListener l){
    	pcs.addPropertyChangeListener(l);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener l){
    	pcs.removePropertyChangeListener(l);
    }
    
    protected void firePropertyChangeEvent(PropertyChangeEvent e){
    	pcs.firePropertyChange(e);
    }
}