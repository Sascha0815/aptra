package git_aptra.DatabaseConnection;

import git_aptra.MenuBar.MenuBarPanelWorkplace;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteVacancy {
	public static void deleteVacancy() {
		Connection dbConnection = null;
		@SuppressWarnings("unused")
		PreparedStatement preparedStatement = null;

		try {
			dbConnection = DriverManager.getConnection(
					"jdbc:mysql://185.28.20.242:3306/u474396146_db",
					"u474396146_aptra", "aptraDB");
		} catch (SQLException e) {
			System.out.println("Datenbank - deleteVacancy" + e.getMessage());
		}

		int[] rows = MenuBarPanelWorkplace.tableJob.getSelectedRows();
		for (int i = 0; i < (rows.length); i++) {
			try {
				String ids = (String) MenuBarPanelWorkplace.tableJob
						.getValueAt(rows[i], 0);
				int id = Integer.parseInt(ids);
				String query = "delete from vacancy where vacancyID = " + id;
				PreparedStatement preparedStmt = dbConnection
						.prepareStatement(query);
				preparedStmt.execute();
			} catch (Exception e) {
				System.out.println("exception search methode");
			}
		}
	}
}
