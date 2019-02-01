package pr2.a06;

import java.awt.event.ActionListener;

import schimkat.berlin.lernhilfe2017ss.event.Timer;

public class WetterMelderTest {
	
	public static void main(String[] args) {
		Timer sun = new Timer(500);
		Timer cloud = new Timer(600);
		Timer overcast = new Timer(700);
		Timer rain = new Timer(800);
		Timer thunder = new Timer(900);
		
		ActionListener wM = new WetterMelder();
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

		sun.addActionListener(wM);
		cloud.addActionListener(wM);
		overcast.addActionListener(wM);
		rain.addActionListener(wM);
		thunder.addActionListener(wM);

		sun.start();
		cloud.start();
		overcast.start();
		rain.start();
		thunder.start();
	}
}
