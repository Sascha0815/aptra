package git_aptra.Instruction;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class DialogInstructionOverview {
	private static JPanel panelInstructionOverview = new JPanel();
	
	private static JLabel labelOverviewContent = new JLabel("<html>Die �bersicht bietet einen strukturierten Einblick in die Funktionen des Programms.  <p/> "+                  
																	"Mit einem Klick auf die verschiedenen Buttons gelangt man auf die passende Seite <p/> "+  
																	"des Programms. Au�erdem bietet die �bersicht die M�glichkeit von Schnellzugriffen <p/> "+
																	"auf die meisten Funktionen</html>");
	
	private static Font fontText = new Font("Calibri", Font.PLAIN, 14);
	
	public static void addInstructionOverview(){
		labelOverviewContent.setFont(fontText);
		panelInstructionOverview.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][]"));
		panelInstructionOverview.add(labelOverviewContent, "cell 0 0 2 1,alignx left");
		DialogInstruction.tabInstruction.addTab("�bersicht",panelInstructionOverview);
	}	
}
