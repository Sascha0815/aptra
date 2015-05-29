package git_aptra.EditVacancyManagement;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.MalformedURLException;

import git_aptra.Loading;
import git_aptra.Oberflaeche;

import javax.swing.JDialog;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class DialogEditVacancyManagement {
	public static JDialog dialogEditVacancyManagement = new JDialog(
			Oberflaeche.frame, true);
	public static JTabbedPane tabEditVacancyManagment = new JTabbedPane(
			JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
	public static void editVacancyManagement() throws MalformedURLException {
		dialogEditVacancyManagement.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		dialogEditVacancyManagement.addWindowListener(new WindowListener() {			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				dialogEditVacancyManagement.dispose();
				DialogEditVacancyManagementMatrix.panelDialogEditVacancyManagementMatrix.removeAll();
				DialogEditVacancyManagementMatrix.resetScore();
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		dialogEditVacancyManagement.setVisible(false);
		dialogEditVacancyManagement.setSize(450,425);
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
		Loading.stopWaitCursor(Oberflaeche.frame.getRootPane());
		dialogEditVacancyManagement.setVisible(true);
		
	}



	
}
