package pr2.a07;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WetterEmpfangsZentrale implements ActionListener {
	
    public WetterModel wM;
    
    public WetterEmpfangsZentrale(WetterModel model){
        this.wM = model;
    }

    public void actionPerformed(ActionEvent e) {
    	wM.setWetter(e.getActionCommand());
    }
}