package git_aptra;

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
	private static JButton buttonAdd = new JButton();
	private static JButton buttonDelete = new JButton();
	private static JButton buttonEdit = new JButton();
	private static JButton buttonSettings = new JButton();
	private static JButton buttonExit = new JButton();
	private static JButton buttonRefreshApplicant = new JButton();
	private static JScrollPane scrollPanePool = new JScrollPane();
	public static DefaultTableModel modelPool = new DefaultTableModel(1, 4) {
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	public static JTable tableApplicant = new JTable();
	public final static Vector COLUMN_IDENTIFIERS_APPLICANT = new Vector() {
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

	// legt das Panel Bewerber an
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
					.getResource("resources/refreshApplicant.png"));
			buttonRefreshApplicant.setIcon(new ImageIcon(refreshApplicant));
		} catch (IOException ex) {
		}
		buttonRefreshApplicant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vector resultsApplicant = Steuerung
						.getInsertApplicantDataIntoTable()
						.insertApplicantDataIntoTable();
				modelPool.setDataVector(resultsApplicant,
						COLUMN_IDENTIFIERS_APPLICANT);
				modelPool.fireTableDataChanged();
			}
		});
		buttonAdd.setToolTipText("Neuer Bewerber hinzuf�gen");
		panelButtonApplicant.add(buttonAdd);
		buttonAdd.setPreferredSize(new Dimension(135, 135));
		try {
			Image add = ImageIO.read(MenuBarPanelApplicant.class
					.getResource("resources/add.png"));
			buttonAdd.setIcon(new ImageIcon(add));
		} catch (IOException ex) {
		}
		buttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				DialogAddApplicant.newApplicant();
				;
			}
		});
		buttonEdit.setToolTipText("Bewerber bearbeiten");
		panelButtonApplicant.add(buttonEdit);
		buttonEdit.setPreferredSize(new Dimension(135, 135));
		try {
			Image pencil = ImageIO.read(MenuBarPanelApplicant.class
					.getResource("resources/pencil.png"));
			buttonEdit.setIcon(new ImageIcon(pencil));
		} catch (IOException ex) {
		}
		buttonDelete.setToolTipText("Bewerber l�schen");
		panelButtonApplicant.add(buttonDelete);
		buttonDelete.setPreferredSize(new Dimension(135, 135));
		try {
			Image trashcan = ImageIO.read(MenuBarPanelApplicant.class
					.getResource("resources/trashcan.png"));
			buttonDelete.setIcon(new ImageIcon(trashcan));
		} catch (IOException ex) {
		}
		buttonDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Steuerung.getDeleteApplicant().deleteApplicant();
				Vector resultsApplicant = Steuerung
						.getInsertApplicantDataIntoTable()
						.insertApplicantDataIntoTable();
				modelPool.setDataVector(resultsApplicant,
						COLUMN_IDENTIFIERS_APPLICANT);
				modelPool.fireTableDataChanged();
			}
		});
		buttonSettings.setToolTipText("Einstellungen");
		panelButtonApplicant.add(buttonSettings);
		buttonSettings.setPreferredSize(new Dimension(135, 135));
		try {
			Image settings = ImageIO.read(MenuBarPanelApplicant.class
					.getResource("resources/settings_big.png"));
			buttonSettings.setIcon(new ImageIcon(settings));
		} catch (IOException ex) {
		}
		buttonExit.setToolTipText("Programm schlie�en");
		panelButtonApplicant.add(buttonExit);
		buttonExit.setPreferredSize(new Dimension(135, 135));
		try {
			Image close = ImageIO.read(MenuBarPanelApplicant.class
					.getResource("resources/close_big.png"));
			buttonExit.setIcon(new ImageIcon(close));
		} catch (IOException ex) {
		}
		buttonExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Oberflaeche.frame.dispose();
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
		Oberflaeche.tabBar.addTab("Bewerber", panelApplicant);

	}

}
