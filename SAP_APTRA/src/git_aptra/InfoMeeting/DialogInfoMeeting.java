package git_aptra.InfoMeeting;

import git_aptra.Oberflaeche;
import git_aptra.InfoMeeting.InfoMeeting;

import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import net.miginfocom.swing.MigLayout;
//Dialog mit Infos zu dem Meeting
public class DialogInfoMeeting {
	private static JDialog dialogInfoMeeting = new JDialog(Oberflaeche.frame, true);
	 
	private static JPanel panelDialogInfoMeeting = new JPanel();
	
	private static JLabel labelInstruction = new JLabel("Meetingdaten");
	private static JLabel labelApplicantID = new JLabel("Bewerbernummer:");
	private static JLabel labelName = new JLabel("Name:");
	private static JLabel labelFirstName = new JLabel("Vorname:");
	private static JLabel labelPosition = new JLabel("Position:");
	private static JLabel labelArea = new JLabel("Bereich:");
	private static JLabel labelMeetingID = new JLabel("Meeting-ID:");
	private static JLabel labelLocation = new JLabel("Ort:");
	private static JLabel labelTypeMeeting = new JLabel("Typ:");
	private static JLabel labelDate = new JLabel("Datum:");
	private static JLabel labelTime = new JLabel("Uhrzeit:");
	private static JLabel labelApplicantIDContent = new JLabel();
	private static JLabel labelNameContent = new JLabel();
	private static JLabel labelFirstNameContent = new JLabel();
	private static JLabel labelPositionContent = new JLabel();
	private static JLabel labelAreaContent = new JLabel();
	private static JLabel labelMeetingIDContent = new JLabel();
	private static JLabel labelLocationContent = new JLabel();
	private static JLabel labelTypeMeetingContent = new JLabel();
	private static JLabel labelDateContent = new JLabel();
	private static JLabel labelTimeContent = new JLabel();

	private static Font fontHeadline = new Font("Calibri", Font.BOLD, 16);
	private static Font fontSubHeadline = new Font("Calibri", Font.BOLD, 14);
	private static Font fontText = new Font("Calibri", Font.PLAIN, 14);
	
	public static void infoMeeting(){
		dialogInfoMeeting.setSize(425, 250);
		dialogInfoMeeting.setLocationRelativeTo(Oberflaeche.frame);
		dialogInfoMeeting.setResizable(false);
		dialogInfoMeeting.setTitle("Meetinginformationen");
		SwingUtilities.updateComponentTreeUI(dialogInfoMeeting);
		dialogInfoMeeting.setLocationRelativeTo(Oberflaeche.frame);
		dialogInfoMeeting.add(panelDialogInfoMeeting);
		labelInstruction.setFont(fontHeadline);
		labelApplicantID.setFont(fontSubHeadline);
		labelName.setFont(fontSubHeadline);
		labelFirstName.setFont(fontSubHeadline);
		labelPosition.setFont(fontSubHeadline);
		labelArea.setFont(fontSubHeadline);
		labelMeetingID.setFont(fontSubHeadline);
		labelLocation.setFont(fontSubHeadline);
		labelTypeMeeting.setFont(fontSubHeadline);
		labelDate.setFont(fontSubHeadline);
		labelTime.setFont(fontSubHeadline);
		labelApplicantIDContent.setFont(fontText);
		labelNameContent.setFont(fontText);
		labelFirstNameContent.setFont(fontText);
		labelPositionContent.setFont(fontText);
		labelAreaContent.setFont(fontText);
		labelMeetingIDContent.setFont(fontText);
		labelLocationContent.setFont(fontText);
		labelDateContent.setFont(fontText);
		labelTimeContent.setFont(fontText);
		labelTypeMeetingContent.setFont(fontText);
		labelApplicantIDContent.setText(InfoMeeting.getDataSetApplicantID());
		labelNameContent.setText(InfoMeeting.getDataSetName());
		labelFirstNameContent.setText(InfoMeeting.getDataSetFirstName());
		labelPositionContent.setText(InfoMeeting.getDataSetPosition());
		labelAreaContent.setText(InfoMeeting.getDataSetArea());
		labelMeetingIDContent.setText(InfoMeeting.getDataSetMeetingID());
		labelLocationContent.setText(InfoMeeting.getDataSetLocation());
		labelTypeMeetingContent.setText(InfoMeeting.getDataSetTypeMeeting());
		labelDateContent.setText(InfoMeeting.getDataSetDate());
		labelTimeContent.setText(InfoMeeting.getDataSetTime());
		panelDialogInfoMeeting.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][][][][][][][][][][][][][]"));
		panelDialogInfoMeeting.add(labelInstruction,"cell 0 0 2 1,alignx center");
		panelDialogInfoMeeting.add(labelApplicantID, "cell 0 1,alignx left");
		panelDialogInfoMeeting.add(labelApplicantIDContent, "cell 0 1 1,alignx left");
		panelDialogInfoMeeting.add(labelName, "cell 0 2,alignx left");
		panelDialogInfoMeeting.add(labelNameContent, "cell 0 2 1,alignx left");
		panelDialogInfoMeeting.add(labelFirstName, "cell 0 3,alignx left");
		panelDialogInfoMeeting.add(labelFirstNameContent, "cell 0 3 1,alignx left");
		panelDialogInfoMeeting.add(labelPosition, "cell 0 4,alignx left");
		panelDialogInfoMeeting.add(labelPositionContent, "cell 0 4 1,alignx left");
		panelDialogInfoMeeting.add(labelArea, "cell 0 5,alignx left");
		panelDialogInfoMeeting.add(labelAreaContent, "cell 0 5 1,alignx left");
		panelDialogInfoMeeting.add(labelMeetingID, "cell 0 6,alignx left");
		panelDialogInfoMeeting.add(labelMeetingIDContent, "cell 0 6 1,alignx left");
		panelDialogInfoMeeting.add(labelLocation, "cell 0 7,alignx left");
		panelDialogInfoMeeting.add(labelLocationContent, "cell 0 7 1,alignx left");
		panelDialogInfoMeeting.add(labelTypeMeeting, "cell 0 8,alignx left");
		panelDialogInfoMeeting.add(labelTypeMeetingContent, "cell 0 8 1,alignx left");
		panelDialogInfoMeeting.add(labelDate, "cell 0 9,alignx left");
		panelDialogInfoMeeting.add(labelDateContent, "cell 0 9 1,alignx left");
		panelDialogInfoMeeting.add(labelTime, "cell 0 10,alignx left");
		panelDialogInfoMeeting.add(labelTimeContent, "cell 0 10 1,alignx left");
		dialogInfoMeeting.setVisible(true);
	}
}
