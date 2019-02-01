package pr2.fin;

import java.awt.Color;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;

public class SmileyModel {
	private static final Object EVENT = null;
	protected int x;
	protected int y;
	protected int r;
	protected double angle;
	protected boolean smile;
	protected Color pupilColor;
	protected Color socketColor;
	protected Color faceColor;
	protected PropertyChangeSupport pCS;

	public SmileyModel() {
		this.x = 125;
		this.y = 125;
		this.r = 250;
		this.angle = 0.0;
		this.smile = true;
		this.pupilColor = Color.BLACK;
		this.socketColor = Color.WHITE;
		this.faceColor = Color.YELLOW;
		pCS = new PropertyChangeSupport(this);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
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

	public Color getPupilColor() {
		return pupilColor;
	}

	public Color getSocketColor() {
		return socketColor;
	}

	public Color getFaceColor() {
		return faceColor;
	}

	protected void zustandAendern(Object parameter) {
		pCS.firePropertyChange("MODEL_UPDATE", EVENT, parameter);
	}

	public void addPropertyChangeListener(PropertyChangeListener l) {
		this.pCS.addPropertyChangeListener(l);
	}

	public void removePropertyChangeListener(PropertyChangeListener l) {
		this.pCS.removePropertyChangeListener(l);
	}

	public void moveRelative(int dx, int dy) {
		this.x = x + dx;
		this.y = y + dy;
		zustandAendern(x);
		zustandAendern(y);
	}

	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
		zustandAendern(x);
		zustandAendern(y);
	}
	
	public void setXPosition(int x) {
		this.x = x;
		zustandAendern(x);
	}
	
	public void setYPosition(int y) {
		this.y = y;
		zustandAendern(y);
	}

	public void setSmile(boolean smile) {
		this.smile = smile;
		zustandAendern(smile);
	}

	public void setAngle(double angle) {
		this.angle = angle;
		zustandAendern(angle);
	}

	public void setRadius(int r) {
		this.r = r;
		zustandAendern(r);
	}

	public void setPupilColor(Color pupilColor) {
		this.pupilColor = pupilColor;
		zustandAendern(pupilColor);
	}

	public void setSocketColor(Color socketColor) {
		this.socketColor = socketColor;
		zustandAendern(socketColor);
	}

	public void setFaceColor(Color faceColor) {
		this.faceColor = faceColor;
		zustandAendern(faceColor);
	}
	
	public void grow(int r) {
		this.r = this.r+r;
		zustandAendern(r);
	}
	
	public void shrink(int r) {
		this.r = this.r-r;
		zustandAendern(r);
	}

	public void setPleased() {
		setSmile(true);
		setPupilColor(Color.BLACK);
		setSocketColor(Color.WHITE);
		setFaceColor(Color.YELLOW);
		setAngle(90.0);
	}

	public void setSad() {
		setSmile(false);
		setPupilColor(Color.BLACK);
		setSocketColor(Color.WHITE);
		setFaceColor(Color.YELLOW);
		setAngle(270.0);
	}

	public void setAngry() {
		setSmile(false);
		setAngle(180.0);
		setPupilColor(Color.BLACK);
		setSocketColor(Color.WHITE);
		setFaceColor(Color.ORANGE);
	}

	public void setSick() {
		setSmile(false);
		setAngle(270.0);
		setPupilColor(Color.BLACK);
		setSocketColor(Color.MAGENTA);
		setFaceColor(Color.GREEN);
	}

	public void setPossessed() {
		setSmile(false);
		setAngle(90.0);
		setPupilColor(Color.BLACK);
		setSocketColor(Color.RED);
		setFaceColor(Color.BLACK);
	}

	public void reset() {
		setPupilColor(Color.BLACK);
		setSocketColor(Color.WHITE);
		setFaceColor(Color.YELLOW);
		setAngle(0.0);
		setSmile(true);
	}

	public void drugTrip() {
		Random rnd = new Random();
		Color[] colors = {
				Color.BLACK,
				Color.BLUE,
				Color.RED,
				Color.YELLOW,
				Color.WHITE,
				Color.MAGENTA,
				Color.GREEN,
				Color.ORANGE,
				Color.GRAY};
		setPupilColor(colors[rnd.nextInt(colors.length)]);
		setSocketColor(colors[rnd.nextInt(colors.length)]);
		setFaceColor(colors[rnd.nextInt(colors.length)]);
		setAngle((Math.random()*1000));
	}

	public void rollEyes(double angle) {
		this.angle+= angle;
		setAngle(this.angle);
	}
}