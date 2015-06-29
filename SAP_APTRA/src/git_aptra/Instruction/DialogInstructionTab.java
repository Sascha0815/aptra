package git_aptra.Instruction;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
//Reiter des Dialogs für Reiterhilfe
public class DialogInstructionTab {
	
	private static JPanel panelInstructionTab = new JPanel();
	
	
	private static JLabel labelSelectionHeadline = new JLabel("Bewertungskritereien anlegen und löschen");
	private static JLabel labelEmployeeHeadline = new JLabel("Neuer Mitarbeiter");
	private static JLabel labelDivisionHeadline = new JLabel("Neue Abteilung");
	
	private static JLabel labelTabContent = new JLabel("<html>Das Programm bietet links oben drei Reiter: Neu, Suchen und Hilfe <p/> "+ 
																"Unter dem Reiter Neu gibt es die Funktionen: <p/> "+ 
																"Neuer Bewerber, Neue Arbeitstelle und Neues Meeting. <p/> "+
																"Unter dem Reiter Suchen gibt es die Funktionen:<p/> "+
																"Bewerber suchen, Arbeiststelle suchen und Meeting suchen</html>");
	
	private static JLabel labelSelectionContent = new JLabel("<html>Mit einem Klick auf den Reiter Bewerbungskriterien bearbeiten besteht die  <p/> "+ 
															"Möglichkeit neue Kriterien zur Bewertung der Bewerber anzulegen oder zu löschen <p/> </html>");
	
	private static JLabel labelEmployeeContent = new JLabel("<html>Mit einem Klick auf den Reiter Neuer Mitarbeiter besteht die  <p/> "+ 
			"Möglichkeit einen neuen Mitarbeiter anzulegen <p/> </html>");
	
	private static JLabel labelDivisionContent = new JLabel("<html>Mit einem Klick auf den Reiter Neue Abteilung besteht die  <p/> "+ 
			"Möglichkeit eine neue Abteilung anzulegen <p/> </html>");
	
	private static Font fontText = new Font("Calibri", Font.PLAIN, 14);
	private static Font fontHeadline = new Font("Calibri", Font.BOLD, 16);
	public static void addInstructionTab(){
		labelTabContent.setFont(fontText);
		labelSelectionContent.setFont(fontText);
		labelSelectionContent.setFont(fontText);
		labelDivisionContent.setFont(fontText);
		labelSelectionHeadline.setFont(fontHeadline);
		labelEmployeeHeadline.setFont(fontHeadline);
		labelDivisionHeadline.setFont(fontHeadline);
		panelInstructionTab.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][][][][][]"));
		panelInstructionTab.add(labelTabContent, "cell 0 0 2 1,alignx left");
		panelInstructionTab.add(labelSelectionHeadline, "cell 0 1,alignx left");
		panelInstructionTab.add(labelSelectionContent, "cell 0 2 2 1,alignx left");
		panelInstructionTab.add(labelEmployeeHeadline, "cell 0 3,alignx left");
		panelInstructionTab.add(labelEmployeeContent, "cell 0 4 2 1,alignx left");
		panelInstructionTab.add(labelDivisionHeadline, "cell 0 5,alignx left");
		panelInstructionTab.add(labelDivisionContent, "cell 0 6 2 1,alignx left");
		DialogInstruction.tabInstruction.addTab("Tab",panelInstructionTab);
	}
}
