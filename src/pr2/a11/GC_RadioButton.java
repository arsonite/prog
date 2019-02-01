package pr2.a11;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.Timer;

public class GC_RadioButton extends JPanel {
	private static final long serialVersionUID = -2338716982619943021L;
	
	protected JRadioButton normal;
	protected JRadioButton drugTrip;
	protected JRadioButton eyeRoll;
	

	public GC_RadioButton(ZentralerController zC) {
		setLayout(new GridLayout(3, 0));

		normal = new JRadioButton("\"Normal\"");
		eyeRoll = new JRadioButton("Roll your eyes.");
		drugTrip = new JRadioButton("These aren't just brownies...");
		
		Timer t = new Timer(10, zC);
		Timer t2 = new Timer(100, zC);
		t.setActionCommand("JButton_ROLL");
		t2.setActionCommand("JButton_DRUG_TRIP");
		normal.setActionCommand("JButton_NORMAL");

		//Lambda-Expressions
		normal.addActionListener(zC);
		normal.addActionListener(e -> {
			t.stop();
			t2.stop();
		});
		eyeRoll.addActionListener(e -> {
			t.start();
			t2.stop();
		});
		drugTrip.addActionListener(e -> {
			t.stop();
			t2.start();
		});
		
		ButtonGroup bG = new ButtonGroup();
		bG.add(normal);
		bG.add(eyeRoll);
		bG.add(drugTrip);
		
		add(normal);
		add(eyeRoll);
		add(drugTrip);
		
		normal.setSelected(true);
		
		normal.setForeground(new Color(30, 140, 255));
		eyeRoll.setForeground(new Color(30, 140, 255));
		drugTrip.setForeground(new Color(30, 140, 255));

		setBackground(new Color(255, 160, 122));
	}
}