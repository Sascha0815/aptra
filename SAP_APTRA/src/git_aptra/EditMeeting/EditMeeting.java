package git_aptra.EditMeeting;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

import git_aptra.Login.Login;
import git_aptra.MenuBar.MenuBarPanelMeeting;

public class EditMeeting {
	private static String DataSetVacancyID;
	private static String DataSetPosition;
	private static String DataSetArea;
	private static String DataSetTypeMeeting;
	private static String DataSetLocation;
	private static Date DataSetDate;
	private static Time DataSetTime;
	
	public static void getSelectedRow(){
		DialogEditMeetingGeneral.labelApplicantIDContent.setText((String) MenuBarPanelMeeting.tableEmployeeMeeting.getValueAt(MenuBarPanelMeeting.tableEmployeeMeeting.getSelectedRow(), 3));
		DialogEditMeetingGeneral.labelNameContent.setText((String) MenuBarPanelMeeting.tableEmployeeMeeting.getValueAt(MenuBarPanelMeeting.tableEmployeeMeeting.getSelectedRow(), 4));
		DialogEditMeetingGeneral.labelFirstNameContent.setText((String) MenuBarPanelMeeting.tableEmployeeMeeting.getValueAt(MenuBarPanelMeeting.tableEmployeeMeeting.getSelectedRow(), 5));
		
		try {
			Connection con =  Login.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT a.vacancyID, m.position, m.area, m.typeMeeting, m.location, m.date, m.time FROM meeting m INNER JOIN applicant a ON a.applicantID = m.applicantID  WHERE m.applicantID =" + (String) MenuBarPanelMeeting.tableEmployeeMeeting.getValueAt(MenuBarPanelMeeting.tableEmployeeMeeting.getSelectedRow(), 3));

			while (rs.next()) {
				DataSetVacancyID = rs.getString(1);
				DataSetPosition = rs.getString(2);
				DataSetArea = rs.getString(3);
				DataSetTypeMeeting = rs.getString(4);
				DataSetLocation = rs.getString(5);
				DataSetDate = rs.getDate(6);
				DataSetTime = rs.getTime(7);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		DialogEditMeetingGeneral.labelVacancyIDContent.setText(DataSetVacancyID);
		DialogEditMeetingGeneral.labelPositionContent.setText(DataSetPosition);
	}
	
	public static String getDataSetVacancyID() {
		return DataSetVacancyID;
	}
	
	public static String getDataSetPosition() {
		return DataSetPosition;
	}
	
	public static String getDataSetArea() {
		return DataSetArea;
	}
	
	public static String getDataSetTypeMeeting() {
		return DataSetTypeMeeting;
	}
	
	public static String getDataSetLocation() {
		return DataSetLocation;
	}
	
	public static Date getDataSetDate() {
		return DataSetDate;
	}
	
	public static Time getDataSetTime() {
		return DataSetTime;
	}
}
