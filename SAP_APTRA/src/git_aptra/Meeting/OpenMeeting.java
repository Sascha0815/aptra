package git_aptra.Meeting;

import git_aptra.MenuBar.MenuBarPanelMeeting;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OpenMeeting {
	private static String date;
	private static String location;
	private static String time;

	public static void insertInfo(){
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://185.28.20.242:3306/u474396146_db",
					"u474396146_aptra", "aptraDB");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select date, location, time FROM meeting");

			while (rs.next()) {
				date = rs.getString(1);
				location = rs.getString(2);
				time = rs.getString(3);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String count = Integer.toString(MenuBarPanelMeeting.tableEmployeeMeeting.getRowCount());
		MenuBarPanelMeeting.labelMeetingCountContent.setText(count);
		MenuBarPanelMeeting.labelMeetingNextDateContent.setText(date);
		MenuBarPanelMeeting.labelMeetingNextTimeContent.setText(time);
		MenuBarPanelMeeting.labelMeetingLocationContent.setText(location);	
	}
		
}
