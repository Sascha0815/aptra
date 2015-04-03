package git_aptra.EditVacancyManagement;

import git_aptra.Oberflaeche;

import javax.swing.JDialog;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

public class DialogEditVacancyManagement {
	public static JDialog dialogEditVacancyManagement = new JDialog(Oberflaeche.frame);
	public static JTabbedPane tabEditVacancyManagment = new JTabbedPane(JTabbedPane.TOP,
			JTabbedPane.SCROLL_TAB_LAYOUT);
	
	public static void editVacancyManagement() {
		dialogEditVacancyManagement.setVisible(true);
		dialogEditVacancyManagement.setSize(450, 550);
		dialogEditVacancyManagement.setLocationRelativeTo(null);
		dialogEditVacancyManagement.setResizable(false);
		dialogEditVacancyManagement.setTitle("Arbeitsstellenmanagement");
		dialogEditVacancyManagement.add(tabEditVacancyManagment);
		DialogEditVacancyManagementGeneral.editVacancyManagementGeneral();
		SwingUtilities.updateComponentTreeUI(dialogEditVacancyManagement);
	}
}
