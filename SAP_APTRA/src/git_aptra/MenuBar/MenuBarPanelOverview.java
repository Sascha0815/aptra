package git_aptra.MenuBar;

import git_aptra.Oberflaeche;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class MenuBarPanelOverview {
	private static JPanel panelOverview = new JPanel();
	private static JPanel panelContentOverview = new JPanel();

	// SWING: Übersicht-Panel
	public static void addPanelOverview() {
		panelOverview.setLayout(new MigLayout("", "[]"));
		panelOverview.add(panelContentOverview,	"cell 0 0");
		Oberflaeche.tabBar.addTab("Übersicht", panelOverview);

	}

}
