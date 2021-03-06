package git_aptra.EditVacancy;

import git_aptra.AddVacancy.InsertVacancyDataIntoTable;
import git_aptra.MenuBar.MenuBarPanelVacancy;

import java.sql.SQLException;
import java.util.Vector;
//Steuerung des Speichervorgangs
public class SaveDataEditVacancy {
	public static void save() {
			DialogEditVacancyGeneral.getGeneral();
			DialogEditVacancySpecification.getSpecification();
			try {
				EditVacancyData.editVacancyData();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

			@SuppressWarnings("rawtypes")
			Vector resultsVacancy = InsertVacancyDataIntoTable
					.insertVacancyDataIntoTable();
			MenuBarPanelVacancy.modelJob.setDataVector(resultsVacancy,
					MenuBarPanelVacancy.COLUMN_IDENTIFIERS_JOB);
			MenuBarPanelVacancy.modelJob.fireTableDataChanged();
			DialogEditVacancy.dialogEditVacancy.dispose();
		}
	}

