package pr2.a11;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class GUICentral extends JPanel {
	private static final long serialVersionUID = -5577430861059404731L;

	protected ZentralerController zC;
	
	public GUICentral(ZentralerController zC) {
		this.zC = zC;
		
		setLayout(new GridLayout(3, 0));

		add(new GC_TextField(zC));
		add(new GC_Button(zC));
		add(new GC_RadioButton(zC));

		setVisible(true);
	}
}