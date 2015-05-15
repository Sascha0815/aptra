package git_aptra.MenuBar;

import git_aptra.Loading;
import git_aptra.Oberflaeche;
import git_aptra.EditApplicant.DialogEditWarning;
import git_aptra.EditVacancyManagement.DialogEditVacancyManagement;
import git_aptra.EditVacancyManagement.EditVacancyManagement;
import git_aptra.SearchVacancy.DialogSearchVacancy;
import git_aptra.VacancyManagement.DialogOpenVacancy;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.imageio.ImageIO;
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

public class MenuBarPanelVacancyManagement {
	
	private static JScrollPane scrollPaneVacancyManagement = new JScrollPane();
	public static DefaultTableModel modelVacancyManagement = new DefaultTableModel(1, 4) {
	private static final long serialVersionUID = 1L;

	public boolean isCellEditable(int row, int column) {
		return false;
		}
	};
	private static JPanel panelVacancyManagement = new JPanel();
	private static JPanel panelManagementButton = new JPanel();
	private static JPanel panelManagementSummary = new JPanel();
	
	private static Font fontHeadline = new Font("Calibri", Font.BOLD, 22);
	private static Font fontContent = new Font("Calibri", Font.ITALIC, 16);
	private static Font fontSubHeadline = new Font("Calibri", Font.BOLD, 16);
	
	private static JButton butttonAddVacancyManagement = new JButton();
	private static JButton buttonEditVacancyManagement = new JButton();
	private static JButton buttonSearchVacancyManagement = new JButton();
			
	public static JTable tableVacancyManagement = new JTable(modelVacancyManagement);

	private static JLabel labelManagementInfo = new JLabel("Info zur Stelle");
	private static JLabel labelManagementCount = new JLabel("Anzahl der Bewerber:");
	private static JLabel labelManagementEndOfApply = new JLabel("Bewerbungsschluss:");
	private static JLabel labelManagementPosition = new JLabel("Stellenbezeichnung:");
	private static JLabel labelManagementArea = new JLabel("Arbeitsbereich:");
	private static JLabel labelManagementRequirementLevel = new JLabel("Anforderung:");
	private static JLabel labelManagementTermsOfEmployment = new JLabel("Anstellungsverhältnis:");
	private static JLabel labelManagementVacancyStatus = new JLabel("Status:");
	private static JLabel labelManagementEducationalAchievement = new JLabel("Bildungsabschluss:");
	public static JLabel labelManagementCountContent = new JLabel(" ");
	public static JLabel labelManagementEndOfApplyContent = new JLabel(" ");
	public static JLabel labelManagementPositionContent = new JLabel(" ");
	public static JLabel labelManagementAreaContent = new JLabel(" ");
	public static JLabel labelManagementRequirementLevelContent = new JLabel(" ");
	public static JLabel labelManagementTermsOfEmploymentContent = new JLabel(" ");
	public static JLabel labelManagementVacancyStatusContent = new JLabel(" ");
	public static JLabel labelManagementEducationalAchievementContent = new JLabel(" ");
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public final static Vector COLUMN_IDENTIFIERS_VACANCYMANAGEMENT = new Vector() {
		private static final long serialVersionUID = 1L;

		{
			add("Bewerber-ID");
			add("Name");
			add("Vorname");
			add("Status");
			add("Neuste Notiz");
			add("Datum");
			add("Anmerkung zu der Notiz");
			add("Bewertung");
		}
	};
	
	private static String[] result;
	private static int idApplicant;
	
