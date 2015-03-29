package git_aptra.DialogAddApplicant;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DialogAddApplicantGeneral {
	private static JLabel labelApplicantID = new JLabel("Identifikationsnummer:");
	private static JLabel labelName = new JLabel("Name:");
	private static JLabel labelFirstName = new JLabel("Vorname:");
	private static JLabel labelStreet = new JLabel("Straﬂe:");
	private static JLabel labelHouseNr = new JLabel("Hausnummer:");
	private static JLabel labelPostalCode = new JLabel("PLZ:");
	private static JLabel labelInstruction = new JLabel(
			"Bitte tragen Sie alle erforderlichen Daten ein!");
	private static JLabel labelCity = new JLabel("Wohnort:");
	public static JPanel panelDialogApplicantMain = new JPanel();
	private static Font fontHeadline = new Font("Arial", Font.BOLD, 18);
	private static Font fontTextField = new Font("Arial", Font.BOLD, 14);
	private static JTextField fieldApplicantID = new JTextField();
	private static JTextField fieldName = new JTextField();
	private static JTextField fieldFirstName = new JTextField();
	private static JTextField fieldStreet = new JTextField();
	private static JTextField fieldHouseNr = new JTextField();
	private static JTextField fieldPostalCode = new JTextField();
	private static JTextField fieldCity = new JTextField();

	private static String applicantID;
	private static String name;
	private static String firstName;
	private static String street;
	private static int houseNr;
	private static int postalCode;
	private static String city;


	public static void addApplicantGeneral() {
		panelDialogApplicantMain.setBackground(Color.LIGHT_GRAY);
		panelDialogApplicantMain.setLayout(new BoxLayout(
				panelDialogApplicantMain, BoxLayout.Y_AXIS));
		panelDialogApplicantMain.add(Box.createRigidArea(new Dimension(0, 10)));
		panelDialogApplicantMain.add(labelInstruction);
		labelInstruction.setFont(fontHeadline);
		panelDialogApplicantMain.add(Box.createRigidArea(new Dimension(0, 10)));
		panelDialogApplicantMain.add(labelApplicantID);
		panelDialogApplicantMain.add(fieldApplicantID);
		fieldApplicantID.setEditable(true);
		panelDialogApplicantMain.add(Box.createRigidArea(new Dimension(0, 10)));
		panelDialogApplicantMain.add(labelName);
		panelDialogApplicantMain.add(fieldName);
		panelDialogApplicantMain.add(Box.createRigidArea(new Dimension(0, 10)));
		fieldName.setFont(fontTextField);
		panelDialogApplicantMain.add(labelFirstName);
		panelDialogApplicantMain.add(fieldFirstName);
		panelDialogApplicantMain.add(Box.createRigidArea(new Dimension(0, 10)));
		fieldFirstName.setFont(fontTextField);
		panelDialogApplicantMain.add(labelStreet);
		panelDialogApplicantMain.add(fieldStreet);
		panelDialogApplicantMain.add(Box.createRigidArea(new Dimension(0, 10)));
		fieldStreet.setFont(fontTextField);
		panelDialogApplicantMain.add(labelHouseNr);
		panelDialogApplicantMain.add(fieldHouseNr);
		panelDialogApplicantMain.add(Box.createRigidArea(new Dimension(0, 10)));
		fieldHouseNr.setFont(fontTextField);
		panelDialogApplicantMain.add(labelPostalCode);
		panelDialogApplicantMain.add(fieldPostalCode);
		panelDialogApplicantMain.add(Box.createRigidArea(new Dimension(0, 10)));
		fieldPostalCode.setFont(fontTextField);
		panelDialogApplicantMain.add(labelCity);
		panelDialogApplicantMain.add(fieldCity);
		panelDialogApplicantMain.add(Box.createRigidArea(new Dimension(0, 10)));
		fieldCity.setFont(fontTextField);
		DialogAddApplicant.tabAdd.addTab("Allgemein", panelDialogApplicantMain);
	}

	public static boolean getGeneral() {
		try {
			applicantID = fieldApplicantID.getText();
			name = fieldName.getText();
			firstName = fieldFirstName.getText();
			street = fieldStreet.getText();
			houseNr = Integer.parseInt(fieldHouseNr.getText());
			postalCode = Integer.parseInt(fieldPostalCode.getText());
			city = fieldCity.getText();
		} catch (Exception e) {
			System.out.println("Nicht alle Daten eingegeben");
		}

		if (applicantID.equals("")){
			return false;
		}
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

	public static void reset() {
		panelDialogApplicantMain.removeAll();
		fieldApplicantID.setText("");
		fieldName.setText("");
		fieldFirstName.setText("");
		fieldStreet.setText("");
		fieldHouseNr.setText("");
		fieldPostalCode.setText("");
		fieldCity.setText("");
	}


	public static String getApplicantID(){
		return applicantID;
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
