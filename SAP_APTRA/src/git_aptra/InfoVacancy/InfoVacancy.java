package git_aptra.InfoVacancy;

import git_aptra.Login.Login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class InfoVacancy {
	private static String dataSetVacancyID;
	private static String dataSetPosition;
	private static String dataSetArea;
	private static String dataSetRequirementLevel;
	private static String dataSetTermsOfEmployment;
	private static String dataSetVacancyStatus;
	private static String dataSetEducationalAchievement;
	private static String dataSetNote;
	private static String dataSetDate;

	public static void getVacancyInfo(int id){
		try {
			Connection con =  Login.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT vacancyID, position, area, requirementLevel, termsOfEmployment, vacancyStatus, educationalAchievement, note, date, divisionID FROM vacancy WHERE vacancyID = " + id);

			while (rs.next()) {
				dataSetVacancyID = rs.getString(1);
				dataSetPosition = rs.getString(2);
				dataSetArea = rs.getString(3);
				dataSetRequirementLevel = rs.getString(4);
				dataSetTermsOfEmployment = rs.getString(5);
				dataSetVacancyStatus = rs.getString(6);
				dataSetEducationalAchievement = rs.getString(7);
				dataSetNote = rs.getString(8);
				dataSetDate = rs.getString(9);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static String getDataSetVacancyID() {
		return dataSetVacancyID;
	}
	
	public static String getDataSetPosition() {
		return dataSetPosition;
	}

	public static String getDataSetArea() {
		return dataSetArea;
	}

	public static String getDataSetRequirementLevel() {
		return dataSetRequirementLevel;
	}

	public static String getDataSetTermsOfEmployment() {
		return dataSetTermsOfEmployment;
	}

	public static String getDataSetVacancyStatus() {
		return dataSetVacancyStatus;
	}

	public static String getDataSetEducationalAchievement() {
		return dataSetEducationalAchievement;
	}

	public static String getDataSetNote() {
		return dataSetNote;
	}

	public static String getDataSetDate() {
		return dataSetDate;
	}
}
