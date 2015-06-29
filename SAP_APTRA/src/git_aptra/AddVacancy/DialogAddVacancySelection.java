package git_aptra.AddVacancy;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;

//Reiter des Dialogs für neue Stellen
public class DialogAddVacancySelection {
	
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
	public static DefaultTableModel modelSelection = new DefaultTableModel(0,0) {
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row, int column) {
			return column == 2;
		}
		
	};
	
	public static JTable tableSelection = new JTable(modelSelection);
	
	private static JButton buttonSave = new JButton("Speichern");
	private static JButton buttonBack = new JButton("Zurück");
	
	private static Font fontHeadline = new Font("Calibri", Font.BOLD, 16);
	private static Font fontSubHeadline = new Font("Calibri", Font.BOLD, 14);
	private static Font fontText = new Font("Calibri", Font.PLAIN, 14);
	private static boolean first = true;
	public static void addVacancyHistory(){
		panelDialogVacancySelection.removeAll();
		labelInstruction.setFont(fontHeadline);
		buttonSave.setFont(fontSubHeadline);
		buttonBack.setFont(fontSubHeadline);
		tableSelection.setFont(fontText);
		tableSelection = new JTable(modelSelection);
		modelSelection.setColumnIdentifiers(COLUMN_IDENTIFIERS_SELECTION);
		JScrollPane scrollPaneSelection = new JScrollPane(tableSelection);
		scrollPaneSelection.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		tableSelection.setRowHeight(20);
		tableSelection.setAutoCreateRowSorter(true);
		panelDialogVacancySelection.setLayout(new MigLayout("", "[grow, left][grow, right]", "[][][][][]push[]"));
		panelDialogVacancySelection.add(labelInstruction, "cell 0 0 2,alignx center");
		panelDialogVacancySelection.add(labelSelection, "cell 0 1,alignx left");
		panelDialogVacancySelection.add(scrollPaneSelection, "cell 0 2 4,alignx left");
		panelDialogVacancySelection.add(buttonBack, "cell 0 5 2 1, alignx left");
		panelDialogVacancySelection.add(buttonSave, "cell 1 5 2 1, alignx right");
		DialogAddVacancy.tabVacancy.addTab("Bewertungsauswahl",panelDialogVacancySelection);
		if (first==true) {
			first=false;
			buttonBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					DialogAddVacancy.tabVacancy.setSelectedIndex(1);
				}
			});
		
			buttonSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				SaveDataAddVacancy.save();
			}
			});	
		}
		
	}
}
