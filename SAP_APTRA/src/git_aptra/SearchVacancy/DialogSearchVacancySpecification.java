package git_aptra.SearchVacancy;

import git_aptra.AddApplicant.DialogAddApplicant;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import net.miginfocom.swing.MigLayout;

public class DialogSearchVacancySpecification {

	private static JPanel panelSearchVacancySpecification = new JPanel();

	private static JLabel labelInstruction = new JLabel("Bitte tragen Sie alle erforderlichen Daten ein!");
	private static JLabel labelLevel = new JLabel("Zusatz/Vermerk:");
	private static JLabel labelDeadline = new JLabel("Bewerbungsschluss:");

	private static JTextField fieldLevel = new JTextField();
	
	private static JDateChooser dateChooserDeadline = new JDateChooser();

	private static JButton buttonSearch = new JButton("Suchen");
	private static JButton buttonAbort = new JButton ("Abbrechen");
	
	private static Font fontHeadline = new Font("Calibri", Font.BOLD, 16);
	private static Font fontSubHeadline = new Font("Calibri", Font.BOLD, 14);
	private static Font fontText = new Font("Calibri", Font.PLAIN, 14);

	public static void searchVacancySpecification() {
		labelInstruction.setFont(fontHeadline);
		buttonSearch.setFont(fontSubHeadline);
		buttonAbort.setFont(fontSubHeadline);
		labelLevel.setFont(fontSubHeadline);
		labelDeadline.setFont(fontSubHeadline);
		dateChooserDeadline.setFont(fontText);
		fieldLevel.setFont(fontText);
		fieldLevel.setText("");
		panelSearchVacancySpecification.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][][][][]push[]"));
		panelSearchVacancySpecification.add(labelInstruction, "cell 0 0 2,alignx center");
		panelSearchVacancySpecification.add(labelLevel, "cell 0 1,alignx left");
		panelSearchVacancySpecification.add(fieldLevel, "cell 0 2 2 1,growx");
		panelSearchVacancySpecification.add(labelDeadline, "cell 0 3,alignx left");
		panelSearchVacancySpecification.add(dateChooserDeadline, "cell 0 4 2,growx "); 
		panelSearchVacancySpecification.add(buttonSearch, "cell 0 5,alignx left");
		panelSearchVacancySpecification.add(buttonAbort, "cell 1 5,alignx right ");

		buttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					SearchControlVacancy.searchVacancy();
					DialogSearchVacancy.dialogSearchVacancy.dispose();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		
		buttonAbort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				DialogAddApplicant.dialogNewApplicant.dispose();
			}
		});
		
		DialogSearchVacancy.tabSearchVacancy.addTab("Spezifikation",panelSearchVacancySpecification);
	}

	private static String level;
	private static int day;
	private static int month;
	private static int year;
	private static Calendar calVacancy = Calendar.getInstance();

	public static void getSpecification() {
		try {
			level = fieldLevel.getText();
			String date = ((JTextField)dateChooserDeadline.getDateEditor().getUiComponent()).getText(); 
			String[] parts = date.split("\\.");
			day = Integer.parseInt(parts[0]);
			month = Integer.parseInt(parts[1]);
			year = Integer.parseInt(parts[2]);
			calVacancy.set(Calendar.YEAR, year);
			calVacancy.set(Calendar.MONTH, (month - 1));
			calVacancy.set(Calendar.DAY_OF_MONTH, day);
	
		} catch (Exception e) {
			System.out.println("Nicht alle Daten eingegeben");
		}
	}
	
	public static String getLevel() {
		return level;
	}

	public static Calendar getCalVacancy() {
		return calVacancy;
	}

}

