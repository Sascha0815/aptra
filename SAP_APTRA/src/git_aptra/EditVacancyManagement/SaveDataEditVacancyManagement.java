package git_aptra.EditVacancyManagement;

public class SaveDataEditVacancyManagement {
	public static void save(){
		DialogEditVacancyManagementGeneral.getGeneral();
		DialogEditVacancyManagementDetails.getDetails();
		DialogEditVacancyManagementResponse.getResponse();
		DialogEditVacancyManagement.dialogEditVacancyManagement.dispose();
	}
	
}
