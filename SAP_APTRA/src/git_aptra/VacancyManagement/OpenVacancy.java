package git_aptra.VacancyManagement;

import git_aptra.MenuBar.MenuBarPanelVacancyManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class OpenVacancy {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Vector openVacancy(int id) {
		Vector resultsOpenVacancy = new Vector();
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://185.28.20.242:3306/u474396146_db",
					"u474396146_aptra", "aptraDB");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT applicant.applicantID, applicant.name, applicant.firstName, relationship.status, relationship.latestNoteType, relationship.latestDate, relationship.latestNote, scoreImpression+scoreExperience+scoreSocialEngagement FROM applicant INNER JOIN relationship ON applicant.applicantID = relationship.applicantID where relationship.vacancyID ="
							+ id);
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

				resultsOpenVacancy.add(vacancy);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultsOpenVacancy;
	}
	private static String date;
	private static String position;
	private static String area;
	private static String requirementLevel;
	private static String termsOfEmployment;
	private static String vacancyStatus;
	private static String educationalAchievement;


	public static void insertInfo(int id){
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://185.28.20.242:3306/u474396146_db",
					"u474396146_aptra", "aptraDB");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select position, area, requirementLevel, termsOfEmployment, vacancyStatus, educationalAchievement, date from vacancy where vacancyID =" + id);

			while (rs.next()) {
				
				position = rs.getString(1);
				area = rs.getString(2);
				requirementLevel = rs.getString(3);
				termsOfEmployment = rs.getString(4);
				vacancyStatus = rs.getString(5);
				educationalAchievement = rs.getString(6);
				date = rs.getString(7);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String count = Integer.toString(MenuBarPanelVacancyManagement.tableVacancyManagement.getRowCount());
		MenuBarPanelVacancyManagement.labelManagementCountContent.setText(count);
		MenuBarPanelVacancyManagement.labelManagementEndOfApplyContent.setText(date);
		MenuBarPanelVacancyManagement.labelManagementPositionContent.setText(position);
		MenuBarPanelVacancyManagement.labelManagementAreaContent.setText(area);
		MenuBarPanelVacancyManagement.labelManagementRequirementLevelContent.setText(requirementLevel);
		MenuBarPanelVacancyManagement.labelManagementVacancyStatusContent.setText(vacancyStatus);
		MenuBarPanelVacancyManagement.labelManagementEducationalAchievementContent.setText(educationalAchievement);
		MenuBarPanelVacancyManagement.labelManagementTermsOfEmploymentContent.setText(termsOfEmployment);
		
	}
}
