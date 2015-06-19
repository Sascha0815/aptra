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
	
	private static JLabel labelRefreshApplicantContent = new JLabel("<html>Mit einem Klick auf Bewerber aktualisieren wird die   <p/> "+                  
																	"Bewerbertabelle aktualisiert und es werden die neusten Bewerber angezeigt.</html>");
	private static JLabel labelAddApplicantContent = new JLabel("<html>Mit einem Klick auf Bewerber hinzufügen können Sie einen neuen<p/> "+                  
																"Bewerber hinzufügen. Nach dem Speichern wird dieser sofort in <p/> "+
																"die Datenbank übernommen und in der Bewerbertabelle angezeigt.</html>");
	private static JLabel labelEditApplicantContent = new JLabel("<html>Mit einem Klick auf Bewerber bearbeiten können Sie die Daten <p/> "+                  
																"eines bestehenden Bewerbers bearbeiten. Um einen Bewerber  <p/> "+
																"bearbeiten zu können müssen Sie erst einen Bewerber in der <p/> "+
																"Bewerbertabelle auswählen.</html>");
	private static JLabel labelDeleteApplicantContent = new JLabel("<html>Mit einem Klick auf Bewerber löschen können Sie einen <p/> "+                  
																"bestehenden Bewerber löschen. Um einen Bewerber löschen  <p/> "+
																"zu können müssen Sie erst einen Bewerber in der Bewerbertabelle <p/> "+
																" auswählen.</html>");
	private static JLabel labelSearchApplicantContent = new JLabel("<html>Mit einem Klick auf Bewerber suchen können Sie einen <p/> "+                  
																	"bestehenden Bewerber suchen. Um einen Bewerber zu suchen  <p/> "+
																	"geben Sie einfach die zu suchenden Daten in den Suchdialog ein.</html>");
	private static JLabel labelInfoApplicantContent = new JLabel("<html>Mit einem Klick auf Bewerberinformation können Sie alle Daten <p/> "+                  
																"von einem bestehenden Bewerber einsehen. Um die   <p/> "+
																"Bewerberinformationen einzusehen müssen Sie erst einen   <p/> "+
																"Bewerber in der Bewerbertabelle auswählen.</html>");
	
	
	private static Font fontHeadline = new Font("Calibri", Font.BOLD, 16);
	private static Font fontText = new Font("Calibri", Font.PLAIN, 14);
	
	public static void addInstructionApplicant(){
		labelRefreshApplicantHeadline.setFont(fontHeadline);
		labelAddApplicantHeadline.setFont(fontHeadline);
		labelEditApplicantHeadline.setFont(fontHeadline);
		labelDeleteApplicantHeadline.setFont(fontHeadline);
		labelSearchApplicantHeadline.setFont(fontHeadline);
		labelInfoApplicantHeadline.setFont(fontHeadline);
		labelRefreshApplicantContent.setFont(fontText);
		labelAddApplicantContent.setFont(fontText);
		labelEditApplicantContent.setFont(fontText);
		labelDeleteApplicantContent.setFont(fontText);
		labelSearchApplicantContent.setFont(fontText);
		labelInfoApplicantContent.setFont(fontText);
		panelInstructionApplicant.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][]"));
		panelInstructionApplicant.add(labelRefreshApplicantHeadline, "cell 0 0 2 1,alignx left");
		panelInstructionApplicant.add(labelRefreshApplicantContent, "cell 0 1,alignx left");
		panelInstructionApplicant.add(labelAddApplicantHeadline, "cell 0 2 2 1,alignx left");
		panelInstructionApplicant.add(labelAddApplicantContent, "cell 0 3,alignx left");
		panelInstructionApplicant.add(labelEditApplicantHeadline, "cell 0 4 2 1,alignx left");
		panelInstructionApplicant.add(labelEditApplicantContent, "cell 0 5,alignx left");
		panelInstructionApplicant.add(labelDeleteApplicantHeadline, "cell 0 6 2 1,alignx left");
		panelInstructionApplicant.add(labelDeleteApplicantContent, "cell 0 7,alignx left");
		panelInstructionApplicant.add(labelSearchApplicantHeadline, "cell 0 8 2 1,alignx left");
		panelInstructionApplicant.add(labelSearchApplicantContent, "cell 0 9,alignx left");
		panelInstructionApplicant.add(labelInfoApplicantHeadline, "cell 0 10 2 1,alignx left");
		panelInstructionApplicant.add(labelInfoApplicantContent, "cell 0 11,alignx left");
		DialogInstruction.tabInstruction.addTab("Bewerber",panelInstructionApplicant);
	}
}
