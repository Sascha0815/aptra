package git_aptra.Delete;

import git_aptra.Login.Login;
import git_aptra.MenuBar.MenuBarPanelMeeting;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteMeeting {
	public static void deleteMeeting() throws SQLException {
		Connection dbConnection = null;
		@SuppressWarnings("unused")
		PreparedStatement preparedStatement = null;

		dbConnection = Login.getConnection();

		int[] rows = MenuBarPanelMeeting.tableEmployeeMeeting.getSelectedRows();
		for (int i = 0; i < (rows.length); i++) {
			try {
				String idm = (String) MenuBarPanelMeeting.tableEmployeeMeeting
						.getValueAt(rows[i], 2);
				int id = Integer.parseInt(idm);
				String query = "delete from meeting where meetingID = " + id;
				PreparedStatement preparedStmt = dbConnection
						.prepareStatement(query);
				preparedStmt.execute();
			} catch (Exception e) {
				System.out.println("exception delete meeting");
			}
		}

	}
}
