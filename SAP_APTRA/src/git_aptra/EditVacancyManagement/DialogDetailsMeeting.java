package git_aptra.EditVacancyManagement;

import git_aptra.Oberflaeche;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class DialogDetailsMeeting {
	public static JDialog dialogMeeting = new JDialog(Oberflaeche.frame);
	public static JPanel panelMeeting = new JPanel();
	
	public static JLabel labelInstruction = new JLabel("Bitte geben Sie die benötigten Daten ein.");
	public static JLabel labelSortOfMeeting = new JLabel("Art des Termins:");
	public static JLabel labelLocation = new JLabel("Ort:");
	public static JLabel labelDate = new JLabel("Datum:");
	public static JLabel labelTime = new JLabel("Uhrzeit:");
	public static JLabel labelEmployee = new JLabel("Zuständiger Mitarbeiter:");

	
	private static String[] boxListEmployee = { 
		"Bitte auswählen", "Fabian Gierer", "Sascha Pfau", "Johannes Vollmer"};
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static JComboBox boxEmployee = new JComboBox(boxListEmployee);
	
	private static String[] boxListSortOfMeeting = { 
		"Bitte auswählen", "Bewerbungsgespräch", "Workshop", "Gruppengespräch"};
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static JComboBox boxSortOfMeeting = new JComboBox(boxListSortOfMeeting);
	
	private static Integer[] boxListDay = { 
		1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 
		17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31 };
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static JComboBox boxDay = new JComboBox(boxListDay);
	private static Integer[] boxListMonth = { 
		1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static JComboBox boxMonth = new JComboBox(boxListMonth);
	private static Integer[] boxListYear = { 
		2015, 2016, 2017, 2018, 2019, 2020, 2021, 2022, 2023, 2024 };
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static JComboBox boxYear = new JComboBox(boxListYear);
	
	private static Integer[] boxListHour = { 
		1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 
		17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31 };
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static JComboBox boxHour = new JComboBox(boxListHour);
	private static Integer[] boxListMinute = { 
		1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 
		19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30,	31, 32, 33, 34, 
		35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 
		51, 52, 53, 54 ,55, 56, 57, 58, 59, 60 };
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static JComboBox boxMinute = new JComboBox(boxListMinute);
	
	private static Font fontHeadline = new Font("Arial", Font.BOLD, 18);
	private static Font fontTextField = new Font("Arial", Font.BOLD, 14);
	
	private static JButton save = new JButton("Speichern");
	
	private static JTextField fieldLocation = new JTextField();
	
		public static void detailsMeeting(){		
			dialogMeeting.setVisible(true);
			dialogMeeting.setSize(400, 450);
			dialogMeeting.setLocationRelativeTo(null);
			panelMeeting.setBackground(Color.LIGHT_GRAY);
			dialogMeeting.setResizable(false);
			panelMeeting.setLayout(new BoxLayout(
					panelMeeting, BoxLayout.Y_AXIS));
			dialogMeeting.setTitle("Meeting Details");
			panelMeeting.add(Box.createRigidArea(new Dimension(0, 10)));
			panelMeeting.add(labelInstruction);	
			labelInstruction.setFont(fontHeadline);
			panelMeeting.add(Box.createRigidArea(new Dimension(0, 10)));
			panelMeeting.add(labelSortOfMeeting);
			panelMeeting.add(boxSortOfMeeting);	
			panelMeeting.add(Box.createRigidArea(new Dimension(0, 10)));
			panelMeeting.add(labelLocation);
			panelMeeting.add(fieldLocation);
			fieldLocation.setFont(fontTextField);	
			panelMeeting.add(Box.createRigidArea(new Dimension(0, 10)));
			panelMeeting.add(labelDate);
			labelDate.setFont(fontTextField);
			boxDay.setToolTipText("Tag");
			panelMeeting.add(boxDay);
			panelMeeting.add(Box.createRigidArea(new Dimension(0, 10)));
			boxMonth.setToolTipText("Monat");
			panelMeeting.add(boxMonth);
			panelMeeting.add(Box.createRigidArea(new Dimension(0, 10)));
			boxYear.setToolTipText("Jahr");
			panelMeeting.add(boxYear);
			panelMeeting.add(Box.createRigidArea(new Dimension(0, 10)));
			panelMeeting.add(labelTime);
			labelTime.setFont(fontTextField);
			boxHour.setToolTipText("Stunden");
			panelMeeting.add(boxHour);
			panelMeeting.add(Box.createRigidArea(new Dimension(0, 10)));
			boxMinute.setToolTipText("Minuten");
			panelMeeting.add(boxMinute);
			panelMeeting.add(Box.createRigidArea(new Dimension(0, 10)));
			panelMeeting.add(labelEmployee);
			panelMeeting.add(boxEmployee);
			
			panelMeeting.add(save);

			save.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					// Save-Methode
				}
			});
			dialogMeeting.add(panelMeeting);
			
		}
		
	}


