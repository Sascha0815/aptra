package git_aptra.DialogApplicantSearch;

import java.sql.SQLException;
import java.util.Vector;

//import git_aptra.DatabaseConnection.SearchApplicant;
import git_aptra.DatabaseConnection.SearchVacancy;
import git_aptra.MenuBar.MenuBarPanelApplicant;

public class SearchControl {
	public static void search() throws SQLException {
		DialogSearchApplicantGeneral.getGeneral();
		DialogSearchApplicantApplication.getApplication();
		DialogSearchApplicantContact.getContact();
		@SuppressWarnings("rawtypes")
		Vector resultsApplicant = SearchVacancy.searchVacancy();
		MenuBarPanelApplicant.modelPool.setDataVector(resultsApplicant,
				MenuBarPanelApplicant.COLUMN_IDENTIFIERS_APPLICANT);
		MenuBarPanelApplicant.modelPool.fireTableDataChanged();

	}
}
