package git_aptra.Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Login {
	private static int entitlement = 0;
	private static int ID;
	
	public static int login(String username, String password) {
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://185.28.20.242:3306/u474396146_db",
					"u474396146_aptra", "aptraDB");
			Statement stmt =  con.createStatement();
		    ResultSet rs = stmt.executeQuery("SELECT entitlement, employeeID from employee where BINARY loginName = '" +  username + "' AND BINARY password = '" +  password +"'" );
		    while (rs.next()) {
		        entitlement = rs.getInt(1);
		        ID = rs.getInt(2);
		        return entitlement;
		    }
		} catch (Exception e) {
			return 0;
		}
		return 0;
	}

	public static int getID(){
		return ID;
	}
	
	public static int getEntitlement(){
		return entitlement;
	}

}
