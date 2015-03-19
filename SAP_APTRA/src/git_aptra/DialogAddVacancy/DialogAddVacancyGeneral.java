package git_aptra.DialogAddVacancy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DialogAddVacancyGeneral {
	private static JLabel labelArea = new JLabel();
	private static JPanel panelDialogVacancyMain = new JPanel();
	private static JLabel labelInstruction2 = new JLabel();
	private static Font fontHeadline = new Font("Arial", Font.BOLD, 18);
	private static Font fontTextField = new Font("Arial", Font.BOLD, 14);
	private static JLabel labelPosition = new JLabel();
	private static JTextField fieldArea = new JTextField();
	private static JTextField fieldPosition = new JTextField();
	private static String area;
	private static String position;

	public static void addVacancyGeneral() {
		panelDialogVacancyMain.setBackground(Color.LIGHT_GRAY);
		panelDialogVacancyMain.setLayout(new BoxLayout(panelDialogVacancyMain,
				BoxLayout.Y_AXIS));
		panelDialogVacancyMain.add(Box.createRigidArea(new Dimension(0, 10)));
		panelDialogVacancyMain.add(labelInstruction2);
		labelInstruction2
				.setText("Bitte tragen Sie alle erfoderlichen Daten ein!");
		labelInstruction2.setFont(fontHeadline);
		panelDialogVacancyMain.add(Box.createRigidArea(new Dimension(0, 10)));
		panelDialogVacancyMain.add(labelPosition);
		labelPosition.setText("Position:");
		panelDialogVacancyMain.add(fieldPosition);
		panelDialogVacancyMain.add(Box.createRigidArea(new Dimension(0, 10)));
		fieldPosition.setFont(fontTextField);
		panelDialogVacancyMain.add(labelArea);
		labelArea.setText("Arbeitsbereich:");
		panelDialogVacancyMain.add(fieldArea);
		panelDialogVacancyMain.add(Box.createRigidArea(new Dimension(0, 10)));
		fieldArea.setFont(fontTextField);
		DialogAddVacancy.tabVacancy.addTab("Allgemein", panelDialogVacancyMain);

	}

	public static boolean getGeneral() {
		area = fieldArea.getText();
		position = fieldPosition.getText();
		if (area.equals("")) {
			return false;
		}
		if (position.equals("")) {
			return false;
		} else {
			return true;
		}
	}
	
	public static String getArea() {
		return area;
	}

	public static String getPosition() {
		return position;
	}
}
