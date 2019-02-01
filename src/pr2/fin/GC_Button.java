package pr2.fin;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GC_Button extends JPanel {
	private static final long serialVersionUID = -2404086371282120492L;
	
	protected JButton pleased;
	protected JButton sad;
	protected JButton angry;
	protected JButton sick;
	protected JButton possessed;

	public GC_Button(ZentralerController zC) {
		setLayout(new GridLayout(5, 0));

		pleased = new JButton("♩ All you need is smile ♩");
		sad = new JButton("\"SAD\" - Every Donald Trump Tweet ever ");
		angry = new JButton("WHY SO SERIOUS?!?");
		sick = new JButton("reaction to us election 2016");
		possessed = new JButton("Someone call an exorcist!");

		pleased.setActionCommand("JCheckbox_PLEASED");
		sad.setActionCommand("JCheckbox_SAD");
		angry.setActionCommand("JCheckbox_ANGRY");
		sick.setActionCommand("JCheckbox_SICK");
		possessed.setActionCommand("JCheckbox_POSSESSED");

		pleased.addActionListener(zC);	
		sad.addActionListener(zC);
		angry.addActionListener(zC);
		sick.addActionListener(zC);
		possessed.addActionListener(zC);

		add(pleased);
		add(sad);
		add(angry);
		add(sick);
		add(possessed);
		
		setBackground(new Color(255, 182, 193));
	}
}