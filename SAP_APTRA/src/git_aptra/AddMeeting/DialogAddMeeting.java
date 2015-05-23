package git_aptra.AddMeeting;

import git_aptra.Oberflaeche;
import javax.swing.JDialog;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

public class DialogAddMeeting {
	public static JTabbedPane tabAdd = new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);
	public static JDialog dialogNewMeeting = new JDialog(Oberflaeche.frame);

	public static void newMeeting() {		
		dialogNewMeeting.setVisible(true);
		dialogNewMeeting.setSize(425, 440);
		dialogNewMeeting.setLocationRelativeTo(null);
		dialogNewMeeting.setResizable(false);
		dialogNewMeeting.setTitle("Neuer Termin");
		dialogNewMeeting.add(tabAdd);
		DialogAddMeetingGeneral.addMeetingGeneral();
		DialogAddMeetingSpecification.addDetailsMeeting();
		SwingUtilities.updateComponentTreeUI(dialogNewMeeting);
		dialogNewMeeting.setLocationRelativeTo(Oberflaeche.frame);
	}
}
