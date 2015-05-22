package git_aptra.EditVacancyManagement;

import java.net.MalformedURLException;

import git_aptra.Loading;
import git_aptra.Oberflaeche;

import javax.swing.JDialog;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

public class DialogEditVacancyManagement implements Runnable{
	public static JDialog dialogEditVacancyManagement = new JDialog(
			Oberflaeche.frame);
	public static JTabbedPane tabEditVacancyManagment = new JTabbedPane(
			JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
	
	@Override
	public void run() {
		try {
			editVacancyManagement();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		Loading.dialogLoading.setVisible(false);
		}
	
	public static void editVacancyManagement() throws MalformedURLException {
		dialogEditVacancyManagement.setVisible(false);
		dialogEditVacancyManagement.setSize(425,425);
		dialogEditVacancyManagement.setLocationRelativeTo(null);
		dialogEditVacancyManagement.setResizable(false);
		dialogEditVacancyManagement.setTitle("Arbeitsstellenmanagement");
		dialogEditVacancyManagement.add(tabEditVacancyManagment);
		DialogEditVacancyManagementGeneral.editVacancyManagementGeneral();
		DialogEditVacancyManagementDetails.editVacancyManagementDetails();
		try {
			DialogEditVacancyManagementMatrix.editVacancyManagementMatrix();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DialogEditVacancyManagementResponse.editVacancyManagementResponse();
		DialogEditVacancyManagementHistory.editVacancyManagementHistory();
		SwingUtilities.updateComponentTreeUI(dialogEditVacancyManagement);
		dialogEditVacancyManagement.setLocationRelativeTo(Oberflaeche.frame);
		dialogEditVacancyManagement.setVisible(true);
		
	}



	
}
