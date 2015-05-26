package git_aptra.EditVacancyManagement;

import git_aptra.AddEmployee.InsertEmployeeDataIntoTable;
import git_aptra.Meeting.DialogDetailsMeeting;
import git_aptra.MenuBar.MenuBarPanelVacancyManagement;
import git_aptra.VacancyManagement.DialogOpenVacancy;
import git_aptra.VacancyManagement.OpenVacancy;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;

import net.miginfocom.swing.MigLayout;

public class DialogEditVacancyManagementGeneral {
	
	private static JPanel panelDialogEditVacancyManagementMain = new JPanel();

	private static JLabel labelInstruction = new JLabel("Bitte tragen Sie alle erforderlichen Daten ein!");
	private static JLabel labelApplicantID = new JLabel("Bewerber-ID:");
	private static JLabel labelName = new JLabel("Name:");
	private static JLabel labelFirstName = new JLabel("Vorname:");
	private static JLabel labelStatus = new JLabel("Status:");
	private static JLabel labelDate = new JLabel("Datum:");
	private static JLabel labelNote = new JLabel("Vermerk:");

	private static SpinnerNumberModel numberModelDay = new SpinnerNumberModel(1,1,31,1);
	private static SpinnerListModel listModelMonth = new SpinnerListModel(new String[] {"Januar", "Februar", "März", "April", "Mai", "Juni", "Juli", "August", "September", "Oktober", "November", "Dezember"});
	private static SpinnerNumberModel numberModelYear = new SpinnerNumberModel(1,1,2100,1);

	private static JSpinner spinnerDay = new JSpinner(numberModelDay);
	private static JSpinner spinnerMonth = new JSpinner(listModelMonth);
	private static JSpinner spinnerYear = new JSpinner(numberModelYear);

	private static JTextField fieldApplicantID = new JTextField();
	private static JTextField fieldName = new JTextField();
	private static JTextField fieldFirstName = new JTextField();
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
	
	public static void editVacancyManagementGeneral() {
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
		spinnerDay.setFont(fontSubHeadline);
		spinnerMonth.setFont(fontSubHeadline);
		spinnerYear.setFont(fontSubHeadline);
		fieldApplicantID.setFont(fontText);
		fieldName.setFont(fontText);
		fieldFirstName.setFont(fontText);
		fieldNote.setFont(fontText);
		fieldApplicantID.setText(EditVacancyManagement.getDataSetApplicantID());
		fieldName.setText(EditVacancyManagement.getDataSetName());
		fieldFirstName.setText(EditVacancyManagement.getDataSetFirstName());
		fieldApplicantID.setEditable(false);
		fieldName.setEditable(false);
		fieldFirstName.setEditable(false);
		panelDialogEditVacancyManagementMain.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][][][][][][][][][][][][]"));
		panelDialogEditVacancyManagementMain.add(labelInstruction, "cell 0 0 2 1,alignx center");
		panelDialogEditVacancyManagementMain.add(labelApplicantID, "cell 0 1,alignx left");
		panelDialogEditVacancyManagementMain.add(fieldApplicantID, "cell 0 2 2 1, growx");
		panelDialogEditVacancyManagementMain.add(labelName, "cell 0 3,alignx left");
		panelDialogEditVacancyManagementMain.add(fieldName, "cell 0 4 2 1, growx");
		panelDialogEditVacancyManagementMain.add(labelFirstName, "cell 0 5,alignx left");
		panelDialogEditVacancyManagementMain.add(fieldFirstName, "cell 0 6 2 1, growx");
		panelDialogEditVacancyManagementMain.add(labelStatus, "cell 0 7,alignx left");
		panelDialogEditVacancyManagementMain.add(boxStatus, "cell 0 8 2 1, growx");
		panelDialogEditVacancyManagementMain.add(labelDate, "cell 0 9,alignx left");
		panelDialogEditVacancyManagementMain.add(spinnerDay, "cell 0 10 2, growx");
		panelDialogEditVacancyManagementMain.add(spinnerMonth, "cell 0 10 2 1, growx");
		panelDialogEditVacancyManagementMain.add(spinnerYear, "cell 0 10 2 2, growx");
		panelDialogEditVacancyManagementMain.add(labelNote, "cell 0 11,alignx left");
		panelDialogEditVacancyManagementMain.add(fieldNote, "cell 0 12 2, growx");
		panelDialogEditVacancyManagementMain.add(buttonSave, "cell 0 13,alignx left");
		panelDialogEditVacancyManagementMain.add(buttonAbort, "cell 1 13,alignx right ");
		DialogEditVacancyManagement.tabEditVacancyManagment.addTab("Übersicht",panelDialogEditVacancyManagementMain);
		
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

	public static void reset() {
		fieldApplicantID.setText("");
		fieldName.setText("");
		fieldFirstName.setText("");
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
		dayNote = (int) spinnerDay.getValue();
		String valueSpinnerMonth = (String) spinnerMonth.getValue();
		if(valueSpinnerMonth.equals("Januar")){
			monthNote = 1;
		}
		if(valueSpinnerMonth.equals("Februar")){
			monthNote = 2;
		}
		if(valueSpinnerMonth.equals("März")){
			monthNote = 3;
		}
		if(valueSpinnerMonth.equals("April")){
			monthNote = 4;
		}
		if(valueSpinnerMonth.equals("Mai")){
			monthNote = 5;
		}
		if(valueSpinnerMonth.equals("Juni")){
			monthNote = 6;
		}
		if(valueSpinnerMonth.equals("Juli")){
			monthNote = 7;
		}
		if(valueSpinnerMonth.equals("August")){
			monthNote = 8;
		}
		if(valueSpinnerMonth.equals("September")){
			monthNote = 9;
		}
		if(valueSpinnerMonth.equals("Oktober")){
			monthNote = 10;
		}
		if(valueSpinnerMonth.equals("November")){
			monthNote = 11;
		}
		if(valueSpinnerMonth.equals("Dezember")){
			monthNote = 12;
		}
		yearNote = (int) spinnerYear.getValue();
		calNote.set(Calendar.YEAR, yearNote);
		calNote.set(Calendar.MONTH, (monthNote - 1));
		calNote.set(Calendar.DAY_OF_MONTH, dayNote);

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
