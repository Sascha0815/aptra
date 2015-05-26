package git_aptra.AddMeeting;

import git_aptra.Oberflaeche;

import java.awt.Font;
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

import net.miginfocom.swing.MigLayout;

public class DialogLoadApplicantData {
		
	public static JDialog dialogLoadApplicantData = new JDialog(Oberflaeche.frame);
	
	private static JLabel labelInstruction = new JLabel("Bewerberdaten auswählen");
	private static JLabel labelApplicantID = new JLabel("Bewerber-ID:");
	private static JLabel labelName = new JLabel("Name:");
	private static JLabel labelFirstName = new JLabel("Vorname:");
	private static JLabel labelVacancyID = new JLabel("Stellen-ID:");
	private static JLabel labelPosition = new JLabel("Stellenbezeichnung:");
	private static JLabel labelDivision = new JLabel("Abteilung:");

	private static JTextField fieldApplicantID = new JTextField();
	private static JTextField fieldName = new JTextField();
	private static JTextField fieldFirstName = new JTextField();
	private static JTextField fieldVacancyID = new JTextField();
	private static JTextField fieldPosition = new JTextField();
	private static JTextField fieldDivision = new JTextField();
	
	private static JButton buttonSearch = new JButton ("Suchen");
	private static JButton save = new JButton("Übernehmen");
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public final static Vector COLUMN_IDENTIFIERS_VACANCYMANAGEMENT_MEETING = new Vector() {
		private static final long serialVersionUID = 1L;

		{
			add("ID");
			add("Name");
			add("Vorname");
			add("Stellen-ID");
			add("Bezeichnung");
			add("Abteilung");
		}
	};
	public static DefaultTableModel modelDialogLoadApplicantData = new DefaultTableModel() {
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	public static JTable tableDialogLoadApplicantData = new JTable(
			modelDialogLoadApplicantData);
	
	private static Font fontHeadline = new Font("Calibri", Font.BOLD, 16);
	private static Font fontSubHeadline = new Font("Calibri", Font.BOLD, 14);
	private static Font fontText = new Font("Calibri", Font.PLAIN, 14);
	
	public static void loadApplicantData(){
		dialogLoadApplicantData.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][][][][][][][][][][][][]"));
		
		dialogLoadApplicantData.add(labelInstruction,"cell 0 0 2 1,alignx center");
		labelInstruction.setFont(fontHeadline);
		dialogLoadApplicantData.add(labelApplicantID,"cell 0 2,alignx left");
		dialogLoadApplicantData.add(fieldApplicantID,"cell 0 3 2 1,growx");
		dialogLoadApplicantData.add(labelName,"cell 0 4,alignx left");
		dialogLoadApplicantData.add(fieldName,"cell 0 5 2 1,growx");
		dialogLoadApplicantData.add(labelFirstName,"cell 0 6,alignx left");
		dialogLoadApplicantData.add(fieldFirstName,"cell 0 7 2 1,growx");
		dialogLoadApplicantData.add(labelVacancyID,"cell 0 8,alignx left");
		dialogLoadApplicantData.add(fieldVacancyID,"cell 0 9 2 1,growx");
		dialogLoadApplicantData.add(labelPosition,"cell 0 10,alignx left");
		dialogLoadApplicantData.add(fieldPosition,"cell 0 11 2 1,growx");
		dialogLoadApplicantData.add(buttonSearch, "cell 0 12, alignx right");
		dialogLoadApplicantData.add(labelDivision,"cell 0 13,alignx left");
		dialogLoadApplicantData.add(fieldDivision,"cell 0 14 2 1,growx");
		
		
		JScrollPane scrollPaneLoadApplicantData = new JScrollPane(
				tableDialogLoadApplicantData);
		dialogLoadApplicantData.add(scrollPaneLoadApplicantData, "cell 0 14 2 1,growx");
		
		
		modelDialogLoadApplicantData
		.setColumnIdentifiers(COLUMN_IDENTIFIERS_VACANCYMANAGEMENT_MEETING);
	tableDialogLoadApplicantData.getTableHeader().setReorderingAllowed(false);
	tableDialogLoadApplicantData.setAutoCreateRowSorter(true);
	tableDialogLoadApplicantData = new JTable(modelDialogLoadApplicantData);
	scrollPaneLoadApplicantData.setBounds(0, 400, 400, 100);
	scrollPaneLoadApplicantData
		.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

	tableDialogLoadApplicantData.setRowHeight(20);
	tableDialogLoadApplicantData.setAutoCreateRowSorter(true);
	dialogLoadApplicantData.add(save,"cell 0 15,alignx right");
	
	dialogLoadApplicantData.setVisible(true);
	dialogLoadApplicantData.setSize(425, 500);
	dialogLoadApplicantData.setLocation(null);
	/*
	panelDialogLoadApplicantData.setResizable(false);
	panelDialogLoadApplicantData.setTitle("Bewerberinformationen");
	SwingUtilities.updateComponentTreeUI(panelDialogLoadApplicantData);
	*/
	dialogLoadApplicantData.setLocationRelativeTo(Oberflaeche.frame);

	//panelDialogLoadApplicantData.add(save, "cell 0 13 ,alignx left");
	}
}

