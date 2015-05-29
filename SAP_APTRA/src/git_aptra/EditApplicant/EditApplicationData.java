package git_aptra.EditApplicant;

import git_aptra.AddApplicant.DialogAddApplicantContact;
import git_aptra.Login.Login;
import git_aptra.MenuBar.MenuBarPanelApplicant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EditApplicationData {
	public static void editApplicantData() throws SQLException {
		Connection dbConnection = null;
		int id = Integer.parseInt((String) MenuBarPanelApplicant.tableApplicant.getValueAt(MenuBarPanelApplicant.tableApplicant.getSelectedRow(), 0)) ;
		dbConnection = Login.getConnection();

		try {
			PreparedStatement preparedStatement = dbConnection
					.prepareStatement("UPDATE applicant SET name = ?, firstName = ?, "
							+ "street = ?, houseNr = ?,  postalCode= ?, city = ?, "
							+ "telefonHome = ?, telefonMobil = ?, email = ?, "
							+ "vacancy = ?, date = ?, educationalAchievement = ? , division = ?"
							+ "WHERE applicantID = ?");

			preparedStatement.setString(1, DialogEditApplicantGeneral.getName());
			preparedStatement.setString(2,DialogEditApplicantGeneral.getFirstName());
			preparedStatement.setString(3,DialogEditApplicantGeneral.getStreet());
			preparedStatement.setInt(4, DialogEditApplicantGeneral.getHouseNr());
			preparedStatement.setInt(5,DialogEditApplicantGeneral.getPostalCode());
			preparedStatement.setString(6, DialogEditApplicantGeneral.getCity());
			preparedStatement.setString(7,DialogEditApplicantContact.getTelefonHome());
			preparedStatement.setString(8,DialogEditApplicantContact.getTelefonMobil());
			preparedStatement.setString(9,DialogEditApplicantContact.getEmail());
			preparedStatement.setString(10,DialogEditApplicantApplication.getVacancy());
			preparedStatement.setDate(11, new java.sql.Date(DialogAddApplicantContact.getCal().getTimeInMillis()));
			preparedStatement.setString(12,DialogEditApplicantApplication.getEducationalAchievement());
			preparedStatement.setString(13,DialogEditApplicantApplication.getDivision());
			preparedStatement.setInt(14, id);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		
		}catch (SQLException e) {
		}
	}
}
