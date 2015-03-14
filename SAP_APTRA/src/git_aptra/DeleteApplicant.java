package git_aptra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteApplicant {
	public void deleteApplicant() {
		Connection dbConnection = null;
		@SuppressWarnings("unused")
		PreparedStatement preparedStatement = null;

		try {
			dbConnection = DriverManager.getConnection(
					"jdbc:mysql://185.28.20.242:3306/u474396146_db",
					"u474396146_aptra", "aptraDB");
		} catch (SQLException e) {
			System.out.println("Datenbank - deleteApplicant" + e.getMessage());
		}

		int[] rows = MenuBarPanelApplicant.tableApplicant.getSelectedRows();
		for (int i = 0; i <= (rows.length); i++) {
			try {
				int id = (rows[i]) + 1;
				String query = "delete from applicant where id = " + id;
				PreparedStatement preparedStmt = dbConnection
						.prepareStatement(query);
				preparedStmt.execute();

			} catch (Exception e) {

			}
		}

		try {
			String query = "ALTER TABLE `applicant` DROP `id`";
			PreparedStatement preparedStmt = dbConnection
					.prepareStatement(query);
			preparedStmt.execute();
			query = "ALTER TABLE `applicant` ADD `id` INT( 11 ) NOT NULL AUTO_INCREMENT PRIMARY KEY FIRST";
			preparedStmt = dbConnection.prepareStatement(query);
			preparedStmt.execute();
		} catch (Exception e) {
		}

	}
}
