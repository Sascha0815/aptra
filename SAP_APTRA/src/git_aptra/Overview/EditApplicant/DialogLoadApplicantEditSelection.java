package git_aptra.Overview.EditApplicant;

import git_aptra.Oberflaeche;

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

public class DialogLoadApplicantEditSelection {
		
	private static JDialog dialogLoadApplicantData = new JDialog(Oberflaeche.frame, true);
	
	private static JPanel panelDialogLoadApplicantData = new JPanel();
	
	private static JLabel labelInstruction = new JLabel("Bewerberdaten auswählen");
	private static JLabel labelApplicantID = new JLabel("Bewerber-ID:");
	private static JLabel labelName = new JLabel("Name:");
	private static JLabel labelFirstName = new JLabel("Vorname:");
	private static JLabel labelVacancyID = new JLabel("Stellen-ID:");
	private static JLabel labelPosition = new JLabel("Stellenbezeichnung:");

	private static JTextField fieldApplicantID = new JTextField();
	private static JTextField fieldName = new JTextField();
	private static JTextField fieldFirstName = new JTextField();
	private static JTextField fieldVacancyID = new JTextField();
	private static JTextField fieldPosition = new JTextField();
	
	private static JButton buttonSave = new JButton("Übernehmen");
	private static JButton buttonAbort = new JButton("Abbrechen");
	private static JButton buttonSearch = new JButton("Suchen");
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public final static Vector COLUMN_IDENTIFIERS_VACANCYMANAGEMENT_MEETING = new Vector() {
		private static final long serialVersionUID = 1L;

		{
			add("ID");
			add("Name");
			add("Vorname");
			add("Stellen-ID");
			add("Bezeichnung");
		}
	};
	
