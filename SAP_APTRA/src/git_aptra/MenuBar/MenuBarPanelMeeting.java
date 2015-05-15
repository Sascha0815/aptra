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
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;

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
			add("Datum");
			add("Uhrzeit");
			add("Zuständiger Mitarbeiter");
			
		}
	};

	private static JPanel panelMeeting = new JPanel();
	private static JPanel panelMeetingInfo = new JPanel();
	private static JPanel panelMeetingButton = new JPanel();
	private static JPanel panelMeetingSummary = new JPanel();

	private static Font fontHeadline = new Font("Calibri", Font.BOLD, 22);
	private static Font fontContent = new Font("Calibri", Font.ITALIC, 16);
	private static Font fontSubHeadline = new Font("Calibri", Font.BOLD, 16);
	
	

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
	private static JScrollPane scrollPaneEmployeeMeeting = new JScrollPane(tableEmployeeMeeting);	

	private static JLabel labelMeetingInfo = new JLabel("Termininformation");
	private static JLabel labelMeetingCount = new JLabel("Anzahl der Termine:");
	private static JLabel labelMeetingNextDate = new JLabel("Nächster Termin am:");
	private static JLabel labelMeetingNextTime = new JLabel("Nächster Termin um:");
	private static JLabel labelMeetingLocation = new JLabel("Nächster Terminort:");
	public static JLabel labelMeetingCountContent = new JLabel();
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

		panelMeeting.setLayout(new MigLayout("", "[]5[]5[]"));
		panelMeetingSummary.setLayout(new MigLayout("", "[]", "[][][][][][][][][][][][][]"));

		// Management-Stelleninfo (links)
		labelMeetingInfo.setFont(fontHeadline);
		labelMeetingCount.setFont(fontSubHeadline);
		labelMeetingNextDate.setFont(fontSubHeadline);
		labelMeetingNextTime.setFont(fontSubHeadline);
		labelMeetingLocation.setFont(fontSubHeadline);
		labelMeetingCountContent.setFont(fontContent);	
		labelMeetingNextDateContent.setFont(fontContent);
		labelMeetingNextTimeContent.setFont(fontContent);
		labelMeetingLocationContent.setFont(fontContent);
		panelMeetingSummary.add(labelMeetingInfo, "cell 0 0,alignx left");		
		panelMeetingSummary.add(labelMeetingCount, "cell 0 1,alignx left");		
		panelMeetingSummary.add(labelMeetingCountContent, "cell 0 2,alignx left");		
		panelMeetingSummary.add(labelMeetingNextDate, "cell 0 3,alignx left");		
		panelMeetingSummary.add(labelMeetingNextDateContent, "cell 0 4,alignx left");		
		panelMeetingSummary.add(labelMeetingNextTime, "cell 0 5,alignx left");	
		panelMeetingSummary.add(labelMeetingNextTimeContent, "cell 0 6,alignx left");
		panelMeetingSummary.add(labelMeetingLocation, "cell 0 7,alignx left");
		panelMeetingSummary.add(labelMeetingLocationContent, "cell 0 8,alignx left");
		
		buttonAddMeeting.setToolTipText("Neuen Termin hinzufügen");
		panelMeetingButton.setLayout(new MigLayout("", "[]", "[]15[]15[]15[]15[]"));
		panelMeetingButton.add(buttonAddMeeting, "cell 0 0");
		buttonAddMeeting.setBorderPainted(false);
		buttonAddMeeting.setBorder(null);
		buttonAddMeeting.setOpaque(false);
		buttonAddMeeting.setContentAreaFilled(false);
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
		panelMeetingButton.add(buttonEditMeeting, "cell 0 1");
		buttonEditMeeting.setBorderPainted(false);
		buttonEditMeeting.setBorder(null);
		buttonEditMeeting.setOpaque(false);
		buttonEditMeeting.setContentAreaFilled(false);
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
		panelMeetingButton.add(buttonDeleteMeeting, "cell 0 2");
		buttonDeleteMeeting.setBorderPainted(false);
		buttonDeleteMeeting.setBorder(null);
		buttonDeleteMeeting.setOpaque(false);
		buttonDeleteMeeting.setContentAreaFilled(false);
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
		panelMeetingButton.add(buttonSearchMeeting, "cell 0 3");
		buttonSearchMeeting.setBorderPainted(false);
		buttonSearchMeeting.setBorder(null);
		buttonSearchMeeting.setOpaque(false);
		buttonSearchMeeting.setContentAreaFilled(false);
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
		panelMeetingButton.add(buttonSettingsMeeting, "cell 0 4");
		buttonSettingsMeeting.setBorderPainted(false);
		buttonSettingsMeeting.setBorder(null);
		buttonSettingsMeeting.setOpaque(false);
		buttonSettingsMeeting.setContentAreaFilled(false);
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
		modelEmployeeMeeting.setColumnIdentifiers(COLUMN_IDENTIFIERS_VACANCYMANAGEMENT);
		tableEmployeeMeeting.getTableHeader().setReorderingAllowed(false);
		tableEmployeeMeeting.setAutoCreateRowSorter(true);
		tableEmployeeMeeting = new JTable(modelEmployeeMeeting);
		scrollPaneEmployeeMeeting = new JScrollPane(
				tableEmployeeMeeting);
		panelMeeting.add(scrollPaneEmployeeMeeting);		
		scrollPaneEmployeeMeeting
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneEmployeeMeeting
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		tableEmployeeMeeting.setRowHeight(20);
		Border border = new LineBorder(Color.gray, 1);
		panelMeetingSummary.setBorder(border);
		panelMeetingButton.setBorder(border);
		scrollPaneEmployeeMeeting.setBorder(border);
		panelMeeting.add(panelMeetingSummary, "cell 0 0, w 200:200:200 , h :1000:");
		panelMeeting.add(scrollPaneEmployeeMeeting, "cell 1 0, w :1800: , h :1000:");
		panelMeeting.add(panelMeetingButton, "cell 2 0, w 150:150:150, h :1000:" );
		Oberflaeche.tabBar.addTab("Terminübersicht", panelMeeting);
		tableEmployeeMeeting.setAutoCreateRowSorter(true);

	}

	public static String[] getResult() {
		return result;
	}
}
