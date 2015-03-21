package git_aptra.DatabaseConnection;

import git_aptra.DialogEditVacancy.CloseDialogEditVacancy;
import git_aptra.DialogEditVacancy.DialogEditVacancyGeneral;
import git_aptra.DialogEditVacancy.DialogEditVacancySpecification;
import git_aptra.MenuBar.MenuBarPanelWorkplace;

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
			MenuBarPanelWorkplace.modelJob.setDataVector(resultsVacancy,
					MenuBarPanelWorkplace.COLUMN_IDENTIFIERS_JOB);
			MenuBarPanelWorkplace.modelJob.fireTableDataChanged();
			CloseDialogEditVacancy.close();

		}
	}
}
