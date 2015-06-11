package git_aptra.Delete;

import git_aptra.EditSelection.DialogEditSelection;
import git_aptra.EditSelection.InsertEditSelectionDataIntoTable;
import git_aptra.Login.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Vector;

public class DeleteSelection {
	@SuppressWarnings("rawtypes")
	public static void deleteSelection() {
		Connection dbConnection = null;
		@SuppressWarnings("unused")
		PreparedStatement preparedStatement = null;
		dbConnection = Login.getConnection();

		int[] rows = DialogEditSelection.tableEditSelection.getSelectedRows();
		for (int i = 0; i < (rows.length); i++) {
			try {
				String notation = (String) DialogEditSelection.tableEditSelection.getValueAt(rows[i], 0);
				String query = "DELETE FROM evaluation WHERE notation = '" + notation + " '";
				PreparedStatement preparedStmt = dbConnection.prepareStatement(query);
				preparedStmt.execute();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
		Vector resultsSeleciton = InsertEditSelectionDataIntoTable.insertEditSelectionDataIntoTable();
		DialogEditSelection.modelEditSelection.setDataVector(resultsSeleciton, DialogEditSelection.COLUMN_IDENTIFIERS_SELECTION);
		DialogEditSelection.modelEditSelection.fireTableDataChanged();
	}
}
