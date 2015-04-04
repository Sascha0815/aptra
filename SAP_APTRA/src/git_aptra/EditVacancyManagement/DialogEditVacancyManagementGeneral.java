package git_aptra.EditVacancyManagement;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
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
	private static JLabel labelDate = new JLabel("Datum:");
	private static JLabel labelNote = new JLabel("Vermerk:");
	private static JLabel labelContributor = new JLabel("Mitarbeiter:");

	private static Integer[] boxListDay = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
			12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28,
			29, 30, 31 };
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static JComboBox boxDateDay = new JComboBox(boxListDay);
	private static Integer[] boxListMonth = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
			11, 12 };
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static JComboBox boxDateMonth = new JComboBox(boxListMonth);
	private static Integer[] boxListYear = { 2015, 2016, 2017, 2018, 2019,
			2020, 2021, 2022, 2023, 2024 };
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static JComboBox boxDateYear = new JComboBox(boxListYear);

	private static Font fontTextField = new Font("Arial", Font.BOLD, 14);

	private static JTextField fieldApplicantID = new JTextField();
	private static JTextField fieldName = new JTextField();
	private static JTextField fieldFirstName = new JTextField();
	private static JTextField fieldNote = new JTextField();

	private static String[] status = { "Bitte auswählen", "Bewerbungseingang",
			"Rückmeldung", "Einladung", "Termin", "Vorauswahl", "Zusage",
			"Absage", "Wartepool", "Sonstiges" };
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static JComboBox boxStatus = new JComboBox(status);
	private static String[] contribute = { "Bitte auswählen",
			"Johannes Vollmer", "Fabian Gierer", "Sascha Pfau", "Praktikant",
			"Sekretärin" };
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static JComboBox boxContributor = new JComboBox(contribute);

	private static JButton saveMain = new JButton("Speichern");

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
		fieldApplicantID.setEditable(false);
		fieldApplicantID.setFont(fontTextField);
		fieldApplicantID.setText(EditVacancyManagement.getDataSetApplicantID());
		panelDialogEditVacancyManagementMain.add(Box
				.createRigidArea(new Dimension(0, 10)));
		panelDialogEditVacancyManagementMain.add(labelName);
		panelDialogEditVacancyManagementMain.add(fieldName);
		fieldName.setEditable(false);
		panelDialogEditVacancyManagementMain.add(Box
				.createRigidArea(new Dimension(0, 10)));
		fieldName.setFont(fontTextField);
		fieldName.setText(EditVacancyManagement.getDataSetName());
		panelDialogEditVacancyManagementMain.add(labelFirstName);
		panelDialogEditVacancyManagementMain.add(fieldFirstName);
		fieldFirstName.setEditable(false);
		panelDialogEditVacancyManagementMain.add(Box
				.createRigidArea(new Dimension(0, 10)));
		fieldFirstName.setFont(fontTextField);
		fieldFirstName.setText(EditVacancyManagement.getDataSetFirstName());
		panelDialogEditVacancyManagementMain.add(Box
				.createRigidArea(new Dimension(0, 10)));
		panelDialogEditVacancyManagementMain.add(labelStatus);
		panelDialogEditVacancyManagementMain.add(boxStatus);
		boxStatus.setSelectedItem(EditVacancyManagement.getDataSetStatus());
		panelDialogEditVacancyManagementMain.add(labelDate);
		boxDateDay.setToolTipText("Tag");
		boxDateDay.setSelectedItem(EditVacancyManagement.getDataSetDay());
		panelDialogEditVacancyManagementMain.add(boxDateDay);
		panelDialogEditVacancyManagementMain.add(Box
				.createRigidArea(new Dimension(0, 10)));
		boxDateMonth.setToolTipText("Monat");
		boxDateMonth.setSelectedItem(EditVacancyManagement.getDataSetMonth());
		panelDialogEditVacancyManagementMain.add(boxDateMonth);
		panelDialogEditVacancyManagementMain.add(Box
				.createRigidArea(new Dimension(0, 10)));
		boxDateYear.setToolTipText("Jahr");
		boxDateYear.setSelectedItem(EditVacancyManagement.getDataSetYear());
		panelDialogEditVacancyManagementMain.add(boxDateYear);
		panelDialogEditVacancyManagementMain.add(Box
				.createRigidArea(new Dimension(0, 10)));
		panelDialogEditVacancyManagementMain.add(labelNote);
		panelDialogEditVacancyManagementMain.add(fieldNote);
		panelDialogEditVacancyManagementMain.add(Box
				.createRigidArea(new Dimension(0, 10)));
		panelDialogEditVacancyManagementMain.add(labelContributor);
		boxContributor.setToolTipText("Mitarbeiter");
		panelDialogEditVacancyManagementMain.add(boxContributor);
		panelDialogEditVacancyManagementMain.add(Box
				.createRigidArea(new Dimension(0, 10)));
		panelDialogEditVacancyManagementMain.add(saveMain);

		DialogEditVacancyManagement.tabEditVacancyManagment.addTab("Übersicht",
				panelDialogEditVacancyManagementMain);
	}

	public static void reset() {
		panelDialogEditVacancyManagementMain.removeAll();
		fieldApplicantID.setText("");
		fieldName.setText("");
		fieldFirstName.setText("");
		fieldNote.setText("");
		boxStatus.setSelectedIndex(0);
		boxContributor.setSelectedIndex(0);
	}
}
