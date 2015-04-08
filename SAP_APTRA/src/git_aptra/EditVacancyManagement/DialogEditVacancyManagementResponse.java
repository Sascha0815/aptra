package git_aptra.EditVacancyManagement;

import git_aptra.MenuBar.MenuBarPanelVacancyManagement;
import git_aptra.ResponsePDF.ResponseControl;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

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
	private static String[] contribute = { "Johannes Vollmer", "Fabian Gierer", "Sascha Pfau", "Praktikant",
		"Sekretärin" };
	@SuppressWarnings({ "unchecked", "rawtypes", })
	private static JComboBox boxContributor = new JComboBox(contribute);
	private static JLabel labelContributor = new JLabel("Mitarbeiter:");
	private static String name;
	private static String responseType;

	
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
				.createRigidArea(new Dimension(0, 10)));
		panelDialogEditVacancyManagementResponse.add(labelContributor);
		panelDialogEditVacancyManagementResponse.add(Box
				.createRigidArea(new Dimension(0, 10)));
		panelDialogEditVacancyManagementResponse.add(boxContributor);
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
			}
		});
		
		
		DialogEditVacancyManagement.tabEditVacancyManagment.addTab("Rückmeldung",
				panelDialogEditVacancyManagementResponse);
	}
	public static void getResponse(){
		responseType = (String) boxResponse.getSelectedItem();
		name = (String) boxContributor.getSelectedItem();
	}
	
	public static void reset() {
		panelDialogEditVacancyManagementResponse.removeAll();
		boxResponse.setSelectedIndex(0);
		boxContributor.setSelectedIndex(0);
		ActionListener[] al = saveResponse.getActionListeners();
		saveResponse.removeActionListener(al[0]);
	}
	
	public static String getResponseType() {
		return responseType;
	}
	public static String getName() {
		return name;
	}
}
