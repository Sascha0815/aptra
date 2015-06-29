package git_aptra.AddEmployee;

import git_aptra.Login.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//Speichert die Daten der neuen Mitarbieter
public class InsertEmployeeDataIntoDatabase {
	public static void insertEmployeeData(String name, String firstName, String loginName, String password, int entitlement, int divisionID) throws SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String query = "INSERT INTO employee"
				+ "(name, firstName, loginName, password, entitlement, divisionID) VALUES"
				+ "(?,?,?,?,?,?)";

		try {
			dbConnection = Login.getConnection();
			preparedStatement = dbConnection.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, firstName);
			preparedStatement.setString(3, loginName);
			preparedStatement.setString(4, password);
			preparedStatement.setInt(5, entitlement);
			preparedStatement.setInt(6, divisionID);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
		}
	}
}
