package git_aptra.EditSelection;

	import git_aptra.Oberflaeche;
	import java.awt.event.WindowEvent;
	import java.awt.event.WindowListener;

	import javax.swing.JDialog;
	import javax.swing.JTabbedPane;
	import javax.swing.SwingUtilities;


	public class DialogEditSelection {

			public static JTabbedPane tabEdit = new JTabbedPane(JTabbedPane.TOP,
					JTabbedPane.SCROLL_TAB_LAYOUT);
			public static JDialog dialogEditSelection = new JDialog(Oberflaeche.frame);

			public static void editSelection() {
				dialogEditSelection.addWindowListener(new WindowListener() {
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
				dialogEditSelection.setVisible(true);
				dialogEditSelection.setSize(420, 420);
				dialogEditSelection.setLocationRelativeTo(null);
				dialogEditSelection.setResizable(false);
				dialogEditSelection.setTitle("Kriterien bearbeiten");
				dialogEditSelection.add(tabEdit);
				DialogEditSelectionGeneral.editSelectionGeneral();
				SwingUtilities.updateComponentTreeUI(dialogEditSelection);
				dialogEditSelection.setLocationRelativeTo(Oberflaeche.frame);

			}
		}


