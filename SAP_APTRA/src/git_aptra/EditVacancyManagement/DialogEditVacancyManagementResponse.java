package git_aptra.EditVacancyManagement;

import git_aptra.MenuBar.MenuBarPanelVacancyManagement;
import git_aptra.ResponsePDF.ResponseControl;
import git_aptra.VacancyManagement.DialogOpenVacancy;
import git_aptra.VacancyManagement.OpenVacancy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;





import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class DialogEditVacancyManagementResponse {
	private static JPanel panelDialogEditVacancyManagementResponse = new JPanel();
	private static JLabel labelInstruction = new JLabel(
			"Bitte wählen sie die gewünschte Rückmeldung.");
	private static String[] response = {  "Bestätigung Bewerbungseingang",
		"Einladung Gespräch", "Vorauswahl", "Zusage",
		"Absage", "Wartepool" };
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static JComboBox boxResponse = new JComboBox(response);
	private static JButton saveResponse = new JButton("Speichern");
	private static String responseType;
	private static int amount;
	
	public static void editVacancyManagementResponse(){
		panelDialogEditVacancyManagementResponse.setBackground(Color.LIGHT_GRAY);
		panelDialogEditVacancyManagementResponse.setLayout(new BoxLayout(
				panelDialogEditVacancyManagementResponse, BoxLayout.Y_AXIS));
		panelDialogEditVacancyManagementResponse.add(Box
				.createRigidArea(new Dimension(0, 10)));
		panelDialogEditVacancyManagementResponse.add(labelInstruction);
		panelDialogEditVacancyManagementResponse.add(Box
				.createRigidArea(new Dimension(0, 10)));
		panelDialogEditVacancyManagementResponse.add(boxResponse);
		panelDialogEditVacancyManagementResponse.add(Box
				.createRigidArea(new Dimension(0, 40)));
		panelDialogEditVacancyManagementResponse.add(saveResponse);
		panelDialogEditVacancyManagementResponse.add(Box
				.createRigidArea(new Dimension(0, 350)));
		
		saveResponse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				SaveDataEditVacancyManagement.save();
				InsertEditVacancyManagementDataIntoDatabase.insertEditVacancyManagementDataResponse();
				int id = Integer.parseInt((String) MenuBarPanelVacancyManagement.tableVacancyManagement.getValueAt(MenuBarPanelVacancyManagement.tableVacancyManagement.getSelectedRow(), 0));
				ResponseControl.control(responseType, id);
				int idd = DialogOpenVacancy.getID();
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
				java.util.Vector resultsVacancy = OpenVacancy.openVacancy(idd, amount);						
				MenuBarPanelVacancyManagement.modelVacancyManagement.setDataVector(resultsVacancy, MenuBarPanelVacancyManagement.COLUMN_IDENTIFIERS_VACANCYMANAGEMENT);
			}
		});
		
		
		DialogEditVacancyManagement.tabEditVacancyManagment.addTab("Rückmeldung",
				panelDialogEditVacancyManagementResponse);
	}
	public static void getResponse(){
		responseType = (String) boxResponse.getSelectedItem();
	}
	
	public static void reset() {
		panelDialogEditVacancyManagementResponse.removeAll();
		boxResponse.setSelectedIndex(0);
		ActionListener[] al = saveResponse.getActionListeners();
		saveResponse.removeActionListener(al[0]);
	}
	
	public static String getResponseType() {
		return responseType;
	}
}
