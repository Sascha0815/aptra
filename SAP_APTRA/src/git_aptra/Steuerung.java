package git_aptra;

import java.util.Vector;

public class Steuerung {
	final private static Steuerung steuerung = new Steuerung();
	final private static SaveDataNewApplicant saveDataNewApplication = new SaveDataNewApplicant();
	final private static InsertApplicationData insertApplicationData = new InsertApplicationData();
	final private static InsertApplicantDataIntoTable insertApplicantDataIntoTable = new InsertApplicantDataIntoTable();
	final private static DeleteApplicant deleteApplicant = new DeleteApplicant();

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

	public static void main(String[] args) {

		new Oberflaeche("Bewerberverwaltung");
		@SuppressWarnings("rawtypes")
		Vector resultsApplicant = insertApplicantDataIntoTable
				.insertApplicantDataIntoTable();
		MenuBarPanelApplicant.modelPool.setDataVector(resultsApplicant,
				MenuBarPanelApplicant.COLUMN_IDENTIFIERS_APPLICANT);
		MenuBarPanelApplicant.modelPool.fireTableDataChanged();
	}

}
