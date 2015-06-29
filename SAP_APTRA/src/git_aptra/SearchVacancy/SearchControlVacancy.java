package git_aptra.SearchVacancy;

import java.sql.SQLException;
import java.util.Vector;

import git_aptra.MenuBar.MenuBarPanelVacancy;
//Steuerung der Suchabläufe
public class SearchControlVacancy {
	public static void searchVacancy() throws SQLException{
		DialogSearchVacancyGeneral.getGeneral();
		DialogSearchVacancySpecification.getSpecification();
		@SuppressWarnings("rawtypes")
		Vector resultsVacancy = SearchVacancy.searchVacancy();
		MenuBarPanelVacancy.modelJob.setDataVector(resultsVacancy,
				MenuBarPanelVacancy.COLUMN_IDENTIFIERS_JOB);
		MenuBarPanelVacancy.modelJob.fireTableDataChanged();
	}

}
