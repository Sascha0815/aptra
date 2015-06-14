package git_aptra.Overview.EditApplicant;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class DialogSelectApplicant {
	private static JPanel panelDialogShowApplicantInfoMain = new JPanel();
	
	private static JLabel labelInstruction = new JLabel("Bewerber zum Bearbeiten auswählen:");
	
	private static JButton buttonContinue = new JButton("Weiter");
	private static JButton buttonLoadApplicantData = new JButton("Bewerber auswählen");
	
	private static Font fontHeadline = new Font("Calibri", Font.BOLD, 16);
	private static Font fontSubHeadline = new Font("Calibri", Font.BOLD, 14);
	private static Font fontText = new Font("Calibri", Font.PLAIN, 14);
		
	public static void selectApplicant(){
		labelInstruction.setFont(fontHeadline);
		panelDialogShowApplicantInfoMain.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][]"));
		panelDialogShowApplicantInfoMain.add(labelInstruction,"cell 0 0 2 1,alignx center");
		panelDialogShowApplicantInfoMain.add(buttonLoadApplicantData, "cell 0 1 2 1, alignx center");
		
		buttonLoadApplicantData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				DialogLoadApplicantEditSelection.loadApplicantData();
			}
		});
	
		
		DialogEditApplicantData.tabAdd.addTab("Allgemein", panelDialogShowApplicantInfoMain);
	}
}
