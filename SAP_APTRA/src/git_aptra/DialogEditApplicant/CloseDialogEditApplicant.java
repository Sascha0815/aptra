package git_aptra.DialogEditApplicant;

public class CloseDialogEditApplicant {

	public static void closeEditApplicant() {
		DialogEditApplicantApplication.reset();
		DialogEditApplicantContact.reset();
		DialogEditApplicantGeneral.reset();
		DialogEditApplicant.dialogEditApplicant.dispose();
	}
}
