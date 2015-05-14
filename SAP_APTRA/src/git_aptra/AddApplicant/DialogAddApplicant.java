package git_aptra.AddApplicant;

import git_aptra.Oberflaeche;
import javax.swing.JDialog;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

public class DialogAddApplicant {
	public static JTabbedPane tabAdd = new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);
	public static JDialog dialogNewApplicant = new JDialog(Oberflaeche.frame);

	public static void newApplicant() {		
		dialogNewApplicant.setVisible(true);
		dialogNewApplicant.setSize(425, 410);
		dialogNewApplicant.setLocationRelativeTo(null);
		dialogNewApplicant.setResizable(false);
		dialogNewApplicant.setTitle("Neuer Bewerber");
		dialogNewApplicant.add(tabAdd);
		DialogAddApplicantGeneral.addApplicantGeneral();
		DialogAddApplicantApplication.addApplicantApplication();
		DialogAddApplicantContact.addApplicantContact();
		SwingUtilities.updateComponentTreeUI(dialogNewApplicant);
		dialogNewApplicant.setLocationRelativeTo(Oberflaeche.frame);
	}
}
