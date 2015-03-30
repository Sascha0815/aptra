package git_aptra.DialogAddManagement;


import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import git_aptra.Oberflaeche;
import git_aptra.DialogAddApplicant.CloseDialogAddApplicant;

import javax.swing.JDialog;
import javax.swing.SwingUtilities;

public class DialogAddVacancyManagement {
	
	public static JDialog dialogAddVacancyManagement  = new JDialog(Oberflaeche.frame);
	
	public static void addVacancyManagement() {
		dialogAddVacancyManagement.addWindowListener(new WindowListener() {
			public void windowClosing(WindowEvent arg0) {
				CloseDialogAddApplicant.close();
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
	
		dialogAddVacancyManagement.setVisible(true);
		dialogAddVacancyManagement.setSize(450, 500);
		dialogAddVacancyManagement.setLocationRelativeTo(null);
		dialogAddVacancyManagement.setResizable(false);
		dialogAddVacancyManagement.setTitle("Ausschreibung verwalten");
		dialogAddVacancyManagement.add(DialogAddVacancyManagementGeneral.panelDialogManagementMain);
		DialogAddVacancyManagementGeneral.addVacancyManagementGeneral();
	SwingUtilities.updateComponentTreeUI(dialogAddVacancyManagement);
	}
}
