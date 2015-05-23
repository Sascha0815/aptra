package git_aptra.Delete;

import git_aptra.EditSelection.DialogEditSelection;
import git_aptra.EditSelection.InsertEditSelectionDataIntoTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

public class DeleteSelection {
	@SuppressWarnings("rawtypes")
	public static void deleteSelection() {
		Connection dbConnection = null;
		@SuppressWarnings("unused")
		PreparedStatement preparedStatement = null;
		try {
			dbConnection = DriverManager.getConnection(
					"jdbc:mysql://185.28.20.242:3306/u474396146_db",
					"u474396146_aptra", "aptraDB");
		} catch (SQLException e) {
		}

		int[] rows = DialogEditSelection.tableEditSelection.getSelectedRows();
		for (int i = 0; i < (rows.length); i++) {
			try {
				String ids = (String) DialogEditSelection.tableEditSelection.getValueAt(rows[i], 0);
				int id = Integer.parseInt(ids);
				String query = "DELETE FROM evaluation WHERE evaluationID = " + id;
				PreparedStatement preparedStmt = dbConnection.prepareStatement(query);
				preparedStmt.execute();
			} catch (Exception e) {
			}
			
		}
		Vector resultsSeleciton = InsertEditSelectionDataIntoTable.insertEditSelectionDataIntoTable();
		DialogEditSelection.modelEditSelection.setDataVector(resultsSeleciton, DialogEditSelection.COLUMN_IDENTIFIERS_SELECTION);
		DialogEditSelection.modelEditSelection.fireTableDataChanged();
	}
}