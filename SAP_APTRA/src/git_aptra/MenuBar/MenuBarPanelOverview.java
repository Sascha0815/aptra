package git_aptra.MenuBar;

import git_aptra.Oberflaeche;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuBarPanelOverview {
	private static JPanel panelOverview = new JPanel();
	private static JPanel panelButtonOverview = new JPanel();
	private static JPanel panelContentOverview = new JPanel();
	private static JPanel panelInfoOverview = new JPanel();
	private static JLabel labelApplicantPic = new JLabel();

	// legt das Panel Übersicht an
	public static void addPanelOverview() {
		panelOverview.setLayout(new BorderLayout(5, 5));
		panelOverview.add(panelButtonOverview, BorderLayout.EAST);
		panelOverview.add(panelContentOverview, BorderLayout.CENTER);
		panelContentOverview.add(labelApplicantPic);
		labelApplicantPic.setPreferredSize(new Dimension(135, 135));
		panelOverview.add(panelInfoOverview, BorderLayout.SOUTH);
		panelButtonOverview
				.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		panelButtonOverview.setBackground(Color.LIGHT_GRAY);
		panelButtonOverview.setPreferredSize(new Dimension(150, 0));
		panelContentOverview.setBackground(Color.LIGHT_GRAY);
		panelInfoOverview.setBackground(Color.LIGHT_GRAY);
		panelInfoOverview.setPreferredSize(new Dimension(0, 20));
		try {
			Image applicant = ImageIO.read(MenuBar.class
					.getResource("resources/applicant.png"));
			labelApplicantPic.setIcon(new ImageIcon(applicant));
		} catch (IOException ex) {
		}
		Oberflaeche.tabBar.addTab("Übersicht", panelOverview);

	}

}
