package git_aptra.EditApplicant;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import git_aptra.Oberflaeche;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

//Warnungs-Dialog
public class DialogEditWarningApplicant {

	private static JDialog dialogEditWarning = new JDialog(Oberflaeche.frame);
	private static JPanel panelEditWarning = new JPanel();
	private static JLabel labelEditWarningNothingSelected = new JLabel("Sie haben keinen Bewerber ausgewählt");
	private static JLabel labelEditWarningTooManySelected = new JLabel("Sie haben mehr als einen Bewerber ausgewählt");
	private static JButton buttonCloseWarning = new JButton("Schließen");
	private static Font fontSubHeadline = new Font("Calibri", Font.BOLD, 14);
	
	public static void nothingSelected() {
		panelEditWarning.removeAll();
		dialogEditWarning.setVisible(true);
		dialogEditWarning.setSize(325, 100);
		dialogEditWarning.setLocationRelativeTo(Oberflaeche.frame);
		dialogEditWarning.setResizable(false);
		dialogEditWarning.setTitle("Fehler");
		dialogEditWarning.add(panelEditWarning);
		labelEditWarningNothingSelected.setFont(fontSubHeadline);
		buttonCloseWarning.setFont(fontSubHeadline);
		panelEditWarning.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][]push[]"));
		panelEditWarning.add(labelEditWarningNothingSelected, "cell 0 0 2 1,alignx center");
		panelEditWarning.add(buttonCloseWarning, "cell 0 1 2 1, alignx center");
		
		buttonCloseWarning.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialogEditWarning.dispose();
			}
		});	
	}
	
	public static void tooManySelected(){
		panelEditWarning.removeAll();
		dialogEditWarning.setVisible(true);
		dialogEditWarning.setSize(325, 100);
		dialogEditWarning.setLocationRelativeTo(Oberflaeche.frame);
		dialogEditWarning.setResizable(false);
		dialogEditWarning.setTitle("Fehler");
		dialogEditWarning.add(panelEditWarning);
		labelEditWarningTooManySelected.setFont(fontSubHeadline);
		buttonCloseWarning.setFont(fontSubHeadline);
		panelEditWarning.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][]push[]"));
		panelEditWarning.add(labelEditWarningTooManySelected, "cell 0 0 2 1,alignx center");
		panelEditWarning.add(buttonCloseWarning, "cell 0 1 2 1, alignx center");
		
		buttonCloseWarning.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialogEditWarning.dispose();
			}
		});	
	}
}

