package git_aptra.EditVacancy;

public class CloseDialogEditVacancy {

	public static void close() {
		DialogEditVacancyGeneral.reset();
		DialogEditVacancySpecification.reset();
		DialogEditVacancy.dialogEditVacancy.dispose();
	}
}