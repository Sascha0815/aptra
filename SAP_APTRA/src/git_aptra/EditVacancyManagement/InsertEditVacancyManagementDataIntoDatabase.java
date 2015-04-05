package git_aptra.EditVacancyManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertEditVacancyManagementDataIntoDatabase {
	public static void insertEditVacancyManagementData() throws SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String query = "INSERT INTO notes"
				+ "(applicantID, date, note, employee) VALUES"
				+ "(?,?,?,?)";

		try {
			dbConnection = DriverManager.getConnection(
					"jdbc:mysql://185.28.20.242:3306/u474396146_db",
					"u474396146_aptra", "aptraDB");
			preparedStatement = dbConnection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.valueOf(EditVacancyManagement.getDataSetApplicantID()));
			preparedStatement.setDate(2, new java.sql.Date(
					DialogEditVacancyManagementGeneral.getCalNote().getTimeInMillis()));
			preparedStatement.setString(3, DialogEditVacancyManagementGeneral.getNote());
			preparedStatement.setString(4, DialogEditVacancyManagementGeneral.getEmployee());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out
					.println("insert problems - Datenbank - insert edit vacancy management data"
							+ e.getMessage());
		}
	}
}
