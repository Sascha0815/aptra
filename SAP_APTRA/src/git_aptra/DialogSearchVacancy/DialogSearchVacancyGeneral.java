package git_aptra.DialogSearchVacancy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class DialogSearchVacancyGeneral {
	
	private static Font fontHeadline = new Font("Arial", Font.BOLD, 18);
	private static Font fontTextField = new Font("Arial", Font.BOLD, 14);

	private static JPanel panelSearchDialogVacancyMain = new JPanel();

	private static JLabel labelVacancyID = new JLabel();
	private static JLabel labelArea = new JLabel();
	private static JLabel labelInstruction2 = new JLabel();
	private static JLabel labelPosition = new JLabel();
	private static JLabel labelRequirementLevel = new JLabel();

	private static JTextField fieldVacancyID = new JTextField();
	private static JTextField fieldArea = new JTextField();
	private static JTextField fieldPosition = new JTextField();

	static String[] boxListRequirementLevel = { "Bitte ausw�hlen",
			"Praktikant", "Auszubildender", "Student", "Angestellter" };
	@SuppressWarnings({ "unchecked", "rawtypes" })
	static JComboBox boxRequirementLevel = new JComboBox(
			boxListRequirementLevel);
	private static JLabel labelTermsOfEmployment = new JLabel();
	static String[] boxListTermsOfEmployment = { "Bitte ausw�hlen", "Vollzeit",
			"Teilzeit", "Aushilfe", "Schichtarbeit" };
	@SuppressWarnings({ "unchecked", "rawtypes" })
	static JComboBox boxTermsOfEmployment = new JComboBox(
			boxListTermsOfEmployment);
	private static JLabel labelVacancyStatus = new JLabel();
	static String[] boxListVacancyStatus = { "Bitte ausw�hlen", "Freigegeben",
		"Bewerbungsschluss", "Vorauswahl", "Bewerbungsgespr�che","Entscheidung", "Abgeschlossen" };
	@SuppressWarnings({ "unchecked", "rawtypes" })
	static JComboBox boxVacancyStatus = new JComboBox(boxListVacancyStatus);
	private static JLabel labelEducationalAchievement = new JLabel(
			"H�chster Bildungsabschluss:");
	static String[] boxListEducationalAchievement = { "Bitte ausw�hlen",
			"Haupptschulabschluss", "Mittlere Reife", "Abitur", "Studium" };
	@SuppressWarnings({ "unchecked", "rawtypes" })
	static JComboBox boxEducationalAchievement = new JComboBox(
			boxListEducationalAchievement);

	public static void searchVacancyGeneral() {

		panelSearchDialogVacancyMain.setBackground(Color.LIGHT_GRAY);
		panelSearchDialogVacancyMain.setLayout(new BoxLayout(panelSearchDialogVacancyMain,
				BoxLayout.Y_AXIS));
		panelSearchDialogVacancyMain.add(Box.createRigidArea(new Dimension(0, 10)));
		panelSearchDialogVacancyMain.add(labelInstruction2);
		labelInstruction2
				.setText("Bitte tragen Sie die gesuchten Daten ein!");
		labelInstruction2.setFont(fontHeadline);
		
		panelSearchDialogVacancyMain.add(Box.createRigidArea(new Dimension(0, 10)));
		panelSearchDialogVacancyMain.add(labelVacancyID);
		labelVacancyID.setText("Identifikationsnummer:");
		panelSearchDialogVacancyMain.add(fieldVacancyID);
		panelSearchDialogVacancyMain.add(Box.createRigidArea(new Dimension(0, 10)));
		panelSearchDialogVacancyMain.add(labelPosition);
		labelPosition.setText("Stellenbezeichnung:");
		panelSearchDialogVacancyMain.add(fieldPosition);
		panelSearchDialogVacancyMain.add(Box.createRigidArea(new Dimension(0, 10)));
		fieldPosition.setFont(fontTextField);
		panelSearchDialogVacancyMain.add(labelArea);
		labelArea.setText("Arbeitsbereich:");
		panelSearchDialogVacancyMain.add(fieldArea);
		panelSearchDialogVacancyMain.add(Box.createRigidArea(new Dimension(0, 10)));
		fieldArea.setFont(fontTextField);
		labelRequirementLevel.setText("Anforderung:");
		panelSearchDialogVacancyMain.add(labelRequirementLevel);
		boxRequirementLevel.setToolTipText("Anforderung");
		panelSearchDialogVacancyMain.add(boxRequirementLevel);
		labelTermsOfEmployment.setText("Anstellungsverh�ltnis:");
		panelSearchDialogVacancyMain.add(labelTermsOfEmployment);
		boxTermsOfEmployment.setToolTipText("Anstellungsverh�ltnis");
		panelSearchDialogVacancyMain.add(boxTermsOfEmployment);
		labelVacancyStatus.setText("Status:");
		panelSearchDialogVacancyMain.add(labelVacancyStatus);
		boxVacancyStatus.setToolTipText("Status");
		panelSearchDialogVacancyMain.add(boxVacancyStatus);

		panelSearchDialogVacancyMain.add(labelEducationalAchievement);
		boxEducationalAchievement
				.setToolTipText("Ben�tigter Bildungsabschluss:");
		panelSearchDialogVacancyMain.add(boxEducationalAchievement);
		DialogSearchVacancy.tabSearchVacancy.addTab("Allgemein", panelSearchDialogVacancyMain);

	}

	private static String vacancyID;
	private static String position;
	private static String area;
	private static String requirementLevel;
	private static String termsOfEmployment;
	private static String educationalAchievementVacancy;
	private static String vacancyStatus;
	
	public static void getGeneral() {
		try {
			vacancyID = fieldVacancyID.getText();
			position = fieldPosition.getText();
			area = fieldArea.getText();
			requirementLevel = String.valueOf(boxRequirementLevel
					.getSelectedItem());
			if (requirementLevel.equals("Bitte ausw�hlen")) {
				requirementLevel = "";
			}
			termsOfEmployment = String.valueOf(boxTermsOfEmployment
					.getSelectedItem());
			if (termsOfEmployment.equals("Bitte ausw�hlen")) {
				termsOfEmployment = "";
			}
			educationalAchievementVacancy = String.valueOf(boxEducationalAchievement
					.getSelectedItem());
			if (educationalAchievementVacancy.equals("Bitte ausw�hlen")) {
				educationalAchievementVacancy = "";
			}
			vacancyStatus = String.valueOf(boxVacancyStatus
					.getSelectedItem());
			if (vacancyStatus.equals("Bitte ausw�hlen")) {
				vacancyStatus = "";
			}
		} catch (Exception e) {
			System.out.println("Nicht alle Daten eingegeben");
		}
	}
	
	public static void reset() {
		panelSearchDialogVacancyMain.removeAll();
		fieldVacancyID.setText("");
		fieldArea.setText("");
		fieldPosition.setText("");
		boxRequirementLevel.setSelectedIndex(0);
		boxTermsOfEmployment.setSelectedIndex(0);
		boxVacancyStatus.setSelectedIndex(0);
		boxEducationalAchievement.setSelectedIndex(0);
	}

	public static String getVacancyID(){
		return vacancyID;
	}
	public static String getRequirementLevel() {
		return requirementLevel;
	}

	public static String getTermsOfEmployment() {
		return termsOfEmployment;
	}

	public static String getEducationalAchievementVacancy() {
		return educationalAchievementVacancy;
	}

	public static String getVacancyStatus() {
		return vacancyStatus;
	}

	public static String getArea() {
		return area;
	}

	public static String getPosition() {
		return position;
	}
}

