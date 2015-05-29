package git_aptra.EditVacancyManagement;

import git_aptra.Login.Login;
import git_aptra.MenuBar.MenuBarPanelVacancyManagement;
import git_aptra.ResponsePDF.ResponseControl;
import git_aptra.VacancyManagement.DialogOpenVacancy;
import git_aptra.VacancyManagement.OpenVacancy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class DialogEditVacancyManagementResponse {
	
	private static JPanel panelDialogEditVacancyManagementResponse = new JPanel();
	
	private static JLabel labelInstruction = new JLabel("Bitte wählen sie die gewünschte Rückmeldung.");
	
	private static String[] response = {  "Bestätigung Bewerbungseingang","Einladung Gespräch", "Vorauswahl", "Zusage","Absage", "Wartepool" };
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static JComboBox boxResponse = new JComboBox(response);
	
	private static JButton buttonSaveResponse = new JButton("Speichern");
	private static JButton buttonAbort = new JButton("Abbrechen");
	
	private static String responseType;
	private static int amount;
	
	public static void editVacancyManagementResponse(){
		boxResponse.setSelectedIndex(0);
		panelDialogEditVacancyManagementResponse.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][]push[]"));
		panelDialogEditVacancyManagementResponse.add(labelInstruction,"cell 0 0 2 1,alignx center");
		panelDialogEditVacancyManagementResponse.add(boxResponse, "cell 0 1 2, growx");
		panelDialogEditVacancyManagementResponse.add(buttonSaveResponse, "cell 0 2,alignx left");
		panelDialogEditVacancyManagementResponse.add(buttonAbort,"cell 1 2,alignx right");
		buttonSaveResponse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				SaveDataEditVacancyManagement.save();
				try {
					InsertEditVacancyManagementDataIntoDatabase.insertEditVacancyManagementDataResponse();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				int id = Integer.parseInt((String) MenuBarPanelVacancyManagement.tableVacancyManagement.getValueAt(MenuBarPanelVacancyManagement.tableVacancyManagement.getSelectedRow(), 0));
				ResponseControl.control(responseType, id);
				int idd = DialogOpenVacancy.getID();
				try {
					Connection con = Login.getConnection();
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
		
		
		DialogEditVacancyManagement.tabEditVacancyManagment.addTab("Rückmeldung",panelDialogEditVacancyManagementResponse);
	}
	public static void getResponse(){
		responseType = (String) boxResponse.getSelectedItem();
	}
	
	public static String getResponseType() {
		return responseType;
	}
}
