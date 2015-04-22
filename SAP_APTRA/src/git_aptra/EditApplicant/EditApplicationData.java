package git_aptra.EditApplicant;

import git_aptra.MenuBar.MenuBarPanelApplicant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EditApplicationData {
	public static void editApplicantData() throws SQLException {
		Connection dbConnection = null;
		int id = Integer.parseInt((String) MenuBarPanelApplicant.tableApplicant.getValueAt(MenuBarPanelApplicant.tableApplicant.getSelectedRow(), 0)) ;
		try {
			dbConnection = DriverManager.getConnection(
					"jdbc:mysql://185.28.20.242:3306/u474396146_db",
					"u474396146_aptra", "aptraDB");
		} catch (SQLException e) {
			System.out.println("Datenbank - editApplicant" + e.getMessage());
		}

		try {
			PreparedStatement preparedStatement = dbConnection
					.prepareStatement("UPDATE applicant SET name = ?, firstName = ?, "
							+ "street = ?, houseNr = ?,  postalCode= ?, city = ?, "
							+ "telefonHome = ?, telefonMobil = ?, email = ?, "
							+ "vacancy = ?, date = ?, educationalAchievement = ? "
							+ "WHERE applicantID = ?");

			preparedStatement
					.setString(1, DialogEditApplicantGeneral.getName());
			preparedStatement.setString(2,
					DialogEditApplicantGeneral.getFirstName());
			preparedStatement.setString(3,
					DialogEditApplicantGeneral.getStreet());
			preparedStatement
					.setInt(4, DialogEditApplicantGeneral.getHouseNr());
			preparedStatement.setInt(5,
					DialogEditApplicantGeneral.getPostalCode());
			preparedStatement
					.setString(6, DialogEditApplicantGeneral.getCity());
			preparedStatement.setString(7,
					DialogEditApplicantContact.getTelefonHome());
			preparedStatement.setString(8,
					DialogEditApplicantContact.getTelefonMobil());
			preparedStatement.setString(9,
					DialogEditApplicantContact.getEmail());
			preparedStatement.setString(10,
					DialogEditApplicantApplication.getVacancy());
			preparedStatement.setDate(11, new java.sql.Date(
					DialogEditApplicantApplication.getCal().getTimeInMillis()));
			preparedStatement.setString(12,
					DialogEditApplicantApplication.getEducationalAchievement());
			preparedStatement.setInt(13, id);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		}

		catch (SQLException e) {

		}

	}

}
