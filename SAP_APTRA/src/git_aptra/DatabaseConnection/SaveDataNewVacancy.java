package git_aptra.DatabaseConnection;

import git_aptra.DialogAddVacancy.CloseDialogAddVacancy;
import git_aptra.DialogAddVacancy.DialogAddVacancyGeneral;
import git_aptra.DialogAddVacancy.DialogAddVacancySpecification;
import git_aptra.MenuBar.MenuBarPanelWorkplace;

import java.sql.SQLException;
import java.util.Vector;

public class SaveDataNewVacancy {
	@SuppressWarnings("rawtypes")
	public static void save() {
		if (DialogAddVacancyGeneral.getGeneral() == true
				&& DialogAddVacancySpecification.getSpecification() == true) {
			try {
				InsertVacancyData.insertVacancyData();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			Vector resultsVacancy = InsertVacancyDateIntoTable
					.insertVacancyDataIntoTable();
			MenuBarPanelWorkplace.modelJob.setDataVector(resultsVacancy,
					MenuBarPanelWorkplace.COLUMN_IDENTIFIERS_JOB);
			MenuBarPanelWorkplace.modelJob.fireTableDataChanged();
			CloseDialogAddVacancy.close();
		}
	}
}
