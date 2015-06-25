package git_aptra.InfoApplicant;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import git_aptra.Login.Login;


public class InfoApplicant {
	private static String dataApplicantID;
	private static String dataName;
	private static String dataFirstName;
	private static String dataStreet;
	private static String dataHouseNr;
	private static String dataPostalCode;
	private static String dataCity;
	private static String dataSex;
	private static String dataTelefonHome;
	private static String dataTelefonMobil;
	private static String dataEmail;
	private static String dataVacancy;
	private static String dataDate;
	private static String dataEducationalAchievement;
	private static String dataDateApplication;
	private static String dataVacancyID;

	public static void getApplicantInfo(int id) {	
		try {
			Connection con =  Login.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT applicantID, name, firstName, street, houseNR, postalCode, city, telefonHome, telefonMobil, email, vacancy, date, applyDate, sex, vacancyID, educationalAchievement FROM applicant WHERE applicantID = " + id);

			while (rs.next()) {
				dataApplicantID = rs.getString(1);
				dataName = rs.getString(2);
				dataFirstName = rs.getString(3);
				dataStreet = rs.getString(4);
				dataHouseNr = rs.getString(5);
				dataPostalCode = rs.getString(6);
				dataCity = rs.getString(7);
				dataTelefonHome = rs.getString(8);
				dataTelefonMobil = rs.getString(9);
				dataEmail = rs.getString(10);
				dataVacancy = rs.getString(11);
				dataDate = rs.getString(12);
				dataDateApplication = rs.getString(13);
				dataSex = rs.getString(14);
				dataVacancyID = rs.getString(15);
				dataEducationalAchievement = rs.getString(16);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	public static String getDataApplicantID() {
		return dataApplicantID;
	}
	
	public static String getDataName() {
		return dataName;
	}

	public static String getDataFirstName() {
		return dataFirstName;
	}

	public static String getDataStreet() {
		return dataStreet;
	}

	public static String getDataHouseNr() {
		return dataHouseNr;
	}

	public static String getDataPostalCode() {
		return dataPostalCode;
	}

	public static String getDataCity() {
		return dataCity;
	}

	public static String getDataTelefonHome() {
		return dataTelefonHome;
	}

	public static String getDataTelefonMobil() {
		return dataTelefonMobil;
	}

	public static String getDataEmail() {
		return dataEmail;
	}

	public static String getDataVacancy() {
		return dataVacancy;
	}

	public static String getDataEducationalAchievement() {
		return dataEducationalAchievement;
	}

	public static String getDataDate() {
		return dataDate;
	}
	
	public static String getDataSex() {
		return dataSex;
	}	

	public static String getDataDateApplication() {
		return dataDateApplication;
	}

	public static String getDataVacancyID() {
		return dataVacancyID;
	}	
}
