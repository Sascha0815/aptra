package git_aptra.DatabaseConnection;

import git_aptra.DialogSearch.DialogSearchApplicantApplication;
import git_aptra.DialogSearch.DialogSearchApplicantContact;
import git_aptra.DialogSearch.DialogSearchApplicantGeneral;
import git_aptra.MenuBar.MenuBarPanelApplicant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;



public class SearchApplicant {
	
	private static String name;
	private static String firstName;
	private static String street;
	private static String houseNr;
	private static String postalCode;
	private static String city;	
	private static String telefonHome;
	private static String telefonMobil;
	private static String email;
	private static String vacancy;
	private static String educationalAcievement;
	

	public static Vector searchApplicant() throws SQLException {
		Connection dbConnection = null;
		Vector resultsSearchApplicant = new Vector();
		if (!DialogSearchApplicantApplication.getEducationalAchievement().equals("")) {
			educationalAcievement = " AND educationalAchievement = '" + DialogSearchApplicantApplication.getEducationalAchievement() +"'";
		}
		else {
			educationalAcievement = "";
		}
		if (!DialogSearchApplicantApplication.getVacancy().equals("")) {
			vacancy = " AND vacancy = '" + DialogSearchApplicantApplication.getVacancy() +"'";
		}
		else {
			vacancy = "";
		}
		if (!DialogSearchApplicantContact.getEmail().equals("")) {
			email = " AND email = '" + DialogSearchApplicantContact.getEmail() +"'";
		}
		else {
			email = "";
		}
		if (!DialogSearchApplicantContact.getTelefonMobil().equals("")) {
			telefonMobil = " AND telefonMobil = '" + DialogSearchApplicantContact.getTelefonMobil() +"'";
		}
		else {
			telefonMobil = "";
		}
		if (!DialogSearchApplicantContact.getTelefonHome().equals("")) {
			telefonHome = " AND telefonHome = '" + DialogSearchApplicantContact.getTelefonHome() +"'";
		}
		else {
			telefonHome = "";
		}
		if (!DialogSearchApplicantGeneral.getName().equals("")) {
			name = " name = '" + DialogSearchApplicantGeneral.getName() +"'";
		}
		else {
			name = "";
		}
		if (!DialogSearchApplicantGeneral.getFirstName().equals("")) {
			firstName = " AND firstName = '" + DialogSearchApplicantGeneral.getFirstName() +"'";
		}
		else {
			firstName = "";
		}
		if (!DialogSearchApplicantGeneral.getStreet().equals("")) {
			street = " AND street = '" + DialogSearchApplicantGeneral.getStreet() +"'";
		}
		else {
			street = "";
		}
		if (!(DialogSearchApplicantGeneral.getHouseNr()==0)) {
			houseNr = " AND houseNR = '" + DialogSearchApplicantGeneral.getHouseNr() +"'";
		}
		else {
			houseNr = "";
		}
		if (!(DialogSearchApplicantGeneral.getPostalCode()==0)) {
			postalCode = " AND postalCode = '" + DialogSearchApplicantGeneral.getHouseNr() +"'";
		}
		else {
			postalCode = "";
		}
		if (!DialogSearchApplicantGeneral.getCity().equals("")) {
			city = " AND city = '" + DialogSearchApplicantGeneral.getCity() +"'";
		}
		else {
			city = "";
		}
		
		//System.out.println("select * from applicant where " + name + firstName + street + houseNr + postalCode + city + telefonHome + telefonMobil + email + vacancy + educationalAcievement);
		try {
			dbConnection = DriverManager.getConnection(
					"jdbc:mysql://185.28.20.242:3306/u474396146_db",
					"u474396146_aptra", "aptraDB");
			
			Statement stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from applicant where " + name + firstName + street + houseNr + postalCode + city + telefonHome + telefonMobil + email + vacancy + educationalAcievement);
			
			
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
				resultsSearchApplicant.add(applicant);
			}
				
		} catch (SQLException e) {
			System.out.println("Datenbank - searchApplicant" + e.getMessage());
		}
		
		
		
		MenuBarPanelApplicant.tableApplicant.setAutoCreateRowSorter(true);
		return resultsSearchApplicant;
		
}
	
}
