package git_aptra;


import git_aptra.DatabaseConnection.InsertApplicantDataIntoTable;
import git_aptra.MenuBar.MenuBarPanelApplicant;

import java.util.Vector;

public class Steuerung {

	public static void main(String[] args) {

		new Oberflaeche("Bewerberverwaltung");
		@SuppressWarnings("rawtypes")
		Vector resultsApplicant = InsertApplicantDataIntoTable.insertApplicantDataIntoTable();
		MenuBarPanelApplicant.modelPool.setDataVector(resultsApplicant,
				MenuBarPanelApplicant.COLUMN_IDENTIFIERS_APPLICANT);
		MenuBarPanelApplicant.modelPool.fireTableDataChanged();
	}

	

	
}
