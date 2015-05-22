package git_aptra.EditSelection;



import java.sql.SQLException;
import java.util.Vector;

public class SavaDataEditSelection {
	@SuppressWarnings("rawtypes")
	public static void save() {
		if (DialogEditSelectionGeneral.getGeneral() == true) {
			try {
				InsertEditSelectionDataIntoTable.insertEditSelectionDataIntoTable();
				InsertEditSelectionDataIntoDatebase.insertSelectionData();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			Vector resultsSeleciton = InsertEditSelectionDataIntoTable.insertEditSelectionDataIntoTable();
			DialogEditSelectionGeneral.modelEditSelection.setDataVector(resultsSeleciton, DialogEditSelectionGeneral.COLUMN_IDENTIFIERS_SELECTION);
			DialogEditSelectionGeneral.modelEditSelection.fireTableDataChanged();
		}
	}
}