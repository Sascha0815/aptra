package git_aptra.AddApplicant;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DialogAddApplicantGeneral {
	
	private static JLabel labelName = new JLabel("Name:");
	private static JLabel labelFirstName = new JLabel("Vorname:");
	private static JLabel labelStreet = new JLabel("Straﬂe:");
	private static JLabel labelHouseNr = new JLabel("Hausnummer:");
	private static JLabel labelPostalCode = new JLabel("PLZ:");
	private static JLabel labelInstruction = new JLabel("Bitte tragen Sie alle erforderlichen Daten ein!");
	private static JLabel labelCity = new JLabel("Wohnort:");
	private static JLabel labelSex = new JLabel("Geschlecht:");
	
	private static String[] boxListSex = { "m‰nnlich", "weiblich"};

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static JComboBox boxSex = new JComboBox(boxListSex);
	
	public static JPanel panelDialogApplicantMain = new JPanel(new GridBagLayout());
	
	private static Font fontHeadline = new Font("Arial", Font.BOLD, 18);
	//private static Font fontTextField = new Font("Arial", Font.BOLD, 14);
	
	private static JTextField fieldName = new JTextField();
	private static JTextField fieldFirstName = new JTextField();
	private static JTextField fieldStreet = new JTextField();
	private static JTextField fieldHouseNr = new JTextField();
	private static JTextField fieldPostalCode = new JTextField();
	private static JTextField fieldCity = new JTextField();
	
	private static GridBagConstraints gbc = new GridBagConstraints();

	private static String name;
	private static String firstName;
	private static String street;
	private static int houseNr;
	private static int postalCode;
	private static String city;
	private static String sex;

	public static void addApplicantGeneral() {
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.weighty = 1;
	    labelInstruction.setFont(fontHeadline);
	    panelDialogApplicantMain.add(labelInstruction,gbc);
	    gbc.gridx = 0;
	    gbc.gridy = 1;
	    panelDialogApplicantMain.add(labelName,gbc);
	    gbc.gridx = 0;
	    gbc.gridy = 2;
	    panelDialogApplicantMain.add(fieldName,gbc);
	    gbc.gridx = 0;
	    gbc.gridy = 3;
	    panelDialogApplicantMain.add(labelFirstName,gbc);
	    gbc.gridx = 0;
	    gbc.gridy = 4;
	    panelDialogApplicantMain.add(fieldFirstName,gbc);
	    gbc.gridx = 0;
	    gbc.gridy = 5;
	    panelDialogApplicantMain.add(labelStreet,gbc);
	    gbc.gridx = 0;
	    gbc.gridy = 6;
	    panelDialogApplicantMain.add(fieldStreet,gbc);
	    gbc.gridx = 0;
	    gbc.gridy = 7;
	    panelDialogApplicantMain.add(labelHouseNr,gbc);
	    gbc.gridx = 0;
	    gbc.gridy = 8;
	    panelDialogApplicantMain.add(fieldHouseNr,gbc);
	    gbc.gridx = 0;
	    gbc.gridy = 9;
	    panelDialogApplicantMain.add(labelPostalCode,gbc);
	    gbc.gridx = 0;
	    gbc.gridy = 10;
	    panelDialogApplicantMain.add(fieldPostalCode,gbc);
	    gbc.gridx = 0;
	    gbc.gridy = 11;
	    panelDialogApplicantMain.add(labelCity,gbc);
	    gbc.gridx = 0;
	    gbc.gridy = 12;
	    panelDialogApplicantMain.add(fieldCity,gbc);
	    gbc.gridx = 0;
	    gbc.gridy = 13;
	    panelDialogApplicantMain.add(labelSex,gbc);
	    gbc.gridx = 0;
	    gbc.gridy = 14;
	    panelDialogApplicantMain.add(boxSex,gbc);
		DialogAddApplicant.tabAdd.addTab("Allgemein", panelDialogApplicantMain);
	}

	public static void getGeneral() {
		try {
			name = fieldName.getText();
		} catch (Exception e) {
		}
		try {
			firstName = fieldFirstName.getText();
		} catch (Exception e) {
		}
		try {
			street = fieldStreet.getText();
		} catch (Exception e) {
		}
		try {
			houseNr = Integer.parseInt(fieldHouseNr.getText());
		} catch (Exception e) {
		}
		try {
			postalCode = Integer.parseInt(fieldPostalCode.getText());
		} catch (Exception e) {
		}
		try {
			city = fieldCity.getText();
		} catch (Exception e) {
		}
		try {
			sex = (String) boxSex.getSelectedItem();
		} catch (Exception e) {
		}
		

	}

	public static void reset() {
		panelDialogApplicantMain.removeAll();
		fieldName.setText("");
		fieldFirstName.setText("");
		fieldStreet.setText("");
		fieldHouseNr.setText("");
		fieldPostalCode.setText("");
		fieldCity.setText("");
		boxSex.setSelectedIndex(0);
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
	
	public static String getSex() {
		return sex;
	}
}
