package git_aptra.EditSelection;

import git_aptra.Login.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//Speichert die neuen Daten in die Datenbank
public class InsertEditSelectionDataIntoDatebase {
	public static void insertSelectionData(String notation, String weighting) throws SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String query = "INSERT INTO evaluation"
				+ "(notation) VALUES"
				+ "(?)";

		try {
			dbConnection = Login.getConnection();
			preparedStatement = dbConnection.prepareStatement(query);
			preparedStatement.setString(1, notation);
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("insert problems - Datenbank - insert Selection data"+ e.getMessage());
		}
	}
}
