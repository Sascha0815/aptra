package git_aptra.SearchMeeting;

import git_aptra.Login.Login;
import git_aptra.SearchApplicant.DialogSearchApplicantGeneral;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class SearchMeeting {
	private static String applicantID;
	private static String firstName;
	private static String name;
	private static String vacancyID;
	private static String postition;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Vector search(){
		Connection dbConnection = null;
		Vector resultsSearchMeeting = new Vector();
		
		DialogSearchMeetingGeneral.getGeneral();
		DialogSearchMeetingSpecification.getSpecification();
		boolean first = true;

		if (!(DialogSearchMeetingGeneral.getApplicantID() == 0)) {
			if (first == true) {
				applicantID = "where m.applicantID = '"
						+ DialogSearchMeetingGeneral.getApplicantID() + "'";
				first = false;
			} else {
				applicantID = " AND m.applicantID = '"
						+ DialogSearchMeetingGeneral.getApplicantID() + "'";
			}
		} else {
			applicantID = "";
		}
		
		if (!(DialogSearchMeetingGeneral.getFirstName().equals(""))) {
			if (first == true) {
				firstName = "where m.firstName = '"
						+ DialogSearchMeetingGeneral.getFirstName() + "'";
				first = false;
			} else {
				firstName = " AND m.firstName = '"
						+ DialogSearchMeetingGeneral.getFirstName() + "'";
			}
		} else {
			firstName = "";
		}
		
		if (!(DialogSearchMeetingGeneral.getName().equals(""))) {
			if (first == true) {
				name = "where m.name = '"
						+ DialogSearchMeetingGeneral.getName() + "'";
				first = false;
			} else {
				name = " AND m.name = '"
						+ DialogSearchMeetingGeneral.getName() + "'";
			}
		} else {
			name = "";
		}
		
		if (!(DialogSearchMeetingGeneral.getVacancyID() == 0)) {
			if (first == true) {
				vacancyID = "where m.name = '"
						+ DialogSearchMeetingGeneral.getVacancyID() + "'";
				first = false;
			} else {
				name = " AND m.name = '"
						+ DialogSearchMeetingGeneral.getVacancyID() + "'";
			}
		} else {
			name = "";
		}
		
		
		
		
		try {
			String query;
			if (Login.getEntitlement()<3) {
				query = "SELECT m.position, m.area, m.meetingID, m.applicantID, m.name, m.firstName, m.typeMeeting, m.location, m.date,  m.time, e.firstName, e.name, e.employeeID from meeting m inner join participation p on p.meetingID = m.MeetingID inner join employee e on e.employeeID = p.employeeID inner join ";
			}
			else {
				query = "SELECT m.position, m.area, m.meetingID, m.applicantID, m.name, m.firstName, m.typeMeeting, m.location, m.date,  m.time, e.firstName, e.name from meeting m inner join participation p on p.meetingID = m.MeetingID inner join employee e on e.employeeID = p.employeeID where e.divisionID = " + Login.getDivisionID();
			}
			query = query + applicantID + name + firstName;
			System.out.println(query);
			dbConnection = Login.getConnection();
			Statement stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
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
				meeting.add(rs.getString(11));
				meeting.add(rs.getString(12));
				meeting.add(rs.getString(13));
				resultsSearchMeeting.add(meeting);
			}

		} catch (SQLException e) {
			System.out.println("Datenbank - search meeting " + e.getMessage());
		}
		DialogSearchMeeting.dialogSearchMeeting.dispose();
		return resultsSearchMeeting;
	}
}
