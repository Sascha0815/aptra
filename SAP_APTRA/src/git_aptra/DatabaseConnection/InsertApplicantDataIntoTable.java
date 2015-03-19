package git_aptra.DatabaseConnection;

import git_aptra.MenuBar.MenuBarPanelApplicant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class InsertApplicantDataIntoTable {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Vector insertApplicantDataIntoTable() {

		Vector resultsApplicant = new Vector();
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://185.28.20.242:3306/u474396146_db",
					"u474396146_aptra", "aptraDB");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from applicant");

			while (rs.next()) {
				Vector applicant = new Vector();
				applicant.add(rs.getString(1));
				applicant.add(rs.getString(2));
				applicant.add(rs.getString(3));
				applicant.add(rs.getString(4));
				applicant.add(rs.getString(5));
				applicant.add(rs.getString(6));
				applicant.add(rs.getString(7));
				applicant.add(rs.getString(8));
				applicant.add(rs.getString(9));
				applicant.add(rs.getString(10));
				applicant.add(rs.getString(11));
				applicant.add(rs.getString(12));
				applicant.add(rs.getString(13));
				resultsApplicant.add(applicant);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return resultsApplicant;
	}
}
