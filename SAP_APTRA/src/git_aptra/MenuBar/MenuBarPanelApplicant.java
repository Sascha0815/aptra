package git_aptra.MenuBar;

import git_aptra.Oberflaeche;
import git_aptra.AddApplicant.DialogAddApplicant;
import git_aptra.AddApplicant.InsertApplicantDataIntoTable;
import git_aptra.Delete.DeleteApplicant;
import git_aptra.EditApplicant.DialogEditApplicant;
import git_aptra.EditApplicant.DialogEditWarning;
import git_aptra.EditApplicant.EditApplicant;
import git_aptra.InfoApplicant.DialogInfoApplicant;
import git_aptra.InfoApplicant.InfoApplicant;
import git_aptra.SearchApplicant.DialogSearchApplicant;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.table.DefaultTableModel;

public class MenuBarPanelApplicant {
	private static JPanel panelApplicant = new JPanel();
	private static JPanel panelButtonApplicant = new JPanel();
	private static JPanel panelContentApplicant = new JPanel();
	private static JPanel panelInfoApplicant = new JPanel();
	
	private static JLabel labelApplicantInfo = new JLabel();
	
	private static JButton buttonAddApplicant = new JButton();
	private static JButton buttonDeleteApplicant = new JButton();
	private static JButton buttonEditApplicant = new JButton();
	private static JButton buttonSearchApplicant = new JButton();
	private static JButton buttonInfoApplicant = new JButton();
	//private static JButton buttonRefreshApplicant = new JButton();
	
	private static String[] vacancyID;
	
