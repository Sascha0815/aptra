package git_aptra.AddVacancy;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class DialogAddVacancySpecification {

	private static Font fontTextField = new Font("Arial", Font.BOLD, 14);

	private static JPanel panelDialogVacancySpecification = new JPanel();
	
	private static JLabel labelInstruction = new JLabel("Bitte tragen Sie alle erfoderlichen Daten ein!");
	private static JLabel labelLevel = new JLabel("Zusatz/Vermerk:");
	private static JLabel labelDeadline = new JLabel("Bewerbungsschluss:");
	private static JLabel labelDay = new JLabel("Tag:");
	private static JLabel labelMonth = new JLabel("Monat:");
	private static JLabel labelYear = new JLabel("Jahr:");
	
	private static JTextField fieldLevel = new JTextField();

	private static JButton save = new JButton("Speichern");

	private static JSpinner spinnerDay = new JSpinner();
	private static JSpinner spinnerMonth = new JSpinner();
	private static JSpinner spinnerYear = new JSpinner();

	public static void addVacancySpecification() {
		panelDialogVacancySpecification.setLayout(new MigLayout("", "[grow][grow][grow]", "[][][][][][][][][][][][]"));
		panelDialogVacancySpecification.add(labelInstruction, "cell 1 0,alignx left");
		panelDialogVacancySpecification.add(labelLevel, "cell 0 1,alignx left");
		panelDialogVacancySpecification.add(fieldLevel, "cell 0 2 3 1,growx");
		panelDialogVacancySpecification.add(labelDeadline, "cell 0 3,alignx left");
		panelDialogVacancySpecification.add(labelDay, "cell 0 5,alignx left");
		panelDialogVacancySpecification.add(spinnerDay, "cell 1 5");
		panelDialogVacancySpecification.add(labelMonth, "cell 0 7,alignx left"); 
		panelDialogVacancySpecification.add(spinnerMonth, "cell 1 7");
		panelDialogVacancySpecification.add(labelYear, "cell 0 9,alignx left"); 
		panelDialogVacancySpecification.add(spinnerYear, "cell 1 9");
		DialogAddVacancy.tabVacancy.addTab("Organisation",panelDialogVacancySpecification);
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				SaveDataNewVacancy.save();
				
			}
		});
	}

	private static String level;
	private static int day;
	private static int month;
	private static int year;
	private static Calendar calVacancy = Calendar.getInstance();

	public static boolean getSpecification() {
		try {
			level = fieldLevel.getText();
			day = (int) spinnerDay.getValue();
			month = (int) spinnerMonth.getValue();
			year = (int) spinnerYear.getValue();
			calVacancy.set(Calendar.YEAR, year);
			calVacancy.set(Calendar.MONTH, (month - 1));
			calVacancy.set(Calendar.DAY_OF_MONTH, day);
		} catch (Exception e) {
			System.out.println("Nicht alle Daten eingegeben");
		}

		if (level.equals("")) {
			return false;
		} else {
			return true;
		}
	}
	
	public static void reset() {
		panelDialogVacancySpecification.removeAll();
		fieldLevel.setText("");
		spinnerDay.setValue(0);
		spinnerMonth.setValue(0);
		spinnerYear.setValue(0);
	}

	public static String getLevel() {
		return level;
	}

	public static Calendar getCalVacancy() {
		return calVacancy;
	}

}
