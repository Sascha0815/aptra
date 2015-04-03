package git_aptra.AddApplicant;

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

public class DialogAddApplicantApplication {
	public static JPanel panelDialogApplicantApplication = new JPanel();

	private static String[] boxListEducationalAchievement = {
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static JComboBox boxApplyDay = new JComboBox(boxListDay);
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static JComboBox boxApplyMonth = new JComboBox(boxListMonth);
	private static Integer[] boxListApplyYear = { 2015, 2016, 2017, 2018, 2019,
			2020, 2021, 2022, 2023, 2024 };
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static JComboBox boxApplyYear = new JComboBox(boxListApplyYear);

	private static JLabel labelDate = new JLabel("Geburtsdatum:");
	private static JLabel labelApplyDate = new JLabel("Bewerbungseingang:");
	private static JLabel labelVacancyID = new JLabel(
			"Stellenidentifikationsnummer:");
	private static JLabel labelVacancy = new JLabel("Stellenbeschreibung:");
	private static JLabel labelEducationalAchievement = new JLabel(
			"Höchster Bildungsabschluss:");

	private static Font fontTextField = new Font("Arial", Font.BOLD, 14);

	private static JTextField fieldVacancyID = new JTextField();
	private static JTextField fieldVacancy = new JTextField();
	private static JTextField fieldDate = new JTextField();

	private static int day;
	private static int month;
	private static int year;
	private static Calendar cal = Calendar.getInstance();
	private static int dayApply;
	private static int monthApply;
	private static int yearApply;
	private static Calendar calApply = Calendar.getInstance();
	private static String educationalAchievement;
	private static String vacancy;
	private static String vacancyID;

	public static void addApplicantApplication() {
		panelDialogApplicantApplication.setBackground(Color.LIGHT_GRAY);
		panelDialogApplicantApplication.setLayout(new BoxLayout(
				panelDialogApplicantApplication, BoxLayout.Y_AXIS));

		panelDialogApplicantApplication.add(labelApplyDate);
		labelApplyDate.setFont(fontTextField);

		boxApplyDay.setToolTipText("Tag");
		panelDialogApplicantApplication.add(boxApplyDay);
		panelDialogApplicantApplication.add(Box.createRigidArea(new Dimension(
				0, 10)));

		boxApplyMonth.setToolTipText("Monat");
		panelDialogApplicantApplication.add(boxApplyMonth);
		panelDialogApplicantApplication.add(Box.createRigidArea(new Dimension(
				0, 10)));

		boxApplyYear.setToolTipText("Jahr");
		panelDialogApplicantApplication.add(boxApplyYear);
		panelDialogApplicantApplication.add(Box.createRigidArea(new Dimension(
				0, 10)));

		panelDialogApplicantApplication.add(labelVacancyID);
		labelVacancyID.setFont(fontTextField);
		panelDialogApplicantApplication.add(Box.createRigidArea(new Dimension(
				0, 10)));

		panelDialogApplicantApplication.add(fieldVacancyID);
		fieldVacancyID.setFont(fontTextField);
		panelDialogApplicantApplication.add(Box.createRigidArea(new Dimension(
				0, 10)));

		panelDialogApplicantApplication.add(labelVacancy);
		labelVacancy.setFont(fontTextField);
		panelDialogApplicantApplication.add(Box.createRigidArea(new Dimension(
				0, 10)));

		panelDialogApplicantApplication.add(fieldVacancy);
		fieldVacancy.setFont(fontTextField);
		panelDialogApplicantApplication.add(Box.createRigidArea(new Dimension(
				0, 10)));

		panelDialogApplicantApplication.add(labelDate);
		labelDate.setFont(fontTextField);
		boxDay.setToolTipText("Tag");
		panelDialogApplicantApplication.add(boxDay);
		panelDialogApplicantApplication.add(Box.createRigidArea(new Dimension(
				0, 10)));

		boxMonth.setToolTipText("Monat");
		panelDialogApplicantApplication.add(boxMonth);
		panelDialogApplicantApplication.add(Box.createRigidArea(new Dimension(
				0, 10)));

		boxYear.setToolTipText("Jahr");
		panelDialogApplicantApplication.add(boxYear);
		panelDialogApplicantApplication.add(Box.createRigidArea(new Dimension(
				0, 10)));

		panelDialogApplicantApplication.add(labelEducationalAchievement);
		labelEducationalAchievement.setFont(fontTextField);
		boxEducationalAchievement.setToolTipText("Höchster Bildungsabschluss:");
		panelDialogApplicantApplication.add(boxEducationalAchievement);
		panelDialogApplicantApplication.add(Box.createRigidArea(new Dimension(
				0, 10)));

		DialogAddApplicant.tabAdd.addTab("Bewerbung",
				panelDialogApplicantApplication);
	}

	public static void getApplication() {
		try {
			vacancy = fieldVacancy.getText();
		} catch (Exception e) {
		}
		try {
			vacancyID = fieldVacancy.getText();
		} catch (Exception e) {
		}

		day = (int) boxDay.getSelectedItem();
		month = (int) boxMonth.getSelectedItem();
		year = (int) boxYear.getSelectedItem();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, (month - 1));
		cal.set(Calendar.DAY_OF_MONTH, day);
		dayApply = (int) boxApplyDay.getSelectedItem();
		monthApply = (int) boxApplyMonth.getSelectedItem();
		yearApply = (int) boxApplyYear.getSelectedItem();
		calApply.set(Calendar.YEAR, yearApply);
		calApply.set(Calendar.MONTH, (monthApply - 1));
		calApply.set(Calendar.DAY_OF_MONTH, dayApply);
		educationalAchievement = String.valueOf(boxEducationalAchievement
				.getSelectedItem());
	}

	public static void reset() {
		panelDialogApplicantApplication.removeAll();
		fieldVacancy.setText("");
		fieldVacancyID.setText("");
		fieldDate.setText("");
		boxDay.setSelectedIndex(0);
		boxMonth.setSelectedIndex(0);
		boxYear.setSelectedIndex(0);
		boxEducationalAchievement.setSelectedIndex(0);
	}

	public static Calendar getCal() {
		return cal;
	}

	public static Calendar getCalApply() {
		return calApply;
	}

	public static String getEducationalAchievement() {
		return educationalAchievement;
	}

	public static String getVacancy() {
		return vacancy;
	}

	public static String getVacancyID() {
		return vacancyID;
	}

}
