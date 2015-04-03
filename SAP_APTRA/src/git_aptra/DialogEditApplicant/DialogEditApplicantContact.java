package git_aptra.DialogEditApplicant;

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

public class DialogEditApplicantContact {
	private static JLabel labelTelefonHome = new JLabel("Telefon privat:");
	private static JLabel labelTelefonMobil = new JLabel("Telefon mobil");
	private static JLabel labelEmail = new JLabel("E-Mail:");
	@SuppressWarnings("unused")
	private Font fontHeadline = new Font("Arial", Font.BOLD, 18);
	private static Font fontTextField = new Font("Arial", Font.BOLD, 14);
	private static JTextField fieldTelefonHome = new JTextField();
	private static JTextField fieldTelefonMobil = new JTextField();
	private static JTextField fieldEmail = new JTextField();
	public static JPanel panelDialogEditApplicantContact = new JPanel();
	private static JButton save = new JButton("Speichern");

	private static String telefonHome;
	private static String telefonMobil;
	private static String email;

	public static void editApplicantContact() {
		panelDialogEditApplicantContact.setBackground(Color.LIGHT_GRAY);
		panelDialogEditApplicantContact.setLayout(new BoxLayout(
				panelDialogEditApplicantContact, BoxLayout.Y_AXIS));
		panelDialogEditApplicantContact.add(Box.createRigidArea(new Dimension(
				0, 10)));
		panelDialogEditApplicantContact.add(labelTelefonHome);
		panelDialogEditApplicantContact.add(fieldTelefonHome);
		panelDialogEditApplicantContact.add(Box.createRigidArea(new Dimension(
				0, 10)));
		fieldTelefonHome.setText(EditApplicant.getDataSetTelefonHome());
		fieldTelefonHome.setFont(fontTextField);
		panelDialogEditApplicantContact.add(labelTelefonMobil);
		panelDialogEditApplicantContact.add(fieldTelefonMobil);
		panelDialogEditApplicantContact.add(Box.createRigidArea(new Dimension(
				0, 10)));
		fieldTelefonMobil.setText(EditApplicant.getDataSetTelefonMobil());
		fieldTelefonMobil.setFont(fontTextField);
		panelDialogEditApplicantContact.add(labelEmail);
		panelDialogEditApplicantContact.add(fieldEmail);
		panelDialogEditApplicantContact.add(Box.createRigidArea(new Dimension(
				0, 10)));
		fieldEmail.setText(EditApplicant.getDataSetEmail());
		fieldEmail.setFont(fontTextField);
		panelDialogEditApplicantContact.add(save);

		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				SaveDataEditApplicant.save();
			}
		});
		DialogEditApplicant.tabEdit.addTab("Kontaktdaten",
				panelDialogEditApplicantContact);
	}

	public static boolean getContact() {
		telefonHome = fieldTelefonHome.getText();
		telefonMobil = fieldTelefonMobil.getText();
		email = fieldEmail.getText();
		if (telefonHome.equals("")) {
			return false;
		}
		if (telefonMobil.equals("")) {
			return false;
		}
		if (email.equals("")) {
			return false;
		} else {
			return true;
		}
	}

	public static void reset() {
		fieldTelefonHome.setText("");
		fieldTelefonMobil.setText("");
		fieldEmail.setText("");
		panelDialogEditApplicantContact.removeAll();
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
