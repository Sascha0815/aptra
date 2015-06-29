package git_aptra.AddApplicant;

import git_aptra.Login.Login;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import net.miginfocom.swing.MigLayout;

public class DialogAddApplicantApplication {
	
	private static JPanel panelDialogApplicantApplication = new JPanel();

	private static String[] boxListEducationalAchievement = {"Bitte wählen", "Hauptschulabschluss", "Mittlere Reife", "Abitur", "Studium" };

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static JComboBox boxEducationalAchievement = new JComboBox(boxListEducationalAchievement);
	
	@SuppressWarnings({ "rawtypes",})
	private static JComboBox boxDivision;

	@SuppressWarnings({ "rawtypes",})
	private static JComboBox boxID;

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
	@SuppressWarnings("unused")
	private static String division;
	private static String vacancy;
	private static int vacancyID;
	private static String[] VID;
	@SuppressWarnings("unused")
	private static String[] div;
	private static String[] divisionData;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void addApplicantApplication() {
		ArrayList<String> id= new ArrayList<String>();
		try {
			Connection con =  Login.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select vacancyID, position from vacancy where vacancyStatus NOT like 'Abgeschlossen'");
			id.add("Bitte wählen");
			while (rs.next()) {
				 id.add(rs.getString(1) + " - " + rs.getString(2) );	

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		VID = new String[id.size()];
		VID = id.toArray(VID);
		
		ArrayList<String> division= new ArrayList<String>();
		try {
			Connection con =  Login.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select divisionID, notation from division");

			while (rs.next()) {
				division.add(rs.getString(1) + " - " + rs.getString(2) );	

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		divisionData = new String[division.size()];
		divisionData = division.toArray(divisionData);
		panelDialogApplicantApplication.removeAll();
		boxDivision = new JComboBox(divisionData);
		boxID = new JComboBox(VID);
		panelDialogApplicantApplication.removeAll();
		boxEducationalAchievement.setSelectedIndex(0);
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
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY,0);
		cal.set(Calendar.MINUTE,0);
		cal.set(Calendar.SECOND,0);
		cal.set(Calendar.MILLISECOND,0);
		Date date = cal.getTime();	
		dateChooserApplyDate.setDate(date);
		panelDialogApplicantApplication.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][][][][][][]push[]"));
		panelDialogApplicantApplication.add(labelInstruction, "cell 0 0 2 1,alignx center");
	    panelDialogApplicantApplication.add(labelApplyDate, "cell 0 1,alignx left");
	    panelDialogApplicantApplication.add(dateChooserApplyDate, "cell 0 2 2, growx");
	    panelDialogApplicantApplication.add(labelVacancyID, "cell 0 3,alignx left");
	    panelDialogApplicantApplication.add(boxID, "cell 0 4 2, growx");
	    panelDialogApplicantApplication.add(labelEducationalAchievement, "cell 0 5,alignx left");
	    panelDialogApplicantApplication.add(boxEducationalAchievement, "cell 0 6 2, growx");
	    panelDialogApplicantApplication.add(buttonBack,"cell 0 7,alignx left");
	    panelDialogApplicantApplication.add(buttonContinue,"cell 1 7,alignx right");
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
			Connection con = Login.getConnection();
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
