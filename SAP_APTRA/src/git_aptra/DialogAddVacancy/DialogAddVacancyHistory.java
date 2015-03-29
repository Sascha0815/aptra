package git_aptra.DialogAddVacancy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;


@SuppressWarnings("unused")
public class DialogAddVacancyHistory {
	private static Font fontTextField = new Font("Arial", Font.BOLD, 14);
	private static JPanel panelDialogVacancyHistory = new JPanel();
	private static JLabel labelHistory = new JLabel();
	private static JTextField fieldHistory = new JTextField();
	
	//private static JSpinner spinner = new JSpinner(new SpinnerNumberModel(0,1,31,1));
	
	public static void addVacancyHistory(){
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
	fieldHistory.setEditable(true);
	//spinner = new JSpinner(new SpinnerNumberModel(0,1,31,1));
	//panelDialogVacancyHistory.add(spinner);
	DialogAddVacancy.tabVacancy.addTab("Dokumentation",
			panelDialogVacancyHistory);
	
	}
}
