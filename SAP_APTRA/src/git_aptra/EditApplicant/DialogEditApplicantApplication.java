package git_aptra.EditApplicant;

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

//Reiter des Dialogs zum Bearbeiten von Bewerbern
public class DialogEditApplicantApplication {
	
	private static JPanel panelDialogEditApplicantApplication = new JPanel();

	private static String[] boxListEducationalAchievement = {"Hauptschulabschluss", "Mittlere Reife", "Abitur", "Studium" };

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static JComboBox boxEducationalAchievement = new JComboBox(boxListEducationalAchievement);

	private static JDateChooser dateChooserApplyDate = new JDateChooser();
	
	private static JLabel labelApplyDate = new JLabel("Bewerbungseingang:");
	private static JLabel labelEducationalAchievement = new JLabel("Höchster Bildungsabschluss:");
	private static JLabel labelInstruction = new JLabel("Ändern Sie Daten des Bewerbers");
	@SuppressWarnings("unused")
	private static JLabel labelDivision = new JLabel("Abteilung");

	
	private static JButton buttonContinue = new JButton("Weiter");
	private static JButton buttonBack = new JButton("Zurück");
	
	private static Font fontHeadline = new Font("Calibri", Font.BOLD, 16);
	private static Font fontSubHeadline = new Font("Calibri", Font.BOLD, 14);
	
	private static int dayApply;
	private static int monthApply;
	private static int yearApply;
	private static Calendar calApply = Calendar.getInstance();
	private static String educationalAchievement;
	@SuppressWarnings("unused")
	private static String division;
	private static String vacancy;
	private static int vacancyID;
	private static String[]VID;
	@SuppressWarnings("unused")
	private static String[] divisionData;

	public static void editApplicantApplication() {
		panelDialogEditApplicantApplication.removeAll();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY,0);
		cal.set(Calendar.MINUTE,0);
		cal.set(Calendar.SECOND,0);
		cal.set(Calendar.MILLISECOND,0);
		Date date = cal.getTime();	
		dateChooserApplyDate.setDate(date);
		ArrayList<String> id= new ArrayList<String>();
		try {
			Connection con = Login.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select vacancyID, position from vacancy");

			while (rs.next()) {
				 id.add(rs.getString(1) + " - " + rs.getString(2) );	

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		VID = new String[id.size()];
		VID = id.toArray(VID);	
		boxEducationalAchievement.setSelectedIndex(0);
		labelInstruction.setFont(fontHeadline);
		labelApplyDate.setFont(fontSubHeadline);
		labelEducationalAchievement.setFont(fontSubHeadline);
		dateChooserApplyDate.setDate(EditApplicant.getDataApplyDate());
		boxEducationalAchievement.setSelectedItem(EditApplicant.getDataEducationalAchievement());
		panelDialogEditApplicantApplication.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][][][][][][][]push[]"));
		panelDialogEditApplicantApplication.add(labelInstruction, "cell 0 0 2 1,alignx center");
	    panelDialogEditApplicantApplication.add(labelApplyDate, "cell 0 1,alignx left");
	    panelDialogEditApplicantApplication.add(dateChooserApplyDate, "cell 0 2 2, growx");
	    panelDialogEditApplicantApplication.add(labelEducationalAchievement, "cell 0 3,alignx left");
	    panelDialogEditApplicantApplication.add(boxEducationalAchievement, "cell 0 4 2, growx");
	    panelDialogEditApplicantApplication.add(buttonBack,"cell 0 8,alignx left");
	    panelDialogEditApplicantApplication.add(buttonContinue,"cell 1 8,alignx right");
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

	
}
