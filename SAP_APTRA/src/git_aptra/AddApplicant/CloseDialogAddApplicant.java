package git_aptra.AddApplicant;

public class CloseDialogAddApplicant {

	public static void close() {
		DialogAddApplicantApplication.reset();
		DialogAddApplicantContact.reset();
		DialogAddApplicantGeneral.reset();
		DialogAddApplicant.tabAdd.removeAll();
		DialogAddApplicant.dialogNewApplicant.dispose();
	}

}