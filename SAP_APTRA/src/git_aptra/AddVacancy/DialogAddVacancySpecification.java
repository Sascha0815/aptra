package git_aptra.AddVacancy;

import git_aptra.MenuBar.MenuBarPanelApplicant;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import net.miginfocom.swing.MigLayout;

public class DialogAddVacancySpecification {

	private static Font fontHeadline = new Font("Calibri", Font.BOLD, 16);
	private static Font fontSubHeadline = new Font("Calibri", Font.BOLD, 14);
	private static Font fontText = new Font("Calibri", Font.PLAIN, 14);

	private static JPanel panelDialogVacancySpecification = new JPanel();
	
	private static JLabel labelInstruction = new JLabel("Bitte tragen Sie alle erfoderlichen Daten ein!");
	private static JLabel labelLevel = new JLabel("Zusatz/Vermerk:");
	private static JLabel labelDeadline = new JLabel("Bewerbungsschluss:");
	private static JLabel labelDivision = new JLabel("Abteilung:");

	private static JTextField fieldLevel = new JTextField();
	
	private static JDateChooser dateChooserDeadline = new JDateChooser();
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	static JComboBox boxDivision = new JComboBox(MenuBarPanelApplicant.getDivision());

	private static JButton buttonContinue = new JButton("Weiter");
	private static JButton buttonBack = new JButton("Zurück");

	public static void addVacancySpecification() {
		fieldLevel.setText("");
		labelInstruction.setFont(fontHeadline);
		labelLevel.setFont(fontSubHeadline);
		labelDeadline.setFont(fontSubHeadline);
		dateChooserDeadline.setFont(fontSubHeadline);
		fieldLevel.setFont(fontText);
		panelDialogVacancySpecification.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][][][][][][][][][][]push[]"));
		panelDialogVacancySpecification.add(labelInstruction, "cell 0 0 2,alignx center");
		panelDialogVacancySpecification.add(labelLevel, "cell 0 1,alignx left");
		panelDialogVacancySpecification.add(fieldLevel, "cell 0 2 2 1,growx");
		panelDialogVacancySpecification.add(labelDeadline, "cell 0 3,alignx left");
		panelDialogVacancySpecification.add(dateChooserDeadline, "cell 0 4 2, growx");
		panelDialogVacancySpecification.add(labelDivision, "cell 0 5,alignx left");
		panelDialogVacancySpecification.add(boxDivision, "cell 0 6,alignx left");
		panelDialogVacancySpecification.add(buttonBack,"cell 0 11,alignx left");
		panelDialogVacancySpecification.add(buttonContinue,"cell 1 11,alignx right");
		DialogAddVacancy.tabVacancy.addTab("Organisation",panelDialogVacancySpecification);
		    
		buttonContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				DialogAddVacancy.tabVacancy.setSelectedIndex((2));
			}
		});
			
		buttonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				DialogAddVacancy.tabVacancy.setSelectedIndex((0));
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

}
