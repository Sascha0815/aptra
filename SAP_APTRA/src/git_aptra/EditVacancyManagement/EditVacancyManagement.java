package git_aptra.EditVacancyManagement;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import git_aptra.Login.Login;
import git_aptra.MenuBar.MenuBarPanelVacancyManagement;
//Liest die benötigten Daten aus
public class EditVacancyManagement {

	private static String DataSetApplicantID;
	private static String DataSetName;
	private static String DataSetFirstName;
	private static String DataSetStatus;
	private static String DataSetDate;
	private static int DataSetDay;
	private static int DataSetMonth;
	private static int DataSetYear;
	private static boolean DataSetCurriculumVitae;
	private static boolean DataSetCoveringLetter;
	

	public static void getSelectedRow() {
		
		DataSetApplicantID = (String) MenuBarPanelVacancyManagement.tableVacancyManagement
				.getValueAt(
						MenuBarPanelVacancyManagement.tableVacancyManagement
								.getSelectedRow(), 0);

		DataSetName = (String) MenuBarPanelVacancyManagement.tableVacancyManagement
				.getValueAt(
						MenuBarPanelVacancyManagement.tableVacancyManagement
								.getSelectedRow(), 1);

		DataSetFirstName = (String) MenuBarPanelVacancyManagement.tableVacancyManagement
				.getValueAt(
						MenuBarPanelVacancyManagement.tableVacancyManagement
								.getSelectedRow(), 2);

		DataSetStatus = (String) MenuBarPanelVacancyManagement.tableVacancyManagement
				.getValueAt(
						MenuBarPanelVacancyManagement.tableVacancyManagement
								.getSelectedRow(), 4);

		DataSetDate = (String) MenuBarPanelVacancyManagement.tableVacancyManagement
				.getValueAt(
						MenuBarPanelVacancyManagement.tableVacancyManagement
								.getSelectedRow(), 5);
		String[] split = DataSetDate.split("-");
		DataSetYear = Integer.parseInt(split[0].toString());
		DataSetMonth = Integer.parseInt(split[1].toString());
		DataSetDay = Integer.parseInt(split[2].toString());
	}

	public static String getDataSetApplicantID() {
		return DataSetApplicantID;
	}

	public static String getDataSetName() {
		return DataSetName;
	}

	public static String getDataSetFirstName() {
		return DataSetFirstName;
	}

	public static String getDataSetStatus() {
		return DataSetStatus;
	}

	public static int getDataSetYear() {
		return DataSetYear;
	}

	public static int getDataSetMonth() {
		return DataSetMonth;
	}

	public static int getDataSetDay() {
		return DataSetDay;
	}
	
	
	public static boolean getDataSetCurriculumVitae() {
		DataSetApplicantID = (String) MenuBarPanelVacancyManagement.tableVacancyManagement
				.getValueAt(
						MenuBarPanelVacancyManagement.tableVacancyManagement
								.getSelectedRow(), 0);
		try {
			Connection con =  Login.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from relationship WHERE applicantID = " + DataSetApplicantID );

			while (rs.next()) {
				DataSetCurriculumVitae = rs.getBoolean(7);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return DataSetCurriculumVitae;
	}
	
	public static boolean getDataSetCoveringLetter() {
		DataSetApplicantID = (String) MenuBarPanelVacancyManagement.tableVacancyManagement
				.getValueAt(
						MenuBarPanelVacancyManagement.tableVacancyManagement
								.getSelectedRow(), 0);
		try {
			Connection con =  Login.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from relationship WHERE applicantID = " + DataSetApplicantID );

			while (rs.next()) {
				DataSetCoveringLetter = rs.getBoolean(8);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return DataSetCoveringLetter;
	}
	
	
	
	
}
