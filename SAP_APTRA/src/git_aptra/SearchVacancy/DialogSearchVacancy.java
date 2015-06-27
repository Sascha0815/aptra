package git_aptra.SearchVacancy;

import git_aptra.Oberflaeche;
import javax.swing.JDialog;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

public class DialogSearchVacancy {
	
	public static JDialog dialogSearchVacancy = new JDialog(Oberflaeche.frame, true);
	
	public static JTabbedPane tabSearchVacancy = new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);
	
	public static void searchVacancy(){	
		dialogSearchVacancy.setSize(425, 450);
		dialogSearchVacancy.setLocationRelativeTo(null);
		dialogSearchVacancy.setResizable(false);
		dialogSearchVacancy.setTitle("Arbeitsstelle suchen");
		dialogSearchVacancy.add(tabSearchVacancy);
		DialogSearchVacancyGeneral.searchVacancyGeneral();
		DialogSearchVacancySpecification.searchVacancySpecification();	
		SwingUtilities.updateComponentTreeUI(dialogSearchVacancy);		
		dialogSearchVacancy.setLocationRelativeTo(Oberflaeche.frame);
		dialogSearchVacancy.setVisible(true);

	}
}
