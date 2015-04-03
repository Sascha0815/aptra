package git_aptra.EditVacancyManagement;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

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

	private static JLabel labelMarkApplicant = new JLabel("Eindruck des Bewerber:");
	private static JLabel labelMarkApplication = new JLabel("Eindruck der Bewerbung:");
	private static JLabel labelComplete = new JLabel("Vollständigkeit der Bewerbung:");
	private static JLabel labelCheckCL = new JLabel ("Anschreiben");
	private static JLabel labelCheckCV = new JLabel ("Lebenslauf");
	
	private static JCheckBox checkCL = new JCheckBox("Anschreiben");
	private static JCheckBox checkCV = new JCheckBox("Lebenslauf");
	
	private static Font fontTextField = new Font("Arial", Font.BOLD, 14);

	private static JTextField fieldMarkApplicant = new JTextField();
	private static JTextField fieldMarkApplication = new JTextField();
	
	private static JButton saveDetails = new JButton("Speichern");



	private static String[] status = {"Bitte auswählen", "Bewerbungseingang", "Rückmeldung",
			"Einladung", "Termin", "Vorauswahl", "Zusage", "Absage",
			"Wartepool", "Sonstiges" };
	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	private static JComboBox boxStatus = new JComboBox(status);
	private static String[] contribute = {"Bitte auswählen", 
		"Johannes Vollmer", "Fabian Gierer", "Sascha Pfau", "Praktikant", "Sekretärin"};
	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	private static JComboBox boxContributor = new JComboBox(contribute);
	
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
		panelDialogEditVacancyManagementDetails.add(Box
				.createRigidArea(new Dimension(0, 10)));
		panelDialogEditVacancyManagementDetails.add(labelMarkApplication);
		panelDialogEditVacancyManagementDetails.add(fieldMarkApplication);
		panelDialogEditVacancyManagementDetails.add(Box
				.createRigidArea(new Dimension(0, 10)));
		fieldMarkApplication.setFont(fontTextField);
		panelDialogEditVacancyManagementDetails.add(labelComplete);
		panelDialogEditVacancyManagementDetails.add(Box
				.createRigidArea(new Dimension(0, 10)));
		panelDialogEditVacancyManagementDetails.add(labelCheckCL);
		panelDialogEditVacancyManagementDetails.add(checkCL);
		panelDialogEditVacancyManagementDetails.add(Box
				.createRigidArea(new Dimension(0, 10)));
		panelDialogEditVacancyManagementDetails.add(labelCheckCV);
		panelDialogEditVacancyManagementDetails.add(checkCV);
		panelDialogEditVacancyManagementDetails.add(Box
				.createRigidArea(new Dimension(0, 10)));
		panelDialogEditVacancyManagementDetails.add(saveDetails);

		DialogEditVacancyManagement.tabEditVacancyManagment.addTab("Details",
				panelDialogEditVacancyManagementDetails);
	}
}
