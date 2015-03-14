package git_aptra.DatabaseConnection;

import git_aptra.MenuBar.MenuBarPanelApplicant;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class InsertVacancyDataIntoTable {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected Vector insertVacancyDataIntoTable() {

		Vector resultsVacancy = new Vector();
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://185.28.20.242:3306/u474396146_db",
					"u474396146_aptra", "aptraDB");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from vacancy");

			while (rs.next()) {
				Vector applicant = new Vector();
				applicant.add(rs.getString(1));
				applicant.add(rs.getString(2));
				applicant.add(rs.getString(3));
				applicant.add(rs.getString(4));
				resultsVacancy.add(applicant);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		MenuBarPanelApplicant.tableApplicant.setAutoCreateRowSorter(true);
		return resultsVacancy;
	}

}
