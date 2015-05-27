package git_aptra.EditVacancy;

import git_aptra.MenuBar.MenuBarPanelVacancy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EditVacancyData {

	public static void editVacancyData() throws SQLException {
		Connection dbConnection = null;
		int id = Integer.parseInt((String) MenuBarPanelVacancy.tableJob.getValueAt(MenuBarPanelVacancy.tableJob.getSelectedRow(),  0));

		try {
			dbConnection = DriverManager.getConnection("jdbc:mysql://185.28.20.242:3306/u474396146_db","u474396146_aptra", "aptraDB");
		} catch (SQLException e) {
		}
		try {
			PreparedStatement preparedStatement = dbConnection.prepareStatement("UPDATE vacancy SET position = ?, area = ?, "
							+ "requirementLevel = ?, termsOfEmployment = ?,  "
							+ "vacancyStatus= ?, educationalAchievement = ?, "
							+ "level = ?, date = ? WHERE vacancyID = ?");

			preparedStatement.setString(1,DialogEditVacancyGeneral.getPosition());
			preparedStatement.setString(2, DialogEditVacancyGeneral.getArea());
			preparedStatement.setString(3,DialogEditVacancyGeneral.getRequirementLevel());
			preparedStatement.setString(4,DialogEditVacancyGeneral.getTermsOfEmployment());
			preparedStatement.setString(5,DialogEditVacancyGeneral.getVacancyStatus());
			preparedStatement.setString(6, DialogEditVacancyGeneral.getEducationalAchievementVacancy());
			preparedStatement.setString(7,DialogEditVacancySpecification.getLevel());
			preparedStatement.setDate(8, new java.sql.Date(DialogEditVacancySpecification.getCalVacancy().getTimeInMillis()));
			preparedStatement.setInt(9, id);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
		}
	}
}
