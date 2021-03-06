package git_aptra.SearchApplicant;

import java.sql.SQLException;
import java.util.Vector;



import git_aptra.MenuBar.MenuBarPanelApplicant;

//Steuerung Suchfunktion Bewerber
public class SearchControlApplicant {
	public static void search() throws SQLException {
		DialogSearchApplicantGeneral.getGeneral();
		DialogSearchApplicantApplication.getApplication();
		DialogSearchApplicantContact.getContact();
		@SuppressWarnings("rawtypes")
		Vector resultsApplicant = SearchApplicant.searchApplicant();
		MenuBarPanelApplicant.modelPool.setDataVector(resultsApplicant,
				MenuBarPanelApplicant.COLUMN_IDENTIFIERS_APPLICANT);
		MenuBarPanelApplicant.modelPool.fireTableDataChanged();

	}
}
