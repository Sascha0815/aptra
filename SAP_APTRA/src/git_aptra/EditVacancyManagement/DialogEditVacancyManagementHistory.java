package git_aptra.EditVacancyManagement;


import git_aptra.Login.Login;
import git_aptra.MenuBar.MenuBarPanelVacancyManagement;

import java.awt.Color;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DialogEditVacancyManagementHistory {

	private static JPanel panelDialogVacancyManagementHistory = new JPanel();

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public final static Vector COLUMN_IDENTIFIERS_VACANCYMANAGEMENTHISTORY = new Vector() {
		private static final long serialVersionUID = 1L;

		{
			add("Status");
			add("Datum");
			add("Vermerk");
			add("Mitarbeiter");

		}
	};
	public static DefaultTableModel modelVacancyManagementHistory = new DefaultTableModel() {
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	public static JTable tableVacancyManagementHistory = new JTable(
			modelVacancyManagementHistory);

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void editVacancyManagementHistory() {
		panelDialogVacancyManagementHistory.setBackground(Color.LIGHT_GRAY);
		panelDialogVacancyManagementHistory.setLayout(new BoxLayout(
				panelDialogVacancyManagementHistory, BoxLayout.Y_AXIS));

		// SWING:Table Bewerber-Management History
		modelVacancyManagementHistory
				.setColumnIdentifiers(COLUMN_IDENTIFIERS_VACANCYMANAGEMENTHISTORY);
		tableVacancyManagementHistory.getTableHeader().setReorderingAllowed(
				false);
		tableVacancyManagementHistory.setAutoCreateRowSorter(true);
		tableVacancyManagementHistory = new JTable(
				modelVacancyManagementHistory);
		JScrollPane scrollPaneVacancyManagementHistory = new JScrollPane(
				tableVacancyManagementHistory);
		panelDialogVacancyManagementHistory
				.add(scrollPaneVacancyManagementHistory);
		scrollPaneVacancyManagementHistory.setPreferredSize(new Dimension(
				DialogEditVacancyManagement.dialogEditVacancyManagement
						.getSize().width - 20,
				DialogEditVacancyManagement.dialogEditVacancyManagement
						.getSize().height - 15));
		scrollPaneVacancyManagementHistory
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneVacancyManagementHistory
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		tableVacancyManagementHistory.setRowHeight(20);
		

		Vector results = new Vector();
		String id = (String) MenuBarPanelVacancyManagement.tableVacancyManagement
				.getValueAt(
						MenuBarPanelVacancyManagement.tableVacancyManagement
								.getSelectedRow(), 0);
		try {
			Connection con = Login.getConnection();
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

		
		modelVacancyManagementHistory.setDataVector(results,
				COLUMN_IDENTIFIERS_VACANCYMANAGEMENTHISTORY);
		modelVacancyManagementHistory.fireTableDataChanged();

		DialogEditVacancyManagement.tabEditVacancyManagment.addTab(
				"Dokumentation", panelDialogVacancyManagementHistory);

	}

	public static void reset() {
		panelDialogVacancyManagementHistory.removeAll();
		tableVacancyManagementHistory.removeAll();

	}
}
