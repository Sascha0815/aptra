package git_aptra.Overview.ShowApplicantInfo;

import git_aptra.Oberflaeche;
import javax.swing.JDialog;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

public class DialogShowApplicantInfo {
	public static JTabbedPane tabAdd = new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);
	public static JDialog dialogNewApplicantInfo = new JDialog(Oberflaeche.frame, true);

	public static void newShowApplicantInfo() {		
		dialogNewApplicantInfo.setSize(425, 440);
		dialogNewApplicantInfo.setLocationRelativeTo(null);
		dialogNewApplicantInfo.setResizable(false);
		dialogNewApplicantInfo.setTitle("Bewerberinformationen");
		dialogNewApplicantInfo.add(tabAdd);
		DialogShowApplicantInfoGeneral.showApplicantInfoGeneral();
		SwingUtilities.updateComponentTreeUI(dialogNewApplicantInfo);
		dialogNewApplicantInfo.setLocationRelativeTo(Oberflaeche.frame);
		dialogNewApplicantInfo.setVisible(true);
	}
}
