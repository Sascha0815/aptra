package git_aptra.AddEmployee;

import java.sql.SQLException;


public class SaveDataNewEmployee {
	public static void save() throws SQLException {
		DialogAddEmployee.getGeneral();
		InsertEmployeeDataIntoDatabase.insertEmployeeData();
		DialogAddEmployee.dialogNewEmployee.dispose();
		DialogAddEmployee.reset();
	}
}
