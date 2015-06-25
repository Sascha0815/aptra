package git_aptra.EditMeeting;

import git_aptra.Login.Login;
import git_aptra.Meeting.InsertMeetingDataIntoTable;
import git_aptra.MenuBar.MenuBarPanelMeeting;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;


public class SaveDataEditMeeting {
	static String area;
	static String vacancyID;
	static int meetingID;
	
	public static void save(){
		DialogEditMeeting.getData();
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		String query = "UPDATE meeting SET typeMeeting = ?, location = ?, date = ?, time = ? WHERE meetingID = " + EditMeeting.getMeetingID();
		
		try {
			dbConnection = Login.getConnection();
			preparedStatement = dbConnection.prepareStatement(query);
			preparedStatement.setString(1, DialogEditMeeting.getType());
			preparedStatement.setString(2, DialogEditMeeting.getLocation());
			preparedStatement.setDate(3, new java.sql.Date(DialogEditMeeting.getCal().getTimeInMillis()));
			preparedStatement.setString(4, DialogEditMeeting.getTime());
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("insert problems - Datenbank - insert meeting data"+ e.getMessage());
		}
		@SuppressWarnings("rawtypes")
		Vector results  = InsertMeetingDataIntoTable.insertMeetingDataIntoTable();
		MenuBarPanelMeeting.modelEmployeeMeeting.setDataVector(results ,MenuBarPanelMeeting.COLUMN_IDENTIFIERS_VACANCYMANAGEMENT);
		MenuBarPanelMeeting.modelEmployeeMeeting.fireTableDataChanged();
		DialogEditMeeting.dialogEditMeeting.dispose();
		}
		
}

