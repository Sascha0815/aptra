package git_aptra.SearchApplicant;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class DialogSearchApplicantApplication {
	public static JPanel panelDialogSearchApplicantApplication = new JPanel();
	
	private static JLabel labelInstruction = new JLabel("Bitte tragen Sie die gesuchten Daten ein!");
	private static JLabel labelEducationalAchievement = new JLabel("Höchster Bildungsabschluss:");
	private static JLabel labelVacancy = new JLabel("Arbeitsstelle:");
	
	private static String[] boxListEducationalAchievement = {"Bitte auswählen", "Hauptschulabschluss", "Mittlere Reife","Abitur", "Studium" };
	private static String[] boxListVacancy = {"Bitte auswählen", "Fachkraft Speißeeis", "Glückskeksautor","Kokosnuss-Sicherheitsbeauftragter"};
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static JComboBox boxEducationalAchievement = new JComboBox( boxListEducationalAchievement);
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static JComboBox boxVacancy = new JComboBox( boxListVacancy);
	
	private static Font fontHeadline = new Font("Calibri", Font.BOLD, 16);
	private static Font fontSubHeadline = new Font("Calibri", Font.BOLD, 14);
	
	private static String educationalAchievement;
	private static String vacancy;

	public static void searchApplicantApplication() {
		labelInstruction.setFont(fontHeadline);
		labelEducationalAchievement.setFont(fontSubHeadline);
		labelVacancy.setFont(fontSubHeadline);
		boxVacancy.setFont(fontSubHeadline);
		boxEducationalAchievement.setFont(fontSubHeadline);
		boxEducationalAchievement.setSelectedIndex(0);
		panelDialogSearchApplicantApplication.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][][][][][][][][][][][][][]"));
		panelDialogSearchApplicantApplication.add(labelInstruction,"cell 0 0 2 1,alignx center");
		panelDialogSearchApplicantApplication.add(labelEducationalAchievement,"cell 0 1,alignx left");
		panelDialogSearchApplicantApplication.add(boxEducationalAchievement,"cell 0 2 2 1,growx");
		panelDialogSearchApplicantApplication.add(labelVacancy,"cell 0 3,alignx left");
		panelDialogSearchApplicantApplication.add(boxVacancy,"cell 0 4 2 1,growx");
		DialogSearchApplicant.tabSearch.addTab("Bewerbung",panelDialogSearchApplicantApplication);
	}

	public static void getApplication() {
		educationalAchievement = String.valueOf(boxEducationalAchievement.getSelectedItem());
		if (educationalAchievement.equals("Bitte auswählen")) {
			educationalAchievement = "";
		}
		vacancy = String.valueOf(boxVacancy.getSelectedItem());
		if (vacancy.equals("Bitte auswählen")) {
			vacancy = "";
		}
	}

	public static String getEducationalAchievement() {
		return educationalAchievement;
	}
	
	public static String getVacancy() {
		return vacancy;
	}

}
