package pr2.a07;

import java.beans.PropertyChangeEvent;

import schimkat.berlin.lernhilfe2017ss.graphics.DirtyPainter;
import schimkat.berlin.lernhilfe2017ss.event.weather.WeatherSymbol;

import pr2.a06.Wetterzustand;

public class WetterAnsicht implements java.beans.PropertyChangeListener {

	protected DirtyPainter dP;
	protected WeatherSymbol wS;

	public WetterAnsicht() {
		wS = new WeatherSymbol(365, 250);
		dP = new DirtyPainter();
		dP.add(wS);
		dP.showDrawing();
	}

	public void propertyChange(PropertyChangeEvent e) {
		switch (e.getNewValue().toString()) {
		case(Wetterzustand.BEDECKT):
			wS.changeToOvercast();
			break;
		case(Wetterzustand.GEWITTER):
			wS.changeToTempest();
			break;
		case(Wetterzustand.REGEN):
			wS.changeToRain();
			break;
		case(Wetterzustand.SONNIG):
			wS.changeToSunny();
			break;
		case(Wetterzustand.WOLKIG):
			wS.changeToCloudy();
			break;
		}
		dP.showDrawing();
	}
}
