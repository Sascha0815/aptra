package git_aptra.EditApplicant;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import git_aptra.Login.Login;
import git_aptra.MenuBar.MenuBarPanelApplicant;
import git_aptra.Overview.EditApplicant.DialogLoadApplicantEditSelection;

public class EditApplicant {
	private static String dataApplicantID;
	private static String dataName;
	private static String dataFirstName;
	private static String dataStreet;
	private static String dataHouseNr;
	private static String dataPostalCode;
	private static String dataCity;
	private static String dataTelefonHome;
	private static String dataTelefonMobil;
	private static String dataEmail;
	private static String dataVacancy;
	private static Date dataDate;
	private static Date dataApplyDate;
	private static String dataEducationalAchievement;
	private static String dataSex;
	private static String vid;

	public static void getSelectedRow(boolean overview) {
		
		if (overview==false) {
			dataName = (String) MenuBarPanelApplicant.tableApplicant.getValueAt(MenuBarPanelApplicant.tableApplicant.getSelectedRow(), 1);
			dataFirstName = (String) MenuBarPanelApplicant.tableApplicant.getValueAt(MenuBarPanelApplicant.tableApplicant.getSelectedRow(),2);
			dataStreet = (String) MenuBarPanelApplicant.tableApplicant.getValueAt(MenuBarPanelApplicant.tableApplicant.getSelectedRow(),3);
			dataHouseNr = (String) MenuBarPanelApplicant.tableApplicant.getValueAt(MenuBarPanelApplicant.tableApplicant.getSelectedRow(),4);
			dataPostalCode = (String) MenuBarPanelApplicant.tableApplicant.getValueAt(MenuBarPanelApplicant.tableApplicant.getSelectedRow(),5);
			dataCity = (String) MenuBarPanelApplicant.tableApplicant.getValueAt(MenuBarPanelApplicant.tableApplicant.getSelectedRow(), 6);
			dataTelefonHome = (String) MenuBarPanelApplicant.tableApplicant.getValueAt(MenuBarPanelApplicant.tableApplicant.getSelectedRow(),7);
			dataTelefonMobil = (String) MenuBarPanelApplicant.tableApplicant.getValueAt(MenuBarPanelApplicant.tableApplicant.getSelectedRow(),8);
			dataEmail = (String) MenuBarPanelApplicant.tableApplicant.getValueAt(MenuBarPanelApplicant.tableApplicant.getSelectedRow(),9);
			dataVacancy = (String) MenuBarPanelApplicant.tableApplicant.getValueAt(MenuBarPanelApplicant.tableApplicant.getSelectedRow(),10);
			dataEducationalAchievement = (String) MenuBarPanelApplicant.tableApplicant.getValueAt(MenuBarPanelApplicant.tableApplicant.getSelectedRow(),12);
			
			try {
				Connection con =  Login.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT sex, date, applyDate FROM applicant WHERE applicantID =" + (String) MenuBarPanelApplicant.tableApplicant.getValueAt(MenuBarPanelApplicant.tableApplicant.getSelectedRow(), 0));

				while (rs.next()) {
					dataSex = rs.getString(1);
					dataDate = rs.getDate(2);
					dataApplyDate = rs.getDate(3);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				Connection con =  Login.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT vacancyID FROM relationship WHERE applicantID =" + (String) MenuBarPanelApplicant.tableApplicant.getValueAt(MenuBarPanelApplicant.tableApplicant.getSelectedRow(), 0));

				while (rs.next()) {				
					vid = rs.getString(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		else {
			
			try {
				Connection con =  Login.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT name, firstName, street, houseNr, postalCode, city, telefonHome, telefonMobil, email, vacancy, educationalAchievement, sex, date, applyDate FROM applicant WHERE applicantID =" + (String) DialogLoadApplicantEditSelection.tableDialogLoadApplicantData.getValueAt(DialogLoadApplicantEditSelection.tableDialogLoadApplicantData.getSelectedRow(), 0));

				while (rs.next()) {
					dataName = rs.getString(1);
					dataFirstName = rs.getString(2);
					dataStreet = rs.getString(3);
					dataHouseNr = rs.getString(4);
					dataPostalCode = rs.getString(5);
					dataCity = rs.getString(6);
					dataTelefonHome = rs.getString(7);
					dataTelefonMobil = rs.getString(8);
					dataEmail = rs.getString(9);
					dataVacancy = rs.getString(10);
					dataEducationalAchievement = rs.getString(11);
					dataSex = rs.getString(12);
					dataDate = rs.getDate(13);
					dataApplyDate = rs.getDate(14);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				Connection con =  Login.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT vacancyID FROM relationship WHERE applicantID =" + (String) DialogLoadApplicantEditSelection.tableDialogLoadApplicantData.getValueAt(DialogLoadApplicantEditSelection.tableDialogLoadApplicantData.getSelectedRow(), 0));

				while (rs.next()) {				
					vid = rs.getString(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

	public static String getDataVacancyID(){
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
		dataVacancy = vid + " - " + dataVacancy;
		return dataVacancy;
	}

	public static String getDataEducationalAchievement() {
		return dataEducationalAchievement;
	}

	public static Date getDataDate(){
		return dataDate;
	}
	
	public static Date getDataApplyDate(){
		return dataApplyDate;
	}
	
	public static String getDataApplicantID() {
		return dataApplicantID;
	}
	
	public static String getDataSex() {
		return dataSex;
	}
	
	

}
