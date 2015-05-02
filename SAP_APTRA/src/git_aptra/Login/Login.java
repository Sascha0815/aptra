package git_aptra.Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.sun.javafx.scene.EnteredExitedHandler;

public class Login {
	static int entitlement = 0;
	
	public static int login(String username, String password) {
		System.out.println("SELECT entitlement from employee where loginName = '" +  username + "' AND password = '" +  password +"'");
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://185.28.20.242:3306/u474396146_db",
					"u474396146_aptra", "aptraDB");
			Statement stmt =  con.createStatement();
		    ResultSet rs = stmt.executeQuery("SELECT entitlement from employee where loginName = '" +  username + "' AND password = '" +  password +"'" );
		    while (rs.next()) {
		        entitlement = rs.getInt(1);
		        return entitlement;
		    }
		} catch (Exception e) {
			return 0;
		}
		return 0;
	}
}
