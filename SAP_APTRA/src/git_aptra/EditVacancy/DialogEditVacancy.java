package git_aptra.EditVacancy;

import git_aptra.Oberflaeche;

import javax.swing.JDialog;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
////Basis des Dialogs zum Bearbeiten von Stellen
public class DialogEditVacancy {
	public static JDialog dialogEditVacancy = new JDialog(Oberflaeche.frame, true);
	public static JTabbedPane tabVacancy = new JTabbedPane(JTabbedPane.TOP,
			JTabbedPane.SCROLL_TAB_LAYOUT);

	public static void editVacancy() {
		dialogEditVacancy.setSize(450, 425);
		dialogEditVacancy.setLocationRelativeTo(Oberflaeche.frame);
		dialogEditVacancy.setResizable(false);
		dialogEditVacancy.setTitle("Stelle bearbeiten");
		dialogEditVacancy.add(tabVacancy);
		DialogEditVacancyGeneral.editVacancyGeneral();
		DialogEditVacancySpecification.editVacancySpecification();
		SwingUtilities.updateComponentTreeUI(dialogEditVacancy);
		dialogEditVacancy.setLocationRelativeTo(Oberflaeche.frame);
		dialogEditVacancy.setVisible(true);
	}
}
