package git_aptra.EditApplicant;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import git_aptra.Login.Login;
import git_aptra.MenuBar.MenuBarPanelApplicant;

public class EditApplicant {
	private static String DataSetApplicantID;
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
	private static Date DataSetDate;
	private static Date DataSetApplyDate;
	private static String DataSetEducationalAchievement;
	private static String DataSetSex;
	private static String DataSetDivision;

	public static void getSelectedRow() {
		DataSetName = (String) MenuBarPanelApplicant.tableApplicant.getValueAt(MenuBarPanelApplicant.tableApplicant.getSelectedRow(), 1);
		DataSetFirstName = (String) MenuBarPanelApplicant.tableApplicant.getValueAt(MenuBarPanelApplicant.tableApplicant.getSelectedRow(),2);
		DataSetStreet = (String) MenuBarPanelApplicant.tableApplicant.getValueAt(MenuBarPanelApplicant.tableApplicant.getSelectedRow(),3);
		DataSetHouseNr = (String) MenuBarPanelApplicant.tableApplicant.getValueAt(MenuBarPanelApplicant.tableApplicant.getSelectedRow(),4);
		DataSetPostalCode = (String) MenuBarPanelApplicant.tableApplicant.getValueAt(MenuBarPanelApplicant.tableApplicant.getSelectedRow(),5);
		DataSetCity = (String) MenuBarPanelApplicant.tableApplicant.getValueAt(MenuBarPanelApplicant.tableApplicant.getSelectedRow(), 6);
		DataSetTelefonHome = (String) MenuBarPanelApplicant.tableApplicant.getValueAt(MenuBarPanelApplicant.tableApplicant.getSelectedRow(),7);
		DataSetTelefonMobil = (String) MenuBarPanelApplicant.tableApplicant.getValueAt(MenuBarPanelApplicant.tableApplicant.getSelectedRow(),8);
		DataSetEmail = (String) MenuBarPanelApplicant.tableApplicant.getValueAt(MenuBarPanelApplicant.tableApplicant.getSelectedRow(),9);
		DataSetVacancy = (String) MenuBarPanelApplicant.tableApplicant.getValueAt(MenuBarPanelApplicant.tableApplicant.getSelectedRow(),10);
		DataSetEducationalAchievement = (String) MenuBarPanelApplicant.tableApplicant.getValueAt(MenuBarPanelApplicant.tableApplicant.getSelectedRow(),12);
		try {
			Connection con =  Login.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT sex, date, applyDate, division FROM applicant WHERE applicantID =" + (String) MenuBarPanelApplicant.tableApplicant.getValueAt(MenuBarPanelApplicant.tableApplicant.getSelectedRow(), 0));

			while (rs.next()) {
				DataSetSex = rs.getString(1);
				DataSetDate = rs.getDate(2);
				DataSetApplyDate = rs.getDate(3);
				DataSetDivision = rs.getString(4);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static String getDataSetVacancyID(){
		return DataSetApplicantID;
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

	public static Date getDataSetDate(){
		return DataSetDate;
	}
	
	public static Date getDataSetApplyDate(){
		return DataSetApplyDate;
	}
	
	public static String getDataSetApplicantID() {
		return DataSetApplicantID;
	}
	
	public static String getDataSetSex() {
		return DataSetSex;
	}
	
	public static String getDataSetDivision() {
		return DataSetDivision;
	}

}
