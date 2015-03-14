package git_aptra.DialogAddApplicant;

import git_aptra.Oberflaeche;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JDialog;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

public class DialogAddApplicant {
	public static JTabbedPane tabAdd = new JTabbedPane(JTabbedPane.TOP,
			JTabbedPane.SCROLL_TAB_LAYOUT);
	public static JDialog dialogNewApplicant = new JDialog(Oberflaeche.frame);	
	
	@SuppressWarnings("static-access")
	public static void newApplicant(){
	dialogNewApplicant.addWindowListener(new WindowListener() {
	public void windowClosing(WindowEvent arg0) {
		CloseDialogApplicant.closeAddApplicant();
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
		dialogNewApplicant.setVisible(true);
		dialogNewApplicant.setSize(450, 400);
		dialogNewApplicant.setLocationRelativeTo(null);
		dialogNewApplicant.setResizable(false);
		dialogNewApplicant.setTitle("Neuer Bewerber");
		dialogNewApplicant.add(tabAdd);
		DialogAddApplicantGeneral.addApplicantGeneral();
		DialogAddApplicantApplication.addApplicantApplication();
		DialogAddApplicantContact.addApplicantContact();		
		SwingUtilities.updateComponentTreeUI(dialogNewApplicant);		

	}
	
	
}
