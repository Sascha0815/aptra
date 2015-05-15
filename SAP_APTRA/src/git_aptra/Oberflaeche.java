package git_aptra;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import git_aptra.Meeting.OpenMeeting;
import git_aptra.MenuBar.MenuBar;
import git_aptra.MenuBar.MenuBarPanelApplicant;
import git_aptra.MenuBar.MenuBarPanelMeeting;
import git_aptra.MenuBar.MenuBarPanelOverview;
import git_aptra.MenuBar.MenuBarPanelVacancyManagement;
import git_aptra.MenuBar.MenuBarPanelVacancy;

public class Oberflaeche extends JFrame {

	//SWING-ELEMENTE:

	private static final long serialVersionUID = 1L;

	public static JFrame frame = new JFrame();

	public static JTabbedPane tabBar = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);

	public Oberflaeche() {
		// Frame anlegen
		frame.setSize(1200, 800);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
		frame.setTitle("aptra - Bewerberverwaltung");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.add(tabBar);
		java.awt.Image im = Toolkit.getDefaultToolkit().getImage("resources/FrameIconSmall.gif");
		frame.setIconImage(im);

		//Panels der MenuBar hinzufügen
		MenuBar.addMenuBar();
		MenuBarPanelOverview.addPanelOverview();
		MenuBarPanelApplicant.addPanelApplicant();
		MenuBarPanelVacancy.addPanelWorkplace();
		MenuBarPanelVacancyManagement.addPanelVacancyManagement();
		MenuBarPanelMeeting.addPanelEmployeeMeeting();
		OpenMeeting.insertInfo();

	}

	

}
