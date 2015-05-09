package git_aptra.EditVacancy;

import git_aptra.AddVacancy.SaveDataNewVacancy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class DialogEditVacancyMeetingSelection {
	private static Font fontTextField = new Font("Arial", Font.BOLD, 14);
	private static JPanel panelDialogVacancyMeetingSelection = new JPanel();
	private static JLabel labelMeetingSelection = new JLabel();
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public final static Vector COLUMN_IDENTIFIERS_VACANCY_MEETING_SELECTION = new Vector() {
		private static final long serialVersionUID = 1L;

		{
			add("Bewertung-ID");
			add("Bezeichnung");
		}
	};
	public static DefaultTableModel modelDialogVacancyMeetingSelection = new DefaultTableModel(
			1, 4) {
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	
	public static JTable tableDialogVacancyMeetingSelection = new JTable(
			modelDialogVacancyMeetingSelection);
	
	private static JButton save = new JButton("Speichern");

	public static void editVacancyHistory() {
		panelDialogVacancyMeetingSelection.setBackground(Color.LIGHT_GRAY);
		panelDialogVacancyMeetingSelection.setLayout(new BoxLayout(
				panelDialogVacancyMeetingSelection, BoxLayout.Y_AXIS));
		panelDialogVacancyMeetingSelection
				.add(Box.createRigidArea(new Dimension(0, 10)));
		panelDialogVacancyMeetingSelection.add(labelMeetingSelection);
		labelMeetingSelection.setText("Auswahl Bewertungskriterien:");

		panelDialogVacancyMeetingSelection.add(Box.createRigidArea(new Dimension(
				0, 10)));
		
		panelDialogVacancyMeetingSelection.add(Box.createRigidArea(new Dimension(0, 5)));
		modelDialogVacancyMeetingSelection
				.setColumnIdentifiers(COLUMN_IDENTIFIERS_VACANCY_MEETING_SELECTION);
		tableDialogVacancyMeetingSelection.getTableHeader().setReorderingAllowed(false);
		tableDialogVacancyMeetingSelection.setAutoCreateRowSorter(true);
		tableDialogVacancyMeetingSelection = new JTable(modelDialogVacancyMeetingSelection);
		JScrollPane scrollPaneVacancyMeetingSelection = new JScrollPane(
				tableDialogVacancyMeetingSelection);
		panelDialogVacancyMeetingSelection.add(scrollPaneVacancyMeetingSelection);
		scrollPaneVacancyMeetingSelection.setBounds(0, 400, 400, 100);
		scrollPaneVacancyMeetingSelection
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneVacancyMeetingSelection
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		tableDialogVacancyMeetingSelection.setRowHeight(20);
		tableDialogVacancyMeetingSelection.setAutoCreateRowSorter(true);
		
		panelDialogVacancyMeetingSelection.add(save);
		
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				SaveDataNewVacancy.save();
				
			}
		});
		
		DialogEditVacancy.tabVacancy.addTab("Bewertungskriterien",
				panelDialogVacancyMeetingSelection);

	}
}
