package git_aptra.DatabaseConnection;

import git_aptra.DialogAddVacancy.CloseDialogAddVacancy;
import git_aptra.DialogAddVacancy.DialogAddVacancyGeneral;
import git_aptra.DialogAddVacancy.DialogAddVacancySpecification;
import git_aptra.MenuBar.MenuBarPanelVacancy;

import java.sql.SQLException;
import java.util.Vector;

public class SaveDataNewVacancy {
	@SuppressWarnings("rawtypes")
	public static void save() {
		if (DialogAddVacancyGeneral.getGeneral() == true
				&& DialogAddVacancySpecification.getSpecification() == true) {
			try {
				InsertVacancyDateIntoTable.insertVacancyDataIntoTable();
				InsertVacancyData.insertVacancyData();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			Vector resultsVacancy = InsertVacancyDateIntoTable
					.insertVacancyDataIntoTable();
			MenuBarPanelVacancy.modelJob.setDataVector(resultsVacancy,
					MenuBarPanelVacancy.COLUMN_IDENTIFIERS_JOB);
			MenuBarPanelVacancy.modelJob.fireTableDataChanged();
			CloseDialogAddVacancy.close();
		}
	}
}
