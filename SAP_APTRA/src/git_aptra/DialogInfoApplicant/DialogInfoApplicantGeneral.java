package git_aptra.DialogInfoApplicant;

import git_aptra.Oberflaeche;
import git_aptra.DialogEditApplicant.DialogEditApplicant;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DialogInfoApplicantGeneral {
	public static JDialog dialogInfoApplicant = new JDialog(Oberflaeche.frame);
	public static JPanel panelInfoApplicantGeneral = new JPanel();
	
	private static JLabel labelName = new JLabel("Name:");
	private static JLabel labelFirstName = new JLabel("Vorname:");
	private static JLabel labelStreet = new JLabel("Straﬂe:");
	private static JLabel labelHouseNr = new JLabel("Hausnummer:");
	private static JLabel labelPostalCode = new JLabel("PLZ:");
	
	private static Font fontHeadline = new Font("Arial", Font.BOLD, 18);
	private static Font fontTextField = new Font("Arial", Font.BOLD, 14);

	public static void infoApplicantGeneral() {
		panelInfoApplicantGeneral.setBackground(Color.LIGHT_GRAY);
		panelInfoApplicantGeneral.setLayout(new BoxLayout(
				panelInfoApplicantGeneral, BoxLayout.Y_AXIS));
		panelInfoApplicantGeneral.add(Box.createRigidArea(new Dimension(0,
				10)));
		panelInfoApplicantGeneral.add(labelName);
		labelName.setFont(fontTextField);
		
		
		
		DialogInfoApplicant.tabInfo.addTab("Allgemein",
				panelInfoApplicantGeneral);
	}
}