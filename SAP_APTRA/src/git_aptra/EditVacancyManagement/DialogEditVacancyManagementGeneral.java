package git_aptra.EditVacancyManagement;

import git_aptra.AddEmployee.InsertEmployeeDataIntoTable;
import git_aptra.Meeting.DialogDetailsMeeting;
import git_aptra.MenuBar.MenuBarPanelVacancyManagement;
import git_aptra.VacancyManagement.DialogOpenVacancy;
import git_aptra.VacancyManagement.OpenVacancy;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import net.miginfocom.swing.MigLayout;
//Reiter des Dialogs zum Bearbeiten von Bewerbern im Management
public class DialogEditVacancyManagementGeneral {
	
	private static JPanel panelDialogEditVacancyManagementMain = new JPanel();

	private static JLabel labelInstruction = new JLabel("Bitte tragen Sie alle erforderlichen Daten ein!");
	private static JLabel labelApplicantID = new JLabel("Bewerber-ID:");
	private static JLabel labelName = new JLabel("Name:");
	private static JLabel labelFirstName = new JLabel("Vorname:");
	private static JLabel labelStatus = new JLabel("Status:");
	private static JLabel labelDate = new JLabel("Datum:");
	private static JLabel labelNote = new JLabel("Vermerk:");
	private static JLabel labelApplicantIDContent = new JLabel();
	private static JLabel labelNameContent = new JLabel();
	private static JLabel labelFirstNameContent = new JLabel();

	private static JDateChooser dateChooser = new JDateChooser();

	private static JTextField fieldNote = new JTextField();

	private static String[] status = { "Bitte auswählen", "Bewerbungseingang","Rückmeldung", "Termin", "Vorauswahl", "Zusage","Absage", "Wartepool", "Sonstiges" };
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static JComboBox boxStatus = new JComboBox(status);
	
	private static JButton buttonSave = new JButton("Speichern");
	private static JButton buttonAbort = new JButton("Abbrechen");
	
	private static Font fontHeadline = new Font("Calibri", Font.BOLD, 16);
	private static Font fontSubHeadline = new Font("Calibri", Font.BOLD, 14);
	private static Font fontText = new Font("Calibri", Font.PLAIN, 14);

	private static String statusNote;
	private static int dayNote;
	private static int monthNote;
	private static int yearNote;
	private static String note;
	private static String employee;
	private static Calendar calNote = Calendar.getInstance();
	private static int amount;
	private static boolean first = true;
	
