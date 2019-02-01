package pr2.a07e;

import schimkat.berlin.lernhilfe2017ss.event.Timer;

import pr2.a06.Wetterzustand;

public class WetterTest {

    public static void main(String[] args) {
    	Timer sun = new Timer(5000, 1000);
		Timer cloud = new Timer(5000, 2000);
		Timer overcast = new Timer(5000, 3000);
		Timer rain = new Timer(5000, 4000);
		Timer thunder = new Timer(5000, 5000);
		
		WetterAnsicht wA = new WetterAnsicht();
		WetterModel wM = new WetterModel();
		WetterEmpfangsZentrale wEZ = new WetterEmpfangsZentrale(wM);
		
		wM.addPropertyChangeListener(wA);
        
		sun.setActionCommand(Wetterzustand.SONNIG);
		cloud.setActionCommand(Wetterzustand.BEDECKT);
		overcast.setActionCommand(Wetterzustand.WOLKIG);
		rain.setActionCommand(Wetterzustand.REGEN);
		thunder.setActionCommand(Wetterzustand.GEWITTER);
        
        sun.addActionListener(wEZ);
        cloud.addActionListener(wEZ);
        overcast.addActionListener(wEZ);
        rain.addActionListener(wEZ);
        thunder.addActionListener(wEZ);
        
        sun.start();
        cloud.start();
        overcast.start();
        rain.start();
        thunder.start();
    }
}