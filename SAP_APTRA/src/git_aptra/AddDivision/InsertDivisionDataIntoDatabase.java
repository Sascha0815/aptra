package git_aptra.AddDivision;

import git_aptra.Login.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDivisionDataIntoDatabase {
	public static void insertDivisionData(String notation) throws SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String query = "INSERT INTO division" + "(notation) VALUES" + "(?)";

		try {
			dbConnection = Login.getConnection();
			preparedStatement = dbConnection.prepareStatement(query);
			preparedStatement.setString(1, notation);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {

		}
	}
}
