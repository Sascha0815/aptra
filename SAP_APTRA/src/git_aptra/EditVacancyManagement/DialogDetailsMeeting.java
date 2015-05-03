package git_aptra.EditVacancyManagement;

import git_aptra.Oberflaeche;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;


public class DialogDetailsMeeting {
	
	public static JDialog dialogMeeting = new JDialog(Oberflaeche.frame);
	
	public static JPanel panelMeeting = new JPanel();
	public static JLabel labelInstruction = new JLabel("Bitte geben Sie die benötigten Daten ein.");
	public static JLabel labelSortOfMeeting = new JLabel("Art des Termins:");
	public static JLabel labelLocation = new JLabel("Ort:");
	public static JLabel labelDate = new JLabel("Datum:");
	public static JLabel labelTime = new JLabel("Uhrzeit:");
	public static JLabel labelEmployee = new JLabel("Zuständiger Mitarbeiter:");

	private static String[] boxListSortOfMeeting = { 
		"Bitte auswählen", "Bewerbungsgespräch", "Workshop", "Gruppengespräch"};
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static JComboBox boxSortOfMeeting = new JComboBox(boxListSortOfMeeting);

	private static Integer valueHour = new Integer(0);
	private static Integer minHour = new Integer(0);
	private static Integer maxHour = new Integer(24);
	private static Integer step = new Integer(1);
	private static SpinnerNumberModel numberModelHour = new SpinnerNumberModel(valueHour, minHour, maxHour, step);
	private static JSpinner spinnerHour = new JSpinner(numberModelHour);
	
	private static Integer valueminute = new Integer(0);
	private static Integer minMinute = new Integer(0);
	private static Integer maxMinute = new Integer(60);
	private static SpinnerNumberModel numberModelMinute = new SpinnerNumberModel(valueminute, minMinute, maxMinute, step);
	private static JSpinner spinnerMinute = new JSpinner(numberModelMinute);
	
	private static Font fontHeadline = new Font("Arial", Font.BOLD, 18);
	private static Font fontTextField = new Font("Arial", Font.BOLD, 14);
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public final static Vector COLUMN_IDENTIFIERS_VACANCYMANAGEMENT_MEETING = new Vector() {
		private static final long serialVersionUID = 1L;

		{
			add("Mitarbeiter-ID");
			add("Name");
			add("Vorname");
		}
	};
	
	public static DefaultTableModel modelDialogEmployeeMeeting = new DefaultTableModel(
			1, 4) {
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	public static JTable tableDialogEmployeeMeeting = new JTable(modelDialogEmployeeMeeting);
	
	private static JButton save = new JButton("Speichern");
	
	private static JTextField fieldLocation = new JTextField();
	
		public static void detailsMeeting(){		
			dialogMeeting.setVisible(true);
			dialogMeeting.setSize(400, 600);
			dialogMeeting.setLocationRelativeTo(null);
			panelMeeting.setBackground(Color.LIGHT_GRAY);
			dialogMeeting.setResizable(false);
			panelMeeting.setLayout(new BoxLayout(panelMeeting, BoxLayout.Y_AXIS));
			dialogMeeting.setTitle("Meeting Details");
			panelMeeting.add(Box.createRigidArea(new Dimension(0, 10)));
			panelMeeting.add(labelInstruction);	
			labelInstruction.setFont(fontHeadline);
			panelMeeting.add(Box.createRigidArea(new Dimension(0, 10)));
			panelMeeting.add(labelSortOfMeeting);
			panelMeeting.add(boxSortOfMeeting);	
			panelMeeting.add(Box.createRigidArea(new Dimension(0, 10)));
			panelMeeting.add(labelLocation);
			panelMeeting.add(fieldLocation);
			fieldLocation.setFont(fontTextField);	
			panelMeeting.add(Box.createRigidArea(new Dimension(0, 10)));
			panelMeeting.add(labelDate);
			labelDate.setFont(fontTextField);
			//spinnerMonth.setToolTipText("Tag");
			//panelMeeting.add(spinnerMonth);
			panelMeeting.add(Box.createRigidArea(new Dimension(0, 10)));
			//boxMonth.setToolTipText("Monat");
			//panelMeeting.add(boxMonth);
			panelMeeting.add(Box.createRigidArea(new Dimension(0, 10)));
			//boxYear.setToolTipText("Jahr");
			//panelMeeting.add(boxYear);
			panelMeeting.add(Box.createRigidArea(new Dimension(0, 10)));
			panelMeeting.add(labelTime);
			labelTime.setFont(fontTextField);
			spinnerHour.setToolTipText("Stunden");
			panelMeeting.add(spinnerHour);
			panelMeeting.add(Box.createRigidArea(new Dimension(0, 10)));
			spinnerMinute.setToolTipText("Minuten");
			panelMeeting.add(spinnerMinute);
			modelDialogEmployeeMeeting
			.setColumnIdentifiers(COLUMN_IDENTIFIERS_VACANCYMANAGEMENT_MEETING);
			tableDialogEmployeeMeeting.getTableHeader().setReorderingAllowed(false);
			tableDialogEmployeeMeeting.setAutoCreateRowSorter(true);
			tableDialogEmployeeMeeting = new JTable(modelDialogEmployeeMeeting);
			JScrollPane scrollPaneEmployeeMeeting = new JScrollPane(
					tableDialogEmployeeMeeting);
			panelMeeting.add(scrollPaneEmployeeMeeting);
			scrollPaneEmployeeMeeting.setBounds(0,400,400,100);
			scrollPaneEmployeeMeeting
			.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPaneEmployeeMeeting
			.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			tableDialogEmployeeMeeting.setRowHeight(20);
			Oberflaeche.tabBar.addTab("Terminübersicht", panelMeeting);
			tableDialogEmployeeMeeting.setAutoCreateRowSorter(true);
			
			panelMeeting.add(save);

			save.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					// Save-Methode
				}
			});
			dialogMeeting.add(panelMeeting);
			
		}
		
	}


