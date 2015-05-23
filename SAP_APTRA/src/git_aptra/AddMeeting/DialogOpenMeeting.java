package git_aptra.AddMeeting;

import git_aptra.Oberflaeche;
import git_aptra.MenuBar.MenuBarPanelMeeting;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import net.miginfocom.swing.MigLayout;

public class DialogOpenMeeting {
	private static JDialog dialogOpenMeeting  = new JDialog(Oberflaeche.frame);
	
	private static JPanel panelOpenMeeting = new JPanel();
	
	private static JLabel labelInstruction = new JLabel("Bitte den gewünschten Bewerber auswählen");
	
	private static Font fontHeadline = new Font("Calibri", Font.BOLD, 16);
	private static Font fontSubHeadline = new Font("Calibri", Font.BOLD, 14);
	
	private static JButton buttonSearch = new JButton("Suchen");
	private static JButton buttonAbort = new JButton("Abbrechen");
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static JComboBox boxID = new JComboBox(MenuBarPanelMeeting.getResult());
	
	private static int applicantID;
	private static int vacancyID;
	
	public static void openMeeting() {
		dialogOpenMeeting.setVisible(true);
		dialogOpenMeeting.setSize(420, 130);
		dialogOpenMeeting.setResizable(false);	
		dialogOpenMeeting.setTitle("Bewerber auswählen");
		dialogOpenMeeting.add(panelOpenMeeting);
		labelInstruction.setFont(fontHeadline);
		boxID.setFont(fontSubHeadline);
		buttonSearch.setFont(fontSubHeadline);
		buttonAbort.setFont(fontSubHeadline);
		panelOpenMeeting.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][][][]"));
		panelOpenMeeting.add(labelInstruction, "cell 0 0 2 1,alignx center");
		panelOpenMeeting.add(boxID, "cell 0 1 2 1,growx");
		panelOpenMeeting.add(buttonSearch, "cell 0 3,alignx left");
		panelOpenMeeting.add(buttonAbort, "cell 1 3,alignx right");
		SwingUtilities.updateComponentTreeUI(dialogOpenMeeting);
		dialogOpenMeeting.setLocationRelativeTo(Oberflaeche.frame);
		
		buttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String IDSplit = ((String) boxID.getSelectedItem());
				String[] IDParts = IDSplit.split(" - ");
				applicantID = Integer.parseInt(IDParts[0]);
				openMeeting(applicantID);
				boxID.setSelectedIndex(0); 					
				dialogOpenMeeting.dispose();
				DialogAddMeeting.newMeeting();
			}
		});
		
		buttonAbort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				dialogOpenMeeting.dispose();
			}
		});		
	}
	
	public static void openMeeting(int id) {
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://185.28.20.242:3306/u474396146_db",
					"u474396146_aptra", "aptraDB");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT applicantID, name, firstName FROM applicant WHERE applicantID = " +applicantID );
			while (rs.next()) {
				DialogAddMeetingGeneral.labelApplicantIDContent.setText(rs.getString(1));
				DialogAddMeetingGeneral.labelNameContent.setText(rs.getString(2));
				DialogAddMeetingGeneral.labelFirstNameContent.setText(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://185.28.20.242:3306/u474396146_db",
					"u474396146_aptra", "aptraDB");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT vacancyID FROM relationship WHERE applicantID = " +applicantID );
			while (rs.next()) {
				vacancyID = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://185.28.20.242:3306/u474396146_db",
					"u474396146_aptra", "aptraDB");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT vacancyID, position FROM vacancy WHERE vacancyID =" +vacancyID);
			while (rs.next()) {
				DialogAddMeetingGeneral.labelVacancyIDContent.setText(rs.getString(1));
				DialogAddMeetingGeneral.labelPositionContent.setText(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}
