package git_aptra.InfoApplicant;


public class CloseDialogInfoApplicant {
	public static void close() {
		DialogInfoApplicantGeneral.reset();
		DialogInfoApplicantApplication.reset();
		DialogInfoApplicantContact.reset();
		DialogInfoApplicantDetails.reset();
		DialogInfoApplicantHistory.reset();
		DialogInfoApplicant.tabInfo.removeAll();
		DialogInfoApplicant.dialogInfoApplicant.dispose();
	}
}
