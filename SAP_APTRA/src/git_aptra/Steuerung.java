package git_aptra;


import git_aptra.DatabaseConnection.InsertApplicantDataIntoTable;
import git_aptra.DatabaseConnection.InsertVacancyDateIntoTable;
import git_aptra.MenuBar.MenuBarPanelApplicant;
import git_aptra.MenuBar.MenuBarPanelWorkplace;

import java.util.Vector;

public class Steuerung {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {

		new Oberflaeche("Bewerberverwaltung");
		Vector resultsApplicant = InsertApplicantDataIntoTable.insertApplicantDataIntoTable();
		MenuBarPanelApplicant.modelPool.setDataVector(resultsApplicant,
				MenuBarPanelApplicant.COLUMN_IDENTIFIERS_APPLICANT);
		MenuBarPanelApplicant.modelPool.fireTableDataChanged();
		Vector resultsVacancy = InsertVacancyDateIntoTable.insertVacancyDataIntoTable();
		MenuBarPanelWorkplace.modelJob.setDataVector(resultsVacancy,
				MenuBarPanelWorkplace.COLUMN_IDENTIFIERS_JOB);
		MenuBarPanelWorkplace.modelJob.fireTableDataChanged();
	}

	

	
}
