package git_aptra.AddMeeting;

import git_aptra.Login.Login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class LoadApplicantData {
	
	private static String applicantID;
	private static String name;
	private static String firstName;
	private static String vacancyID;
	private static String vacancy;
	private static String division;
	@SuppressWarnings("rawtypes")
	private static Vector resultsLoadApplicantData = new Vector();

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Vector loadApplicanData() throws SQLException {
		Connection dbConnection = null;
		boolean first = true;

		if (!(DialogLoadApplicantData.getApplicantID().equals(""))) {
			if (first == true) {
				applicantID = "where applicantID = '"
						+ DialogLoadApplicantData.getApplicantID() + "'";
				first = false;
			} else {
				applicantID = " AND applicantID = '"
						+ DialogLoadApplicantData.getApplicantID() + "'";
			}
		} else {
			applicantID = "";
		}
		
		if (!DialogLoadApplicantData.getName().equals("")) {
			if (first == true) {
				name = "where name = '"
						+ DialogLoadApplicantData.getName() + "'";
				first = false;
			} else {
				name = " AND name = '"
						+ DialogLoadApplicantData.getName() + "'";
			}
		} else {
			name = "";
		}

		if (!DialogLoadApplicantData.getFirstName().equals("")) {
			if (first == true) {
				firstName = "where firstName = '"
						+ DialogLoadApplicantData.getFirstName() + "'";
				first = false;
			} else {
				firstName = " AND firstName = '"
						+ DialogLoadApplicantData.getFirstName() + "'";
			}
		} else {
			firstName = "";
		}
		
		if (!DialogLoadApplicantData.getVacancyID().equals("")) {
			if (first == true) {
				vacancyID = "where vacancyID = '"
						+ DialogLoadApplicantData.getVacancyID() + "'";
				first = false;
			} else {
				vacancyID = " AND vacancyID = '"
						+ DialogLoadApplicantData.getVacancyID() + "'";
			}
		} else {
			vacancyID = "";
		}
		
		if (!DialogLoadApplicantData.getPosition().equals("")) {
			if (first == true) {
				vacancy = "where vacancy = '"
						+ DialogLoadApplicantData.getPosition() + "'";
				first = false;
			} else {
				vacancy = " AND vacancy = '"
						+ DialogLoadApplicantData.getPosition() + "'";
			}
		} else {
			vacancy = "";
		}
		
		if (!DialogLoadApplicantData.getDivision().equals("")) {
			if (first == true) {
				division = "where division = '"
						+ DialogLoadApplicantData.getDivision() + "'";
				first = false;
			} else {
				division = " AND division = '"
						+ DialogLoadApplicantData.getDivision() + "'";
			}
		} else {
			division = "";
		}
		
		try {
			dbConnection = Login.getConnection();

			Statement stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from applicant " + applicantID + name
					+ firstName + vacancyID + vacancy + division);
			
			System.out.println("select * from applicant " + applicantID + name
					+ firstName + vacancyID + vacancy + division);
			
			while (rs.next()) {
				Vector applicant = new Vector();
				applicant.add(rs.getString(1));
				applicant.add(rs.getString(2));
				applicant.add(rs.getString(3));
				applicant.add(rs.getString(4));
				applicant.add(rs.getString(5));
				applicant.add(rs.getString(6));
				resultsLoadApplicantData.add(applicant);
			}

		} catch (SQLException e) {
			System.out.println("Datenbank - loadApplicantData" + e.getMessage());
		}
		return resultsLoadApplicantData;	
	}
	
	@SuppressWarnings("rawtypes")
	public static Vector getResultsLoadApplicantData(){
		return resultsLoadApplicantData;
	}
}
