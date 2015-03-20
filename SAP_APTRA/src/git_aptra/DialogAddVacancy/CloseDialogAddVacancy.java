package git_aptra.DialogAddVacancy;

public class CloseDialogAddVacancy {
	public static void close() {
		DialogAddVacancySpecification.reset();
		DialogAddVacancyGeneral.reset();
		DialogAddVacancy.dialogNewVacancy.dispose();
	}
}
