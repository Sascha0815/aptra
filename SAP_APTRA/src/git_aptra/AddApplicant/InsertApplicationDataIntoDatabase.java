package git_aptra.AddApplicant;

import git_aptra.Login.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class InsertApplicationDataIntoDatabase {
	private static int id = 0;
	public static void insertApplicantData() throws SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		String maxid = null;
		

		String query = "INSERT INTO applicant"
				+ "(name, firstName, street, houseNr, postalCode, city, sex, telefonHome, telefonMobil, email, vacancy, date, educationalAchievement, applyDate, vacancyID) VALUES"
				+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			dbConnection = Login.getConnection();
			preparedStatement = dbConnection.prepareStatement(query);
			preparedStatement.setString(1, DialogAddApplicantGeneral.getName());
			preparedStatement.setString(2,DialogAddApplicantGeneral.getFirstName());
			preparedStatement.setString(3,DialogAddApplicantGeneral.getStreet());
			preparedStatement.setInt(4, DialogAddApplicantGeneral.getHouseNr());
			preparedStatement.setInt(5,DialogAddApplicantGeneral.getPostalCode());
			preparedStatement.setString(6, DialogAddApplicantGeneral.getCity());
			preparedStatement.setString(7,DialogAddApplicantGeneral.getSex());
			preparedStatement.setString(8,DialogAddApplicantContact.getTelefonHome());
			preparedStatement.setString(9,DialogAddApplicantContact.getTelefonMobil());
			preparedStatement.setString(10, DialogAddApplicantContact.getEmail());
			preparedStatement.setString(11,DialogAddApplicantApplication.getVacancy());
			preparedStatement.setDate(12, new java.sql.Date(DialogAddApplicantContact.getCal().getTimeInMillis()));
			preparedStatement.setString(13,DialogAddApplicantApplication.getEducationalAchievement());
			preparedStatement.setDate(14, new java.sql.Date(DialogAddApplicantApplication.getCalApply().getTimeInMillis()));
			preparedStatement.setInt(15, DialogAddApplicantApplication.getVacancyID());
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
		}
		
		try {
			Connection con =  Login.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT MAX(applicantID) AS max FROM applicant");

			while (rs.next()) {
			    String em = rs.getString("max");
			    maxid = em.replace("\n", ",");
			    id = Integer.parseInt(maxid);
			}
		} catch (SQLException e) {
		}

		if (DialogAddApplicantApplication.getVacancyID()!=0) {
			query = "INSERT INTO relationship"			
					+ "(applicantID, vacancyID, status, dateApplication, latestNoteType, latestDate) VALUES"
					+ "(?,?,?,?,?,?)";			
			try {
				dbConnection = Login.getConnection();
				preparedStatement = dbConnection.prepareStatement(query);
				preparedStatement.setInt(1, id);
				preparedStatement.setInt(2, DialogAddApplicantApplication.getVacancyID());
				preparedStatement.setString(3, "offen");
				preparedStatement.setDate(4, new java.sql.Date(DialogAddApplicantApplication.getCalApply().getTimeInMillis()));
				preparedStatement.setString(5, "Bewerbungseingang");
				preparedStatement.setDate(6, new java.sql.Date(DialogAddApplicantApplication.getCalApply().getTimeInMillis()));
				preparedStatement.executeUpdate();
			} catch (Exception e) {
			}
		}
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void saveDataRating(){	
		Vector eid = new Vector();
		Vector weighting = new Vector(); 
		Vector notation = new Vector();
		try {
			Connection con =  Login.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT evaluationID, weighting, notation from vacancyevaluation");
			while (rs.next()) {			  
			   eid.add(rs.getInt(1));
			   weighting.add(rs.getInt(2));
			   notation.add(rs.getString(3));
			}
		} catch (SQLException e) {
			System.out.println("Fehler auslesen der Kriterien" + e.getMessage());
		}
		
		for (int i = 0; i < eid.size(); i++) {
			Connection dbConnection = null;
			PreparedStatement preparedStatement = null;
			String query = "INSERT INTO rating"
					+ "(vacancyID, evaluationID, applicantID, weighting, notation) VALUES"
					+ "(?,?,?,?,?)";
			try {
				dbConnection = Login.getConnection();
				preparedStatement = dbConnection.prepareStatement(query);
				preparedStatement.setInt(1, DialogAddApplicantApplication.getVacancyID());
				preparedStatement.setInt(2, (int) eid.elementAt(i));
				preparedStatement.setInt(3, id);
				preparedStatement.setInt(4, (int) weighting.elementAt(i));
				preparedStatement.setString(5, (String) notation.elementAt(i));				
				preparedStatement.executeUpdate();
				
			} catch (SQLException e) {
			}
		}
		
	}
	
}
