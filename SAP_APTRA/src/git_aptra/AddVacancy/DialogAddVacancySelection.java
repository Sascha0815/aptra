package git_aptra.AddVacancy;

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
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;


@SuppressWarnings("unused")
public class DialogAddVacancySelection {
	private static Font fontTextField = new Font("Arial", Font.BOLD, 14);
	
	private static JPanel panelDialogVacancySelection = new JPanel();
	
	private static JLabel labelSelection = new JLabel("Auswahl Bewertungskriterien:");
	private static JLabel labelInstruction = new JLabel("Bitte tragen Sie alle erfoderlichen Daten ein!");
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public final static Vector COLUMN_IDENTIFIERS_SELECTION = new Vector() {
		private static final long serialVersionUID = 1L;

		{
			add("Bewertung-ID");
			add("Bezeichnung");
			add("Gewichtung");
		}
	};
	public static DefaultTableModel modelSelection = new DefaultTableModel(
			1, 4) {
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row, int column) {
			return column == 2;
		}
		
	};
	
	public static JTable tableSelection = new JTable(
			modelSelection);
	
	
	private static JButton save = new JButton("Speichern");
	private static JButton buttonBack = new JButton("Zurück");
		
	public static void addVacancyHistory(){
		panelDialogVacancySelection.setLayout(new MigLayout("", "[grow, left][grow, right]", "[][][][][][][][][][][][][][]push[]"));
		panelDialogVacancySelection.add(labelInstruction, "cell 0 0 2,alignx center");
		panelDialogVacancySelection.add(labelSelection, "cell 0 1,alignx left");
		tableSelection = new JTable(modelSelection);
		modelSelection.setColumnIdentifiers(COLUMN_IDENTIFIERS_SELECTION);
		JScrollPane scrollPaneSelection = new JScrollPane(tableSelection);
		scrollPaneSelection.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		tableSelection.setRowHeight(20);
		tableSelection.setAutoCreateRowSorter(true);
		panelDialogVacancySelection.add(scrollPaneSelection, "cell 0 2 4 12,alignx left");
		panelDialogVacancySelection.add(save, "cell 1 15 2 1, alignx right");
		panelDialogVacancySelection.add(buttonBack, "cell 0 15 2 1, alignx left");
		
		buttonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				DialogAddVacancy.tabVacancy.setSelectedIndex(1);
			}
		});
	
		save.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
			SaveDataNewVacancy.save();
		}
	});
	
	DialogAddVacancy.tabVacancy.addTab("Bewertungsauswahl",
			panelDialogVacancySelection);
	
	}
}
