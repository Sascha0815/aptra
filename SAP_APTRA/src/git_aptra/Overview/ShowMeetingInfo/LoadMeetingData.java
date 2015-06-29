package git_aptra.Overview.ShowMeetingInfo;

import git_aptra.Login.Login;
import git_aptra.Overview.EditMeeting.DialogOverviewEditMeetingData;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

//Suchfunktion Übersicht Termin anzeigen
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
		if (!(DialogOverviewEditMeetingData.getMeetingID().equals(""))) {
			if (first == true) {
				meetingID = "where meetingID = '"
						+ DialogOverviewEditMeetingData.getMeetingID() + "'";
				first = false;
			} else {
				meetingID = " AND meetingID = '"
						+ DialogOverviewEditMeetingData.getMeetingID() + "'";
			}
		} else {
			meetingID = "";
		}
		
		if (!DialogOverviewEditMeetingData.getTypeMeeting().equals("")) {
			if (first == true) {
				typeMeeting = "where typeMeeting = '"
						+ DialogOverviewEditMeetingData.getTypeMeeting() + "'";
				first = false;
			} else {
				typeMeeting = " AND typeMeeting = '"
						+ DialogOverviewEditMeetingData.getTypeMeeting() + "'";
			}
		} else {
			typeMeeting = "";
		}

		if (!DialogOverviewEditMeetingData.getLocation().equals("")) {
			if (first == true) {
				location = "where location = '"
						+ DialogOverviewEditMeetingData.getLocation() + "'";
				first = false;
			} else {
				location = " AND location = '"
						+ DialogOverviewEditMeetingData.getLocation() + "'";
			}
		} else {
			location = "";
		}
	
		if (!DialogOverviewEditMeetingData.getTime().equals("")) {
			if (first == true) {
				time = "where time = '"
						+ DialogOverviewEditMeetingData.getTime() + "'";
				first = false;
			} else {
				time = " AND time = '"
						+ DialogOverviewEditMeetingData.getTime() + "'";
			}
		} else {
			time = "";
		}
		if (!DialogOverviewEditMeetingData.getDate().equals("")) {
			if (first == true) {
				date = "where date = '"
						+ DialogOverviewEditMeetingData.getDate() + "'";
				first = false;
			} else {
				date = " AND date = '"
						+ DialogOverviewEditMeetingData.getDate() + "'";
			}
		} else {
			date = "";
		}
		
		if (!DialogOverviewEditMeetingData.getFirstName().equals("")) {
			if (first == true) {
				firstName = "where firstName = '"
						+ DialogOverviewEditMeetingData.getFirstName() + "'";
				first = false;
			} else {
				firstName = " AND firstName = '"
						+ DialogOverviewEditMeetingData.getFirstName() + "'";
			}
		} else {
			firstName = "";
		}
	
		if (!DialogOverviewEditMeetingData.getName().equals("")) {
			if (first == true) {
				name = "where name = '"
						+ DialogOverviewEditMeetingData.getName() + "'";
				first = false;
			} else {
				name = " AND name = '"
						+ DialogOverviewEditMeetingData.getName() + "'";
			}
		} else {
			name = "";
		}
		if (!DialogOverviewEditMeetingData.getVacancyID().equals("")) {
			if (first == true) {
				vacancyID = "where vacancyID = '"
						+ DialogOverviewEditMeetingData.getVacancyID() + "'";
				first = false;
			} else {
				vacancyID = " AND vacancyID = '"
						+ DialogOverviewEditMeetingData.getVacancyID() + "'";
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
