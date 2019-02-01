package pr2.fin;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.Timer;

public class Menu extends JMenuBar {

	private static final long serialVersionUID = 5861833218236610976L;

	public Menu(ZentralerController zC) {
		ResourceBundle rB = ResourceBundle.getBundle("pr2.ressources.Locale", zC.getLocale());

		JMenu file = new JMenu(rB.getString("FILE"));
		JMenu smiley = new JMenu(rB.getString("SMILEY"));
		JMenu language = new JMenu(rB.getString("LANGUAGE"));

		add(file);
		add(smiley);
		add(language);
		
		JRadioButtonMenuItem de = new JRadioButtonMenuItem(rB.getString("GERMAN"));
		JRadioButtonMenuItem en = new JRadioButtonMenuItem(rB.getString("ENGLISH"));
		JRadioButtonMenuItem it = new JRadioButtonMenuItem(rB.getString("ITALIAN"));
		
		language.add(de);
		language.add(en);
		language.add(it);

		JMenuItem save = new JMenuItem(rB.getString("SAVE"));
		JMenuItem load = new JMenuItem(rB.getString("LOAD"));
		JMenuItem exit = new JMenuItem(rB.getString("EXIT"));

		file.add(save);
		file.add(load);
		file.add(exit);

		JMenu size = new JMenu(rB.getString("SIZE"));

		JRadioButtonMenuItem happy = new JRadioButtonMenuItem(rB.getString("HAPPY"));
		JRadioButtonMenuItem sad = new JRadioButtonMenuItem(rB.getString("SAD"));
		JRadioButtonMenuItem sick = new JRadioButtonMenuItem(rB.getString("SICK"));
		JRadioButtonMenuItem angry = new JRadioButtonMenuItem(rB.getString("ANGRY"));
		JRadioButtonMenuItem possessed = new JRadioButtonMenuItem(rB.getString("POSSESSED"));
		
		JMenuItem roll = new JMenuItem(rB.getString("ROLL"));
		JMenuItem drugtrip = new JMenuItem(rB.getString("DRUGTRIP"));
		JMenuItem normal = new JMenuItem(rB.getString("NORMAL"));

		ButtonGroup bG = new ButtonGroup();
		bG.add(happy);
		bG.add(sad);
		bG.add(sick);
		bG.add(angry);
		bG.add(possessed);
		
		ButtonGroup bG_2 = new ButtonGroup();
		bG_2.add(roll);
		bG_2.add(drugtrip);
		bG_2.add(normal);
		
		ButtonGroup bG_3 = new ButtonGroup();
		bG_3.add(de);
		bG_3.add(en);
		bG_3.add(it);
		
		normal.isSelected();

		smiley.add(size);
		smiley.addSeparator();
		smiley.add(happy);
		smiley.add(sad);
		smiley.add(sick);
		smiley.add(angry);
		smiley.add(possessed);
		smiley.addSeparator();
		smiley.add(roll);
		smiley.add(drugtrip);
		smiley.add(normal);

		JMenuItem sizePlus = new JMenuItem(rB.getString("INCREASE"));
		JMenuItem sizeMinus = new JMenuItem(rB.getString("DECREASE"));

		size.add(sizePlus);
		size.add(sizeMinus);

		happy.addActionListener(zC);
		sad.addActionListener(zC);
		sick.addActionListener(zC);
		angry.addActionListener(zC);
		possessed.addActionListener(zC);
		sizePlus.addActionListener(zC);
		sizeMinus.addActionListener(zC);
		de.addActionListener(zC);
		en.addActionListener(zC);
		it.addActionListener(zC);
		
		Timer t = new Timer(10, zC);
		Timer t2 = new Timer(100, zC);
		t.setActionCommand("JButton_ROLL");
		t2.setActionCommand("JButton_DRUG_TRIP");
		normal.setActionCommand("JButton_NORMAL");
		normal.addActionListener(zC);
		normal.addActionListener(e -> {
			t.stop();
			t2.stop();
		});
		roll.addActionListener(e -> {
			t.start();
			t2.stop();
		});
		drugtrip.addActionListener(e -> {
			t.stop();
			t2.start();
		});

		happy.setActionCommand("JCheckbox_PLEASED");
		sad.setActionCommand("JCheckbox_SAD");
		sick.setActionCommand("JCheckbox_SICK");
		angry.setActionCommand("JCheckbox_ANGRY");
		possessed.setActionCommand("JCheckbox_POSSESSED");
		sizePlus.setActionCommand("Increase_SIZE");
		sizeMinus.setActionCommand("Decrease_SIZE");
		de.setActionCommand("German");
		en.setActionCommand("English");
		it.setActionCommand("Italian");
		
		de.setSelected(true);
		normal.setSelected(true);
		happy.setSelected(true);

		zC.setLocale(new Locale("de", "DE"));
		
		validate();
		repaint();
	}
}
