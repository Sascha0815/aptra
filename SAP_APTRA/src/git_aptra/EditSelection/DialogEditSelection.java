package git_aptra.EditSelection;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import git_aptra.Oberflaeche;
import git_aptra.Delete.DeleteSelection;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;

public class DialogEditSelection {
	public static JTabbedPane tabEdit = new JTabbedPane(JTabbedPane.TOP,
			JTabbedPane.SCROLL_TAB_LAYOUT);
	public static JDialog dialogEditSelection = new JDialog(Oberflaeche.frame);
	
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

	public static JTable tableEditSelection = new JTable(modelEditSelection);

	private static JButton buttonSave = new JButton("Speichern");
	private static JButton buttonAdd = new JButton("Hinzufügen");
	private static JButton buttonEdit = new JButton("Bearbeiten");
	private static JButton buttonDelete = new JButton("Löschen");
	
	private static Font fontHeadline = new Font("Calibri", Font.BOLD, 16);
	private static Font fontSubHeadline = new Font("Calibri", Font.BOLD, 14);

	public static void editSelection() {
		dialogEditSelection.setVisible(true);
		dialogEditSelection.setSize(420,300);
		dialogEditSelection.setLocationRelativeTo(null);
		dialogEditSelection.setResizable(false);
		dialogEditSelection.setTitle("Kriterien bearbeiten");
		SwingUtilities.updateComponentTreeUI(dialogEditSelection);
		dialogEditSelection.setLocationRelativeTo(Oberflaeche.frame);
		JScrollPane scrollPaneSelection = new JScrollPane(tableEditSelection);
		modelEditSelection.setColumnIdentifiers(COLUMN_IDENTIFIERS_SELECTION);
		scrollPaneSelection.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		tableEditSelection.setRowHeight(20);
		tableEditSelection.setAutoCreateRowSorter(true);
		tableEditSelection = new JTable(modelEditSelection);
		dialogEditSelection.add(panelDialogEditSelectionGeneral);
		labelInstruction.setFont(fontHeadline);
		labelSelection.setFont(fontSubHeadline);
		scrollPaneSelection.setFont(fontSubHeadline);
		buttonSave.setFont(fontSubHeadline);
		buttonAdd.setFont(fontSubHeadline);
		buttonEdit.setFont(fontSubHeadline);
		buttonDelete.setFont(fontSubHeadline);
		panelDialogEditSelectionGeneral.setLayout(new MigLayout("", "[grow,left][grow,right]","[][][][]"));
		panelDialogEditSelectionGeneral.add(labelInstruction,"cell 0 0 2 1,alignx center");
		panelDialogEditSelectionGeneral.add(buttonSave, "cell 0 1 2,growx");
		panelDialogEditSelectionGeneral.add(buttonAdd, "cell 0 1 2 1,growx");
		panelDialogEditSelectionGeneral.add(buttonEdit, "cell 0 1 2 2,growx");
		panelDialogEditSelectionGeneral.add(buttonDelete, "cell 0 1 2 3,growx");
		panelDialogEditSelectionGeneral.add(labelSelection,"cell 0 2,alignx left");
		panelDialogEditSelectionGeneral.add(scrollPaneSelection,"cell 0 3 2 10,growx");

		buttonSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				dialogEditSelection.dispose();
			}
		});
		
		buttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				DialogNewSelection.newSelection();
			}
		});
		
		buttonEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
			}
		});
		
		buttonDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				DeleteSelection.deleteSelection();
			}
		});
	}
}


