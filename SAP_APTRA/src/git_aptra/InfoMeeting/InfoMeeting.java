package git_aptra.InfoMeeting;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import git_aptra.Login.Login;

public class InfoMeeting {
	private static String dataSetPosition;
	private static String dataSetArea;
	private static String dataSetMeetingID;
	private static String dataSetApplicantID;
	private static String dataSetName;
	private static String dataSetFirstName;
	private static String dataSetTypeMeeting;
	private static String dataSetLocation;
	private static String dataSetDate;
	private static String dataSetTime;
	
	public static void getMeetingInfo(int id){
		try {
			Connection con =  Login.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT position, area, meetingID, applicantID, name, firstName, typeMeeting, location, date, time FROM meeting WHERE meetingID = " + id);

			while (rs.next()) {
				dataSetPosition = rs.getString(1);
				dataSetArea = rs.getString(2);
				dataSetMeetingID = rs.getString(3);
				dataSetApplicantID = rs.getString(4);
				dataSetName = rs.getString(5);
				dataSetFirstName = rs.getString(6);
				dataSetTypeMeeting = rs.getString(7);
				dataSetLocation = rs.getString(8);
				dataSetDate = rs.getString(9);
				dataSetTime = rs.getString(10);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public static String getDataSetApplicantID() {
		return dataSetApplicantID;
	}
	
	public static String getDataSetName() {
		return dataSetName;
	}

	public static String getDataSetFirstName() {
		return dataSetFirstName;
	}

	public static String getDataSetPosition() {
		return dataSetPosition;
	}

	public static String getDataSetArea() {
		return dataSetArea;
	}

	public static String getDataSetMeetingID() {
		return dataSetMeetingID;
	}

	public static String getDataSetTypeMeeting() {
		return dataSetTypeMeeting;
	}

	public static String getDataSetDate() {
		return dataSetDate;
	}

	public static String getDataSetTime() {
		return dataSetTime;
	}	
	
	public static String getDataSetLocation() {
		return dataSetLocation;
	}	
}
