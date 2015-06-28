package git_aptra.Instruction;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class DialogInstructionVacancyManagement {
	
	private static JPanel panelInstructionVacancyManagement = new JPanel();
	
	private static JLabel labelSelectVacancyManagementHeadline = new JLabel("Arbeitstelle auswählen");
	private static JLabel labelEditVacancyManagementHeadline = new JLabel("Bewerber bewerten/rückmelden");
	
	private static JLabel labelSelectVacancyManagementContent = new JLabel("<html>Mit einem Klick auf Arbeitstelle auswählen werden allevorhanden Arbeistellen   <p/> "+                  
																	"angezeigt. Nach dem Auswählen werden alle Bewerber, die sich für diese    <p/> "+  
																	"Arbeitsstelle beworben haben.</html>");
	private static JLabel labelEditVacancyManagementContent = new JLabel("<html>Mit einem Klick auf Bewerber bewerten/rückmelden können Sie einen Bewerber<p/> "+                  
																"bewerten.Außerdem können Sie mittels einer PDF eine Rückmeldung erstellen. Des    <p/> "+
																"Weiterenist es möglich ein Termin zu Erstellen. Dieser wird sofort in die <p/> "+
																"Meetingtabelle  übernommen. </p> </html>");
	
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
