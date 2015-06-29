package git_aptra.AddMeeting;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class DialogAddMeetingGeneral {
	private static JPanel panelDialogMeetingMain = new JPanel();
	
	private static JLabel labelInstruction = new JLabel("Informationen zum ausgewählten Bewerber");
	private static JLabel labelApplicantID = new JLabel("Bewerber-ID:");
	private static JLabel labelName = new JLabel("Name:");
	private static JLabel labelFirstName = new JLabel("Vorname:");
	private static JLabel labelVacancyID = new JLabel("Stellen-ID:");
	private static JLabel labelPosition = new JLabel("Stellenbezeichnung:");
	public static JLabel labelApplicantIDContent = new JLabel();
	public static JLabel labelNameContent = new JLabel();
	public static JLabel labelFirstNameContent = new JLabel();
	public static JLabel labelVacancyIDContent = new JLabel();
	public static JLabel labelPositionContent = new JLabel();

	private static JButton buttonContinue = new JButton("Weiter");
	private static JButton buttonLoadApplicantData = new JButton("Bewerber auswählen");
	
	private static Font fontHeadline = new Font("Calibri", Font.BOLD, 16);
	private static Font fontSubHeadline = new Font("Calibri", Font.BOLD, 14);
	private static Font fontText = new Font("Calibri", Font.PLAIN, 14);
	private static boolean first = true;
	
	
	
	public static void addMeetingGeneral(){
		panelDialogMeetingMain.removeAll();	
		labelApplicantIDContent.setText("");
		labelNameContent.setText("");
		labelFirstNameContent.setText("");
		labelVacancyIDContent.setText("");
		labelPositionContent.setText("");
		
		labelInstruction.setFont(fontHeadline);
		labelApplicantID.setFont(fontSubHeadline);
		labelName.setFont(fontSubHeadline);
		labelFirstName.setFont(fontSubHeadline);
		labelVacancyID.setFont(fontSubHeadline);
		labelPosition.setFont(fontSubHeadline);
		labelApplicantIDContent.setFont(fontText);
		labelNameContent.setFont(fontText);
		labelFirstNameContent.setFont(fontText);
		labelVacancyIDContent.setFont(fontText);
		labelPositionContent.setFont(fontText);
		panelDialogMeetingMain.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][][][][][][][][][][][][][]push[]"));
		panelDialogMeetingMain.add(labelInstruction,"cell 0 0 2 1,alignx center");
		panelDialogMeetingMain.add(buttonLoadApplicantData, "cell 0 1 2 1, alignx center");
		panelDialogMeetingMain.add(labelApplicantID,"cell 0 2,alignx left");
		panelDialogMeetingMain.add(labelApplicantIDContent,"cell 0 3 2 1,growx");
		panelDialogMeetingMain.add(labelName,"cell 0 4,alignx left");
		panelDialogMeetingMain.add(labelNameContent,"cell 0 5 2 1,growx");
		panelDialogMeetingMain.add(labelFirstName,"cell 0 6,alignx left");
		panelDialogMeetingMain.add(labelFirstNameContent,"cell 0 7 2 1,growx");
		panelDialogMeetingMain.add(labelVacancyID,"cell 0 8,alignx left");
		panelDialogMeetingMain.add(labelVacancyIDContent,"cell 0 9 2 1,growx");
		panelDialogMeetingMain.add(labelPosition,"cell 0 10,alignx left");
		panelDialogMeetingMain.add(labelPositionContent,"cell 0 11 2 1,growx");
		panelDialogMeetingMain.add(buttonContinue,"cell 1 14,alignx right");
		if (first==true) {
			first =false;
			buttonLoadApplicantData.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					DialogLoadApplicantData.loadApplicantData();
				}
			});
			
			buttonContinue.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					DialogAddMeeting.tabAdd.setSelectedIndex(1);
				}
			});
		}
		
		
		DialogAddMeeting.tabAdd.addTab("Allgemein", panelDialogMeetingMain);
	}
}
