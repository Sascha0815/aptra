package git_aptra.AddApplicant;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

public class DialogAddApplicantGeneral {
	
	private static JPanel panelDialogApplicantMain = new JPanel();
	
	private static JLabel labelInstruction = new JLabel("Bitte tragen Sie alle erforderlichen Daten ein!");
	private static JLabel labelSex = new JLabel("Anrede:");
	private static JLabel labelFemale = new JLabel("Frau:");
	private static JLabel labelMale = new JLabel("Herr:");
	private static JLabel labelName = new JLabel("Name:");
	private static JLabel labelFirstName = new JLabel("Vorname:");
	private static JLabel labelStreet = new JLabel("Straﬂe:");
	private static JLabel labelHouseNr = new JLabel("Hausnummer:");
	private static JLabel labelPostalCode = new JLabel("PLZ:");
	private static JLabel labelCity = new JLabel("Wohnort:");

	private static JRadioButton radioButtonFemale = new JRadioButton();
	private static JRadioButton radioButtonMale = new JRadioButton();
	
	private static ButtonGroup radioButtonGroup = new ButtonGroup();
	
	private static JTextField fieldName = new JTextField("");
	private static JTextField fieldFirstName = new JTextField("");
	private static JTextField fieldStreet = new JTextField("");
	private static JTextField fieldHouseNr = new JTextField();
	private static JTextField fieldPostalCode = new JTextField();
	private static JTextField fieldCity = new JTextField();
	
	private static JButton buttonContinue = new JButton("Weiter");
	
	private static Font fontHeadline = new Font("Calibri", Font.BOLD, 16);
	private static Font fontSubHeadline = new Font("Calibri", Font.BOLD, 14);
	private static Font fontText = new Font("Calibri", Font.PLAIN, 14);
	
	private static String name;
	private static String firstName;
	private static String street;
	private static int houseNr;
	private static int postalCode;
	private static String city;
	private static String sex;

	public static void addApplicantGeneral() {
		panelDialogApplicantMain.removeAll();
		fieldName.setText("");
		fieldFirstName.setText("");
		fieldStreet.setText("");
		fieldHouseNr.setText("");
		fieldPostalCode.setText("");
		fieldCity.setText("");
		buttonContinue.setFont(fontSubHeadline);
		radioButtonFemale.setSelected(false);
		radioButtonMale.setSelected(false);
		radioButtonGroup.add(radioButtonFemale);
		radioButtonGroup.add(radioButtonMale);
		radioButtonGroup.clearSelection();
		labelInstruction.setFont(fontHeadline);
		labelName.setFont(fontSubHeadline);
		labelFirstName.setFont(fontSubHeadline);
		labelStreet.setFont(fontSubHeadline);
		labelHouseNr.setFont(fontSubHeadline);
		labelPostalCode.setFont(fontSubHeadline);
		labelCity.setFont(fontSubHeadline);
		labelSex.setFont(fontSubHeadline);
		labelFemale.setFont(fontSubHeadline);
		labelMale.setFont(fontSubHeadline);
		fieldName.setFont(fontText);
		fieldFirstName.setFont(fontText);
		fieldStreet.setFont(fontText);
		fieldHouseNr.setFont(fontText);
		fieldPostalCode.setFont(fontText);
		fieldCity.setFont(fontText);
		panelDialogApplicantMain.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][][][][][][][][][][][][]push[]"));
	    panelDialogApplicantMain.add(labelInstruction,"cell 0 0 2 1,alignx center");
	    panelDialogApplicantMain.add(labelSex, "cell 0 1,alignx left");
	    panelDialogApplicantMain.add(labelFemale, "cell 0 2,alignx left");
	    panelDialogApplicantMain.add(radioButtonFemale, "cell 0 2 1,alignx left");
	    panelDialogApplicantMain.add(labelMale, "cell 0 2 2,alignx left");
	    panelDialogApplicantMain.add(radioButtonMale, "cell 0 2 3,alignx left");
	    panelDialogApplicantMain.add(labelName,"cell 0 3,alignx left");
	    panelDialogApplicantMain.add(fieldName,"cell 0 4 2 1,growx");
	    panelDialogApplicantMain.add(labelFirstName,"cell 0 5,alignx left");
	    panelDialogApplicantMain.add(fieldFirstName,"cell 0 6 2 1,growx");
	    panelDialogApplicantMain.add(labelStreet,"cell 0 7,alignx left");
	    panelDialogApplicantMain.add(fieldStreet, "cell 0 8 2 1,growx");
	    panelDialogApplicantMain.add(labelHouseNr,"cell 0 9,alignx left");
	    panelDialogApplicantMain.add(fieldHouseNr,"cell 0 10 2 1,growx");
	    panelDialogApplicantMain.add(labelPostalCode,"cell 0 11,alignx left");
	    panelDialogApplicantMain.add(fieldPostalCode,"cell 0 12 2 1,growx");
	    panelDialogApplicantMain.add(labelCity,"cell 0 13,alignx left");
	    panelDialogApplicantMain.add(fieldCity, "cell 0 14 2 1,growx");
	    panelDialogApplicantMain.add(buttonContinue,"cell 1 15,alignx right");
		DialogAddApplicant.tabAdd.addTab("Allgemein", panelDialogApplicantMain);
		
	    buttonContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				DialogAddApplicant.tabAdd.setSelectedIndex((1));
			}
		});
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
			if(radioButtonFemale.isSelected()){
				sex = "weiblich";
			}
			if(radioButtonMale.isSelected()){
				sex = "m‰nnlich";
			}
			
		} catch (Exception e) {
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
	
	public static String getSex() {
		return sex;
	}
}
