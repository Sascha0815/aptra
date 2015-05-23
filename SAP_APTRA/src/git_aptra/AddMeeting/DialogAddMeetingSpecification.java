package git_aptra.AddMeeting;

import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

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
	
	private static JDateChooser dateChooserDateCreation = new JDateChooser();
	private static JDateChooser dateChooserDate = new JDateChooser();


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
	private static JButton save = new JButton("Speichern");
	private static JTextField fieldLocation = new JTextField();
	private static JTextField fieldType = new JTextField();
	private static JTextField fieldTime = new JTextField();


	public static void addDetailsMeeting() {
		modelDialogEmployeeMeeting.setColumnIdentifiers(COLUMN_IDENTIFIERS_VACANCYMANAGEMENT_MEETING);
		tableDialogEmployeeMeeting.getTableHeader().setReorderingAllowed(false);
		tableDialogEmployeeMeeting.setAutoCreateRowSorter(true);
		tableDialogEmployeeMeeting = new JTable(modelDialogEmployeeMeeting);
		JScrollPane scrollPaneEmployeeMeeting = new JScrollPane(tableDialogEmployeeMeeting);
		scrollPaneEmployeeMeeting.setBounds(0, 400, 400, 100);
		scrollPaneEmployeeMeeting.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		tableDialogEmployeeMeeting.setRowHeight(20);
		tableDialogEmployeeMeeting.setAutoCreateRowSorter(true);
		panelDialogMeetingSpecification.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][][][][][][][][][][][][]"));
		panelDialogMeetingSpecification.add(labelInstruction,"cell 0 0 2 1,alignx center");
		panelDialogMeetingSpecification.add(labelSortOfMeeting, "cell 0 1,alignx left");
		panelDialogMeetingSpecification.add(fieldType, "cell 0 2 2 1,growx");
		panelDialogMeetingSpecification.add(labelDateCreation, "cell 0 3,alignx left");
		panelDialogMeetingSpecification.add(dateChooserDateCreation, "cell 0 4 2, growx");
		panelDialogMeetingSpecification.add(labelLocation, "cell 0 5,alignx left");
		panelDialogMeetingSpecification.add(fieldLocation, "cell 0 6 2 1,growx");
		panelDialogMeetingSpecification.add(labelDate, "cell 0 7,alignx left");
		panelDialogMeetingSpecification.add(dateChooserDate, "cell 0 8 2, growx");
		panelDialogMeetingSpecification.add(labelTime, "cell 0 9,alignx left");
		panelDialogMeetingSpecification.add(fieldTime, "cell 0 10 2 1,growx");
		panelDialogMeetingSpecification.add(labelEmployee, "cell 0 11,alignx left");
		panelDialogMeetingSpecification.add(scrollPaneEmployeeMeeting, "cell 0 12 2 1,growx");
		panelDialogMeetingSpecification.add(save, "cell 0 13 ,alignx left");
		DialogAddMeeting.tabAdd.addTab("Termin", panelDialogMeetingSpecification);
	}
}
