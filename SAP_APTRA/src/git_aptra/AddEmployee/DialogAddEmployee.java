package git_aptra.AddEmployee;

import git_aptra.Oberflaeche;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JDialog;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

public class DialogAddEmployee {
	public static JTabbedPane tabAdd = new JTabbedPane(JTabbedPane.TOP,
			JTabbedPane.SCROLL_TAB_LAYOUT);
	public static JDialog dialogNewEmployee = new JDialog(Oberflaeche.frame);

	public static void newEmployee() {
		dialogNewEmployee.addWindowListener(new WindowListener() {
			public void windowClosing(WindowEvent arg0) {

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
		dialogNewEmployee.setVisible(true);
		dialogNewEmployee.setSize(420, 420);
		dialogNewEmployee.setLocationRelativeTo(null);
		dialogNewEmployee.setResizable(false);
		dialogNewEmployee.setTitle("Neuer Mitarbeiter");
		dialogNewEmployee.add(tabAdd);
		DialogAddEmployeeGeneral.addEmployeeGeneral();
		SwingUtilities.updateComponentTreeUI(dialogNewEmployee);
		dialogNewEmployee.setLocationRelativeTo(Oberflaeche.frame);

	}
}
