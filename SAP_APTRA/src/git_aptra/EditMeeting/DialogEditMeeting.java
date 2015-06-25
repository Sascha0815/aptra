package git_aptra.EditMeeting;

import git_aptra.Oberflaeche;
import git_aptra.AddEmployee.InsertEmployeeDataIntoTable;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import lu.tudor.santec.jtimechooser.JTimeChooser;

import com.toedter.calendar.JDateChooser;

import net.miginfocom.swing.MigLayout;

public class DialogEditMeeting {
	public static JDialog dialogEditMeeting = new JDialog(Oberflaeche.frame, true);
	private static JPanel panelDialogMeeting = new JPanel();
	
	private static JLabel labelInstruction = new JLabel("Bitte geben Sie die benötigten Daten ein");
	private static JLabel labelSortOfMeeting = new JLabel("Art des Termins:");
	private static JLabel labelLocation = new JLabel("Ort:");
	private static JLabel labelDate = new JLabel("Datum Termin:");
	private static JLabel labelTime = new JLabel("Uhrzeit:");
	
	private static JDateChooser dateChooserDate = new JDateChooser();
	
	private static JTextField fieldLocation = new JTextField();
	private static JTextField fieldType = new JTextField();
	private static JTimeChooser timeChooser = new JTimeChooser();
	
	private static JButton buttonSave = new JButton("Speichern");
	
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

	public static void editMeeting() {
		panelDialogMeeting.removeAll();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY,0);
		cal.set(Calendar.MINUTE,0);
		cal.set(Calendar.SECOND,0);
		cal.set(Calendar.MILLISECOND,0);
		Date date = cal.getTime();			
		dateChooserDate.setDate(date);	
		timeChooser.setTime(date);
		dialogEditMeeting.setSize(425, 310);
		dialogEditMeeting.setTitle("Termin bearbeiten");
		SwingUtilities.updateComponentTreeUI(dialogEditMeeting);
		dialogEditMeeting.setLocationRelativeTo(Oberflaeche.frame);
		labelInstruction.setFont(fontHeadline);
		labelSortOfMeeting.setFont(fontSubHeadline);
		labelLocation.setFont(fontSubHeadline);
		labelDate.setFont(fontSubHeadline);
		labelTime.setFont(fontSubHeadline);
		fieldLocation.setFont(fontText);
		fieldType.setFont(fontText);
		timeChooser.setFont(fontText);
		fieldLocation.setText(EditMeeting.getDataLocation());
		fieldType.setText(EditMeeting.getDataTypeMeeting());
		dateChooserDate.setDate(EditMeeting.getDataDate());
		timeChooser.setTime(EditMeeting.getDataTime());
		panelDialogMeeting.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][][][][][][][][][][]push[]"));
		panelDialogMeeting.add(labelInstruction,"cell 0 0 2 1,alignx center");
		panelDialogMeeting.add(labelSortOfMeeting, "cell 0 1,alignx left");
		panelDialogMeeting.add(fieldType, "cell 0 2 2 1,growx");
		panelDialogMeeting.add(labelLocation, "cell 0 5,alignx left");
		panelDialogMeeting.add(fieldLocation, "cell 0 6 2 1,growx");
		panelDialogMeeting.add(labelDate, "cell 0 7,alignx left");
		panelDialogMeeting.add(dateChooserDate, "cell 0 8 2, growx");
		panelDialogMeeting.add(labelTime, "cell 0 9,alignx left");
		panelDialogMeeting.add(timeChooser, "cell 0 10 2 1,growx");
		panelDialogMeeting.add(buttonSave, "cell 0 11,alignx right");
		dialogEditMeeting.add(panelDialogMeeting);	
		buttonSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				SaveDataEditMeeting.save();
			}
		});
		dialogEditMeeting.setVisible(true);	
	}
	
	public static void getData(){
		try {
			type = fieldType.getText();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			location = fieldLocation.getText();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			hour = timeChooser.getHours();
			minute = timeChooser.getMinutes();
			second = timeChooser.getSeconds();
			time = hour + ":" + minute + ":" + second;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			String date = ((JTextField)dateChooserDate.getDateEditor().getUiComponent()).getText(); 
			String[] parts = date.split("\\.");
			day = Integer.parseInt(parts[0]);
			month = Integer.parseInt(parts[1]);
			year = Integer.parseInt(parts[2]);
			cal.set(Calendar.YEAR, year);
			cal.set(Calendar.MONTH, (month - 1));
			cal.set(Calendar.DAY_OF_MONTH, day);	
		} catch (Exception e) {
			System.out.println(e.getMessage());
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
	
}

