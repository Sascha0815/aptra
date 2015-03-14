package git_aptra;

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

public class DialogAddVacancySpecification {
	@SuppressWarnings("unused")
	private Font fontHeadline = new Font("Arial", Font.BOLD, 18);
	private static Font fontTextField = new Font("Arial", Font.BOLD, 14);
	private static JPanel panelDialogVacancySpecification = new JPanel();
	private static JLabel labelLevel = new JLabel();
	private static JTextField fieldLevel = new JTextField();
	private static String level;
	private static String dateVacancy;
	private static JLabel labelEducationalAchievement = new JLabel(
			"Höchster Bildungsabschluss:");
	private static JButton save = new JButton("Speichern");
	static String[] boxListDay = { "Bitte auswählen", "01", "02", "03", "04",
			"05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15",
			"16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26",
			"27", "28", "29", "30", "31" };
	@SuppressWarnings({ "unchecked", "rawtypes" })
	static JComboBox boxDay = new JComboBox(boxListDay);
	static String[] boxListMonth = { "Bitte auswählen", "Januar", "Februar",
			"März", "April", "Mai", "Juni", "Juli", "August", "September",
			"Oktober", "November", "Dezember" };
	@SuppressWarnings({ "rawtypes", "unchecked" })
	static JComboBox boxMonth = new JComboBox(boxListMonth);
	static String[] boxListYear = { "Bitte auswählen", "2000", "1999", "1998",
			"1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990",
			"1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982",
			"1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974",
			"1973", "1972", "1971", "1970" };
	@SuppressWarnings({ "unchecked", "rawtypes" })
	static JComboBox boxYear = new JComboBox(boxListYear);

	public static void addVacancySpecification() {
		panelDialogVacancySpecification.setBackground(Color.LIGHT_GRAY);
		panelDialogVacancySpecification.setLayout(new BoxLayout(
				panelDialogVacancySpecification, BoxLayout.Y_AXIS));
		panelDialogVacancySpecification.add(Box.createRigidArea(new Dimension(
				0, 10)));
		panelDialogVacancySpecification.add(labelLevel);
		labelLevel.setText("Art des Bewerbers:");
		panelDialogVacancySpecification.add(fieldLevel);
		panelDialogVacancySpecification.add(Box.createRigidArea(new Dimension(
				0, 10)));
		fieldLevel.setFont(fontTextField);
		boxDay.setToolTipText("Tag");
		panelDialogVacancySpecification.add(boxDay);
		panelDialogVacancySpecification.add(Box.createRigidArea(new Dimension(
				0, 10)));
		boxMonth.setToolTipText("Monat");
		panelDialogVacancySpecification.add(boxMonth);
		panelDialogVacancySpecification.add(Box.createRigidArea(new Dimension(
				0, 10)));
		boxYear.setToolTipText("Jahr");
		panelDialogVacancySpecification.add(boxYear);
		panelDialogVacancySpecification.add(Box.createRigidArea(new Dimension(
				0, 10)));
		String[] boxListEducationalAchievement = { "Bitte auswählen",
				"Haupptschulabschluss", "Mittlere Reife", "Abitur", "Studium" };
		@SuppressWarnings({ "unchecked", "rawtypes" })
		JComboBox boxEducationalAchievement = new JComboBox(
				boxListEducationalAchievement);
		panelDialogVacancySpecification.add(labelEducationalAchievement);
		boxEducationalAchievement.setToolTipText("Höchster Bildugsabschluss:");
		panelDialogVacancySpecification.add(boxEducationalAchievement);
		panelDialogVacancySpecification.add(Box.createRigidArea(new Dimension(
				0, 10)));
		panelDialogVacancySpecification.add(save);
		DialogAddVacancy.tabVacancy.addTab("Allgemein",
				panelDialogVacancySpecification);

	}

	public static boolean getGeneral() {
		level = fieldLevel.getText();
		String day = String.valueOf(boxDay.getSelectedItem());
		String month = String.valueOf(boxMonth.getSelectedItem());
		String year = String.valueOf(boxYear.getSelectedItem());
		dateVacancy = day + "." + month + "." + year;

		if (level.equals("")) {
			return false;
		}
		if (dateVacancy.equals("")) {
			return false;
		} else {
			return true;
		}
	}

	public String getLevel() {
		return level;
	}

	public String getDateVacancy() {
		return dateVacancy;
	}
}
