package git_aptra.DialogSearchVacancy;

import java.sql.SQLException;
import java.util.Vector;

import git_aptra.DatabaseConnection.SearchVacancy;
import git_aptra.MenuBar.MenuBarPanelWorkplace;

public class SearchControlVacancy {
	public static void searchVacancy() throws SQLException{
		DialogSearchVacancyGeneral.getGeneral();
		DialogSearchVacancySpecification.getSpecification();
		@SuppressWarnings("rawtypes")
		Vector resultsVacancy = SearchVacancy.searchVacancy();
		MenuBarPanelWorkplace.modelJob.setDataVector(resultsVacancy,
				MenuBarPanelWorkplace.COLUMN_IDENTIFIERS_JOB);
		MenuBarPanelWorkplace.modelJob.fireTableDataChanged();
		CloseDialogSearchVacancy.closeSearchVacancy();
	}

}
