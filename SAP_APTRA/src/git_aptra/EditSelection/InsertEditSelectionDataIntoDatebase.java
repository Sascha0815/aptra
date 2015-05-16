package git_aptra.EditSelection;

import git_aptra.AddVacancy.DialogAddVacancyGeneral;
import git_aptra.AddVacancy.DialogAddVacancySpecification;
import git_aptra.Meeting.DialogDetailsMeeting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertEditSelectionDataIntoDatebase {
	public static void insertEditSelectionData() throws SQLException {
			
		int []rows = DialogEditSelectionGeneral.tableEditSelection.getSelectedRows();
		
		for (int i = 0; i < rows.length; i++) {
			int id = Integer.parseInt((String) DialogEditSelectionGeneral.tableEditSelection.getValueAt(i, 0));
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
				
				preparedStatement.setString(id, query);
				
		
				preparedStatement.executeUpdate();
				preparedStatement.close();
				
			} catch (SQLException e) {
				System.out
						.println("insert problems - Datenbank - insert evaluation data"
								+ e.getMessage());
			}
		}
	}
}
