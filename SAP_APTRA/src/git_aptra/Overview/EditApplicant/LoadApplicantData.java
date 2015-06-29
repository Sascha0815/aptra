package git_aptra.Overview.EditApplicant;

import git_aptra.Login.Login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

//Suchfunktion Übersicht Bewerber bearbeiten
public class LoadApplicantData {
	
	private static String applicantID;
	private static String name;
	private static String firstName;
	private static String vacancyID;
	private static String vacancy;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Vector loadApplicanData() throws SQLException {
		Connection dbConnection = null;
		boolean first = true;
		Vector resultsLoadApplicantData = new Vector();
		if (!(DialogLoadApplicantEditSelection.getApplicantID().equals(""))) {
			if (first == true) {
				applicantID = "where applicantID = '"
						+ DialogLoadApplicantEditSelection.getApplicantID() + "'";
				first = false;
			} else {
				applicantID = " AND applicantID = '"
						+ DialogLoadApplicantEditSelection.getApplicantID() + "'";
			}
		} else {
			applicantID = "";
		}
		
		if (!DialogLoadApplicantEditSelection.getName().equals("")) {
			if (first == true) {
				name = "where name = '"
						+ DialogLoadApplicantEditSelection.getName() + "'";
				first = false;
			} else {
				name = " AND name = '"
						+ DialogLoadApplicantEditSelection.getName() + "'";
			}
		} else {
			name = "";
		}

		if (!DialogLoadApplicantEditSelection.getFirstName().equals("")) {
			if (first == true) {
				firstName = "where firstName = '"
						+ DialogLoadApplicantEditSelection.getFirstName() + "'";
				first = false;
			} else {
				firstName = " AND firstName = '"
						+ DialogLoadApplicantEditSelection.getFirstName() + "'";
			}
		} else {
			firstName = "";
		}
		
		if (!DialogLoadApplicantEditSelection.getVacancyID().equals("")) {
			if (first == true) {
				vacancyID = "where vacancyID = '"
						+ DialogLoadApplicantEditSelection.getVacancyID() + "'";
				first = false;
			} else {
				vacancyID = " AND vacancyID = '"
						+ DialogLoadApplicantEditSelection.getVacancyID() + "'";
			}
		} else {
			vacancyID = "";
		}
		
		if (!DialogLoadApplicantEditSelection.getPosition().equals("")) {
			if (first == true) {
				vacancy = "where vacancy = '"
						+ DialogLoadApplicantEditSelection.getPosition() + "'";
				first = false;
			} else {
				vacancy = " AND vacancy = '"
						+ DialogLoadApplicantEditSelection.getPosition() + "'";
			}
		} else {
			vacancy = "";
		}
		
		
		try {
			dbConnection = Login.getConnection();

			Statement stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from applicant " + applicantID + name
					+ firstName + vacancyID + vacancy );
		
			while (rs.next()) {
				Vector applicant = new Vector();
				applicant.add(rs.getString(1));
				applicant.add(rs.getString(2));
				applicant.add(rs.getString(3));
				applicant.add(rs.getString(16));
				applicant.add(rs.getString(12));
				resultsLoadApplicantData.add(applicant);
			}

		} catch (SQLException e) {
			System.out.println("Datenbank - loadApplicantData" + e.getMessage());
		}
		return resultsLoadApplicantData;	
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Vector insertLoadApplicantDataIntoTable(){
		Vector resultsLoadApplicantDataAll = new Vector();
		try {
			Connection dbConnection = null;
			dbConnection = Login.getConnection();
			
			Statement stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from applicant");
		
			while (rs.next()) {
				Vector applicant = new Vector();
				applicant.add(rs.getString(1));
				applicant.add(rs.getString(2));
				applicant.add(rs.getString(3));
				applicant.add(rs.getString(16));
				applicant.add(rs.getString(12));
				resultsLoadApplicantDataAll.add(applicant);
			}

		} catch (SQLException e) {
			System.out.println("Datenbank - loadApplicantData" + e.getMessage());
		}
		return resultsLoadApplicantDataAll;
	}
	
}
