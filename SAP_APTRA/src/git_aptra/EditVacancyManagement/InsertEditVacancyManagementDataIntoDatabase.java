package git_aptra.EditVacancyManagement;

import git_aptra.MenuBar.MenuBarPanelVacancyManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertEditVacancyManagementDataIntoDatabase {
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
					.prepareStatement("UPDATE relationship SET latestNoteType = ?, latestDate = ?, latestNote = ? WHERE applicantID =" + id);
			preparedStatement.setString(8,
					DialogEditVacancyManagementGeneral.getStatusNote());
			preparedStatement.setDate(11, new java.sql.Date(
					DialogEditVacancyManagementGeneral.getCalNote()
							.getTimeInMillis()));
			preparedStatement.setString(3,
					DialogEditVacancyManagementGeneral.getNote());

		} catch (SQLException e) {

		}
	}
}
