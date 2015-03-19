package git_aptra.DialogAddVacancy;

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
	private static JLabel labelDeadline = new JLabel(); 
	private static String dateVacancy;
	
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
	static String[] boxListYear = { "Bitte auswählen", "2015", "2016", "2017",
			"2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025",
			"2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033",
			"2034", "2035", "2036", "2037", "2038", "2039", "2040"};
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
		labelDeadline.setText("Bewerbungsschluss:");
		panelDialogVacancySpecification.add(labelDeadline);
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
		panelDialogVacancySpecification.add(Box.createRigidArea(new Dimension(
				0, 10)));
		panelDialogVacancySpecification.add(save);
		DialogAddVacancy.tabVacancy.addTab("Organisation",
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

	public static String getLevel() {
		return level;
	}

	public static String getDateVacancy() {
		return dateVacancy;
	}

	public static JLabel getLabelDeadline() {
		return labelDeadline;
	}

}
