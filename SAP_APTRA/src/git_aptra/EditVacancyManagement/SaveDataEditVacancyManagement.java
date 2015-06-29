package git_aptra.EditVacancyManagement;
//Steuerung des Speichervorgangs
public class SaveDataEditVacancyManagement {
	public static void save(){
		DialogEditVacancyManagementGeneral.getGeneral();
		DialogEditVacancyManagementResponse.getResponse();
		DialogEditVacancyManagement.dialogEditVacancyManagement.dispose();
	}
	
}
