package git_aptra.DialogEditVacancy;

public class CloseDialogEditVacancy {

	public static void close() {
		DialogEditVacancyGeneral.reset();
		DialogEditVacancySpecification.reset();
		DialogEditVacancy.dialogEditVacancy.dispose();
	}
}