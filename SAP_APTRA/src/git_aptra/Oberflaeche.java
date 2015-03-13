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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Oberflaeche extends JFrame {

	// Swing-Elemente

	private static final long serialVersionUID = 1L;

	public static JFrame frame = new JFrame();

	private JMenuBar menuBar = new JMenuBar();
	private JMenu menuNew = new JMenu();
	private JMenu menuHelp = new JMenu();
	private JMenu menuSettings = new JMenu();

	private JMenuItem itemApplicant = new JMenuItem();
	private JMenuItem itemJob = new JMenuItem();
	private JMenuItem itemAbout = new JMenuItem();
	private JMenuItem itemExit = new JMenuItem();
	private JMenuItem itemChangeDesign = new JMenuItem();

	private JTabbedPane tabBar = new JTabbedPane(JTabbedPane.TOP,
			JTabbedPane.SCROLL_TAB_LAYOUT);

	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	private JPanel panel4 = new JPanel();
	private JPanel panelButton1 = new JPanel();
	private JPanel panelContent1 = new JPanel();
	private JPanel panelInfo1 = new JPanel();
	private JPanel panelButton2 = new JPanel();
	private JPanel panelContent2 = new JPanel();
	private JPanel panelInfo2 = new JPanel();
	private JPanel panelButton3 = new JPanel();
	private JPanel panelContent3 = new JPanel();
	private JPanel panelInfo3 = new JPanel();
	private JPanel panelButton4 = new JPanel();
	private JPanel panelContent4 = new JPanel();
	private JPanel panelInfo4 = new JPanel();

	private JButton buttonAdd = new JButton();
	private JButton buttonDeleteApplicant = new JButton();
	private JButton buttonDeleteJob = new JButton();
	private JButton buttonEditApplicant = new JButton();
	private JButton buttonEditJob = new JButton();
	private JButton buttonSettingsApplicant = new JButton();
	private JButton buttonSettingsJob = new JButton();
	private JButton buttonJob = new JButton();
	private JButton buttonExitApplicant = new JButton();
	private JButton buttonExitJob = new JButton();
	private JButton buttonRefreshApplicant = new JButton();
	private JButton buttonRefreshJob = new JButton();

	public static DefaultTableModel modelPool = new DefaultTableModel(1, 4) {
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	private DefaultTableModel modelJob = new DefaultTableModel(1, 4) {
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};

	private JTable tableJob = new JTable(modelJob);
	public static JTable tableApplicant = new JTable();

	private JLabel labelApplicantPic = new JLabel();
	private JLabel labelBackground = new JLabel();
	

	

	// Objekte

	final private static Datenbank datenbank = new Datenbank();
	final private static Steuerung steuerung = new Steuerung();

	public static Datenbank getDatenbank(){
		return datenbank;
	}
	public static Steuerung getSteuerung(){
		return steuerung;
	}
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

	public final static Vector COLUMN_IDENTIFIERS_JOB = new Vector() {
		{
			add("Name");
			add("Vorname");
			add("Stra�e");
			add("Hausnummer");
			add("PLZ");
			add("Wohnort");
		}
	};

	public Oberflaeche(String title) {

		// SWING: Frame
		super(title);
		frame.setSize(1200, 800);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
		frame.setTitle("Bewerberverwaltung");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);

			ImageIcon img = new ImageIcon("logo.png");
			frame.setIconImage(img.getImage());
	

		// SWING: Panel1
		panel1.setLayout(new BorderLayout(5, 5));
		panel1.add(panelButton1, BorderLayout.EAST);
		panel1.add(panelContent1, BorderLayout.CENTER);
		panelContent1.add(labelApplicantPic);
		labelApplicantPic.setPreferredSize(new Dimension(135, 135));
		panel1.add(panelInfo1, BorderLayout.SOUTH);
		panelButton1.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		panelButton1.setBackground(Color.LIGHT_GRAY);
		panelButton1.setPreferredSize(new Dimension(150, 0));
		panelContent1.setBackground(Color.LIGHT_GRAY);
		panelInfo1.setBackground(Color.LIGHT_GRAY);
		panelInfo1.setPreferredSize(new Dimension(0, 20));

		// SWING: Panel2
		panel2.setLayout(new BorderLayout(5, 5));
		panel2.add(panelButton2, BorderLayout.EAST);
		panel2.add(panelContent2, BorderLayout.CENTER);
		panel2.add(panelInfo2, BorderLayout.SOUTH);
		panelButton2.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		panelButton2.setBackground(Color.LIGHT_GRAY);
		panelButton2.setPreferredSize(new Dimension(150, 0));
		panelContent2.setBackground(Color.LIGHT_GRAY);
		panelInfo2.setBackground(Color.LIGHT_GRAY);
		panelInfo2.setPreferredSize(new Dimension(0, 20));
		buttonRefreshApplicant.setToolTipText("Tabelle aktualisieren");
		panelButton2.add(buttonRefreshApplicant);
		buttonRefreshApplicant.setPreferredSize(new Dimension(135, 135));
		try {
			Image refreshApplicant = ImageIO.read(getClass().getResource(
					"resources/refreshApplicant.png"));
			buttonRefreshApplicant.setIcon(new ImageIcon(refreshApplicant));
		} catch (IOException ex) {
		}
		buttonRefreshApplicant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vector resultsApplicant = datenbank
						.insertApplicantDataIntoTable();
				modelPool.setDataVector(resultsApplicant,
						COLUMN_IDENTIFIERS_APPLICANT);
				modelPool.fireTableDataChanged();
			}
		});
		buttonAdd.setToolTipText("Neuer Bewerber hinzuf�gen");
		panelButton2.add(buttonAdd);
		buttonAdd.setPreferredSize(new Dimension(135, 135));
		try {
			Image add = ImageIO.read(getClass()
					.getResource("resources/add.png"));
			buttonAdd.setIcon(new ImageIcon(add));
		} catch (IOException ex) {
		}
		buttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				steuerung.dialogAddApplicant();
			}
		});
		buttonEditApplicant.setToolTipText("Bewerber bearbeiten");
		panelButton2.add(buttonEditApplicant);
		buttonEditApplicant.setPreferredSize(new Dimension(135, 135));
		try {
			Image pencil = ImageIO.read(getClass().getResource(
					"resources/pencil.png"));
			buttonEditApplicant.setIcon(new ImageIcon(pencil));
		} catch (IOException ex) {
		}
		buttonDeleteApplicant.setToolTipText("Bewerber l�schen");
		panelButton2.add(buttonDeleteApplicant);
		buttonDeleteApplicant.setPreferredSize(new Dimension(135, 135));
		try {
			Image trashcan = ImageIO.read(getClass().getResource(
					"resources/trashcan.png"));
			buttonDeleteApplicant.setIcon(new ImageIcon(trashcan));
		} catch (IOException ex) {
		}
		buttonDeleteApplicant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				datenbank.deleteApplicant();
				Vector resultsApplicant = datenbank
						.insertApplicantDataIntoTable();
				modelPool.setDataVector(resultsApplicant,
						COLUMN_IDENTIFIERS_APPLICANT);
				modelPool.fireTableDataChanged();
			}
		});
		buttonSettingsApplicant.setToolTipText("Einstellungen");
		panelButton2.add(buttonSettingsApplicant);
		buttonSettingsApplicant.setPreferredSize(new Dimension(135, 135));
		try {
			Image settings = ImageIO.read(getClass().getResource(
					"resources/settings_big.png"));
			buttonSettingsApplicant.setIcon(new ImageIcon(settings));
		} catch (IOException ex) {
		}
		buttonExitApplicant.setToolTipText("Programm schlie�en");
		panelButton2.add(buttonExitApplicant);
		buttonExitApplicant.setPreferredSize(new Dimension(135, 135));
		try {
			Image close = ImageIO.read(getClass().getResource(
					"resources/close_big.png"));
			buttonExitApplicant.setIcon(new ImageIcon(close));
		} catch (IOException ex) {
		}
		buttonExitApplicant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				frame.dispose();
			}
		});

		// SWING: Panel3
		panel3.setLayout(new BorderLayout(5, 5));
		panel3.add(panelButton3, BorderLayout.EAST);
		panel3.add(panelContent3, BorderLayout.CENTER);
		panel3.add(panelInfo3, BorderLayout.SOUTH);
		panelButton3.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		panelButton3.setBackground(Color.LIGHT_GRAY);
		panelButton3.setPreferredSize(new Dimension(150, 0));
		panelContent3.setBackground(Color.LIGHT_GRAY);
		panelInfo3.setBackground(Color.LIGHT_GRAY);
		panelInfo3.setPreferredSize(new Dimension(0, 20));
		buttonRefreshJob.setToolTipText("Tabelle aktualisieren");
		panelButton3.add(buttonRefreshJob);
		buttonRefreshJob.setPreferredSize(new Dimension(135, 135));
		buttonRefreshJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		try {
			Image add = ImageIO.read(getClass().getResource(
					"resources/refreshApplicant.png"));
			buttonRefreshJob.setIcon(new ImageIcon(add));
		} catch (IOException ex) {
		}
		buttonJob.setToolTipText("Neue Arbeitstelle hinzuf�gen");
		panelButton3.add(buttonJob);
		buttonJob.setPreferredSize(new Dimension(135, 135));
		buttonJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				steuerung.dialogAddVacancy();
			}
		});
		try {
			Image job = ImageIO.read(getClass()
					.getResource("resources/job.png"));
			buttonJob.setIcon(new ImageIcon(job));
		} catch (IOException ex) {
		}
		buttonEditJob.setToolTipText("Neue Arbeitstelle hinzuf�gen");
		panelButton3.add(buttonEditJob);
		buttonEditJob.setPreferredSize(new Dimension(135, 135));
		buttonEditJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
			}
		});
		try {
			Image pencil = ImageIO.read(getClass().getResource(
					"resources/pencil.png"));
			buttonEditJob.setIcon(new ImageIcon(pencil));
		} catch (IOException ex) {
		}
		buttonDeleteJob.setToolTipText("Bewerber l�schen");
		panelButton3.add(buttonDeleteJob);
		buttonDeleteJob.setPreferredSize(new Dimension(135, 135));
		try {
			Image trashcan = ImageIO.read(getClass().getResource(
					"resources/trashcan.png"));
			buttonDeleteJob.setIcon(new ImageIcon(trashcan));
		} catch (IOException ex) {
		}
		buttonSettingsJob.setToolTipText("Einstellungen");
		panelButton3.add(buttonSettingsJob);
		buttonSettingsJob.setPreferredSize(new Dimension(135, 135));
		try {
			Image settings = ImageIO.read(getClass().getResource(
					"resources/settings_big.png"));
			buttonSettingsJob.setIcon(new ImageIcon(settings));
		} catch (IOException ex) {
		}
		buttonExitJob.setToolTipText("Programm schlie�en");
		panelButton3.add(buttonExitJob);
		buttonExitJob.setPreferredSize(new Dimension(135, 135));
		try {
			Image close = ImageIO.read(getClass().getResource(
					"resources/close_big.png"));
			buttonExitJob.setIcon(new ImageIcon(close));
		} catch (IOException ex) {
		}
		buttonExitJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				frame.dispose();
			}
		});
		

		// SWING: Panel4
		panel4.setLayout(new BorderLayout(5, 5));
		panel4.add(panelButton4, BorderLayout.EAST);
		panel4.add(panelContent4, BorderLayout.CENTER);
		panel4.add(panelInfo4, BorderLayout.SOUTH);
		panelButton4.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		panelButton4.setBackground(Color.LIGHT_GRAY);
		panelButton4.setPreferredSize(new Dimension(150, 0));
		panelContent4.setBackground(Color.LIGHT_GRAY);
		panelInfo4.setBackground(Color.LIGHT_GRAY);
		panelInfo4.setPreferredSize(new Dimension(0, 20));

		// SWING: MenuBar
		frame.setJMenuBar(menuBar);
		itemApplicant.setText("Neuer Bewerber");
		itemAbout.setText("�ber");
		itemJob.setText("Neues Stellenangebot");
		itemExit.setText("Beenden");
		itemChangeDesign.setText("Desgin �ndern");
		menuBar.add(menuNew);
		menuNew.setText("Neu");
		menuNew.add(itemApplicant);
		menuNew.add(itemJob);
		menuNew.add(itemExit);
		menuBar.add(menuSettings);
		menuSettings.setText("Einstellungen");
		menuSettings.add(itemChangeDesign);
		menuBar.add(menuHelp);
		menuHelp.setText("Hilfe");
		menuHelp.add(itemAbout);
		try {
			Image close = ImageIO.read(getClass().getResource(
					"resources/close.png"));
			itemExit.setIcon(new ImageIcon(close));
		} catch (IOException ex) {
		}
		try {
			Image plus = ImageIO.read(getClass().getResource(
					"resources/plus.png"));
			itemApplicant.setIcon(new ImageIcon(plus));
		} catch (IOException ex) {
		}
		try {
			Image job = ImageIO.read(getClass().getResource(
					"resources/job_small.png"));
			itemJob.setIcon(new ImageIcon(job));
		} catch (IOException ex) {
		}
		try {
			Image settings = ImageIO.read(getClass().getResource(
					"resources/settings.png"));
			itemChangeDesign.setIcon(new ImageIcon(settings));
		} catch (IOException ex) {
		}
		try {
			Image about = ImageIO.read(getClass().getResource(
					"resources/about.png"));
			itemAbout.setIcon(new ImageIcon(about));
		} catch (IOException ex) {
		}

		itemExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		itemApplicant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				steuerung.dialogAddApplicant();
			}
		});
		itemChangeDesign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				steuerung.changeDesign();
			}
		});

		// SWING: TabbedPane
		frame.add(tabBar);
		tabBar.addTab("�bersicht", panel1);
		tabBar.addTab("Bewerber", panel2);
		tabBar.addTab("Arbeitsstellen", panel3);

		// SWING: Table Bewerberpool
		modelPool.setColumnIdentifiers(COLUMN_IDENTIFIERS_APPLICANT);
		tableApplicant.getTableHeader().setReorderingAllowed(false);
		tableApplicant.setAutoCreateRowSorter(true);
		tableApplicant = new JTable(modelPool);
		JScrollPane scrollPanePool = new JScrollPane(tableApplicant);
		panelContent2.add(scrollPanePool);
		scrollPanePool.setPreferredSize(new Dimension(
				panelContent2.getSize().width - 20,
				panelContent2.getSize().height - 20));
		scrollPanePool
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPanePool
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		// SWING:Table Arbeitsstellen
		modelJob.setColumnIdentifiers(COLUMN_IDENTIFIERS_JOB);
		tableJob.getTableHeader().setReorderingAllowed(false);
		tableJob = new JTable(modelJob);
		JScrollPane scrollPaneJob = new JScrollPane(tableJob);
		panelContent3.add(scrollPaneJob);
		scrollPaneJob.setPreferredSize(new Dimension(
				panelContent3.getSize().width - 20,
				panelContent3.getSize().height - 20));
		scrollPaneJob
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneJob
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

	
	}
}
