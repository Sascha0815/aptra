package git_aptra.SearchMeeting;

import git_aptra.Oberflaeche;
import javax.swing.JDialog;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

public class DialogSearchMeeting {
	public static JTabbedPane tabSearch = new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);
	public static JDialog dialogSearchMeeting = new JDialog(Oberflaeche.frame, true);

	public static void searchMeeting() {		
		dialogSearchMeeting.setSize(425, 440);
		dialogSearchMeeting.setLocationRelativeTo(null);
		dialogSearchMeeting.setResizable(false);
		dialogSearchMeeting.setTitle("Neuer Termin");
		dialogSearchMeeting.add(tabSearch);
		DialogSearchMeetingGeneral.searchMeetingGeneral();
		DialogSearchMeetingSpecification.searchDetailsMeeting();
		SwingUtilities.updateComponentTreeUI(dialogSearchMeeting);
		dialogSearchMeeting.setLocationRelativeTo(Oberflaeche.frame);
		dialogSearchMeeting.setVisible(true);
	}
}
