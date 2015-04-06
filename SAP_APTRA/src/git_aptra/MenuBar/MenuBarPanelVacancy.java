package git_aptra.MenuBar;

import git_aptra.Oberflaeche;
import git_aptra.AddVacancy.DialogAddVacancy;
import git_aptra.AddVacancy.InsertVacancyDataIntoTable;
import git_aptra.Delete.DeleteVacancy;
import git_aptra.EditVacancy.DialogEditVacancy;
import git_aptra.EditVacancy.DialogEditVacancyWarning;
import git_aptra.EditVacancy.EditVacancy;
import git_aptra.SearchVacancy.DialogSearchVacancy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MenuBarPanelVacancy {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public final static Vector COLUMN_IDENTIFIERS_JOB = new Vector() {
		private static final long serialVersionUID = 1L;

		{
			add("Stellen-ID");
			add("Stellenbezeichnung");
			add("Arbeitsbereich");
			add("Anforderung");
			add("Anstellungsverhältnis");
			add("Status");
			add("Bildungsabschluss");
			add("Art des Bewerbers");
			add("Bewerbungsschluss");
		}
	};
	private static JPanel panelWorkplace = new JPanel();
	private static JPanel panelContentWorkplace = new JPanel();
	private static JPanel panelInfoWorkplace = new JPanel();
	private static JPanel panelButtonWorkplace = new JPanel();

	private static JButton butttonAddJob = new JButton();
	private static JButton buttonRefreshJob = new JButton();
	private static JButton buttonDeleteJob = new JButton();
	private static JButton buttonEditJob = new JButton();
	private static JButton buttonSearchJob = new JButton();
	private static JButton buttonSettingsJob = new JButton();
	public static DefaultTableModel modelJob = new DefaultTableModel(1, 4) {
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	public static JTable tableJob = new JTable(modelJob);

	// SWING: Arbeitsstellen Panel
	public static void addPanelWorkplace() {
		
		
		panelWorkplace.setLayout(new BorderLayout(5, 5));
		panelWorkplace.add(panelButtonWorkplace, BorderLayout.EAST);
		panelWorkplace.add(panelContentWorkplace, BorderLayout.CENTER);
		panelWorkplace.add(panelInfoWorkplace, BorderLayout.SOUTH);
		panelButtonWorkplace
				.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		panelButtonWorkplace.setBackground(Color.LIGHT_GRAY);
		panelButtonWorkplace.setPreferredSize(new Dimension(150, 0));
		panelContentWorkplace.setBackground(Color.LIGHT_GRAY);
		panelInfoWorkplace.setBackground(Color.LIGHT_GRAY);
		panelInfoWorkplace.setPreferredSize(new Dimension(0, 20));
		buttonRefreshJob.setToolTipText("Tabelle aktualisieren");
		panelButtonWorkplace.add(buttonRefreshJob);
		buttonRefreshJob.setPreferredSize(new Dimension(135, 135));
		buttonRefreshJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		try {
			Image add = ImageIO.read(MenuBarPanelVacancy.class
					.getResource("resources/job_refresh.png"));
			buttonRefreshJob.setIcon(new ImageIcon(add));
		} catch (IOException ex) {
		}
		buttonRefreshJob.addActionListener(new ActionListener() {
			@SuppressWarnings("rawtypes")
			public void actionPerformed(ActionEvent e) {
				Vector resultsVacancy = InsertVacancyDataIntoTable
						.insertVacancyDataIntoTable();
				MenuBarPanelVacancy.modelJob.setDataVector(resultsVacancy,
						MenuBarPanelVacancy.COLUMN_IDENTIFIERS_JOB);
				MenuBarPanelVacancy.modelJob.fireTableDataChanged();
			}
		});
		butttonAddJob.setToolTipText("Neue Arbeitstelle hinzufügen");
		panelButtonWorkplace.add(butttonAddJob);
		butttonAddJob.setPreferredSize(new Dimension(135, 135));
		butttonAddJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				DialogAddVacancy.newVacancy();
			}
		});
		try {
			Image job = ImageIO.read(MenuBarPanelVacancy.class
					.getResource("resources/job_add.png"));
			butttonAddJob.setIcon(new ImageIcon(job));
		} catch (IOException ex) {
		}
		buttonEditJob.setToolTipText("Bewerber bearbeiten");
		panelButtonWorkplace.add(buttonEditJob);
		buttonEditJob.setPreferredSize(new Dimension(135, 135));
		buttonEditJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (tableJob.getSelectedRowCount() > 1 || tableJob.getSelectedRowCount() == 0 ) {
					DialogEditVacancyWarning.selectOnlyOne();
				} else {
					EditVacancy.getSelectedRow();
					DialogEditVacancy.editVacancy();
				}
			}
		});
		try {
			Image pencil = ImageIO.read(MenuBarPanelApplicant.class
					.getResource("resources/job_edit.png"));
			buttonEditJob.setIcon(new ImageIcon(pencil));
		} catch (IOException ex) {
		}

		buttonDeleteJob.setToolTipText("Bewerber löschen");
		panelButtonWorkplace.add(buttonDeleteJob);
		buttonDeleteJob.setPreferredSize(new Dimension(135, 135));
		try {
			Image trashcan = ImageIO.read(MenuBarPanelApplicant.class
					.getResource("resources/job_delete.png"));
			buttonDeleteJob.setIcon(new ImageIcon(trashcan));
		} catch (IOException ex) {
		}
		buttonDeleteJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				DeleteVacancy.deleteVacancy();
				@SuppressWarnings("rawtypes")
				Vector resultsVacancy = InsertVacancyDataIntoTable
						.insertVacancyDataIntoTable();
				modelJob.setDataVector(resultsVacancy, COLUMN_IDENTIFIERS_JOB);
				modelJob.fireTableDataChanged();
			}
		});
		buttonSearchJob.setToolTipText("Einstellungen");
		panelButtonWorkplace.add(buttonSearchJob);
		buttonSearchJob.setPreferredSize(new Dimension(135, 135));
		try {
			Image settings = ImageIO.read(MenuBarPanelApplicant.class
					.getResource("resources/job_search.png"));
			buttonSearchJob.setIcon(new ImageIcon(settings));
		} catch (IOException ex) {
		}
		buttonSearchJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				DialogSearchVacancy.searchVacancy();
			}
		});
		buttonSettingsJob.setToolTipText("Programm schließen");
		panelButtonWorkplace.add(buttonSettingsJob);
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

		// SWING:Table Arbeitsstellen
		modelJob.setColumnIdentifiers(COLUMN_IDENTIFIERS_JOB);
		tableJob.getTableHeader().setReorderingAllowed(false);
		tableJob.setAutoCreateRowSorter(true);
		tableJob = new JTable(modelJob);
		JScrollPane scrollPaneJob = new JScrollPane(tableJob);
		panelWorkplace.add(scrollPaneJob);
		scrollPaneJob.setPreferredSize(new Dimension(panelContentWorkplace
				.getSize().width - 20,
				panelContentWorkplace.getSize().height - 15));
		scrollPaneJob
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneJob
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		tableJob.setRowHeight(20);
		Oberflaeche.tabBar.addTab("Arbeitststellen", panelWorkplace);

	}
}
