package git_aptra.AddEmployee;

import git_aptra.Login.Login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

//Vorbereitung f�r geplante Funktionen
public class InsertEmployeeDataIntoTable {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Vector insertEmployeeDataIntoTable() {
	String query;
	if (Login.getEntitlement()<3) {
		query = "Select * from employee";
	}
	else {
		query = "Select * from employee where divisionID = " + Login.getDivisionID();
	}
	Vector resultsEmployee = new Vector();
	try {
		Connection con =  Login.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);

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
