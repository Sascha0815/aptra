package git_aptra.EditVacancyManagement;


import git_aptra.MenuBar.MenuBarPanelVacancyManagement;
import git_aptra.VacancyManagement.DialogOpenVacancy;

import java.sql.Connection;
import java.sql.DriverManager;
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
	public static void insertMeeting(String type, String location, Calendar cal, String time){
		
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://185.28.20.242:3306/u474396146_db",
					"u474396146_aptra", "aptraDB");
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
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://185.28.20.242:3306/u474396146_db",
					"u474396146_aptra", "aptraDB");
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
			dbConnection = DriverManager.getConnection(
					"jdbc:mysql://185.28.20.242:3306/u474396146_db",
					"u474396146_aptra", "aptraDB");
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
			System.out
					.println("insert problems - Datenbank - insert meeting data"
							+ e.getMessage());
		}
	}
	
	
}
