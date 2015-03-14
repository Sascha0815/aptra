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

public class MenuBarPanelWorkplace {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public final static Vector COLUMN_IDENTIFIERS_JOB = new Vector() {
		private static final long serialVersionUID = 1L;

		{
			add("Name");
			add("Vorname");
			add("Straße");
			add("Hausnummer");
			add("PLZ");
			add("Wohnort");
		}
	};
	private static JPanel panelWorkplace = new JPanel();
	private static JPanel panelContentWorkplace = new JPanel();
	private static JPanel panelInfoWorkplace = new JPanel();
	private static JPanel panelButtonWorkplace = new JPanel();

	private static JButton buttonJob = new JButton();
	private static JButton buttonRefreshJob = new JButton();
	private static DefaultTableModel modelJob = new DefaultTableModel(1, 4) {
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	private static JTable tableJob = new JTable(modelJob);

	// legt das Panel Arbeitsstellen an
	public static void addPanelWorkplace() {
		panelWorkplace.setLayout(new BorderLayout(5, 5));
		panelWorkplace.add(panelButtonWorkplace, BorderLayout.EAST);
		panelWorkplace.add(panelContentWorkplace, BorderLayout.CENTER);
		panelWorkplace.add(panelInfoWorkplace, BorderLayout.SOUTH);
		panelButtonWorkplace
				.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		panelButtonWorkplace.setBackground(Color.LIGHT_GRAY);
		panelButtonWorkplace.setPreferredSize(new Dimension(150, 0));
		panelContentWorkplace.setBackground(Color.LIGHT_GRAY);
		panelInfoWorkplace.setBackground(Color.LIGHT_GRAY);
		panelInfoWorkplace.setPreferredSize(new Dimension(0, 20));
		buttonRefreshJob.setToolTipText("Tabelle aktualisieren");
		panelButtonWorkplace.add(buttonRefreshJob);
		buttonRefreshJob.setPreferredSize(new Dimension(135, 135));
		buttonRefreshJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		try {
			Image add = ImageIO.read(MenuBarPanelWorkplace.class
					.getResource("resources/refreshApplicant.png"));
			buttonRefreshJob.setIcon(new ImageIcon(add));
		} catch (IOException ex) {
		}
		buttonJob.setToolTipText("Neue Arbeitstelle hinzufügen");
		panelButtonWorkplace.add(buttonJob);
		buttonJob.setPreferredSize(new Dimension(135, 135));
		buttonJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				DialogAddVacancy.newVacancy();
			}
		});

		try {
			Image job = ImageIO.read(MenuBarPanelWorkplace.class
					.getResource("resources/job.png"));
			buttonJob.setIcon(new ImageIcon(job));
		} catch (IOException ex) {
		}

		// SWING:Table Arbeitsstellen
		modelJob.setColumnIdentifiers(COLUMN_IDENTIFIERS_JOB);
		tableJob.getTableHeader().setReorderingAllowed(false);
		tableJob = new JTable(modelJob);
		JScrollPane scrollPaneJob = new JScrollPane(tableJob);
		panelWorkplace.add(scrollPaneJob);
		scrollPaneJob.setPreferredSize(new Dimension(panelContentWorkplace
				.getSize().width - 20,
				panelContentWorkplace.getSize().height - 15));
		scrollPaneJob
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneJob
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		Oberflaeche.tabBar.addTab("Arbeitststellen", panelWorkplace);

	}
}
