package git_aptra.EditApplicant;

import git_aptra.DatabaseConnection.InsertApplicantDataIntoTable;
import git_aptra.MenuBar.MenuBarPanelApplicant;

import java.sql.SQLException;
import java.util.Vector;

public class SaveDataEditApplicant {

	public static void save() {
		if (DialogEditApplicantApplication.getApplication() == true
				&& DialogEditApplicantGeneral.getGeneral() == true
				&& DialogEditApplicantContact.getContact() == true) {
			try {				
				EditApplicationData.editApplicantData();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			@SuppressWarnings("rawtypes")
			Vector resultsApplicant = InsertApplicantDataIntoTable.insertApplicantDataIntoTable();
			MenuBarPanelApplicant.modelPool.setDataVector(resultsApplicant,
					MenuBarPanelApplicant.COLUMN_IDENTIFIERS_APPLICANT);
			MenuBarPanelApplicant.modelPool.fireTableDataChanged();

			DialogEditApplicantGeneral.reset();
			DialogEditApplicantApplication.reset();
			DialogEditApplicantContact.reset();
			DialogEditApplicant.tabEdit.removeAll();
			DialogEditApplicant.dialogEditApplicant.dispose();

		}
	}
}
