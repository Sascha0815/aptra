package git_aptra.EditMeeting;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

import git_aptra.Login.Login;
//Liest die benötigten Daten aus
public class EditMeeting {
	private static String DataSetTypeMeeting;
	private static String DataSetLocation;
	private static Date DataSetDate;
	private static Time DataSetTime;
	private static int meetingID;
	
	public static void getSelectedRow(int id){
		meetingID = id;
		try {
			Connection con =  Login.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT typeMeeting, location, date, time FROM meeting WHERE meetingID = " +id);

			while (rs.next()) {
				DataSetTypeMeeting = rs.getString(1);
				DataSetLocation = rs.getString(2);
				DataSetDate = rs.getDate(3);
				DataSetTime = rs.getTime(4);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static String getDataTypeMeeting() {
		return DataSetTypeMeeting;
	}
	
	public static String getDataLocation() {
		return DataSetLocation;
	}
	
	public static Date getDataDate() {
		return DataSetDate;
	}
	
	public static Time getDataTime() {
		return DataSetTime;
	}
	public static int getMeetingID() {
		return meetingID;
	}
	
}
