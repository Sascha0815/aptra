package git_aptra.Meeting;

import git_aptra.Login.Login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class InsertMeetingDataIntoTable {
	@SuppressWarnings({ "rawtypes", })
	public static Vector resultsMeeting = new Vector();
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Vector insertMeetingDataIntoTable() {
		int entitlement = Login.getEntitlement();
		if(entitlement==1){
		try {
			Connection con =  Login.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT m.position, m.area, m.meetingID, m.applicantID, m.name, m.firstName, m.typeMeeting, m.location, m.date,  m.time, e.firstName, e.name from meeting m inner join participation p on p.meetingID = m.MeetingID inner join employee e on e.employeeID = p.employeeID");

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
				meeting.add(rs.getString(11)+" "+rs.getString(12));
				resultsMeeting.add(meeting);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}

		if(entitlement==2){
			try {
				Connection con = Login.getConnection();
				Statement stmt = con.createStatement();
				String query = ("SELECT m.position, m.area, m.meetingID, m.applicantID, m.name, m.firstName, m.typeMeeting, m.location, m.date,  m.time, e.firstName, e.name from meeting m inner join participation p on p.meetingID = m.MeetingID inner join employee e on e.employeeID = p.employeeID where p.employeeID = " + Login.getID());

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
					meeting.add(rs.getString(11)+" "+rs.getString(12));
					resultsMeeting.add(meeting);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultsMeeting;
	}	
}
