package git_aptra.EditApplicant;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;

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
	
	private static SpinnerNumberModel numberModelDay = new SpinnerNumberModel(1,1,31,1);
	private static SpinnerListModel listModelMonth = new SpinnerListModel(new String[] {"Januar", "Februar", "März", "April", "Mai", "Juni", "Juli", "August", "September", "Oktober", "November", "Dezember"});
	private static SpinnerNumberModel numberModelYear = new SpinnerNumberModel(1,1,2100,1);
	
	private static JSpinner spinnerDay = new JSpinner(numberModelDay);
	private static JSpinner spinnerMonth = new JSpinner(listModelMonth);
	private static JSpinner spinnerYear = new JSpinner(numberModelYear);
	
	private static JButton buttonSave = new JButton("Speichern");
	private static JButton buttonAbort = new JButton ("Abbrechen");
	
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
		labelInstruction.setFont(fontHeadline);
		spinnerDay.setFont(fontSubHeadline);
		spinnerMonth.setFont(fontSubHeadline);
		spinnerYear.setFont(fontSubHeadline);
		buttonSave.setFont(fontSubHeadline);
		buttonAbort.setFont(fontSubHeadline);
		labelTelefonHome.setFont(fontSubHeadline);
		labelTelefonMobil.setFont(fontSubHeadline);
		labelEmail.setFont(fontSubHeadline);
		labelBirthday.setFont(fontSubHeadline);
		fieldTelefonHome.setFont(fontText);
		fieldTelefonMobil.setFont(fontText);
		fieldEmail.setFont(fontText);
		fieldTelefonHome.setText(EditApplicant.getDataSetTelefonHome());
		fieldTelefonMobil.setText(EditApplicant.getDataSetTelefonMobil());
		fieldEmail.setText(EditApplicant.getDataSetEmail());
		spinnerDay.setValue(EditApplicant.getDataSetDay());
		spinnerMonth.setValue(EditApplicant.getDataSetMonth());
		spinnerYear.setValue(EditApplicant.getDataSetYear());
		panelDialogEditApplicantContact.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][][][][][][][][][]"));
		panelDialogEditApplicantContact.add(labelInstruction,"cell 0 0 2 1,alignx center");
		panelDialogEditApplicantContact.add(labelTelefonHome, "cell 0 1,alignx left");
		panelDialogEditApplicantContact.add(fieldTelefonHome, "cell 0 2 2 1,growx");
		panelDialogEditApplicantContact.add(labelTelefonMobil, "cell 0 3,alignx left");
		panelDialogEditApplicantContact.add(fieldTelefonMobil, "cell 0 4 2 1,growx");
		panelDialogEditApplicantContact.add(labelEmail, "cell 0 5,alignx left");
		panelDialogEditApplicantContact.add(fieldEmail, "cell 0 6 2 1,growx");
		panelDialogEditApplicantContact.add(labelBirthday, "cell 0 7,alignx left");
		panelDialogEditApplicantContact.add(spinnerDay, "cell 0 8 2, growx");
		panelDialogEditApplicantContact.add(spinnerMonth, "cell 0 8 2 1, growx");
		panelDialogEditApplicantContact.add(spinnerYear, "cell 0 8 2 2, growx");
		panelDialogEditApplicantContact.add(buttonSave, "cell 0 9,alignx left");
		panelDialogEditApplicantContact.add(buttonAbort, "cell 1 9,alignx right ");
		DialogEditApplicant.tabEdit.addTab("Kontaktdaten",panelDialogEditApplicantContact);

		buttonSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				SaveDataEditApplicant.save();
			}
		});
		
		buttonAbort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				DialogEditApplicant.dialogEditApplicant.dispose();
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
		day = (int) spinnerDay.getValue();
		String valueSpinnerMonth = (String) spinnerMonth.getValue();
		if(valueSpinnerMonth.equals("Januar")){
			month = 1;
		}
		if(valueSpinnerMonth.equals("Februar")){
			month = 2;
		}
		if(valueSpinnerMonth.equals("März")){
			month = 3;
		}
		if(valueSpinnerMonth.equals("April")){
			month = 4;
		}
		if(valueSpinnerMonth.equals("Mai")){
			month = 5;
		}
		if(valueSpinnerMonth.equals("Juni")){
			month = 6;
		}
		if(valueSpinnerMonth.equals("Juli")){
			month = 7;
		}
		if(valueSpinnerMonth.equals("August")){
			month = 8;
		}
		if(valueSpinnerMonth.equals("September")){
			month = 9;
		}
		if(valueSpinnerMonth.equals("Oktober")){
			month = 10;
		}
		if(valueSpinnerMonth.equals("November")){
			month = 11;
		}
		if(valueSpinnerMonth.equals("Dezember")){
			month = 12;
		}
		year = (int) spinnerYear.getValue();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, (month - 1));
		cal.set(Calendar.DAY_OF_MONTH, day);
	}

	public static void reset() {
		fieldTelefonHome.setText("");
		fieldTelefonMobil.setText("");
		fieldEmail.setText("");
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
