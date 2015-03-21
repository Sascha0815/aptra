package git_aptra.MenuBar;

import git_aptra.DialogAbout;
import git_aptra.ChangeDesign;
import git_aptra.Oberflaeche;
import git_aptra.DialogAddApplicant.DialogAddApplicant;
import git_aptra.DialogAddVacancy.DialogAddVacancy;
import git_aptra.DialogApplicantSearch.DialogSearchApplicant;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar {
	private static JMenuBar menuBar = new JMenuBar();
	private static JMenu menuNew = new JMenu();
	private static JMenu menuHelp = new JMenu();
	private static JMenu menuSettings = new JMenu();

	private static JMenuItem itemApplicant = new JMenuItem();
	private static JMenuItem itemJob = new JMenuItem();
	private static JMenuItem itemSearch = new JMenuItem();
	private static JMenuItem itemAbout = new JMenuItem();
	private static JMenuItem itemExit = new JMenuItem();
	private static JMenuItem itemChangeDesign = new JMenuItem();

	// SWING: MenuBar mit Reitern, Einträgen und ActionListenern
	public static void addMenuBar() {
		// MenuBar
		Oberflaeche.frame.setJMenuBar(menuBar);

		// MenuNew
		menuBar.add(menuNew);
		menuNew.setText("Neu");
		menuNew.add(itemApplicant);
		itemApplicant.setText("Neuer Bewerber");
		try {
			Image plus = ImageIO.read(MenuBar.class
					.getResource("resources/plus.png"));
			itemApplicant.setIcon(new ImageIcon(plus));
		} catch (IOException ex) {
		}
		itemApplicant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogAddApplicant.newApplicant();
			}
		});
		menuNew.add(itemJob);
		itemJob.setText("Neues Stellenangebot");
		try {
			Image job = ImageIO.read(MenuBar.class
					.getResource("resources/job_small.png"));
			itemJob.setIcon(new ImageIcon(job));
		} catch (IOException ex) {
		}
		itemJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogAddVacancy.newVacancy();
			}
		});
		menuNew.add(itemSearch);
		itemSearch.setText("Bewerber suchen");
		try {
			Image close = ImageIO.read(MenuBar.class
					.getResource("resources/search_small.png"));
			itemSearch.setIcon(new ImageIcon(close));
		} catch (IOException ex) {
		}
		itemSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogSearchApplicant.searchApplicant();
			}
		});
		menuNew.add(itemExit);
		itemExit.setText("Beenden");
		try {
			Image close = ImageIO.read(MenuBar.class
					.getResource("resources/close.png"));
			itemExit.setIcon(new ImageIcon(close));
		} catch (IOException ex) {
		}
		itemExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Oberflaeche.frame.dispose();
			}
		});

		// MenuSettings
		menuBar.add(menuSettings);
		menuSettings.setText("Einstellungen");
		menuSettings.add(itemChangeDesign);
		itemChangeDesign.setText("Desgin ändern");
		try {
			Image settings = ImageIO.read(MenuBar.class
					.getResource("resources/settings.png"));
			itemChangeDesign.setIcon(new ImageIcon(settings));
		} catch (IOException ex) {
		}
		itemChangeDesign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangeDesign.changeDesign();
			}
		});

		// MenuHelp
		menuBar.add(menuHelp);
		menuHelp.setText("Hilfe");
		menuHelp.add(itemAbout);
		itemAbout.setText("Über");
		try {
			Image about = ImageIO.read(MenuBar.class
					.getResource("resources/about.png"));
			itemAbout.setIcon(new ImageIcon(about));
		} catch (IOException ex) {
		}
		itemAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogAbout.about();
			}
		});

	}
}
