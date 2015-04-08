package git_aptra.EditVacancyManagement;

import git_aptra.InfoApplicant.InfoApplicant;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;



import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DialogEditVacancyManagementDetails {

	private static JPanel panelDialogEditVacancyManagementDetails = new JPanel();

	private static JLabel labelMarkApplicant = new JLabel(
			"Eindruck des Bewerber:");
	private static JLabel labelMarkApplication = new JLabel(
			"Eindruck der Bewerbung:");
	private static JLabel labelComplete = new JLabel(
			"Vollständigkeit der Bewerbung:");
	private static JLabel labelCheckCL = new JLabel("Anschreiben");
	private static JLabel labelCheckCV = new JLabel("Lebenslauf");

	private static JCheckBox checkCL = new JCheckBox("Anschreiben");
	private static JCheckBox checkCV = new JCheckBox("Lebenslauf");

	private static Font fontTextField = new Font("Arial", Font.BOLD, 14);

	private static JTextField fieldMarkApplicant = new JTextField();
	private static JTextField fieldMarkApplication = new JTextField();

	private static JButton saveDetails = new JButton("Speichern");

	private static String[] status = { "Bitte auswählen", "Bewerbungseingang",
			"Einladung", "Termin", "Vorauswahl", "Zusage",
			"Absage", "Wartepool", "Sonstiges" };
	@SuppressWarnings({ "unchecked", "rawtypes", })
	private static JComboBox boxStatus = new JComboBox(status);
	private static String[] contribute = { "Bitte auswählen",
			"Johannes Vollmer", "Fabian Gierer", "Sascha Pfau", "Praktikant",
			"Sekretärin" };
	@SuppressWarnings({ "unchecked", "rawtypes", })
	private static JComboBox boxContributor = new JComboBox(contribute);

	private static String markApplicant;
	private static String markApplication;
	private static boolean CL;
	private static boolean CV;
	
	
	public static void editVacancyManagementDetails() {
		panelDialogEditVacancyManagementDetails.setBackground(Color.LIGHT_GRAY);
		panelDialogEditVacancyManagementDetails.setLayout(new BoxLayout(
				panelDialogEditVacancyManagementDetails, BoxLayout.Y_AXIS));
		panelDialogEditVacancyManagementDetails.add(Box
				.createRigidArea(new Dimension(0, 10)));
		panelDialogEditVacancyManagementDetails.add(labelMarkApplicant);
		panelDialogEditVacancyManagementDetails.add(Box
				.createRigidArea(new Dimension(0, 10)));
		panelDialogEditVacancyManagementDetails.add(fieldMarkApplicant);
		fieldMarkApplicant.setFont(fontTextField);
		fieldMarkApplicant.setText(InfoApplicant.getDataSetMarkApplicant());
		panelDialogEditVacancyManagementDetails.add(Box
				.createRigidArea(new Dimension(0, 10)));
		panelDialogEditVacancyManagementDetails.add(labelMarkApplication);
		panelDialogEditVacancyManagementDetails.add(fieldMarkApplication);
		panelDialogEditVacancyManagementDetails.add(Box
				.createRigidArea(new Dimension(0, 10)));
		fieldMarkApplication.setFont(fontTextField);
		fieldMarkApplication.setText(InfoApplicant.getDataSetMarkApplication());
		panelDialogEditVacancyManagementDetails.add(labelComplete);
		panelDialogEditVacancyManagementDetails.add(Box
				.createRigidArea(new Dimension(0, 10)));
		panelDialogEditVacancyManagementDetails.add(labelCheckCL);
		panelDialogEditVacancyManagementDetails.add(checkCL);
		if(InfoApplicant.getDataSetCL()==true){
			checkCL.setSelected(true);
		}else {
			checkCL.setSelected(false);
		}
		panelDialogEditVacancyManagementDetails.add(Box
				.createRigidArea(new Dimension(0, 10)));
		panelDialogEditVacancyManagementDetails.add(labelCheckCV);
		panelDialogEditVacancyManagementDetails.add(checkCV);
		if(InfoApplicant.getDataSetCV()==true){
			checkCV.setSelected(true);
		}else {
			checkCV.setSelected(false);
		}
		panelDialogEditVacancyManagementDetails.add(Box
				.createRigidArea(new Dimension(0, 10)));
		panelDialogEditVacancyManagementDetails.add(saveDetails);
		
		saveDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				SaveDataEditVacancyManagement.save();
				try {
					InsertEditVacancyManagementDataIntoDatabase.insertEditVacancyManagementDataDetails();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});

		DialogEditVacancyManagement.tabEditVacancyManagment.addTab("Details",
				panelDialogEditVacancyManagementDetails);
	}
	
	

	public static void reset() {
		panelDialogEditVacancyManagementDetails.removeAll();
		fieldMarkApplicant.setText("");
		fieldMarkApplication.setText("");
		checkCL.setSelected(false);
		checkCV.setSelected(false);
		boxStatus.setSelectedIndex(0);
		boxContributor.setSelectedIndex(0);
	}
	
	public static void getDetails() {
		try {
			markApplicant = fieldMarkApplicant.getText();
		} catch (Exception e) {
		}
		try {
			markApplication = fieldMarkApplication.getText();
		} catch (Exception e) {
		}
		try {
			if(checkCL.isSelected()){
				CL = true;
			}
		} catch (Exception e) {
		}
		try {
			if(checkCV.isSelected()){
				CV = true;
			}
		} catch (Exception e) {
		}
		
	}
	
	public static String getMarkApplicant() {
		return markApplicant;
	}
	
	public static String getMarkApplication() {
		return markApplication;
	}
	
	public static boolean getCL(){
		return CL;
	}
	
	public static boolean getCV(){
		return CV;
	}
}
