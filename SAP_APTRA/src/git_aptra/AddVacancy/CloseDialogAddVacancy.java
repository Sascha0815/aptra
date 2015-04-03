package git_aptra.AddVacancy;

public class CloseDialogAddVacancy {
	public static void close() {
		DialogAddVacancySpecification.reset();
		DialogAddVacancyGeneral.reset();
		DialogAddVacancy.dialogNewVacancy.dispose();
	}
}
