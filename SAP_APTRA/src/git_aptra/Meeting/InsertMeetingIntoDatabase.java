package git_aptra.Meeting;


import git_aptra.Login.Login;
import git_aptra.MenuBar.MenuBarPanelVacancyManagement;
import git_aptra.VacancyManagement.DialogOpenVacancy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

public class InsertMeetingIntoDatabase {
	static String position;
	static int idVacancy = DialogOpenVacancy.getID();
	static String name;
	static String firstName;
	static String area;
	static int meetingID;
	public static void insertMeeting(String type, String location, Calendar cal, String time){
		
		try {
			Connection con =  Login.getConnection();
			Statement stmt =  con.createStatement();
		    ResultSet rs = stmt.executeQuery("SELECT position, area from vacancy where vacancyID = " +  idVacancy );
		    while (rs.next()) {
		        position = rs.getString(1);
		        area = rs.getString(2);
		    }
		} catch (Exception e) {
			System.out.println("Fehler auslesen der Position" +e.getMessage());
		}
		
		try {
			Connection con = Login.getConnection();
			Statement stmt =  con.createStatement();
		    ResultSet rs = stmt.executeQuery("SELECT  name, firstName from applicant where applicantId = " +  MenuBarPanelVacancyManagement.getIDApplicant() );
		    while (rs.next()) {		    	
		        name = rs.getString(1);
		        firstName = rs.getString(2);
		        
		    }
		} catch (Exception e) {
			System.out.println("Fehler auslesen der Bewerberinfos" +e.getMessage());
		}
		
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		
		String query = "INSERT INTO meeting"
				+ "(position, area, applicantID, name, firstName, typeMeeting, location, date, time) VALUES"
				+ "(?,?,?,?,?,?,?,?,?)";

		try {
			dbConnection = Login.getConnection();
			preparedStatement = dbConnection.prepareStatement(query);
			preparedStatement.setString(1, position);
			preparedStatement.setString(2, area);
			preparedStatement.setInt(3, MenuBarPanelVacancyManagement.getIDApplicant());
			preparedStatement.setString(4, name);
			preparedStatement.setString(5, firstName);
			preparedStatement.setString(6, type);
			preparedStatement.setString(7, location);
			preparedStatement.setDate(8, new java.sql.Date(cal.getTimeInMillis()));
			preparedStatement.setString(9, time);
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("insert problems - Datenbank - insert meeting data "
							+ e.getMessage());
		}
	}
	
	public static void insertParticipation(){	
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
		
		int []rows = DialogDetailsMeeting.tableDialogEmployeeMeeting.getSelectedRows();
		
		for (int i = 0; i < rows.length; i++) {
			int id = Integer.parseInt((String) DialogDetailsMeeting.tableDialogEmployeeMeeting.getValueAt(i, 0));
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
