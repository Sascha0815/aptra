package git_aptra.Instruction;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class DialogInstructionApplicant {
	
	private static JPanel panelInstructionApplicant = new JPanel();
	
	private static JLabel labelRefreshApplicantHeadline = new JLabel("Beweber aktualisieren");
	private static JLabel labelAddApplicantHeadline = new JLabel("Bewerber anlegen");
	private static JLabel labelEditApplicantHeadline = new JLabel("Bewerber bearbeiten");
	private static JLabel labelDeleteApplicantHeadline = new JLabel("Bewerber löschen");
	private static JLabel labelSearchApplicantHeadline = new JLabel("Bewerber suchen");
	private static JLabel labelInfoApplicantHeadline = new JLabel("Bewerberinformationen");
	
	private static JLabel labelRefreshApplicantContent = new JLabel();
	private static JLabel labelAddApplicantContent = new JLabel();
	private static JLabel labelEditApplicantContent = new JLabel();
	private static JLabel labelDeleteApplicantContent = new JLabel();
	private static JLabel labelSearchApplicantContent = new JLabel();
	private static JLabel labelInfoApplicantContent = new JLabel();
	
	
	private static Font fontHeadline = new Font("Calibri", Font.BOLD, 16);
	private static Font fontSubHeadline = new Font("Calibri", Font.BOLD, 14);
	private static Font fontText = new Font("Calibri", Font.PLAIN, 14);
	
	public static void addInstructionApplicant(){
		labelRefreshApplicantHeadline.setFont(fontHeadline);
		labelAddApplicantHeadline.setFont(fontHeadline);
		labelEditApplicantHeadline.setFont(fontHeadline);
		labelDeleteApplicantHeadline.setFont(fontHeadline);
		labelSearchApplicantHeadline.setFont(fontHeadline);
		labelInfoApplicantHeadline.setFont(fontHeadline);
		panelInstructionApplicant.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][]"));
		DialogInstruction.tabInstruction.addTab("Bewerber",panelInstructionApplicant);
	}
}
