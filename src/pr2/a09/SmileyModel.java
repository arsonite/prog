package pr2.a09;

import java.awt.Color;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SmileyModel {
	protected int x;
	protected int y;
	protected int r;
	protected double angle;
	protected boolean smile;
	protected Color c;
	protected PropertyChangeSupport pCS;

	public SmileyModel(int x, int y, int r, double angle, boolean smile, Color c) {
		this.x = x;
		this.y = y;
		this.r = r;
		this.angle = angle;
		this.smile = smile;
		this.c = c;
		pCS = new PropertyChangeSupport(this);
	}
	
	public void addPropertyChangeListener(PropertyChangeListener l) {
		this.pCS.addPropertyChangeListener(l);
	}
	
	public void removePropertyChangeListener(PropertyChangeListener l) {
		this.pCS.removePropertyChangeListener(l);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Color getColor() {
		return c;
	}
	
	public int getRadius() {
		return r;
	}
	
	public double getAngle() {
		return angle;
	}
	
	public boolean isSmile() {
		return smile;
	}
	
	protected void zustandAendern(Object parameter) {
        pCS.firePropertyChange("MODEL_UPDATE", "EVENT", parameter);
    }
	
	public void setSmile(boolean smile) {
        this.smile = smile;
        zustandAendern(smile);
    }

    public void setAngle(double angle) {
        this.angle = angle;
        zustandAendern(angle);
    }
}
