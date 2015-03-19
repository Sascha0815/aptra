package git_aptra.DialogAddApplicant;

public class CloseDialogAddApplicant {

	public static void close() {
		DialogAddApplicantApplication.reset();
		DialogAddApplicantContact.reset();
		DialogAddApplicantGeneral.reset();
		DialogAddApplicant.dialogNewApplicant.dispose();
	}

}
