package git_aptra.DialogSearch;

import java.sql.SQLException;
import java.util.Vector;

import git_aptra.DatabaseConnection.SearchApplicant;
import git_aptra.MenuBar.MenuBarPanelApplicant;

public class SearchControl {
	public static void search() throws SQLException{
		DialogSearchApplicantGeneral.getSelected();
		DialogSearchApplicantApplication.getApplication();
		DialogSearchApplicantContact.getContact();
		SearchApplicant.searchApplicant();
		Vector resultsApplicant = SearchApplicant.searchApplicant();
		MenuBarPanelApplicant.modelPool.setDataVector(resultsApplicant,
				MenuBarPanelApplicant.COLUMN_IDENTIFIERS_APPLICANT);
		MenuBarPanelApplicant.modelPool.fireTableDataChanged();
		//CloseDialogSearchApplicant.closeSearchApplicant();
	}
}
