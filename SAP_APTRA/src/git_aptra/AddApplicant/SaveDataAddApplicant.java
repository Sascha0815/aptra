package git_aptra.AddApplicant;


import git_aptra.MenuBar.MenuBarPanelApplicant;

import java.sql.SQLException;
import java.util.Vector;

public class SaveDataAddApplicant {
	public static void save() {
			DialogAddApplicantGeneral.getGeneral();
			DialogAddApplicantApplication.getApplication();
			DialogAddApplicantContact.getContact();
			try {
				InsertApplicantDataIntoTable.insertApplicantDataIntoTable();
				InsertApplicationDataIntoDatabase.insertApplicantData();
				InsertApplicationDataIntoDatabase.saveDataRating();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			@SuppressWarnings("rawtypes")
			Vector resultsApplicant = InsertApplicantDataIntoTable.insertApplicantDataIntoTable();
			MenuBarPanelApplicant.modelPool.setDataVector(resultsApplicant,MenuBarPanelApplicant.COLUMN_IDENTIFIERS_APPLICANT);
			MenuBarPanelApplicant.modelPool.fireTableDataChanged();
			DialogAddApplicant.dialogNewApplicant.dispose();
		}
	}


