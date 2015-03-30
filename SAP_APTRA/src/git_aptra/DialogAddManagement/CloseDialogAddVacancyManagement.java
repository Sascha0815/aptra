package git_aptra.DialogAddManagement;


public class CloseDialogAddVacancyManagement {

	public static void close() {
		DialogAddVacancyManagementGeneral.reset();
		DialogAddVacancyManagement.dialogAddVacancyManagement.dispose();
	}
}
