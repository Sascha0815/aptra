package git_aptra.AddMeeting;

import git_aptra.AddEmployee.InsertEmployeeDataIntoTable;
import git_aptra.Meeting.OpenMeeting;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;




import lu.tudor.santec.jtimechooser.JTimeChooser;

import com.toedter.calendar.JDateChooser;

import net.miginfocom.swing.MigLayout;

public class DialogAddMeetingSpecification {
	private static JPanel panelDialogMeetingSpecification = new JPanel();
	
	private static JLabel labelInstruction = new JLabel("Bitte geben Sie die benötigten Daten ein");
	private static JLabel labelSortOfMeeting = new JLabel("Art des Termins:");
	private static JLabel labelLocation = new JLabel("Raum:");
	private static JLabel labelDate = new JLabel("Datum Termin:");
	private static JLabel labelTime = new JLabel("Uhrzeit:");
	private static JLabel labelEmployee = new JLabel("Zuständiger Mitarbeiter:");
	private static JLabel labelWarning = new JLabel("Kein Mitarbeiter ausgewählt");
	
	private static JDateChooser dateChooser = new JDateChooser();
	
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
	
	private static String type;
	private static String location;
	private static int day;
	private static int month;
	private static int year;
	private static Calendar cal = Calendar.getInstance();
	private static int hour;
	private static int minute;
	private static int second;
	private static String time;
	private static String responsibleEmployeeName;
	private static String responsibleEmployeeFirstName;
	private static boolean first = true;
	
	public static void addDetailsMeeting() {
		panelDialogMeetingSpecification.removeAll();
		fieldLocation.setText("");
		fieldType.setText("");
		labelWarning.setForeground(Color.RED);
		labelWarning.setVisible(false);
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY,0);
		cal.set(Calendar.MINUTE,0);
		cal.set(Calendar.SECOND,0);
		cal.set(Calendar.MILLISECOND,0);
		Date date = cal.getTime();		
		timeChooser.setTime(date);
		dateChooser.setDate(date);
		labelInstruction.setFont(fontHeadline);
		labelSortOfMeeting.setFont(fontSubHeadline);
		labelLocation.setFont(fontSubHeadline);
		labelDate.setFont(fontSubHeadline);
		labelTime.setFont(fontSubHeadline);
		labelEmployee.setFont(fontSubHeadline);
		labelWarning.setFont(fontSubHeadline);
		fieldLocation.setFont(fontText);
		fieldType.setFont(fontText);
		timeChooser.setFont(fontText);
		modelDialogEmployeeMeeting.setColumnIdentifiers(COLUMN_IDENTIFIERS_VACANCYMANAGEMENT_MEETING);
		tableDialogEmployeeMeeting.getTableHeader().setReorderingAllowed(false);
		tableDialogEmployeeMeeting.setAutoCreateRowSorter(true);
		tableDialogEmployeeMeeting = new JTable(modelDialogEmployeeMeeting);
		JScrollPane scrollPaneEmployeeMeeting = new JScrollPane(tableDialogEmployeeMeeting);
		scrollPaneEmployeeMeeting.setBounds(0, 400, 400, 100);
		scrollPaneEmployeeMeeting.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		tableDialogEmployeeMeeting.setRowHeight(20);
		tableDialogEmployeeMeeting.setAutoCreateRowSorter(true);
		@SuppressWarnings("rawtypes")
		Vector resultsEmployee = InsertEmployeeDataIntoTable.insertEmployeeDataIntoTable();
		modelDialogEmployeeMeeting.setDataVector(resultsEmployee,COLUMN_IDENTIFIERS_VACANCYMANAGEMENT_MEETING);
		modelDialogEmployeeMeeting.fireTableDataChanged();
		panelDialogMeetingSpecification.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][][][][][][][][][][][][][]push[]"));
		panelDialogMeetingSpecification.add(labelInstruction,"cell 0 0 2 1,alignx center");
		panelDialogMeetingSpecification.add(labelSortOfMeeting, "cell 0 1,alignx left");
		panelDialogMeetingSpecification.add(fieldType, "cell 0 2 2 1,growx");
		panelDialogMeetingSpecification.add(labelLocation, "cell 0 5,alignx left");
		panelDialogMeetingSpecification.add(fieldLocation, "cell 0 6 2 1,growx");
		panelDialogMeetingSpecification.add(labelDate, "cell 0 7,alignx left");
		panelDialogMeetingSpecification.add(dateChooser, "cell 0 8 2, growx");
		panelDialogMeetingSpecification.add(labelTime, "cell 0 9,alignx left");
		panelDialogMeetingSpecification.add(timeChooser, "cell 0 10 2 1,growx");
		panelDialogMeetingSpecification.add(labelEmployee, "cell 0 11,alignx left");
		panelDialogMeetingSpecification.add(scrollPaneEmployeeMeeting, "cell 0 12 2 1,growx");
		panelDialogMeetingSpecification.add(labelWarning, "cell 0 13,alignx left");
		panelDialogMeetingSpecification.add(buttonBack, "cell 0 14,alignx left");
		panelDialogMeetingSpecification.add(buttonSave, "cell 1 14,alignx right");
		DialogAddMeeting.tabAdd.addTab("Termin", panelDialogMeetingSpecification);
		
		buttonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				DialogAddMeeting.tabAdd.setSelectedIndex(0);
			}
		});
		if (first ==true) {
			first = false;
			buttonSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					if(tableDialogEmployeeMeeting.getSelectedRowCount()==0){
						labelWarning.setVisible(true);
					} else{
						SaveDataAddMeeting.save();
						OpenMeeting.insertInfo();
					}
				}
			});
		}
		
		
	}
	public static void getSpecification(){
		try {
			type = fieldType.getText();
		} catch (Exception e) {
		}
		try {
			location = fieldLocation.getText();
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
			String date = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText(); 
			String[] parts = date.split("\\.");
			day = Integer.parseInt(parts[0]);
			month = Integer.parseInt(parts[1]);
			year = Integer.parseInt(parts[2]);
			cal.set(Calendar.YEAR, year);
			cal.set(Calendar.MONTH, (month - 1));
			cal.set(Calendar.DAY_OF_MONTH, day);	
		} catch (Exception e) {
		}
		
		try {
			responsibleEmployeeName = (String) (tableDialogEmployeeMeeting.getValueAt(tableDialogEmployeeMeeting.getSelectedRow(), 1));
			responsibleEmployeeFirstName = (String) (tableDialogEmployeeMeeting.getValueAt(tableDialogEmployeeMeeting.getSelectedRow(), 2));
		} catch (Exception e) {
		}
	}
	
	public static String getType(){
		return type;
	}
	
	public static String getLocation(){
		return location;
	}
	
	public static Calendar getCal(){
		return cal;
	}
	
	public static String getTime(){
		return time;
	}
	
	public static String getResponsibleEmployeeName(){
		return responsibleEmployeeName;
	}
	
	public static String getResponsibleEmployeeFirstName(){
		return responsibleEmployeeFirstName;
	}
	
	
}

