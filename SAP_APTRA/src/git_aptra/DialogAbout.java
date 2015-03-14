package git_aptra;

import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DialogAbout {

	public static JDialog dialogAbout = new JDialog(Oberflaeche.frame);
	public static JPanel panelAbout = new JPanel();
	public static JLabel labelAbout = new JLabel();

	public static void about() {
		dialogAbout.setVisible(true);
		dialogAbout.setSize(400, 200);
		dialogAbout.setLocationRelativeTo(null);
		dialogAbout.setResizable(false);
		dialogAbout.setTitle("Über");
		dialogAbout.add(panelAbout);
		panelAbout.add(labelAbout);
		panelAbout.setBackground(Color.LIGHT_GRAY);
		labelAbout
				.setText("Entwicklerteam: Fabian Gierer, Sascha Pfau, Johannes Vollmer");
	}

}
