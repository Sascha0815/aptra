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
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;

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
	private static JScrollPane scrollPaneJob = new JScrollPane();
	private static JPanel panelWorkplace = new JPanel();
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
		panelWorkplace.setLayout(new MigLayout("", "[]5[]"));	
		panelButtonWorkplace.setLayout(new MigLayout("", "[]", "[]15[]15[]15[]15[]15[]"));
		buttonRefreshJob.setToolTipText("Tabelle aktualisieren");
		panelButtonWorkplace.add(buttonRefreshJob, "cell 0 0");
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
		panelButtonWorkplace.add(butttonAddJob, "cell 0 1");
		butttonAddJob.setBorderPainted(false);
		butttonAddJob.setBorder(null);
		butttonAddJob.setOpaque(false);
		butttonAddJob.setContentAreaFilled(false);
		butttonAddJob.setPreferredSize(new Dimension(135, 135));
		butttonAddJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				DialogAddVacancy.newVacancy();
			}
		});
		try {
			Image job = ImageIO.read(MenuBarPanelVacancy.class
					.getResource("resources/vacancy_add.png"));
			butttonAddJob.setIcon(new ImageIcon(job));
		} catch (IOException ex) {
		}
		buttonEditJob.setToolTipText("Bewerber bearbeiten");
		panelButtonWorkplace.add(buttonEditJob, "cell 0 2");
		buttonEditJob.setBorderPainted(false);
		buttonEditJob.setBorder(null);
		buttonEditJob.setOpaque(false);
		buttonEditJob.setContentAreaFilled(false);
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
					.getResource("resources/vacancy_edit.png"));
			buttonEditJob.setIcon(new ImageIcon(pencil));
		} catch (IOException ex) {
		}

		buttonDeleteJob.setToolTipText("Bewerber löschen");
		panelButtonWorkplace.add(buttonDeleteJob, "cell 0 3");
		buttonDeleteJob.setBorderPainted(false);
		buttonDeleteJob.setBorder(null);
		buttonDeleteJob.setOpaque(false);
		buttonDeleteJob.setContentAreaFilled(false);
		buttonDeleteJob.setPreferredSize(new Dimension(135, 135));
		try {
			Image trashcan = ImageIO.read(MenuBarPanelApplicant.class
					.getResource("resources/vacancy_delete.png"));
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
		panelButtonWorkplace.add(buttonSearchJob, "cell 0 4");
		buttonSearchJob.setBorderPainted(false);
		buttonSearchJob.setBorder(null);
		buttonSearchJob.setOpaque(false);
		buttonSearchJob.setContentAreaFilled(false);
		buttonSearchJob.setPreferredSize(new Dimension(135, 135));
		try {
			Image settings = ImageIO.read(MenuBarPanelApplicant.class
					.getResource("resources/vacancy_search.png"));
			buttonSearchJob.setIcon(new ImageIcon(settings));
		} catch (IOException ex) {
		}
		buttonSearchJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				DialogSearchVacancy.searchVacancy();
			}
		});
		buttonSettingsJob.setToolTipText("Ausschreibung anzeigen");
		panelButtonWorkplace.add(buttonSettingsJob, "cell 0 5");
		buttonSettingsJob.setBorderPainted(false);
		buttonSettingsJob.setBorder(null);
		buttonSettingsJob.setOpaque(false);
		buttonSettingsJob.setContentAreaFilled(false);
		buttonSettingsJob.setPreferredSize(new Dimension(135, 135));
		try {
			Image close = ImageIO.read(MenuBarPanelApplicant.class
					.getResource("resources/vacancy_info.png"));
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
		scrollPaneJob = new JScrollPane(tableJob);		
		scrollPaneJob
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneJob
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		tableJob.setRowHeight(20);
		Border border = new LineBorder(Color.gray, 1);
		scrollPaneJob.setBorder(border);
		panelButtonWorkplace.setBorder(border);
		panelWorkplace.add(scrollPaneJob, "cell 0 0, w :1800: , h :1000:");
		panelWorkplace.add(panelButtonWorkplace, "cell 1 0, w 150:150:150, h :1000:");
		Oberflaeche.tabBar.addTab("Arbeitststellen", panelWorkplace);
		tableJob.setAutoCreateRowSorter(true);
	}
}
