package git_aptra.DatabaseConnection;

import git_aptra.DialogSearchApplicant.DialogSearchApplicantApplication;
import git_aptra.DialogSearchApplicant.DialogSearchApplicantContact;
import git_aptra.DialogSearchApplicant.DialogSearchApplicantGeneral;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class SearchApplicant {
	
	private static String name;
	private static String firstName;
	private static String street;
	private static String houseNr;
	private static String postalCode;
	private static String city;
	private static String telefonHome;
	private static String telefonMobil;
	private static String email;
	private static String vacancy;
	private static String educationalAcievement;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Vector searchApplicant() throws SQLException {
		Connection dbConnection = null;
		Vector resultsSearchApplicant = new Vector();
		boolean first = true;

		if (!DialogSearchApplicantGeneral.getName().equals("")) {
			if (first == true) {
				name = "where name = '"
						+ DialogSearchApplicantGeneral.getName() + "'";
				first = false;
			} else {
				name = "where name = '"
						+ DialogSearchApplicantGeneral.getName() + "'";
			}
		} else {
			name = "";
		}

		if (!DialogSearchApplicantGeneral.getFirstName().equals("")) {
			if (first == true) {
				firstName = "where firstName = '"
						+ DialogSearchApplicantGeneral.getFirstName() + "'";
				first = false;
			} else {
				firstName = " AND firstName = '"
						+ DialogSearchApplicantGeneral.getFirstName() + "'";
			}
		} else {
			firstName = "";
		}
		if (!DialogSearchApplicantGeneral.getStreet().equals("")) {
			if (first == true) {
				street = "where street = '"
						+ DialogSearchApplicantGeneral.getStreet() + "'";
				first = false;
			} else {
				street = " AND street = '"
						+ DialogSearchApplicantGeneral.getStreet() + "'";
			}
		} else {
			street = "";
		}
		if (!(DialogSearchApplicantGeneral.getHouseNr() == 0)) {
			if (first == true) {
				houseNr = "where houseNR = '"
						+ DialogSearchApplicantGeneral.getHouseNr() + "'";
				first = false;
			} else {
				houseNr = " AND houseNR = '"
						+ DialogSearchApplicantGeneral.getHouseNr() + "'";
			}
		} else {
			houseNr = "";
		}
		if (!(DialogSearchApplicantGeneral.getPostalCode() == 0)) {
			if (first == true) {
				postalCode = "where postalCode = '"
						+ DialogSearchApplicantGeneral.getPostalCode() + "'";
				first = false;
			} else {
				postalCode = " AND postalCode = '"
						+ DialogSearchApplicantGeneral.getPostalCode() + "'";
			}
		} else {
			postalCode = "";
		}
		if (!DialogSearchApplicantGeneral.getCity().equals("")) {
			if (first == true) {
				city = "where city = '"
						+ DialogSearchApplicantGeneral.getCity() + "'";
				first = false;
			} else {
				city = " AND city = '" + DialogSearchApplicantGeneral.getCity()
						+ "'";
			}
		} else {
			city = "";
		}
		if (!DialogSearchApplicantContact.getTelefonHome().equals("")) {
			if (first == true) {
				telefonHome = "where telefonHome = '"
						+ DialogSearchApplicantContact.getTelefonHome() + "'";
				first = false;
			} else {
				telefonHome = " AND telefonHome = '"
						+ DialogSearchApplicantContact.getTelefonHome() + "'";
			}
		} else {
			telefonHome = "";
		}
		if (!DialogSearchApplicantContact.getTelefonMobil().equals("")) {
			if (first == true) {
				telefonMobil = "where telefonMobil = '"
						+ DialogSearchApplicantContact.getTelefonMobil() + "'";
				first = false;
			} else {
				telefonMobil = " AND telefonMobil = '"
						+ DialogSearchApplicantContact.getTelefonMobil() + "'";
			}
		} else {
			telefonMobil = "";
		}
		if (!DialogSearchApplicantContact.getEmail().equals("")) {
			if (first == true) {
				email = "where email = '"
						+ DialogSearchApplicantContact.getEmail() + "'";
				first = false;
			} else {
				email = " AND email = '"
						+ DialogSearchApplicantContact.getEmail() + "'";
			}
		} else {
			email = "";
		}
		if (!DialogSearchApplicantApplication.getVacancy().equals("")) {
			if (first == true) {
				vacancy = "where vacancy = '"
						+ DialogSearchApplicantApplication.getVacancy() + "'";
				first = false;
			} else {
				vacancy = " AND vacancy = '"
						+ DialogSearchApplicantApplication.getVacancy() + "'";
			}
		} else {
			vacancy = "";
		}
		if (!DialogSearchApplicantApplication.getEducationalAchievement()
				.equals("Bitte auswählen")) {
			if (first == true) {
				educationalAcievement = "where educationalAchievement = '"
						+ DialogSearchApplicantApplication
								.getEducationalAchievement() + "'";
				first = false;
			} else {
				educationalAcievement = "AND educationalAchievement = '"
						+ DialogSearchApplicantApplication
								.getEducationalAchievement() + "'";
			}
		} else {
			educationalAcievement = "";
		}

		System.out.println("select * from applicant " + name + firstName
				+ street + houseNr + postalCode + city + telefonHome
				+ telefonMobil + email + vacancy + educationalAcievement);
		try {
			dbConnection = DriverManager.getConnection(
					"jdbc:mysql://185.28.20.242:3306/u474396146_db",
					"u474396146_aptra", "aptraDB");

			Statement stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from applicant " + name
					+ firstName + street + houseNr + postalCode + city
					+ telefonHome + telefonMobil + email + vacancy
					+ educationalAcievement);

			while (rs.next()) {
				Vector applicant = new Vector();
				applicant.add(rs.getString(1));
				applicant.add(rs.getString(2));
				applicant.add(rs.getString(3));
				applicant.add(rs.getString(4));
				applicant.add(rs.getString(5));
				applicant.add(rs.getString(6));
				applicant.add(rs.getString(7));
				applicant.add(rs.getString(8));
				applicant.add(rs.getString(9));
				applicant.add(rs.getString(10));
				applicant.add(rs.getString(11));
				applicant.add(rs.getString(12));
				applicant.add(rs.getString(13));
				resultsSearchApplicant.add(applicant);
			}

		} catch (SQLException e) {
			System.out.println("Datenbank - searchApplicant" + e.getMessage());
		}

		return resultsSearchApplicant;

	}

}
