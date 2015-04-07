package git_aptra.SearchVacancy;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class SearchVacancy {

	private static String vacancyID;
	private static String position;
	private static String area;
	private static String requirementLevel;
	private static String termsOfEmployment;
	private static String vacancyStatus;
	private static String educationalAchievementVacancy;
	private static String level;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Vector searchVacancy() {
		Connection dbConnection = null;
		Vector resultsSearchVacancy = new Vector();
		boolean first = true;
		
		if (!(DialogSearchVacancyGeneral.getVacancyID() == 0)) {
			if (first == true) {
				vacancyID = "where vacancyID = '"
						+ DialogSearchVacancyGeneral.getVacancyID() + "'";
				first = false;
			} else {
				vacancyID = " AND vacancyID = '"
						+ DialogSearchVacancyGeneral.getVacancyID() + "'";
			}
		} else {
			vacancyID = "";
		}
		if (!DialogSearchVacancyGeneral.getPosition().equals("")) {
			if (first == true) {
				position = "where position = '"
						+ DialogSearchVacancyGeneral.getPosition() + "'";
				first = false;
			} else {
				position = "where position = '"
						+ DialogSearchVacancyGeneral.getPosition() + "'";
			}
		} else {
			position = "";
		}

		if (!DialogSearchVacancyGeneral.getArea().equals("")) {
			if (first == true) {
				area = "where area = '" + DialogSearchVacancyGeneral.getArea()
						+ "'";
				first = false;
			} else {
				area = "AND area = '" + DialogSearchVacancyGeneral.getArea()
						+ "'";
			}
		} else {
			area = "";
		}

		if (!DialogSearchVacancyGeneral.getRequirementLevel().equals("")) {
			if (first == true) {
				requirementLevel = "where requirementLevel = '"
						+ DialogSearchVacancyGeneral.getRequirementLevel()
						+ "'";
				first = false;
			} else {
				requirementLevel = "AND requirementLevel = '"
						+ DialogSearchVacancyGeneral.getRequirementLevel()
						+ "'";
			}
		} else {
			requirementLevel = "";
		}

		if (!DialogSearchVacancyGeneral.getTermsOfEmployment().equals("")) {
			if (first == true) {
				termsOfEmployment = "where termsOfEmployment = '"
						+ DialogSearchVacancyGeneral.getTermsOfEmployment()
						+ "'";
				first = false;
			} else {
				termsOfEmployment = "AND termsOfEmployment = '"
						+ DialogSearchVacancyGeneral.getTermsOfEmployment()
						+ "'";
			}
		} else {
			termsOfEmployment = "";
		}

		if (!DialogSearchVacancyGeneral.getVacancyStatus().equals("")) {
			if (first == true) {
				vacancyStatus = "where vacancyStatus = '"
						+ DialogSearchVacancyGeneral.getVacancyStatus() + "'";
				first = false;
			} else {
				vacancyStatus = "AND vacancyStatus = '"
						+ DialogSearchVacancyGeneral.getVacancyStatus() + "'";
			}
		} else {
			vacancyStatus = "";
		}

		if (!DialogSearchVacancyGeneral.getEducationalAchievementVacancy()
				.equals("")) {
			if (first == true) {
				educationalAchievementVacancy = "where educationalAchievement = '"
						+ DialogSearchVacancyGeneral
								.getEducationalAchievementVacancy() + "'";
				first = false;
			} else {
				educationalAchievementVacancy = "AND educationalAchievement = '"
						+ DialogSearchVacancyGeneral
								.getEducationalAchievementVacancy() + "'";
			}
		} else {
			educationalAchievementVacancy = "";
		}

		if (!DialogSearchVacancySpecification.getLevel().equals("")) {
			if (first == true) {
				level = "where level = '"
						+ DialogSearchVacancySpecification.getLevel() + "'";
				first = false;
			} else {
				level = "AND level = '"
						+ DialogSearchVacancySpecification.getLevel() + "'";
			}
		} else {
			level = "";
		}
		System.out.println("select * from vacancy "
					+ vacancyID + position + area + requirementLevel + termsOfEmployment
					+ vacancyStatus + educationalAchievementVacancy + level);

		try {
			dbConnection = DriverManager.getConnection(
					"jdbc:mysql://185.28.20.242:3306/u474396146_db",
					"u474396146_aptra", "aptraDB");

			Statement stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from vacancy "
					+ vacancyID + position + area + requirementLevel + termsOfEmployment
					+ vacancyStatus + educationalAchievementVacancy + level);

			while (rs.next()) {
				Vector vacancy = new Vector();
				vacancy.add(rs.getString(1));
				vacancy.add(rs.getString(2));
				vacancy.add(rs.getString(3));
				vacancy.add(rs.getString(4));
				vacancy.add(rs.getString(5));
				vacancy.add(rs.getString(6));
				vacancy.add(rs.getString(7));
				vacancy.add(rs.getString(8));
				vacancy.add(rs.getString(9));
				resultsSearchVacancy.add(vacancy);
			}

		} catch (SQLException e) {
			System.out.println("Datenbank - searchVacancy" + e.getMessage());
		}

		return resultsSearchVacancy;

	}

}
