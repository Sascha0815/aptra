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
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		String query = "UPDATE meeting SET typeMeeting = ?, location = ?, date = ?, time = ? WHERE applicantID = " + MenuBarPanelMeeting.tableEmployeeMeeting.getValueAt(MenuBarPanelMeeting.tableEmployeeMeeting.getSelectedRow(), 2);
		
		try {
			dbConnection = Login.getConnection();
			preparedStatement = dbConnection.prepareStatement(query);
			preparedStatement.setString(1, DialogEditMeetingSpecification.getType());
			preparedStatement.setString(2, DialogEditMeetingSpecification.getLocation());
			preparedStatement.setDate(2, new java.sql.Date(DialogEditMeetingSpecification.getCal().getTimeInMillis()));
			preparedStatement.setString(4, DialogEditMeetingSpecification.getTime());
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

