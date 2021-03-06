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
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;
//Basis des Dialogs zum Bearbeiten der Bewertungskriterien
public class DialogEditSelection {
	public static JTabbedPane tabEdit = new JTabbedPane(JTabbedPane.TOP,
			JTabbedPane.SCROLL_TAB_LAYOUT);
	public static JDialog dialogEditSelection = new JDialog(Oberflaeche.frame, true);
	
	private static JPanel panelDialogEditSelectionGeneral = new JPanel();

	private static JLabel labelSelection = new JLabel("Auswahl Bewertungskriterien:");
	private static JLabel labelInstruction = new JLabel("Bitte w�hlen Sie Ihre Bewertungskriterien!");

	
	private static JScrollPane scrollPaneSelection = new JScrollPane();
	public static DefaultTableModel modelEditSelection = new DefaultTableModel() {
		private static final long serialVersionUID = 1L;
	public boolean isCellEditable(int row, int column) {
		return false;
		}
	};

	public static JTable tableEditSelection = new JTable();
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public final static Vector COLUMN_IDENTIFIERS_SELECTION = new Vector() {
		private static final long serialVersionUID = 1L;
		{
			add("Bezeichnung");
		}
	};
	private static JButton buttonClose = new JButton("Schlie�en");
	private static JButton buttonAdd = new JButton("Hinzuf�gen");
	private static JButton buttonDelete = new JButton("L�schen");
	
	private static Font fontHeadline = new Font("Calibri", Font.BOLD, 16);
	private static Font fontSubHeadline = new Font("Calibri", Font.BOLD, 14);

	public static void editSelection() {
		panelDialogEditSelectionGeneral.removeAll();
		dialogEditSelection.setSize(420,300);
		dialogEditSelection.setLocationRelativeTo(Oberflaeche.frame);
		dialogEditSelection.setResizable(false);
		dialogEditSelection.setTitle("Kriterien bearbeiten");
		modelEditSelection.setColumnIdentifiers(COLUMN_IDENTIFIERS_SELECTION);
		tableEditSelection.getTableHeader().setReorderingAllowed(false);
		tableEditSelection.setAutoCreateRowSorter(true);
		tableEditSelection = new JTable(modelEditSelection);
		scrollPaneSelection = new JScrollPane(tableEditSelection);
		scrollPaneSelection.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		tableEditSelection.setRowHeight(20);
		dialogEditSelection.add(panelDialogEditSelectionGeneral);
		labelInstruction.setFont(fontHeadline);
		labelSelection.setFont(fontSubHeadline);
		scrollPaneSelection.setFont(fontSubHeadline);
		buttonClose.setFont(fontSubHeadline);
		buttonAdd.setFont(fontSubHeadline);
		buttonDelete.setFont(fontSubHeadline);
		panelDialogEditSelectionGeneral.setLayout(new MigLayout("", "[grow,left][grow,right]","[][][][]"));
		panelDialogEditSelectionGeneral.add(labelInstruction,"cell 0 0 2 1,alignx center");
		panelDialogEditSelectionGeneral.add(buttonClose, "cell 0 1 2,growx");
		panelDialogEditSelectionGeneral.add(buttonAdd, "cell 0 1 2 1,growx");
		panelDialogEditSelectionGeneral.add(buttonDelete, "cell 0 1 2 3,growx");
		panelDialogEditSelectionGeneral.add(labelSelection,"cell 0 2,alignx left");
		panelDialogEditSelectionGeneral.add(scrollPaneSelection,"cell 0 3 2 10,growx");
		
		buttonClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				dialogEditSelection.dispose();
			}
		});
		
		buttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				DialogNewSelection.newSelection();
			}
		});
		
		buttonDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				DeleteSelection.deleteSelection();
			}
		});
		dialogEditSelection.setVisible(true);
	}
}


