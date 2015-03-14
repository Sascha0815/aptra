package git_aptra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*public class InsertVacancyData {
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
			preparedStatement.setString(1, Steuerung.getSteuerung().getArea());
			preparedStatement.setString(2, Steuerung.getSteuerung()
					.getPosition());
			preparedStatement.setString(3, Steuerung.getSteuerung().getLevel());
			preparedStatement.setString(4, Steuerung.getSteuerung()
					.getDateVacancy());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Datenbank - insert VacancyData"
					+ e.getMessage());
		}
	}*/


