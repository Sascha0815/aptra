package git_aptra.DialogInfoApplicant;

import git_aptra.Oberflaeche;

import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DialogInfoApplicant {
	public static JDialog dialogInfoApplicant = new JDialog(Oberflaeche.frame);
	public static JPanel panelInfoApplicant  = new JPanel();
	public static JLabel labelInfoApplicant  = new JLabel();

	public static void infoApplicant() {
		dialogInfoApplicant.setVisible(true);
		dialogInfoApplicant.setSize(400, 200);
		dialogInfoApplicant.setLocationRelativeTo(null);
		dialogInfoApplicant.setResizable(false);
		dialogInfoApplicant.setTitle("Bewerberinformationen");
		dialogInfoApplicant.add(panelInfoApplicant);
		panelInfoApplicant.add(labelInfoApplicant);
		panelInfoApplicant.setBackground(Color.LIGHT_GRAY);
		labelInfoApplicant
				.setText("Hier folgt die Übersicht eines einzelnen Bewerbers");
	}

}
