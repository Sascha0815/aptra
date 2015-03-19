package git_aptra.DialogSearch;

import git_aptra.Oberflaeche;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JDialog;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

public class DialogSearchApplicant {

	public static JTabbedPane tabSearch = new JTabbedPane(JTabbedPane.TOP,
			JTabbedPane.SCROLL_TAB_LAYOUT);
	public static JDialog dialogSearchApplicant = new JDialog(Oberflaeche.frame);

	public static void searchApplicant() {
		dialogSearchApplicant.addWindowListener(new WindowListener() {
			public void windowClosing(WindowEvent arg0) {
				CloseDialogSearchApplicant.closeSearchApplicant();
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
		dialogSearchApplicant.setVisible(true);
		dialogSearchApplicant.setSize(450, 400);
		dialogSearchApplicant.setLocationRelativeTo(null);
		dialogSearchApplicant.setResizable(false);
		dialogSearchApplicant.setTitle("Bewerber suchen");
		dialogSearchApplicant.add(tabSearch);
		DialogSearchApplicantGeneral.searchApplicantGeneral();
		DialogSearchApplicantApplication.searchApplicantApplication();
		;
		DialogSearchApplicantContact.searchApplicantContact();
		SwingUtilities.updateComponentTreeUI(dialogSearchApplicant);

	}
}
