package git_aptra.EditVacancy;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import git_aptra.Login.Login;
import git_aptra.MenuBar.MenuBarPanelVacancy;

public class EditVacancy {
	private static String DataSetVacancyID;
	private static String DataSetPosition;
	private static String DataSetArea;
	private static String DataSetRequirementLevel;
	private static String DataSetTermsOfEmployment;
	private static String DataSetVacancyStatus;
	private static String DataSetEducationalAchievement;
	private static String DataSetLevel;
	private static Date DataSetDate;

	public static void getSelectedRow() {
		DataSetPosition = (String) MenuBarPanelVacancy.tableJob.getValueAt(MenuBarPanelVacancy.tableJob.getSelectedRow(), 1);
		DataSetArea = (String) MenuBarPanelVacancy.tableJob.getValueAt(MenuBarPanelVacancy.tableJob.getSelectedRow(), 2);
		DataSetRequirementLevel = (String) MenuBarPanelVacancy.tableJob.getValueAt(MenuBarPanelVacancy.tableJob.getSelectedRow(), 3);
		DataSetTermsOfEmployment = (String) MenuBarPanelVacancy.tableJob.getValueAt(MenuBarPanelVacancy.tableJob.getSelectedRow(), 4);
		DataSetVacancyStatus = (String) MenuBarPanelVacancy.tableJob.getValueAt(MenuBarPanelVacancy.tableJob.getSelectedRow(), 5);
		DataSetEducationalAchievement = (String) MenuBarPanelVacancy.tableJob.getValueAt(MenuBarPanelVacancy.tableJob.getSelectedRow(), 6);
		DataSetLevel = (String) MenuBarPanelVacancy.tableJob.getValueAt(MenuBarPanelVacancy.tableJob.getSelectedRow(), 7);
		try {
			Connection con = Login.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT date FROM vacancy WHERE vacancyID =" + (String) MenuBarPanelVacancy.tableJob.getValueAt(MenuBarPanelVacancy.tableJob.getSelectedRow(), 0));

			while (rs.next()) {
				DataSetDate = rs.getDate(1);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public static String getDataSetVacancyID(){
		return DataSetVacancyID;
	}

	public static String getDataSetPosition() {
		return DataSetPosition;
	}

	public static String getDataSetArea() {
		return DataSetArea;
	}

	public static String getDataSetRequirementLevel() {
		return DataSetRequirementLevel;
	}

	public static String getDataSetTermsOfEmployment() {
		return DataSetTermsOfEmployment;
	}

	public static String getDataSetVacancyStatus() {
		return DataSetVacancyStatus;
	}

	public static String getDataSetLevel() {
		return DataSetLevel;
	}

	public static String getDataSetEducationalAchievement() {
		return DataSetEducationalAchievement;
	}
	
	public static Date getDataSetDate() {
		return DataSetDate;
	}


}
