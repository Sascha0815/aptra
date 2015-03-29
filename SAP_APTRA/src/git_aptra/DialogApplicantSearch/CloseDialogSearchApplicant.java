package git_aptra.DialogApplicantSearch;

public class CloseDialogSearchApplicant {
	public static void closeSearchApplicant() {
		DialogSearchApplicantApplication.reset();
		DialogSearchApplicantContact.reset();
		DialogSearchApplicantGeneral.reset();
		DialogSearchApplicant.dialogSearchApplicant.dispose();
	}

}
