package git_aptra.SearchApplicant;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class DialogSearchApplicantContact {
	
	public static JPanel panelSearchDialogApplicantContact = new JPanel();
	
	private static JLabel labelInstruction = new JLabel("Bitte tragen Sie die gesuchten Daten ein!");
	private static JLabel labelTelefonHome = new JLabel("Telefon privat:");
	private static JLabel labelTelefonMobil = new JLabel("Telefon mobil");
	private static JLabel labelEmail = new JLabel("E-Mail:");
	
	private static JTextField fieldTelefonHome = new JTextField();
	private static JTextField fieldTelefonMobil = new JTextField();
	private static JTextField fieldEmail = new JTextField();
	
	private static Font fontHeadline = new Font("Calibri", Font.BOLD, 16);
	private static Font fontSubHeadline = new Font("Calibri", Font.BOLD, 14);
	private static Font fontText = new Font("Calibri", Font.PLAIN, 14);
	
	private static JButton buttonSearch = new JButton("Suchen");
	private static JButton buttonBack = new JButton ("Zurück");

	private static String telefonHome;
	private static String telefonMobil;
	private static String email;
	static boolean first = true;
	
	public static void searchApplicantContact() {
		labelInstruction.setFont(fontHeadline);
		labelTelefonHome.setFont(fontSubHeadline);
		labelTelefonMobil.setFont(fontSubHeadline);
		labelEmail.setFont(fontSubHeadline);
		buttonSearch.setFont(fontSubHeadline);
		buttonBack.setFont(fontSubHeadline);
		fieldTelefonHome.setFont(fontText);
		fieldTelefonMobil.setFont(fontText);
		fieldEmail.setFont(fontText);
		fieldTelefonHome.setText("");
		fieldTelefonMobil.setText("");
		fieldEmail.setText("");
		panelSearchDialogApplicantContact.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][][][][][][]push[]"));
		panelSearchDialogApplicantContact.add(labelInstruction,"cell 0 0 2 1,alignx center");
		panelSearchDialogApplicantContact.add(labelTelefonHome,"cell 0 1,alignx left");
		panelSearchDialogApplicantContact.add(fieldTelefonHome,"cell 0 2 2 1,growx");
		panelSearchDialogApplicantContact.add(labelTelefonMobil,"cell 0 3,alignx left");
		panelSearchDialogApplicantContact.add(fieldTelefonMobil,"cell 0 4 2 1,growx");
		panelSearchDialogApplicantContact.add(labelEmail,"cell 0 5,alignx left");
		panelSearchDialogApplicantContact.add(fieldEmail,"cell 0 6 2 1,growx");
		panelSearchDialogApplicantContact.add(buttonBack, "cell 0 7,alignx left ");
		panelSearchDialogApplicantContact.add(buttonSearch, "cell 1 7,alignx right");
		DialogSearchApplicant.tabSearch.addTab("Kontaktdaten",panelSearchDialogApplicantContact);		
		if (first==true) {
			first=false;
			buttonBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					DialogSearchApplicant.tabSearch.setSelectedIndex(1);
				}
			});		
			buttonSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					try {
						SearchControlApplicant.search();
						DialogSearchApplicant.dialogSearchApplicant.dispose();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			});
		}
		
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
