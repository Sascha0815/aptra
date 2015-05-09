package git_aptra.EditVacancyManagement;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import git_aptra.Oberflaeche;

import javax.swing.JDialog;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

public class DialogEditVacancyManagement {
	public static JDialog dialogEditVacancyManagement = new JDialog(
			Oberflaeche.frame);
	public static JTabbedPane tabEditVacancyManagment = new JTabbedPane(
			JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);

	public static void editVacancyManagement() {
		dialogEditVacancyManagement.addWindowListener(new WindowListener() {
			public void windowClosing(WindowEvent arg0) {
				CloseDialogEditVacancyManagement.close();
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
		dialogEditVacancyManagement.setVisible(true);
		dialogEditVacancyManagement.setSize(450, 550);
		dialogEditVacancyManagement.setLocationRelativeTo(null);
		dialogEditVacancyManagement.setResizable(false);
		dialogEditVacancyManagement.setTitle("Arbeitsstellenmanagement");
		dialogEditVacancyManagement.add(tabEditVacancyManagment);
		DialogEditVacancyManagementGeneral.editVacancyManagementGeneral();
		DialogEditVacancyManagementDetails.editVacancyManagementDetails();
		DialogEditVacancyManagementMatrix.editVacancyManagementMatrix();
		DialogEditVacancyManagementResponse.editVacancyManagementResponse();
		DialogEditVacancyManagementHistory.editVacancyManagementHistory();
		SwingUtilities.updateComponentTreeUI(dialogEditVacancyManagement);
	}
}
