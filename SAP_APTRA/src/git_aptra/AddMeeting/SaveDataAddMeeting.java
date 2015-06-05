package git_aptra.AddMeeting;

import git_aptra.Login.Login;
import git_aptra.MenuBar.MenuBarPanelMeeting;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;


public class SaveDataAddMeeting {
	@SuppressWarnings({ "rawtypes"})
	private static Vector resultsMeeting = new Vector();
	static String area;
	static String vacancyID;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void save(){
		DialogLoadApplicantData.getApplicantData();
		DialogAddMeetingSpecification.getSpecification();
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		String query = "INSERT INTO meeting"
				+ "(position, area, applicantID, name, firstName, typeMeeting, location, date, time) VALUES"
				+ "(?,?,?,?,?,?,?,?,?)";
		try {
			Connection con =  Login.getConnection();
			Statement stmt =  con.createStatement();
		    ResultSet rs = stmt.executeQuery("SELECT  vacancyID from applicant where applicantID = " +  DialogAddMeetingGeneral.labelApplicantIDContent.getText() );
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
			preparedStatement.setString(1, DialogAddMeetingGeneral.labelPositionContent.getText());
			preparedStatement.setString(2, area);
			preparedStatement.setString(3, DialogAddMeetingGeneral.labelApplicantIDContent.getText());
			preparedStatement.setString(4, DialogAddMeetingGeneral.labelNameContent.getText());
			preparedStatement.setString(5, DialogAddMeetingGeneral.labelFirstNameContent.getText());
			preparedStatement.setString(6, DialogAddMeetingSpecification.getType());
			preparedStatement.setString(7, DialogAddMeetingSpecification.getLocation());
			preparedStatement.setDate(8, new java.sql.Date(DialogAddMeetingSpecification.getCal().getTimeInMillis()));
			preparedStatement.setString(9, DialogAddMeetingSpecification.getTime());
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("insert problems - Datenbank - insert meeting data"+ e.getMessage());
		}
		
		
		try {
			Connection con =  Login.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM meeting");

			while (rs.next()) {
				Vector meeting = new Vector();
				meeting.add(rs.getString(1));
				meeting.add(rs.getString(2));
				meeting.add(rs.getString(3));
				meeting.add(rs.getString(4));
				meeting.add(rs.getString(5));
				meeting.add(rs.getString(6));
				meeting.add(rs.getString(7));
				meeting.add(rs.getString(8));
				meeting.add(rs.getString(9));
				meeting.add(rs.getString(10));
				resultsMeeting.add(meeting);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		MenuBarPanelMeeting.modelEmployeeMeeting.setDataVector(resultsMeeting,MenuBarPanelMeeting.COLUMN_IDENTIFIERS_VACANCYMANAGEMENT);
		MenuBarPanelMeeting.modelEmployeeMeeting.fireTableDataChanged();
		DialogAddMeeting.dialogNewMeeting.dispose();
		}
				
}