	private static JScrollPane scrollPanePool = new JScrollPane();
	public static DefaultTableModel modelPool = new DefaultTableModel(1, 4) {
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	public static JTable tableApplicant = new JTable();
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public final static Vector COLUMN_IDENTIFIERS_APPLICANT = new Vector() {
		private static final long serialVersionUID = 1L;

		{
			add("Bewerber-ID");
			add("Name");
			add("Vorname");
			add("Straße");
			add("Hausnummer");
			add("PLZ");
			add("Wohnort");
			add("Telefon privat");
			add("Telefon mobil");
			add("E-Mail");
			add("Arbeitsstelle");
			add("Datum (J-M-T)");
			add("Bildungsabschluss");
		}
	};

	// SWING: Bewerber Panel
	public static void addPanelApplicant() {
		panelApplicant.setLayout(new BorderLayout(5, 5));
		panelApplicant.add(panelButtonApplicant, BorderLayout.EAST);
		panelApplicant.add(panelContentApplicant, BorderLayout.CENTER);
		panelApplicant.add(panelInfoApplicant, BorderLayout.SOUTH);
		panelInfoApplicant.add(labelApplicantInfo);
		labelApplicantInfo.setHorizontalAlignment(JLabel.LEFT);
		labelApplicantInfo.setText("Test");

		panelButtonApplicant
				.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		panelButtonApplicant.setBackground(Color.LIGHT_GRAY);
		panelButtonApplicant.setPreferredSize(new Dimension(150, 0));
		panelContentApplicant.setBackground(Color.LIGHT_GRAY);
		panelInfoApplicant.setBackground(Color.LIGHT_GRAY);
		panelInfoApplicant.setPreferredSize(new Dimension(0, 20));
		
		/*
		buttonRefreshApplicant.setToolTipText("Tabelle aktualisieren");
		panelButtonApplicant.add(buttonRefreshApplicant);
		buttonRefreshApplicant.setPreferredSize(new Dimension(135, 135));
		try {
			Image refreshApplicant = ImageIO.read(MenuBarPanelApplicant.class
					.getResource("resources/applicant_refresh.png"));
			buttonRefreshApplicant.setIcon(new ImageIcon(refreshApplicant));
		} catch (IOException ex) {
		}
		buttonRefreshApplicant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("rawtypes")
				Vector resultsApplicant = InsertApplicantDataIntoTable
						.insertApplicantDataIntoTable();
				modelPool.setDataVector(resultsApplicant,
						COLUMN_IDENTIFIERS_APPLICANT);
				modelPool.fireTableDataChanged();
			}
		});
		*/
		buttonAddApplicant.setToolTipText("Neuer Bewerber hinzufügen");
		panelButtonApplicant.add(buttonAddApplicant);
		buttonAddApplicant.setBorderPainted(false);
		buttonAddApplicant.setBorder(null);
		buttonAddApplicant.setBackground(Color.LIGHT_GRAY);
		buttonAddApplicant.setPreferredSize(new Dimension(135, 135));
		try {
			Image add = ImageIO.read(MenuBarPanelApplicant.class
					.getResource("resources/applicant_add.png"));
			buttonAddApplicant.setIcon(new ImageIcon(add));
		} catch (IOException ex) {
		}
		buttonAddApplicant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				ArrayList<String> id= new ArrayList<String>();
				try {
					Connection con = DriverManager.getConnection(
							"jdbc:mysql://185.28.20.242:3306/u474396146_db",
							"u474396146_aptra", "aptraDB");
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("Select vacancyID, position from vacancy");

					while (rs.next()) {
						 id.add(rs.getString(1) + " - " + rs.getString(2) );	

					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				vacancyID = new String[id.size()];
				vacancyID = id.toArray(vacancyID);
				DialogAddApplicant.newApplicant();
			}
		});
		buttonEditApplicant.setToolTipText("Bewerber bearbeiten");
		panelButtonApplicant.add(buttonEditApplicant);
		buttonEditApplicant.setBorderPainted(false);
		buttonEditApplicant.setBorder(null);
		buttonEditApplicant.setBackground(Color.LIGHT_GRAY);
		buttonEditApplicant.setPreferredSize(new Dimension(135, 135));
		try {
			Image pencil = ImageIO.read(MenuBarPanelApplicant.class
					.getResource("resources/applicant_edit.png"));
			buttonEditApplicant.setIcon(new ImageIcon(pencil));
		} catch (IOException ex) {
		}
		buttonEditApplicant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (tableApplicant.getSelectedRowCount() > 1 || tableApplicant.getSelectedRowCount() == 0 ) {
					DialogEditWarning.selectOnlyOne();
				} else {
					EditApplicant.getSelectedRow();
					DialogEditApplicant.editApplicant();
				}
			}
		});
		buttonDeleteApplicant.setToolTipText("Bewerber löschen");
		panelButtonApplicant.add(buttonDeleteApplicant);
		buttonDeleteApplicant.setBorderPainted(false);
		buttonDeleteApplicant.setBorder(null);
		buttonDeleteApplicant.setBackground(Color.LIGHT_GRAY);
		buttonDeleteApplicant.setPreferredSize(new Dimension(135, 135));
		try {
			Image trashcan = ImageIO.read(MenuBarPanelApplicant.class
					.getResource("resources/applicant_delete.png"));
			buttonDeleteApplicant.setIcon(new ImageIcon(trashcan));
		} catch (IOException ex) {
		}
		buttonDeleteApplicant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				DeleteApplicant.deleteApplicant();
				@SuppressWarnings("rawtypes")
				Vector resultsApplicant = InsertApplicantDataIntoTable
						.insertApplicantDataIntoTable();
				modelPool.setDataVector(resultsApplicant,
						COLUMN_IDENTIFIERS_APPLICANT);
				modelPool.fireTableDataChanged();
			}
		});
		buttonSearchApplicant.setToolTipText("Suchen");
		panelButtonApplicant.add(buttonSearchApplicant);
		buttonSearchApplicant.setBorderPainted(false);
		buttonSearchApplicant.setBorder(null);
		buttonSearchApplicant.setBackground(Color.LIGHT_GRAY);
		buttonSearchApplicant.setPreferredSize(new Dimension(135, 135));
		try {
			Image settings = ImageIO.read(MenuBarPanelApplicant.class
					.getResource("resources/applicant_search.png"));
			buttonSearchApplicant.setIcon(new ImageIcon(settings));
		} catch (IOException ex) {
		}
		buttonSearchApplicant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				DialogSearchApplicant.searchApplicant();
			}
		});

		buttonInfoApplicant.setToolTipText("Bewerberinformationen");
		panelButtonApplicant.add(buttonInfoApplicant);
		buttonInfoApplicant.setBorderPainted(false);
		buttonInfoApplicant.setBorder(null);
		buttonInfoApplicant.setBackground(Color.LIGHT_GRAY);
		buttonInfoApplicant.setPreferredSize(new Dimension(135, 135));
		try {
			Image close = ImageIO.read(MenuBarPanelApplicant.class
					.getResource("resources/applicant_info.png"));
			buttonInfoApplicant.setIcon(new ImageIcon(close));
		} catch (IOException ex) {
		}
		buttonInfoApplicant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (tableApplicant.getSelectedRowCount() > 1 || tableApplicant.getSelectedRowCount() == 0 ) {
					DialogEditWarning.selectOnlyOne();
				} else {
					InfoApplicant.getSelectedRow();
					DialogInfoApplicant.infoApplicant();
				}
			}
		});

		// SWING: Table Bewerberpool
		modelPool.setColumnIdentifiers(COLUMN_IDENTIFIERS_APPLICANT);
		tableApplicant.getTableHeader().setReorderingAllowed(false);
		tableApplicant.setAutoCreateRowSorter(true);
		tableApplicant = new JTable(modelPool);
		scrollPanePool = new JScrollPane(tableApplicant);
		panelApplicant.add(scrollPanePool);
		scrollPanePool.setPreferredSize(new Dimension(panelContentApplicant
				.getSize().width - 20,
				panelContentApplicant.getSize().height - 20));
		scrollPanePool
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPanePool
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		tableApplicant.setRowHeight(20);
		Oberflaeche.tabBar.addTab("Bewerber", panelApplicant);
		tableApplicant.setAutoCreateRowSorter(true);
	}
	
	public static String[] getVacancyID(){
		return vacancyID;
	}

}
