package git_aptra.AddEmployee;

import java.sql.SQLException;


public class SaveDataNewEmployee {
	public static void save() throws SQLException {
		DialogAddEmployeeGeneral.getGeneral();
		InsertEmployeeDataIntoDatabase.insertEmployeeData();
		CloseDialogAddEmployee.close();
	}
}
