package git_aptra.VacancyManagement;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import git_aptra.Oberflaeche;
import git_aptra.MenuBar.MenuBarPanelVacancyManagement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import net.miginfocom.swing.MigLayout;

public class DialogOpenVacancy {
	
	private static JDialog dialogAddVacancyManagement  = new JDialog(Oberflaeche.frame, true);
	
	private static JPanel panelAddVacancyManagement = new JPanel();
	
	private static JLabel labelInstruction = new JLabel("Bitte die gewünschte Stellen-ID eingeben");
	
	private static Font fontHeadline = new Font("Calibri", Font.BOLD, 16);
	private static Font fontSubHeadline = new Font("Calibri", Font.BOLD, 14);
	
	private static JButton buttonSearch = new JButton("Suchen");
	private static JButton buttonAbort = new JButton("Abbrechen");
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static JComboBox boxID = new JComboBox(MenuBarPanelVacancyManagement.getResult());
	
	private static int id;
	private static boolean first = true;
	private static int amount;
	
	public static void addVacancyManagement() {
		dialogAddVacancyManagement.setSize(420, 130);
		dialogAddVacancyManagement.setResizable(false);	
		dialogAddVacancyManagement.setTitle("Ausschreibung verwalten");
		dialogAddVacancyManagement.add(panelAddVacancyManagement);
		labelInstruction.setFont(fontHeadline);
		boxID.setFont(fontSubHeadline);
		buttonSearch.setFont(fontSubHeadline);
		buttonAbort.setFont(fontSubHeadline);
		panelAddVacancyManagement.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][]push[]"));
		panelAddVacancyManagement.add(labelInstruction, "cell 0 0 2,alignx center");
		panelAddVacancyManagement.add(boxID, "cell 0 1 2,growx");
		panelAddVacancyManagement.add(buttonSearch, "cell 0 2,alignx left");
		panelAddVacancyManagement.add(buttonAbort, "cell 1 2,alignx right");
		SwingUtilities.updateComponentTreeUI(dialogAddVacancyManagement);		
		if (first==true) {
			first = false;
			buttonSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					String IDSplit = ((String) boxID.getSelectedItem());
					String[] IDParts = IDSplit.split(" - ");
					id = Integer.parseInt(IDParts[0]);
					try {
						Connection con = DriverManager.getConnection(
								"jdbc:mysql://185.28.20.242:3306/u474396146_db",
								"u474396146_aptra", "aptraDB");
						Statement stmt =  con.createStatement();
					    ResultSet rs = stmt.executeQuery("select count(*) from rating where vacancyID = " + DialogOpenVacancy.getID());
					    while (rs.next()) {
					        amount = rs.getInt(1);
					       }
					} catch (Exception e) {
						System.out.println("Fehler auslesen der Anzahl Kriterien" +e.getMessage());
					}
					@SuppressWarnings("rawtypes")
					Vector resultsVacancy = OpenVacancy.openVacancy(id, amount);						
					MenuBarPanelVacancyManagement.modelVacancyManagement.setDataVector(resultsVacancy, MenuBarPanelVacancyManagement.COLUMN_IDENTIFIERS_VACANCYMANAGEMENT);
					boxID.setSelectedIndex(0); 					
					dialogAddVacancyManagement.dispose();
					OpenVacancy.insertInfo(id);
				}
			});
		}
		
		
		buttonAbort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				dialogAddVacancyManagement.dispose();
			}
		});
		dialogAddVacancyManagement.setLocationRelativeTo(Oberflaeche.frame);
		dialogAddVacancyManagement.setVisible(true);
		
	}
	
	public static int getID(){
		return id;
	}
	
}
