package git_aptra;

import javax.swing.JDialog;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

public class DialogAddVacancy {
	public static JDialog dialogNewVacancy = new JDialog(Oberflaeche.frame);
	public static JTabbedPane tabVacancy = new JTabbedPane(JTabbedPane.TOP,
			JTabbedPane.SCROLL_TAB_LAYOUT);
	public static void newVacancy(){
		dialogNewVacancy.setVisible(true);
		dialogNewVacancy.setSize(450, 400);
		dialogNewVacancy.setLocationRelativeTo(null);
		dialogNewVacancy.setResizable(false);
		dialogNewVacancy.setTitle("Neuer Stelle");
		dialogNewVacancy.add(tabVacancy);
		DialogAddVacancyGeneral.addVacancyGeneral();
		DialogAddVacancySpecification.addVacancySpecification();
		SwingUtilities.updateComponentTreeUI(dialogNewVacancy);
	}
}
