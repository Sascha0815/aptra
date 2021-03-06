package git_aptra.EditVacancyManagement;

import git_aptra.Login.Login;
import git_aptra.MenuBar.MenuBarPanelVacancyManagement;
import git_aptra.VacancyManagement.DialogOpenVacancy;
import git_aptra.VacancyManagement.OpenVacancy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
//Speichert die Daten in die Datenbank

public class InsertEditVacancyManagementDataIntoDatabase {
	
	
	
	static String response = "Rückmeldung versandt";
	private static int IDEmployee = Login.getID();	
	private static String name;
	private static String firstName;
	private static String fullName;
	public static void insertEditVacancyManagementData() throws SQLException {
		try {
			Connection con = Login.getConnection();
			Statement stmt =  con.createStatement();
		    ResultSet rs = stmt.executeQuery("SELECT name, firstName from employee where employeeID = " +  IDEmployee );
		    while (rs.next()) {
		        name = rs.getString(1);
		        firstName = rs.getString(2);
		        fullName = firstName + " " +name;
		    }
		} catch (Exception e) {
			System.out.println("Fehler auslesen des aktuellen Users" +e.getMessage());
		}
		
		
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
			dbConnection = Login.getConnection();
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
			preparedStatement.setString(5, fullName);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out
					.println("insert problems - Datenbank - insert edit vacancy management data"
							+ e.getMessage());
		}

		dbConnection = Login.getConnection();

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

	
	public static void insertEditVacancyManagementDataResponse() throws SQLException {
		try {
			Connection con = Login.getConnection();
			Statement stmt =  con.createStatement();
		    ResultSet rs = stmt.executeQuery("SELECT name, firstName from employee where employeeID = " +  IDEmployee );
		    while (rs.next()) {
		        name = rs.getString(1);
		        firstName = rs.getString(2);
		        fullName = firstName + " " +name;
		    }
		} catch (Exception e) {
			System.out.println("Fehler auslesen des aktuellen Users" +e.getMessage());
		}
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
			dbConnection = Login.getConnection();
			preparedStatement = dbConnection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.valueOf(EditVacancyManagement
					.getDataSetApplicantID()));
			preparedStatement.setString(2,
					DialogEditVacancyManagementResponse.getResponseType());
			preparedStatement.setDate(3, new java.sql.Date(System.currentTimeMillis()));
			preparedStatement.setString(4, response);
			preparedStatement.setString(5, fullName);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out
					.println("insert problems - Datenbank - insert edit vacancy management data(response)"
							+ e.getMessage());
		}

		dbConnection = Login.getConnection();

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
	@SuppressWarnings("rawtypes")
	public static void insertEditVacancyManagementDataMatrix(int amount, Vector notations) {
		Vector scores = new Vector();
		scores = DialogEditVacancyManagementMatrix.getScore();
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		String query;
		for (int i = 0; i < amount; i++) {
			query = ("UPDATE rating SET score = " + scores.elementAt(i)+ " WHERE vacancyID = " + DialogOpenVacancy.getID() + " AND notation = '" +notations.elementAt(i) + "' AND applicantID = " + MenuBarPanelVacancyManagement.getIDApplicant());
				try {
						dbConnection = Login.getConnection();
						preparedStatement = dbConnection.prepareStatement(query);						
						preparedStatement.executeUpdate();

				} catch (SQLException e) {
						System.out
								.println("insert problems - Datenbank - insert edit vacancy management data(matrix)"
										+ e.getMessage());
				}
		}

		
		Vector resultsVacancy = OpenVacancy.openVacancy(DialogOpenVacancy.getID(), amount);						
		MenuBarPanelVacancyManagement.modelVacancyManagement.setDataVector(resultsVacancy, MenuBarPanelVacancyManagement.COLUMN_IDENTIFIERS_VACANCYMANAGEMENT);
	}



}
