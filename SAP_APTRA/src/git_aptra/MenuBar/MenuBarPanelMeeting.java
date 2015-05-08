package git_aptra.MenuBar;

import git_aptra.Oberflaeche;
import git_aptra.Login.Login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MenuBarPanelMeeting {	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public final static Vector COLUMN_IDENTIFIERS_VACANCYMANAGEMENT = new Vector() {
		private static final long serialVersionUID = 1L;
		{
			add("Stellenbezeichnung");
			add("Arbeitsbereich");
			add("Meeting-ID");
			add("Bewerber-ID");
			add("Name");
			add("Vorname");
			add("Art des Termins");
			add("Ort");
			add("Uhrzeit");
			add("Zuständiger Mitarbeiter");
			
		}
	};
	private static JPanel panelEmployeeMeeting = new JPanel();
	private static JPanel panelMeetingContent = new JPanel();
	private static JPanel panelMeetingInfo = new JPanel();
	private static JPanel panelMeetingButton = new JPanel();
	private static JPanel panelMeetingSummary = new JPanel();

	private static Font fontHeadline = new Font("Arial", Font.BOLD, 22);
	private static Font fontSubHeadline = new Font("Arial", Font.BOLD, 14);
	private static Font fontContent = new Font("Arial", Font.ITALIC, 14);

	private static JButton buttonAddMeeting = new JButton();
	private static JButton buttonDeleteMeeting = new JButton();
	private static JButton buttonEditMeeting = new JButton();
	private static JButton buttonSearchMeeting = new JButton();
	private static JButton buttonSettingsMeeting = new JButton();
	public static DefaultTableModel modelEmployeeMeeting = new DefaultTableModel(
			1, 4) {
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	public static JTable tableEmployeeMeeting = new JTable(modelEmployeeMeeting);

	private static JLabel labelMeetingInfo = new JLabel("Termininfo");
	private static JLabel labelMeetingCount = new JLabel("Anzahl der Termine:");
	private static JLabel labelMeetingNextDate = new JLabel("Nächster Termin am:");
	private static JLabel labelMeetingNextTime = new JLabel("Nächster Termin um:");
	private static JLabel labelMeetingLocation = new JLabel("Nächster Terminort:");
	
	public static JLabel labelMeetingCountContent = new JLabel(" ");
	public static JLabel labelMeetingNextDateContent = new JLabel(" ");
	public static JLabel labelMeetingNextTimeContent = new JLabel(" ");
	public static JLabel labelMeetingLocationContent = new JLabel(" ");	
	private static String[] result;
	@SuppressWarnings("unused")
	private static int entitlement;
	
	// SWING: Arbeitsstellen Panel
	public static void addPanelEmployeeMeeting() {
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://185.28.20.242:3306/u474396146_db",
					"u474396146_aptra", "aptraDB");
			Statement stmt =  con.createStatement();
		    ResultSet rs = stmt.executeQuery("SELECT entitlement from employee where employeeID = " + Login.getID());
		    while (rs.next()) {		    	
		    	entitlement = rs.getInt(1);
		    }
		} catch (Exception e) {
			System.out.println("Fehler auslesen der Berechtigung" +e.getMessage());
		}

		panelEmployeeMeeting.setLayout(new BorderLayout(5, 5));
		panelEmployeeMeeting.add(panelMeetingButton, BorderLayout.EAST);
		panelEmployeeMeeting.add(panelMeetingContent, BorderLayout.CENTER);
		panelEmployeeMeeting.add(panelMeetingInfo, BorderLayout.SOUTH);
		panelEmployeeMeeting.add(panelMeetingSummary, BorderLayout.WEST);

		// Management-Stelleninfo (links)
		panelMeetingSummary.setBackground(Color.LIGHT_GRAY);
		panelMeetingSummary.setLayout(new BoxLayout(panelMeetingSummary, BoxLayout.Y_AXIS));
		panelMeetingSummary.setPreferredSize(new Dimension(180, 0));
		panelMeetingSummary.add(Box.createRigidArea(new Dimension(0, 30)));
		panelMeetingSummary.add(labelMeetingInfo);
		labelMeetingInfo.setFont(fontHeadline);
		panelMeetingSummary.add(Box.createRigidArea(new Dimension(0, 30)));
		panelMeetingSummary.add(labelMeetingCount);
		labelMeetingCount.setFont(fontSubHeadline);
		panelMeetingSummary.add(labelMeetingCountContent);
		labelMeetingCountContent.setFont(fontContent);		
		panelMeetingSummary.add(Box.createRigidArea(new Dimension(0, 10)));
		panelMeetingSummary.add(labelMeetingNextDate);
		labelMeetingNextDate.setFont(fontSubHeadline);
		panelMeetingSummary.add(labelMeetingNextDateContent);
		labelMeetingNextDateContent.setFont(fontContent);
		panelMeetingSummary.add(Box.createRigidArea(new Dimension(0, 10)));
		panelMeetingSummary.add(labelMeetingNextTime);
		labelMeetingNextTime.setFont(fontSubHeadline);
		panelMeetingSummary.add(labelMeetingNextTimeContent);
		labelMeetingNextTimeContent.setFont(fontContent);
		panelMeetingSummary.add(Box.createRigidArea(new Dimension(0, 10)));
		panelMeetingSummary.add(labelMeetingLocation);
		labelMeetingLocation.setFont(fontSubHeadline);
		panelMeetingSummary.add(labelMeetingLocationContent);
		labelMeetingLocationContent.setFont(fontContent);
		panelMeetingSummary.add(Box.createRigidArea(new Dimension(0, 10)));
			
		panelMeetingContent.setLayout(new FlowLayout(FlowLayout.CENTER, 20,
				20));
		panelMeetingButton.setLayout(new FlowLayout(FlowLayout.CENTER, 20,
				20));
		panelMeetingButton.setBackground(Color.LIGHT_GRAY);
		panelMeetingButton.setPreferredSize(new Dimension(150, 0));
		panelMeetingContent.setBackground(Color.LIGHT_GRAY);
		panelMeetingInfo.setBackground(Color.LIGHT_GRAY);
		panelMeetingInfo.setPreferredSize(new Dimension(0, 20));
		buttonAddMeeting
				.setToolTipText("Neuen Termin hinzufügen");
		panelMeetingButton.add(buttonAddMeeting);
		buttonAddMeeting.setPreferredSize(new Dimension(135, 135));
		buttonAddMeeting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				// Dialog Termin auswahl
			}
		});
		try {
			Image job = ImageIO.read(MenuBarPanelMeeting.class
					.getResource("resources/meeting_add.png"));
			buttonAddMeeting.setIcon(new ImageIcon(job));
		} catch (IOException ex) {
		}
		buttonEditMeeting.setToolTipText("Bewerber bearbeiten");
		panelMeetingButton.add(buttonEditMeeting);
		buttonEditMeeting.setBorderPainted(false);
		buttonEditMeeting.setBorder(null);
		buttonEditMeeting.setBackground(Color.LIGHT_GRAY);
		buttonEditMeeting.setPreferredSize(new Dimension(135, 135));
		buttonEditMeeting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
			}
		});
		try {
			Image pencil = ImageIO.read(MenuBarPanelApplicant.class
					.getResource("resources/meeting_edit.png"));
			buttonEditMeeting.setIcon(new ImageIcon(pencil));
		} catch (IOException ex) {
		}

		buttonDeleteMeeting.setToolTipText("Bewerber löschen");
		panelMeetingButton.add(buttonDeleteMeeting);
		buttonDeleteMeeting.setBorderPainted(false);
		buttonDeleteMeeting.setBorder(null);
		buttonDeleteMeeting.setBackground(Color.LIGHT_GRAY);
		buttonDeleteMeeting.setPreferredSize(new Dimension(135, 135));
		try {
			Image trashcan = ImageIO.read(MenuBarPanelApplicant.class
					.getResource("resources/meeting_delete.png"));
			buttonDeleteMeeting.setIcon(new ImageIcon(trashcan));
		} catch (IOException ex) {
		}
		buttonDeleteMeeting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {

			}
		});
		buttonSearchMeeting.setToolTipText("Einstellungen");
		panelMeetingButton.add(buttonSearchMeeting);
		buttonSearchMeeting.setBorderPainted(false);
		buttonSearchMeeting.setBorder(null);
		buttonSearchMeeting.setBackground(Color.LIGHT_GRAY);
		buttonSearchMeeting.setPreferredSize(new Dimension(135, 135));
		try {
			Image settings = ImageIO.read(MenuBarPanelApplicant.class
					.getResource("resources/meeting_search.png"));
			buttonSearchMeeting.setIcon(new ImageIcon(settings));
		} catch (IOException ex) {
		}
		buttonSearchMeeting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {

			}
		});
		buttonSettingsMeeting.setToolTipText("Info zum Termin");
		panelMeetingButton.add(buttonSettingsMeeting);
		buttonSettingsMeeting.setBorderPainted(false);
		buttonSettingsMeeting.setBorder(null);
		buttonSettingsMeeting.setBackground(Color.LIGHT_GRAY);
		buttonSettingsMeeting
				.setPreferredSize(new Dimension(135, 135));
		try {
			Image close = ImageIO.read(MenuBarPanelApplicant.class
					.getResource("resources/meeting_info.png"));
			buttonSettingsMeeting.setIcon(new ImageIcon(close));
		} catch (IOException ex) {
		}
		buttonSettingsMeeting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {

			}
		});

		// SWING:Table Arbeitsstellen
		modelEmployeeMeeting
				.setColumnIdentifiers(COLUMN_IDENTIFIERS_VACANCYMANAGEMENT);
		tableEmployeeMeeting.getTableHeader().setReorderingAllowed(false);
		tableEmployeeMeeting.setAutoCreateRowSorter(true);
		tableEmployeeMeeting = new JTable(modelEmployeeMeeting);
		JScrollPane scrollPaneEmployeeMeeting = new JScrollPane(
				tableEmployeeMeeting);
		panelEmployeeMeeting.add(scrollPaneEmployeeMeeting);
		scrollPaneEmployeeMeeting.setPreferredSize(new Dimension(
				panelMeetingContent.getSize().width - 20,
				panelMeetingContent.getSize().height - 15));
		scrollPaneEmployeeMeeting
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneEmployeeMeeting
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		tableEmployeeMeeting.setRowHeight(20);
		Oberflaeche.tabBar.addTab("Terminübersicht", panelEmployeeMeeting);
		tableEmployeeMeeting.setAutoCreateRowSorter(true);

	}

	public static String[] getResult() {
		return result;
	}
}
