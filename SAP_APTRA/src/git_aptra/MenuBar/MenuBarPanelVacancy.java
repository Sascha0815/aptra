package git_aptra.MenuBar;

import git_aptra.Loading;
import git_aptra.Oberflaeche;
import git_aptra.AddVacancy.DialogAddVacancy;
import git_aptra.AddVacancy.InsertVacancyDataIntoTable;
import git_aptra.Delete.DeleteVacancy;
import git_aptra.EditVacancy.DialogEditVacancy;
import git_aptra.EditVacancy.DialogEditVacancyWarning;
import git_aptra.EditVacancy.EditVacancy;
import git_aptra.InfoVacancy.DialogInfoVacancy;
import git_aptra.InfoVacancy.InfoVacancy;
import git_aptra.Login.Login;
import git_aptra.SearchVacancy.DialogSearchVacancy;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
	private static JButton buttonDetailsJob = new JButton();
	public static DefaultTableModel modelJob = new DefaultTableModel() {
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	public static JTable tableJob = new JTable(modelJob);
	
	private static String[] vacancyID;
	@SuppressWarnings("unused")
	private static String[] division;
	private static String[] divisionData;
	private static JScrollPane paneButton = new JScrollPane(panelButtonWorkplace);
	// SWING: Arbeitsstellen Panel
	public static void addPanelWorkplace() {		
		panelWorkplace.setLayout(new MigLayout("", "[]5[]"));	
		panelButtonWorkplace.setLayout(new MigLayout("", "16[]", "[]15[]15[]15[]15[]15[]"));
		buttonRefreshJob.setToolTipText("Tabelle aktualisieren");
		panelButtonWorkplace.add(buttonRefreshJob, "cell 0 0");
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
		butttonAddJob.setBorder(null);
		butttonAddJob.setOpaque(false);
		butttonAddJob.setContentAreaFilled(false);
		butttonAddJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Loading.startWaitCursor(Oberflaeche.frame.getRootPane());
				ArrayList<String> id= new ArrayList<String>();
				try {
					Connection con =  Login.getConnection();
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("Select vacancyID, position from vacancy");

					while (rs.next()) {
						 id.add(rs.getString(1) + " - " + rs.getString(2) );	

					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				vacancyID = new String[id.size()];
				vacancyID = id.toArray(vacancyID);
				
				ArrayList<String> division= new ArrayList<String>();
				try {
					Connection con =  Login.getConnection();
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("Select divisionID, notation from division");

					while (rs.next()) {
						division.add(rs.getString(1) + " - " + rs.getString(2) );	

					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				divisionData = new String[division.size()];
				divisionData = division.toArray(divisionData);
				DialogAddVacancy.newVacancy();
			}
		});
		try {
			Image job = ImageIO.read(MenuBarPanelVacancy.class
					.getResource("resources/vacancy_add.png"));
			butttonAddJob.setIcon(new ImageIcon(job));
		} catch (IOException ex) {
		}
		buttonEditJob.setToolTipText("Arbeitsstelle bearbeiten");
		panelButtonWorkplace.add(buttonEditJob, "cell 0 2");
		buttonEditJob.setBorder(null);
		buttonEditJob.setOpaque(false);
		buttonEditJob.setContentAreaFilled(false);
		buttonEditJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (tableJob.getSelectedRowCount() == 0 ) {
					DialogEditVacancyWarning.nothingSelected();
				} 
				if (tableJob.getSelectedRowCount() > 1){
					DialogEditVacancyWarning.tooManySelected();
				} else {
					Loading.startWaitCursor(Oberflaeche.frame.getRootPane());
					ArrayList<String> id= new ArrayList<String>();
					try {
						Connection con =  Login.getConnection();
						Statement stmt = con.createStatement();
						ResultSet rs = stmt.executeQuery("Select vacancyID, position from vacancy");

						while (rs.next()) {
							 id.add(rs.getString(1) + " - " + rs.getString(2) );	

						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
					vacancyID = new String[id.size()];
					vacancyID = id.toArray(vacancyID);
					
					ArrayList<String> division= new ArrayList<String>();
					try {
						Connection con =  Login.getConnection();
						Statement stmt = con.createStatement();
						ResultSet rs = stmt.executeQuery("Select divisionID, notation from division");

						while (rs.next()) {
							division.add(rs.getString(1) + " - " + rs.getString(2) );	

						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
					divisionData = new String[division.size()];
					divisionData = division.toArray(divisionData);
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

		buttonDeleteJob.setToolTipText("Arbeitsstelle löschen");
		panelButtonWorkplace.add(buttonDeleteJob, "cell 0 3");
		buttonDeleteJob.setBorder(null);
		buttonDeleteJob.setOpaque(false);
		buttonDeleteJob.setContentAreaFilled(false);
		try {
			Image trashcan = ImageIO.read(MenuBarPanelApplicant.class
					.getResource("resources/vacancy_delete.png"));
			buttonDeleteJob.setIcon(new ImageIcon(trashcan));
		} catch (IOException ex) {
		}
		buttonDeleteJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					DeleteVacancy.deleteVacancy();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				@SuppressWarnings("rawtypes")
				Vector resultsVacancy = InsertVacancyDataIntoTable
						.insertVacancyDataIntoTable();
				modelJob.setDataVector(resultsVacancy, COLUMN_IDENTIFIERS_JOB);
				modelJob.fireTableDataChanged();
			}
		});
		buttonSearchJob.setToolTipText("Arbeitsstelle suchen");
		panelButtonWorkplace.add(buttonSearchJob, "cell 0 4");
		buttonSearchJob.setBorder(null);
		buttonSearchJob.setOpaque(false);
		buttonSearchJob.setContentAreaFilled(false);
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
		buttonDetailsJob.setToolTipText("Ausschreibung anzeigen");
		panelButtonWorkplace.add(buttonDetailsJob, "cell 0 5");
		buttonDetailsJob.setBorder(null);
		buttonDetailsJob.setOpaque(false);
		buttonDetailsJob.setContentAreaFilled(false);
		try {
			Image close = ImageIO.read(MenuBarPanelApplicant.class
					.getResource("resources/vacancy_info.png"));
			buttonDetailsJob.setIcon(new ImageIcon(close));
		} catch (IOException ex) {
		}
		buttonDetailsJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (tableJob.getSelectedRowCount() == 0 ) {
					DialogEditVacancyWarning.nothingSelected();
				} 
				if (tableJob.getSelectedRowCount() > 1){
					DialogEditVacancyWarning.tooManySelected();
				} else {
					InfoVacancy.getVacancyInfo();
					DialogInfoVacancy.infoVacancy();
				}
			}
		});

		// SWING:Table Arbeitsstellen
		modelJob.setColumnIdentifiers(COLUMN_IDENTIFIERS_JOB);
		tableJob.getTableHeader().setReorderingAllowed(false);
		tableJob.setAutoCreateRowSorter(true);
		tableJob = new JTable(modelJob);
		scrollPaneJob = new JScrollPane(tableJob);		
		scrollPaneJob.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		tableJob.setRowHeight(20);
		Border border = new LineBorder(Color.gray, 1);
		scrollPaneJob.setBorder(border);
		panelButtonWorkplace.setBorder(border);
		panelWorkplace.add(scrollPaneJob, "cell 0 0, w :1800: , h :1000:");
		panelWorkplace.add(paneButton, "cell 1 0, w 170:170:170, h :1000:");
		Oberflaeche.tabBar.addTab("Arbeitsstellen", panelWorkplace);
		tableJob.setAutoCreateRowSorter(true);
	}
	
	public static String[] getVacancyID(){
		return vacancyID;
	}
	
	public static String[] getDivision(){
		return divisionData;
	}
}
