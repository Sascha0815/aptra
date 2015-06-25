package git_aptra.Overview.ShowMeetingInfo;

import git_aptra.Login.Login;
import git_aptra.Overview.EditMeeting.DialogOverviewEditMeetingData;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class LoadMeetingData {
	
	private static String meetingID;
	private static String typeMeeting;
	private static String location;
	private static String time;
	private static String date;
	private static String firstName;
	private static String name;
	private static String vacancyID;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Vector loadMeetingData() throws SQLException {
		Connection dbConnection = null;
		boolean first = true;
		Vector resultsLoadMeetingData = new Vector();
		if (!(DialogLoadMeetingData.getMeetingID().equals(""))) {
			if (first == true) {
				meetingID = "where meetingID = '"
						+ DialogLoadMeetingData.getMeetingID() + "'";
				first = false;
			} else {
				meetingID = " AND meetingID = '"
						+ DialogLoadMeetingData.getMeetingID() + "'";
			}
		} else {
			meetingID = "";
		}
		
		if (!DialogLoadMeetingData.getTypeMeeting().equals("")) {
			if (first == true) {
				typeMeeting = "where typeMeeting = '"
						+ DialogLoadMeetingData.getTypeMeeting() + "'";
				first = false;
			} else {
				typeMeeting = " AND typeMeeting = '"
						+ DialogLoadMeetingData.getTypeMeeting() + "'";
			}
		} else {
			typeMeeting = "";
		}

		if (!DialogLoadMeetingData.getLocation().equals("")) {
			if (first == true) {
				location = "where location = '"
						+ DialogLoadMeetingData.getLocation() + "'";
				first = false;
			} else {
				location = " AND location = '"
						+ DialogLoadMeetingData.getLocation() + "'";
			}
		} else {
			location = "";
		}
	
		if (!DialogLoadMeetingData.getTime().equals("")) {
			if (first == true) {
				time = "where time = '"
						+ DialogLoadMeetingData.getTime() + "'";
				first = false;
			} else {
				time = " AND time = '"
						+ DialogLoadMeetingData.getTime() + "'";
			}
		} else {
			time = "";
		}
		if (!DialogLoadMeetingData.getDate().equals("")) {
			if (first == true) {
				date = "where date = '"
						+ DialogLoadMeetingData.getDate() + "'";
				first = false;
			} else {
				date = " AND date = '"
						+ DialogLoadMeetingData.getDate() + "'";
			}
		} else {
			date = "";
		}
		
		if (!DialogLoadMeetingData.getFirstName().equals("")) {
			if (first == true) {
				firstName = "where firstName = '"
						+ DialogLoadMeetingData.getFirstName() + "'";
				first = false;
			} else {
				firstName = " AND firstName = '"
						+ DialogLoadMeetingData.getFirstName() + "'";
			}
		} else {
			firstName = "";
		}
	
		if (!DialogLoadMeetingData.getName().equals("")) {
			if (first == true) {
				name = "where name = '"
						+ DialogLoadMeetingData.getName() + "'";
				first = false;
			} else {
				name = " AND name = '"
						+ DialogLoadMeetingData.getName() + "'";
			}
		} else {
			name = "";
		}
		if (!DialogLoadMeetingData.getVacancyID().equals("")) {
			if (first == true) {
				vacancyID = "where vacancyID = '"
						+ DialogLoadMeetingData.getVacancyID() + "'";
				first = false;
			} else {
				vacancyID = " AND vacancyID = '"
						+ DialogLoadMeetingData.getVacancyID() + "'";
			}
		} else {
			vacancyID = "";
		}
		
		try {
			dbConnection = Login.getConnection();

			Statement stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from meeting " + meetingID + typeMeeting
					+ location + time + date + firstName + name + vacancyID);
		
			while (rs.next()) {
				Vector meeting = new Vector();
				meeting.add(rs.getString(3));
				meeting.add(rs.getString(7));
				meeting.add(rs.getString(8));
				meeting.add(rs.getString(10));
				meeting.add(rs.getString(9));
				meeting.add(rs.getString(6));
				meeting.add(rs.getString(5));
				meeting.add(rs.getString(11));
				resultsLoadMeetingData.add(meeting);
			}

		} catch (SQLException e) {
			System.out.println("Datenbank - loadVacancyData" + e.getMessage());
		}
		return resultsLoadMeetingData;	
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Vector insertLoadMeetingDataIntoTable(){
		Vector resultsLoadMeetingDataAll = new Vector();
		try {
			Connection dbConnection = null;
			dbConnection = Login.getConnection();
			
			Statement stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from meeting");
		
			while (rs.next()) {
				Vector meeting = new Vector();
				meeting.add(rs.getString(3));
				meeting.add(rs.getString(7));
				meeting.add(rs.getString(8));
				meeting.add(rs.getString(10));
				meeting.add(rs.getString(9));
				meeting.add(rs.getString(6));
				meeting.add(rs.getString(5));
				meeting.add(rs.getString(11));
				resultsLoadMeetingDataAll.add(meeting);
			}

		} catch (SQLException e) {
			System.out.println("Datenbank - loadvacancyDataAll" + e.getMessage());
		}
		return resultsLoadMeetingDataAll;
	}
}
