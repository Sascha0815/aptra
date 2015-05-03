package git_aptra;

import javax.swing.SwingUtilities;

import git_aptra.AddApplicant.DialogAddApplicant;

import javax.swing.UIManager;

public class ChangeDesign {
	private static boolean LaF = false;
	
	//METHODE: Design wechseln
	public static void changeDesign() {
		if (LaF == true) {
			try {
				UIManager.setLookAndFeel(UIManager
						.getCrossPlatformLookAndFeelClassName());

			} catch (Exception e) {

			}
		} else {
			try {
				UIManager.setLookAndFeel(UIManager
						.getSystemLookAndFeelClassName());

			} catch (Exception e) {
			}
		}
		SwingUtilities.updateComponentTreeUI(Oberflaeche.frame);
		SwingUtilities
				.updateComponentTreeUI(DialogAddApplicant.dialogNewApplicant);
		LaF = !LaF;
	}
}
