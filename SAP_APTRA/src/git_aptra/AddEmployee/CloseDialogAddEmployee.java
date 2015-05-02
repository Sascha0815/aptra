package git_aptra.AddEmployee;

public class CloseDialogAddEmployee {
	
	public static void close() {
		DialogAddEmployeeGeneral.reset();
		DialogAddEmployee.tabAdd.removeAll();
		DialogAddEmployee.dialogNewEmployee.dispose();
	}
}
