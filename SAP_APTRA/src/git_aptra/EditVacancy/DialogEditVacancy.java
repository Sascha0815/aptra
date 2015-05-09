package git_aptra.EditVacancy;

import git_aptra.Oberflaeche;

import javax.swing.JDialog;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

public class DialogEditVacancy {
	public static JDialog dialogEditVacancy = new JDialog(Oberflaeche.frame);
	public static JTabbedPane tabVacancy = new JTabbedPane(JTabbedPane.TOP,
			JTabbedPane.SCROLL_TAB_LAYOUT);

	public static void editVacancy() {
		dialogEditVacancy.setVisible(true);
		dialogEditVacancy.setSize(450, 400);
		dialogEditVacancy.setLocationRelativeTo(null);
		dialogEditVacancy.setResizable(false);
		dialogEditVacancy.setTitle("Stelle bearbeiten");
		dialogEditVacancy.add(tabVacancy);
		DialogEditVacancyGeneral.editVacancyGeneral();
		DialogEditVacancySpecification.editVacancySpecification();
		DialogEditVacancyMeetingSelection.editVacancyHistory();
		SwingUtilities.updateComponentTreeUI(dialogEditVacancy);
	}
}
