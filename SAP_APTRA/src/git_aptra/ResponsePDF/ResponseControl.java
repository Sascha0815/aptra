package git_aptra.ResponsePDF;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import git_aptra.MenuBar.MenuBarPanelVacancyManagement;

public class ResponseControl {
	private static String firstName;
	private static String name;
	private static String fullName;
	private static String street;
	private static String houseNr;
	private static String streetNr; 
	private static String postalCode;
	private static String city;
	private static String PCCity;
	private static String sex;
	
	public static void control(String type, int id){
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://185.28.20.242:3306/u474396146_db",
					"u474396146_aptra", "aptraDB");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from applicant where applicantID = " +id);

			while (rs.next()) {
				name = rs.getString(2);
				firstName = rs.getString(3);
				street = rs.getString(4);
				houseNr = (String) rs.getString(5);
				postalCode = (String) rs.getString(6);
				city = rs.getString(7);
				sex = rs.getString(8);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		fullName = firstName + " " + name;
		streetNr = street + " " + houseNr;
		PCCity = postalCode + " " + city;
		
		
		
		switch (type) {
		case "Absage":
			Rejection.rejection(fullName, streetNr, PCCity, sex, name);
			break;

		default:
			break;
		}
	}

}
