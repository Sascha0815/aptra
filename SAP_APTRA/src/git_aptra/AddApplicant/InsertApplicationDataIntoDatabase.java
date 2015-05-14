package git_aptra.AddApplicant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertApplicationDataIntoDatabase {
	public static void insertApplicantData() throws SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		String maxid = null;
		int id = 0;

		String query = "INSERT INTO applicant"
				+ "(name, firstName, street, houseNr, postalCode, city, sex, telefonHome, telefonMobil, email, vacancy, date, educationalAchievement, applyDate, vacancyID) VALUES"
				+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			dbConnection = DriverManager.getConnection(
					"jdbc:mysql://185.28.20.242:3306/u474396146_db",
					"u474396146_aptra", "aptraDB");
			preparedStatement = dbConnection.prepareStatement(query);
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
					DialogAddApplicantGeneral.getSex());
			preparedStatement.setString(8,
					DialogAddApplicantContact.getTelefonHome());
			preparedStatement.setString(9,
					DialogAddApplicantContact.getTelefonMobil());
			preparedStatement
					.setString(10, DialogAddApplicantContact.getEmail());
			preparedStatement.setString(11,
					DialogAddApplicantApplication.getVacancy());
			preparedStatement.setDate(12, new java.sql.Date(
					DialogAddApplicantContact.getCal().getTimeInMillis()));
			preparedStatement.setString(13,
					DialogAddApplicantApplication.getEducationalAchievement());
			preparedStatement.setDate(14, new java.sql.Date(
					DialogAddApplicantApplication.getCalApply().getTimeInMillis()));
			preparedStatement.setInt(15, DialogAddApplicantApplication.getVacancyID());
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			System.out
					.println("insert problems - Datenbank - insert Applicant data"
							+ e.getMessage());
		}
		
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://185.28.20.242:3306/u474396146_db",
					"u474396146_aptra", "aptraDB");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT MAX(applicantID) AS max FROM applicant");

			while (rs.next()) {
			    String em = rs.getString("max");
			    maxid = em.replace("\n", ",");
			    id = Integer.parseInt(maxid);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (DialogAddApplicantApplication.getVacancyID()!=0) {
			query = "INSERT INTO relationship"			
					+ "(applicantID, vacancyID, status, dateApplication, latestNoteType, latestDate) VALUES"
					+ "(?,?,?,?,?,?)";			
			try {
				dbConnection = DriverManager.getConnection(
						"jdbc:mysql://185.28.20.242:3306/u474396146_db",
						"u474396146_aptra", "aptraDB");
				preparedStatement = dbConnection.prepareStatement(query);
				preparedStatement.setInt(1, id);
				preparedStatement.setInt(2, DialogAddApplicantApplication.getVacancyID());
				preparedStatement.setString(3, "offen");
				preparedStatement.setDate(4, new java.sql.Date(
						DialogAddApplicantApplication.getCalApply().getTimeInMillis()));
				preparedStatement.setString(5, "Bewerbungseingang");
				preparedStatement.setDate(6, new java.sql.Date(
						DialogAddApplicantApplication.getCalApply().getTimeInMillis()));
				preparedStatement.executeUpdate();
			} catch (Exception e) {
				System.out
				.println("insert problems - Datenbank - insert relashionship data"
						+ e.getMessage());
			}
		}
	}
}
