package git_aptra.SearchApplicant;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class DialogSearchApplicantGeneral {
	
	public static JPanel panelDialogSearchApplicantMain = new JPanel();
	
	private static JLabel labelApplicantID = new JLabel("Bewerbernummer:");
	private static JLabel labelName = new JLabel("Name:");
	private static JLabel labelFirstName = new JLabel("Vorname:");
	private static JLabel labelStreet = new JLabel("Straﬂe:");
	private static JLabel labelHouseNr = new JLabel("Hausnummer:");
	private static JLabel labelPostalCode = new JLabel("PLZ:");
	private static JLabel labelInstruction = new JLabel("Bitte tragen Sie die gesuchten Daten ein!");
	private static JLabel labelCity = new JLabel("Wohnort:");

	private static JTextField fieldApplicantID = new JTextField();
	private static JTextField fieldName = new JTextField();
	private static JTextField fieldFirstName = new JTextField();
	private static JTextField fieldStreet = new JTextField();
	private static JTextField fieldHouseNr = new JTextField();
	private static JTextField fieldPostalCode = new JTextField();
	private static JTextField fieldCity = new JTextField();
	
	private static Font fontHeadline = new Font("Calibri", Font.BOLD, 16);
	private static Font fontSubHeadline = new Font("Calibri", Font.BOLD, 14);
	private static Font fontText = new Font("Calibri", Font.PLAIN, 14);

	private static int applicantID;
	private static String name;
	private static String firstName;
	private static String street;
	private static int houseNr;
	private static int postalCode;
	private static String city;

	public static void searchApplicantGeneral() {
		labelInstruction.setFont(fontHeadline);
		labelApplicantID.setFont(fontSubHeadline);
		labelName.setFont(fontSubHeadline);
		labelFirstName.setFont(fontSubHeadline);
		labelStreet.setFont(fontSubHeadline);
		labelHouseNr.setFont(fontSubHeadline);
		labelPostalCode.setFont(fontSubHeadline);
		labelCity.setFont(fontSubHeadline);
		fieldName.setFont(fontText);
		fieldFirstName.setFont(fontText);
		fieldStreet.setFont(fontText);
		fieldHouseNr.setFont(fontText);
		fieldPostalCode.setFont(fontText);
		fieldCity.setFont(fontText);
		fieldApplicantID.setFont(fontText);
		fieldName.setText("");
		fieldFirstName.setText("");
		fieldStreet.setText("");
		fieldHouseNr.setText("");
		fieldPostalCode.setText("");
		fieldCity.setText("");
		fieldApplicantID.setText("");
		panelDialogSearchApplicantMain.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][][][][][][][][][][][][][]"));
		panelDialogSearchApplicantMain.add(labelInstruction,"cell 0 0 2 1,alignx center");
		panelDialogSearchApplicantMain.add(labelApplicantID,"cell 0 1,alignx left");
		panelDialogSearchApplicantMain.add(fieldApplicantID,"cell 0 2 2 1,growx");
		panelDialogSearchApplicantMain.add(labelName,"cell 0 3,alignx left");
		panelDialogSearchApplicantMain.add(fieldName,"cell 0 4 2 1,growx");
		panelDialogSearchApplicantMain.add(labelFirstName,"cell 0 5,alignx left");
		panelDialogSearchApplicantMain.add(fieldFirstName,"cell 0 6 2 1,growx");
		panelDialogSearchApplicantMain.add(labelStreet,"cell 0 7,alignx left");
		panelDialogSearchApplicantMain.add(fieldStreet, "cell 0 8 2 1,growx");
		panelDialogSearchApplicantMain.add(labelHouseNr,"cell 0 9,alignx left");
		panelDialogSearchApplicantMain.add(fieldHouseNr,"cell 0 10 2 1,growx");
		panelDialogSearchApplicantMain.add(labelPostalCode,"cell 0 11,alignx left");
		panelDialogSearchApplicantMain.add(fieldPostalCode,"cell 0 12 2 1,growx");
		panelDialogSearchApplicantMain.add(labelCity,"cell 0 13,alignx left");
		panelDialogSearchApplicantMain.add(fieldCity, "cell 0 14 2 1,growx");
		DialogSearchApplicant.tabSearch.addTab("Allgemein",panelDialogSearchApplicantMain);
	}

	public static void getGeneral() {
		try {
			applicantID = Integer.parseInt(fieldApplicantID.getText());

		} catch (Exception e) {
			applicantID = 0;
		}
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
	
	public static int getApplicantID() {
		return applicantID;
	}
	
	

}
