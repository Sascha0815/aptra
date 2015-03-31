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
	private static JLabel labelStreet = new JLabel("Straße:");
	private static JLabel labelHouseNr = new JLabel("Hausnummer:");
	private static JLabel labelPostalCode = new JLabel("PLZ:");
	private static JLabel labelInstruction = new JLabel(
			"Änderungen der Stammdaten!");
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
	

	private static String name;
	private static String firstName;
	private static String street;
	private static int houseNr;
	private static int postalCode;
	private static String city;

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
		fieldFirstName.setText(EditApplicant.getDataSetFirstName());
		fieldFirstName.setFont(fontTextField);
		panelDialogEditApplicantMain.add(labelStreet);
		panelDialogEditApplicantMain.add(fieldStreet);
		panelDialogEditApplicantMain.add(Box.createRigidArea(new Dimension(0,
				10)));
		fieldStreet.setText(EditApplicant.getDataSetStreet());
		fieldStreet.setFont(fontTextField);
		panelDialogEditApplicantMain.add(labelHouseNr);
		panelDialogEditApplicantMain.add(fieldHouseNr);
		panelDialogEditApplicantMain.add(Box.createRigidArea(new Dimension(0,
				10)));
		fieldHouseNr.setText(EditApplicant.getDataSetHouseNr());
		fieldHouseNr.setFont(fontTextField);
		panelDialogEditApplicantMain.add(labelPostalCode);
		panelDialogEditApplicantMain.add(fieldPostalCode);
		panelDialogEditApplicantMain.add(Box.createRigidArea(new Dimension(0,
				10)));
		fieldPostalCode.setText(EditApplicant.getDataSetPostalCode());
		fieldPostalCode.setFont(fontTextField);
		panelDialogEditApplicantMain.add(labelCity);
		panelDialogEditApplicantMain.add(fieldCity);
		panelDialogEditApplicantMain.add(Box.createRigidArea(new Dimension(0,
				10)));
		fieldCity.setText(EditApplicant.getDataSetCity());
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

	public static boolean getGeneral() {
		name = fieldName.getText();
		firstName = fieldFirstName.getText();
		street = fieldStreet.getText();
		houseNr = Integer.parseInt(fieldHouseNr.getText());
		postalCode = Integer.parseInt(fieldPostalCode.getText());
		city = fieldCity.getText();

		if (name.equals("")) {
			return false;
		}
		if (firstName.equals("")) {
			return false;
		}
		if (street.equals("")) {
			return false;
		}
		if ((houseNr == 0)) {
			return false;
		}
		if ((postalCode == 0)) {
			return false;
		}
		if (city.equals("")) {
			return false;
		} else {
			return true;
		}
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
