package git_aptra.AddVacancy;

public class CloseDialogAddVacancy {
	public static void close() {
		DialogAddVacancyGeneral.reset();
		DialogAddVacancy.dialogNewVacancy.dispose();
	}
}
