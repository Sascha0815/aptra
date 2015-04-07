package git_aptra;

import git_aptra.AddApplicant.InsertApplicantDataIntoTable;
import git_aptra.AddVacancy.InsertVacancyDataIntoTable;
import git_aptra.MenuBar.MenuBarPanelApplicant;
import git_aptra.MenuBar.MenuBarPanelVacancy;
import git_aptra.ResponsePDF.Rejecion;

import java.util.Vector;

public class Steuerung {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		//Rejecion.rejection();
		new Oberflaeche("Bewerberverwaltung");
		Vector resultsApplicant = InsertApplicantDataIntoTable
				.insertApplicantDataIntoTable();
		MenuBarPanelApplicant.modelPool.setDataVector(resultsApplicant,
				MenuBarPanelApplicant.COLUMN_IDENTIFIERS_APPLICANT);
		MenuBarPanelApplicant.modelPool.fireTableDataChanged();
		Vector resultsVacancy = InsertVacancyDataIntoTable
				.insertVacancyDataIntoTable();
		MenuBarPanelVacancy.modelJob.setDataVector(resultsVacancy,
				MenuBarPanelVacancy.COLUMN_IDENTIFIERS_JOB);
		MenuBarPanelVacancy.modelJob.fireTableDataChanged();
	

	}

}
