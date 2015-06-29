package git_aptra.Delete;

import git_aptra.Login.Login;
import git_aptra.MenuBar.MenuBarPanelVacancy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//Löscht Stellen
public class DeleteVacancy {
	public static void deleteVacancy() throws SQLException {
		Connection dbConnection = null;
		@SuppressWarnings("unused")
		PreparedStatement preparedStatement = null;

		dbConnection = Login.getConnection();

		int[] rows = MenuBarPanelVacancy.tableJob.getSelectedRows();
		for (int i = 0; i < (rows.length); i++) {
			try {
				String ids = (String) MenuBarPanelVacancy.tableJob
						.getValueAt(rows[i], 0);
				int id = Integer.parseInt(ids);
				String query = "delete from vacancy where vacancyID = " + id;
				PreparedStatement preparedStmt = dbConnection
						.prepareStatement(query);
				preparedStmt.execute();
			} catch (Exception e) {
				System.out.println("exception search vacancy");
			}
		}
	}
}
