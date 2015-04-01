package git_aptra.DialogAddApplicant;

import git_aptra.DatabaseConnection.SaveDataNewApplicant;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DialogAddApplicantContact {
	private static JLabel labelTelefonHome = new JLabel("Telefon privat:");
	private static JLabel labelTelefonMobil = new JLabel("Telefon mobil");
	private static JLabel labelEmail = new JLabel("E-Mail:");
	@SuppressWarnings("unused")
	private Font fontHeadline = new Font("Arial", Font.BOLD, 18);
	private static Font fontTextField = new Font("Arial", Font.BOLD, 14);
	private static JTextField fieldTelefonHome = new JTextField();
	private static JTextField fieldTelefonMobil = new JTextField();
	private static JTextField fieldEmail = new JTextField();
	public static JPanel panelDialogApplicantContact = new JPanel();
	private static JButton save = new JButton("Speichern");
	private static String telefonHome;
	private static String telefonMobil;
	private static String email;

	public static void addApplicantContact() {
		panelDialogApplicantContact.setBackground(Color.LIGHT_GRAY);
		panelDialogApplicantContact.setLayout(new BoxLayout(
				panelDialogApplicantContact, BoxLayout.Y_AXIS));
		panelDialogApplicantContact.add(Box
				.createRigidArea(new Dimension(0, 10)));
		panelDialogApplicantContact.add(labelTelefonHome);
		panelDialogApplicantContact.add(fieldTelefonHome);
		panelDialogApplicantContact.add(Box
				.createRigidArea(new Dimension(0, 10)));
		fieldTelefonHome.setFont(fontTextField);
		panelDialogApplicantContact.add(labelTelefonMobil);
		panelDialogApplicantContact.add(fieldTelefonMobil);
		panelDialogApplicantContact.add(Box
				.createRigidArea(new Dimension(0, 10)));
		fieldTelefonMobil.setFont(fontTextField);
		panelDialogApplicantContact.add(labelEmail);
		panelDialogApplicantContact.add(fieldEmail);
		panelDialogApplicantContact.add(Box
				.createRigidArea(new Dimension(0, 10)));
		fieldEmail.setFont(fontTextField);
		panelDialogApplicantContact.add(save);

		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				SaveDataNewApplicant.save();
			}
		});
		DialogAddApplicant.tabAdd.addTab("Kontaktdaten",
				panelDialogApplicantContact);
	}

	public static void getContact() {
		try {
			telefonHome = fieldTelefonHome.getText();
		} catch (Exception e) {
		}
		try {
			email = fieldEmail.getText();
		} catch (Exception e) {
		}
		try {
			telefonMobil = fieldTelefonMobil.getText();
		} catch (Exception e) {
		}
	}

	public static void reset() {
		fieldTelefonHome.setText("");
		fieldTelefonMobil.setText("");
		fieldEmail.setText("");
		panelDialogApplicantContact.removeAll();
	}

	public static String getTelefonHome() {
		return telefonHome;
	}

	public static String getTelefonMobil() {
		return telefonMobil;
	}

	public static String getEmail() {
		return email;
	}
}
