package git_aptra.DialogAddVacancy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DialogAddVacancyGeneral {

	private static Font fontHeadline = new Font("Arial", Font.BOLD, 18);
	private static Font fontTextField = new Font("Arial", Font.BOLD, 14);

	private static JPanel panelDialogVacancyMain = new JPanel();

	private static JLabel labelArea = new JLabel();
	private static JLabel labelInstruction2 = new JLabel();
	private static JLabel labelPosition = new JLabel();
	private static JLabel labelRequirementLevel = new JLabel();

	private static JTextField fieldArea = new JTextField();
	private static JTextField fieldPosition = new JTextField();

	static String[] boxListRequirementLevel = { "Bitte auswählen",
			"Praktikant", "Auszubildender", "Student", "Angestellter" };
	@SuppressWarnings({ "unchecked", "rawtypes" })
	static JComboBox boxRequirementLevel = new JComboBox(
			boxListRequirementLevel);
	private static JLabel labelTermsOfEmployment = new JLabel();
	static String[] boxListTermsOfEmployment = { "Bitte auswählen", "Vollzeit",
			"Teilzeit", "Aushilfe", "Schichtarbeit" };
	@SuppressWarnings({ "unchecked", "rawtypes" })
	static JComboBox boxTermsOfEmployment = new JComboBox(
			boxListTermsOfEmployment);
	private static JLabel labelVacancyStatus = new JLabel();
	static String[] boxListVacancyStatus = { "Bitte auswählen", "Freigegeben",
			"", "Bewerbungsgespräche", "Vorauswahl", "Abgeschlossen" };
	@SuppressWarnings({ "unchecked", "rawtypes" })
	static JComboBox boxVacancyStatus = new JComboBox(boxListVacancyStatus);
	private static JLabel labelEducationalAchievement = new JLabel(
			"Höchster Bildungsabschluss:");
	static String[] boxListEducationalAchievement = { "Bitte auswählen",
			"Haupptschulabschluss", "Mittlere Reife", "Abitur", "Studium" };
	@SuppressWarnings({ "unchecked", "rawtypes" })
	static JComboBox boxEducationalAchievement = new JComboBox(
			boxListEducationalAchievement);

	public static void addVacancyGeneral() {

		panelDialogVacancyMain.setBackground(Color.LIGHT_GRAY);
		panelDialogVacancyMain.setLayout(new BoxLayout(panelDialogVacancyMain,
				BoxLayout.Y_AXIS));
		panelDialogVacancyMain.add(Box.createRigidArea(new Dimension(0, 10)));
		panelDialogVacancyMain.add(labelInstruction2);
		labelInstruction2
				.setText("Bitte tragen Sie alle erfoderlichen Daten ein!");
		labelInstruction2.setFont(fontHeadline);
		panelDialogVacancyMain.add(Box.createRigidArea(new Dimension(0, 10)));
		panelDialogVacancyMain.add(labelPosition);
		labelPosition.setText("Stellenbezeichnung:");
		panelDialogVacancyMain.add(fieldPosition);
		panelDialogVacancyMain.add(Box.createRigidArea(new Dimension(0, 10)));
		fieldPosition.setFont(fontTextField);
		panelDialogVacancyMain.add(labelArea);
		labelArea.setText("Arbeitsbereich:");
		panelDialogVacancyMain.add(fieldArea);
		panelDialogVacancyMain.add(Box.createRigidArea(new Dimension(0, 10)));
		fieldArea.setFont(fontTextField);
		labelRequirementLevel.setText("Anforderung:");
		panelDialogVacancyMain.add(labelRequirementLevel);
		boxRequirementLevel.setToolTipText("Anforderung");
		panelDialogVacancyMain.add(boxRequirementLevel);
		labelTermsOfEmployment.setText("Anstellungsverhältnis:");
		panelDialogVacancyMain.add(labelTermsOfEmployment);
		boxTermsOfEmployment.setToolTipText("Anstellungsverhältnis");
		panelDialogVacancyMain.add(boxTermsOfEmployment);
		labelVacancyStatus.setText("Status:");
		panelDialogVacancyMain.add(labelVacancyStatus);
		boxVacancyStatus.setToolTipText("Status");
		panelDialogVacancyMain.add(boxVacancyStatus);

		panelDialogVacancyMain.add(labelEducationalAchievement);
		boxEducationalAchievement
				.setToolTipText("Benötigter Bildungsabschluss:");
		panelDialogVacancyMain.add(boxEducationalAchievement);
		DialogAddVacancy.tabVacancy.addTab("Allgemein", panelDialogVacancyMain);

	}

	private static String position;
	private static String area;
	private static String requirementLevel;
	private static String termsOfEmployment;
	private static String educationalAchievementVacancy;
	private static String vacancyStatus;
	
	public static boolean getGeneral() {
		try {
			position = fieldPosition.getText();
			area = fieldArea.getText();
			requirementLevel = String.valueOf(boxRequirementLevel
					.getSelectedItem());
			termsOfEmployment = String.valueOf(boxTermsOfEmployment
					.getSelectedItem());
			educationalAchievementVacancy = String.valueOf(boxEducationalAchievement
					.getSelectedItem());
			vacancyStatus = String.valueOf(boxVacancyStatus
					.getSelectedItem());
		} catch (Exception e) {
			System.out.println("Nicht alle Daten eingegeben");
		}

		if (area.equals("")) {
			return false;
		}
		if (position.equals("")) {
			return false;
		} 
		if (requirementLevel.equals("")) {
			return false;
		}
		if (termsOfEmployment.equals("")) {
			return false;
		}
		if (educationalAchievementVacancy.equals("")) {
			return false;
		}
		if (vacancyStatus.equals("")) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public static void reset() {
		panelDialogVacancyMain.removeAll();
		fieldArea.setText("");
		fieldPosition.setText("");
		boxRequirementLevel.setSelectedIndex(0);
		boxTermsOfEmployment.setSelectedIndex(0);
		boxVacancyStatus.setSelectedIndex(0);
		boxEducationalAchievement.setSelectedIndex(0);
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
