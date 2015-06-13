package git_aptra.EditMeeting;

import git_aptra.Login.Login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class LoadEditApplicantData {
	
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
		if (!(DialogLoadEditApplicantData.getApplicantID().equals(""))) {
			if (first == true) {
				applicantID = "where applicantID = '"
						+ DialogLoadEditApplicantData.getApplicantID() + "'";
				first = false;
			} else {
				applicantID = " AND applicantID = '"
						+ DialogLoadEditApplicantData.getApplicantID() + "'";
			}
		} else {
			applicantID = "";
		}
		
		if (!DialogLoadEditApplicantData.getName().equals("")) {
			if (first == true) {
				name = "where name = '"
						+ DialogLoadEditApplicantData.getName() + "'";
				first = false;
			} else {
				name = " AND name = '"
						+ DialogLoadEditApplicantData.getName() + "'";
			}
		} else {
			name = "";
		}

		if (!DialogLoadEditApplicantData.getFirstName().equals("")) {
			if (first == true) {
				firstName = "where firstName = '"
						+ DialogLoadEditApplicantData.getFirstName() + "'";
				first = false;
			} else {
				firstName = " AND firstName = '"
						+ DialogLoadEditApplicantData.getFirstName() + "'";
			}
		} else {
			firstName = "";
		}
		
		if (!DialogLoadEditApplicantData.getVacancyID().equals("")) {
			if (first == true) {
				vacancyID = "where vacancyID = '"
						+ DialogLoadEditApplicantData.getVacancyID() + "'";
				first = false;
			} else {
				vacancyID = " AND vacancyID = '"
						+ DialogLoadEditApplicantData.getVacancyID() + "'";
			}
		} else {
			vacancyID = "";
		}
		
		if (!DialogLoadEditApplicantData.getPosition().equals("")) {
			if (first == true) {
				vacancy = "where vacancy = '"
						+ DialogLoadEditApplicantData.getPosition() + "'";
				first = false;
			} else {
				vacancy = " AND vacancy = '"
						+ DialogLoadEditApplicantData.getPosition() + "'";
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
