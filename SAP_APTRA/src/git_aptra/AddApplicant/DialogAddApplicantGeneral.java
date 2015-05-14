package git_aptra.AddApplicant;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class DialogAddApplicantGeneral {
	
	private static JLabel labelName = new JLabel("Name:");
	private static JLabel labelFirstName = new JLabel("Vorname:");
	private static JLabel labelStreet = new JLabel("Straﬂe:");
	private static JLabel labelHouseNr = new JLabel("Hausnummer:");
	private static JLabel labelPostalCode = new JLabel("PLZ:");
	private static JLabel labelInstruction = new JLabel("Bitte tragen Sie alle erforderlichen Daten ein!");
	private static JLabel labelCity = new JLabel("Wohnort:");
	private static JLabel labelSex = new JLabel("Geschlecht:");
	
	private static String[] boxListSex = {"m‰nnlich", "weiblich"};

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static JComboBox boxSex = new JComboBox(boxListSex);
	
	public static JPanel panelDialogApplicantMain = new JPanel(new GridBagLayout());
	
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
	private static String sex;

	public static void addApplicantGeneral() {
		panelDialogApplicantMain.setLayout(new MigLayout("", "[grow][grow][grow]", "[][][][][][][][][][][][][][]"));
	    panelDialogApplicantMain.add(labelInstruction,"cell 0 0,alignx right");
	    panelDialogApplicantMain.add(labelName,"cell 0 1,alignx left");
	    panelDialogApplicantMain.add(fieldName,"cell 0 2 3 1,growx");
	    panelDialogApplicantMain.add(labelFirstName,"cell 0 3,alignx left");
	    panelDialogApplicantMain.add(fieldFirstName,"cell 0 4 3 1,growx");
	    panelDialogApplicantMain.add(labelStreet,"cell 0 5,alignx left");
	    panelDialogApplicantMain.add(fieldStreet,"cell 0 6 3 1,growx");
	    panelDialogApplicantMain.add(labelHouseNr,"cell 0 7,alignx left");
	    panelDialogApplicantMain.add(fieldHouseNr,"cell 0 8 3 1,growx");
	    panelDialogApplicantMain.add(labelPostalCode,"cell 0 9,alignx left");
	    panelDialogApplicantMain.add(fieldPostalCode,"cell 0 10 3 1,growx");
	    panelDialogApplicantMain.add(labelCity,"cell 0 11,alignx left");
	    panelDialogApplicantMain.add(fieldCity, "cell 0 12 3 1,growx");
	    panelDialogApplicantMain.add(labelSex, "cell 0 13,alignx left");
	    panelDialogApplicantMain.add(boxSex, "cell 0 14 3 1,growx");
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
