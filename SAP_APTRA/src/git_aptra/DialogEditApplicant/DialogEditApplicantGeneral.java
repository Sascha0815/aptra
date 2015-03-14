package git_aptra.DialogEditApplicant;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DialogEditApplicantGeneral {
	private static JLabel labelName = new JLabel("Name:");
	private static JLabel labelFirstName = new JLabel("Vorname:");
	private static JLabel labelStreet = new JLabel("Straﬂe:");
	private static JLabel labelHouseNr = new JLabel("Hausnummer:");
	private static JLabel labelPostalCode = new JLabel("PLZ:");
	private static JLabel labelInstruction = new JLabel(
			"Bitte tragen Sie alle erforderlichen Daten ein!");
	private static JLabel labelCity = new JLabel("Wohnort:");
	public static JPanel panelDialogEditApplicantMain = new JPanel();
	private static Font fontHeadline = new Font("Arial", Font.BOLD, 18);
	private static Font fontTextField = new Font("Arial", Font.BOLD, 14);
	private static JTextField fieldName = new JTextField();
	private static JTextField fieldFirstName = new JTextField();
	private static JTextField fieldStreet = new JTextField();
	private static JTextField fieldHouseNr = new JTextField();
	private static JTextField fieldPostalCode = new JTextField();
	private static JTextField fieldCity = new JTextField();

	public static void editApplicantGeneral() {
		panelDialogEditApplicantMain.setBackground(Color.LIGHT_GRAY);
		panelDialogEditApplicantMain.setLayout(new BoxLayout(
				panelDialogEditApplicantMain, BoxLayout.Y_AXIS));
		panelDialogEditApplicantMain.add(Box.createRigidArea(new Dimension(0,
				10)));
		panelDialogEditApplicantMain.add(labelInstruction);
		labelInstruction.setFont(fontHeadline);
		panelDialogEditApplicantMain.add(Box.createRigidArea(new Dimension(0,
				10)));
		panelDialogEditApplicantMain.add(labelName);
		panelDialogEditApplicantMain.add(fieldName);
		fieldName.setText(EditApplicant.getDataSetName());
		panelDialogEditApplicantMain.add(Box.createRigidArea(new Dimension(0,
				10)));
		fieldName.setFont(fontTextField);
		panelDialogEditApplicantMain.add(labelFirstName);
		panelDialogEditApplicantMain.add(fieldFirstName);
		panelDialogEditApplicantMain.add(Box.createRigidArea(new Dimension(0,
				10)));
		fieldFirstName.setFont(fontTextField);
		panelDialogEditApplicantMain.add(labelStreet);
		panelDialogEditApplicantMain.add(fieldStreet);
		panelDialogEditApplicantMain.add(Box.createRigidArea(new Dimension(0,
				10)));
		fieldStreet.setFont(fontTextField);
		panelDialogEditApplicantMain.add(labelHouseNr);
		panelDialogEditApplicantMain.add(fieldHouseNr);
		panelDialogEditApplicantMain.add(Box.createRigidArea(new Dimension(0,
				10)));
		fieldHouseNr.setFont(fontTextField);
		panelDialogEditApplicantMain.add(labelPostalCode);
		panelDialogEditApplicantMain.add(fieldPostalCode);
		panelDialogEditApplicantMain.add(Box.createRigidArea(new Dimension(0,
				10)));
		fieldPostalCode.setFont(fontTextField);
		panelDialogEditApplicantMain.add(labelCity);
		panelDialogEditApplicantMain.add(fieldCity);
		panelDialogEditApplicantMain.add(Box.createRigidArea(new Dimension(0,
				10)));
		fieldCity.setFont(fontTextField);
		DialogEditApplicant.tabEdit.addTab("Allgemein",
				panelDialogEditApplicantMain);
	}

	public static void reset() {
		panelDialogEditApplicantMain.removeAll();
		fieldName.setText("");
		fieldFirstName.setText("");
		fieldStreet.setText("");
		fieldHouseNr.setText("");
		fieldPostalCode.setText("");
		fieldCity.setText("");
	}
}
