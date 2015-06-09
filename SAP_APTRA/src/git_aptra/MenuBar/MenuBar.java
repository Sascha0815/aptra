package git_aptra.MenuBar;

import git_aptra.Design;
import git_aptra.DialogAbout;
import git_aptra.Oberflaeche;
import git_aptra.AddApplicant.DialogAddApplicant;
import git_aptra.AddDivision.DialogAddDivision;
import git_aptra.AddEmployee.DialogAddEmployee;
import git_aptra.AddVacancy.DialogAddVacancy;
import git_aptra.EditSelection.DialogEditSelection;
import git_aptra.EditSelection.InsertEditSelectionDataIntoTable;
import git_aptra.Login.Login;
import git_aptra.SearchApplicant.DialogSearchApplicant;
import git_aptra.SearchVacancy.DialogSearchVacancy;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;

public class MenuBar {
	private static JMenuBar menuBar = new JMenuBar();
	private static JMenu menuNew = new JMenu();
	private static JMenu menuHelp = new JMenu();
	
	private static JLabel labelEmployee = new JLabel("Sie sind eingeloggt als:  " + Login.getFirstName() + " " + Login.getName() + " (Mitarbeiter-ID: " + Login.getID() + ")");

	private static JMenuItem itemApplicant = new JMenuItem();
	private static JMenuItem itemJob = new JMenuItem();
	private static JMenuItem itemEmployee = new JMenuItem();
	private static JMenuItem itemSearchApplicant = new JMenuItem();
	private static JMenuItem itemSearchJob = new JMenuItem();
	private static JMenuItem itemEditSelection = new JMenuItem();
	private static JMenuItem itemDivision = new JMenuItem();
	private static JMenuItem itemAbout = new JMenuItem();
	private static JMenuItem itemExit = new JMenuItem();
	
	private static Font fontHeadline = new Font("Calibri", Font.BOLD, 16);
	
	@SuppressWarnings("unused")
	private static String[] division;
	private static String[] divisionData;

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
		itemApplicant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogAddApplicant.newApplicant();
			}
		});
		
		// MenuItem Neue Arbeitsstelle
		menuNew.add(itemJob);
		itemJob.setText("Neues Arbeitsstelle");
		itemJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogAddVacancy.newVacancy();
			}
		});
		
		// MenuItem Neuer Mitarbeiter
		menuNew.add(itemEmployee);
		itemEmployee.setText("Neuer Mitarbeiter");
		itemEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> division= new ArrayList<String>();
				try {
					Connection con =  Login.getConnection();
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("Select divisionID, notation from division");

					while (rs.next()) {
						division.add(rs.getString(1) + " - " + rs.getString(2) );	

					}
				} catch (SQLException f) {
					f.printStackTrace();
				}
				divisionData = new String[division.size()];
				divisionData = division.toArray(divisionData);
				DialogAddEmployee.addEmployee();
				}
			
			});
				
		// MenuItem Bewerber suchen
		menuNew.add(itemSearchApplicant);
		itemSearchApplicant.setText("Bewerber suchen");
		itemSearchApplicant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogSearchApplicant.searchApplicant();
			}
		});
		
		// MenuItem Arbeitsstelle suchen
		menuNew.add(itemSearchJob);
		itemSearchJob.setText("Arbeitsstelle suchen");
		itemSearchJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogSearchVacancy.searchVacancy();
			}
		});
		
		// MenuItem Bewerberkriterien bearbeiten
		menuNew.add(itemEditSelection);
		itemEditSelection.setText("Bewertungskriterien bearbeiten");
		itemEditSelection.addActionListener(new ActionListener() {
			@SuppressWarnings("rawtypes")
			public void actionPerformed(ActionEvent e) {
				Vector resultsSeleciton = InsertEditSelectionDataIntoTable.insertEditSelectionDataIntoTable();
				DialogEditSelection.modelEditSelection.setDataVector(resultsSeleciton, DialogEditSelection.COLUMN_IDENTIFIERS_SELECTION);
				DialogEditSelection.modelEditSelection.fireTableDataChanged();
				DialogEditSelection.editSelection();
			}
		});
		
		// MenuItem Bewerberkriterien bearbeiten
		menuNew.add(itemDivision);
		itemDivision.setText("Abteilung hinzufügen");
		itemDivision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogAddDivision.addDivision();
			}
		});
					
		// MenuItem Programm beenden
		menuNew.add(itemExit);
		itemExit.setText("Beenden");
		itemExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Oberflaeche.frame.dispose();
			}
		});
		
		// Menu Hilfe
		menuBar.add(menuHelp);
		menuHelp.setText("Hilfe");
		menuHelp.add(itemAbout);
		itemAbout.setText("Über");
		itemAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogAbout.about();
			}
		});
		
		menuBar.add(Box.createGlue());
		menuBar.add(labelEmployee);
		labelEmployee.setFont(fontHeadline);
		
		

	}
	public static String[] getDivision(){
		
		return divisionData;
		}
}
