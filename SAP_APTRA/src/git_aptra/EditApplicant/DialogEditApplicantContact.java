package git_aptra.EditApplicant;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import com.toedter.calendar.JDateChooser;

import net.miginfocom.swing.MigLayout;

public class DialogEditApplicantContact {
	
	private static JPanel panelDialogEditApplicantContact = new JPanel();
	
	private static JLabel labelInstruction = new JLabel("Änderungen der Stammdaten!");
	private static JLabel labelTelefonHome = new JLabel("Telefon privat:");
	private static JLabel labelTelefonMobil = new JLabel("Telefon mobil");
	private static JLabel labelEmail = new JLabel("E-Mail:");
	private static JLabel labelBirthday = new JLabel("Geburtsdatum:");

	private static JTextField fieldTelefonHome = new JTextField();
	private static JTextField fieldTelefonMobil = new JTextField();
	private static JTextField fieldEmail = new JTextField();
	
	private static JDateChooser dateChooserBirthday = new JDateChooser();
	
	private static JButton buttonSave = new JButton("Speichern");
	private static JButton buttonBack = new JButton ("Zurück");
	
	private static Font fontHeadline = new Font("Calibri", Font.BOLD, 16);
	private static Font fontSubHeadline = new Font("Calibri", Font.BOLD, 14);
	private static Font fontText = new Font("Calibri", Font.PLAIN, 14);

	private static String telefonHome;
	private static String telefonMobil;
	private static String email;
	private static int day;
	private static int month;
	private static int year;
	private static Calendar cal = Calendar.getInstance();

	public static void editApplicantContact() {
		panelDialogEditApplicantContact.removeAll();
		fieldTelefonHome.setText("");
		fieldTelefonMobil.setText("");
		fieldEmail.setText("");
		labelInstruction.setFont(fontHeadline);
		buttonSave.setFont(fontSubHeadline);
		buttonBack.setFont(fontSubHeadline);
		labelTelefonHome.setFont(fontSubHeadline);
		labelTelefonMobil.setFont(fontSubHeadline);
		labelEmail.setFont(fontSubHeadline);
		labelBirthday.setFont(fontSubHeadline);
		fieldTelefonHome.setFont(fontText);
		fieldTelefonMobil.setFont(fontText);
		fieldEmail.setFont(fontText);
		fieldTelefonHome.setText(EditApplicant.getDataTelefonHome());
		fieldTelefonMobil.setText(EditApplicant.getDataTelefonMobil());
		fieldEmail.setText(EditApplicant.getDataEmail());
		dateChooserBirthday.setDate(EditApplicant.getDataDate());
		panelDialogEditApplicantContact.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][][][][][][][][]push[]"));
		panelDialogEditApplicantContact.add(labelInstruction,"cell 0 0 2 1,alignx center");
		panelDialogEditApplicantContact.add(labelTelefonHome, "cell 0 1,alignx left");
		panelDialogEditApplicantContact.add(fieldTelefonHome, "cell 0 2 2 1,growx");
		panelDialogEditApplicantContact.add(labelTelefonMobil, "cell 0 3,alignx left");
		panelDialogEditApplicantContact.add(fieldTelefonMobil, "cell 0 4 2 1,growx");
		panelDialogEditApplicantContact.add(labelEmail, "cell 0 5,alignx left");
		panelDialogEditApplicantContact.add(fieldEmail, "cell 0 6 2 1,growx");
		panelDialogEditApplicantContact.add(labelBirthday, "cell 0 7,alignx left");
		panelDialogEditApplicantContact.add(dateChooserBirthday, "cell 0 8 2,growx");
		panelDialogEditApplicantContact.add(buttonBack, "cell 0 9,alignx left ");
		panelDialogEditApplicantContact.add(buttonSave, "cell 1 9,alignx right");
		DialogEditApplicant.tabEdit.addTab("Kontaktdaten",panelDialogEditApplicantContact);
		
		buttonSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				SaveDataEditApplicant.save();
			}
		});
		
		buttonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				DialogEditApplicant.tabEdit.setSelectedIndex(1);
			}
		});
		
		
	}

	public static void getContact() {
		try {
			telefonHome = fieldTelefonHome.getText();
		} catch (Exception e) {
		}
		try {
			telefonMobil = fieldTelefonMobil.getText();
		} catch (Exception e) {
		}
		try {
			email = fieldEmail.getText();
		} catch (Exception e) {
		}
		try {
			String date = ((JTextField)dateChooserBirthday.getDateEditor().getUiComponent()).getText(); 
			String[] parts = date.split("\\.");
			day = Integer.parseInt(parts[0]);
			month = Integer.parseInt(parts[1]);
			year = Integer.parseInt(parts[2]);
			
		} catch (Exception e) {
		}
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, (month - 1));
		cal.set(Calendar.DAY_OF_MONTH, day);
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
	public static Calendar getCal() {
		return cal;
	}
}
