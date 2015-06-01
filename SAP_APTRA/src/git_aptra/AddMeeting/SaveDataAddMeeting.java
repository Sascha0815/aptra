package git_aptra.AddMeeting;

import git_aptra.AddApplicant.DialogAddApplicantApplication;
import git_aptra.Login.Login;
import git_aptra.Meeting.DialogDetailsMeeting;
import git_aptra.MenuBar.MenuBarPanelVacancyManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class SaveDataAddMeeting {
	public static void save(){
		DialogLoadApplicantData.getApplicantData();
		DialogAddMeetingSpecification.getSpecification();
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		String query = "INSERT INTO meeting"
				+ "(position, area, applicantID, name, firstName, typeMeeting, location, date, time, responsibleEmployeeName, responsibleEmployeeFirstName ) VALUES"
				+ "(?,?,?,?,?,?,?,?,?,?,?)";

		try {
			dbConnection = Login.getConnection();
			preparedStatement = dbConnection.prepareStatement(query);
			preparedStatement.setString(1, DialogAddMeetingGeneral.labelPositionContent.getText());
			preparedStatement.setString(2, DialogAddMeetingGeneral.labelPositionContent.getText());
			preparedStatement.setInt(3, MenuBarPanelVacancyManagement.getIDApplicant());
			preparedStatement.setString(4, DialogAddMeetingGeneral.labelNameContent.getText());
			preparedStatement.setString(5, DialogAddMeetingGeneral.labelFirstNameContent.getText());
			preparedStatement.setString(6, DialogAddMeetingSpecification.getType());
			preparedStatement.setString(7, DialogAddMeetingSpecification.getLocation());
			preparedStatement.setDate(8, new java.sql.Date(DialogAddMeetingSpecification.getCal().getTimeInMillis()));
			preparedStatement.setString(9, DialogAddMeetingSpecification.getTime());
			preparedStatement.setString(10, DialogAddMeetingSpecification.getResponsibleEmployeeName());
			preparedStatement.setString(11, DialogAddMeetingSpecification.getResponsibleEmployeeFirstName());
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			System.out
					.println("insert problems - Datenbank - insert meeting data"
							+ e.getMessage());
		}
	}
}
