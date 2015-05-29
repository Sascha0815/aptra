package git_aptra.InfoApplicant;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import git_aptra.Login.Login;
import git_aptra.MenuBar.MenuBarPanelApplicant;

public class InfoApplicant {
	private static String dataSetApplicantID;
	private static String dataSetName;
	private static String dataSetFirstName;
	private static String dataSetStreet;
	private static String dataSetHouseNr;
	private static String dataSetPostalCode;
	private static String dataSetCity;
	private static String dataSetSex;
	private static String dataSetTelefonHome;
	private static String dataSetTelefonMobil;
	private static String dataSetEmail;
	private static String dataSetVacancy;
	private static String dataSetDate;
	private static String dataSetEducationalAchievement;
	private static String dataSetDateApplication;
	private static String dataSetVacancyID;

	public static void getApplicantInfo() {
		dataSetApplicantID = (String) MenuBarPanelApplicant.tableApplicant.getValueAt(MenuBarPanelApplicant.tableApplicant.getSelectedRow(), 0);
		dataSetName = (String) MenuBarPanelApplicant.tableApplicant.getValueAt(MenuBarPanelApplicant.tableApplicant.getSelectedRow(), 1);
		dataSetFirstName = (String) MenuBarPanelApplicant.tableApplicant.getValueAt(MenuBarPanelApplicant.tableApplicant.getSelectedRow(),2);
		dataSetStreet = (String) MenuBarPanelApplicant.tableApplicant.getValueAt(MenuBarPanelApplicant.tableApplicant.getSelectedRow(),3);
		dataSetHouseNr = (String) MenuBarPanelApplicant.tableApplicant.getValueAt(MenuBarPanelApplicant.tableApplicant.getSelectedRow(),4);
		dataSetPostalCode = (String) MenuBarPanelApplicant.tableApplicant.getValueAt(MenuBarPanelApplicant.tableApplicant.getSelectedRow(),5);
		dataSetCity = (String) MenuBarPanelApplicant.tableApplicant.getValueAt(MenuBarPanelApplicant.tableApplicant.getSelectedRow(), 6);
		dataSetTelefonHome = (String) MenuBarPanelApplicant.tableApplicant.getValueAt(MenuBarPanelApplicant.tableApplicant.getSelectedRow(),7);
		dataSetTelefonMobil = (String) MenuBarPanelApplicant.tableApplicant.getValueAt(MenuBarPanelApplicant.tableApplicant.getSelectedRow(),8);
		dataSetEmail = (String) MenuBarPanelApplicant.tableApplicant.getValueAt(MenuBarPanelApplicant.tableApplicant.getSelectedRow(),9);
		dataSetVacancy = (String) MenuBarPanelApplicant.tableApplicant.getValueAt(MenuBarPanelApplicant.tableApplicant.getSelectedRow(),10);
		dataSetDate = (String) MenuBarPanelApplicant.tableApplicant.getValueAt(MenuBarPanelApplicant.tableApplicant.getSelectedRow(), 11);
		dataSetEducationalAchievement = (String) MenuBarPanelApplicant.tableApplicant.getValueAt(MenuBarPanelApplicant.tableApplicant.getSelectedRow(),12);
		try {
			Connection con =  Login.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT sex, applyDate, vacancyID FROM applicant WHERE applicantID =" + dataSetApplicantID);

			while (rs.next()) {
				dataSetDateApplication = rs.getString(1);
				dataSetDateApplication = rs.getString(2);
				dataSetVacancyID = rs.getString(3);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static String getDataSetApplicantID() {
		return dataSetApplicantID;
	}
	
	public static String getDataSetName() {
		return dataSetName;
	}

	public static String getDataSetFirstName() {
		return dataSetFirstName;
	}

	public static String getDataSetStreet() {
		return dataSetStreet;
	}

	public static String getDataSetHouseNr() {
		return dataSetHouseNr;
	}

	public static String getDataSetPostalCode() {
		return dataSetPostalCode;
	}

	public static String getDataSetCity() {
		return dataSetCity;
	}

	public static String getDataSetTelefonHome() {
		return dataSetTelefonHome;
	}

	public static String getDataSetTelefonMobil() {
		return dataSetTelefonMobil;
	}

	public static String getDataSetEmail() {
		return dataSetEmail;
	}

	public static String getDataSetVacancy() {
		return dataSetVacancy;
	}

	public static String getDataSetEducationalAchievement() {
		return dataSetEducationalAchievement;
	}

	public static String getDataSetDate() {
		return dataSetDate;
	}
	
	public static String getDataSetSex() {
		return dataSetSex;
	}	

	public static String getDataSetDateApplication() {
		return dataSetDateApplication;
	}

	public static String getDataSetVacancyID() {
		return dataSetVacancyID;
	}	
}
