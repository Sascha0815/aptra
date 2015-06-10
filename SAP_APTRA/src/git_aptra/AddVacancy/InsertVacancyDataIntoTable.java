package git_aptra.AddVacancy;

import git_aptra.Login.Login;

import java.sql.Connection;
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
			ResultSet rs = stmt.executeQuery("Select v.vacancyID, v.position, v.area, v.requirementLevel, v.termsOfEmployment, v.vacancyStatus, v.educationalAchievement, v.level, v.date, d.notation from vacancy v inner join division d on v.divisionID = d.divisionID");

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
				vacancy.add(rs.getString(10));
				resultsVacancy.add(vacancy);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultsVacancy;
	}
}
