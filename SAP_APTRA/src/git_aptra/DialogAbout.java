package git_aptra;

import java.awt.Font;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class DialogAbout {

	private static JDialog dialogAbout = new JDialog(Oberflaeche.frame, true);
	
	private static JPanel panelAbout = new JPanel();
	
	private static JLabel labelAptra = new JLabel("Aptra GmbH & Co.KG");
	private static JLabel labelRights = new JLabel("ALL RIGHTS RESERVED");
	private static JLabel labelVersion = new JLabel("Version: Alpha 1.3.2");	
	private static JLabel labelTeam = new JLabel("Entwicklerteam: Fabian Gierer, Sascha Pfau, Johannes Vollmer");
	
	private static Font fontText = new Font("Calibri", Font.PLAIN, 14);
	
	//METHODE: Über-Dialog
	public static void about() {
		dialogAbout.setSize(370, 120);
		dialogAbout.setResizable(false);
		dialogAbout.setTitle("Über");
		dialogAbout.add(panelAbout);
		panelAbout.setLayout(new MigLayout("", "[]", "[]5[]5[]5[]"));
		labelAptra.setFont(fontText);
		labelRights.setFont(fontText);
		labelTeam.setFont(fontText);
		labelVersion.setFont(fontText);
		panelAbout.add(labelAptra, "cell 0 0, alignx center");
		panelAbout.add(labelTeam, "cell 0 1, alignx center");
		panelAbout.add(labelVersion, "cell 0 2, alignx center");
		panelAbout.add(labelRights, "cell 0 3, alignx center");
		dialogAbout.setLocationRelativeTo(Oberflaeche.frame);
		dialogAbout.setVisible(true);
	}

}