	// SWING: Arbeitsstellen Panel
	public static void addPanelVacancyManagement() {

		panelVacancyManagement.setLayout(new MigLayout("", "[]5[]5[]"));
		panelManagementSummary.setLayout(new MigLayout("", "[]", "[][][][][][][][][][][][][]"));
		
		// Management-Stelleninfo (links)
		labelManagementInfo.setFont(fontHeadline);
		labelManagementCount.setFont(fontSubHeadline);
		labelManagementEndOfApply.setFont(fontSubHeadline);
		labelManagementPosition.setFont(fontSubHeadline);
		labelManagementArea.setFont(fontSubHeadline);
		labelManagementRequirementLevel.setFont(fontSubHeadline);
		labelManagementTermsOfEmployment.setFont(fontSubHeadline);
		labelManagementVacancyStatus.setFont(fontSubHeadline);
		labelManagementEducationalAchievement.setFont(fontSubHeadline);
		labelManagementCountContent.setFont(fontContent);
		labelManagementEndOfApplyContent.setFont(fontContent);
		labelManagementPositionContent.setFont(fontContent);
		labelManagementAreaContent.setFont(fontContent);
		labelManagementRequirementLevelContent.setFont(fontContent);
		labelManagementTermsOfEmploymentContent.setFont(fontContent);
		labelManagementVacancyStatusContent.setFont(fontContent);
		labelManagementEducationalAchievementContent.setFont(fontContent);
		panelManagementSummary.add(labelManagementInfo,"cell 0 0,alignx left");
		panelManagementSummary.add(labelManagementCount, "cell 0 1,alignx left");
		panelManagementSummary.add(labelManagementCountContent, "cell 0 2,alignx left");	
		panelManagementSummary.add(labelManagementEndOfApply, "cell 0 3,alignx left");
		panelManagementSummary.add(labelManagementEndOfApplyContent, "cell 0 4,alignx left");
		panelManagementSummary.add(labelManagementPosition, "cell 0 5,alignx left");
		panelManagementSummary.add(labelManagementPositionContent, "cell 0 6,alignx left");
		panelManagementSummary.add(labelManagementArea, "cell 0 7,alignx left");
		panelManagementSummary.add(labelManagementAreaContent, "cell 0 8,alignx left");
		panelManagementSummary.add(labelManagementRequirementLevel, "cell 0 9,alignx left");
		panelManagementSummary.add(labelManagementRequirementLevelContent, "cell 0 10,alignx left");
		panelManagementSummary.add(labelManagementTermsOfEmployment, "cell 0 11,alignx left");
		panelManagementSummary.add(labelManagementTermsOfEmploymentContent, "cell 0 12,alignx left");
		panelManagementSummary.add(labelManagementVacancyStatus, "cell 0 13,alignx left");
		panelManagementSummary.add(labelManagementVacancyStatusContent, "cell 0 14,alignx left");
		panelManagementSummary.add(labelManagementEducationalAchievement, "cell 0 15,alignx left");
		panelManagementSummary.add(labelManagementEducationalAchievementContent, "cell 0 16,alignx left");
		butttonAddVacancyManagement.setToolTipText("Neue Arbeitstelle hinzufügen");
		panelManagementButton.setLayout(new MigLayout("", "[]", "[]15[]15[]"));
		panelManagementButton.add(butttonAddVacancyManagement, "cell 0 0");
		butttonAddVacancyManagement.setBorderPainted(false);
		butttonAddVacancyManagement.setBorder(null);
		butttonAddVacancyManagement.setOpaque(false);
		butttonAddVacancyManagement.setContentAreaFilled(false);
		butttonAddVacancyManagement.setPreferredSize(new Dimension(135, 135));
		butttonAddVacancyManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				ArrayList<String> id= new ArrayList<String>();
				try {
					Connection con = DriverManager.getConnection(
							"jdbc:mysql://185.28.20.242:3306/u474396146_db",
							"u474396146_aptra", "aptraDB");
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("Select vacancyID,position from vacancy");

					while (rs.next()) {
						 id.add(rs.getString(1)+" - "+rs.getString(2));

					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				result = new String[id.size()];
				result = id.toArray(result);
				
				DialogOpenVacancy.addVacancyManagement();
			}
		});
		try {
			Image job = ImageIO.read(MenuBarPanelVacancyManagement.class
					.getResource("resources/management_open.png"));
			butttonAddVacancyManagement.setIcon(new ImageIcon(job));
		} catch (IOException ex) {
		}
		buttonEditVacancyManagement.setToolTipText("Bewerber bearbeiten");
		panelManagementButton.add(buttonEditVacancyManagement, "cell 0 1");
		buttonEditVacancyManagement.setBorderPainted(false);
		buttonEditVacancyManagement.setBorder(null);
		buttonEditVacancyManagement.setOpaque(false);
		buttonEditVacancyManagement.setContentAreaFilled(false);
		buttonEditVacancyManagement.setPreferredSize(new Dimension(135, 135));
		buttonEditVacancyManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (tableVacancyManagement.getSelectedRowCount() > 1
						|| tableVacancyManagement.getSelectedRowCount() == 0) {
					DialogEditWarning.selectOnlyOne();
				} else {
					EditVacancyManagement.getSelectedRow();
					Loading loading = new Loading();
					Thread threadLoading = new Thread(loading);
					threadLoading.start();
					DialogEditVacancyManagement edit = new DialogEditVacancyManagement();
					Thread threadEdit = new Thread(edit);
					threadEdit.start();
				    idApplicant = Integer.parseInt((String) MenuBarPanelVacancyManagement.tableVacancyManagement.getValueAt(MenuBarPanelVacancyManagement.tableVacancyManagement.getSelectedRow(), 0));
				}
			}
		});
		try {
			Image pencil = ImageIO.read(MenuBarPanelApplicant.class
					.getResource("resources/management_rate.png"));
			buttonEditVacancyManagement.setIcon(new ImageIcon(pencil));
		} catch (IOException ex) {
		}
		
		buttonSearchVacancyManagement.setToolTipText("Bewerber suchen");
		panelManagementButton.add(buttonSearchVacancyManagement, "cell 0 2");
		buttonSearchVacancyManagement.setBorderPainted(false);
		buttonSearchVacancyManagement.setBorder(null);
		buttonSearchVacancyManagement.setOpaque(false);
		buttonSearchVacancyManagement.setContentAreaFilled(false);
		buttonSearchVacancyManagement.setPreferredSize(new Dimension(135, 135));
		try {
			Image settings = ImageIO.read(MenuBarPanelApplicant.class
					.getResource("resources/management_search.png"));
			buttonSearchVacancyManagement.setIcon(new ImageIcon(settings));
		} catch (IOException ex) {
		}
		buttonSearchVacancyManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				DialogSearchVacancy.searchVacancy();
			}
		});
	
		// SWING:Table Arbeitsstellen
		modelVacancyManagement.setColumnIdentifiers(COLUMN_IDENTIFIERS_VACANCYMANAGEMENT);
		tableVacancyManagement.getTableHeader().setReorderingAllowed(false);
		tableVacancyManagement.setAutoCreateRowSorter(true);
		tableVacancyManagement = new JTable(modelVacancyManagement);
		scrollPaneVacancyManagement = new JScrollPane(tableVacancyManagement);
		scrollPaneVacancyManagement.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneVacancyManagement.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		tableVacancyManagement.setRowHeight(20);	
		Border border = new LineBorder(Color.gray, 1);
		panelManagementSummary.setBorder(border);
		panelManagementButton.setBorder(border);
		scrollPaneVacancyManagement.setBorder(border);
		panelVacancyManagement.add(panelManagementSummary, "cell 0 0, w 200:200:200 , h :1000:");
		panelVacancyManagement.add(scrollPaneVacancyManagement, "cell 1 0, w :1800: , h :1000:");
		panelVacancyManagement.add(panelManagementButton, "cell 2 0, w 150:150:150, h :1000:" );
		Oberflaeche.tabBar.addTab("Stellenmanagement", panelVacancyManagement);
		tableVacancyManagement.setAutoCreateRowSorter(true);

	}

	public static String[] getResult() {
		return result;
	}
	
	public static int getIDApplicant(){
		return idApplicant;
	}

}
