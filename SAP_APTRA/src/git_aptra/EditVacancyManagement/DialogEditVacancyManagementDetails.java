package git_aptra.EditVacancyManagement;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class DialogEditVacancyManagementDetails {

	private static JPanel panelDialogEditVacancyManagementDetails = new JPanel();

	private static JLabel labelInstruction = new JLabel("Bitte tragen Sie alle erforderlichen Daten ein!");
	private static JLabel labelMarkApplicant = new JLabel("Eindruck des Bewerber:");
	private static JLabel labelMarkApplication = new JLabel("Eindruck der Bewerbung:");
	private static JLabel labelComplete = new JLabel("Vollständigkeit der Bewerbung:");
	private static JLabel labelCheckCL = new JLabel("Anschreiben:");
	private static JLabel labelCheckCV = new JLabel("Lebenslauf:");

	private static JCheckBox checkCL = new JCheckBox();
	private static JCheckBox checkCV = new JCheckBox();

	private static JTextField fieldMarkApplicant = new JTextField();
	private static JTextField fieldMarkApplication = new JTextField();

	private static JButton buttonSave = new JButton("Speichern");
	private static JButton buttonAbort = new JButton("Abbrechen");
	
	private static Font fontHeadline = new Font("Calibri", Font.BOLD, 16);
	private static Font fontSubHeadline = new Font("Calibri", Font.BOLD, 14);
	private static Font fontText = new Font("Calibri", Font.PLAIN, 14);

	private static String[] status = { "Bitte auswählen", "Bewerbungseingang","Einladung", "Termin", "Vorauswahl", "Zusage","Absage", "Wartepool", "Sonstiges" };
	@SuppressWarnings({ "unchecked", "rawtypes", })
	private static JComboBox boxStatus = new JComboBox(status);
	
	private static String markApplicant;
	private static String markApplication;
	private static boolean CL;
	private static boolean CV;
	
	public static void editVacancyManagementDetails() {
		labelInstruction.setFont(fontHeadline);
		labelMarkApplicant.setFont(fontSubHeadline);
		labelMarkApplication.setFont(fontSubHeadline);
		labelComplete.setFont(fontSubHeadline);
		labelCheckCL.setFont(fontSubHeadline);
		labelCheckCV.setFont(fontSubHeadline);
		checkCL.setFont(fontSubHeadline);
		checkCV.setFont(fontSubHeadline);
		buttonSave.setFont(fontSubHeadline);
		buttonAbort.setFont(fontSubHeadline);
		boxStatus.setFont(fontSubHeadline);
		fieldMarkApplicant.setFont(fontText);
		fieldMarkApplication.setFont(fontText);
		fieldMarkApplicant.setText(EditVacancyManagement.getDataSetApplicantImpression());
		fieldMarkApplication.setText(EditVacancyManagement.getDataSetApplicationImpression());
		if(EditVacancyManagement.getDataSetCoveringLetter()==true){
			checkCL.setSelected(true);
		} else {
			checkCL.setSelected(false);
		}
		if(EditVacancyManagement.getDataSetCurriculumVitae()==true){
			checkCV.setSelected(true);
		} else {
			checkCV.setSelected(false);
		}
		panelDialogEditVacancyManagementDetails.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][][][][][][][][][][][][]"));
		panelDialogEditVacancyManagementDetails.add(labelInstruction, "cell 0 0 2 1,alignx center");
		panelDialogEditVacancyManagementDetails.add(labelMarkApplicant, "cell 0 1,alignx left");
		panelDialogEditVacancyManagementDetails.add(fieldMarkApplicant, "cell 0 2 2 1, growx");
		panelDialogEditVacancyManagementDetails.add(labelMarkApplication, "cell 0 3,alignx left");
		panelDialogEditVacancyManagementDetails.add(fieldMarkApplication, "cell 0 4 2 1, growx");
		panelDialogEditVacancyManagementDetails.add(labelComplete, "cell 0 5,alignx left");
		panelDialogEditVacancyManagementDetails.add(labelCheckCL, "cell 0 6 2,alignx left");
		panelDialogEditVacancyManagementDetails.add(checkCL, "cell 0 6 2 1,alignx left");
		panelDialogEditVacancyManagementDetails.add(labelCheckCV, "cell 0 6 2 2,alignx left");
		panelDialogEditVacancyManagementDetails.add(checkCV, "cell 0 6 2 3,alignx left");
		panelDialogEditVacancyManagementDetails.add(buttonSave, "cell 0 7,alignx left");
		panelDialogEditVacancyManagementDetails.add(buttonAbort, "cell 1 7,alignx right ");
		DialogEditVacancyManagement.tabEditVacancyManagment.addTab("Details",panelDialogEditVacancyManagementDetails);
		
		buttonSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				SaveDataEditVacancyManagement.save();
				try {
					InsertEditVacancyManagementDataIntoDatabase.insertEditVacancyManagementDataDetails();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		
		buttonAbort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				DialogEditVacancyManagement.dialogEditVacancyManagement.dispose();
			}
		});
	}
	
	public static void reset() {
		panelDialogEditVacancyManagementDetails.removeAll();
		fieldMarkApplicant.setText("");
		fieldMarkApplication.setText("");
		checkCL.setSelected(false);
		checkCV.setSelected(false);
		boxStatus.setSelectedIndex(0);
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
