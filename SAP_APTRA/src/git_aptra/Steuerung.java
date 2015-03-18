package git_aptra;

import git_aptra.DatabaseConnection.DeleteApplicant;
import git_aptra.DatabaseConnection.EditApplicationData;
import git_aptra.DatabaseConnection.InsertApplicantDataIntoTable;
import git_aptra.DatabaseConnection.InsertApplicationData;
import git_aptra.DatabaseConnection.SaveDataNewApplicant;
import git_aptra.DialogEditApplicant.EditApplicant;
import git_aptra.DialogSearch.DialogSearchApplicant;
import git_aptra.DialogSearch.SearchControl;
import git_aptra.MenuBar.MenuBarPanelApplicant;

import java.util.Vector;

public class Steuerung {

	
	public static void main(String[] args) {

		new Oberflaeche("Bewerberverwaltung");
		@SuppressWarnings("rawtypes")
		Vector resultsApplicant = insertApplicantDataIntoTable
				.insertApplicantDataIntoTable();
		MenuBarPanelApplicant.modelPool.setDataVector(resultsApplicant,
				MenuBarPanelApplicant.COLUMN_IDENTIFIERS_APPLICANT);
		MenuBarPanelApplicant.modelPool.fireTableDataChanged();
	}
	final private static Steuerung steuerung = new Steuerung();
	final private static SaveDataNewApplicant saveDataNewApplication = new SaveDataNewApplicant();
	final private static InsertApplicationData insertApplicationData = new InsertApplicationData();
	final private static InsertApplicantDataIntoTable insertApplicantDataIntoTable = new InsertApplicantDataIntoTable();
	final private static DeleteApplicant deleteApplicant = new DeleteApplicant();
	final private static EditApplicant editApplicant = new EditApplicant();
	final private static EditApplicationData editApplicationData = new EditApplicationData();
	final private static SearchControl searchControl = new SearchControl();

	public static Steuerung getSteuerung() {
		return steuerung;
	}
	public static SaveDataNewApplicant getSaveDataNewApplicant() {
		return saveDataNewApplication;
	}
	public static InsertApplicationData getInsertApplicationData() {
		return insertApplicationData;
	}
	public static InsertApplicantDataIntoTable getInsertApplicantDataIntoTable() {
		return insertApplicantDataIntoTable;
	}
	public static DeleteApplicant getDeleteApplicant() {
		return deleteApplicant;
	}	
	public static EditApplicant getEditApplicant() {
		return editApplicant;
	}	
	public static EditApplicationData getEditApplicationData() {
		return editApplicationData;
	}
	public static SearchControl getSearchControl() {
		return searchControl;
	}

	

}
