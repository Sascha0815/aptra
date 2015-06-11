package git_aptra.Meeting;

import git_aptra.Oberflaeche;
import git_aptra.Meeting.InsertMeetingIntoDatabase;
import git_aptra.MenuBar.MenuBarPanelMeeting;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;
import lu.tudor.santec.jtimechooser.JTimeChooser;

import com.toedter.calendar.JDateChooser;

public class DialogDetailsMeeting {

	private static JDialog dialogMeeting = new JDialog(Oberflaeche.frame, true);

	private static JPanel panelMeeting = new JPanel();
	
	private static JLabel labelInstruction = new JLabel("Bitte geben Sie die benötigten Daten ein");
	private static JLabel labelSortOfMeeting = new JLabel("Art des Termins:");
	private static JLabel labelDateCreation = new JLabel("Datum Termineintrag:");
	private static JLabel labelLocation = new JLabel("Ort:");
	private static JLabel labelDate = new JLabel("Datum Termin:");
	private static JLabel labelTime = new JLabel("Uhrzeit:");
	private static JLabel labelEmployee = new JLabel("Zuständiger Mitarbeiter:");
	
	private static JDateChooser dateChooserDateCreation = new JDateChooser();
	private static JDateChooser dateChooserDate = new JDateChooser();
	
	private static JTextField fieldLocation = new JTextField();
	private static JTextField fieldType = new JTextField();
	private static JTimeChooser timeChooser = new JTimeChooser();

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public final static Vector COLUMN_IDENTIFIERS_VACANCYMANAGEMENT_MEETING = new Vector() {
		private static final long serialVersionUID = 1L;

		{
			add("Mitarbeiter-ID");
			add("Name");
			add("Vorname");
		}
	};
	public static DefaultTableModel modelDialogEmployeeMeeting = new DefaultTableModel() {
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	public static JTable tableDialogEmployeeMeeting = new JTable(modelDialogEmployeeMeeting);
	
	private static JButton buttonSave = new JButton("Speichern");
	private static JButton buttonBack = new JButton("Zurück");
	
	private static Font fontHeadline = new Font("Calibri", Font.BOLD, 16);
	private static Font fontSubHeadline = new Font("Calibri", Font.BOLD, 14);
	private static Font fontText = new Font("Calibri", Font.PLAIN, 14);

	private static String typeMeeting;
	private static int dayCreation;
	private static int monthCreation;
	private static int yearCreation;
	private static Calendar calCreation = Calendar.getInstance();
	private static String locationMeeting;
	private static int day;
	private static int month;
	private static int year;
	private static Calendar calNote = Calendar.getInstance();
	private static int hour;
	private static int minute;
	private static int second;
	private static String time;


	public static void detailsMeeting() {
		panelMeeting.removeAll();
		labelInstruction.setFont(fontHeadline);
		labelSortOfMeeting.setFont(fontSubHeadline);
		labelDateCreation.setFont(fontSubHeadline);
		labelLocation.setFont(fontSubHeadline);
		labelDate.setFont(fontSubHeadline);
		labelTime.setFont(fontSubHeadline);
		labelEmployee.setFont(fontSubHeadline);
		fieldLocation.setFont(fontText);
		fieldType.setFont(fontText);
		timeChooser.setFont(fontText);
		dialogMeeting.setSize(400, 400);
		dialogMeeting.setLocationRelativeTo(null);
		dialogMeeting.setResizable(false);
		dialogMeeting.setTitle("Meeting Details");
		modelDialogEmployeeMeeting.setColumnIdentifiers(COLUMN_IDENTIFIERS_VACANCYMANAGEMENT_MEETING);
		tableDialogEmployeeMeeting.getTableHeader().setReorderingAllowed(false);
		tableDialogEmployeeMeeting.setAutoCreateRowSorter(true);
		tableDialogEmployeeMeeting = new JTable(modelDialogEmployeeMeeting);
		JScrollPane scrollPaneEmployeeMeeting = new JScrollPane(tableDialogEmployeeMeeting);
		panelMeeting.add(scrollPaneEmployeeMeeting);
		scrollPaneEmployeeMeeting.setBounds(0, 400, 400, 100);
		scrollPaneEmployeeMeeting.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		tableDialogEmployeeMeeting.setRowHeight(20);
		panelMeeting.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][][][][][][][][][][][][]push[]"));
		panelMeeting.add(labelInstruction,"cell 0 0 2 1,alignx center");
		panelMeeting.add(labelSortOfMeeting, "cell 0 1,alignx left");
		panelMeeting.add(fieldType, "cell 0 2 2 1,growx");
		panelMeeting.add(labelDateCreation, "cell 0 3,alignx left");
		panelMeeting.add(dateChooserDateCreation, "cell 0 4 2, growx");
		panelMeeting.add(labelLocation, "cell 0 5,alignx left");
		panelMeeting.add(fieldLocation, "cell 0 6 2 1,growx");
		panelMeeting.add(labelDate, "cell 0 7,alignx left");
		panelMeeting.add(dateChooserDate, "cell 0 8 2, growx");
		panelMeeting.add(labelTime, "cell 0 9,alignx left");
		panelMeeting.add(timeChooser, "cell 0 10 2 1,growx");
		panelMeeting.add(labelEmployee, "cell 0 11,alignx left");
		panelMeeting.add(scrollPaneEmployeeMeeting, "cell 0 12 2 1,growx");
		panelMeeting.add(buttonBack, "cell 0 13,alignx left");
		panelMeeting.add(buttonSave, "cell 1 13,alignx right");
		Oberflaeche.tabBar.addTab("Terminübersicht", panelMeeting);
		tableDialogEmployeeMeeting.setAutoCreateRowSorter(true);

		buttonSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					typeMeeting = fieldType.getText();
				} catch (Exception e) {
				}
				try {
					String date = ((JTextField)dateChooserDateCreation.getDateEditor().getUiComponent()).getText(); 
					String[] parts = date.split("\\.");
					dayCreation = Integer.parseInt(parts[0]);
					monthCreation = Integer.parseInt(parts[1]);
					yearCreation = Integer.parseInt(parts[2]);
					calCreation.set(Calendar.YEAR, yearCreation);
					calCreation.set(Calendar.MONTH, (monthCreation - 1));
					calCreation.set(Calendar.DAY_OF_MONTH, dayCreation);	
				} catch (Exception e) {
				}	
				try {
					locationMeeting = fieldLocation.getText();
				} catch (Exception e) {
				}
				try {
					hour = timeChooser.getHours();
					minute = timeChooser.getMinutes();
					second = timeChooser.getSeconds();
					time = hour + ":" + minute + ":" + second;
				} catch (Exception e) {
				}
				try {
					String date = ((JTextField)dateChooserDateCreation.getDateEditor().getUiComponent()).getText(); 
					String[] parts = date.split("\\.");
					day = Integer.parseInt(parts[0]);
					month = Integer.parseInt(parts[1]);
					year = Integer.parseInt(parts[2]);
					calNote.set(Calendar.YEAR, year);
					calNote.set(Calendar.MONTH, (month - 1));
					calNote.set(Calendar.DAY_OF_MONTH, day);	
				} catch (Exception e) {
				}		
			InsertMeetingIntoDatabase.insertMeeting(typeMeeting, locationMeeting, calNote, time);
			InsertMeetingIntoDatabase.insertParticipation();
			InsertMeetingDataIntoTable.insertMeetingDataIntoTable();
			MenuBarPanelMeeting.modelEmployeeMeeting.setDataVector(InsertMeetingDataIntoTable.resultsMeeting,MenuBarPanelMeeting.COLUMN_IDENTIFIERS_VACANCYMANAGEMENT);
			MenuBarPanelMeeting.modelEmployeeMeeting.fireTableDataChanged();
			dialogMeeting.dispose();
			}
		});
		
		buttonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				dialogMeeting.dispose();
			}
		});
		dialogMeeting.add(panelMeeting);
		dialogMeeting.setVisible(true);

	}
	

}