	public static void editVacancyManagementGeneral() {
		panelDialogEditVacancyManagementMain.removeAll();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY,0);
		cal.set(Calendar.MINUTE,0);
		cal.set(Calendar.SECOND,0);
		cal.set(Calendar.MILLISECOND,0);
		Date date = cal.getTime();	
		dateChooser.setDate(date);
		labelInstruction.setFont(fontHeadline);
		labelApplicantID.setFont(fontSubHeadline);
		labelName.setFont(fontSubHeadline);
		labelFirstName.setFont(fontSubHeadline);
		labelStatus.setFont(fontSubHeadline);
		labelDate.setFont(fontSubHeadline);
		labelNote.setFont(fontSubHeadline);
		buttonSave.setFont(fontSubHeadline);
		buttonAbort.setFont(fontSubHeadline);
		boxStatus.setFont(fontSubHeadline);
		dateChooser.setFont(fontText);
		labelApplicantIDContent.setFont(fontText);
		labelNameContent.setFont(fontText);
		labelFirstNameContent.setFont(fontText);
		fieldNote.setFont(fontText);
		labelApplicantIDContent.setText(EditVacancyManagement.getDataSetApplicantID());
		labelNameContent.setText(EditVacancyManagement.getDataSetName());
		labelFirstNameContent.setText(EditVacancyManagement.getDataSetFirstName());
		panelDialogEditVacancyManagementMain.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][][][][][][][][][][][][]push[]"));
		panelDialogEditVacancyManagementMain.add(labelInstruction, "cell 0 0 2 1,alignx center");
		panelDialogEditVacancyManagementMain.add(labelApplicantID, "cell 0 1,alignx left");
		panelDialogEditVacancyManagementMain.add(labelApplicantIDContent, "cell 0 2 2 1, growx");
		panelDialogEditVacancyManagementMain.add(labelName, "cell 0 3,alignx left");
		panelDialogEditVacancyManagementMain.add(labelNameContent, "cell 0 4 2 1, growx");
		panelDialogEditVacancyManagementMain.add(labelFirstName, "cell 0 5,alignx left");
		panelDialogEditVacancyManagementMain.add(labelFirstNameContent, "cell 0 6 2 1, growx");
		panelDialogEditVacancyManagementMain.add(labelStatus, "cell 0 7,alignx left");
		panelDialogEditVacancyManagementMain.add(boxStatus, "cell 0 8 2 1, growx");
		panelDialogEditVacancyManagementMain.add(labelDate, "cell 0 9,alignx left");
		panelDialogEditVacancyManagementMain.add(dateChooser, "cell 0 10 2, growx");
		panelDialogEditVacancyManagementMain.add(labelNote, "cell 0 11,alignx left");
		panelDialogEditVacancyManagementMain.add(fieldNote, "cell 0 12 2, growx");
		panelDialogEditVacancyManagementMain.add(buttonAbort, "cell 0 13,alignx left ");
		panelDialogEditVacancyManagementMain.add(buttonSave, "cell 1 13,alignx right");
		DialogEditVacancyManagement.tabEditVacancyManagment.addTab("Übersicht",panelDialogEditVacancyManagementMain);
		
		if (first==true) {
			first=false;
			buttonSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					String meeting = "Termin";
					if (meeting.equals((String) boxStatus.getSelectedItem())) {
						@SuppressWarnings("rawtypes")
						Vector resultEmployee = InsertEmployeeDataIntoTable.insertEmployeeDataIntoTable();
						DialogDetailsMeeting.modelDialogEmployeeMeeting.setDataVector(resultEmployee, DialogDetailsMeeting.COLUMN_IDENTIFIERS_VACANCYMANAGEMENT_MEETING);
						DialogDetailsMeeting.modelDialogEmployeeMeeting.fireTableDataChanged();
						DialogDetailsMeeting.detailsMeeting();
					}
					SaveDataEditVacancyManagement.save();
					try {
						InsertEditVacancyManagementDataIntoDatabase.insertEditVacancyManagementData();
					} catch (SQLException e) {
						e.printStackTrace();
					}				
					int id = DialogOpenVacancy.getID();				
					@SuppressWarnings("rawtypes")
					java.util.Vector resultsVacancy = OpenVacancy.openVacancy(id, amount);						
					MenuBarPanelVacancyManagement.modelVacancyManagement.setDataVector(resultsVacancy, MenuBarPanelVacancyManagement.COLUMN_IDENTIFIERS_VACANCYMANAGEMENT);
				}
			});
			
			buttonAbort.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					DialogEditVacancyManagement.dialogEditVacancyManagement.dispose();
				}
			});
		}
		
	}

	public static void reset() {
		fieldNote.setText("");
		boxStatus.setSelectedIndex(0);
	}

	public static void getGeneral() {
		try {
			statusNote = (String) boxStatus.getSelectedItem();
		} catch (Exception e) {
		}
		try {
			note = fieldNote.getText();
		} catch (Exception e) {
		}
		try {
			String date = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText(); 
			String[] parts = date.split("\\.");
			dayNote = Integer.parseInt(parts[0]);
			monthNote = Integer.parseInt(parts[1]);
			yearNote = Integer.parseInt(parts[2]);
			calNote.set(Calendar.YEAR, yearNote);
			calNote.set(Calendar.MONTH, (monthNote - 1));
			calNote.set(Calendar.DAY_OF_MONTH, dayNote);	
		} catch (Exception e) {
		}

	}

	public static Calendar getCalNote() {
		return calNote;
	}

	public static String getStatusNote() {
		return statusNote;
	}

	public static String getNote() {
		return note;
	}

	public static String getEmployee() {
		return employee;
	}

}
