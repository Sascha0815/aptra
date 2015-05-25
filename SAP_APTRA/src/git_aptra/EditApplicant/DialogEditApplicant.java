package git_aptra.EditApplicant;

import git_aptra.Loading;
import git_aptra.Oberflaeche;

import javax.swing.JDialog;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

public class DialogEditApplicant {
	public static JTabbedPane tabEdit = new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);
	public static JDialog dialogEditApplicant = new JDialog(Oberflaeche.frame);

	public static void editApplicant() {
		Loading.stopWaitCursor(Oberflaeche.frame.getRootPane());
		dialogEditApplicant.setVisible(true);
		dialogEditApplicant.setSize(425,450);
		dialogEditApplicant.setLocationRelativeTo(null);
		dialogEditApplicant.setResizable(false);
		dialogEditApplicant.setTitle("Bewerber bearbeiten");
		dialogEditApplicant.add(tabEdit);
		DialogEditApplicantGeneral.editApplicantGeneral();
		DialogEditApplicantApplication.editApplicantApplication();
		DialogEditApplicantContact.editApplicantContact();
		SwingUtilities.updateComponentTreeUI(dialogEditApplicant);
		dialogEditApplicant.setLocationRelativeTo(Oberflaeche.frame);
	}
}