	public static DefaultTableModel modelDialogLoadApplicantData = new DefaultTableModel() {
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	
	public static JTable tableDialogLoadApplicantData = new JTable(modelDialogLoadApplicantData);
	
	private static Font fontHeadline = new Font("Calibri", Font.BOLD, 16);
	
	private static String applicantID;
	private static String name;
	private static String firstName;
	private static String vacancyID;
	private static String vacancy;
	@SuppressWarnings("rawtypes")
	private static Vector resultsLoadApplicantData = new Vector();
	@SuppressWarnings("rawtypes")
	private static Vector resultsLoadApplicantDataAll = new Vector();
	
	public static void loadApplicantData(){
		panelDialogLoadApplicantData.removeAll();
		for(int i = 0; i<modelDialogLoadApplicantData.getRowCount();i++){
			modelDialogLoadApplicantData.removeRow(i);
		}
		fieldApplicantID.setText("");
		fieldName.setText("");
		fieldFirstName.setText("");
		fieldVacancyID.setText("");
		fieldPosition.setText("");
		labelInstruction.setFont(fontHeadline);
		dialogLoadApplicantData.setSize(425, 500);
		dialogLoadApplicantData.setLocationRelativeTo(Oberflaeche.frame);
		modelDialogLoadApplicantData.setColumnIdentifiers(COLUMN_IDENTIFIERS_VACANCYMANAGEMENT_MEETING);
		tableDialogLoadApplicantData.getTableHeader().setReorderingAllowed(false);
		tableDialogLoadApplicantData.setAutoCreateRowSorter(true);
		tableDialogLoadApplicantData = new JTable(modelDialogLoadApplicantData);
		JScrollPane scrollPaneLoadApplicantData = new JScrollPane(tableDialogLoadApplicantData);
		scrollPaneLoadApplicantData.setBounds(0, 400, 400, 100);
		scrollPaneLoadApplicantData.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		tableDialogLoadApplicantData.setRowHeight(20);
		tableDialogLoadApplicantData.setAutoCreateRowSorter(true);
		resultsLoadApplicantDataAll = LoadApplicantData.insertLoadApplicantDataIntoTable();
		DialogLoadApplicantEditSelection.modelDialogLoadApplicantData.setDataVector(resultsLoadApplicantDataAll,DialogLoadApplicantEditSelection.COLUMN_IDENTIFIERS_VACANCYMANAGEMENT_MEETING);
		DialogLoadApplicantEditSelection.modelDialogLoadApplicantData.fireTableDataChanged();
		dialogLoadApplicantData.add(panelDialogLoadApplicantData);
		panelDialogLoadApplicantData.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][][][][][][][][][][][][]5[]5[]5[]5"));
		panelDialogLoadApplicantData.add(labelInstruction,"cell 0 0 2 1,alignx center");
		panelDialogLoadApplicantData.add(labelApplicantID,"cell 0 2,alignx left");
		panelDialogLoadApplicantData.add(fieldApplicantID,"cell 0 3 2 1,growx");
		panelDialogLoadApplicantData.add(labelName,"cell 0 4,alignx left");
		panelDialogLoadApplicantData.add(fieldName,"cell 0 5 2 1,growx");
		panelDialogLoadApplicantData.add(labelFirstName,"cell 0 6,alignx left");
		panelDialogLoadApplicantData.add(fieldFirstName,"cell 0 7 2 1,growx");
		panelDialogLoadApplicantData.add(labelVacancyID,"cell 0 8,alignx left");
		panelDialogLoadApplicantData.add(fieldVacancyID,"cell 0 9 2 1,growx");
		panelDialogLoadApplicantData.add(labelPosition,"cell 0 10,alignx left");
		panelDialogLoadApplicantData.add(fieldPosition,"cell 0 11 2 1,growx");
		panelDialogLoadApplicantData.add(buttonSearch, "cell 1 14, alignx right");
		panelDialogLoadApplicantData.add(scrollPaneLoadApplicantData, "cell 0 15 2 1,growx");
		panelDialogLoadApplicantData.add(buttonAbort,"cell 0 16,alignx left");
		panelDialogLoadApplicantData.add(buttonSave,"cell 1 16,alignx right");
	
		buttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				getApplicantData();
				try {
					resultsLoadApplicantData = LoadApplicantData.loadApplicanData();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				modelDialogLoadApplicantData.setDataVector(resultsLoadApplicantData,COLUMN_IDENTIFIERS_VACANCYMANAGEMENT_MEETING);
				modelDialogLoadApplicantData.fireTableDataChanged();
			}
		});
		
		buttonSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				
				
				
				/*
				DialogShowApplicantInfoGeneral.labelApplicantIDContent.setText((String) tableDialogLoadApplicantData.getValueAt(tableDialogLoadApplicantData.getSelectedRow(), 0));
				DialogShowApplicantInfoGeneral.labelNameContent.setText((String) tableDialogLoadApplicantData.getValueAt(tableDialogLoadApplicantData.getSelectedRow(), 1));
				DialogShowApplicantInfoGeneral.labelFirstNameContent.setText((String) tableDialogLoadApplicantData.getValueAt(tableDialogLoadApplicantData.getSelectedRow(), 2));
				DialogShowApplicantInfoGeneral.labelVacancyIDContent.setText((String) tableDialogLoadApplicantData.getValueAt(tableDialogLoadApplicantData.getSelectedRow(), 3));
				DialogShowApplicantInfoGeneral.labelPositionContent.setText((String) tableDialogLoadApplicantData.getValueAt(tableDialogLoadApplicantData.getSelectedRow(), 4));
				*/
				dialogLoadApplicantData.dispose();
			}
		});
		
		buttonAbort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				dialogLoadApplicantData.dispose();
			}
		});
		
		
		dialogLoadApplicantData.setVisible(true);
	}
	
	public static void getApplicantData(){
		try {
			applicantID = fieldApplicantID.getText();
		} catch (Exception e) {
		}
		try {
			name = fieldName.getText();
		} catch (Exception e) {
		}
		try {
			firstName = fieldFirstName.getText();
		} catch (Exception e) {
		}
		try {
			vacancyID = fieldVacancyID.getText();
		} catch (Exception e) {
		}
		try {
			vacancy = fieldPosition.getText();
		} catch (Exception e) {
		}
	}
	
	public static String getApplicantID() {
		return applicantID;
	}
	
	public static String getName() {
		return name;
	}

	public static String getFirstName() {
		return firstName;
	}
	
	public static String getVacancyID() {
		return vacancyID;
	}

	public static String getPosition() {
		return vacancy;
	}
	
}

