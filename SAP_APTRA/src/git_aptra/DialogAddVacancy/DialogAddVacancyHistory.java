package git_aptra.DialogAddVacancy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class DialogAddVacancyHistory {
	private Font fontHeadline = new Font("Arial", Font.BOLD, 18);
	private static Font fontTextField = new Font("Arial", Font.BOLD, 14);
	private static JPanel panelDialogVacancyHistory = new JPanel();
	private static JLabel labelHistory = new JLabel();
	private static JTextField fieldHistory = new JTextField();
	
	static void addVacancyHistory() {
	panelDialogVacancyHistory.setBackground(Color.LIGHT_GRAY);
	panelDialogVacancyHistory.setLayout(new BoxLayout(
			panelDialogVacancyHistory, BoxLayout.Y_AXIS));
	panelDialogVacancyHistory.add(Box.createRigidArea(new Dimension(
			0, 10)));
	panelDialogVacancyHistory.add(labelHistory);
	labelHistory.setText("Dokumentation:");
	panelDialogVacancyHistory.add(fieldHistory);
	panelDialogVacancyHistory.add(Box.createRigidArea(new Dimension(
			0, 10)));
	fieldHistory.setFont(fontTextField);
	fieldHistory.setEditable(false);
	DialogAddVacancy.tabVacancy.addTab("Dokumentation",
			panelDialogVacancyHistory);
	
	}
}
