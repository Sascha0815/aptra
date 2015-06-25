package git_aptra.EditVacancy;

import git_aptra.Login.Login;
import git_aptra.MenuBar.MenuBarPanelVacancy;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

import com.toedter.calendar.JDateChooser;

public class DialogEditVacancySpecification {

	private static Font fontHeadline = new Font("Calibri", Font.BOLD, 16);
	private static Font fontSubHeadline = new Font("Calibri", Font.BOLD, 14);
	private static Font fontText = new Font("Calibri", Font.PLAIN, 14);

	private static JPanel panelDialogVacancySpecification = new JPanel();
	
	private static JLabel labelInstruction = new JLabel("Bitte tragen Sie alle erfoderlichen Daten ein!");
	private static JLabel labelNote = new JLabel("Zusatz/Vermerk:");
	private static JLabel labelDeadline = new JLabel("Bewerbungsschluss:");
	private static JLabel labelDivision = new JLabel("Abteilung:");

	private static JTextField fieldLevel = new JTextField();
	
	private static JDateChooser dateChooserDeadline = new JDateChooser();
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static JComboBox boxDivision;
	private static int divisionID;
	private static JButton buttonSave = new JButton("Speichern");
	private static JButton buttonBack = new JButton("Zurück");
	private static String[] vacancyID;
	private static String[] divisionData;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void editVacancySpecification() {
		panelDialogVacancySpecification.removeAll();
		ArrayList<String> id= new ArrayList<String>();
		try {
			Connection con =  Login.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select vacancyID, position from vacancy");

			while (rs.next()) {
				 id.add(rs.getString(1) + " - " + rs.getString(2) );	

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		vacancyID = new String[id.size()];
		vacancyID = id.toArray(vacancyID);
		
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
		boxDivision = new JComboBox(divisionData);
		fieldLevel.setText("");
		labelInstruction.setFont(fontHeadline);
		labelNote.setFont(fontSubHeadline);
		labelDeadline.setFont(fontSubHeadline);
		labelDivision.setFont(fontSubHeadline);
		boxDivision.setFont(fontText);
		dateChooserDeadline.setFont(fontText);
		fieldLevel.setFont(fontText);
		fieldLevel.setText(EditVacancy.getDataNote());
		dateChooserDeadline.setDate(EditVacancy.getDataDate());
		boxDivision.setSelectedItem(EditVacancy.getVacancy());
		panelDialogVacancySpecification.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][][][][][][][][][][]push[]"));
		panelDialogVacancySpecification.add(labelInstruction, "cell 0 0 2,alignx center");
		panelDialogVacancySpecification.add(labelNote, "cell 0 1,alignx left");
		panelDialogVacancySpecification.add(fieldLevel, "cell 0 2 2 1,growx");
		panelDialogVacancySpecification.add(labelDeadline, "cell 0 3,alignx left");
		panelDialogVacancySpecification.add(dateChooserDeadline, "cell 0 4 2, growx");
		panelDialogVacancySpecification.add(labelDivision, "cell 0 5,alignx left");
		panelDialogVacancySpecification.add(boxDivision, "cell 0 6 2 1,growx");
		panelDialogVacancySpecification.add(buttonBack,"cell 0 11,alignx left");
		panelDialogVacancySpecification.add(buttonSave,"cell 1 11,alignx right");
		DialogEditVacancy.tabVacancy.addTab("Organisation",panelDialogVacancySpecification);
		    
		buttonSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				SaveDataEditVacancy.save();
			}
		});
			
		buttonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				DialogEditVacancy.tabVacancy.setSelectedIndex((0));
			}
		});
	}

	private static String level;
	private static int day;
	private static int month;
	private static int year;
	private static Calendar calVacancy = Calendar.getInstance();

	public static boolean getSpecification() {
		String division = (String) boxDivision.getSelectedItem();
		String[] partsDivision = division.split(" - ");
		divisionID = Integer.parseInt(partsDivision[0]);
		try {
			level = fieldLevel.getText();
		} catch (Exception e) {
		}
		try {
			String date = ((JTextField)dateChooserDeadline.getDateEditor().getUiComponent()).getText(); 
			String[] parts = date.split("\\.");
			day = Integer.parseInt(parts[0]);
			month = Integer.parseInt(parts[1]);
			year = Integer.parseInt(parts[2]);
			calVacancy.set(Calendar.YEAR, year);
			calVacancy.set(Calendar.MONTH, (month - 1));
			calVacancy.set(Calendar.DAY_OF_MONTH, day);
		} catch (Exception e) {
		}
		if (level.equals("")) {
			return false;
		} else {
			return true;
		}
	}


	public static String getLevel() {
		return level;
	}

	public static Calendar getCalVacancy() {
		return calVacancy;
	}
	
	public static int getDivisionID() {
		return divisionID;
	}
}
