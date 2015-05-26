package git_aptra.EditApplicant;

import git_aptra.AddApplicant.InsertApplicantDataIntoTable;
import git_aptra.MenuBar.MenuBarPanelApplicant;

import java.sql.SQLException;
import java.util.Vector;

public class SaveDataEditApplicant {
	
	public static void save() {
			DialogEditApplicantApplication.getApplication();
			DialogEditApplicantGeneral.getGeneral();
			DialogEditApplicantContact.getContact();
			try {				
				EditApplicationData.editApplicantData();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			@SuppressWarnings("rawtypes")
			Vector resultsApplicant = InsertApplicantDataIntoTable.insertApplicantDataIntoTable();
			MenuBarPanelApplicant.modelPool.setDataVector(resultsApplicant,MenuBarPanelApplicant.COLUMN_IDENTIFIERS_APPLICANT);
			MenuBarPanelApplicant.modelPool.fireTableDataChanged();
			DialogEditApplicant.dialogEditApplicant.dispose();
		}
}

