package git_aptra;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class Oberflaeche extends JFrame {

	// Swing-Elemente

	private static final long serialVersionUID = 1L;

	public static JFrame frame = new JFrame();

	public static JTabbedPane tabBar = new JTabbedPane(JTabbedPane.TOP,
			JTabbedPane.SCROLL_TAB_LAYOUT);

	

	public Oberflaeche(String title) {

		// Frame anlegen
		super(title);
		frame.setSize(1200, 800);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
		frame.setTitle("Bewerberverwaltung");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.add(tabBar);

		MenuBar.addMenuBar();
		MenuBarPanelOverview.addPanelOverview();
		MenuBarPanelApplicant.addPanelApplicant();
		MenuBarPanelWorkplace.addPanelWorkplace();
	}

	public Oberflaeche() {

	}

}
