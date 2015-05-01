package git_aptra.EditVacancyManagement;

import git_aptra.MenuBar.MenuBarPanelVacancyManagement;
import git_aptra.VacancyManagement.DialogOpenVacancy;
import git_aptra.VacancyManagement.OpenVacancy;

import java.util.Vector;


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
