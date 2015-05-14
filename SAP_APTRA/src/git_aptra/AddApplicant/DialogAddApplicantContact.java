package git_aptra.AddApplicant;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class DialogAddApplicantContact {
	
	public static JPanel panelDialogApplicantContact = new JPanel();
	
	private static JLabel labelTelefonHome = new JLabel("Telefon privat:");
	private static JLabel labelTelefonMobil = new JLabel("Telefon mobil:");
	private static JLabel labelEmail = new JLabel("E-Mail:");
	private static JLabel labelInstruction = new JLabel("Bitte tragen Sie alle erforderlichen Daten ein!");
	private static JLabel labelBirthday = new JLabel("Geburtsdatum:");
	
	private static JTextField fieldTelefonHome = new JTextField();
	private static JTextField fieldTelefonMobil = new JTextField();
	private static JTextField fieldEmail = new JTextField();
	
	private static Integer[] boxListDay = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
		12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28,
		29, 30, 31 };
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static JComboBox boxDay = new JComboBox(boxListDay);
	private static Integer[] boxListMonth = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
		11, 12 };
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static JComboBox boxMonth = new JComboBox(boxListMonth);
	private static Integer[] boxListYear = { 2000, 1999, 1998, 1997, 1996,
		1995, 1994, 1993, 1992, 1991, 1990, 1989, 1988, 1987, 1986, 1985,
		1984, 1983, 1982, 1981, 1980, 1979, 1978, 1977, 1976, 1975, 1974,
		1973, 1972, 1971, 1970 };
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static JComboBox boxYear = new JComboBox(boxListYear);
	
	private static JButton save = new JButton("Speichern");
	private static JButton buttonAbort = new JButton ("Abbrechen");
	
	private static String telefonHome;
	private static String telefonMobil;
	private static String email;
	private static int day;
	private static int month;
	private static int year;
	private static Calendar cal = Calendar.getInstance();

	public static void addApplicantContact() {
		panelDialogApplicantContact.setLayout(new MigLayout("", "[grow][grow][grow]", "[][][][][][][][][][][][][][]"));
		panelDialogApplicantContact.add(labelInstruction,"cell 0 0,alignx right");
		panelDialogApplicantContact.add(labelTelefonHome, "cell 0 1,alignx left");
		panelDialogApplicantContact.add(fieldTelefonHome, "cell 0 2 3 1,growx");
		panelDialogApplicantContact.add(labelTelefonMobil, "cell 0 3,alignx left");
		panelDialogApplicantContact.add(fieldTelefonMobil, "cell 0 4 3 1,growx");
		panelDialogApplicantContact.add(labelEmail, "cell 0 5,alignx left");
		panelDialogApplicantContact.add(fieldEmail, "cell 0 6 3 1,growx");
		panelDialogApplicantContact.add(labelBirthday, "cell 0 7,alignx left");
		panelDialogApplicantContact.add(boxDay, "cell 0 8");
		panelDialogApplicantContact.add(boxMonth, "cell 0 8 1");
		panelDialogApplicantContact.add(boxYear, "cell 0 8 2");
		panelDialogApplicantContact.add(save, "cell 0 9,alignx left");
		panelDialogApplicantContact.add(buttonAbort, "cell 2 9,alignx right");
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
		day = (int) boxDay.getSelectedItem();
		month = (int) boxMonth.getSelectedItem();
		year = (int) boxYear.getSelectedItem();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, (month - 1));
		cal.set(Calendar.DAY_OF_MONTH, day);
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
	
	public static Calendar getCal() {
		return cal;
	}
}
