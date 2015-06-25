package git_aptra.Overview.ShowVacancyInfo;

import git_aptra.Oberflaeche;
import git_aptra.InfoVacancy.DialogInfoVacancy;
import git_aptra.InfoVacancy.InfoVacancy;
import git_aptra.Overview.EditVacancy.LoadVacancyData;

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

public class DialogLoadVacancyData {
		
	private static JDialog dialogLoadVacancyData = new JDialog(Oberflaeche.frame, true);
	
	private static JPanel paneldialogLoadVacancyData = new JPanel();
	
	private static JLabel labelInstruction = new JLabel("Arbeitsstelle auswählen");
	private static JLabel labelVacancyID = new JLabel("Vacancy-ID:");
	private static JLabel labelPosition = new JLabel("Stellenbezeichnung:");
	private static JLabel labelArea = new JLabel("Arbeitsbereich:");
	private static JLabel labelDivisionID = new JLabel("Abteilungs-ID:");
	private static JLabel labelEducationalAchievement = new JLabel("Höchster Bildungsabschluss:");
	private static JLabel labelRequirementLevel = new JLabel("Anforderung:");
	private static JLabel labelTermsOfEmployment = new JLabel("Anstellungsverhältnis:");
	
	private static JTextField fieldVacancyID = new JTextField();
	private static JTextField fieldPosition = new JTextField();
	private static JTextField fieldArea = new JTextField();
	private static JTextField fieldDivisionID = new JTextField();
	private static JTextField fieldEducationalAchievement = new JTextField();
	private static JTextField fieldRequirementLevel = new JTextField();
	private static JTextField fieldTermsOfEmployment = new JTextField();
	
	private static JButton buttonSave = new JButton("Übernehmen");
	private static JButton buttonAbort = new JButton("Abbrechen");
	private static JButton buttonSearch = new JButton("Suchen");
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public final static Vector COLUMN_IDENTIFIERS_OVERWIEV_VACANCY_INFO = new Vector() {
		private static final long serialVersionUID = 1L;

		{
			add("ID");
			add("Bezeichnung");
			add("Arbeitsbereich");
			add("Abteilung");
			add("Anforderung");
		}
	};
	
