package git_aptra.EditSelection;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

import git_aptra.Oberflaeche;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import net.miginfocom.swing.MigLayout;

public class DialogNewSelection {
	
	public static JDialog dialogNewSelection = new JDialog(Oberflaeche.frame, true);
	
	private static JPanel panelDialogNewSelection = new JPanel();

	private static JLabel labelInstruction = new JLabel("Bitte tragen Sie die erfoderlichen Daten ein!");
	private static JLabel labelNotation = new JLabel("Bezeichnung");
	private static JLabel labelWarning = new JLabel("Dieses Bewertungskriterium ist bereits vorhanden!");
	
	private static JTextField fieldNotation = new JTextField();
	
	private static JButton buttonSave = new JButton("Speichern");
	private static JButton buttonAbort = new JButton ("Abbrechen");
	
	private static Font fontHeadline = new Font("Calibri", Font.BOLD, 16);
	private static Font fontSubHeadline = new Font("Calibri", Font.BOLD, 14);
	private static Font fontText = new Font("Calibri", Font.PLAIN, 14);
	
	private static String notation;
	private static String weighting;
	private static boolean duplicate;
	
	public static void newSelection() {
		fieldNotation.setText("");
		labelInstruction.setFont(fontHeadline);
		labelNotation.setFont(fontSubHeadline);
		buttonSave.setFont(fontSubHeadline);
		buttonAbort.setFont(fontSubHeadline);
		fieldNotation.setFont(fontText);
		labelWarning.setFont(fontSubHeadline);
	    labelWarning.setVisible(false);
		labelWarning.setForeground(Color.red);
		dialogNewSelection.setSize(325,170);
		dialogNewSelection.setLocationRelativeTo(Oberflaeche.frame);
		dialogNewSelection.setTitle("Neues Bewertungskriterium");
		SwingUtilities.updateComponentTreeUI(dialogNewSelection);
		dialogNewSelection.setLocationRelativeTo(Oberflaeche.frame);
		dialogNewSelection.add(panelDialogNewSelection);
		panelDialogNewSelection.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][][][][]"));
		panelDialogNewSelection.add(labelInstruction, "cell 0 0 2 1,alignx center");
		panelDialogNewSelection.add(labelNotation, "cell 0 1,alignx left");
		panelDialogNewSelection.add(fieldNotation, "cell 0 2 2 1,growx");
		panelDialogNewSelection.add(labelWarning, "cell 0 3 2,alignx left");
		panelDialogNewSelection.add(buttonSave, "cell 0 4,alignx left");
		panelDialogNewSelection.add(buttonAbort, "cell 1 4 ,alignx right ");
		
		buttonSave.addActionListener(new ActionListener() {
			@SuppressWarnings("rawtypes")
			public void actionPerformed(ActionEvent evt) {
				notation = fieldNotation.getText();
				for(int i = 0; i<DialogEditSelection.tableEditSelection.getRowCount();i++){
					if(notation.equals((String) DialogEditSelection.tableEditSelection.getValueAt(i, 0))){
						duplicate = true;
					}
				}
				if(duplicate==false){
					reset();
					try {
						InsertEditSelectionDataIntoDatebase.insertSelectionData(notation,weighting);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					labelWarning.setVisible(true);
				}
				Vector resultsSeleciton = InsertEditSelectionDataIntoTable.insertEditSelectionDataIntoTable();
				DialogEditSelection.modelEditSelection.setDataVector(resultsSeleciton, DialogEditSelection.COLUMN_IDENTIFIERS_SELECTION);
				DialogEditSelection.modelEditSelection.fireTableDataChanged();
			}
		});
		
		buttonAbort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				dialogNewSelection.dispose();
			}
		});

		dialogNewSelection.setVisible(true);
	}
	
	public static void reset(){
		dialogNewSelection.dispose();
		fieldNotation.setText("");
	}
	
}
