package git_aptra.EditSelection;


import git_aptra.MenuBar.MenuBarPanelVacancy;

import java.sql.SQLException;
import java.util.Vector;

public class SavaDataEditSelection {
	@SuppressWarnings("rawtypes")
	public static void save() {
		if (DialogEditSelectionGeneral.getGeneral() == true) {
			try {
				InsertEditSelectionDataIntoTable.insertEditSelectionDataIntoTable();
				InsertEditSelectionDataIntoDatebase.insertEditSelectionData();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			Vector resultsSeleciton = InsertEditSelectionDataIntoTable.insertEditSelectionDataIntoTable();
			DialogEditSelectionGeneral.modelEditSelection.setDataVector(resultsSeleciton, DialogEditSelectionGeneral.COLUMN_IDENTIFIERS_SELECTION);
			DialogEditSelectionGeneral.modelEditSelection.fireTableDataChanged();
		}
	}
}