	public static DefaultTableModel modeldialogLoadVacancyData = new DefaultTableModel() {
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	
	public static JTable tabledialogLoadVacancyData = new JTable(modeldialogLoadVacancyData);
	
	private static Font fontHeadline = new Font("Calibri", Font.BOLD, 16);

	private static String vacancyID;
	private static String position;
	private static String area;
	private static String divisionID;
	private static String educationalAchievement;
	private static String requirementLevel;
	private static String termsOfEmployment;
	@SuppressWarnings("rawtypes")
	private static Vector resultsLoadVacancyData = new Vector();
	@SuppressWarnings({ "rawtypes",})
	private static Vector resultsLoadVacancyDataAll = new Vector();
	
	public static void loadVacancyData(){
		
		paneldialogLoadVacancyData.removeAll();
		for(int i = 0; i<modeldialogLoadVacancyData.getRowCount();i++){
			modeldialogLoadVacancyData.removeRow(i);
		}
		
		fieldVacancyID.setText("");
		fieldPosition.setText("");
		fieldArea.setText("");
		fieldDivisionID.setText("");
		fieldEducationalAchievement.setText("");
		fieldRequirementLevel.setText("");
		fieldTermsOfEmployment.setText("");
		labelInstruction.setFont(fontHeadline);
		dialogLoadVacancyData.setSize(425, 500);
		dialogLoadVacancyData.setLocationRelativeTo(Oberflaeche.frame);
		modeldialogLoadVacancyData.setColumnIdentifiers(COLUMN_IDENTIFIERS_OVERWIEV_VACANCY_INFO);
		tabledialogLoadVacancyData.getTableHeader().setReorderingAllowed(false);
		tabledialogLoadVacancyData.setAutoCreateRowSorter(true);
		tabledialogLoadVacancyData = new JTable(modeldialogLoadVacancyData);
		JScrollPane scrollPaneLoadVacancyData = new JScrollPane(tabledialogLoadVacancyData);
		scrollPaneLoadVacancyData.setBounds(0, 400, 400, 100);
		scrollPaneLoadVacancyData.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		tabledialogLoadVacancyData.setRowHeight(20);
		tabledialogLoadVacancyData.setAutoCreateRowSorter(true);
		resultsLoadVacancyDataAll = LoadVacancyData.insertLoadVacancyDataIntoTable();
		modeldialogLoadVacancyData.setDataVector(resultsLoadVacancyDataAll,COLUMN_IDENTIFIERS_OVERWIEV_VACANCY_INFO);
		modeldialogLoadVacancyData.fireTableDataChanged();
		paneldialogLoadVacancyData.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][][][][][][][][][][][][][][][][]push[]"));
		paneldialogLoadVacancyData.add(labelInstruction,"cell 0 0 2 1,alignx center");
		paneldialogLoadVacancyData.add(labelVacancyID,"cell 0 2,alignx left");
		paneldialogLoadVacancyData.add(fieldVacancyID,"cell 0 3 2 1,growx");
		paneldialogLoadVacancyData.add(labelPosition,"cell 0 4,alignx left");
		paneldialogLoadVacancyData.add(fieldPosition,"cell 0 5 2 1,growx");
		paneldialogLoadVacancyData.add(labelArea,"cell 0 6,alignx left");
		paneldialogLoadVacancyData.add(fieldArea,"cell 0 7 2 1,growx");
		paneldialogLoadVacancyData.add(labelDivisionID,"cell 0 8,alignx left");
		paneldialogLoadVacancyData.add(fieldDivisionID,"cell 0 9 2 1,growx");
		paneldialogLoadVacancyData.add(labelEducationalAchievement,"cell 0 10,alignx left");
		paneldialogLoadVacancyData.add(fieldEducationalAchievement,"cell 0 11 2 1,growx");
		paneldialogLoadVacancyData.add(labelRequirementLevel,"cell 0 12 2 1,growx");
		paneldialogLoadVacancyData.add(fieldRequirementLevel,"cell 0 13 2 1,growx");
		paneldialogLoadVacancyData.add(labelTermsOfEmployment,"cell 0 14 2 1,growx");
		paneldialogLoadVacancyData.add(fieldTermsOfEmployment,"cell 0 15 2 1,growx");
		paneldialogLoadVacancyData.add(buttonSearch, "cell 1 16, alignx right");
		paneldialogLoadVacancyData.add(scrollPaneLoadVacancyData, "cell 0 17 2 1,growx");
		paneldialogLoadVacancyData.add(buttonAbort,"cell 0 18,alignx left");
		paneldialogLoadVacancyData.add(buttonSave,"cell 1 18,alignx right");
	
		buttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				getVacancyData();
				try {
					resultsLoadVacancyData = LoadVacancyData.loadVacancyData();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				modeldialogLoadVacancyData.setDataVector(resultsLoadVacancyData,COLUMN_IDENTIFIERS_OVERWIEV_VACANCY_INFO);
				modeldialogLoadVacancyData.fireTableDataChanged();
			
			}
		});
		
		buttonSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				dialogLoadVacancyData.dispose();
				InfoVacancy.getVacancyInfo(Integer.parseInt((String) tabledialogLoadVacancyData.getValueAt(tabledialogLoadVacancyData.getSelectedRow(), 0)));
				DialogInfoVacancy.infoVacancy();
			}
		});
		
		buttonAbort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				dialogLoadVacancyData.dispose();
			}
		});
		
		dialogLoadVacancyData.add(paneldialogLoadVacancyData);
		dialogLoadVacancyData.setVisible(true);
	}
	
	public static void getVacancyData(){
		try {
			vacancyID = fieldVacancyID.getText();
		} catch (Exception e) {
		}
		try {
			position = fieldPosition.getText();
		} catch (Exception e) {
		}
		try {
			area = fieldArea.getText();
		} catch (Exception e) {
		}
		try {
			divisionID = fieldDivisionID.getText();
		} catch (Exception e) {
		}
		try {
			educationalAchievement = fieldEducationalAchievement.getText();
		} catch (Exception e) {
		}
		try {
			requirementLevel = fieldRequirementLevel.getText();
		} catch (Exception e) {
		}
		try {
			termsOfEmployment = fieldTermsOfEmployment.getText();
		} catch (Exception e) {
		}
	}
	
	public static String getVacancyID() {
		return vacancyID;
	}
	
	public static String getPosition() {
		return position;
	}

	public static String getArea() {
		return area;
	}
	
	public static String getDivisonID() {
		return divisionID;
	}

	public static String getEducationAchievement() {
		return educationalAchievement;
	}
	
	public static String getRequirementLevel() {
		return requirementLevel;
	}

	public static String getTermsOfEmployment() {
		return termsOfEmployment;
	}

	
}

