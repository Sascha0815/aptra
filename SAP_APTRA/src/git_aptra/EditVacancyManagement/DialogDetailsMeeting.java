package git_aptra.EditVacancyManagement;

import git_aptra.Oberflaeche;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class DialogDetailsMeeting {

	private static JDialog dialogMeeting = new JDialog(Oberflaeche.frame);

	private static JPanel panelMeeting = new JPanel();
	private static JLabel labelInstruction = new JLabel(
			"Bitte geben Sie die benötigten Daten ein.");
	private static JLabel labelSortOfMeeting = new JLabel("Art des Termins:");
	private static JLabel labelLocation = new JLabel("Ort:");
	private static JLabel labelDate = new JLabel("Datum:");
	private static JLabel labelTime = new JLabel("Uhrzeit:");
	private static JLabel labelEmployee = new JLabel("Zuständige Mitarbeiter:");
	private static Integer[] boxListDay = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
			12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28,
			29, 30, 31 };
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static JComboBox boxDateDay = new JComboBox(boxListDay);
	private static Integer[] boxListMonth = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
			11, 12 };
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static JComboBox boxDateMonth = new JComboBox(boxListMonth);
	private static Integer[] boxListYear = { 2015, 2016, 2017, 2018, 2019,
			2020, 2021, 2022, 2023, 2024 };
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static JComboBox boxDateYear = new JComboBox(boxListYear);

	private static Font fontHeadline = new Font("Arial", Font.BOLD, 18);
	private static Font fontTextField = new Font("Arial", Font.BOLD, 14);

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public final static Vector COLUMN_IDENTIFIERS_VACANCYMANAGEMENT_MEETING = new Vector() {
		private static final long serialVersionUID = 1L;

		{
			add("Mitarbeiter-ID");
			add("Name");
			add("Vorname");
		}
	};
	public static DefaultTableModel modelDialogEmployeeMeeting = new DefaultTableModel(
			1, 4) {
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	public static JTable tableDialogEmployeeMeeting = new JTable(
			modelDialogEmployeeMeeting);
	private static JButton save = new JButton("Speichern");
	private static JTextField fieldLocation = new JTextField();
	private static JTextField fieldType = new JTextField();
	private static JTextField fieldTime = new JTextField();
	
	private static String typeMeeting;
	private static String locationMeeting;
	private static int day;
	private static int month;
	private static int year;
	private static int meetingID;
	private static String time;
	private static Calendar calNote = Calendar.getInstance();
	private static String responsibleEmployeeName;
	private static String responsibleEmployeeFirstName;

	@SuppressWarnings("static-access")
	public static void detailsMeeting() {
		dialogMeeting.setVisible(true);
		dialogMeeting.setSize(400, 600);
		dialogMeeting.setLocationRelativeTo(null);
		dialogMeeting.setDefaultCloseOperation(dialogMeeting.DO_NOTHING_ON_CLOSE);
		panelMeeting.setBackground(Color.LIGHT_GRAY);
		dialogMeeting.setResizable(false);
		panelMeeting.setLayout(new BoxLayout(panelMeeting, BoxLayout.Y_AXIS));
		dialogMeeting.setTitle("Meeting Details");
		panelMeeting.add(Box.createRigidArea(new Dimension(0, 10)));
		panelMeeting.add(labelInstruction);
		labelInstruction.setFont(fontHeadline);
		panelMeeting.add(Box.createRigidArea(new Dimension(0, 10)));
		panelMeeting.add(labelSortOfMeeting);
		labelSortOfMeeting.setFont(fontTextField);
		panelMeeting.add(fieldType);
		panelMeeting.add(Box.createRigidArea(new Dimension(0, 10)));
		panelMeeting.add(labelLocation);
		labelLocation.setFont(fontTextField);
		panelMeeting.add(fieldLocation);
		fieldLocation.setFont(fontTextField);
		panelMeeting.add(Box.createRigidArea(new Dimension(0, 10)));
		panelMeeting.add(labelDate);
		labelDate.setFont(fontTextField);
		boxDateDay.setToolTipText("Tag");
		panelMeeting.add(boxDateDay);
		panelMeeting.add(Box
				.createRigidArea(new Dimension(0, 10)));
		boxDateMonth.setToolTipText("Monat");
		panelMeeting.add(boxDateMonth);
		panelMeeting.add(Box
				.createRigidArea(new Dimension(0, 10)));
		boxDateYear.setToolTipText("Jahr");
		panelMeeting.add(boxDateYear);
		panelMeeting.add(Box
				.createRigidArea(new Dimension(0, 10)));
		panelMeeting.add(labelTime);
		labelTime.setFont(fontTextField);
		panelMeeting.add(fieldTime);
		panelMeeting.add(Box.createRigidArea(new Dimension(0, 10)));
		panelMeeting.add(labelEmployee);
		labelEmployee.setFont(fontTextField);
		panelMeeting.add(Box.createRigidArea(new Dimension(0, 5)));
		modelDialogEmployeeMeeting
				.setColumnIdentifiers(COLUMN_IDENTIFIERS_VACANCYMANAGEMENT_MEETING);
		tableDialogEmployeeMeeting.getTableHeader().setReorderingAllowed(false);
		tableDialogEmployeeMeeting.setAutoCreateRowSorter(true);
		tableDialogEmployeeMeeting = new JTable(modelDialogEmployeeMeeting);
		JScrollPane scrollPaneEmployeeMeeting = new JScrollPane(
				tableDialogEmployeeMeeting);
		panelMeeting.add(scrollPaneEmployeeMeeting);
		scrollPaneEmployeeMeeting.setBounds(0, 400, 400, 100);
		scrollPaneEmployeeMeeting
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneEmployeeMeeting
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		tableDialogEmployeeMeeting.setRowHeight(20);
		Oberflaeche.tabBar.addTab("Terminübersicht", panelMeeting);
		tableDialogEmployeeMeeting.setAutoCreateRowSorter(true);

		panelMeeting.add(save);

		save.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent evt) {
			typeMeeting = fieldType.getText();
			locationMeeting = fieldLocation.getText();
			day = (int) boxDateDay.getSelectedItem();
			month = (int) boxDateMonth.getSelectedItem();
			year = (int) boxDateYear.getSelectedItem();
			calNote.set(Calendar.YEAR, year);
			calNote.set(Calendar.MONTH, month);
			calNote.set(Calendar.DAY_OF_MONTH, day);
			time = (String) fieldTime.getText();			
			int []rows = tableDialogEmployeeMeeting.getSelectedRows();
			
			
			InsertMeetingIntoDatabase.insertMeeting(typeMeeting, locationMeeting, calNote, time, responsibleEmployeeName,responsibleEmployeeFirstName);
			try {
				Connection con = DriverManager.getConnection(
						"jdbc:mysql://185.28.20.242:3306/u474396146_db",
						"u474396146_aptra", "aptraDB");
				Statement stmt =  con.createStatement();
			    ResultSet rs = stmt.executeQuery("SELECT MAX(meetingID) from meeting");
			    while (rs.next()) {
			        meetingID = rs.getInt(1);
			    }
			} catch (Exception e) {
				System.out.println("Fehler auslesen der MeetingID" +e.getMessage());
			}
			
			
			for (int i = 0; i < rows.length; i++) {
				int id = Integer.parseInt((String) tableDialogEmployeeMeeting.getValueAt(i, 0));
				InsertMeetingIntoDatabase.insertParticipation(id, meetingID);				
			}
			
			
			fieldType.setText("");
			fieldLocation.setText("");
			boxDateDay.setSelectedIndex(0);
			boxDateMonth.setSelectedIndex(0);
			boxDateYear.setSelectedIndex(0);
			fieldTime.setText("");
			panelMeeting.removeAll();
			dialogMeeting.dispose();
			}
		});
		dialogMeeting.add(panelMeeting);

	}
	

}
