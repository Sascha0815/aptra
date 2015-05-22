package git_aptra.AddApplicant;

import git_aptra.MenuBar.MenuBarPanelApplicant;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;

import net.miginfocom.swing.MigLayout;

public class DialogAddApplicantApplication {
	public static JPanel panelDialogApplicantApplication = new JPanel();

	private static String[] boxListEducationalAchievement = {"Hauptschulabschluss", "Mittlere Reife", "Abitur", "Studium" };

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static JComboBox boxEducationalAchievement = new JComboBox(boxListEducationalAchievement);

	private static SpinnerNumberModel numberModelDay = new SpinnerNumberModel(1,1,31,1);
	private static SpinnerListModel listModelMonth = new SpinnerListModel(new String[] {"Januar", "Februar", "März", "April", "Mai", "Juni", "Juli", "August", "September", "Oktober", "November", "Dezember"});
	private static SpinnerNumberModel numberModelYear = new SpinnerNumberModel(2015,2015,2020,1);

	private static JSpinner spinnerDay = new JSpinner(numberModelDay);
	private static JSpinner spinnerMonth = new JSpinner(listModelMonth);
	private static JSpinner spinnerYear = new JSpinner(numberModelYear);
	
	private static JLabel labelApplyDate = new JLabel("Bewerbungseingang:");
	private static JLabel labelVacancyID = new JLabel("Stellenidentifikationsnummer:");
	private static JLabel labelEducationalAchievement = new JLabel("Höchster Bildungsabschluss:");
	private static JLabel labelInstruction = new JLabel("Bitte tragen Sie alle erforderlichen Daten ein!");

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static JComboBox boxID = new JComboBox(MenuBarPanelApplicant.getVacancyID());
	
	private static JTextField fieldDate = new JTextField();
	
	private static Font fontHeadline = new Font("Calibri", Font.BOLD, 16);
	private static Font fontSubHeadline = new Font("Calibri", Font.BOLD, 14);
	private static Font fontText = new Font("Calibri", Font.PLAIN, 14);
	
	private static int dayApply;
	private static int monthApply;
	private static int yearApply;
	private static Calendar calApply = Calendar.getInstance();
	private static String educationalAchievement;
	private static String vacancy;
	private static int vacancyID;

	public static void addApplicantApplication() {
		boxID.setSelectedIndex(0);
		fieldDate.setText("");
		spinnerDay.setValue(1);
		spinnerMonth.setValue("Januar");
		spinnerYear.setValue(2015);
		boxEducationalAchievement.setSelectedIndex(0);
		labelInstruction.setFont(fontHeadline);
		labelApplyDate.setFont(fontSubHeadline);
		labelVacancyID.setFont(fontSubHeadline);
		labelEducationalAchievement.setFont(fontSubHeadline);
		boxID.setFont(fontSubHeadline);
		spinnerDay.setFont(fontSubHeadline);
		spinnerMonth.setFont(fontSubHeadline);
		spinnerYear.setFont(fontSubHeadline);
		fieldDate.setFont(fontText);
		labelEducationalAchievement.setFont(fontText);
	    spinnerYear.setEditor(new JSpinner.NumberEditor(spinnerYear, "0"));
		panelDialogApplicantApplication.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][][][][][][][][][][][]"));
		panelDialogApplicantApplication.add(labelInstruction, "cell 0 0 2 1,alignx center");
	    panelDialogApplicantApplication.add(labelApplyDate, "cell 0 1,alignx left");
	    panelDialogApplicantApplication.add(spinnerDay, "cell 0 2 1, growx");
	    panelDialogApplicantApplication.add(spinnerMonth, "cell 0 2 1 1, growx");
	    panelDialogApplicantApplication.add(spinnerYear, "cell 0 2 1 2, growx");
	    panelDialogApplicantApplication.add(labelVacancyID, "cell 0 3,alignx left");
	    panelDialogApplicantApplication.add(boxID, "cell 0 4 2, growx");
	    panelDialogApplicantApplication.add(labelEducationalAchievement, "cell 0 7,alignx left");
	    panelDialogApplicantApplication.add(boxEducationalAchievement, "cell 0 8 2, growx");
		DialogAddApplicant.tabAdd.addTab("Bewerbung",panelDialogApplicantApplication);

	}

	public static void getApplication() {
		try {
			String IDSplit = ((String) boxID.getSelectedItem());
			String[] IDParts = IDSplit.split(" - ");
			vacancyID = Integer.parseInt(IDParts[0]);
		} catch (Exception e) {
			vacancyID = 0;
		}
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://185.28.20.242:3306/u474396146_db",
					"u474396146_aptra", "aptraDB");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select position from vacancy where vacancyID = " + vacancyID);

			while (rs.next()) {
				vacancy = (rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		dayApply = (int) spinnerDay.getValue();
		String valueSpinnerMonth = (String) spinnerMonth.getValue();
		if(valueSpinnerMonth.equals("Januar")){
			monthApply = 1;
		}
		if(valueSpinnerMonth.equals("Februar")){
			monthApply = 2;
		}
		if(valueSpinnerMonth.equals("März")){
			monthApply = 3;
		}
		if(valueSpinnerMonth.equals("April")){
			monthApply = 4;
		}
		if(valueSpinnerMonth.equals("Mai")){
			monthApply = 5;
		}
		if(valueSpinnerMonth.equals("Juni")){
			monthApply = 6;
		}
		if(valueSpinnerMonth.equals("Juli")){
			monthApply = 7;
		}
		if(valueSpinnerMonth.equals("August")){
			monthApply = 8;
		}
		if(valueSpinnerMonth.equals("September")){
			monthApply = 9;
		}
		if(valueSpinnerMonth.equals("Oktober")){
			monthApply = 10;
		}
		if(valueSpinnerMonth.equals("November")){
			monthApply = 11;
		}
		if(valueSpinnerMonth.equals("Dezember")){
			monthApply = 12;
		}
		yearApply = (int) spinnerYear.getValue();
		calApply.set(Calendar.YEAR, yearApply);
		calApply.set(Calendar.MONTH, (monthApply - 1));
		calApply.set(Calendar.DAY_OF_MONTH, dayApply);
		educationalAchievement = String.valueOf(boxEducationalAchievement.getSelectedItem());
	}

	public static Calendar getCalApply() {
		return calApply;
	}

	public static String getEducationalAchievement() {
		return educationalAchievement;
	}

	public static String getVacancy() {
		return vacancy;
	}

	public static int getVacancyID() {
		return vacancyID;
	}

}
