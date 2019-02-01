package pr2.fin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import java.util.Locale;

public class ZentralerController implements ActionListener {
	protected SmileyModel m;
	protected Locale currentLocale;

	static final String SET_X_POSITION = "JTextField_SET_X_POSITION";
	static final String SET_Y_POSITION = "JTextField_SET_Y_POSITION";
	static final String SET_SIZE = "JTextField_SIZE";
	static final String SET_ANGLE = "JTextField_ANGLE";

	static final String PUPIL_COLOR = "JButton_PUPIL_COLOR";
	static final String SOCKET_COLOR = "JButton_SOCKET_COLOR";
	static final String FACE_COLOR = "JButton_FACE_COLOR";

	static final String NO_ACTION = "JButton_NORMAL";
	static final String ACTION_ROLL = "JButton_ROLL";
	static final String ACTION_DRUG_TRIP = "JButton_DRUG_TRIP";

	static final String STATUS_PLEASED = "JCheckbox_PLEASED";
	static final String STATUS_SAD = "JCheckbox_SAD";
	static final String STATUS_ANGRY = "JCheckbox_ANGRY";
	static final String STATUS_SICK = "JCheckbox_SICK";
	static final String STATUS_POSSESSED = "JCheckbox_POSSESSED";

	static final String INCREASE_SIZE = "Increase_SIZE";
	static final String DECREASE_SIZE = "Decrease_SIZE";

	static final String LANGUAGE_GERMAN = "German";
	static final String LANGUAGE_ENGLISH = "English";
	static final String LANGUAGE_ITALIAN = "Italian";

	public ZentralerController(SmileyModel m){
		this.m = m;
		currentLocale = new Locale("en", "US");
	}

	public Locale getLocale(){
		return currentLocale;
	}

	public void setLocale(Locale l){
		currentLocale = l;
	}

	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case SET_X_POSITION:
			m.setXPosition(Integer.parseInt(((JTextField) e.getSource()).getText()));
			break;
		case SET_Y_POSITION:
			m.setYPosition(Integer.parseInt(((JTextField) e.getSource()).getText()));
			break;
		case SET_SIZE:
			m.setRadius(Integer.parseInt(((JTextField) e.getSource()).getText()));
			break;
		case SET_ANGLE:
			m.setAngle(Double.parseDouble(((JTextField) e.getSource()).getText()));
			break;
		case STATUS_PLEASED:
			m.setPleased();
			break;
		case STATUS_SAD:
			m.setSad();
			break;
		case STATUS_ANGRY:
			m.setAngry();
			break;
		case STATUS_SICK:
			m.setSick();
			break;
		case STATUS_POSSESSED:
			m.setPossessed();
			break;
		case NO_ACTION:
			m.reset();
			break;
		case ACTION_ROLL:
			m.rollEyes(5.0);
			break;
		case ACTION_DRUG_TRIP:
			m.drugTrip();
			break;
		case INCREASE_SIZE:
			m.grow(75);
			break;
		case DECREASE_SIZE:
			m.shrink(75);
			break;
		case LANGUAGE_GERMAN:
			setLocale(new Locale("de", "DE"));
			break;
		case LANGUAGE_ENGLISH:
			setLocale(new Locale("en", "US"));
			break;
		case LANGUAGE_ITALIAN:
			setLocale(new Locale("it", "IT"));
		}
	}
}