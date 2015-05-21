package git_aptra.EditSelection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class InsertEditSelectionDataIntoTable {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Vector insertEditSelectionDataIntoTable() {
	Vector resultsSelection = new Vector();
	try {
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://185.28.20.242:3306/u474396146_db",
				"u474396146_aptra", "aptraDB");
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
