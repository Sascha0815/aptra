package git_aptra.EditApplicant;

import git_aptra.Login.Login;
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

public class DialogEditApplicantApplication {
	
	private static JPanel panelDialogEditApplicantApplication = new JPanel();

	private static String[] boxListEducationalAchievement = {"Hauptschulabschluss", "Mittlere Reife", "Abitur", "Studium" };

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static JComboBox boxEducationalAchievement = new JComboBox(boxListEducationalAchievement);

	private static JDateChooser dateChooserApplyDate = new JDateChooser();
	
	private static JLabel labelApplyDate = new JLabel("Bewerbungseingang:");
	private static JLabel labelVacancyID = new JLabel("Stellenidentifikationsnummer:");
	private static JLabel labelEducationalAchievement = new JLabel("Höchster Bildungsabschluss:");
	private static JLabel labelInstruction = new JLabel("Änderung der Stammdaten");
	private static JLabel labelDivision = new JLabel("Abteilung");
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static JComboBox boxDivision = new JComboBox(MenuBarPanelApplicant.getDivision());

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static JComboBox boxID = new JComboBox(MenuBarPanelApplicant.getVacancyID());
	
	private static JButton buttonContinue = new JButton("Weiter");
	private static JButton buttonBack = new JButton("Zurück");
	
	private static Font fontHeadline = new Font("Calibri", Font.BOLD, 16);
	private static Font fontSubHeadline = new Font("Calibri", Font.BOLD, 14);
	
	private static int dayApply;
	private static int monthApply;
	private static int yearApply;
	private static Calendar calApply = Calendar.getInstance();
	private static String educationalAchievement;
	private static String division;
	private static String vacancy;
	private static int vacancyID;

	public static void editApplicantApplication() {
		boxID.setSelectedIndex(0);
		boxEducationalAchievement.setSelectedIndex(0);
		labelInstruction.setFont(fontHeadline);
		labelApplyDate.setFont(fontSubHeadline);
		labelVacancyID.setFont(fontSubHeadline);
		labelEducationalAchievement.setFont(fontSubHeadline);
		boxID.setFont(fontSubHeadline);
		buttonContinue.setFont(fontSubHeadline);
		buttonBack.setFont(fontSubHeadline);
		dateChooserApplyDate.setDate(EditApplicant.getDataSetApplyDate());
		boxEducationalAchievement.setSelectedItem(EditApplicant.getDataSetEducationalAchievement());
		boxDivision.setSelectedItem(EditApplicant.getDataSetDivision());
		panelDialogEditApplicantApplication.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][][][][][][][][]push[]"));
		panelDialogEditApplicantApplication.add(labelInstruction, "cell 0 0 2 1,alignx center");
	    panelDialogEditApplicantApplication.add(labelApplyDate, "cell 0 1,alignx left");
	    panelDialogEditApplicantApplication.add(dateChooserApplyDate, "cell 0 2 2, growx");
	    panelDialogEditApplicantApplication.add(labelVacancyID, "cell 0 3,alignx left");
	    panelDialogEditApplicantApplication.add(boxID, "cell 0 4 2, growx");
	    panelDialogEditApplicantApplication.add(labelEducationalAchievement, "cell 0 7,alignx left");
	    panelDialogEditApplicantApplication.add(boxEducationalAchievement, "cell 0 8 2, growx");
	    panelDialogEditApplicantApplication.add(buttonBack,"cell 0 9,alignx left");
	    panelDialogEditApplicantApplication.add(buttonContinue,"cell 1 9,alignx right");
		DialogEditApplicant.tabEdit.addTab("Bewerbung", panelDialogEditApplicantApplication);
		
		buttonContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				DialogEditApplicant.tabEdit.setSelectedIndex((2));
			}
		});
		
		buttonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				DialogEditApplicant.tabEdit.setSelectedIndex((0));
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
			Connection con =  Login.getConnection();
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
	
	public static String getVacancy() {
		return vacancy;
	}

	public static int getVacancyID() {
		return vacancyID;
	}
}
