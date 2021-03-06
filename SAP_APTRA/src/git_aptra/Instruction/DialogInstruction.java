package git_aptra.Instruction;

import git_aptra.Oberflaeche;

import javax.swing.JDialog;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
//Basis des Dialogs mit Hilfetexten
public class DialogInstruction {
	public static JTabbedPane tabInstruction = new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);
	public static JDialog dialogNewInstrcution = new JDialog(Oberflaeche.frame, true);
	
	public static void newInstruction(){
		dialogNewInstrcution.setSize(500, 520);
		dialogNewInstrcution.setLocationRelativeTo(Oberflaeche.frame);
		dialogNewInstrcution.setResizable(false);
		dialogNewInstrcution.setTitle("Hilfe");
		dialogNewInstrcution.add(tabInstruction);
		DialogInstructionOverview.addInstructionOverview();
		DialogInstructionApplicant.addInstructionApplicant();
		DialogInstructionVacancy.addInstructionVacancy();
		DialogInstructionVacancyManagement.addInstructionVacancyManagement();
		DialogInstructionMeeting.addInstructionMeeting();
		DialogInstructionTab.addInstructionTab();
		SwingUtilities.updateComponentTreeUI(dialogNewInstrcution);
		dialogNewInstrcution.setLocationRelativeTo(Oberflaeche.frame);
		dialogNewInstrcution.setVisible(true);
	}
}
