package git_aptra.AddDivision;

import git_aptra.Oberflaeche;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import net.miginfocom.swing.MigLayout;

public class DialogAddDivision {
	public static JDialog dialogAddDivision = new JDialog(Oberflaeche.frame, true);
	
	private static JPanel panelDialogAddDivision = new JPanel();
	
	private static JLabel labelInstruction = new JLabel("Bitte tragen Sie alle erforderlichen Daten ein!");
	private static JLabel labelNotation = new JLabel("Bezeichnung der Abteilung:");

	private static JTextField fieldNotation = new JTextField();
	
	private static Font fontHeadline = new Font("Calibri", Font.BOLD, 16);
	private static Font fontSubHeadline = new Font("Calibri", Font.BOLD, 14);
	private static Font fontText = new Font("Calibri", Font.PLAIN, 14);
	
	private static JButton buttonSave = new JButton("Speichern");
	private static JButton buttonAbort = new JButton("Abbrechen");
	private static boolean first = true;
	private static String notation;
	
	public static void addDivision() {
		panelDialogAddDivision.removeAll();
		fieldNotation.setText("");
		dialogAddDivision.setLocationRelativeTo(Oberflaeche.frame);
		dialogAddDivision.setSize(350, 140);
		dialogAddDivision.setResizable(false);
		dialogAddDivision.setTitle("Neue Abteilung");
		SwingUtilities.updateComponentTreeUI(dialogAddDivision);
		dialogAddDivision.setLocationRelativeTo(Oberflaeche.frame);
		dialogAddDivision.add(panelDialogAddDivision);
		labelInstruction.setFont(fontHeadline);
		labelNotation.setFont(fontSubHeadline);
		fieldNotation.setFont(fontText);
		dialogAddDivision.add(panelDialogAddDivision);
		panelDialogAddDivision.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][][]push[]"));
		panelDialogAddDivision.add(labelInstruction, "cell 0 0 2 1,alignx center");
		panelDialogAddDivision.add(labelNotation, "cell 0 1,alignx left");
		panelDialogAddDivision.add(fieldNotation, "cell 0 2 2 1,growx");
		panelDialogAddDivision.add(buttonSave, "cell 0 3,alignx left");
		panelDialogAddDivision.add(buttonAbort, "cell 1 3,alignx right");
		if (first==true) {
			first=false;
			buttonSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					notation = fieldNotation.getText();
					dialogAddDivision.dispose();
					try {
						InsertDivisionDataIntoDatabase.insertDivisionData(notation);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			});
			buttonAbort.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					dialogAddDivision.dispose();
				}
			});
		}
		
		dialogAddDivision.setVisible(true);
		
	}
}
