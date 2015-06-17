package git_aptra.Overview.EditApplicant;

import git_aptra.Oberflaeche;
import javax.swing.JDialog;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

public class DialogEditApplicantData {
	public static JTabbedPane tabAdd = new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);
	public static JDialog dialogSelectEditApplicant = new JDialog(Oberflaeche.frame, true);

	public static void editApplicantData() {		
		dialogSelectEditApplicant.setSize(425, 130);
		dialogSelectEditApplicant.setResizable(false);
		dialogSelectEditApplicant.setTitle("Neuer Termin");
		dialogSelectEditApplicant.add(tabAdd);
		DialogSelectApplicant.selectApplicant();
		SwingUtilities.updateComponentTreeUI(dialogSelectEditApplicant);
		dialogSelectEditApplicant.setLocationRelativeTo(Oberflaeche.frame);
		dialogSelectEditApplicant.setVisible(true);
	}
}
