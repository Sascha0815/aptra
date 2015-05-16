package git_aptra.MenuBar;

import git_aptra.DialogAbout;
import git_aptra.ChangeDesign;
import git_aptra.Oberflaeche;
import git_aptra.AddApplicant.DialogAddApplicant;
import git_aptra.AddEmployee.DialogAddEmployee;
import git_aptra.AddVacancy.DialogAddVacancy;
import git_aptra.EditSelection.DialogEditSelection;
import git_aptra.SearchApplicant.DialogSearchApplicant;
import git_aptra.SearchVacancy.DialogSearchVacancy;

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
	private static JMenuItem itemEmployee = new JMenuItem();
	private static JMenuItem itemSearchApplicant = new JMenuItem();
	private static JMenuItem itemSearchJob = new JMenuItem();
	private static JMenuItem itemEditSelection = new JMenuItem();
	private static JMenuItem itemAbout = new JMenuItem();
	private static JMenuItem itemExit = new JMenuItem();
	private static JMenuItem itemChangeDesign = new JMenuItem();

	// SWING: MenuBar mit Reitern, Einträgen und ActionListenern
	public static void addMenuBar() {
		
		// MenuBar
		Oberflaeche.frame.setJMenuBar(menuBar);

		// Menu Neu
		menuBar.add(menuNew);
		menuNew.setText("Neu");
		
		// MenuItem Neuer Bewerber
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
		
		// MenuItem Neue Arbeitsstelle
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
		
		// MenuItem Neuer Mitarbeiter
		menuNew.add(itemEmployee);
		itemEmployee.setText("Neuer Mitarbeiter");
		try {
			Image job = ImageIO.read(MenuBar.class
					.getResource("resources/job_small.png"));
			itemEmployee.setIcon(new ImageIcon(job));
		} catch (IOException ex) {
		}
		itemEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogAddEmployee.addEmployee();
			}
		});
		
		// MenuItem Bewerber suchen
		menuNew.add(itemSearchApplicant);
		itemSearchApplicant.setText("Bewerber suchen");
		try {
			Image close = ImageIO.read(MenuBar.class
					.getResource("resources/search_small.png"));
			itemSearchApplicant.setIcon(new ImageIcon(close));
		} catch (IOException ex) {
		}
		itemSearchApplicant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogSearchApplicant.searchApplicant();
			}
		});
		
		// MenuItem Arbeitsstelle suchen
		menuNew.add(itemSearchJob);
		itemSearchJob.setText("Arbeitsstelle suchen");
		try {
			Image close = ImageIO.read(MenuBar.class
					.getResource("resources/search_small.png"));
			itemSearchJob.setIcon(new ImageIcon(close));
		} catch (IOException ex) {
		}
		itemSearchJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogSearchVacancy.searchVacancy();
			}
		});
		
		// MenuItem Bewerberkriterien bearbeiten
				menuNew.add(itemEditSelection);
				itemEditSelection.setText("Bewertungskriterien bearbeiten");
				try {
					Image close = ImageIO.read(MenuBar.class
							.getResource("resources/search_small.png"));
					itemEditSelection.setIcon(new ImageIcon(close));
				} catch (IOException ex) {
				}
				itemEditSelection.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						DialogEditSelection.editSelection();
					}
				});
		
		// MenuItem Programm beenden
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

		// Menu Einstellungen
		menuBar.add(menuSettings);
		menuSettings.setText("Einstellungen");
		menuSettings.add(itemChangeDesign);
		
		// MenuItem Design ändern
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

		// Menu Hilfe
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
