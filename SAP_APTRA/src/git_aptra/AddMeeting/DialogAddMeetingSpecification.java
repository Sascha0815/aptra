package git_aptra.AddMeeting;

import git_aptra.Oberflaeche;

import java.awt.Dimension;
import java.awt.Font;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;

public class DialogAddMeetingSpecification {

	private static JPanel panelDialogMeetingSpecification = new JPanel();
	
	private static JLabel labelInstruction = new JLabel("Bitte geben Sie die benötigten Daten ein.");
	private static JLabel labelSortOfMeeting = new JLabel("Art des Termins:");
	private static JLabel labelDateCreation = new JLabel("Datum Termineintrag:");
	private static JLabel labelLocation = new JLabel("Ort:");
	private static JLabel labelDate = new JLabel("Datum Termin:");
	private static JLabel labelTime = new JLabel("Uhrzeit:");
	private static JLabel labelEmployee = new JLabel("Zuständige Mitarbeiter:");
	
	private static SpinnerNumberModel numberModelDayCreation = new SpinnerNumberModel(1,1,31,1);
	private static SpinnerListModel listModelMonthCreation = new SpinnerListModel(new String[] {"Januar", "Februar", "März", "April", "Mai", "Juni", "Juli", "August", "September", "Oktober", "November", "Dezember"});
	private static SpinnerNumberModel numberModelYearCreation = new SpinnerNumberModel(2015,2015,2020,1);

	private static JSpinner spinnerDayCreation = new JSpinner(numberModelDayCreation);
	private static JSpinner spinnerMonthCreation = new JSpinner(listModelMonthCreation);
	private static JSpinner spinnerYearCreation = new JSpinner(numberModelYearCreation);
	
	private static SpinnerNumberModel numberModelDay = new SpinnerNumberModel(1,1,31,1);
	private static SpinnerListModel listModelMonth = new SpinnerListModel(new String[] {"Januar", "Februar", "März", "April", "Mai", "Juni", "Juli", "August", "September", "Oktober", "November", "Dezember"});
	private static SpinnerNumberModel numberModelYear = new SpinnerNumberModel(2015,2015,2020,1);

	private static JSpinner spinnerDay = new JSpinner(numberModelDay);
	private static JSpinner spinnerMonth = new JSpinner(listModelMonth);
	private static JSpinner spinnerYear = new JSpinner(numberModelYear);

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
	public static DefaultTableModel modelDialogEmployeeMeeting = new DefaultTableModel() {
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


public static void addDetailsMeeting() {
	
	panelDialogMeetingSpecification.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][][][][][][][][][][][][]"));
	DialogAddMeeting.tabAdd.addTab("Spezifikationen", panelDialogMeetingSpecification);
	panelDialogMeetingSpecification.add(labelInstruction,"cell 0 0 2 1,alignx center");
	panelDialogMeetingSpecification.add(labelSortOfMeeting, "cell 0 1,alignx left");
	panelDialogMeetingSpecification.add(fieldType, "cell 0 2 2 1,growx");
	panelDialogMeetingSpecification.add(labelDateCreation, "cell 0 3,alignx left");
	panelDialogMeetingSpecification.add(spinnerDayCreation, "cell 0 4 2, alignx left");
	panelDialogMeetingSpecification.add(spinnerMonthCreation, "cell 0 4 2 1, alignx left");
	panelDialogMeetingSpecification.add(spinnerYearCreation, "cell 0 4 2 2, alignx left");
	spinnerYearCreation.setEditor(new JSpinner.NumberEditor(spinnerYearCreation, "0"));
	
	panelDialogMeetingSpecification.add(labelLocation, "cell 0 5,alignx left");
	panelDialogMeetingSpecification.add(fieldLocation, "cell 0 6 2 1,growx");
	panelDialogMeetingSpecification.add(labelDate, "cell 0 7,alignx left");
	panelDialogMeetingSpecification.add(spinnerDay, "cell 0 8 2, alignx left");
	panelDialogMeetingSpecification.add(spinnerMonth, "cell 0 8 2 1, alignx left");
	panelDialogMeetingSpecification.add(spinnerYear, "cell 0 8 2 2, alignx left");
	spinnerYear.setEditor(new JSpinner.NumberEditor(spinnerYear, "0"));
	panelDialogMeetingSpecification.add(labelTime, "cell 0 9,alignx left");
	panelDialogMeetingSpecification.add(fieldTime, "cell 0 10 2 1,growx");
	panelDialogMeetingSpecification.add(labelEmployee, "cell 0 11,alignx left");
	JScrollPane scrollPaneEmployeeMeeting = new JScrollPane(
			tableDialogEmployeeMeeting);
	panelDialogMeetingSpecification.add(scrollPaneEmployeeMeeting, "cell 0 12 2 1,growx");
	panelDialogMeetingSpecification.add(save, "cell 0 13 ,alignx left");
	
	modelDialogEmployeeMeeting
	.setColumnIdentifiers(COLUMN_IDENTIFIERS_VACANCYMANAGEMENT_MEETING);
tableDialogEmployeeMeeting.getTableHeader().setReorderingAllowed(false);
tableDialogEmployeeMeeting.setAutoCreateRowSorter(true);
tableDialogEmployeeMeeting = new JTable(modelDialogEmployeeMeeting);
scrollPaneEmployeeMeeting.setBounds(0, 400, 400, 100);
scrollPaneEmployeeMeeting
	.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

tableDialogEmployeeMeeting.setRowHeight(20);
tableDialogEmployeeMeeting.setAutoCreateRowSorter(true);

}

}
