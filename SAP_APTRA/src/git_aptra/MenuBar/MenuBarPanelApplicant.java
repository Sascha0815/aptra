package git_aptra.MenuBar;

import git_aptra.Oberflaeche;
import git_aptra.AddApplicant.DialogAddApplicant;
import git_aptra.AddApplicant.InsertApplicantDataIntoTable;
import git_aptra.Delete.DeleteApplicant;
import git_aptra.EditApplicant.DialogEditApplicant;
import git_aptra.EditApplicant.DialogEditWarningApplicant;
import git_aptra.EditApplicant.EditApplicant;
import git_aptra.InfoApplicant.DialogInfoApplicant;
import git_aptra.InfoApplicant.InfoApplicant;
import git_aptra.Login.Login;
import git_aptra.SearchApplicant.DialogSearchApplicant;
import net.miginfocom.swing.MigLayout;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class MenuBarPanelApplicant {
	private static JPanel panelApplicant = new JPanel();
	private static JPanel panelButtonApplicant = new JPanel();
	
	private static JButton buttonAddApplicant = new JButton();
	private static JButton buttonDeleteApplicant = new JButton();
	private static JButton buttonEditApplicant = new JButton();
	private static JButton buttonSearchApplicant = new JButton();
	private static JButton buttonInfoApplicant = new JButton();
	private static JButton buttonRefreshApplicant = new JButton();
	
	private static String[] vacancyID;
	//@SuppressWarnings("unused")
	private static String[] division;
	private static String[] divisionData;
	
	private static JScrollPane scrollPanePool = new JScrollPane();
	public static DefaultTableModel modelPool = new DefaultTableModel() {
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
	private static JScrollPane paneButton = new JScrollPane(panelButtonApplicant);
	// SWING: Bewerber Panel
	public static void addPanelApplicant() {
		panelApplicant.setLayout(new MigLayout("", "[]5[]"));
		panelButtonApplicant.setLayout(new MigLayout("", "6.5%![]0%!", "20[]20[]20[]20[]20[]20[]"));
		buttonRefreshApplicant.setToolTipText("Tabelle aktualisieren");
		panelButtonApplicant.add(buttonRefreshApplicant, "cell 0 0");
		buttonRefreshApplicant.setOpaque(false);
		buttonRefreshApplicant.setContentAreaFilled(false);
		buttonRefreshApplicant.setBorder(null);
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
		
		buttonAddApplicant.setToolTipText("Neuer Bewerber hinzufügen");
		panelButtonApplicant.add(buttonAddApplicant, "cell 0 1");
		buttonAddApplicant.setOpaque(false);
		buttonAddApplicant.setContentAreaFilled(false);
		buttonAddApplicant.setBorder(null);
		try {
			Image add = ImageIO.read(MenuBarPanelApplicant.class
					.getResource("resources/applicant_add.png"));   
			buttonAddApplicant.setIcon(new ImageIcon(add));
		} catch (IOException ex) {
		}
		buttonAddApplicant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				DialogAddApplicant.newApplicant();
			}
		});
		buttonEditApplicant.setToolTipText("Bewerber bearbeiten");
		panelButtonApplicant.add(buttonEditApplicant, "cell 0 2");
		buttonEditApplicant.setOpaque(false);
		buttonEditApplicant.setContentAreaFilled(false);
		buttonEditApplicant.setBorder(null);
		buttonEditApplicant.setSize(panelButtonApplicant.getWidth(), panelButtonApplicant.getWidth());
		try {
			Image pencil = ImageIO.read(MenuBarPanelApplicant.class
					.getResource("resources/applicant_edit.png"));   
			buttonEditApplicant.setIcon(new ImageIcon(pencil));
		} catch (IOException ex) {
		}
		buttonEditApplicant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (tableApplicant.getSelectedRowCount() == 0 ) {
					DialogEditWarningApplicant.nothingSelected();
				}	
				if (tableApplicant.getSelectedRowCount() > 1 ){
					DialogEditWarningApplicant.tooManySelected();
				} else {
					ArrayList<String> id= new ArrayList<String>();
					try {
						Connection con = Login.getConnection();
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
					
					ArrayList<String> division= new ArrayList<String>();
					try {
						Connection con = Login.getConnection();
						Statement stmt = con.createStatement();
						ResultSet rs = stmt.executeQuery("Select divisionID, notation from division");

						while (rs.next()) {
							division.add(rs.getString(1) + " - " + rs.getString(2) );	

						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
					divisionData = new String[division.size()];
					divisionData = division.toArray(divisionData);
					EditApplicant.getSelectedRow();
					DialogEditApplicant.editApplicant();
				}
			}
		});
		buttonDeleteApplicant.setToolTipText("Bewerber löschen");
		panelButtonApplicant.add(buttonDeleteApplicant, "cell 0 3");
		buttonDeleteApplicant.setBorder(null);
		buttonDeleteApplicant.setOpaque(false);
		buttonDeleteApplicant.setContentAreaFilled(false);
		buttonDeleteApplicant.setSize(panelButtonApplicant.getWidth(), panelButtonApplicant.getWidth());
		try {
			Image trashcan = ImageIO.read(MenuBarPanelApplicant.class
					.getResource("resources/applicant_delete.png"));  
			buttonDeleteApplicant.setIcon(new ImageIcon(trashcan));
		} catch (IOException ex) {
		}
		buttonDeleteApplicant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					DeleteApplicant.deleteApplicant();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				@SuppressWarnings("rawtypes")
				Vector resultsApplicant = InsertApplicantDataIntoTable
						.insertApplicantDataIntoTable();
				modelPool.setDataVector(resultsApplicant,
						COLUMN_IDENTIFIERS_APPLICANT);
				modelPool.fireTableDataChanged();
			}
		});
		buttonSearchApplicant.setToolTipText("Suchen");
		panelButtonApplicant.add(buttonSearchApplicant, "cell 0 4");
		buttonSearchApplicant.setBorder(null);
		buttonSearchApplicant.setOpaque(false);
		buttonSearchApplicant.setContentAreaFilled(false);
		buttonSearchApplicant.setSize(panelButtonApplicant.getWidth(), panelButtonApplicant.getWidth());
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
		panelButtonApplicant.add(buttonInfoApplicant, "cell 0 5");
		buttonInfoApplicant.setBorderPainted(false);
		buttonInfoApplicant.setBorder(null);
		buttonInfoApplicant.setOpaque(false);
		buttonInfoApplicant.setContentAreaFilled(false);
		buttonInfoApplicant.setSize(panelButtonApplicant.getWidth(), panelButtonApplicant.getWidth());
		try {
			Image close = ImageIO.read(MenuBarPanelApplicant.class
					.getResource("resources/applicant_info.png"));  
			buttonInfoApplicant.setIcon(new ImageIcon(close));
		} catch (IOException ex) {
		}
		buttonInfoApplicant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (tableApplicant.getSelectedRowCount() == 0 ) {
					DialogEditWarningApplicant.nothingSelected();
				}	
				if (tableApplicant.getSelectedRowCount() > 1 ){
						DialogEditWarningApplicant.tooManySelected();
				} else {
					InfoApplicant.getApplicantInfo();
					DialogInfoApplicant.infoApplicant();
				}
			}
		});

		modelPool.setColumnIdentifiers(COLUMN_IDENTIFIERS_APPLICANT);
		tableApplicant.getTableHeader().setReorderingAllowed(false);
		tableApplicant.setAutoCreateRowSorter(true);
		tableApplicant = new JTable(modelPool);
		scrollPanePool = new JScrollPane(tableApplicant);		
		scrollPanePool.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		tableApplicant.setRowHeight(20);
		Border border = new LineBorder(Color.gray, 1);
		scrollPanePool.setBorder(border);
		panelButtonApplicant.setBorder(border);
		panelApplicant.add(scrollPanePool, "cell 0 0, w :1800: , h :1000:");
		scrollPanePool.setSize((int)(panelApplicant.getWidth()*0.8),panelApplicant.getHeight());
		panelApplicant.add(paneButton, "cell 1 0, w 170:170:170, h :1000:");   
		panelButtonApplicant.setSize((int)(panelApplicant.getWidth()*0.2),panelApplicant.getHeight());
		Oberflaeche.tabBar.addTab("Bewerber", panelApplicant);
		tableApplicant.setAutoCreateRowSorter(true);
		
		if (Login.getEntitlement()>1) {
			buttonDeleteApplicant.setEnabled(false);
			buttonEditApplicant.setEnabled(false);			
		}
		if (Login.getEntitlement()==3) {
			buttonAddApplicant.setEnabled(false);
		}
	}
	
	public static String[] getVacancyID(){
		return vacancyID;
	}
	
	public static String[] getDivision(){
		return divisionData;
	}

}
