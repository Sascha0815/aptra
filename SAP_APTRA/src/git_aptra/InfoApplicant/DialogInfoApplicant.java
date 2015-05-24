package git_aptra.InfoApplicant;

import java.awt.Font;
import git_aptra.Oberflaeche;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

import net.miginfocom.swing.MigLayout;

public class DialogInfoApplicant {
	private static JDialog dialogInfoApplicant = new JDialog(Oberflaeche.frame);
	 
	private static JPanel panelDialogInfoApplicant = new JPanel();
	
	private static JTabbedPane tabInfo = new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);
	
	private static JLabel labelInstruction = new JLabel("Bewerberdaten");
	private static JLabel labelApplicantID = new JLabel("Bewerbernummer:");
	private static JLabel labelName = new JLabel("Name:");
	private static JLabel labelFirstName = new JLabel("Vorname:");
	private static JLabel labelStreet = new JLabel("Stra�e:");
	private static JLabel labelHouseNr = new JLabel("Hausnummer:");
	private static JLabel labelPostalCode = new JLabel("PLZ:");
	private static JLabel labelCity = new JLabel("Wohnort:");
	private static JLabel labelTelefonHome = new JLabel("Telefon privat:");
	private static JLabel labelTelefonMobil = new JLabel("Telefon mobil:");
	private static JLabel labelEmail = new JLabel("E-Mail:");
	private static JLabel labelDateOfBirth = new JLabel("Geburtsdatum:");
	private static JLabel labelDateOfApplication = new JLabel("Bewerbungseingang:");
	private static JLabel labelVacancyID = new JLabel("Stellenidentifikationsnummer:");
	private static JLabel labelVacancy = new JLabel("Stellenbeschreibung:");
	private static JLabel labelEducationalAchievement = new JLabel("H�chster Bildungsabschluss:");
	private static JLabel labelApplicantIDContent = new JLabel();
	private static JLabel labelNameContent = new JLabel();
	private static JLabel labelFirstNameContent = new JLabel();
	private static JLabel labelStreetContent = new JLabel();
	private static JLabel labelHouseNrContent = new JLabel();
	private static JLabel labelPostalCodeContent = new JLabel();
	private static JLabel labelCityContent = new JLabel();
	private static JLabel labelTelefonHomeContent = new JLabel();
	private static JLabel labelTelefonMobilContent = new JLabel();
	private static JLabel labelEmailContent = new JLabel();
	private static JLabel labelDateOfBirthContent = new JLabel();
	private static JLabel labelDateOfApplicationContent = new JLabel();
	private static JLabel labelVacancyIDContent = new JLabel();
	private static JLabel labelVacancyContent = new JLabel();
	private static JLabel labelEducationalAchievementContent = new JLabel();
	
	private static Font fontHeadline = new Font("Calibri", Font.BOLD, 16);
	private static Font fontSubHeadline = new Font("Calibri", Font.BOLD, 14);
	private static Font fontText = new Font("Calibri", Font.PLAIN, 14);

	public static void infoApplicant() {
		dialogInfoApplicant.setVisible(true);
		dialogInfoApplicant.setSize(425, 500);
		dialogInfoApplicant.setLocationRelativeTo(null);
		dialogInfoApplicant.setResizable(false);
		dialogInfoApplicant.setTitle("Bewerberinformationen");
		SwingUtilities.updateComponentTreeUI(dialogInfoApplicant);
		dialogInfoApplicant.setLocationRelativeTo(Oberflaeche.frame);
		dialogInfoApplicant.add(tabInfo);
		dialogInfoApplicant.add(panelDialogInfoApplicant);
		labelInstruction.setFont(fontHeadline);
		labelApplicantID.setFont(fontSubHeadline);
		labelName.setFont(fontSubHeadline);
		labelFirstName.setFont(fontSubHeadline);
		labelStreet.setFont(fontSubHeadline);
		labelHouseNr.setFont(fontSubHeadline);
		labelPostalCode.setFont(fontSubHeadline);
		labelCity.setFont(fontSubHeadline);
		labelTelefonHome.setFont(fontSubHeadline);
		labelTelefonMobil.setFont(fontSubHeadline);
		labelEmail.setFont(fontSubHeadline);
		labelDateOfBirth.setFont(fontSubHeadline);
		labelDateOfApplication.setFont(fontSubHeadline);
		labelVacancyID.setFont(fontSubHeadline);
		labelVacancy.setFont(fontSubHeadline);
		labelEducationalAchievement.setFont(fontSubHeadline);
		labelApplicantIDContent.setFont(fontText);
		labelNameContent.setFont(fontText);
		labelFirstNameContent.setFont(fontText);
		labelStreetContent.setFont(fontText);
		labelHouseNrContent.setFont(fontText);
		labelPostalCodeContent.setFont(fontText);
		labelCityContent.setFont(fontText);
		labelTelefonHomeContent.setFont(fontText);
		labelTelefonMobilContent.setFont(fontText);
		labelEmailContent.setFont(fontText);
		labelDateOfBirthContent.setFont(fontText);
		labelDateOfApplicationContent.setFont(fontText);
		labelVacancyIDContent.setFont(fontText);
		labelVacancyContent.setFont(fontText);
		labelEducationalAchievementContent.setFont(fontText);
		labelNameContent.setText(InfoApplicant.getDataSetName());
		labelFirstNameContent.setText(InfoApplicant.getDataSetFirstName());
		labelStreetContent.setText(InfoApplicant.getDataSetStreet());
		labelHouseNrContent.setText(InfoApplicant.getDataSetHouseNr());
		labelPostalCodeContent.setText(InfoApplicant.getDataSetPostalCode());
		labelCityContent.setText(InfoApplicant.getDataSetCity());
		labelTelefonHomeContent.setText(InfoApplicant.getDataSetTelefonHome());
		labelTelefonMobilContent.setText(InfoApplicant.getDataSetTelefonMobil());
		labelEmailContent.setText(InfoApplicant.getDataSetEmail());
		labelDateOfBirthContent.setText("");
		labelVacancyIDContent.setText(InfoApplicant.getDataSetVacancyID());
		labelVacancyContent.setText(InfoApplicant.getDataSetVacancy());
		labelEducationalAchievementContent.setText(InfoApplicant.getDataSetEducationalAchievement());
		panelDialogInfoApplicant.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][][][][][][][][][][][][][]"));
		panelDialogInfoApplicant.add(labelInstruction,"cell 0 0 2 1,alignx center");
		panelDialogInfoApplicant.add(labelName, "cell 0 1,alignx left");
		panelDialogInfoApplicant.add(labelNameContent, "cell 0 1 1,alignx left");
		panelDialogInfoApplicant.add(labelFirstName, "cell 0 2,alignx left");
		panelDialogInfoApplicant.add(labelFirstNameContent, "cell 0 2 1,alignx left");
		panelDialogInfoApplicant.add(labelStreet, "cell 0 3,alignx left");
		panelDialogInfoApplicant.add(labelStreetContent, "cell 0 3 1,alignx left");
		panelDialogInfoApplicant.add(labelHouseNr, "cell 0 4,alignx left");
		panelDialogInfoApplicant.add(labelHouseNrContent, "cell 0 4 1,alignx left");
		panelDialogInfoApplicant.add(labelPostalCode, "cell 0 5,alignx left");
		panelDialogInfoApplicant.add(labelPostalCodeContent, "cell 0 5 1,alignx left");
		panelDialogInfoApplicant.add(labelCity, "cell 0 6,alignx left");
		panelDialogInfoApplicant.add(labelCityContent, "cell 0 6 1,alignx left");
		panelDialogInfoApplicant.add(labelTelefonHome, "cell 0 7,alignx left");
		panelDialogInfoApplicant.add(labelTelefonHomeContent, "cell 0 7 1,alignx left");
		panelDialogInfoApplicant.add(labelTelefonMobil, "cell 0 8,alignx left");
		panelDialogInfoApplicant.add(labelTelefonMobilContent, "cell 0 8 1,alignx left");
		panelDialogInfoApplicant.add(labelEmail, "cell 0 9,alignx left");
		panelDialogInfoApplicant.add(labelEmailContent, "cell 0 9 1,alignx left");
		panelDialogInfoApplicant.add(labelDateOfBirth, "cell 0 10,alignx left");
		panelDialogInfoApplicant.add(labelDateOfBirthContent, "cell 0 10 1,alignx left");
		panelDialogInfoApplicant.add(labelDateOfApplication, "cell 0 11,alignx left");
		panelDialogInfoApplicant.add(labelDateOfApplicationContent, "cell 0 11 1,alignx left");
		panelDialogInfoApplicant.add(labelVacancyID, "cell 0 12,alignx left");
		panelDialogInfoApplicant.add(labelVacancyIDContent, "cell 0 12 1,alignx left");
		panelDialogInfoApplicant.add(labelVacancy, "cell 0 13,alignx left");
		panelDialogInfoApplicant.add(labelVacancyContent, "cell 0 13 1,alignx left");
		panelDialogInfoApplicant.add(labelEducationalAchievement, "cell 0 14,alignx left");
		panelDialogInfoApplicant.add(labelEducationalAchievementContent, "cell 0 14 1,alignx left");
		
	}

}
