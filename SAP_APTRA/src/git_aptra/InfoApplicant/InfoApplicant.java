package git_aptra.InfoApplicant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import git_aptra.MenuBar.MenuBarPanelApplicant;

public class InfoApplicant {

	private static String DataSetName;
	private static String DataSetFirstName;
	private static String DataSetStreet;
	private static String DataSetHouseNr;
	private static String DataSetPostalCode;
	private static String DataSetCity;
	private static String DataSetTelefonHome;
	private static String DataSetTelefonMobil;
	private static String DataSetEmail;
	private static String DataSetVacancy;
	private static String DataSetDate;
	private static String DataSetEducationalAchievement;
	private static String DataSetDateApplication;
	private static String DataSetVacancyID;
	private static String DataSetMarkApplicant;
	private static String DataSetMarkApplication;
	private static boolean DataSetCL;
	private static boolean DataSetCV;

	public static void getSelectedRow() {
		DataSetName = (String) MenuBarPanelApplicant.tableApplicant.getValueAt(
				MenuBarPanelApplicant.tableApplicant.getSelectedRow(), 1);

		DataSetFirstName = (String) MenuBarPanelApplicant.tableApplicant
				.getValueAt(
						MenuBarPanelApplicant.tableApplicant.getSelectedRow(),
						2);
		DataSetStreet = (String) MenuBarPanelApplicant.tableApplicant
				.getValueAt(
						MenuBarPanelApplicant.tableApplicant.getSelectedRow(),
						3);
		DataSetHouseNr = (String) MenuBarPanelApplicant.tableApplicant
				.getValueAt(
						MenuBarPanelApplicant.tableApplicant.getSelectedRow(),
						4);
		DataSetPostalCode = (String) MenuBarPanelApplicant.tableApplicant
				.getValueAt(
						MenuBarPanelApplicant.tableApplicant.getSelectedRow(),
						5);
		DataSetCity = (String) MenuBarPanelApplicant.tableApplicant.getValueAt(
				MenuBarPanelApplicant.tableApplicant.getSelectedRow(), 6);
		DataSetTelefonHome = (String) MenuBarPanelApplicant.tableApplicant
				.getValueAt(
						MenuBarPanelApplicant.tableApplicant.getSelectedRow(),
						7);
		DataSetTelefonMobil = (String) MenuBarPanelApplicant.tableApplicant
				.getValueAt(
						MenuBarPanelApplicant.tableApplicant.getSelectedRow(),
						8);
		DataSetEmail = (String) MenuBarPanelApplicant.tableApplicant
				.getValueAt(
						MenuBarPanelApplicant.tableApplicant.getSelectedRow(),
						9);
		DataSetVacancy = (String) MenuBarPanelApplicant.tableApplicant
				.getValueAt(
						MenuBarPanelApplicant.tableApplicant.getSelectedRow(),
						10);
		DataSetDate = (String) MenuBarPanelApplicant.tableApplicant.getValueAt(
				MenuBarPanelApplicant.tableApplicant.getSelectedRow(), 11);

		DataSetEducationalAchievement = (String) MenuBarPanelApplicant.tableApplicant
				.getValueAt(
						MenuBarPanelApplicant.tableApplicant.getSelectedRow(),
						12);
	}

	public static String getDataSetName() {
		return DataSetName;
	}

	public static String getDataSetFirstName() {
		return DataSetFirstName;
	}

	public static String getDataSetStreet() {
		return DataSetStreet;
	}

	public static String getDataSetHouseNr() {
		return DataSetHouseNr;
	}

	public static String getDataSetPostalCode() {
		return DataSetPostalCode;
	}

	public static String getDataSetCity() {
		return DataSetCity;
	}

	public static String getDataSetTelefonHome() {
		return DataSetTelefonHome;
	}

	public static String getDataSetTelefonMobil() {
		return DataSetTelefonMobil;
	}

	public static String getDataSetEmail() {
		return DataSetEmail;
	}

	public static String getDataSetVacancy() {
		return DataSetVacancy;
	}

	public static String getDataSetEducationalAchievement() {
		return DataSetEducationalAchievement;
	}

	public static String getDataSetDate() {
		return DataSetDate;
	}

	public static String getDataSetDateApplication() {
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://185.28.20.242:3306/u474396146_db",
					"u474396146_aptra", "aptraDB");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from applicant");

			while (rs.next()) {
				DataSetDateApplication = rs.getString(14);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return DataSetDateApplication;
	}

	public static String getDataSetVacancyID() {
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://185.28.20.242:3306/u474396146_db",
					"u474396146_aptra", "aptraDB");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from applicant");

			while (rs.next()) {
				DataSetVacancyID = rs.getString(15);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return DataSetVacancyID;
	}
	
	public static String getDataSetMarkApplicant(){
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://185.28.20.242:3306/u474396146_db",
					"u474396146_aptra", "aptraDB");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from relationship");

			while (rs.next()) {
				DataSetMarkApplicant = rs.getString(5);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return DataSetMarkApplicant;
	}
	
	public static String getDataSetMarkApplication(){
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://185.28.20.242:3306/u474396146_db",
					"u474396146_aptra", "aptraDB");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from relationship");

			while (rs.next()) {
				DataSetMarkApplication = rs.getString(6);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return DataSetMarkApplication;
	}
	
	public static boolean getDataSetCL(){
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://185.28.20.242:3306/u474396146_db",
					"u474396146_aptra", "aptraDB");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from relationship");

			while (rs.next()) {
				DataSetCL = rs.getBoolean(7);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return DataSetCL;
	}
	
	public static boolean getDataSetCV(){
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://185.28.20.242:3306/u474396146_db",
					"u474396146_aptra", "aptraDB");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from relationship");

			while (rs.next()) {
				DataSetCV = rs.getBoolean(8);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return DataSetCV;
	}
	
	
	

}
