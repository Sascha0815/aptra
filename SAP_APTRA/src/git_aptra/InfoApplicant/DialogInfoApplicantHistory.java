package git_aptra.InfoApplicant;

import git_aptra.MenuBar.MenuBarPanelApplicant;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DialogInfoApplicantHistory {

private static JPanel panelInfoApplicantManagementHistory = new JPanel();
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public final static Vector COLUMN_IDENTIFIERS_APPLICANTHISTORY = new Vector() {
		private static final long serialVersionUID = 1L;

		{
			add("Status");
			add("Datum");
			add("Vermerk");
			add("Mitarbeiter");

		}
	};
	public static DefaultTableModel modelInfoApplicantManagementHistory = new DefaultTableModel(
			1, 4) {
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	public static JTable tableInfoApplicantManagementHistory = new JTable(
			modelInfoApplicantManagementHistory);
	
	@SuppressWarnings("rawtypes")
	public static void infoApplicantManagementHistory(){
		panelInfoApplicantManagementHistory.setBackground(Color.LIGHT_GRAY);
		panelInfoApplicantManagementHistory.setLayout(new BoxLayout(
				panelInfoApplicantManagementHistory, BoxLayout.Y_AXIS));
		
		// SWING:Table Bewerber-Management History
				modelInfoApplicantManagementHistory
						.setColumnIdentifiers(COLUMN_IDENTIFIERS_APPLICANTHISTORY);
				tableInfoApplicantManagementHistory.getTableHeader().setReorderingAllowed(false);
				tableInfoApplicantManagementHistory.setAutoCreateRowSorter(true);
				tableInfoApplicantManagementHistory = new JTable(modelInfoApplicantManagementHistory);
				JScrollPane scrollPaneInfoApplicantManagementHistory = new JScrollPane(
						tableInfoApplicantManagementHistory);
				panelInfoApplicantManagementHistory.add(scrollPaneInfoApplicantManagementHistory);
				scrollPaneInfoApplicantManagementHistory
						.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
				scrollPaneInfoApplicantManagementHistory
						.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
				tableInfoApplicantManagementHistory.setRowHeight(20);
				
				@SuppressWarnings("rawtypes")
				Vector results = new Vector();
				String id = (String) MenuBarPanelApplicant.tableApplicant
						.getValueAt(
								MenuBarPanelApplicant.tableApplicant
										.getSelectedRow(), 0);
				try {
					Connection con = DriverManager.getConnection(
							"jdbc:mysql://185.28.20.242:3306/u474396146_db",
							"u474396146_aptra", "aptraDB");
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT notes.noteType, notes.date, notes.note, notes.employee FROM relationship INNER JOIN notes ON relationship.applicantID = notes.applicantID where notes.applicantID = " +id);

					while (rs.next()) {
						Vector applicant = new Vector();
						applicant.add(rs.getString(1));
						applicant.add(rs.getString(2));
						applicant.add(rs.getString(3));
						applicant.add(rs.getString(4));
						results.add(applicant);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

				
				modelInfoApplicantManagementHistory.setDataVector(results,
						COLUMN_IDENTIFIERS_APPLICANTHISTORY);
				modelInfoApplicantManagementHistory.fireTableDataChanged();
	
	DialogInfoApplicant.tabInfo.addTab("Dokumentation",
			panelInfoApplicantManagementHistory);
	}	
	public static void reset() {
		panelInfoApplicantManagementHistory.removeAll();
		tableInfoApplicantManagementHistory.removeAll();

	}
	
}
