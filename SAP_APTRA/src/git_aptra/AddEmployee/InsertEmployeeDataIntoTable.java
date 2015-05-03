package git_aptra.AddEmployee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class InsertEmployeeDataIntoTable {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Vector insertEmployeeDataIntoTable() {
	Vector resultsEmployee = new Vector();
	try {
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://185.28.20.242:3306/u474396146_db",
				"u474396146_aptra", "aptraDB");
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("Select * from employee");

		while (rs.next()) {
			Vector employee = new Vector();
			employee.add(rs.getString(1));
			employee.add(rs.getString(2));
			employee.add(rs.getString(3));
			resultsEmployee.add(employee);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return resultsEmployee;
	}
	
}
