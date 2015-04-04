package git_aptra.InfoApplicant;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DialogInfoApplicantContact {

	public static JPanel panelInfoApplicantContact = new JPanel();
	
	private static JLabel labelTelefonHome = new JLabel("Telefon privat:");
	private static JLabel labelTelefonMobil = new JLabel("Telefon mobil");
	private static JLabel labelEmail = new JLabel("E-Mail:");

	private static Font fontTextField = new Font("Arial", Font.BOLD, 14);
	
	private static JTextField fieldTelefonHome = new JTextField();
	private static JTextField fieldTelefonMobil = new JTextField();
	private static JTextField fieldEmail = new JTextField();
	

	public static void infoApplicantContact() {
		panelInfoApplicantContact.setBackground(Color.LIGHT_GRAY);
		panelInfoApplicantContact.setLayout(new BoxLayout(
				panelInfoApplicantContact, BoxLayout.Y_AXIS));
		panelInfoApplicantContact.add(Box
				.createRigidArea(new Dimension(0, 10)));
		panelInfoApplicantContact.add(labelTelefonHome);
		panelInfoApplicantContact.add(fieldTelefonHome);
		panelInfoApplicantContact.add(Box
				.createRigidArea(new Dimension(0, 10)));
		fieldTelefonHome.setFont(fontTextField);
		panelInfoApplicantContact.add(labelTelefonMobil);
		panelInfoApplicantContact.add(fieldTelefonMobil);
		panelInfoApplicantContact.add(Box
				.createRigidArea(new Dimension(0, 10)));
		fieldTelefonMobil.setFont(fontTextField);
		panelInfoApplicantContact.add(labelEmail);
		panelInfoApplicantContact.add(fieldEmail);
		panelInfoApplicantContact.add(Box
				.createRigidArea(new Dimension(0, 10)));
		fieldEmail.setFont(fontTextField);

		DialogInfoApplicant.tabInfo.addTab("Kontakt",
				panelInfoApplicantContact);
		
	}
	
	public static void reset() {
		panelInfoApplicantContact.removeAll();
		fieldTelefonHome.setText("");
		fieldTelefonMobil.setText("");
		fieldEmail.setText("");
	}
}
