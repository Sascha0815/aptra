package git_aptra.DialogSearch;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DialogSearchApplicantContact {
	private static JLabel labelTelefonHome = new JLabel("Telefon privat:");
	private static JLabel labelTelefonMobil = new JLabel("Telefon mobil");
	private static JLabel labelEmail = new JLabel("E-Mail:");
	@SuppressWarnings("unused")
	private Font fontHeadline = new Font("Arial", Font.BOLD, 18);
	private static Font fontTextField = new Font("Arial", Font.BOLD, 14);
	private static JTextField fieldTelefonHome = new JTextField();
	private static JTextField fieldTelefonMobil = new JTextField();
	private static JTextField fieldEmail = new JTextField();
	public static JPanel panelSearchDialogApplicantContact = new JPanel();
	private static String telefonHome;
	private static String telefonMobil;
	private static String email;
	public static JButton search = new JButton("Suchen");
	

	public static void searchApplicantContact() {
		panelSearchDialogApplicantContact.setBackground(Color.LIGHT_GRAY);
		panelSearchDialogApplicantContact.setLayout(new BoxLayout(
				panelSearchDialogApplicantContact, BoxLayout.Y_AXIS));
		panelSearchDialogApplicantContact.add(Box
				.createRigidArea(new Dimension(0, 10)));
		panelSearchDialogApplicantContact.add(labelTelefonHome);
		panelSearchDialogApplicantContact.add(fieldTelefonHome);
		panelSearchDialogApplicantContact.add(Box
				.createRigidArea(new Dimension(0, 10)));
		fieldTelefonHome.setFont(fontTextField);
		panelSearchDialogApplicantContact.add(labelTelefonMobil);
		panelSearchDialogApplicantContact.add(fieldTelefonMobil);
		panelSearchDialogApplicantContact.add(Box
				.createRigidArea(new Dimension(0, 10)));
		fieldTelefonMobil.setFont(fontTextField);
		panelSearchDialogApplicantContact.add(labelEmail);
		panelSearchDialogApplicantContact.add(fieldEmail);
		panelSearchDialogApplicantContact.add(Box
				.createRigidArea(new Dimension(0, 10)));
		fieldEmail.setFont(fontTextField);
		panelSearchDialogApplicantContact.add(search);
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
			try {
				 	SearchControl.search();
					CloseDialogSearchApplicant.closeSearchApplicant();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		
		DialogSearchApplicant.tabSearch.addTab("Kontaktdaten",
				panelSearchDialogApplicantContact);
	}

	public static void getContact() {
		try {
			telefonHome = fieldTelefonHome.getText();
			telefonMobil = fieldTelefonMobil.getText();
			email = fieldEmail.getText();
		} catch (Exception e) {
			System.out.println("Nicht alle Daten eingegeben");
		}
	}

	public static void reset() {
		fieldTelefonHome.setText("");
		fieldTelefonMobil.setText("");
		fieldEmail.setText("");
		panelSearchDialogApplicantContact.removeAll();
		ActionListener[] al = search.getActionListeners();
		search.removeActionListener(al[0]);
		
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
