package git_aptra.EditVacancyManagement;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DialogEditVacancyManagementGeneral {
	private static JPanel panelDialogEditVacancyManagementMain = new JPanel();

	private static JLabel labelApplicantID = new JLabel("Bewerber-ID:");
	private static JLabel labelName = new JLabel("Name:");
	private static JLabel labelFirstName = new JLabel("Vorname:");
	private static JLabel labelStatus = new JLabel("Status:");
	

	private static Font fontTextField = new Font("Arial", Font.BOLD, 14);

	private static JTextField fieldApplicantID = new JTextField();
	private static JTextField fieldName = new JTextField();
	private static JTextField fieldFirstName = new JTextField();


	private static String[] status = {"Bitte auswählen", "Bewerbungseingang", "Rückmeldung",
			"Einladung", "Termin", "Vorauswahl", "Zusage", "Absage",
			"Wartepool", "Sonstiges" };
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static JComboBox boxStatus = new JComboBox(status);

	public static void editVacancyManagementGeneral() {
		panelDialogEditVacancyManagementMain.setBackground(Color.LIGHT_GRAY);
		panelDialogEditVacancyManagementMain.setLayout(new BoxLayout(
				panelDialogEditVacancyManagementMain, BoxLayout.Y_AXIS));
		panelDialogEditVacancyManagementMain.add(Box
				.createRigidArea(new Dimension(0, 10)));
		panelDialogEditVacancyManagementMain.add(labelApplicantID);
		panelDialogEditVacancyManagementMain.add(Box
				.createRigidArea(new Dimension(0, 10)));
		panelDialogEditVacancyManagementMain.add(fieldApplicantID);
		fieldApplicantID.setFont(fontTextField);
		panelDialogEditVacancyManagementMain.add(Box
				.createRigidArea(new Dimension(0, 10)));
		panelDialogEditVacancyManagementMain.add(labelName);
		panelDialogEditVacancyManagementMain.add(fieldName);
		panelDialogEditVacancyManagementMain.add(Box
				.createRigidArea(new Dimension(0, 10)));
		fieldName.setFont(fontTextField);
		panelDialogEditVacancyManagementMain.add(labelFirstName);
		panelDialogEditVacancyManagementMain.add(fieldFirstName);
		panelDialogEditVacancyManagementMain.add(Box
				.createRigidArea(new Dimension(0, 10)));
		fieldFirstName.setFont(fontTextField);
		panelDialogEditVacancyManagementMain.add(Box
				.createRigidArea(new Dimension(0, 10)));
		panelDialogEditVacancyManagementMain.add(labelStatus);
		panelDialogEditVacancyManagementMain.add(boxStatus);
		

		DialogEditVacancyManagement.tabEditVacancyManagment.addTab("Übersicht",
				panelDialogEditVacancyManagementMain);
	}
}
