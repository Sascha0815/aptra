package git_aptra.AddApplicant;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
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
	private static JLabel labelTelefonMobil = new JLabel("Telefon mobil:");
	private static JLabel labelEmail = new JLabel("E-Mail:");
	private static JLabel labelInstruction = new JLabel("Bitte tragen Sie alle erforderlichen Daten ein!");
	@SuppressWarnings("unused")
	private static Font fontHeadline = new Font("Arial", Font.BOLD, 18);
	private static Font fontTextField = new Font("Arial", Font.BOLD, 14);
	private static JTextField fieldTelefonHome = new JTextField(35);
	private static JTextField fieldTelefonMobil = new JTextField(35);
	private static JTextField fieldEmail = new JTextField(35);
	public static JPanel panelDialogApplicantContact = new JPanel();
	private static JButton save = new JButton("Speichern");
	private static GridBagConstraints gbc = new GridBagConstraints();
	private static String telefonHome;
	private static String telefonMobil;
	private static String email;

	public static void addApplicantContact() {
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.weighty = 2;
	    labelInstruction.setFont(fontHeadline);
	    panelDialogApplicantContact.add(labelInstruction,gbc);
	    gbc.gridx = 0;
	    gbc.gridy = 1;
	    panelDialogApplicantContact.add(labelTelefonHome,gbc);
	    gbc.gridx = 0;
	    gbc.gridy = 2;
	    panelDialogApplicantContact.add(fieldTelefonHome,gbc);
	    gbc.gridx = 0;
	    gbc.gridy = 3;
	    panelDialogApplicantContact.add(labelTelefonMobil,gbc);
	    gbc.gridx = 0;
	    gbc.gridy = 4;
	    panelDialogApplicantContact.add(fieldTelefonMobil,gbc);
	    gbc.gridx = 0;
	    gbc.gridy = 5;
	    panelDialogApplicantContact.add(labelEmail,gbc);
	    gbc.gridx = 0;
	    gbc.gridy = 6;
	    panelDialogApplicantContact.add(fieldEmail,gbc);
	    gbc.gridx = 0;
	    gbc.gridy = 7;
	    gbc.anchor = GridBagConstraints.WEST;
	    gbc.fill = GridBagConstraints.NONE;
	    panelDialogApplicantContact.add(save,gbc);

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
		ActionListener[] al = save.getActionListeners();
		save.removeActionListener(al[0]);
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
