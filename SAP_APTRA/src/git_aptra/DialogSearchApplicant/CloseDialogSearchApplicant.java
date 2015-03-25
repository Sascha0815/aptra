package git_aptra.DialogSearchApplicant;

public class CloseDialogSearchApplicant {
	public static void closeSearchApplicant() {
		DialogSearchApplicantApplication.reset();
		DialogSearchApplicantContact.reset();
		DialogSearchApplicantGeneral.reset();
		DialogSearchApplicant.dialogSearchApplicant.dispose();
	}

}
