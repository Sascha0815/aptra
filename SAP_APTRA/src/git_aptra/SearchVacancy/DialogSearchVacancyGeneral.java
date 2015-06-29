package git_aptra.SearchVacancy;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
//Dialog Suchfunktion Arbeitsstelle 1.Tab
public class DialogSearchVacancyGeneral {

	private static JPanel panelSearchDialogVacancyMain = new JPanel();

	private static JLabel labelVacancyID = new JLabel("Stellen-ID:");
	private static JLabel labelArea = new JLabel("Arbeitsbereich:");
	private static JLabel labelInstruction = new JLabel("Bitte tragen Sie die gesuchten Daten ein!");
	private static JLabel labelPosition = new JLabel("Stellenbezeichnung:");
	private static JLabel labelRequirementLevel = new JLabel("Anforderung:");
	private static JLabel labelTermsOfEmployment = new JLabel("Anstellungsverhältnis:");
	private static JLabel labelEducationalAchievement = new JLabel("Höchster Bildungsabschluss:");
	private static JLabel labelVacancyStatus = new JLabel("Status:");

	private static JTextField fieldVacancyID = new JTextField();
	private static JTextField fieldArea = new JTextField();
	private static JTextField fieldPosition = new JTextField();
	
	private static JButton buttonContinue = new JButton("Weiter");
	
	private static Font fontHeadline = new Font("Calibri", Font.BOLD, 16);

	static String[] boxListRequirementLevel = { "Bitte auswählen", "Praktikant", "Auszubildender", "Student", "Angestellter" };
	@SuppressWarnings({ "unchecked", "rawtypes" })
	static JComboBox boxRequirementLevel = new JComboBox(boxListRequirementLevel);
	static String[] boxListTermsOfEmployment = { "Bitte auswählen", "Vollzeit",	"Teilzeit", "Aushilfe", "Schichtarbeit" };
	@SuppressWarnings({ "unchecked", "rawtypes" })
	static JComboBox boxTermsOfEmployment = new JComboBox(boxListTermsOfEmployment);
	static String[] boxListVacancyStatus = { "Bitte auswählen", "Freigegeben", "Bewerbungsschluss", "Vorauswahl", "Bewerbungsgespräche","Entscheidung", "Abgeschlossen" };
	@SuppressWarnings({ "unchecked", "rawtypes" })
	static JComboBox boxVacancyStatus = new JComboBox(boxListVacancyStatus);
	static String[] boxListEducationalAchievement = { "Bitte auswählen", "Haupptschulabschluss", "Mittlere Reife", "Abitur", "Studium" };
	@SuppressWarnings({ "unchecked", "rawtypes" })
	static JComboBox boxEducationalAchievement = new JComboBox(boxListEducationalAchievement);

	public static void searchVacancyGeneral() {
		fieldArea.setText("");
		fieldPosition.setText("");
		fieldVacancyID.setText("");
		boxRequirementLevel.setSelectedIndex(0);
		boxTermsOfEmployment.setSelectedIndex(0);
		boxVacancyStatus.setSelectedIndex(0);
		boxEducationalAchievement.setSelectedIndex(0);
		labelInstruction.setFont(fontHeadline);
		panelSearchDialogVacancyMain.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][][][][][][][][][][][][][][]push[]"));
		panelSearchDialogVacancyMain.add(labelInstruction, "cell 0 0 2 1,alignx center");
		panelSearchDialogVacancyMain.add(labelVacancyID, "cell 0 1,alignx left");
		panelSearchDialogVacancyMain.add(fieldVacancyID, "cell 0 2 2 1,growx");
		panelSearchDialogVacancyMain.add(labelPosition, "cell 0 3,alignx left");
		panelSearchDialogVacancyMain.add(fieldPosition, "cell 0 4 2 1,growx");
		panelSearchDialogVacancyMain.add(labelArea, "cell 0 5");
		panelSearchDialogVacancyMain.add(fieldArea, "cell 0 6 2 1,growx");
		panelSearchDialogVacancyMain.add(labelRequirementLevel, "cell 0 7");
		panelSearchDialogVacancyMain.add(boxRequirementLevel, "cell 0 8 2 1,growx");
		panelSearchDialogVacancyMain.add(labelTermsOfEmployment, "cell 0 9");
		panelSearchDialogVacancyMain.add(boxTermsOfEmployment, "cell 0 10 2 1,growx");
		panelSearchDialogVacancyMain.add(labelVacancyStatus, "cell 0 11");
		panelSearchDialogVacancyMain.add(boxVacancyStatus, "cell 0 12 2 1,growx");
		panelSearchDialogVacancyMain.add(labelEducationalAchievement, "cell 0 13");
		panelSearchDialogVacancyMain.add(boxEducationalAchievement, "cell 0 14 2 1,growx");
		panelSearchDialogVacancyMain.add(buttonContinue, "cell 1 15,alignx right");
		DialogSearchVacancy.tabSearchVacancy.addTab("Allgemein", panelSearchDialogVacancyMain);
		
	    buttonContinue.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					DialogSearchVacancy.tabSearchVacancy.setSelectedIndex((1));
				}
			});
	}

	private static String position;
	private static String area;
	private static String requirementLevel;
	private static String termsOfEmployment;
	private static String educationalAchievementVacancy;
	private static String vacancyStatus;
	private static String  vacancyID;
	
	
	public static void getGeneral() {
		try {
			position = fieldPosition.getText();
			area = fieldArea.getText();
			vacancyID = fieldVacancyID.getText();
			requirementLevel = String.valueOf(boxRequirementLevel.getSelectedItem());
			if (requirementLevel.equals("Bitte auswählen")) {
				requirementLevel = "";
			}
			termsOfEmployment = String.valueOf(boxTermsOfEmployment
					.getSelectedItem());
			if (termsOfEmployment.equals("Bitte auswählen")) {
				termsOfEmployment = "";
			}
			educationalAchievementVacancy = String.valueOf(boxEducationalAchievement
					.getSelectedItem());
			if (educationalAchievementVacancy.equals("Bitte auswählen")) {
				educationalAchievementVacancy = "";
			}
			vacancyStatus = String.valueOf(boxVacancyStatus
					.getSelectedItem());
			if (vacancyStatus.equals("Bitte auswählen")) {
				vacancyStatus = "";
			}
		} catch (Exception e) {
			System.out.println("Nicht alle Daten eingegeben");
		}
	}
	
	public static String getVacancyID() {
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

