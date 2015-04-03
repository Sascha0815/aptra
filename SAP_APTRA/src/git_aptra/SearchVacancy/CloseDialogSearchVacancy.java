package git_aptra.SearchVacancy;

public class CloseDialogSearchVacancy {
	public static void closeSearchVacancy() {
		DialogSearchVacancyGeneral.reset();
		DialogSearchVacancySpecification.reset();
		DialogSearchVacancy.dialogSearchVacancy.dispose();
	}
}
