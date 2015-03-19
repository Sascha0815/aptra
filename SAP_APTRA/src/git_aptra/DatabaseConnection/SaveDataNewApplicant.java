package git_aptra.DatabaseConnection;

import git_aptra.Steuerung;
import git_aptra.DialogAddApplicant.DialogAddApplicant;
import git_aptra.DialogAddApplicant.DialogAddApplicantApplication;
import git_aptra.DialogAddApplicant.DialogAddApplicantContact;
import git_aptra.DialogAddApplicant.DialogAddApplicantGeneral;
import git_aptra.MenuBar.MenuBarPanelApplicant;

import java.sql.SQLException;
import java.util.Vector;

public class SaveDataNewApplicant {
	public static void save() {
		if (DialogAddApplicantGeneral.getGeneral() == true
				&& DialogAddApplicantApplication.getApplication() == true
				&& DialogAddApplicantContact.getContact() == true) {
			try {
				InsertApplicantDataIntoTable.insertApplicantDataIntoTable();
				InsertApplicationData.insertApplicantData();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			@SuppressWarnings("rawtypes")
			Vector resultsApplicant = InsertApplicantDataIntoTable.insertApplicantDataIntoTable();
			MenuBarPanelApplicant.modelPool.setDataVector(resultsApplicant,
					MenuBarPanelApplicant.COLUMN_IDENTIFIERS_APPLICANT);
			MenuBarPanelApplicant.modelPool.fireTableDataChanged();

			DialogAddApplicantGeneral.reset();
			DialogAddApplicantApplication.reset();
			DialogAddApplicantContact.reset();
			DialogAddApplicant.tabAdd.removeAll();
			DialogAddApplicant.dialogNewApplicant.dispose();

		}
	}

}
