package git_aptra.EditSelection;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import git_aptra.Oberflaeche;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import net.miginfocom.swing.MigLayout;

public class DialogNewSelection {
	public static JDialog dialogNewSelection = new JDialog(Oberflaeche.frame);
	
	private static JPanel panelDialogNewSelection = new JPanel();

	private static JLabel labelNotation = new JLabel("Bezeichnung");
	private static JLabel labelInstruction = new JLabel("Bitte tragen Sie alle erfoderlichen Daten ein!");
	
	private static JTextField fieldNotation = new JTextField();
	
	private static JButton buttonSave = new JButton("Speichern");
	private static JButton buttonAbort = new JButton ("Abbrechen");
	
	private static Font fontHeadline = new Font("Calibri", Font.BOLD, 16);
	private static Font fontSubHeadline = new Font("Calibri", Font.BOLD, 14);
	private static Font fontText = new Font("Calibri", Font.PLAIN, 14);
	
	private static String notation;
	private static boolean duplicate;
	
	public static void newSelection() {
		labelInstruction.setFont(fontHeadline);
		labelNotation.setFont(fontSubHeadline);
		buttonSave.setFont(fontSubHeadline);
		buttonAbort.setFont(fontSubHeadline);
		fieldNotation.setFont(fontText);
		dialogNewSelection.setVisible(true);
		dialogNewSelection.setSize(325,140);
		dialogNewSelection.setLocationRelativeTo(null);
		dialogNewSelection.setResizable(false);
		dialogNewSelection.setTitle("Neues Bewertungskriterium");
		SwingUtilities.updateComponentTreeUI(dialogNewSelection);
		dialogNewSelection.setLocationRelativeTo(Oberflaeche.frame);
		dialogNewSelection.add(panelDialogNewSelection);
		panelDialogNewSelection.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][][][]"));
		panelDialogNewSelection.add(labelInstruction, "cell 0 0 2 1,alignx center");
		panelDialogNewSelection.add(labelNotation, "cell 0 1,alignx left");
		panelDialogNewSelection.add(fieldNotation, "cell 0 2 2 1,growx");
		panelDialogNewSelection.add(buttonSave, "cell 0 3,alignx left");
		panelDialogNewSelection.add(buttonAbort, "cell 1 3,alignx right ");
		
		buttonSave.addActionListener(new ActionListener() {
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
						InsertEditSelectionDataIntoDatebase.insertSelectionData();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					
				}
			
			}
		});
		
		buttonAbort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				dialogNewSelection.dispose();
			}
		});
	}
	
	public static void reset(){
		dialogNewSelection.dispose();
		fieldNotation.setText("");
	}
	
	public static String getNotation(){
		return notation;
	}
}
