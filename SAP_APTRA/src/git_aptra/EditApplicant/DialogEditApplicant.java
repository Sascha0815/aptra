package git_aptra.EditApplicant;

import git_aptra.Oberflaeche;

import javax.swing.JDialog;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

//Basis des Dialogs zum Bearbeiten von Bewerbern
public class DialogEditApplicant {
	public static JTabbedPane tabEdit = new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);
	public static JDialog dialogEditApplicant = new JDialog(Oberflaeche.frame, true);

	public static void editApplicant() {
		dialogEditApplicant.setSize(425,450);
		dialogEditApplicant.setLocationRelativeTo(Oberflaeche.frame);
		dialogEditApplicant.setResizable(false);
		dialogEditApplicant.setTitle("Bewerber bearbeiten");
		dialogEditApplicant.add(tabEdit);
		DialogEditApplicantGeneral.editApplicantGeneral();
		DialogEditApplicantApplication.editApplicantApplication();
		DialogEditApplicantContact.editApplicantContact();
		SwingUtilities.updateComponentTreeUI(dialogEditApplicant);
		dialogEditApplicant.setLocationRelativeTo(Oberflaeche.frame);
		dialogEditApplicant.setVisible(true);
	}
}
