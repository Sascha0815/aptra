package git_aptra.AddApplicant;

import git_aptra.MenuBar.MenuBarPanelApplicant;





import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;





import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class DialogAddApplicantApplication {
	public static JPanel panelDialogApplicantApplication = new JPanel();

	private static String[] boxListEducationalAchievement = {
			"Hauptschulabschluss", "Mittlere Reife", "Abitur", "Studium" };

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
	private static JLabel labelVacancyID = new JLabel("Stellenidentifikationsnummer:");
	private static JLabel labelEducationalAchievement = new JLabel("H�chster Bildungsabschluss:");
	private static JLabel labelInstruction = new JLabel("Bitte tragen Sie alle erforderlichen Daten ein!");

	private static Font fontTextField = new Font("Arial", Font.BOLD, 14);
	private static Font fontHeadline = new Font("Arial", Font.BOLD, 18);

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static JComboBox boxID = new JComboBox(MenuBarPanelApplicant.getVacancyID());
	
	private static JTextField fieldDate = new JTextField();
	
	private static GridBagConstraints gbc = new GridBagConstraints();

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
	private static int vacancyID;

	public static void addApplicantApplication() {
		panelDialogApplicantApplication.setLayout(new MigLayout("", "[grow][grow][grow]", "[][][][][][][][][][][][]"));
		panelDialogApplicantApplication.add(labelInstruction, "cell 0 0,alignx center");
	    panelDialogApplicantApplication.add(labelApplyDate, "cell 0 1,alignx left");
	    panelDialogApplicantApplication.add(boxApplyDay, "cell 0 2");
	    panelDialogApplicantApplication.add(boxApplyMonth, "cell 0 2 1");
	    panelDialogApplicantApplication.add(boxApplyYear, "cell 0 2 2");
	    panelDialogApplicantApplication.add(labelVacancyID, "cell 0 3,alignx left");
	    panelDialogApplicantApplication.add(boxID, "cell 0 4");
	    panelDialogApplicantApplication.add(labelDate, "cell 0 5,alignx left");
	    panelDialogApplicantApplication.add(boxDay, "cell 0 6");
	    panelDialogApplicantApplication.add(boxMonth, "cell 0 6 1");
	    panelDialogApplicantApplication.add(boxYear, "cell 0 6 2");
	    panelDialogApplicantApplication.add(labelEducationalAchievement, "cell 0 7,alignx left");
	    panelDialogApplicantApplication.add(boxEducationalAchievement, "cell 0 8");
		DialogAddApplicant.tabAdd.addTab("Bewerbung",
				panelDialogApplicantApplication);

	}

	public static void getApplication() {
		try {
			String IDSplit = ((String) boxID.getSelectedItem());
			String[] IDParts = IDSplit.split(" - ");
			vacancyID = Integer.parseInt(IDParts[0]);
		} catch (Exception e) {
			vacancyID = 0;
		}
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://185.28.20.242:3306/u474396146_db",
					"u474396146_aptra", "aptraDB");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("Select position from vacancy where vacancyID = "
							+ vacancyID);

			while (rs.next()) {
				vacancy = (rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
		boxID.setSelectedIndex(0);
		fieldDate.setText("");
		boxDay.setSelectedIndex(0);
		boxMonth.setSelectedIndex(0);
		boxYear.setSelectedIndex(0);
		boxEducationalAchievement.setSelectedIndex(0);
		boxApplyDay.setSelectedIndex(0);
		boxApplyMonth.setSelectedIndex(0);
		boxApplyYear.setSelectedIndex(0);
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

	public static int getVacancyID() {
		return vacancyID;
	}

}
