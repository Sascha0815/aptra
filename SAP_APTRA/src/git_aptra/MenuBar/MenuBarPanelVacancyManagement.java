package git_aptra.MenuBar;

import git_aptra.Oberflaeche;
import git_aptra.EditApplicant.DialogEditWarning;
import git_aptra.EditVacancyManagement.DialogEditVacancyManagement;
import git_aptra.EditVacancyManagement.EditVacancyManagement;
import git_aptra.SearchVacancy.DialogSearchVacancy;
import git_aptra.VacancyManagement.DialogOpenVacancy;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
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

public class MenuBarPanelVacancyManagement {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public final static Vector COLUMN_IDENTIFIERS_VACANCYMANAGEMENT = new Vector() {
		private static final long serialVersionUID = 1L;

		{
			add("Bewerber-ID");
			add("Name");
			add("Vorname");
			add("Status");
			add("Neuste Notiz");
			add("Datum der Notiz");
			add("Anmerkung zu der Notiz");

		}
	};
	private static JPanel panelVacancyManagement = new JPanel();
	private static JPanel panelManagementContent = new JPanel();
	private static JPanel panelManagementInfo = new JPanel();
	private static JPanel panelManagementButton = new JPanel();
	private static JPanel panelManagementSummary = new JPanel();

	private static Font fontHeadline = new Font("Arial", Font.BOLD, 22);
	private static Font fontSubHeadline = new Font("Arial", Font.BOLD, 14);
	private static Font fontContent = new Font("Arial", Font.ITALIC, 14);

