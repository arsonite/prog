package pr2.a07e;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import schimkat.berlin.lernhilfe2017ss.event.weather.WeatherSymbol;
import schimkat.berlin.lernhilfe2017ss.graphics.DirtyPainter;

public class WetterAnsicht implements PropertyChangeListener {

	protected WeatherSymbol wS;
	protected DirtyPainter dP;

	public WetterAnsicht() {
		wS = new WeatherSymbol(365, 250);
		dP = new DirtyPainter();
		dP.add(wS);
		dP.showDrawing();
	}

	public void propertyChange(PropertyChangeEvent evt) {
		switch ((Wetterzustand) evt.getNewValue()) {
		case SONNIG:
			wS.changeToSunny();
			break;
		case WOLKIG:
			wS.changeToCloudy();
			break;
		case BEDECKT:
			wS.changeToOvercast();
			break;
		case REGEN:
			wS.changeToRain();
			break;
		case GEWITTER:
			wS.changeToTempest();
			break;
		}
		dP.showDrawing();
	}
}
