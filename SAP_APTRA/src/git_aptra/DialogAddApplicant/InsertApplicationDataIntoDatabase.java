package git_aptra.DialogAddApplicant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertApplicationDataIntoDatabase {
	public static void insertApplicantData() throws SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String insertTableSQL = "INSERT INTO applicant"
				+ "(name, firstName, street, houseNr, postalCode, city, telefonHome, telefonMobil, email, vacancy, date, educationalAchievement) VALUES"
				+ "(?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			dbConnection = DriverManager.getConnection(
					"jdbc:mysql://185.28.20.242:3306/u474396146_db",
					"u474396146_aptra", "aptraDB");
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, DialogAddApplicantGeneral.getName());
			preparedStatement.setString(2,
					DialogAddApplicantGeneral.getFirstName());
			preparedStatement.setString(3,
					DialogAddApplicantGeneral.getStreet());
			preparedStatement.setInt(4, DialogAddApplicantGeneral.getHouseNr());
			preparedStatement.setInt(5,
					DialogAddApplicantGeneral.getPostalCode());
			preparedStatement.setString(6, DialogAddApplicantGeneral.getCity());
			preparedStatement.setString(7,
					DialogAddApplicantContact.getTelefonHome());
			preparedStatement.setString(8,
					DialogAddApplicantContact.getTelefonMobil());
			preparedStatement
					.setString(9, DialogAddApplicantContact.getEmail());
			preparedStatement.setString(10,
					DialogAddApplicantApplication.getVacancy());
			preparedStatement.setDate(11, new java.sql.Date(
					DialogAddApplicantApplication.getCal().getTimeInMillis()));
			preparedStatement.setString(12,
					DialogAddApplicantApplication.getEducationalAchievement());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out
					.println("insert problems - Datenbank - insert Applicant data"
							+ e.getMessage());
		}
	}
}
