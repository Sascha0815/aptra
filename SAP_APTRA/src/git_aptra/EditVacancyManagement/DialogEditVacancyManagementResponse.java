package git_aptra.EditVacancyManagement;

import git_aptra.Login.Login;
import git_aptra.MenuBar.MenuBarPanelVacancyManagement;
import git_aptra.ResponsePDF.ResponseControl;
import git_aptra.VacancyManagement.DialogOpenVacancy;
import git_aptra.VacancyManagement.OpenVacancy;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import lu.tudor.santec.jtimechooser.JTimeChooser;

import com.toedter.calendar.JDateChooser;

import net.miginfocom.swing.MigLayout;

public class DialogEditVacancyManagementResponse {
	
	private static JPanel panelDialogEditVacancyManagementResponse = new JPanel();
	
	private static JLabel labelInstruction = new JLabel("Bitte wählen sie die gewünschte Rückmeldung.");
	
	private static String[] response = {  "Bestätigung Bewerbungseingang","Einladung Gespräch", "Vorauswahl", "Zusage","Absage", "Wartepool" };
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static JComboBox boxResponse = new JComboBox(response);
	
	private static JButton buttonSaveResponse = new JButton("Speichern");
	private static JButton buttonAbort = new JButton("Abbrechen");
	
	private static JLabel labelLocation = new JLabel("Raumnummer:");
	private static JLabel labelDate = new JLabel("Datum Termin:");
	private static JLabel labelTime = new JLabel("Uhrzeit:");
	
	private static JDateChooser dateChooserDate = new JDateChooser();
	
	private static JTextField fieldLocation = new JTextField();
	private static JTimeChooser timeChooser = new JTimeChooser();
	
	private static String responseType;
	private static int amount;
	private static boolean first = true;
	private static String location;
	private static String date;
	private static int hour;
	private static int minute;
	private static String time;
	
	public static void editVacancyManagementResponse(){
		boxResponse.setSelectedIndex(0);
		labelLocation.setVisible(false);
		labelDate.setVisible(false);
		labelTime.setVisible(false);
		dateChooserDate.setVisible(false);
		timeChooser.setVisible(false);
		fieldLocation.setVisible(false);
		panelDialogEditVacancyManagementResponse.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][][][][][][][]push[]"));
		panelDialogEditVacancyManagementResponse.add(labelInstruction,"cell 0 0 2 1,alignx center");
		panelDialogEditVacancyManagementResponse.add(boxResponse, "cell 0 1 2, growx");
		panelDialogEditVacancyManagementResponse.add(labelLocation, "cell 0 2,alignx left");
		panelDialogEditVacancyManagementResponse.add(fieldLocation, "cell 0 3 2 1,growx");
		panelDialogEditVacancyManagementResponse.add(labelDate, "cell 0 4,alignx left");
		panelDialogEditVacancyManagementResponse.add(dateChooserDate, "cell 0 5 2, growx");
		panelDialogEditVacancyManagementResponse.add(labelTime, "cell 0 6,alignx left");
		panelDialogEditVacancyManagementResponse.add(timeChooser, "cell 0 7 2 1,growx");
		panelDialogEditVacancyManagementResponse.add(buttonSaveResponse, "cell 0 8,alignx left");
		panelDialogEditVacancyManagementResponse.add(buttonAbort,"cell 1 8,alignx right");
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
		if (first==true) {
			first = false;
			 ItemListener itemListener = new ItemListener() {
					@Override
					public void itemStateChanged(ItemEvent e) {
						 if (boxResponse.getSelectedItem().equals("Einladung Gespräch")) {
								labelLocation.setVisible(true);
								labelDate.setVisible(true);
								labelTime.setVisible(true);
								dateChooserDate.setVisible(true);
								timeChooser.setVisible(true);
								fieldLocation.setVisible(true);
						}
					}
			 };
				 boxResponse.addItemListener(itemListener);
		}
		
		
		DialogEditVacancyManagement.tabEditVacancyManagment.addTab("Rückmeldung",panelDialogEditVacancyManagementResponse);
	}
	public static void getResponse(){
		responseType = (String) boxResponse.getSelectedItem();
		try {
			location = fieldLocation.getText();
		} catch (Exception e) {
		}
		try {
			hour = timeChooser.getHours();
			minute = timeChooser.getMinutes();
			time = hour + ":" + minute;
		} catch (Exception e) {
		}
		try {
			date = ((JTextField)dateChooserDate.getDateEditor().getUiComponent()).getText(); 
		} catch (Exception e) {
		}
	}
	
	public static String getResponseType() {
		return responseType;
	}
	
	public static String getLocation(){
		return location;
	}
	
	public static String getCal(){
		return date;
	}
	
	public static String getTime(){
		return time;
	}
}
