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
		public static DefaultTableModel modelEditSelection = new DefaultTableModel(
				8, 1) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		public static JTable tableEditSelection = new JTable(
				modelEditSelection);
		
		
		private static JButton save = new JButton("Speichern");
		private static JButton add = new JButton("Hinzufügen");
		private static JButton edit = new JButton("Bearbeiten");
		private static JButton delete = new JButton("Löschen");
		
		
		public static void editSelectionGeneral(){
			panelDialogEditSelectionGeneral.setLayout(new MigLayout("", "[grow]", "[][][][]"));
			panelDialogEditSelectionGeneral.add(labelInstruction, "cell 0 0,alignx left");
			panelDialogEditSelectionGeneral.add(labelSelection, "cell 0 1,alignx left");
			JScrollPane scrollPaneSelection = new JScrollPane(tableEditSelection);
			modelEditSelection.setColumnIdentifiers(COLUMN_IDENTIFIERS_SELECTION);
			scrollPaneSelection.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			tableEditSelection.setRowHeight(20);
			tableEditSelection.setAutoCreateRowSorter(true);
			tableEditSelection = new JTable(modelEditSelection);
			panelDialogEditSelectionGeneral.add(tableEditSelection, "cell 0 2 4 12,grow");
			panelDialogEditSelectionGeneral.add(save, "wrap, growx" );
			panelDialogEditSelectionGeneral.add(add, "wrap, growx");
			panelDialogEditSelectionGeneral.add(edit, "wrap, growx");
			panelDialogEditSelectionGeneral.add(delete, "wrap, growx");

		
			save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				SavaDataEditSelection.save();
				
			}
			
			
		});
				DialogEditSelection.tabEdit.addTab("Allgemein", panelDialogEditSelectionGeneral);
			}
			public static boolean getGeneral(){
				return true;
				
			}
			
}
	