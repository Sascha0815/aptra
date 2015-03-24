package git_aptra.DialogSearchVacancy;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Calendar;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DialogSearchVacancySpecification {

	private static Font fontTextField = new Font("Arial", Font.BOLD, 14);

	private static JPanel panelSearchVacancySpecification = new JPanel();

	private static JLabel labelLevel = new JLabel();
	private static JLabel labelDeadline = new JLabel();

	private static JTextField fieldLevel = new JTextField();

	private static JButton search = new JButton("Suchen");

	private static Integer[] boxListDay = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
			12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28,
			29, 30, 31 };
	@SuppressWarnings({ "unchecked", "rawtypes" })
	static JComboBox boxDay = new JComboBox(boxListDay);
	private static Integer[] boxListMonth = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
			11, 12 };
	@SuppressWarnings({ "rawtypes", "unchecked" })
	static JComboBox boxMonth = new JComboBox(boxListMonth);
	private static Integer[] boxListYear = { 2000, 1999, 1998, 1997, 1996,
			1995, 1994, 1993, 1992, 1991, 1990, 1989, 1988, 1987, 1986, 1985,
			1984, 1983, 1982, 1981, 1980, 1979, 1978, 1977, 1976, 1975, 1974,
			1973, 1972, 1971, 1970 };
	@SuppressWarnings({ "unchecked", "rawtypes" })
	static JComboBox boxYear = new JComboBox(boxListYear);

	public static void searchVacancySpecification() {
		panelSearchVacancySpecification.setBackground(Color.LIGHT_GRAY);
		panelSearchVacancySpecification.setLayout(new BoxLayout(
				panelSearchVacancySpecification, BoxLayout.Y_AXIS));
		panelSearchVacancySpecification.add(Box.createRigidArea(new Dimension(
				0, 10)));
		panelSearchVacancySpecification.add(labelLevel);
		labelLevel.setText("Art des Bewerbers:");
		panelSearchVacancySpecification.add(fieldLevel);
		panelSearchVacancySpecification.add(Box.createRigidArea(new Dimension(
				0, 10)));
		fieldLevel.setFont(fontTextField);
		labelDeadline.setText("Bewerbungsschluss:");
		panelSearchVacancySpecification.add(labelDeadline);
		boxDay.setToolTipText("Tag");
		panelSearchVacancySpecification.add(boxDay);
		panelSearchVacancySpecification.add(Box.createRigidArea(new Dimension(
				0, 10)));
		boxMonth.setToolTipText("Monat");
		panelSearchVacancySpecification.add(boxMonth);
		panelSearchVacancySpecification.add(Box.createRigidArea(new Dimension(
				0, 10)));
		boxYear.setToolTipText("Jahr");
		panelSearchVacancySpecification.add(boxYear);
		panelSearchVacancySpecification.add(Box.createRigidArea(new Dimension(
				0, 10)));
		panelSearchVacancySpecification.add(Box.createRigidArea(new Dimension(
				0, 10)));
		panelSearchVacancySpecification.add(search);
		DialogSearchVacancy.tabSearchVacancy.addTab("Organisation",
				panelSearchVacancySpecification);
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					SearchControlVacancy.searchVacancy();
					CloseDialogSearchVacancy.closeSearchVacancy();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
	DialogSearchVacancy.tabSearchVacancy.addTab("Spezifikation",
			panelSearchVacancySpecification);
	}

	private static String level;
	private static int day;
	private static int month;
	private static int year;
	private static Calendar calVacancy = Calendar.getInstance();

	public static void getSpecification() {
		try {
			level = fieldLevel.getText();
			day = (int) boxDay.getSelectedItem();
			month = (int) boxMonth.getSelectedItem();
			year = (int) boxYear.getSelectedItem();
			calVacancy.set(Calendar.YEAR, year);
			calVacancy.set(Calendar.MONTH, (month - 1));
			calVacancy.set(Calendar.DAY_OF_MONTH, day);
		} catch (Exception e) {
			System.out.println("Nicht alle Daten eingegeben");
		}
/*
		if (level.equals("")) {
			return false;
		} else {
			return true;
		}
		*/
	}
	
	public static void reset() {
		
		fieldLevel.setText("");
		boxDay.setSelectedIndex(0);
		boxMonth.setSelectedIndex(0);
		boxYear.setSelectedIndex(0);
		panelSearchVacancySpecification.removeAll();
	}

	public static String getLevel() {
		return level;
	}

	public static Calendar getCalVacancy() {
		return calVacancy;
	}

}

