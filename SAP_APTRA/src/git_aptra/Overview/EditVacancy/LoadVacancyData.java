package git_aptra.Overview.EditVacancy;

import git_aptra.Login.Login;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

//Suchfunktion Übersicht Arbeitsstellen bearbeiten
public class LoadVacancyData {

	private static String vacancyID;
	private static String position;
	private static String area;
	private static String divisionID;
	private static String educationalAchievement;
	private static String requirementLevel;
	private static String termsOfEmployment;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Vector loadVacancyData() throws SQLException {
		Connection dbConnection = null;
		boolean first = true;
		Vector resultsLoadVacancyData = new Vector();
		if (!(DialogOverviewEditVacancyData.getVacancyID().equals(""))) {
			if (first == true) {
				vacancyID = "where vacancyID = '"
						+ DialogOverviewEditVacancyData.getVacancyID() + "'";
				first = false;
			} else {
				vacancyID = " AND vacancyID = '"
						+ DialogOverviewEditVacancyData.getVacancyID() + "'";
			}
		} else {
			vacancyID = "";
		}
		
		if (!DialogOverviewEditVacancyData.getPosition().equals("")) {
			if (first == true) {
				position = "where position = '"
						+ DialogOverviewEditVacancyData.getPosition() + "'";
				first = false;
			} else {
				position = " AND position = '"
						+ DialogOverviewEditVacancyData.getPosition() + "'";
			}
		} else {
			position = "";
		}

		if (!DialogOverviewEditVacancyData.getArea().equals("")) {
			if (first == true) {
				area = "where area = '"
						+ DialogOverviewEditVacancyData.getArea() + "'";
				first = false;
			} else {
				area = " AND area = '"
						+ DialogOverviewEditVacancyData.getArea() + "'";
			}
		} else {
			area = "";
		}
	
		if (!DialogOverviewEditVacancyData.getDivisonID().equals("")) {
			if (first == true) {
				divisionID = "where divisionID = '"
						+ DialogOverviewEditVacancyData.getDivisonID() + "'";
				first = false;
			} else {
				divisionID = " AND divisionID = '"
						+ DialogOverviewEditVacancyData.getDivisonID() + "'";
			}
		} else {
			divisionID = "";
		}
		if (!DialogOverviewEditVacancyData.getEducationAchievement().equals("")) {
			if (first == true) {
				educationalAchievement = "where educationalAchievement = '"
						+ DialogOverviewEditVacancyData.getEducationAchievement() + "'";
				first = false;
			} else {
				educationalAchievement = " AND educationalAchievement = '"
						+ DialogOverviewEditVacancyData.getEducationAchievement() + "'";
			}
		} else {
			educationalAchievement = "";
		}
		if (!DialogOverviewEditVacancyData.getRequirementLevel().equals("")) {
			if (first == true) {
				requirementLevel = "where requirementLevel = '"
						+ DialogOverviewEditVacancyData.getRequirementLevel() + "'";
				first = false;
			} else {
				requirementLevel = " AND requirementLevel = '"
						+ DialogOverviewEditVacancyData.getRequirementLevel() + "'";
			}
		} else {
			requirementLevel = "";
		}
		
		if (!DialogOverviewEditVacancyData.getTermsOfEmployment().equals("")) {
			if (first == true) {
				termsOfEmployment = "where termsOfEmployment = '"
						+ DialogOverviewEditVacancyData.getTermsOfEmployment()+ "'";
				first = false;
			} else {
				termsOfEmployment = " AND termsOfEmployment = '"
						+ DialogOverviewEditVacancyData.getTermsOfEmployment() + "'";
			}
		} else {
			termsOfEmployment = "";
		}
		
		try {
			dbConnection = Login.getConnection();

			Statement stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from vacancy " + vacancyID + position
					+ area + divisionID + educationalAchievement + requirementLevel + termsOfEmployment );
		
			while (rs.next()) {
				Vector vacancy = new Vector();
				vacancy.add(rs.getString(1));
				vacancy.add(rs.getString(2));
				vacancy.add(rs.getString(3));
				vacancy.add(rs.getString(10));
				vacancy.add(rs.getString(7));
				vacancy.add(rs.getString(4));
				vacancy.add(rs.getString(5));
				resultsLoadVacancyData.add(vacancy);
			}

		} catch (SQLException e) {
			System.out.println("Datenbank - loadVacancyData" + e.getMessage());
		}
		return resultsLoadVacancyData;	
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Vector insertLoadVacancyDataIntoTable(){
		Vector resultsLoadVacancyDataAll = new Vector();
		try {
			Connection dbConnection = null;
			dbConnection = Login.getConnection();
			
			Statement stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from vacancy");
		
			while (rs.next()) {
				Vector vacancy = new Vector();
				vacancy.add(rs.getString(1));
				vacancy.add(rs.getString(2));
				vacancy.add(rs.getString(3));
				vacancy.add(rs.getString(4));
				vacancy.add(rs.getString(5));
				resultsLoadVacancyDataAll.add(vacancy);
			}

		} catch (SQLException e) {
			System.out.println("Datenbank - loadvacancyDataAll" + e.getMessage());
		}
		return resultsLoadVacancyDataAll;
	}
	
}
