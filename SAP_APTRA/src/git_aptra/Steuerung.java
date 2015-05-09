package git_aptra;

import git_aptra.AddApplicant.InsertApplicantDataIntoTable;
import git_aptra.AddVacancy.InsertVacancyDataIntoTable;
import git_aptra.EditVacancyManagement.InsertMeetingDataIntoTable;
import git_aptra.Login.DialogLogin;
import git_aptra.MenuBar.MenuBarPanelApplicant;
import git_aptra.MenuBar.MenuBarPanelMeeting;
import git_aptra.MenuBar.MenuBarPanelVacancy;

import java.util.Vector;

public class Steuerung {
	
	
	@SuppressWarnings("rawtypes")
	//METHODE: main
	public static void main(String[] args) {	
		new DialogLogin();
		Vector resultsApplicant = InsertApplicantDataIntoTable.insertApplicantDataIntoTable();
		MenuBarPanelApplicant.modelPool.setDataVector(resultsApplicant,MenuBarPanelApplicant.COLUMN_IDENTIFIERS_APPLICANT);
		MenuBarPanelApplicant.modelPool.fireTableDataChanged();
		Vector resultsVacancy = InsertVacancyDataIntoTable.insertVacancyDataIntoTable();
		MenuBarPanelVacancy.modelJob.setDataVector(resultsVacancy,MenuBarPanelVacancy.COLUMN_IDENTIFIERS_JOB);
		MenuBarPanelVacancy.modelJob.fireTableDataChanged();
		Vector resultsMeeting = InsertMeetingDataIntoTable.insertMeetingDataIntoTable();
		MenuBarPanelMeeting.modelEmployeeMeeting.setDataVector(resultsMeeting,MenuBarPanelMeeting.COLUMN_IDENTIFIERS_VACANCYMANAGEMENT);
		MenuBarPanelMeeting.modelEmployeeMeeting.fireTableDataChanged();
		
	
	}
}
