package git_aptra.Overview.EditMeeting;

import git_aptra.Oberflaeche;
import git_aptra.EditMeeting.DialogEditMeeting;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
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

public class DialogOverviewEditMeetingData {
		
	private static JDialog dialogLoadMeetingData = new JDialog(Oberflaeche.frame, true);
	
	private static JPanel paneldialogLoadMeetingData = new JPanel();
	
	private static JLabel labelInstruction = new JLabel("Meeting auswählen");
	private static JLabel labelMeetingID = new JLabel("Termin-ID:");
	private static JLabel labelTypMeeting = new JLabel("Art des Termins:");
	private static JLabel labelLocation = new JLabel("Ort:");
	private static JLabel labelDate = new JLabel("Datum:");
	private static JLabel labelTime = new JLabel("Uhrzeit:");
	
	private static JTextField fieldMeetingID = new JTextField();
	private static JTextField fieldTypMeeting = new JTextField();
	private static JTextField fieldLocation = new JTextField();
	private static JTextField fieldDate = new JTextField();
	private static JTextField fieldTime = new JTextField();
	
	private static JButton buttonSave = new JButton("Übernehmen");
	private static JButton buttonAbort = new JButton("Abbrechen");
	private static JButton buttonSearch = new JButton("Suchen");
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public final static Vector COLUMN_IDENTIFIERS_OVERWIEV_MEETING_INFO = new Vector() {
		private static final long serialVersionUID = 1L;

		{
			add("ID");
			add("Bezeichnung");
			add("Ort");
			add("Zeit");
			add("Datum");
		}
	};
	
	public static DefaultTableModel modeldialogLoadMeetingData = new DefaultTableModel() {
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	
	public static JTable tabledialogLoadMeetingData = new JTable(modeldialogLoadMeetingData);
	
	private static Font fontHeadline = new Font("Calibri", Font.BOLD, 16);
	
	private static String meetingID;
	private static String typeMeeting;
	private static String location;
	private static String time;
	private static String date;
	@SuppressWarnings("rawtypes")
	private static Vector resultsLoadMeetingData = new Vector();
	@SuppressWarnings({ "rawtypes",})
	private static Vector resultsLoadMeetingDataAll = new Vector();
	
	public static void loadMeetingData(){
		
		paneldialogLoadMeetingData.removeAll();
		for(int i = 0; i<modeldialogLoadMeetingData.getRowCount();i++){
			modeldialogLoadMeetingData.removeRow(i);
		}
				
		fieldMeetingID.setText("");
		fieldTypMeeting.setText("");
		fieldDate.setText("");
		fieldTime.setText("");
		labelInstruction.setFont(fontHeadline);
		dialogLoadMeetingData.setSize(425, 450);
		dialogLoadMeetingData.setLocationRelativeTo(Oberflaeche.frame);
		modeldialogLoadMeetingData.setColumnIdentifiers(COLUMN_IDENTIFIERS_OVERWIEV_MEETING_INFO);
		tabledialogLoadMeetingData.getTableHeader().setReorderingAllowed(false);
		tabledialogLoadMeetingData.setAutoCreateRowSorter(true);
		tabledialogLoadMeetingData = new JTable(modeldialogLoadMeetingData);
		JScrollPane scrollPaneLoadMeetingData = new JScrollPane(tabledialogLoadMeetingData);
		scrollPaneLoadMeetingData.setBounds(0, 400, 400, 100);
		scrollPaneLoadMeetingData.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		tabledialogLoadMeetingData.setRowHeight(20);
		tabledialogLoadMeetingData.setAutoCreateRowSorter(true);
		resultsLoadMeetingDataAll = LoadMeetingData.insertLoadMeetingDataIntoTable();
		modeldialogLoadMeetingData.setDataVector(resultsLoadMeetingDataAll,COLUMN_IDENTIFIERS_OVERWIEV_MEETING_INFO);
		modeldialogLoadMeetingData.fireTableDataChanged();
		paneldialogLoadMeetingData.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][][][][][][][][][]5[]5[]5[]"));
		paneldialogLoadMeetingData.add(labelInstruction,"cell 0 0 2 1,alignx center");
		paneldialogLoadMeetingData.add(labelMeetingID,"cell 0 2,alignx left");
		paneldialogLoadMeetingData.add(fieldMeetingID,"cell 0 3 2 1,growx");
		paneldialogLoadMeetingData.add(labelTypMeeting,"cell 0 4,alignx left");
		paneldialogLoadMeetingData.add(fieldTypMeeting,"cell 0 5 2 1,growx");
		paneldialogLoadMeetingData.add(labelLocation,"cell 0 6,alignx left");
		paneldialogLoadMeetingData.add(fieldLocation,"cell 0 7 2 1,growx");
		paneldialogLoadMeetingData.add(labelDate,"cell 0 8 2 1,growx");
		paneldialogLoadMeetingData.add(fieldDate,"cell 0 9 2 1,growx");
		paneldialogLoadMeetingData.add(labelTime,"cell 0 10 2 1,growx");
		paneldialogLoadMeetingData.add(fieldTime,"cell 0 11 2 1,growx");	
		paneldialogLoadMeetingData.add(buttonSearch, "cell 1 12, alignx right");
		paneldialogLoadMeetingData.add(scrollPaneLoadMeetingData, "cell 0 13 2 1,growx");
		paneldialogLoadMeetingData.add(buttonAbort,"cell 0 14,alignx left");
		paneldialogLoadMeetingData.add(buttonSave,"cell 1 14,alignx right");

		
		buttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				getMeetingData();
				try {
					resultsLoadMeetingData = LoadMeetingData.loadMeetingData();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				modeldialogLoadMeetingData.setDataVector(resultsLoadMeetingData,COLUMN_IDENTIFIERS_OVERWIEV_MEETING_INFO);
				modeldialogLoadMeetingData.fireTableDataChanged();
			}
		});
		
		buttonSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				DialogEditMeeting.editMeeting();
			}
		});
		
		buttonAbort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				dialogLoadMeetingData.dispose();
			}
		});
		
		dialogLoadMeetingData.add(paneldialogLoadMeetingData);
		dialogLoadMeetingData.setVisible(true);
	}
	
	public static void getMeetingData(){
		try {
			meetingID = fieldMeetingID.getText();
		} catch (Exception e) {
		}
		try {
			typeMeeting = fieldTypMeeting.getText();
		} catch (Exception e) {
		}
		try {
			location = fieldLocation.getText();
		} catch (Exception e) {
		}
		try {
			time = fieldTime.getText();
		} catch (Exception e) {
		}
		try {
			date = fieldDate.getText();
		} catch (Exception e) {
		}
	}
	
	public static String getMeetingID() {
		return meetingID;
	}
	
	public static String getTypeMeeting() {
		return typeMeeting;
	}

	public static String getLocation() {
		return location;
	}
	
	public static String getTime() {
		return time;
	}

	public static String getDate() {
		return date;
	}

}

