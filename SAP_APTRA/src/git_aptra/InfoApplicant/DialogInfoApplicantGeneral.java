package git_aptra.InfoApplicant;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DialogInfoApplicantGeneral {

	public static JPanel panelInfoApplicantGeneral = new JPanel();

	private static JLabel labelName = new JLabel("Name:");
	private static JLabel labelFirstName = new JLabel("Vorname:");
	private static JLabel labelStreet = new JLabel("Straﬂe:");
	private static JLabel labelHouseNr = new JLabel("Hausnummer:");
	private static JLabel labelPostalCode = new JLabel("PLZ:");
	private static JLabel labelCity = new JLabel("Wohnort:");
	private static JTextField fieldName = new JTextField();
	private static JTextField fieldFirstName = new JTextField();
	private static JTextField fieldStreet = new JTextField();
	private static JTextField fieldHouseNr = new JTextField();
	private static JTextField fieldPostalCode = new JTextField();
	private static JTextField fieldCity = new JTextField();
	
	private static Font fontTextField = new Font("Arial", Font.BOLD, 14);

	public static void infoApplicantGeneral() {
		panelInfoApplicantGeneral.setBackground(Color.LIGHT_GRAY);
		panelInfoApplicantGeneral.setLayout(new BoxLayout(
				panelInfoApplicantGeneral, BoxLayout.Y_AXIS));
		panelInfoApplicantGeneral.add(Box.createRigidArea(new Dimension(0, 10)));
		panelInfoApplicantGeneral.add(Box.createRigidArea(new Dimension(0, 10)));
		panelInfoApplicantGeneral.add(labelName);
		panelInfoApplicantGeneral.add(fieldName);
		panelInfoApplicantGeneral.add(Box.createRigidArea(new Dimension(0, 10)));
		fieldName.setFont(fontTextField);
		panelInfoApplicantGeneral.add(labelFirstName);
		panelInfoApplicantGeneral.add(fieldFirstName);
		panelInfoApplicantGeneral.add(Box.createRigidArea(new Dimension(0, 10)));
		fieldFirstName.setFont(fontTextField);
		panelInfoApplicantGeneral.add(labelStreet);
		panelInfoApplicantGeneral.add(fieldStreet);
		panelInfoApplicantGeneral.add(Box.createRigidArea(new Dimension(0, 10)));
		fieldStreet.setFont(fontTextField);
		panelInfoApplicantGeneral.add(labelHouseNr);
		panelInfoApplicantGeneral.add(Box.createRigidArea(new Dimension(0, 10)));
		fieldHouseNr.setFont(fontTextField);
		panelInfoApplicantGeneral.add(labelPostalCode);
		panelInfoApplicantGeneral.add(fieldPostalCode);
		panelInfoApplicantGeneral.add(Box.createRigidArea(new Dimension(0, 10)));
		fieldPostalCode.setFont(fontTextField);
		panelInfoApplicantGeneral.add(labelCity);
		panelInfoApplicantGeneral.add(fieldCity);
		panelInfoApplicantGeneral.add(Box.createRigidArea(new Dimension(0, 10)));
		fieldCity.setFont(fontTextField);
		
		DialogInfoApplicant.tabInfo.addTab("Allgemein",
				panelInfoApplicantGeneral);
	}
}