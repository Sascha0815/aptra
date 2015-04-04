package git_aptra.InfoApplicant;

import java.awt.Color;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DialogInfoApplicantHistory {

private static JPanel panelInfoApplicantManagementHistory = new JPanel();
	
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
	public static DefaultTableModel modelInfoApplicantManagementHistory = new DefaultTableModel(
			1, 4) {
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	public static JTable tableInfoApplicantManagementHistory = new JTable(
			modelInfoApplicantManagementHistory);
	
	public static void infoApplicantManagementHistory(){
		panelInfoApplicantManagementHistory.setBackground(Color.LIGHT_GRAY);
		panelInfoApplicantManagementHistory.setLayout(new BoxLayout(
				panelInfoApplicantManagementHistory, BoxLayout.Y_AXIS));
		
		// SWING:Table Bewerber-Management History
				modelInfoApplicantManagementHistory
						.setColumnIdentifiers(COLUMN_IDENTIFIERS_VACANCYMANAGEMENTHISTORY);
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
	
	DialogInfoApplicant.tabInfo.addTab("Dokumentation",
			panelInfoApplicantManagementHistory);
	}	
	public static void reset() {
		panelInfoApplicantManagementHistory.removeAll();
		tableInfoApplicantManagementHistory.removeAll();

	}
	
}
