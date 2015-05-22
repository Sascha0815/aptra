package git_aptra.EditSelection;

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

	public class DialogEditSelectionGeneral {
		
		private static JPanel panelDialogEditSelectionGeneral = new JPanel();
		
		private static JLabel labelSelection = new JLabel("Auswahl Bewertungskriterien:");
		private static JLabel labelInstruction = new JLabel("Bitte wählen Sie Ihre Bewertungskriterien!");
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public final static Vector COLUMN_IDENTIFIERS_SELECTION = new Vector() {
			private static final long serialVersionUID = 1L;

			{
				add("Bezeichnung");
			}
		};
		public static DefaultTableModel modelEditSelection = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		public static JTable tableEditSelection = new JTable(modelEditSelection);
		
		private static JButton buttonSave = new JButton("Speichern");
		private static JButton buttonAdd = new JButton("Hinzufügen");
		private static JButton buttonEdit = new JButton("Bearbeiten");
		private static JButton buttonDelete = new JButton("Löschen");
		
		private static Font fontHeadline = new Font("Calibri", Font.BOLD, 16);
		private static Font fontSubHeadline = new Font("Calibri", Font.BOLD, 14);
		
		public static void EditSelectionGeneral(){
			labelInstruction.setFont(fontHeadline);
			labelSelection.setFont(fontSubHeadline);
			buttonSave.setFont(fontSubHeadline);
			buttonAdd.setFont(fontSubHeadline);
			buttonEdit.setFont(fontSubHeadline);
			buttonDelete.setFont(fontSubHeadline);
			JScrollPane scrollPaneSelection = new JScrollPane(tableEditSelection);
			modelEditSelection.setColumnIdentifiers(COLUMN_IDENTIFIERS_SELECTION);
			scrollPaneSelection.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			tableEditSelection.setRowHeight(20);
			tableEditSelection.setAutoCreateRowSorter(true);
			tableEditSelection = new JTable(modelEditSelection);
			panelDialogEditSelectionGeneral.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][][][][][][]"));
			panelDialogEditSelectionGeneral.add(labelInstruction, "cell 0 0 2 1,alignx center");
			panelDialogEditSelectionGeneral.add(labelSelection, "cell 0 1,alignx left");
			panelDialogEditSelectionGeneral.add(tableEditSelection, "cell 0 2 2 20,growx");
			panelDialogEditSelectionGeneral.add(buttonSave, "wrap, growx" );
			panelDialogEditSelectionGeneral.add(buttonAdd, "wrap, growx");
			panelDialogEditSelectionGeneral.add(buttonEdit, "wrap, growx");
			panelDialogEditSelectionGeneral.add(buttonDelete, "wrap, growx");
			buttonSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
					
				}
			});
				DialogEditSelection.tabEdit.addTab("Allgemein", panelDialogEditSelectionGeneral);
			}
			public static boolean getGeneral(){
				return true;
			}			
}
	