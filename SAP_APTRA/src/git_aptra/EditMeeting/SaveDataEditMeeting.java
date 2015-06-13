package git_aptra.EditMeeting;

import git_aptra.Login.Login;
import git_aptra.Meeting.InsertMeetingDataIntoTable;
import git_aptra.MenuBar.MenuBarPanelMeeting;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SaveDataEditMeeting {
	static String area;
	static String vacancyID;
	static int meetingID;
	
	public static void save(){
		DialogLoadEditApplicantData.getApplicantData();
		DialogEditMeetingSpecification.getSpecification();
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		String query = "UPDATE meeting"
				+ "(position = ?, area = ?, applicantID = ?, name = ?, firstName = ?, typeMeeting = ?, location = ?, date = ?, time = ?)";
		try {
			Connection con =  Login.getConnection();
			Statement stmt =  con.createStatement();
		    ResultSet rs = stmt.executeQuery("SELECT  vacancyID from applicant where applicantID = " +  DialogEditMeetingGeneral.labelApplicantIDContent.getText() );
		    while (rs.next()) {
		        vacancyID = rs.getString(1);
		    }
		} catch (Exception e) {
			System.out.println("Fehler auslesen der Position" +e.getMessage());
		}
		
		try {
			Connection con =  Login.getConnection();
			Statement stmt =  con.createStatement();
		    ResultSet rs = stmt.executeQuery("SELECT  area from vacancy where vacancyID = " +  vacancyID );
		    while (rs.next()) {
		        area = rs.getString(1);
		    }
		} catch (Exception e) {
			System.out.println("Fehler auslesen der Position" +e.getMessage());
		}
		
		try {
			dbConnection = Login.getConnection();
			preparedStatement = dbConnection.prepareStatement(query);
			preparedStatement.setString(1, DialogEditMeetingGeneral.labelPositionContent.getText());
			preparedStatement.setString(2, area);
			preparedStatement.setString(3, DialogEditMeetingGeneral.labelApplicantIDContent.getText());
			preparedStatement.setString(4, DialogEditMeetingGeneral.labelNameContent.getText());
			preparedStatement.setString(5, DialogEditMeetingGeneral.labelFirstNameContent.getText());
			preparedStatement.setString(6, DialogEditMeetingSpecification.getType());
			preparedStatement.setString(7, DialogEditMeetingSpecification.getLocation());
			preparedStatement.setDate(8, new java.sql.Date(DialogEditMeetingSpecification.getCal().getTimeInMillis()));
			preparedStatement.setString(9, DialogEditMeetingSpecification.getTime());
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("insert problems - Datenbank - insert meeting data"+ e.getMessage());
		}
		insertParticipationAddMeeting();
		InsertMeetingDataIntoTable.insertMeetingDataIntoTable();
		MenuBarPanelMeeting.modelEmployeeMeeting.setDataVector(InsertMeetingDataIntoTable.resultsMeeting,MenuBarPanelMeeting.COLUMN_IDENTIFIERS_VACANCYMANAGEMENT);
		MenuBarPanelMeeting.modelEmployeeMeeting.fireTableDataChanged();
		DialogEditMeeting.dialogEditMeeting.dispose();
		}
		
	private static void insertParticipationAddMeeting(){	
		try {
			Connection con =  Login.getConnection();
			Statement stmt =  con.createStatement();
		    ResultSet rs = stmt.executeQuery("SELECT MAX(meetingID) from meeting");
		    while (rs.next()) {
		        meetingID = rs.getInt(1);
		    }
		} catch (Exception e) {
			System.out.println("Fehler auslesen der MeetingID" +e.getMessage());
		}
		
		int []rows = DialogEditMeetingSpecification.tableDialogEmployeeMeeting.getSelectedRows();
		
		for (int i = 0; i < rows.length; i++) {
			int id = Integer.parseInt((String) DialogEditMeetingSpecification.tableDialogEmployeeMeeting.getValueAt(i, 0));
			Connection dbConnection = null;
			PreparedStatement preparedStatement = null;
			
			String query = "INSERT INTO participation"
					+ "(employeeID, meetingID) VALUES"
					+ "(?,?)";

			try {
				dbConnection = Login.getConnection();
				preparedStatement = dbConnection.prepareStatement(query);
				preparedStatement.setInt(1, id);
				preparedStatement.setInt(2, meetingID);
				
		
				preparedStatement.executeUpdate();
				preparedStatement.close();
				
			} catch (SQLException e) {
				System.out
						.println("insert problems - Datenbank - insert participation data"
								+ e.getMessage());
			}
		}
	}
}

