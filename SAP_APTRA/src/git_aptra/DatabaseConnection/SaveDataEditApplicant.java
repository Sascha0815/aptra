package git_aptra.DatabaseConnection;

import git_aptra.Steuerung;

import git_aptra.DialogEditApplicant.DialogEditApplicant;
import git_aptra.DialogEditApplicant.DialogEditApplicantApplication;
import git_aptra.DialogEditApplicant.DialogEditApplicantContact;
import git_aptra.DialogEditApplicant.DialogEditApplicantGeneral;
import git_aptra.MenuBar.MenuBarPanelApplicant;

import java.sql.SQLException;
import java.util.Vector;

public class SaveDataEditApplicant {

	public static void save() {
		if (DialogEditApplicantApplication.getApplication() == true
				&& DialogEditApplicantGeneral.getGeneral() == true
				&& DialogEditApplicantContact.getContact() == true) {
			try {
				Steuerung.getEditApplicationData();
				EditApplicationData.editApplicantData();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			@SuppressWarnings("rawtypes")
			Vector resultsApplicant = Steuerung
					.getInsertApplicantDataIntoTable()
					.insertApplicantDataIntoTable();
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
