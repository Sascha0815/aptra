package git_aptra;

import git_aptra.DatabaseConnection.InsertApplicantDataIntoTable;
import git_aptra.DatabaseConnection.InsertManagementDataIntoTable;
import git_aptra.DatabaseConnection.InsertVacancyDateIntoTable;
import git_aptra.MenuBar.MenuBarPanelApplicant;
import git_aptra.MenuBar.MenuBarPanelVacancyManagement;
import git_aptra.MenuBar.MenuBarPanelVacancy;

import java.util.Vector;

public class Steuerung {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {

		new Oberflaeche("Bewerberverwaltung");
		Vector resultsApplicant = InsertApplicantDataIntoTable
				.insertApplicantDataIntoTable();
		MenuBarPanelApplicant.modelPool.setDataVector(resultsApplicant,
				MenuBarPanelApplicant.COLUMN_IDENTIFIERS_APPLICANT);
		MenuBarPanelApplicant.modelPool.fireTableDataChanged();
		Vector resultsVacancy = InsertVacancyDateIntoTable
				.insertVacancyDataIntoTable();
		MenuBarPanelVacancy.modelJob.setDataVector(resultsVacancy,
				MenuBarPanelVacancy.COLUMN_IDENTIFIERS_JOB);
		MenuBarPanelVacancy.modelJob.fireTableDataChanged();
		Vector resultsVacancyManagement = InsertManagementDataIntoTable
				.insertManagementDataIntoTable();
		MenuBarPanelVacancyManagement.modelVacancyManagement.setDataVector(resultsVacancyManagement,
				MenuBarPanelVacancyManagement.COLUMN_IDENTIFIERS_VACANCYMANAGEMENT);
		MenuBarPanelVacancyManagement.modelVacancyManagement.fireTableDataChanged();
	}

}
