package pr2.a06;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WetterPrinter implements ActionListener{
	public long time = System.currentTimeMillis();
	public String message = "Wetternachricht um ";
	
	public void actionPerformed(ActionEvent e) {
		System.out.printf("%s %10s[ms]: %10s \n", message, (e.getWhen()-time), e.getActionCommand());
	}
}
