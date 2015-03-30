package git_aptra.DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class InsertManagementDataIntoTable {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Vector insertManagementDataIntoTable() {

		Vector resultsVacancyManagement = new Vector();
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://185.28.20.242:3306/u474396146_db",
					"u474396146_aptra", "aptraDB");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select name,firstName from applicant");

			while (rs.next()) {
				Vector vacancyManagement = new Vector();
				vacancyManagement.add(rs.getString(1));
				vacancyManagement.add(rs.getString(2));
				
				resultsVacancyManagement.add(vacancyManagement);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultsVacancyManagement;
	}
}
