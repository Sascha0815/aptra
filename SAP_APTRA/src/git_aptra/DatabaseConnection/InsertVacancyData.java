package git_aptra.DatabaseConnection;

import git_aptra.DialogAddVacancy.DialogAddVacancyGeneral;
import git_aptra.DialogAddVacancy.DialogAddVacancySpecification;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertVacancyData {
	public static void insertVacancyData() throws SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String insertTableSQL = "INSERT INTO vacancy"
				+ "(position, area, requirementLevel, termsOfEmployment, vacancyStatus, educationalAchievement, level, date) VALUES"
				+ "(?,?,?,?,?,?,?,?)";

		try {
			dbConnection = DriverManager.getConnection(
					"jdbc:mysql://185.28.20.242:3306/u474396146_db",
					"u474396146_aptra", "aptraDB");
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);
			preparedStatement.setString(1,
					DialogAddVacancyGeneral.getPosition());
			preparedStatement.setString(2, DialogAddVacancyGeneral.getArea());
			preparedStatement.setString(3,
					DialogAddVacancyGeneral.getRequirementLevel());
			preparedStatement.setString(4,
					DialogAddVacancyGeneral.getTermsOfEmployment());
			preparedStatement.setString(5,
					DialogAddVacancyGeneral.getVacancyStatus());
			preparedStatement.setString(6,
					DialogAddVacancyGeneral.getEducationalAchievementVacancy());
			preparedStatement.setString(7,
					DialogAddVacancySpecification.getLevel());
			preparedStatement.setDate(8, new java.sql.Date(
					DialogAddVacancySpecification.getCalVacancy()
							.getTimeInMillis()));
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Datenbank - insert VacancyData"
					+ e.getMessage());
		}
	}
}