	private static JButton butttonAddVacancyManagement = new JButton();
	private static JButton buttonDeleteVacancyManagement = new JButton();
	private static JButton buttonEditVacancyManagement = new JButton();
	private static JButton buttonSearchVacancyManagement = new JButton();
	private static JButton buttonSettingsVacancyManagement = new JButton();
	public static DefaultTableModel modelVacancyManagement = new DefaultTableModel(
			1, 4) {
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	public static JTable tableVacancyManagement = new JTable(
			modelVacancyManagement);

	private static JLabel labelManagementInfo = new JLabel("Info zur Stelle");
	private static JLabel labelManagementCount = new JLabel(
			"Anzahl der Bewerber:");
	private static JLabel labelManagementEndOfApply = new JLabel(
			"Bewerbungsschluss:");
	private static JLabel labelManagementPosition = new JLabel(
			"Stellenbezeichnung:");
	private static JLabel labelManagementArea = new JLabel("Arbeitsbereich:");
	private static JLabel labelManagementRequirementLevel = new JLabel(
			"Anforderung:");
	private static JLabel labelManagementTermsOfEmployment = new JLabel(
			"Anstellungsverhältnis:");
	private static JLabel labelManagementVacancyStatus = new JLabel("Status:");
	private static JLabel labelManagementEducationalAchievement = new JLabel(
			"Bildungsabschluss:");
	public static JLabel labelManagementCountContent = new JLabel();
	public static JLabel labelManagementEndOfApplyContent = new JLabel();
	public static JLabel labelManagementPositionContent = new JLabel();
	public static JLabel labelManagementAreaContent = new JLabel();
	public static JLabel labelManagementRequirementLevelContent = new JLabel();
	public static JLabel labelManagementTermsOfEmploymentContent = new JLabel();
	public static JLabel labelManagementVacancyStatusContent = new JLabel();
	public static JLabel labelManagementEducationalAchievementContent = new JLabel();

	// SWING: Arbeitsstellen Panel
	public static void addPanelVacancyManagement() {

		panelVacancyManagement.setLayout(new BorderLayout(5, 5));
		panelVacancyManagement.add(panelManagementButton, BorderLayout.EAST);
		panelVacancyManagement.add(panelManagementContent, BorderLayout.CENTER);
		panelVacancyManagement.add(panelManagementInfo, BorderLayout.SOUTH);
		panelVacancyManagement.add(panelManagementSummary, BorderLayout.WEST);

		// Management-Stelleninfo (links)
		panelManagementSummary.setBackground(Color.LIGHT_GRAY);
		panelManagementSummary.setLayout(new BoxLayout(panelManagementSummary, BoxLayout.Y_AXIS));
		panelManagementSummary.setPreferredSize(new Dimension(180, 0));
		panelManagementSummary.add(labelManagementInfo);
		labelManagementInfo.setFont(fontHeadline);
		panelManagementSummary.add(Box.createRigidArea(new Dimension(0, 30)));
		panelManagementSummary.add(labelManagementCount);
		labelManagementCount.setFont(fontSubHeadline);
		panelManagementSummary.add(labelManagementCountContent);
		labelManagementCountContent.setFont(fontContent);		
		panelManagementSummary.add(Box.createRigidArea(new Dimension(0, 10)));
		panelManagementSummary.add(labelManagementEndOfApply);
		labelManagementEndOfApply.setFont(fontSubHeadline);
		panelManagementSummary.add(labelManagementEndOfApplyContent);
		labelManagementEndOfApplyContent.setFont(fontContent);
		panelManagementSummary.add(Box.createRigidArea(new Dimension(0, 10)));
		panelManagementSummary.add(labelManagementPosition);
		labelManagementPosition.setFont(fontSubHeadline);
		panelManagementSummary.add(labelManagementPositionContent);
		labelManagementPositionContent.setFont(fontContent);
		panelManagementSummary.add(Box.createRigidArea(new Dimension(0, 10)));
		panelManagementSummary.add(labelManagementArea);
		labelManagementArea.setFont(fontSubHeadline);
		panelManagementSummary.add(labelManagementAreaContent);
		labelManagementAreaContent.setFont(fontContent);
		panelManagementSummary.add(Box.createRigidArea(new Dimension(0, 10)));
		panelManagementSummary.add(labelManagementRequirementLevel);
		labelManagementRequirementLevel.setFont(fontSubHeadline);
		panelManagementSummary.add(labelManagementRequirementLevelContent);
		labelManagementRequirementLevelContent.setFont(fontContent);
		panelManagementSummary.add(Box.createRigidArea(new Dimension(0, 10)));
		panelManagementSummary.add(labelManagementTermsOfEmployment);
		labelManagementTermsOfEmployment.setFont(fontSubHeadline);
		panelManagementSummary.add(labelManagementTermsOfEmploymentContent);
		labelManagementTermsOfEmploymentContent.setFont(fontContent);
		panelManagementSummary.add(Box.createRigidArea(new Dimension(0, 10)));
		panelManagementSummary.add(labelManagementVacancyStatus);
		labelManagementVacancyStatus.setFont(fontSubHeadline);
		panelManagementSummary.add(labelManagementVacancyStatusContent);
		labelManagementVacancyStatusContent.setFont(fontContent);
		panelManagementSummary.add(Box.createRigidArea(new Dimension(0, 10)));
		panelManagementSummary.add(labelManagementEducationalAchievement);
		labelManagementEducationalAchievement.setFont(fontSubHeadline);
		panelManagementSummary.add(labelManagementEducationalAchievementContent);
		labelManagementEducationalAchievementContent.setFont(fontContent);		
		panelManagementContent.setLayout(new FlowLayout(FlowLayout.CENTER, 20,
				20));
		panelManagementButton.setLayout(new FlowLayout(FlowLayout.CENTER, 20,
				20));
		panelManagementButton.setBackground(Color.LIGHT_GRAY);
		panelManagementButton.setPreferredSize(new Dimension(150, 0));
		panelManagementContent.setBackground(Color.LIGHT_GRAY);
		panelManagementInfo.setBackground(Color.LIGHT_GRAY);
		panelManagementInfo.setPreferredSize(new Dimension(0, 20));
		butttonAddVacancyManagement
				.setToolTipText("Neue Arbeitstelle hinzufügen");
		panelManagementButton.add(butttonAddVacancyManagement);
		butttonAddVacancyManagement.setPreferredSize(new Dimension(135, 135));
		butttonAddVacancyManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				DialogOpenVacancy.addVacancyManagement();

			}
		});
		try {
			Image job = ImageIO.read(MenuBarPanelVacancyManagement.class
					.getResource("resources/job_add.png"));
			butttonAddVacancyManagement.setIcon(new ImageIcon(job));
		} catch (IOException ex) {
		}
		buttonEditVacancyManagement.setToolTipText("Bewerber bearbeiten");
		panelManagementButton.add(buttonEditVacancyManagement);
		buttonEditVacancyManagement.setPreferredSize(new Dimension(135, 135));
		buttonEditVacancyManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (tableVacancyManagement.getSelectedRowCount() > 1
						|| tableVacancyManagement.getSelectedRowCount() == 0) {
					DialogEditWarning.selectOnlyOne();
				} else {
					EditVacancyManagement.getSelectedRow();
					DialogEditVacancyManagement.editVacancyManagement();
				}
			}
		});
		try {
			Image pencil = ImageIO.read(MenuBarPanelApplicant.class
					.getResource("resources/job_edit.png"));
			buttonEditVacancyManagement.setIcon(new ImageIcon(pencil));
		} catch (IOException ex) {
		}

		buttonDeleteVacancyManagement.setToolTipText("Bewerber löschen");
		panelManagementButton.add(buttonDeleteVacancyManagement);
		buttonDeleteVacancyManagement.setPreferredSize(new Dimension(135, 135));
		try {
			Image trashcan = ImageIO.read(MenuBarPanelApplicant.class
					.getResource("resources/job_delete.png"));
			buttonDeleteVacancyManagement.setIcon(new ImageIcon(trashcan));
		} catch (IOException ex) {
		}
		buttonDeleteVacancyManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {

			}
		});
		buttonSearchVacancyManagement.setToolTipText("Einstellungen");
		panelManagementButton.add(buttonSearchVacancyManagement);
		buttonSearchVacancyManagement.setPreferredSize(new Dimension(135, 135));
		try {
			Image settings = ImageIO.read(MenuBarPanelApplicant.class
					.getResource("resources/job_search.png"));
			buttonSearchVacancyManagement.setIcon(new ImageIcon(settings));
		} catch (IOException ex) {
		}
		buttonSearchVacancyManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				DialogSearchVacancy.searchVacancy();
			}
		});
		buttonSettingsVacancyManagement.setToolTipText("Programm schließen");
		panelManagementButton.add(buttonSettingsVacancyManagement);
		buttonSettingsVacancyManagement
				.setPreferredSize(new Dimension(135, 135));
		try {
			Image close = ImageIO.read(MenuBarPanelApplicant.class
					.getResource("resources/job_settings.png"));
			buttonSettingsVacancyManagement.setIcon(new ImageIcon(close));
		} catch (IOException ex) {
		}
		buttonSettingsVacancyManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {

			}
		});

		// SWING:Table Arbeitsstellen
		modelVacancyManagement
				.setColumnIdentifiers(COLUMN_IDENTIFIERS_VACANCYMANAGEMENT);
		tableVacancyManagement.getTableHeader().setReorderingAllowed(false);
		tableVacancyManagement.setAutoCreateRowSorter(true);
		tableVacancyManagement = new JTable(modelVacancyManagement);
		JScrollPane scrollPaneVacancyManagement = new JScrollPane(
				tableVacancyManagement);
		panelVacancyManagement.add(scrollPaneVacancyManagement);
		scrollPaneVacancyManagement.setPreferredSize(new Dimension(
				panelManagementContent.getSize().width - 20,
				panelManagementContent.getSize().height - 15));
		scrollPaneVacancyManagement
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneVacancyManagement
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		tableVacancyManagement.setRowHeight(20);
		Oberflaeche.tabBar.addTab("Stellenmanagement", panelVacancyManagement);

	}

}
