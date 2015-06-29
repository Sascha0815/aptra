package git_aptra.EditVacancy;

import git_aptra.Login.Login;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//Speichert die Änderungen
public class EditVacancyData {

	public static void editVacancyData() throws SQLException {
		Connection dbConnection = null;
		int id = EditVacancy.getVacancyID();
		dbConnection = Login.getConnection();
		try {
			PreparedStatement preparedStatement = dbConnection.prepareStatement("UPDATE vacancy SET position = ?, area = ?, "
							+ "requirementLevel = ?, termsOfEmployment = ?,  "
							+ "vacancyStatus= ?, educationalAchievement = ?, "
							+ "note = ?, date = ?, divisionID = ? WHERE vacancyID = ?");
			preparedStatement.setString(1, DialogEditVacancyGeneral.getPosition());
			preparedStatement.setString(2, DialogEditVacancyGeneral.getArea());
			preparedStatement.setString(3, DialogEditVacancyGeneral.getRequirementLevel());
			preparedStatement.setString(4, DialogEditVacancyGeneral.getTermsOfEmployment());
			preparedStatement.setString(5, DialogEditVacancyGeneral.getVacancyStatus());
			preparedStatement.setString(6, DialogEditVacancyGeneral.getEducationalAchievementVacancy());
			preparedStatement.setString(7, DialogEditVacancySpecification.getLevel());
			preparedStatement.setDate(8, new java.sql.Date(DialogEditVacancySpecification.getCalVacancy().getTimeInMillis()));
			preparedStatement.setInt(9, DialogEditVacancySpecification.getDivisionID());
			preparedStatement.setInt(10, id);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
