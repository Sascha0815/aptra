package git_aptra.MenuBar;

import git_aptra.Oberflaeche;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MenuBarPanelOverview {
	private static JPanel panelOverview = new JPanel();
	private static JPanel panelContentOverview = new JPanel();
	private static JPanel panelInfoOverview = new JPanel();
	private static JLabel imageLabel = new JLabel();


	// SWING: �bersicht-Panel
	public static void addPanelOverview() {
		panelOverview.setLayout(new BorderLayout(5, 5));
		panelOverview.add(panelContentOverview, BorderLayout.CENTER);
		panelOverview.add(panelInfoOverview, BorderLayout.SOUTH);
		panelContentOverview.setBackground(Color.LIGHT_GRAY);
		panelInfoOverview.setBackground(Color.LIGHT_GRAY);
		panelInfoOverview.setPreferredSize(new Dimension(0, 20));
		Oberflaeche.tabBar.addTab("�bersicht", panelOverview);

	}

}





