package git_aptra.DialogAddApplicant;

public class CloseDialogApplicant {

	public static void closeAddApplicant(){
		DialogAddApplicantApplication.reset();
		DialogAddApplicantContact.reset();
		DialogAddApplicantGeneral.reset();
		DialogAddApplicant.dialogNewApplicant.dispose();
	}
		
}
