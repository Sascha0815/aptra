package git_aptra.EditMeeting;

import git_aptra.Oberflaeche;
import javax.swing.JDialog;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

public class DialogEditMeeting {
	public static JTabbedPane tabEdit = new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);
	public static JDialog dialogEditMeeting = new JDialog(Oberflaeche.frame, true);
	
	public static void editMeeting() {		
		dialogEditMeeting.setSize(425, 440);
		dialogEditMeeting.setLocationRelativeTo(null);
		dialogEditMeeting.setResizable(false);
		dialogEditMeeting.setTitle("Termin bearbeiten");
		dialogEditMeeting.add(tabEdit);
		DialogEditMeetingSpecification.editDetailsMeeting();
		SwingUtilities.updateComponentTreeUI(dialogEditMeeting);
		dialogEditMeeting.setLocationRelativeTo(Oberflaeche.frame);
		dialogEditMeeting.setVisible(true);
	}
}
