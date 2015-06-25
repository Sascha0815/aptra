package git_aptra.MenuBar;

import git_aptra.DialogAbout;
import git_aptra.Oberflaeche;
import git_aptra.AddApplicant.DialogAddApplicant;
import git_aptra.AddDivision.DialogAddDivision;
import git_aptra.AddEmployee.DialogAddEmployee;
import git_aptra.AddVacancy.DialogAddVacancy;
import git_aptra.EditSelection.DialogEditSelection;
import git_aptra.EditSelection.InsertEditSelectionDataIntoTable;
import git_aptra.Instruction.DialogInstruction;
import git_aptra.Login.Login;
import git_aptra.SearchApplicant.DialogSearchApplicant;
import git_aptra.SearchMeeting.DialogSearchMeeting;
import git_aptra.SearchVacancy.DialogSearchVacancy;

import java.awt.Font;
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
import javax.swing.*;

public class MenuBar {
	private static JMenuBar menuBar = new JMenuBar();
	private static JMenu menuNew = new JMenu();
	private static JMenu menuSearch = new JMenu();
	private static JMenu menuHelp = new JMenu();
	
	private static JLabel labelEmployee = new JLabel("Sie sind eingeloggt als:  " + Login.getFirstName() + " " + Login.getName() + " (Mitarbeiter-ID: " + Login.getID() + ")");

	private static JMenuItem itemApplicant = new JMenuItem();
	private static JMenuItem itemJob = new JMenuItem();
	private static JMenuItem itemEmployee = new JMenuItem();
	private static JMenuItem itemSearchApplicant = new JMenuItem();
	private static JMenuItem itemSearchJob = new JMenuItem();
	private static JMenuItem itemSearchMeeting = new JMenuItem();
	private static JMenuItem itemEditSelection = new JMenuItem();
	private static JMenuItem itemDivision = new JMenuItem();
	private static JMenuItem itemAbout = new JMenuItem();
	private static JMenuItem itemExit = new JMenuItem();
	private static JMenuItem itemHelp = new JMenuItem();
	
	private static JButton buttonInstruction = new JButton();
	
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
		
		// Menu Search
		menuBar.add(menuSearch);
		menuSearch.setText("Suchen");
		
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
		itemJob.setText("Neue Arbeitsstelle");
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
		menuSearch.add(itemSearchApplicant);
		itemSearchApplicant.setText("Bewerber suchen");
		itemSearchApplicant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogSearchApplicant.searchApplicant();
			}
		});
		
		// MenuItem Arbeitsstelle suchen
		menuSearch.add(itemSearchJob);
		itemSearchJob.setText("Arbeitsstelle suchen");
		itemSearchJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogSearchVacancy.searchVacancy();
			}
		});
		
		// MenuItem Meeting suchen
		menuSearch.add(itemSearchMeeting);
		itemSearchMeeting.setText("Meeting suchen");
		itemSearchMeeting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogSearchMeeting.searchMeeting();
			}
		});
		
		// MenuItem Neues Bewerberkriterium
		menuNew.add(itemEditSelection);
		itemEditSelection.setText("Neues Bewerberkriterium");
		itemEditSelection.addActionListener(new ActionListener() {
			@SuppressWarnings("rawtypes")
			public void actionPerformed(ActionEvent e) {
				Vector resultsSeleciton = InsertEditSelectionDataIntoTable.insertEditSelectionDataIntoTable();
				DialogEditSelection.modelEditSelection.setDataVector(resultsSeleciton, DialogEditSelection.COLUMN_IDENTIFIERS_SELECTION);
				DialogEditSelection.modelEditSelection.fireTableDataChanged();
				DialogEditSelection.editSelection();
			}
		});
		
		// MenuItem Neue Abteilung
		menuNew.add(itemDivision);
		itemDivision.setText("Neue Abteilung");
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
		
		menuHelp.add(itemHelp);
		itemHelp.setText("Hilfe");
		itemHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogInstruction.newInstruction();
			}
		});
		
		menuBar.add(Box.createGlue());
		menuBar.add(labelEmployee);
		labelEmployee.setFont(fontHeadline);
		menuBar.add(buttonInstruction);
		try {
			Image questionMark = ImageIO.read(MenuBarPanelApplicant.class
					.getResource("resources/question_mark.png"));
			buttonInstruction.setIcon(new ImageIcon(questionMark));
		} catch (IOException ex) {
		}
		buttonInstruction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogInstruction.newInstruction();
			}
		});
		
		

	}
	public static String[] getDivision(){
		
		return divisionData;
		}
}
