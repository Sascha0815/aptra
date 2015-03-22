package git_aptra.MenuBar;

import git_aptra.Oberflaeche;
import git_aptra.DatabaseConnection.DeleteApplicant;
import git_aptra.DatabaseConnection.InsertApplicantDataIntoTable;
import git_aptra.DatabaseConnection.InsertVacancyDateIntoTable;
import git_aptra.DialogAddApplicant.DialogAddApplicant;
import git_aptra.DialogAddVacancy.DialogAddVacancy;
import git_aptra.DialogApplicantSearch.DialogSearchApplicant;
import git_aptra.DialogEditApplicant.DialogEditApplicant;
import git_aptra.DialogEditApplicant.DialogEditWarning;
import git_aptra.DialogEditApplicant.EditApplicant;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuBarPanelOverview {
	private static JPanel panelOverview = new JPanel();
	private static JPanel panelContentOverview = new JPanel();
	private static JPanel panelInfoOverview = new JPanel();

	private static JButton buttonAddApplicant = new JButton(
			BorderLayout.LINE_START);
	private static JButton buttonDeleteApplicant = new JButton(
			BorderLayout.LINE_START);
	private static JButton buttonEditApplicant = new JButton(
			BorderLayout.LINE_START);
	private static JButton buttonSearchApplicant = new JButton(
			BorderLayout.LINE_START);
	private static JButton buttonSettingsApplicant = new JButton(
			BorderLayout.LINE_START);
	private static JButton buttonRefreshApplicant = new JButton(
			BorderLayout.LINE_START);

	private static JButton butttonAddJob = new JButton(BorderLayout.LINE_END);
	private static JButton buttonRefreshJob = new JButton(BorderLayout.LINE_END);
	private static JButton buttonDeleteJob = new JButton(BorderLayout.LINE_END);
	private static JButton buttonEditJob = new JButton(BorderLayout.LINE_END);
	private static JButton buttonSearchJob = new JButton(BorderLayout.LINE_END);
	private static JButton buttonSettingsJob = new JButton(
			BorderLayout.LINE_END);

	// SWING: Übersicht-Panel
	public static void addPanelOverview() {
		panelOverview.setLayout(new BorderLayout(5, 5));
		panelOverview.add(panelContentOverview, BorderLayout.CENTER);
		panelOverview.add(panelInfoOverview, BorderLayout.SOUTH);
		panelContentOverview.setBackground(Color.LIGHT_GRAY);
		panelInfoOverview.setBackground(Color.LIGHT_GRAY);
		panelInfoOverview.setPreferredSize(new Dimension(0, 20));
		Oberflaeche.tabBar.addTab("Übersicht", panelOverview);

		buttonRefreshApplicant.setToolTipText("Tabelle aktualisieren");
		panelContentOverview.add(buttonRefreshApplicant);
		buttonRefreshApplicant.setPreferredSize(new Dimension(135, 135));
		try {
			Image refreshApplicant = ImageIO.read(MenuBarPanelApplicant.class
					.getResource("resources/applicant_refresh.png"));
			buttonRefreshApplicant.setIcon(new ImageIcon(refreshApplicant));
		} catch (IOException ex) {
		}
		buttonRefreshApplicant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("rawtypes")
				Vector resultsApplicant = InsertApplicantDataIntoTable
						.insertApplicantDataIntoTable();
				MenuBarPanelApplicant.modelPool.setDataVector(resultsApplicant,
						MenuBarPanelApplicant.COLUMN_IDENTIFIERS_APPLICANT);
				MenuBarPanelApplicant.modelPool.fireTableDataChanged();
			}
		});

		buttonAddApplicant.setToolTipText("Neuer Bewerber hinzufügen");
		panelContentOverview.add(buttonAddApplicant);
		buttonAddApplicant.setPreferredSize(new Dimension(135, 135));
		try {
			Image add = ImageIO.read(MenuBarPanelApplicant.class
					.getResource("resources/applicant_add.png"));
			buttonAddApplicant.setIcon(new ImageIcon(add));
		} catch (IOException ex) {
		}
		buttonAddApplicant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				DialogAddApplicant.newApplicant();
			}
		});

		buttonEditApplicant.setToolTipText("Bewerber bearbeiten");
		panelContentOverview.add(buttonEditApplicant);
		buttonEditApplicant.setPreferredSize(new Dimension(135, 135));
		try {
			Image pencil = ImageIO.read(MenuBarPanelApplicant.class
					.getResource("resources/applicant_edit.png"));
			buttonEditApplicant.setIcon(new ImageIcon(pencil));
		} catch (IOException ex) {
		}
		buttonEditApplicant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (MenuBarPanelApplicant.tableApplicant.getSelectedRowCount() > 1) {
					DialogEditWarning.selectOnlyOne();
				} else {
					EditApplicant.getSelectedRow();
					DialogEditApplicant.editApplicant();
				}
			}
		});
		buttonDeleteApplicant.setToolTipText("Bewerber löschen");
		panelContentOverview.add(buttonDeleteApplicant);
		buttonDeleteApplicant.setPreferredSize(new Dimension(135, 135));
		try {
			Image trashcan = ImageIO.read(MenuBarPanelApplicant.class
					.getResource("resources/applicant_delete.png"));
			buttonDeleteApplicant.setIcon(new ImageIcon(trashcan));
		} catch (IOException ex) {
		}
		buttonDeleteApplicant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				DeleteApplicant.deleteApplicant();
				@SuppressWarnings("rawtypes")
				Vector resultsApplicant = InsertApplicantDataIntoTable
						.insertApplicantDataIntoTable();
				MenuBarPanelApplicant.modelPool.setDataVector(resultsApplicant,
						MenuBarPanelApplicant.COLUMN_IDENTIFIERS_APPLICANT);
				MenuBarPanelApplicant.modelPool.fireTableDataChanged();
			}
		});
		buttonSearchApplicant.setToolTipText("Suchen");
		panelContentOverview.add(buttonSearchApplicant);
		buttonSearchApplicant.setPreferredSize(new Dimension(135, 135));
		try {
			Image settings = ImageIO.read(MenuBarPanelApplicant.class
					.getResource("resources/applicant_search.png"));
			buttonSearchApplicant.setIcon(new ImageIcon(settings));
		} catch (IOException ex) {
		}
		buttonSearchApplicant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				DialogSearchApplicant.searchApplicant();
			}
		});

		buttonSettingsApplicant.setToolTipText("Programm schließen");
		panelContentOverview.add(buttonSettingsApplicant);
		buttonSettingsApplicant.setPreferredSize(new Dimension(135, 135));
		try {
			Image close = ImageIO.read(MenuBarPanelApplicant.class
					.getResource("resources/applicant_settings.png"));
			buttonSettingsApplicant.setIcon(new ImageIcon(close));
		} catch (IOException ex) {
		}
		buttonSettingsApplicant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {

			}
		});

		buttonRefreshJob.setToolTipText("Tabelle aktualisieren");
		panelContentOverview.add(buttonRefreshJob);
		buttonRefreshJob.setPreferredSize(new Dimension(135, 135));
		buttonRefreshJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		try {
			Image add = ImageIO.read(MenuBarPanelWorkplace.class
					.getResource("resources/job_refresh.png"));
			buttonRefreshJob.setIcon(new ImageIcon(add));
		} catch (IOException ex) {
		}
		buttonRefreshJob.addActionListener(new ActionListener() {
			@SuppressWarnings("rawtypes")
			public void actionPerformed(ActionEvent e) {
				Vector resultsVacancy = InsertVacancyDateIntoTable
						.insertVacancyDataIntoTable();
				MenuBarPanelWorkplace.modelJob.setDataVector(resultsVacancy,
						MenuBarPanelWorkplace.COLUMN_IDENTIFIERS_JOB);
				MenuBarPanelWorkplace.modelJob.fireTableDataChanged();
			}
		});
		butttonAddJob.setToolTipText("Neue Arbeitstelle hinzufügen");
		panelContentOverview.add(butttonAddJob);
		butttonAddJob.setPreferredSize(new Dimension(135, 135));
		butttonAddJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				DialogAddVacancy.newVacancy();
			}
		});

		try {
			Image job = ImageIO.read(MenuBarPanelWorkplace.class
					.getResource("resources/job_add.png"));
			butttonAddJob.setIcon(new ImageIcon(job));
		} catch (IOException ex) {
		}
		buttonEditJob.setToolTipText("Bewerber bearbeiten");
		panelContentOverview.add(buttonEditJob);
		buttonEditJob.setPreferredSize(new Dimension(135, 135));
		try {
			Image pencil = ImageIO.read(MenuBarPanelApplicant.class
					.getResource("resources/job_edit.png"));
			buttonEditJob.setIcon(new ImageIcon(pencil));
		} catch (IOException ex) {
		}
		buttonDeleteJob.setToolTipText("Bewerber löschen");
		panelContentOverview.add(buttonDeleteJob);
		buttonDeleteJob.setPreferredSize(new Dimension(135, 135));
		try {
			Image trashcan = ImageIO.read(MenuBarPanelApplicant.class
					.getResource("resources/job_delete.png"));
			buttonDeleteJob.setIcon(new ImageIcon(trashcan));
		} catch (IOException ex) {
		}
		buttonDeleteJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
			}
		});
		buttonSearchJob.setToolTipText("Einstellungen");
		panelContentOverview.add(buttonSearchJob);
		buttonSearchJob.setPreferredSize(new Dimension(135, 135));
		try {
			Image settings = ImageIO.read(MenuBarPanelApplicant.class
					.getResource("resources/job_search.png"));
			buttonSearchJob.setIcon(new ImageIcon(settings));
		} catch (IOException ex) {
		}
		buttonSettingsJob.setToolTipText("Programm schließen");
		panelContentOverview.add(buttonSettingsJob);
		buttonSettingsJob.setPreferredSize(new Dimension(135, 135));
		try {
			Image close = ImageIO.read(MenuBarPanelApplicant.class
					.getResource("resources/job_settings.png"));
			buttonSettingsJob.setIcon(new ImageIcon(close));
		} catch (IOException ex) {
		}
		buttonSettingsJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {

			}
		});

	}

}
