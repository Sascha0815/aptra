package git_aptra.SearchMeeting;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class DialogSearchMeetingGeneral {
	private static JPanel panelDialogMeetingMain = new JPanel();
	
	private static JLabel labelInstruction = new JLabel("Bitte geben Sie die zu suchenden Daten ein!");
	private static JLabel labelApplicantID = new JLabel("Bewerber-ID:");
	private static JLabel labelName = new JLabel("Bewerber-Name:");
	private static JLabel labelFirstName = new JLabel("Bewerber-Vorname:");
	private static JLabel labelVacancyID = new JLabel("Stellen-ID:");
	private static JLabel labelPosition = new JLabel("Stellenbezeichnung:");
	
	private static JTextField fieldApplicantID = new JTextField();
	private static JTextField fieldName = new JTextField();
	private static JTextField fieldFirstName = new JTextField();
	private static JTextField fieldVacancyID = new JTextField();
	private static JTextField fieldPosition = new JTextField();

	private static JButton buttonContinue = new JButton("Weiter");
	
	private static Font fontHeadline = new Font("Calibri", Font.BOLD, 16);
	private static Font fontSubHeadline = new Font("Calibri", Font.BOLD, 14);
	private static Font fontText = new Font("Calibri", Font.PLAIN, 14);
	
	private static int applicantID;
	private static int vacancyID;
	private static String firstName = "";
	private static String name = "";
	private static String position = "";
		
	public static void searchMeetingGeneral(){
		labelInstruction.setFont(fontHeadline);
		labelApplicantID.setFont(fontSubHeadline);
		labelName.setFont(fontSubHeadline);
		labelFirstName.setFont(fontSubHeadline);
		labelVacancyID.setFont(fontSubHeadline);
		labelPosition.setFont(fontSubHeadline);
		fieldApplicantID.setFont(fontText);
		fieldName.setFont(fontText);
		fieldFirstName.setFont(fontText);
		fieldVacancyID.setFont(fontText);
		fieldPosition.setFont(fontText);
		panelDialogMeetingMain.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][][][][][][][][][][][][][]push[]"));
		panelDialogMeetingMain.add(labelInstruction,"cell 0 0 2 1,alignx center");
		panelDialogMeetingMain.add(labelApplicantID,"cell 0 2,alignx left");
		panelDialogMeetingMain.add(fieldApplicantID,"cell 0 3 2 1,growx");
		panelDialogMeetingMain.add(labelName,"cell 0 4,alignx left");
		panelDialogMeetingMain.add(fieldName,"cell 0 5 2 1,growx");
		panelDialogMeetingMain.add(labelFirstName,"cell 0 6,alignx left");
		panelDialogMeetingMain.add(fieldFirstName,"cell 0 7 2 1,growx");
		panelDialogMeetingMain.add(labelVacancyID,"cell 0 8,alignx left");
		panelDialogMeetingMain.add(fieldVacancyID,"cell 0 9 2 1,growx");
		panelDialogMeetingMain.add(labelPosition,"cell 0 10,alignx left");
		panelDialogMeetingMain.add(fieldPosition,"cell 0 11 2 1,growx");
		panelDialogMeetingMain.add(buttonContinue,"cell 1 14,alignx right");
		
		buttonContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				DialogSearchMeeting.tabSearch.setSelectedIndex(1);
			}
		});
		
		DialogSearchMeeting.tabSearch.addTab("Allgemein", panelDialogMeetingMain);
	}
	
	public static void getGeneral(){
		try {
			applicantID = Integer.parseInt(fieldApplicantID.getText());
		} catch (Exception e) {
			applicantID = 0;
		}
		try {
			vacancyID = Integer.parseInt(fieldVacancyID.getText());
		} catch (Exception e) {
			vacancyID = 0;
		}
		
		firstName = fieldFirstName.getText();
		name = fieldName.getText();
		position = fieldPosition.getText();		
	}
	
	public static int getApplicantID(){
		return applicantID;
	}
	public static int getVacancyID(){
		return vacancyID;
	}
	public static String getFirstName(){
		return firstName;
	}
	public static String getName(){
		return name;
	}
	public static String getPosition(){
		return position;
	}
}
