package git_aptra.AddVacancy;

import git_aptra.MenuBar.MenuBarPanelVacancy;

import java.sql.SQLException;
import java.util.Vector;

public class SaveDataNewVacancy {
	@SuppressWarnings("rawtypes")
	public static void save() {
		if (DialogAddVacancyGeneral.getGeneral() == true && DialogAddVacancySpecification.getSpecification() == true) {
			try {
				InsertVacancyDataIntoDatabase.insertVacancyData();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			Vector resultsVacancy = InsertVacancyDataIntoTable.insertVacancyDataIntoTable();
			InsertVacancyDataIntoDatabase.insertRatingData();
			MenuBarPanelVacancy.modelJob.setDataVector(resultsVacancy,MenuBarPanelVacancy.COLUMN_IDENTIFIERS_JOB);
			MenuBarPanelVacancy.modelJob.fireTableDataChanged();
		}
	}
}
