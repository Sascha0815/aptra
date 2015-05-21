package git_aptra.AddVacancy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import git_aptra.Oberflaeche;
import git_aptra.MenuBar.MenuBarPanelVacancy;

import javax.swing.JDialog;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

public class DialogAddVacancy {
	public static JDialog dialogNewVacancy = new JDialog(Oberflaeche.frame);
	public static JTabbedPane tabVacancy = new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void newVacancy() {
		dialogNewVacancy.setVisible(true);
		dialogNewVacancy.setSize(450, 375);
		dialogNewVacancy.setResizable(false);
		dialogNewVacancy.setTitle("Neue Stelle");
		dialogNewVacancy.add(tabVacancy);
		DialogAddVacancyGeneral.addVacancyGeneral();
		DialogAddVacancySpecification.addVacancySpecification();
		DialogAddVacancySelection.addVacancyHistory();
		dialogNewVacancy.setLocationRelativeTo(Oberflaeche.frame);
		SwingUtilities.updateComponentTreeUI(dialogNewVacancy);
		Vector results = new Vector();
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://185.28.20.242:3306/u474396146_db",
					"u474396146_aptra", "aptraDB");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select evaluationID, notation from evaluation");

			while (rs.next()) {
				Vector vacancy = new Vector();
				vacancy.add(rs.getInt(1));
				vacancy.add(rs.getString(2));
				results.add(vacancy);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		DialogAddVacancySelection.modelSelection.setDataVector(results, DialogAddVacancySelection.COLUMN_IDENTIFIERS_SELECTION);
		DialogAddVacancySelection.modelSelection.fireTableDataChanged();

	}
	}

