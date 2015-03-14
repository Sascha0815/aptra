package git_aptra.DialogEditApplicant;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DialogEditApplicantApplication {
	public static JPanel panelDialogEditApplicantApplication = new JPanel();
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
	private static JLabel labelVacancy = new JLabel("Bewerbung für die Stelle:");
	private static JLabel labelDate = new JLabel("Geburtsdatum:");
	@SuppressWarnings("unused")
	private Font fontHeadline = new Font("Arial", Font.BOLD, 18);
	private static Font fontTextField = new Font("Arial", Font.BOLD, 14);
	private static JTextField fieldVacancy = new JTextField();
	private static JTextField fieldDate = new JTextField();
	private static JLabel labelEducationalAchievement = new JLabel(
			"Höchster Bildungsabschluss:");

	public static void editApplicantApplication() {
		panelDialogEditApplicantApplication.setBackground(Color.LIGHT_GRAY);
		panelDialogEditApplicantApplication.setLayout(new BoxLayout(
				panelDialogEditApplicantApplication, BoxLayout.Y_AXIS));
		panelDialogEditApplicantApplication.add(Box
				.createRigidArea(new Dimension(0, 10)));
		panelDialogEditApplicantApplication.add(labelVacancy);
		labelVacancy.setFont(fontTextField);
		panelDialogEditApplicantApplication.add(fieldVacancy);
		panelDialogEditApplicantApplication.add(Box
				.createRigidArea(new Dimension(0, 10)));
		fieldVacancy.setFont(fontTextField);
		panelDialogEditApplicantApplication.add(labelDate);
		labelDate.setFont(fontTextField);
		boxDay.setToolTipText("Tag");
		panelDialogEditApplicantApplication.add(boxDay);
		panelDialogEditApplicantApplication.add(Box
				.createRigidArea(new Dimension(0, 10)));
		boxMonth.setToolTipText("Monat");
		panelDialogEditApplicantApplication.add(boxMonth);
		panelDialogEditApplicantApplication.add(Box
				.createRigidArea(new Dimension(0, 10)));
		boxYear.setToolTipText("Jahr");
		panelDialogEditApplicantApplication.add(boxYear);
		panelDialogEditApplicantApplication.add(Box
				.createRigidArea(new Dimension(0, 10)));
		panelDialogEditApplicantApplication.add(labelEducationalAchievement);
		labelEducationalAchievement.setFont(fontTextField);
		boxEducationalAchievement.setToolTipText("Höchster Bildungsabschluss:");
		panelDialogEditApplicantApplication.add(boxEducationalAchievement);
		panelDialogEditApplicantApplication.add(Box
				.createRigidArea(new Dimension(0, 10)));
		DialogEditApplicant.tabEdit.addTab("Bewerbung",
				panelDialogEditApplicantApplication);
	}

	public static void reset() {
		panelDialogEditApplicantApplication.removeAll();
		fieldVacancy.setText("");
		fieldDate.setText("");
		boxDay.setSelectedIndex(0);
		boxMonth.setSelectedIndex(0);
		boxYear.setSelectedIndex(0);
		boxEducationalAchievement.setSelectedIndex(0);
	}
}
