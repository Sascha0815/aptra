package git_aptra.EditVacancyManagement;

public class SaveDataEditVacancyManagement {
	public static void save(){
		DialogEditVacancyManagementGeneral.getGeneral();
		DialogEditVacancyManagementResponse.getResponse();
		DialogEditVacancyManagement.dialogEditVacancyManagement.dispose();
	}
	
}
