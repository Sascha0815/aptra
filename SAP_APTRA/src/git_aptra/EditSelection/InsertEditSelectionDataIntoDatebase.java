package git_aptra.EditSelection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertEditSelectionDataIntoDatebase {
	public static void insertSelectionData(String notation, String weighting) throws SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String query = "INSERT INTO evaluation"
				+ "(notation) VALUES"
				+ "(?)";

		try {
			dbConnection = DriverManager.getConnection(
					"jdbc:mysql://185.28.20.242:3306/u474396146_db",
					"u474396146_aptra", "aptraDB");
			preparedStatement = dbConnection.prepareStatement(query);
			preparedStatement.setString(1, notation);
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("insert problems - Datenbank - insert Selection data"+ e.getMessage());
		}
	}
}
