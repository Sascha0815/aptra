package git_aptra.DialogInfoApplicant;

import git_aptra.Oberflaeche;
import git_aptra.DialogEditApplicant.CloseDialogEditApplicant;

import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

public class DialogInfoApplicant {
	public static JDialog dialogInfoApplicant = new JDialog(Oberflaeche.frame);
	public static JTabbedPane tabInfo = new JTabbedPane(JTabbedPane.TOP,
			JTabbedPane.SCROLL_TAB_LAYOUT);

	public static void infoApplicant() {
		dialogInfoApplicant.addWindowListener(new WindowListener() {
			public void windowClosing(WindowEvent arg0) {
				CloseDialogEditApplicant.closeEditApplicant();
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
		dialogInfoApplicant.setSize(400, 500);
		dialogInfoApplicant.setLocationRelativeTo(null);
		dialogInfoApplicant.setResizable(false);
		dialogInfoApplicant.setTitle("Bewerberinformationen");
		dialogInfoApplicant.add(tabInfo);
		DialogInfoApplicantGeneral.infoApplicantGeneral();
		SwingUtilities.updateComponentTreeUI(dialogInfoApplicant);
	}

}
