package git_aptra.Instruction;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class DialogInstructionMeeting {
	
	private static JPanel panelInstructionMeeting = new JPanel();
	
	private static JLabel labelRefreshMeetingHeadline = new JLabel("Meeting aktualisieren");
	private static JLabel labelAddMeetingHeadline = new JLabel("Meeting anlegen");
	private static JLabel labelEditMeetingHeadline = new JLabel("Meeting bearbeiten");
	private static JLabel labelDeleteMeetingHeadline = new JLabel("Meeting löschen");
	private static JLabel labelSearchMeetingHeadline = new JLabel("Meeting suchen");
	private static JLabel labelInfoMeetingHeadline = new JLabel("Meetinginformationen");
	
	private static JLabel labelRefreshMeetingContent = new JLabel("<html>Mit einem Klick auf Meeting aktualisieren wird die Meetingtabelle   <p/> "+                  
																	"aktualisiert und es werden die neusten Meetings angezeigt.</html>");
	private static JLabel labelAddMeetingContent = new JLabel("<html>Mit einem Klick auf Meeting hinzufügen können Sie ein neues Meeting hinzufügen.<p/> "+                  
																"Nach dem Speichern wird dieses sofort in die Datenbank übernommen und in der <p/> "+
																"Meetingtabelle angezeigt.</html>");
	private static JLabel labelEditMeetingContent = new JLabel("<html>Mit einem Klick auf Meeting bearbeiten können Sie die Daten eines bestehenden <p/> "+                  
																"Meetings bearbeiten. Um einen Meeting bearbeiten zu können müssen  Sie erst ein <p/> "+
																"Meeting in der Meetingtabelle auswählen. <p/> </html>");
	private static JLabel labelDeleteMeetingContent = new JLabel("<html>Mit einem Klick auf Meeting löschen können Sie ein bestehendes Meeting <p/> "+                  
																"löschen. Um einen Meeting löschen zu können müssen Sie erst ein Meeting  in<p/> "+
																"der Meetingtabelle auswählen. </p></html>");
	private static JLabel labelSearchMeetingContent = new JLabel("<html>Mit einem Klick auf Meeting suchen können Sie ein bestehendes Meeting  <p/> "+                  
																	"suchen. Um ein Meeting zu suchen geben Sie einfach die zu suchenden  <p/> "+
																	"Daten in den Suchdialog ein.</html>");
	private static JLabel labelInfoMeetingContent = new JLabel("<html>Mit einem Klick auf Meetinginformationen können Sie alle Daten von einem <p/> "+                  
																" bestehenden Meeting einsehen. Um die Meetinginformationen   <p/> "+
																"einzusehen müssen Sie erst ein Meeting in der Meetingtabelle auswählen.  <p/></html>");
	
	
	private static Font fontHeadline = new Font("Calibri", Font.BOLD, 16);
	private static Font fontText = new Font("Calibri", Font.PLAIN, 14);
	
	public static void addInstructionMeeting(){
		labelRefreshMeetingHeadline.setFont(fontHeadline);
		labelAddMeetingHeadline.setFont(fontHeadline);
		labelEditMeetingHeadline.setFont(fontHeadline);
		labelDeleteMeetingHeadline.setFont(fontHeadline);
		labelSearchMeetingHeadline.setFont(fontHeadline);
		labelInfoMeetingHeadline.setFont(fontHeadline);
		labelRefreshMeetingContent.setFont(fontText);
		labelAddMeetingContent.setFont(fontText);
		labelEditMeetingContent.setFont(fontText);
		labelDeleteMeetingContent.setFont(fontText);
		labelSearchMeetingContent.setFont(fontText);
		labelInfoMeetingContent.setFont(fontText);
		panelInstructionMeeting.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][]"));
		panelInstructionMeeting.add(labelRefreshMeetingHeadline, "cell 0 0 2 1,alignx left");
		panelInstructionMeeting.add(labelRefreshMeetingContent, "cell 0 1,alignx left");
		panelInstructionMeeting.add(labelAddMeetingHeadline, "cell 0 2 2 1,alignx left");
		panelInstructionMeeting.add(labelAddMeetingContent, "cell 0 3,alignx left");
		panelInstructionMeeting.add(labelEditMeetingHeadline, "cell 0 4 2 1,alignx left");
		panelInstructionMeeting.add(labelEditMeetingContent, "cell 0 5,alignx left");
		panelInstructionMeeting.add(labelDeleteMeetingHeadline, "cell 0 6 2 1,alignx left");
		panelInstructionMeeting.add(labelDeleteMeetingContent, "cell 0 7,alignx left");
		panelInstructionMeeting.add(labelSearchMeetingHeadline, "cell 0 8 2 1,alignx left");
		panelInstructionMeeting.add(labelSearchMeetingContent, "cell 0 9,alignx left");
		panelInstructionMeeting.add(labelInfoMeetingHeadline, "cell 0 10 2 1,alignx left");
		panelInstructionMeeting.add(labelInfoMeetingContent, "cell 0 11,alignx left");
		DialogInstruction.tabInstruction.addTab("Meeting",panelInstructionMeeting);
	}
}
