package git_aptra.AddApplicant;

import git_aptra.Login.Login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class InsertApplicantDataIntoTable {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Vector insertApplicantDataIntoTable() {

		Vector resultsApplicant = new Vector();
		try {
			Connection con = Login.getConnection();
			Statement stmt = con.createStatement();
			if (Login.getEntitlement()<3) {
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
					applicant.add(rs.getString(9));
					applicant.add(rs.getString(10));
					applicant.add(rs.getString(11));
					applicant.add(rs.getString(12));
					applicant.add(rs.getString(13));
					applicant.add(rs.getString(14));
					resultsApplicant.add(applicant);
					}
					
				}
			

		else {
			ResultSet rs = stmt.executeQuery("Select * from applicant a inner join relationship r on r.applicantID = a.applicantID inner join vacancy v on v.vacancyID = r.vacancyID where v.divisionID = " + Login.getDivisionID());	
			
			while (rs.next()) {
				Vector applicant = new Vector();
				applicant.add(rs.getString(1));
				applicant.add(rs.getString(2));
				applicant.add(rs.getString(3));
				applicant.add(rs.getString(4));
				applicant.add(rs.getString(5));
				applicant.add(rs.getString(6));
				applicant.add(rs.getString(7));
				applicant.add(rs.getString(9));
				applicant.add(rs.getString(10));
				applicant.add(rs.getString(11));
				applicant.add(rs.getString(12));
				applicant.add(rs.getString(13));
				applicant.add(rs.getString(14));
				resultsApplicant.add(applicant);
				}
		}
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultsApplicant;
	}
}
