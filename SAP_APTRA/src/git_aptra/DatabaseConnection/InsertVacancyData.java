package git_aptra.DatabaseConnection;

import git_aptra.DialogAddVacancy.DialogAddVacancyGeneral;
import git_aptra.DialogAddVacancy.DialogAddVacancySpecification;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertVacancyData {
	public void insertVacancyData() throws SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String insertTableSQL = "INSERT INTO vacancy"
				+ "(area, position, level, date) VALUES" + "(?,?,?,?)";

		try {
			dbConnection = DriverManager.getConnection(
					"jdbc:mysql://185.28.20.242:3306/u474396146_db",
					"u474396146_aptra", "aptraDB");
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, DialogAddVacancyGeneral.getArea());
			preparedStatement.setString(2,
					DialogAddVacancyGeneral.getPosition());
			preparedStatement.setString(3,
					DialogAddVacancySpecification.getLevel());
			preparedStatement.setString(4,
					DialogAddVacancySpecification.getDateVacancy());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Datenbank - insert VacancyData"
					+ e.getMessage());
		}
	}
}
