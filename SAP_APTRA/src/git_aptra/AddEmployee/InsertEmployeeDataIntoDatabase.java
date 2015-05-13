package git_aptra.AddEmployee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertEmployeeDataIntoDatabase {
	public static void insertEmployeeData() throws SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String query = "INSERT INTO employee"
				+ "(name, firstName, loginName, password, entitlement) VALUES"
				+ "(?,?,?,?,?)";

		try {
			dbConnection = DriverManager.getConnection(
					"jdbc:mysql://185.28.20.242:3306/u474396146_db",
					"u474396146_aptra", "aptraDB");
			preparedStatement = dbConnection.prepareStatement(query);
			preparedStatement.setString(1, DialogAddEmployee.getName());
			preparedStatement.setString(2, DialogAddEmployee.getFirstName());
			preparedStatement.setString(3, DialogAddEmployee.getLoginName());
			preparedStatement.setString(4, DialogAddEmployee.getPassword());
			preparedStatement.setInt(5, DialogAddEmployee.getEntitlement());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out
			.println("insert problems - Datenbank - insert Employee data"
					+ e.getMessage());
		}
	}
}
