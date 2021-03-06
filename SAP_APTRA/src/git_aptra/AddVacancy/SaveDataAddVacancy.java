package git_aptra.AddVacancy;

import git_aptra.MenuBar.MenuBarPanelVacancy;

import java.sql.SQLException;
import java.util.Vector;

public class SaveDataAddVacancy {
	@SuppressWarnings("rawtypes")
	public static void save() {
		if (DialogAddVacancyGeneral.getGeneral() == true && DialogAddVacancySpecification.getSpecification() == true) {
			try {
				InsertVacancyDataIntoDatabase.insertVacancyData();
				InsertVacancyDataIntoDatabase.insertVacancyevaluationData();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DialogAddVacancy.dialogNewVacancy.dispose();
			Vector resultsVacancy = InsertVacancyDataIntoTable.insertVacancyDataIntoTable();
			MenuBarPanelVacancy.modelJob.setDataVector(resultsVacancy,MenuBarPanelVacancy.COLUMN_IDENTIFIERS_JOB);
			MenuBarPanelVacancy.modelJob.fireTableDataChanged();
			DialogAddVacancy.dialogNewVacancy.dispose();
		}
	}
}
