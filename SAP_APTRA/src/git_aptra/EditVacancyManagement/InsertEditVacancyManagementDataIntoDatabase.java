package git_aptra.EditVacancyManagement;

import git_aptra.MenuBar.MenuBarPanelVacancyManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class InsertEditVacancyManagementDataIntoDatabase {
	
	
	
	static String response = "Rückmeldung versandt";

	public static void insertEditVacancyManagementData() throws SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		String id = (String) MenuBarPanelVacancyManagement.tableVacancyManagement
				.getValueAt(
						MenuBarPanelVacancyManagement.tableVacancyManagement
								.getSelectedRow(), 0);

		String query = "INSERT INTO notes"
				+ "(applicantID, noteType, date, note, employee) VALUES"
				+ "(?,?,?,?,?)";

		try {
			dbConnection = DriverManager.getConnection(
					"jdbc:mysql://185.28.20.242:3306/u474396146_db",
					"u474396146_aptra", "aptraDB");
			preparedStatement = dbConnection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.valueOf(EditVacancyManagement
					.getDataSetApplicantID()));
			preparedStatement.setString(2,
					DialogEditVacancyManagementGeneral.getStatusNote());
			preparedStatement.setDate(3, new java.sql.Date(
					DialogEditVacancyManagementGeneral.getCalNote()
							.getTimeInMillis()));
			preparedStatement.setString(4,
					DialogEditVacancyManagementGeneral.getNote());
			preparedStatement.setString(5,
					DialogEditVacancyManagementGeneral.getEmployee());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out
					.println("insert problems - Datenbank - insert edit vacancy management data"
							+ e.getMessage());
		}

		try {
			dbConnection = DriverManager.getConnection(
					"jdbc:mysql://185.28.20.242:3306/u474396146_db",
					"u474396146_aptra", "aptraDB");
		} catch (SQLException e) {
			System.out.println("Datenbank - editApplicant" + e.getMessage());
		}

		try {
			PreparedStatement ps = dbConnection
					.prepareStatement("UPDATE relationship SET latestNoteType = ?, latestDate = ?, latestNote = ? WHERE applicantID ="
							+ id);
			ps.setString(1, DialogEditVacancyManagementGeneral.getStatusNote());
			ps.setDate(2, new java.sql.Date(DialogEditVacancyManagementGeneral
					.getCalNote().getTimeInMillis()));
			ps.setString(3, DialogEditVacancyManagementGeneral.getNote());
			ps.executeUpdate();
		} catch (SQLException e) {

		}

	}

	public static void insertEditVacancyManagementDataDetails()
			throws SQLException {
		Connection dbConnection = null;
		String id = (String) MenuBarPanelVacancyManagement.tableVacancyManagement
				.getValueAt(
						MenuBarPanelVacancyManagement.tableVacancyManagement
								.getSelectedRow(), 0);
		try {
			dbConnection = DriverManager.getConnection(
					"jdbc:mysql://185.28.20.242:3306/u474396146_db",
					"u474396146_aptra", "aptraDB");
		} catch (SQLException e) {
			System.out.println("Datenbank - editApplicant" + e.getMessage());
		}

		try {
			PreparedStatement ps = dbConnection
					.prepareStatement("UPDATE relationship SET impressionApplicant = ?, impressionApplication = ?, curriculumVitae = ?, coveringLetter = ? WHERE applicantID ="
							+ id);
			ps.setString(1,
					DialogEditVacancyManagementDetails.getMarkApplicant());
			ps.setString(2,
					DialogEditVacancyManagementDetails.getMarkApplication());
			ps.setBoolean(3, DialogEditVacancyManagementDetails.getCL());
			ps.setBoolean(4, DialogEditVacancyManagementDetails.getCV());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(DialogEditVacancyManagementDetails
					.getMarkApplicant());
			System.out.println("Datenbank - editApplicant" + e.getMessage());
		}
	}

	public static void insertEditVacancyManagementDataResponse() {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		String id = (String) MenuBarPanelVacancyManagement.tableVacancyManagement
				.getValueAt(
						MenuBarPanelVacancyManagement.tableVacancyManagement
								.getSelectedRow(), 0);

		String query = "INSERT INTO notes"
				+ "(applicantID, noteType, date, note, employee) VALUES"
				+ "(?,?,?,?,?)";

		try {
			dbConnection = DriverManager.getConnection(
					"jdbc:mysql://185.28.20.242:3306/u474396146_db",
					"u474396146_aptra", "aptraDB");
			preparedStatement = dbConnection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.valueOf(EditVacancyManagement
					.getDataSetApplicantID()));
			preparedStatement.setString(2,
					DialogEditVacancyManagementResponse.getResponseType());
			preparedStatement.setDate(3, new java.sql.Date(System.currentTimeMillis()));
			preparedStatement.setString(4, response);
			preparedStatement.setString(5,
					DialogEditVacancyManagementResponse.getName());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out
					.println("insert problems - Datenbank - insert edit vacancy management data(response)"
							+ e.getMessage());
		}

		try {
			dbConnection = DriverManager.getConnection(
					"jdbc:mysql://185.28.20.242:3306/u474396146_db",
					"u474396146_aptra", "aptraDB");
		} catch (SQLException e) {
			System.out.println("Datenbank - editApplicant" + e.getMessage());
		}

		try {
			PreparedStatement ps = dbConnection
					.prepareStatement("UPDATE relationship SET latestNoteType = ?, latestDate = ?, latestNote = ? WHERE applicantID ="
							+ id);
			ps.setString(1,
					DialogEditVacancyManagementResponse.getResponseType());
			ps.setDate(2, new java.sql.Date(System.currentTimeMillis()));
			ps.setString(3, response);
			ps.executeUpdate();
		} catch (SQLException e) {

		}
	}
	public static void insertEditVacancyManagementDataMatrix() {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		String id = (String) MenuBarPanelVacancyManagement.tableVacancyManagement
				.getValueAt(
						MenuBarPanelVacancyManagement.tableVacancyManagement
								.getSelectedRow(), 0);
		String query = ("UPDATE relationship SET scoreImpression = ? , scoreExperience = ?, "
				+ "scoreSocialEngagement = ? WHERE applicantID = " +id);

		try {
			dbConnection = DriverManager.getConnection(
					"jdbc:mysql://185.28.20.242:3306/u474396146_db",
					"u474396146_aptra", "aptraDB");
			preparedStatement = dbConnection.prepareStatement(query);
			preparedStatement.setInt(1, DialogEditVacancyManagementMatrix.getScoreImpression());
			preparedStatement.setInt(2, DialogEditVacancyManagementMatrix.getScoreExperience());
			preparedStatement.setInt(3, DialogEditVacancyManagementMatrix.getScoreSocialEngagement());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out
					.println("insert problems - Datenbank - insert edit vacancy management data(matrix)"
							+ e.getMessage());

	}
	}



}
