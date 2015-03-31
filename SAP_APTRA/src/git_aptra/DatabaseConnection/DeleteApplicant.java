package git_aptra.DatabaseConnection;

import git_aptra.MenuBar.MenuBarPanelApplicant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteApplicant {
	public static void deleteApplicant() {
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
		for (int i = 0; i < (rows.length); i++) {
			try {
				String ids = (String) MenuBarPanelApplicant.tableApplicant
						.getValueAt(rows[i], 0);
				int id = Integer.parseInt(ids);
				String query = "delete from applicant where applicantID = " + id;
				PreparedStatement preparedStmt = dbConnection
						.prepareStatement(query);
				preparedStmt.execute();
			} catch (Exception e) {
				System.out.println("exception delete methode");
			}
		}

	}
}
