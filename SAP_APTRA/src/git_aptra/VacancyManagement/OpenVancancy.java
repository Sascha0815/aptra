package git_aptra.VacancyManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class OpenVancancy {
	@SuppressWarnings("rawtypes")
	public static Vector openVacancy(int id) {
		Vector resultsOpenVacancy = new Vector();
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://185.28.20.242:3306/u474396146_db",
					"u474396146_aptra", "aptraDB");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT applicant.applicantID, applicant.name, applicant.firstName, relationship.status, relationship.dateConversation FROM applicant INNER JOIN relationship ON applicant.applicantID = relationship.applicantID where relationship.vacancyID =" + id);
			while (rs.next()) {
				Vector vacancy = new Vector();
				vacancy.add(rs.getString(1));
				vacancy.add(rs.getString(2));
				vacancy.add(rs.getString(3));
				vacancy.add(rs.getString(4));
				vacancy.add(rs.getString(5));
				resultsOpenVacancy.add(vacancy);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultsOpenVacancy;
	}
}
