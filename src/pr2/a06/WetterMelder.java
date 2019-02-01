package pr2.a06;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import schimkat.berlin.lernhilfe2017ss.event.weather.WeatherSymbol;
import schimkat.berlin.lernhilfe2017ss.graphics.DirtyPainter;

public class WetterMelder implements ActionListener {
	public WeatherSymbol wS = new WeatherSymbol(365, 250);
	public DirtyPainter dP = new DirtyPainter();

	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case Wetterzustand.SONNIG:
			wS.changeToSunny();
			break;
		case Wetterzustand.WOLKIG:
			wS.changeToCloudy();
			break;
		case Wetterzustand.BEDECKT:
			wS.changeToOvercast();
			break;
		case Wetterzustand.REGEN:
			wS.changeToRain();
			break;
		case Wetterzustand.GEWITTER:
			wS.changeToTempest();
			break;
		}
		dP.add(wS);
		dP.showDrawing();
	}
}
