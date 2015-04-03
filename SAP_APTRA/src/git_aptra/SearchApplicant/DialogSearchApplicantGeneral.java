package git_aptra.SearchApplicant;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DialogSearchApplicantGeneral {
	private static JLabel labelName = new JLabel("Name:");
	private static JLabel labelFirstName = new JLabel("Vorname:");
	private static JLabel labelStreet = new JLabel("Straﬂe:");
	private static JLabel labelHouseNr = new JLabel("Hausnummer:");
	private static JLabel labelPostalCode = new JLabel("PLZ:");
	private static JLabel labelInstruction = new JLabel(
			"Bitte tragen Sie die gesuchten Daten ein!");
	private static JLabel labelCity = new JLabel("Wohnort:");
	public static JPanel panelDialogSearchApplicantMain = new JPanel();
	private static Font fontHeadline = new Font("Arial", Font.BOLD, 18);
	private static Font fontTextField = new Font("Arial", Font.BOLD, 14);
	private static JTextField fieldName = new JTextField();
	private static JTextField fieldFirstName = new JTextField();
	private static JTextField fieldStreet = new JTextField();
	private static JTextField fieldHouseNr = new JTextField();
	private static JTextField fieldPostalCode = new JTextField();
	private static JTextField fieldCity = new JTextField();

	private static String name;
	private static String firstName;
	private static String street;
	private static int houseNr;
	private static int postalCode;
	private static String city;

	public static void searchApplicantGeneral() {
		panelDialogSearchApplicantMain.setBackground(Color.LIGHT_GRAY);
		panelDialogSearchApplicantMain.setLayout(new BoxLayout(
				panelDialogSearchApplicantMain, BoxLayout.Y_AXIS));
		panelDialogSearchApplicantMain.add(Box.createRigidArea(new Dimension(0,
				10)));
		panelDialogSearchApplicantMain.add(labelInstruction);
		labelInstruction.setFont(fontHeadline);
		panelDialogSearchApplicantMain.add(Box.createRigidArea(new Dimension(0,
				10)));
		panelDialogSearchApplicantMain.add(Box.createRigidArea(new Dimension(0,
				10)));
		panelDialogSearchApplicantMain.add(labelName);
		panelDialogSearchApplicantMain.add(fieldName);
		panelDialogSearchApplicantMain.add(Box.createRigidArea(new Dimension(0,
				10)));
		fieldName.setFont(fontTextField);
		panelDialogSearchApplicantMain.add(labelFirstName);
		panelDialogSearchApplicantMain.add(fieldFirstName);
		panelDialogSearchApplicantMain.add(Box.createRigidArea(new Dimension(0,
				10)));
		fieldFirstName.setFont(fontTextField);
		panelDialogSearchApplicantMain.add(labelStreet);
		panelDialogSearchApplicantMain.add(fieldStreet);
		panelDialogSearchApplicantMain.add(Box.createRigidArea(new Dimension(0,
				10)));
		fieldStreet.setFont(fontTextField);
		panelDialogSearchApplicantMain.add(labelHouseNr);
		panelDialogSearchApplicantMain.add(fieldHouseNr);
		panelDialogSearchApplicantMain.add(Box.createRigidArea(new Dimension(0,
				10)));
		fieldHouseNr.setFont(fontTextField);
		panelDialogSearchApplicantMain.add(labelPostalCode);
		panelDialogSearchApplicantMain.add(fieldPostalCode);
		panelDialogSearchApplicantMain.add(Box.createRigidArea(new Dimension(0,
				10)));
		fieldPostalCode.setFont(fontTextField);
		panelDialogSearchApplicantMain.add(labelCity);
		panelDialogSearchApplicantMain.add(fieldCity);
		panelDialogSearchApplicantMain.add(Box.createRigidArea(new Dimension(0,
				10)));
		fieldCity.setFont(fontTextField);
		DialogSearchApplicant.tabSearch.addTab("Allgemein",
				panelDialogSearchApplicantMain);
	}

	public static void getGeneral() {
		try {
			houseNr = Integer.parseInt(fieldHouseNr.getText());

		} catch (Exception e) {
			houseNr = 0;
		}
		try {
			postalCode = Integer.parseInt(fieldPostalCode.getText());

		} catch (Exception e) {
			postalCode = 0;
		}
		name = fieldName.getText();
		firstName = fieldFirstName.getText();
		street = fieldStreet.getText();
		city = fieldCity.getText();
	}

	public static void reset() {
		panelDialogSearchApplicantMain.removeAll();
		fieldName.setText("");
		fieldFirstName.setText("");
		fieldStreet.setText("");
		fieldHouseNr.setText("");
		fieldPostalCode.setText("");
		fieldCity.setText("");
	}

	public static String getName() {
		return name;
	}

	public static String getFirstName() {
		return firstName;
	}

	public static String getStreet() {
		return street;
	}

	public static int getHouseNr() {
		return houseNr;
	}

	public static int getPostalCode() {
		return postalCode;
	}

	public static String getCity() {
		return city;
	}

}
