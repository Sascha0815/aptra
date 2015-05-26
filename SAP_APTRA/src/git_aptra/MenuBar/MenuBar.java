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
import git_aptra.SearchApplicant.DialogSearchApplicant;
import git_aptra.SearchVacancy.DialogSearchVacancy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UnsupportedLookAndFeelException;

public class MenuBar {
	private static JMenuBar menuBar = new JMenuBar();
	private static JMenu menuNew = new JMenu();
	private static JMenu menuHelp = new JMenu();
	private static JMenu menuDesign = new JMenu("Design");

	private static JMenuItem itemApplicant = new JMenuItem();
	private static JMenuItem itemJob = new JMenuItem();
	private static JMenuItem itemEmployee = new JMenuItem();
	private static JMenuItem itemSearchApplicant = new JMenuItem();
	private static JMenuItem itemSearchJob = new JMenuItem();
	private static JMenuItem itemEditSelection = new JMenuItem();
	private static JMenuItem itemDivision = new JMenuItem();
	private static JMenuItem itemAbout = new JMenuItem();
	private static JMenuItem itemExit = new JMenuItem();
	private static JMenuItem itemStandardLook = new JMenuItem("Standard");
	private static JMenuItem itemTextureLook = new JMenuItem("Texture");
	private static JMenuItem itemSmartLook = new JMenuItem("Smart");
	private static JMenuItem itemNoireLook = new JMenuItem("Noire");
	private static JMenuItem itemAcrylLook = new JMenuItem("Acryl");
	private static JMenuItem itemAeroLook = new JMenuItem("Aero");
	private static JMenuItem itemAluminiumLook = new JMenuItem("Aluminium");
	private static JMenuItem itemBernsteinLook = new JMenuItem("Bernstein");
	private static JMenuItem itemFastLook = new JMenuItem("Fast");
	private static JMenuItem itemGraphiteLook = new JMenuItem("Graphite");
	private static JMenuItem itemHifiLook = new JMenuItem("HiFi");
	private static JMenuItem itemLunaLook = new JMenuItem("Luna");
	private static JMenuItem itemMcWinLook = new JMenuItem("McWin");
	private static JMenuItem itemMintLook = new JMenuItem("Mint");
	
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
		itemJob.setText("Neues Stellenangebot");
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
					Connection con = DriverManager.getConnection(
							"jdbc:mysql://185.28.20.242:3306/u474396146_db",
							"u474396146_aptra", "aptraDB");
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

		// Menu Design
		menuDesign.add(itemStandardLook);
		itemStandardLook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Design.standardLook();
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		menuBar.add(menuDesign);
		menuDesign.add(itemAcrylLook);
		itemAcrylLook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Design.acrylLook();
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		menuDesign.add(itemAeroLook);
		itemAeroLook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Design.aeroLook();
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		menuDesign.add(itemAluminiumLook);
		itemAluminiumLook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Design.aluminiumLook();
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		menuDesign.add(itemBernsteinLook);
		itemBernsteinLook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Design.bernsteinLook();
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		menuDesign.add(itemFastLook);
		itemFastLook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Design.fastLook();
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		menuDesign.add(itemGraphiteLook);
		itemGraphiteLook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Design.graphiteLook();
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		menuDesign.add(itemHifiLook);
		itemHifiLook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Design.hifiLook();
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		menuDesign.add(itemLunaLook);
		itemLunaLook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Design.lunaLook();
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		menuDesign.add(itemMcWinLook);
		itemMcWinLook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Design.McWinLook();
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		menuDesign.add(itemMintLook);
		itemMintLook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Design.mintLook();
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		menuDesign.add(itemNoireLook);
		itemNoireLook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Design.noireLook();
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		menuDesign.add(itemSmartLook);
		itemSmartLook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Design.smartLook();
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		menuDesign.add(itemTextureLook);
		itemTextureLook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Design.textureLook();
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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

	}
	public static String[] getDivision(){
		
		return divisionData;
		}
}
