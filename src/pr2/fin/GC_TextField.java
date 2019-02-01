package pr2.fin;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GC_TextField extends JPanel {
	private static final long serialVersionUID = -2031888760744378955L;
	protected JTextField setXPosition;
	protected JTextField setYPosition;
	protected JTextField setSize;
	protected JTextField setAngle;

	public GC_TextField(ZentralerController zC) {
		setLayout(new GridLayout(4, 0));
		JLabel sXP = new JLabel("  Set (x) Position: ");
		JLabel sYP = new JLabel("  Set (y) Position: ");
		JLabel sS = new JLabel("  Set Size: ");
		JLabel sA = new JLabel("  Set Eye Angle: ");
		setXPosition = new JTextField();
		setYPosition = new JTextField();
		setSize = new JTextField();
		setAngle = new JTextField();

		setXPosition.setActionCommand("JTextField_SET_X_POSITION");
		setYPosition.setActionCommand("JTextField_SET_Y_POSITION");
		setSize.setActionCommand("JTextField_SIZE");
		setAngle.setActionCommand("JTextField_ANGLE");

		setXPosition.addActionListener(zC);
		setYPosition.addActionListener(zC);
		setSize.addActionListener(zC);
		setAngle.addActionListener(zC);

		add(sXP);
		add(setXPosition);
		add(sYP);
		add(setYPosition);
		add(sS);
		add(setSize);
		add(sA);
		add(setAngle);

		sXP.setForeground(new Color(255, 255, 255));
		sYP.setForeground(new Color(255, 255, 255));
		sS.setForeground(new Color(255, 255, 255));
		sA.setForeground(new Color(255, 255, 255));

		setBackground(new Color(255, 99, 71));
	}
}