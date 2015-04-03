package git_aptra.SearchVacancy;

import git_aptra.Oberflaeche;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JDialog;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

public class DialogSearchVacancy {
	public static JTabbedPane tabSearchVacancy = new JTabbedPane(JTabbedPane.TOP,
			JTabbedPane.SCROLL_TAB_LAYOUT);
	public static JDialog dialogSearchVacancy = new JDialog(Oberflaeche.frame);	
	
	public static void searchVacancy(){
		dialogSearchVacancy.addWindowListener(new WindowListener() {
	public void windowClosing(WindowEvent arg0) {
	    CloseDialogSearchVacancy.closeSearchVacancy();
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}
	});		
		dialogSearchVacancy.setVisible(true);
		dialogSearchVacancy.setSize(450, 400);
		dialogSearchVacancy.setLocationRelativeTo(null);
		dialogSearchVacancy.setResizable(false);
		dialogSearchVacancy.setTitle("Stellenausschreibung suchen");
		dialogSearchVacancy.add(tabSearchVacancy);
		DialogSearchVacancyGeneral.searchVacancyGeneral();
		DialogSearchVacancySpecification.searchVacancySpecification();	
		SwingUtilities.updateComponentTreeUI(dialogSearchVacancy);		

	}
}
