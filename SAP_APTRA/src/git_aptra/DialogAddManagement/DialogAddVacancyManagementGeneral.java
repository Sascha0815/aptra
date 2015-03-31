package git_aptra.DialogAddManagement;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DialogAddVacancyManagementGeneral {

	public static JPanel panelDialogManagementMain = new JPanel();
	private static JLabel managementMain = new JLabel(
			"Stellenidentifikationsnummer");
	private static JButton search = new JButton("Suchen");

	public static void addVacancyManagementGeneral() {
		panelDialogManagementMain.setBackground(Color.LIGHT_GRAY);
		panelDialogManagementMain.setLayout(new FlowLayout(FlowLayout.LEFT, 20,
				20));
		panelDialogManagementMain.setPreferredSize(new Dimension(150, 0));
		panelDialogManagementMain.add(managementMain);
		panelDialogManagementMain.add(search);

		/*
		 * search.addActionListener(new ActionListener() {
		 * 
		 * public void actionPerformed(ActionEvent evt) { try {
		 * SearchControlApplicant.search();
		 * CloseDialogSearchApplicant.closeSearchApplicant(); } catch
		 * (SQLException e) { e.printStackTrace(); } } }
		 */
	}

	public static void reset() {
		panelDialogManagementMain.removeAll();

	}

}