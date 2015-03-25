package git_aptra.MenuBar;

import git_aptra.Oberflaeche;
import git_aptra.DatabaseConnection.DeleteApplicant;
import git_aptra.DatabaseConnection.InsertApplicantDataIntoTable;
import git_aptra.DialogAddApplicant.DialogAddApplicant;
import git_aptra.DialogEditApplicant.DialogEditApplicant;
import git_aptra.DialogEditApplicant.DialogEditWarning;
import git_aptra.DialogEditApplicant.EditApplicant;
import git_aptra.DialogInfoApplicant.DialogInfoApplicant;
import git_aptra.DialogSearchApplicant.DialogSearchApplicant;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MenuBarPanelApplicant {
	private static JPanel panelApplicant = new JPanel();
	private static JPanel panelButtonApplicant = new JPanel();
	private static JPanel panelContentApplicant = new JPanel();
	private static JPanel panelInfoApplicant = new JPanel();
	private static JButton buttonAddApplicant = new JButton();
	private static JButton buttonDeleteApplicant = new JButton();
	private static JButton buttonEditApplicant = new JButton();
	private static JButton buttonSearchApplicant = new JButton();
	private static JButton buttonInfoApplicant = new JButton();
	private static JButton buttonRefreshApplicant = new JButton();
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
			add("Bewerbernummer");
			add("Name");
			add("Vorname");
			add("Stra�e");
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
		panelButtonApplicant
				.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		panelButtonApplicant.setBackground(Color.LIGHT_GRAY);
		panelButtonApplicant.setPreferredSize(new Dimension(150, 0));
		panelContentApplicant.setBackground(Color.LIGHT_GRAY);
		panelInfoApplicant.setBackground(Color.LIGHT_GRAY);
		panelInfoApplicant.setPreferredSize(new Dimension(0, 20));
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
		buttonAddApplicant.setToolTipText("Neuer Bewerber hinzuf�gen");
		panelButtonApplicant.add(buttonAddApplicant);
		buttonAddApplicant.setPreferredSize(new Dimension(135, 135));
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
		panelButtonApplicant.add(buttonEditApplicant);
		buttonEditApplicant.setPreferredSize(new Dimension(135, 135));
		try {
			Image pencil = ImageIO.read(MenuBarPanelApplicant.class
					.getResource("resources/applicant_edit.png"));
			buttonEditApplicant.setIcon(new ImageIcon(pencil));
		} catch (IOException ex) {
		}
		buttonEditApplicant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (tableApplicant.getSelectedRowCount() > 1) {
					DialogEditWarning.selectOnlyOne();
				} else {
					EditApplicant.getSelectedRow();
					DialogEditApplicant.editApplicant();
				}
			}
		});
		buttonDeleteApplicant.setToolTipText("Bewerber l�schen");
		panelButtonApplicant.add(buttonDeleteApplicant);
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
		buttonInfoApplicant.setPreferredSize(new Dimension(135, 135));
		try {
			Image close = ImageIO.read(MenuBarPanelApplicant.class
					.getResource("resources/applicant_info.png"));
			buttonInfoApplicant.setIcon(new ImageIcon(close));
		} catch (IOException ex) {
		}
		buttonInfoApplicant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				DialogInfoApplicant.infoApplicant();
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

	}

}
