package git_aptra.EditVacancy;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class DialogEditVacancyGeneral {
	
	private static JPanel panelDialogVacancyMain = new JPanel();
	
	private static JLabel labelArea = new JLabel("Arbeitsbereich");
	private static JLabel labelInstruction = new JLabel("Bitte tragen Sie alle erfoderlichen Daten ein!");
	private static JLabel labelPosition = new JLabel("Stellenbezeichnung");
	private static JLabel labelRequirementLevel = new JLabel("Anfoderung");
	private static JLabel labelTermsOfEmployment = new JLabel("Anstellungsverhältnis");
	private static JLabel labelVacancyStatus = new JLabel("Status");
	private static JLabel labelEducationalAchievement = new JLabel("Höchster Bildungsabschluss:");
	
	private static JTextField fieldArea = new JTextField();
	private static JTextField fieldPosition = new JTextField();

	static String[] boxListRequirementLevel = { "Bitte auswählen", "Praktikant", "Auszubildender", "Student", "Angestellter" };
	@SuppressWarnings({ "unchecked", "rawtypes" })
	static JComboBox boxRequirementLevel = new JComboBox(boxListRequirementLevel);
	
	static String[] boxListTermsOfEmployment = { "Bitte auswählen", "Vollzeit",
			"Teilzeit", "Aushilfe", "Schichtarbeit" };
	@SuppressWarnings({ "unchecked", "rawtypes" })
	static JComboBox boxTermsOfEmployment = new JComboBox(boxListTermsOfEmployment);
	
	static String[] boxListVacancyStatus = { "Bitte auswählen", "Freigegeben","Bewerbungsschluss", "Vorauswahl", "Bewerbungsgespräche","Entscheidung", "Abgeschlossen" };
	@SuppressWarnings({ "unchecked", "rawtypes" })
	static JComboBox boxVacancyStatus = new JComboBox(boxListVacancyStatus);
	
	static String[] boxListEducationalAchievement = { "Bitte auswählen","Hauptschulabschluss", "Mittlere Reife", "Abitur", "Studium" };
	@SuppressWarnings({ "unchecked", "rawtypes" })
	static JComboBox boxEducationalAchievement = new JComboBox(boxListEducationalAchievement);
	
	private static JButton buttonContinue = new JButton("Weiter");
	
	private static Font fontHeadline = new Font("Calibri", Font.BOLD, 16);
	private static Font fontSubHeadline = new Font("Calibri", Font.BOLD, 14);
	private static Font fontText = new Font("Calibri", Font.PLAIN, 14);
	
	public static void editVacancyGeneral() {
		fieldArea.setText("");
		fieldPosition.setText("");
		boxRequirementLevel.setSelectedIndex(0);
		boxTermsOfEmployment.setSelectedIndex(0);
		boxVacancyStatus.setSelectedIndex(0);
		boxEducationalAchievement.setSelectedIndex(0);
		labelInstruction.setFont(fontHeadline);
		labelArea.setFont(fontSubHeadline);
		labelPosition.setFont(fontSubHeadline);
		labelRequirementLevel.setFont(fontSubHeadline);
		labelTermsOfEmployment.setFont(fontSubHeadline);
		labelVacancyStatus.setFont(fontSubHeadline);
		labelEducationalAchievement.setFont(fontSubHeadline);
		boxRequirementLevel.setFont(fontSubHeadline);
		boxTermsOfEmployment.setFont(fontSubHeadline);
		boxVacancyStatus.setFont(fontSubHeadline);
		boxEducationalAchievement.setFont(fontSubHeadline);
		fieldArea.setFont(fontText);
		fieldPosition.setFont(fontText);
		fieldArea.setText(EditVacancy.getDataSetArea());
		fieldPosition.setText(EditVacancy.getDataSetPosition());
		boxRequirementLevel.setSelectedItem(EditVacancy.getDataSetRequirementLevel());
		boxTermsOfEmployment.setSelectedItem(EditVacancy.getDataSetTermsOfEmployment());
		boxVacancyStatus.setSelectedItem(EditVacancy.getDataSetVacancyStatus());
		boxEducationalAchievement.setSelectedItem(EditVacancy.getDataSetEducationalAchievement());
		panelDialogVacancyMain.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][][][][][][][][][][][]push[]"));
		panelDialogVacancyMain.add(labelInstruction, "cell 0 0 2 1,alignx center");
		panelDialogVacancyMain.add(labelPosition, "cell 0 1,alignx left");
		panelDialogVacancyMain.add(fieldPosition, "cell 0 2 2 1,growx");
		panelDialogVacancyMain.add(labelArea, "cell 0 3");
		panelDialogVacancyMain.add(fieldArea, "cell 0 4 2 1,growx");
		panelDialogVacancyMain.add(labelRequirementLevel, "cell 0 5");
		panelDialogVacancyMain.add(boxRequirementLevel, "cell 0 6 2 1,growx");
		panelDialogVacancyMain.add(labelTermsOfEmployment, "cell 0 7");
		panelDialogVacancyMain.add(boxTermsOfEmployment, "cell 0 8 2 1,growx");
		panelDialogVacancyMain.add(labelVacancyStatus, "cell 0 9");
		panelDialogVacancyMain.add(boxVacancyStatus, "cell 0 10 2 1,growx");
		panelDialogVacancyMain.add(labelEducationalAchievement, "cell 0 11");
		panelDialogVacancyMain.add(boxEducationalAchievement, "cell 0 12 2 1,growx");
		panelDialogVacancyMain.add(buttonContinue,"cell 1 13,alignx right");
	    
		buttonContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				DialogEditVacancy.tabVacancy.setSelectedIndex((1));
			}
		});
		DialogEditVacancy.tabVacancy.addTab("Allgemein", panelDialogVacancyMain);
	}

	private static String position;
	private static String area;
	private static String requirementLevel;
	private static String termsOfEmployment;
	private static String educationalAchievementVacancy;
	private static String vacancyStatus;

	public static void getGeneral() {
		try {
			position = fieldPosition.getText();
		} catch (Exception e) {
		}
		try {
			area = fieldArea.getText();
		} catch (Exception e) {
		}
		try {
			requirementLevel = String.valueOf(boxRequirementLevel
					.getSelectedItem());
		} catch (Exception e) {
		}
		try {
			termsOfEmployment = String.valueOf(boxTermsOfEmployment
					.getSelectedItem());
		} catch (Exception e) {
		}
		try {
			educationalAchievementVacancy = String
					.valueOf(boxEducationalAchievement.getSelectedItem());
		} catch (Exception e) {
		}
		try {
			vacancyStatus = String.valueOf(boxVacancyStatus.getSelectedItem());
		} catch (Exception e) {
		}
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
