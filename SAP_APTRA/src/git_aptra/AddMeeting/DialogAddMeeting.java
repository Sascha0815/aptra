package git_aptra.AddMeeting;

import git_aptra.Oberflaeche;
import javax.swing.JDialog;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

//Basis des Dialogs für neue Meetings
public class DialogAddMeeting {
	public static JTabbedPane tabAdd = new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);
	public static JDialog dialogNewMeeting = new JDialog(Oberflaeche.frame, true);

	public static void newMeeting() {		
		dialogNewMeeting.setSize(425, 460);
		dialogNewMeeting.setLocationRelativeTo(Oberflaeche.frame);
		dialogNewMeeting.setResizable(false);
		dialogNewMeeting.setTitle("Neuer Termin");
		dialogNewMeeting.add(tabAdd);
		DialogAddMeetingGeneral.addMeetingGeneral();
		DialogAddMeetingSpecification.addDetailsMeeting();
		SwingUtilities.updateComponentTreeUI(dialogNewMeeting);
		dialogNewMeeting.setLocationRelativeTo(Oberflaeche.frame);
		dialogNewMeeting.setVisible(true);
	}
}
