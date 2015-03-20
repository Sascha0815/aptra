package git_aptra.DatabaseConnection;

import git_aptra.DialogAddVacancy.DialogAddVacancyGeneral;
import git_aptra.DialogAddVacancy.DialogAddVacancySpecification;

import java.sql.SQLException;

public class SaveDataNewVacancy {
	public static void save() {
		if (DialogAddVacancyGeneral.getGeneral() == true
				&& DialogAddVacancySpecification.getSpecification() == true) {
			try {
				InsertVacancyData.insertVacancyData();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
