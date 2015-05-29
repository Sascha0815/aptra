package git_aptra.AddEmployee;

import git_aptra.Login.Login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class InsertEmployeeDataIntoTable {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Vector insertEmployeeDataIntoTable() {
	Vector resultsEmployee = new Vector();
	try {
		Connection con =  Login.getConnection();
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
