package git_aptra.EditSelection;

import git_aptra.Login.Login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
//Schreibt die Daten in die Tabelle
public class InsertEditSelectionDataIntoTable {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Vector insertEditSelectionDataIntoTable() {
	Vector resultsSelection = new Vector();
	try {
		Connection con =  Login.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("Select notation from evaluation");

		while (rs.next()) {
			Vector evaluation = new Vector();
			evaluation.add(rs.getString(1));
			resultsSelection.add(evaluation);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return resultsSelection;
	}
}
