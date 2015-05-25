package git_aptra.AddApplicant;

import git_aptra.MenuBar.MenuBarPanelApplicant;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import net.miginfocom.swing.MigLayout;

public class DialogAddApplicantApplication {
	
	private static JPanel panelDialogApplicantApplication = new JPanel();

	private static String[] boxListEducationalAchievement = {"Hauptschulabschluss", "Mittlere Reife", "Abitur", "Studium" };

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static JComboBox boxEducationalAchievement = new JComboBox(boxListEducationalAchievement);
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static JComboBox boxDivision = new JComboBox(MenuBarPanelApplicant.getDivision());

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static JComboBox boxID = new JComboBox(MenuBarPanelApplicant.getVacancyID());

	private static JDateChooser dateChooserApplyDate = new JDateChooser();
	
	private static JLabel labelApplyDate = new JLabel("Bewerbungseingang:");
	private static JLabel labelVacancyID = new JLabel("Stellenidentifikationsnummer:");
	private static JLabel labelEducationalAchievement = new JLabel("Höchster Bildungsabschluss:");
	private static JLabel labelInstruction = new JLabel("Bitte tragen Sie alle erforderlichen Daten ein!");
	private static JLabel labelDivision = new JLabel("Abteilung");
	
	private static JButton buttonContinue = new JButton("Weiter");
	private static JButton buttonBack = new JButton("Zurück");
	
	private static Font fontHeadline = new Font("Calibri", Font.BOLD, 16);
	private static Font fontSubHeadline = new Font("Calibri", Font.BOLD, 14);
	private static Font fontText = new Font("Calibri", Font.PLAIN, 14);
	
	private static int dayApply;
	private static int monthApply;
	private static int yearApply;
	private static Calendar calApply = Calendar.getInstance();
	private static String educationalAchievement;
	private static String division;
	private static String vacancy;
	private static int vacancyID;

	public static void addApplicantApplication() {
		boxID.setSelectedIndex(0);
		boxEducationalAchievement.setSelectedIndex(0);
		boxID.setSelectedIndex(0);
		boxDivision.setSelectedIndex(0);
		dateChooserApplyDate.setDate(null);
		labelInstruction.setFont(fontHeadline);
		labelApplyDate.setFont(fontSubHeadline);
		labelVacancyID.setFont(fontSubHeadline);
		labelEducationalAchievement.setFont(fontSubHeadline);
		labelDivision.setFont(fontSubHeadline);
		buttonContinue.setFont(fontSubHeadline);
		buttonBack.setFont(fontSubHeadline);
		boxID.setFont(fontText);
		boxEducationalAchievement.setFont(fontText);
		boxDivision.setFont(fontText);
		dateChooserApplyDate.setFont(fontText);
		panelDialogApplicantApplication.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][][][][][][][][][][]push[]"));
		panelDialogApplicantApplication.add(labelInstruction, "cell 0 0 2 1,alignx center");
	    panelDialogApplicantApplication.add(labelApplyDate, "cell 0 1,alignx left");
	    panelDialogApplicantApplication.add(dateChooserApplyDate, "cell 0 2 2, growx");
	    panelDialogApplicantApplication.add(labelVacancyID, "cell 0 3,alignx left");
	    panelDialogApplicantApplication.add(boxID, "cell 0 4 2, growx");
	    panelDialogApplicantApplication.add(labelEducationalAchievement, "cell 0 7,alignx left");
	    panelDialogApplicantApplication.add(boxEducationalAchievement, "cell 0 8 2, growx");
	    panelDialogApplicantApplication.add(labelDivision, "cell 0 9, alignx left");
	    panelDialogApplicantApplication.add(boxDivision, "cell 0 10 2 1, growx");
	    panelDialogApplicantApplication.add(buttonBack,"cell 0 11,alignx left");
	    panelDialogApplicantApplication.add(buttonContinue,"cell 1 11,alignx right");
		DialogAddApplicant.tabAdd.addTab("Bewerbung",panelDialogApplicantApplication);
	    
		buttonContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				DialogAddApplicant.tabAdd.setSelectedIndex((2));
			}
		});
		
		buttonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				DialogAddApplicant.tabAdd.setSelectedIndex((0));
			}
		});
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
		try {
			String date = ((JTextField)dateChooserApplyDate.getDateEditor().getUiComponent()).getText(); 
			String[] parts = date.split("\\.");
			dayApply= Integer.parseInt(parts[0]);
			monthApply = Integer.parseInt(parts[1]);
			yearApply = Integer.parseInt(parts[2]);
			calApply.set(Calendar.YEAR, yearApply);
			calApply.set(Calendar.MONTH, (monthApply - 1));
			calApply.set(Calendar.DAY_OF_MONTH, dayApply);	
		} catch (Exception e) {
		}
		try {
			educationalAchievement = String.valueOf(boxEducationalAchievement.getSelectedItem());
		} catch (Exception e) {
		}
		try {
			String divisionSplit = ((String) boxID.getSelectedItem());
			String[] divisionParts = divisionSplit.split(" - ");
			division = divisionParts[1];
		} catch (Exception e) {
		}
	}

	public static Calendar getCalApply() {
		return calApply;
	}

	public static String getEducationalAchievement() {
		return educationalAchievement;
	}
	
	public static String getDivision() {
		return division;
	}

	public static String getVacancy() {
		return vacancy;
	}

	public static int getVacancyID() {
		return vacancyID;
	}

}
