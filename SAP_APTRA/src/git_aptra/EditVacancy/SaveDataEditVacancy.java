package git_aptra.EditVacancy;

import git_aptra.DatabaseConnection.InsertVacancyDateIntoTable;
import git_aptra.MenuBar.MenuBarPanelVacancy;

import java.sql.SQLException;
import java.util.Vector;

public class SaveDataEditVacancy {
	public static void save() {
		if (DialogEditVacancyGeneral.getGeneral() == true
				&& DialogEditVacancySpecification.getSpecification() == true) {
			try {
				EditVacancyData.editVacancyData();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			@SuppressWarnings("rawtypes")
			Vector resultsVacancy = InsertVacancyDateIntoTable
					.insertVacancyDataIntoTable();
			MenuBarPanelVacancy.modelJob.setDataVector(resultsVacancy,
					MenuBarPanelVacancy.COLUMN_IDENTIFIERS_JOB);
			MenuBarPanelVacancy.modelJob.fireTableDataChanged();
			CloseDialogEditVacancy.close();

		}
	}
}
