package git_aptra.AddVacancy;

import git_aptra.Login.Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class InsertVacancyDataIntoTable {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Vector insertVacancyDataIntoTable() {

		Vector resultsVacancy = new Vector();
		try {
			Connection con =  Login.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from vacancy");

			while (rs.next()) {
				Vector vacancy = new Vector();
				vacancy.add(rs.getString(1));
				vacancy.add(rs.getString(2));
				vacancy.add(rs.getString(3));
				vacancy.add(rs.getString(4));
				vacancy.add(rs.getString(5));
				vacancy.add(rs.getString(6));
				vacancy.add(rs.getString(7));
				vacancy.add(rs.getString(8));
				vacancy.add(rs.getString(9));
				resultsVacancy.add(vacancy);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultsVacancy;
	}
}
