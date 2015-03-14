package git_aptra;

public class CloseDialogApplicant {

	public static void close(){
		DialogAddApplicantApplication.reset();
		DialogAddApplicantContact.reset();
		DialogAddApplicantGeneral.reset();
		DialogAddApplicant.dialogNewApplicant.dispose();
	}
	
	
}
