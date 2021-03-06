package git_aptra.SearchMeeting;

import git_aptra.Oberflaeche;
import javax.swing.JDialog;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

//Basis des Dialogs Suchfunktion Termine
public class DialogSearchMeeting {
	public static JTabbedPane tabSearch = new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);
	public static JDialog dialogSearchMeeting = new JDialog(Oberflaeche.frame, true);

	public static void searchMeeting() {		
		dialogSearchMeeting.setSize(425, 500);
		dialogSearchMeeting.setLocationRelativeTo(Oberflaeche.frame);
		dialogSearchMeeting.setResizable(false);
		dialogSearchMeeting.setTitle("Meeting suchen");
		dialogSearchMeeting.add(tabSearch);
		DialogSearchMeetingGeneral.searchMeetingGeneral();
		DialogSearchMeetingSpecification.searchDetailsMeeting();
		SwingUtilities.updateComponentTreeUI(dialogSearchMeeting);
		dialogSearchMeeting.setLocationRelativeTo(Oberflaeche.frame);
		dialogSearchMeeting.setVisible(true);
	}
}
