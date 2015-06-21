package git_aptra.Instruction;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class DialogInstructionVacancyManagement {
	
	private static JPanel panelInstructionVacancyManagement = new JPanel();
	
	private static JLabel labelSelectVacancyManagementHeadline = new JLabel("Arbeitstelle ausw�hlen");
	private static JLabel labelEditVacancyManagementHeadline = new JLabel("Bewerber bewerten/r�ckmelden");
	
	private static JLabel labelSelectVacancyManagementContent = new JLabel("<html>Mit einem Klick auf Arbeitstelle ausw�hlen werden alle   <p/> "+                  
																	"vorhanden Arbeistellen angezeigt. Nach dem Ausw�hlen werden  <p/> "+  
																	"alle Bewerber, die sich f�r diese Arbeitsstelle beworben haben.</html>");
	private static JLabel labelEditVacancyManagementContent = new JLabel("<html>Mit einem Klick auf Bewerber bewerten/r�ckmelden k�nnen Sie <p/> "+                  
																"einen Bewerber bewerten. Au�erdem k�nnen Sie mittels einer   <p/> "+
																"PDF eine R�ckmeldung erstellen. Des Weiteren ist es m�glich    <p/> "+
																"ein Termin zu Erstellen. Dieser wird sofort in die Meetingtabelle  <p/> "+
																" �bernommen</html>");
	
	private static Font fontHeadline = new Font("Calibri", Font.BOLD, 16);
	private static Font fontText = new Font("Calibri", Font.PLAIN, 14);
	
	public static void addInstructionVacancyManagement(){
		labelSelectVacancyManagementHeadline.setFont(fontHeadline);
		labelEditVacancyManagementHeadline.setFont(fontHeadline);
		labelSelectVacancyManagementContent.setFont(fontText);
		labelEditVacancyManagementContent.setFont(fontText);
		panelInstructionVacancyManagement.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][]"));
		panelInstructionVacancyManagement.add(labelSelectVacancyManagementHeadline, "cell 0 0 2 1,alignx left");
		panelInstructionVacancyManagement.add(labelSelectVacancyManagementContent, "cell 0 1,alignx left");
		panelInstructionVacancyManagement.add(labelEditVacancyManagementHeadline, "cell 0 2 2 1,alignx left");
		panelInstructionVacancyManagement.add(labelEditVacancyManagementContent, "cell 0 3,alignx left");
		DialogInstruction.tabInstruction.addTab("Stellenmanagement",panelInstructionVacancyManagement);
	}
}
