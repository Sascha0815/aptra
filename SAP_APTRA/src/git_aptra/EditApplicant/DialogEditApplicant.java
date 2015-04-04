package git_aptra.EditApplicant;

import git_aptra.Oberflaeche;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JDialog;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

public class DialogEditApplicant {
	public static JTabbedPane tabEdit = new JTabbedPane(JTabbedPane.TOP,
			JTabbedPane.SCROLL_TAB_LAYOUT);
	public static JDialog dialogEditApplicant = new JDialog(Oberflaeche.frame);

	public static void editApplicant() {
		dialogEditApplicant.addWindowListener(new WindowListener() {
			public void windowClosing(WindowEvent arg0) {
				CloseDialogEditApplicant.close();
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
		dialogEditApplicant.setVisible(true);
		dialogEditApplicant.setSize(450, 500);
		dialogEditApplicant.setLocationRelativeTo(null);
		dialogEditApplicant.setResizable(false);
		dialogEditApplicant.setTitle("Bewerber bearbeiten");
		dialogEditApplicant.add(tabEdit);
		DialogEditApplicantGeneral.editApplicantGeneral();
		DialogEditApplicantApplication.editApplicantApplication();
		DialogEditApplicantContact.editApplicantContact();
		SwingUtilities.updateComponentTreeUI(dialogEditApplicant);
	}
}
