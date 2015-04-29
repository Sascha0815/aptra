package git_aptra.EditVacancyManagement;


public class CloseDialogEditVacancyManagement {
	public static void close() {
		DialogEditVacancyManagementGeneral.reset();
		DialogEditVacancyManagementDetails.reset();
		DialogEditVacancyManagementHistory.reset();
		DialogEditVacancyManagementResponse.reset();
		DialogEditVacancyManagementMatrix.reset();
		DialogEditVacancyManagement.dialogEditVacancyManagement.dispose();
	}
}
