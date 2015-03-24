package git_aptra.DialogSearchVacancy;

public class CloseDialogSearchVacancy {
	public static void closeSearchVacancy() {
		DialogSearchVacancyGeneral.reset();
		DialogSearchVacancySpecification.reset();
		DialogSearchVacancy.dialogSearchVacancy.dispose();
	}
}
