package git_aptra.DialogApplicantSearch;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DialogSearchApplicantApplication {
	public static JPanel panelDialogSearchApplicantApplication = new JPanel();
	private static String[] boxListEducationalAchievement = { "Bitte wählen",
			"Haupptschulabschluss", "Mittlere Reife", "Abitur", "Studium" };
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static JComboBox boxEducationalAchievement = new JComboBox(
			boxListEducationalAchievement);
	private static Integer[] boxListDay = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
			12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28,
			29, 30, 31 };
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static JComboBox boxDay = new JComboBox(boxListDay);
	private static Integer[] boxListMonth = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
			11, 12 };
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static JComboBox boxMonth = new JComboBox(boxListMonth);
	private static Integer[] boxListYear = { 2000, 1999, 1998, 1997, 1996,
			1995, 1994, 1993, 1992, 1991, 1990, 1989, 1988, 1987, 1986, 1985,
			1984, 1983, 1982, 1981, 1980, 1979, 1978, 1977, 1976, 1975, 1974,
			1973, 1972, 1971, 1970 };
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static JComboBox boxYear = new JComboBox(boxListYear);
	private static JLabel labelVacancy = new JLabel("Bewerbung für die Stelle:");
	@SuppressWarnings("unused")
	private static JLabel labelDate = new JLabel("Geburtsdatum:");
	@SuppressWarnings("unused")
	private Font fontHeadline = new Font("Arial", Font.BOLD, 18);
	private static Font fontTextField = new Font("Arial", Font.BOLD, 14);
	private static JTextField fieldVacancy = new JTextField();
	private static JTextField fieldDate = new JTextField();
	private static JLabel labelEducationalAchievement = new JLabel(
			"Höchster Bildungsabschluss:");

	private static int day;
	private static int month;
	private static int year;
	private static Calendar cal = Calendar.getInstance();
	private static String educationalAchievement;
	private static String vacancy;

	public static void searchApplicantApplication() {
		panelDialogSearchApplicantApplication.setBackground(Color.LIGHT_GRAY);
		panelDialogSearchApplicantApplication.setLayout(new BoxLayout(
				panelDialogSearchApplicantApplication, BoxLayout.Y_AXIS));
		panelDialogSearchApplicantApplication.add(Box
				.createRigidArea(new Dimension(0, 10)));
		panelDialogSearchApplicantApplication.add(labelVacancy);
		labelVacancy.setFont(fontTextField);
		panelDialogSearchApplicantApplication.add(fieldVacancy);
		panelDialogSearchApplicantApplication.add(Box
				.createRigidArea(new Dimension(0, 10)));
		fieldVacancy.setFont(fontTextField);
		/*
		 * panelDialogSearchApplicantApplication.add(labelDate);
		 * labelDate.setFont(fontTextField); boxDay.setToolTipText("Tag");
		 * panelDialogSearchApplicantApplication.add(boxDay);
		 * panelDialogSearchApplicantApplication.add(Box.createRigidArea(new
		 * Dimension( 0, 10))); boxMonth.setToolTipText("Monat");
		 * panelDialogSearchApplicantApplication.add(boxMonth);
		 * panelDialogSearchApplicantApplication.add(Box.createRigidArea(new
		 * Dimension( 0, 10))); boxYear.setToolTipText("Jahr");
		 * panelDialogSearchApplicantApplication.add(boxYear);
		 * panelDialogSearchApplicantApplication.add(Box.createRigidArea(new
		 * Dimension( 0, 10)));
		 */
		panelDialogSearchApplicantApplication.add(labelEducationalAchievement);
		labelEducationalAchievement.setFont(fontTextField);
		boxEducationalAchievement.setToolTipText("Höchster Bildungsabschluss:");
		panelDialogSearchApplicantApplication.add(boxEducationalAchievement);
		panelDialogSearchApplicantApplication.add(Box
				.createRigidArea(new Dimension(0, 10)));
		DialogSearchApplicant.tabSearch.addTab("Bewerbung",
				panelDialogSearchApplicantApplication);
	}

	public static void getApplication() {
		try {
			vacancy = fieldVacancy.getText();
			day = (int) boxDay.getSelectedItem();
			month = (int) boxMonth.getSelectedItem();
			year = (int) boxYear.getSelectedItem();
			cal.set(Calendar.YEAR, year);
			cal.set(Calendar.MONTH, (month - 1));
			cal.set(Calendar.DAY_OF_MONTH, day);
		} catch (Exception e) {
			System.out.println("Nicht alle Daten eingegeben");
		}

		educationalAchievement = String.valueOf(boxEducationalAchievement
				.getSelectedItem());
		if (educationalAchievement.equals("Bitte wählen")) {
			educationalAchievement = "";
		}

	}

	public static void reset() {
		panelDialogSearchApplicantApplication.removeAll();
		fieldVacancy.setText("");
		fieldDate.setText("");
		boxDay.setSelectedIndex(0);
		boxMonth.setSelectedIndex(0);
		boxYear.setSelectedIndex(0);
		boxEducationalAchievement.setSelectedIndex(0);
	}

	public static String getEducationalAchievement() {
		return educationalAchievement;
	}

	public static String getVacancy() {
		return vacancy;
	}
}
