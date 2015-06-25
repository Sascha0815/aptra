package git_aptra.EditVacancy;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import git_aptra.Login.Login;
import git_aptra.MenuBar.MenuBarPanelVacancy;

public class EditVacancy {
	private static String dataVacancyID;
	private static String dataPosition;
	private static String dataArea;
	private static String dataRequirementLevel;
	private static String dataTermsOfEmployment;
	private static String dataVacancyStatus;
	private static String dataEducationalAchievement;
	private static String dataNote;
	private static Date dataDate;
	private static String division;
	private static String DID;
	private static String notation;
	private static int VID;

	public static void getSelectedRow(int id) {
		VID = id;
		try {
			Connection con = Login.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT vacancyID, position, area, requirementLevel, termsOfEmployment, vacancyStatus, date, educationalAchievement, note, divisionID FROM vacancy WHERE vacancyID = " +id);

			while (rs.next()) {
				dataVacancyID = rs.getString(1);
				dataPosition = rs.getString(2);
				dataArea = rs.getString(3);
				dataRequirementLevel = rs.getString(4);
				dataTermsOfEmployment = rs.getString(5);
				dataVacancyStatus = rs.getString(6);
				dataDate = rs.getDate(7);
				dataEducationalAchievement = rs.getString(8);
				dataNote = rs.getString(9);
				DID = rs.getString(10);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			Connection con = Login.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT notation FROM division WHERE divisionID = " +DID);

			while (rs.next()) {
				notation = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public static String getDataVacancyID(){
		return dataVacancyID;
	}

	public static String getDataPosition() {
		return dataPosition;
	}

	public static String getDataArea() {
		return dataArea;
	}

	public static String getDataRequirementLevel() {
		return dataRequirementLevel;
	}

	public static String getDataTermsOfEmployment() {
		return dataTermsOfEmployment;
	}

	public static String getDataVacancyStatus() {
		return dataVacancyStatus;
	}

	public static String getDataNote() {
		return dataNote;
	}

	public static String getDataEducationalAchievement() {
		return dataEducationalAchievement;
	}
	
	public static Date getDataDate() {
		return dataDate;
	}
	public static String getVacancy() {
		division = DID + " - " + notation;
		return division;
	}
	public static int getVacancyID() {
		return VID;
	}
	


}
