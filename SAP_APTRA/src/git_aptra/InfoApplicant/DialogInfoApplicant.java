package git_aptra.InfoApplicant;

import git_aptra.Oberflaeche;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JDialog;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

public class DialogInfoApplicant {
	public static JDialog dialogInfoApplicant = new JDialog(Oberflaeche.frame);
	public static JTabbedPane tabInfo = new JTabbedPane(JTabbedPane.TOP,
			JTabbedPane.SCROLL_TAB_LAYOUT);

	public static void infoApplicant() {
		dialogInfoApplicant.addWindowListener(new WindowListener() {
			public void windowClosing(WindowEvent arg0) {
				CloseDialogInfoApplicant.close();
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
		dialogInfoApplicant.setVisible(true);
		dialogInfoApplicant.setSize(425, 500);
		dialogInfoApplicant.setLocationRelativeTo(null);
		dialogInfoApplicant.setResizable(false);
		dialogInfoApplicant.setTitle("Bewerberinformationen");
		dialogInfoApplicant.add(tabInfo);
		DialogInfoApplicantGeneral.infoApplicantGeneral();
		DialogInfoApplicantApplication.infoApplicantApplication();
		DialogInfoApplicantContact.infoApplicantContact();
		DialogInfoApplicantDetails.infoApplicantManagementDetails();
		DialogInfoApplicantHistory.infoApplicantManagementHistory();
		SwingUtilities.updateComponentTreeUI(dialogInfoApplicant);
	}

}
