package git_aptra.Delete;

import git_aptra.Login.Login;
import git_aptra.Meeting.InsertMeetingDataIntoTable;
import git_aptra.MenuBar.MenuBarPanelMeeting;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class DeleteMeeting {
	public static void deleteMeeting() throws SQLException {
		Connection dbConnection = null;
		@SuppressWarnings("unused")
		PreparedStatement preparedStatement = null;
		int idm = 0;
		dbConnection = Login.getConnection();

		int[] rows = MenuBarPanelMeeting.tableEmployeeMeeting.getSelectedRows();
		for (int i = 0; i < (rows.length); i++) {
			try {
				int ide = (int) MenuBarPanelMeeting.tableEmployeeMeeting
						.getValueAt(rows[i], 11);
				idm = Integer.parseInt((String) MenuBarPanelMeeting.tableEmployeeMeeting
						.getValueAt(rows[i], 2));
				String query = "delete from participation where meetingID = " + idm + " AND employeeID = " + ide;
				PreparedStatement preparedStmt = dbConnection
						.prepareStatement(query);
				preparedStmt.execute();
			} catch (Exception e) {
				System.out.println(e.getMessage() +" exception delete meeting");
			}
		try {
			Connection con =  Login.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from participation where meetingID = " + idm);
			if (!rs.next() ) {
				String query = "delete from meeting where meetingID = " + idm;
				PreparedStatement preparedStmt = dbConnection
						.prepareStatement(query);
				preparedStmt.execute();				
			}
		} catch (Exception e) {
		}
			
		}
		@SuppressWarnings("rawtypes")
		Vector resultsMeeting = InsertMeetingDataIntoTable.insertMeetingDataIntoTable();
		MenuBarPanelMeeting.modelEmployeeMeeting.setDataVector(resultsMeeting,MenuBarPanelMeeting.COLUMN_IDENTIFIERS_VACANCYMANAGEMENT);
		MenuBarPanelMeeting.modelEmployeeMeeting.fireTableDataChanged();
	}
}
