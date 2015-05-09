package git_aptra.EditVacancyManagement;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.MalformedURLException;

import git_aptra.Loading;
import git_aptra.Oberflaeche;
import git_aptra.Login.DialogLogin;
import git_aptra.MenuBar.MenuBarPanelVacancyManagement;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

public class DialogEditVacancyManagement extends Thread {
	public static JDialog dialogEditVacancyManagement = new JDialog(
			Oberflaeche.frame);
	public static JTabbedPane tabEditVacancyManagment = new JTabbedPane(
			JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);

	public static void editVacancyManagement() throws MalformedURLException {
		Loading.start();
		dialogEditVacancyManagement.setVisible(false);
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
		dialogEditVacancyManagement.setSize(450, 550);
		dialogEditVacancyManagement.setLocationRelativeTo(null);
		dialogEditVacancyManagement.setResizable(false);
		dialogEditVacancyManagement.setTitle("Arbeitsstellenmanagement");		
		DialogEditVacancyManagementGeneral.editVacancyManagementGeneral();
		DialogEditVacancyManagementDetails.editVacancyManagementDetails();
		DialogEditVacancyManagementMatrix.editVacancyManagementMatrix();
		DialogEditVacancyManagementResponse.editVacancyManagementResponse();
		DialogEditVacancyManagementHistory.editVacancyManagementHistory();		
		SwingUtilities.updateComponentTreeUI(dialogEditVacancyManagement);
		dialogEditVacancyManagement.add(tabEditVacancyManagment);
		dialogEditVacancyManagement.setVisible(true);
	}
}
