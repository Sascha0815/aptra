package git_aptra.Meeting;

import git_aptra.Login.Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class InsertMeetingDataIntoTable {
	private static String employeeName;
	private static String employeeFirstName;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Vector insertMeetingDataIntoTable() {
		Vector resultsMeeting = new Vector();
		if(Login.getEntitlement()==1){
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://185.28.20.242:3306/u474396146_db",
					"u474396146_aptra", "aptraDB");
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
				meeting.add(rs.getString(12)+" "+rs.getString(11));
				resultsMeeting.add(meeting);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if(Login.getEntitlement()==2){
			try {
				Connection con = DriverManager.getConnection(
						"jdbc:mysql://185.28.20.242:3306/u474396146_db",
						"u474396146_aptra", "aptraDB");
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT DISTINCT e.name, e.firstName FROM meeting m INNER JOIN"
						+ "participation p ON m.meetingID = p.meetingID INNER JOIN employee e on e.employeeID = p.employeeID WHERE e.employeeID =" + Login.getID()  );
				while (rs.next()) {
					employeeName = rs.getString(1);
					employeeFirstName = rs.getString(2);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}	
			}
			try {
				Connection con = DriverManager.getConnection(
						"jdbc:mysql://185.28.20.242:3306/u474396146_db",
						"u474396146_aptra", "aptraDB");
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM meeting WHERE responsibleEmployeeName = " + employeeName + "AND responsibleEmployeeFirstName = " + employeeFirstName);

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
					meeting.add(rs.getString(12)+" "+rs.getString(11));
					resultsMeeting.add(meeting);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultsMeeting;
	}	
}
