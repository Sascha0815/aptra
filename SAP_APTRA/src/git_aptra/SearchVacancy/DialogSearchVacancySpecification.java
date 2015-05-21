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
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;

import net.miginfocom.swing.MigLayout;

public class DialogSearchVacancySpecification {

	private static JPanel panelSearchVacancySpecification = new JPanel();

	private static JLabel labelInstruction = new JLabel("Bitte tragen Sie alle erforderlichen Daten ein!");
	private static JLabel labelLevel = new JLabel();
	private static JLabel labelDeadline = new JLabel();

	private static JTextField fieldLevel = new JTextField();
	
	private static SpinnerNumberModel numberModelDay = new SpinnerNumberModel(1,1,31,1);
	private static SpinnerListModel listModelMonth = new SpinnerListModel(new String[] {"Januar", "Februar", "März", "April", "Mai", "Juni", "Juli", "August", "September", "Oktober", "November", "Dezember"});
	private static SpinnerNumberModel numberModelYear = new SpinnerNumberModel(1,1,2100,1);
	
	private static JSpinner spinnerDay = new JSpinner(numberModelDay);
	private static JSpinner spinnerMonth = new JSpinner(listModelMonth);
	private static JSpinner spinnerYear = new JSpinner(numberModelYear);

	private static JButton buttonSearch = new JButton("Suchen");
	private static JButton buttonAbort = new JButton ("Abbrechen");
	
	private static Font fontHeadline = new Font("Calibri", Font.BOLD, 16);
	private static Font fontSubHeadline = new Font("Calibri", Font.BOLD, 14);
	private static Font fontText = new Font("Calibri", Font.PLAIN, 14);

	public static void searchVacancySpecification() {
		labelInstruction.setFont(fontHeadline);
		spinnerDay.setFont(fontSubHeadline);
		spinnerMonth.setFont(fontSubHeadline);
		spinnerYear.setFont(fontSubHeadline);
		buttonSearch.setFont(fontSubHeadline);
		buttonAbort.setFont(fontSubHeadline);
		labelLevel.setFont(fontSubHeadline);
		labelDeadline.setFont(fontSubHeadline);
		fieldLevel.setFont(fontText);
		panelSearchVacancySpecification.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][][][][]100[]"));
		panelSearchVacancySpecification.add(labelInstruction, "cell 1 0,alignx center");
		panelSearchVacancySpecification.add(labelLevel, "cell 0 1,alignx left");
		panelSearchVacancySpecification.add(fieldLevel, "cell 0 2 2 1,growx");
		panelSearchVacancySpecification.add(labelDeadline, "cell 0 3,alignx left");
		panelSearchVacancySpecification.add(spinnerDay, "cell 0 4 2,growx "); 
		panelSearchVacancySpecification.add(spinnerMonth, "cell 0 4 2 1,growx "); 
		panelSearchVacancySpecification.add(spinnerYear, "cell 0 4 2 2,growx ");
		panelSearchVacancySpecification.add(buttonSearch, "cell 0 5,alignx left");
		panelSearchVacancySpecification.add(buttonAbort, "cell 1 5,alignx right ");

		buttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					SearchControlVacancy.searchVacancy();
					CloseDialogSearchVacancy.closeSearchVacancy();
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
			day = (int) spinnerDay.getValue();
			String valueSpinnerMonth = (String) spinnerMonth.getValue();
			if(valueSpinnerMonth.equals("Januar")){
				month = 1;
			}
			if(valueSpinnerMonth.equals("Februar")){
				month = 2;
			}
			if(valueSpinnerMonth.equals("März")){
				month = 3;
			}
			if(valueSpinnerMonth.equals("April")){
				month = 4;
			}
			if(valueSpinnerMonth.equals("Mai")){
				month = 5;
			}
			if(valueSpinnerMonth.equals("Juni")){
				month = 6;
			}
			if(valueSpinnerMonth.equals("Juli")){
				month = 7;
			}
			if(valueSpinnerMonth.equals("August")){
				month = 8;
			}
			if(valueSpinnerMonth.equals("September")){
				month = 9;
			}
			if(valueSpinnerMonth.equals("Oktober")){
				month = 10;
			}
			if(valueSpinnerMonth.equals("November")){
				month = 11;
			}
			if(valueSpinnerMonth.equals("Dezember")){
				month = 12;
			}
			year = (int) spinnerYear.getValue();
			calVacancy.set(Calendar.YEAR, year);
			calVacancy.set(Calendar.MONTH, (month - 1));
			calVacancy.set(Calendar.DAY_OF_MONTH, day);
		} catch (Exception e) {
			System.out.println("Nicht alle Daten eingegeben");
		}
	}
	
	public static void reset() {
		fieldLevel.setText("");
		spinnerDay.setValue(1);
		spinnerMonth.setValue(1);
		spinnerYear.setValue(2015);
	}

	public static String getLevel() {
		return level;
	}

	public static Calendar getCalVacancy() {
		return calVacancy;
	}

}

