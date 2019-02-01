package pr2.a06;

import schimkat.berlin.lernhilfe2017ss.event.Timer;

public class WetterPrinterTest {
	
	public static void main(String[] args) {
		Timer sun = new Timer(5000);
		Timer cloud = new Timer(6000);
		Timer overcast = new Timer(7000);
		Timer rain = new Timer(8000);
		Timer thunder = new Timer(9000);
		
		WetterPrinter wP = new WetterPrinter();

		sun.setActionCommand(Wetterzustand.SONNIG);
		cloud.setActionCommand(Wetterzustand.BEDECKT);
		overcast.setActionCommand(Wetterzustand.WOLKIG);
		rain.setActionCommand(Wetterzustand.REGEN);
		thunder.setActionCommand(Wetterzustand.GEWITTER);
		
		sun.addActionListener(wP);
		cloud.addActionListener(wP);
		overcast.addActionListener(wP);
		rain.addActionListener(wP);
		thunder.addActionListener(wP);

		sun.start();
		cloud.start();
		overcast.start();
		rain.start();
		thunder.start();

		while (true) {
		}
	}
}
