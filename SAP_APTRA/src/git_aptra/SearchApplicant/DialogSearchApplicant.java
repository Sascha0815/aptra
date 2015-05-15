package git_aptra.SearchApplicant;

import git_aptra.Oberflaeche;
import javax.swing.JDialog;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

public class DialogSearchApplicant {

	public static JTabbedPane tabSearch = new JTabbedPane(JTabbedPane.TOP,
			JTabbedPane.SCROLL_TAB_LAYOUT);
	public static JDialog dialogSearchApplicant = new JDialog(Oberflaeche.frame);

	public static void searchApplicant() {
		dialogSearchApplicant.setVisible(true);
		dialogSearchApplicant.setSize(425, 425);
		dialogSearchApplicant.setLocationRelativeTo(null);
		dialogSearchApplicant.setResizable(false);
		dialogSearchApplicant.setTitle("Bewerber suchen");
		dialogSearchApplicant.add(tabSearch);
		DialogSearchApplicantGeneral.searchApplicantGeneral();
		DialogSearchApplicantApplication.searchApplicantApplication();
		DialogSearchApplicantContact.searchApplicantContact();
		SwingUtilities.updateComponentTreeUI(dialogSearchApplicant);
		dialogSearchApplicant.setLocationRelativeTo(Oberflaeche.frame);

	}
}
