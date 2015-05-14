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
		}
	};
	public static DefaultTableModel modelSelection = new DefaultTableModel(
			1, 4) {
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	
	public static JTable tableSelection = new JTable(
			modelSelection);
	
	
	private static JButton save = new JButton("Speichern");
	
	
	//private static JSpinner spinner = new JSpinner(new SpinnerNumberModel(0,1,31,1));
	
	public static void addVacancyHistory(){
		panelDialogVacancySelection.setLayout(new MigLayout("", "[grow][grow][grow]", "[][][][][][][][][][][][]"));
		panelDialogVacancySelection.add(labelInstruction, "cell 1 0,alignx left");
		panelDialogVacancySelection.add(labelSelection, "cell 0 1,alignx left");
		JScrollPane scrollPaneSelection = new JScrollPane(tableSelection);
		modelSelection.setColumnIdentifiers(COLUMN_IDENTIFIERS_SELECTION);
		scrollPaneSelection.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		tableSelection.setRowHeight(20);
		tableSelection.setAutoCreateRowSorter(true);
		tableSelection = new JTable(modelSelection);
		panelDialogVacancySelection.add(tableSelection, "cell 0 2 4 12,grow");

	
		save.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
			SaveDataNewVacancy.save();
			
		}
	});
	
	DialogAddVacancy.tabVacancy.addTab("Bewertungsauswahl",
			panelDialogVacancySelection);
	
	}
}
