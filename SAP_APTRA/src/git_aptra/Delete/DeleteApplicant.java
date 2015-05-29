package git_aptra.Delete;

import git_aptra.Login.Login;
import git_aptra.MenuBar.MenuBarPanelApplicant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteApplicant {
	public static void deleteApplicant() throws SQLException {
		Connection dbConnection = null;
		@SuppressWarnings("unused")
		PreparedStatement preparedStatement = null;

		dbConnection = Login.getConnection();

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
