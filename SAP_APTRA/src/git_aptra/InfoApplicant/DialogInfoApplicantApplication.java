package git_aptra.InfoApplicant;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DialogInfoApplicantApplication {

	public static JPanel panelInfoApplicantApplication = new JPanel();

	private static JLabel labelDateOfBirth = new JLabel("Geburtsdatum:");
	private static JLabel labelDateOfApplication = new JLabel("Bewerbungseingang:");
	private static JLabel labelVacancyID = new JLabel(
			"Stellenidentifikationsnummer:");
	private static JLabel labelVacancy = new JLabel("Stellenbeschreibung:");
	private static JLabel labelEducationalAchievement = new JLabel(
			"H�chster Bildungsabschluss:");

	private static Font fontTextField = new Font("Arial", Font.BOLD, 14);

	private static JTextField fieldDateOfBirth = new JTextField();
	private static JTextField fieldVacancyID = new JTextField();
	private static JTextField fieldVacancy = new JTextField();
	private static JTextField fieldDateOfApplication = new JTextField();
	private static JTextField fieldEducationalAchievement = new JTextField();

	public static void infoApplicantApplication() {
		panelInfoApplicantApplication.setBackground(Color.LIGHT_GRAY);
		panelInfoApplicantApplication.setLayout(new BoxLayout(
				panelInfoApplicantApplication, BoxLayout.Y_AXIS));

		panelInfoApplicantApplication.add(Box.createRigidArea(new Dimension(
				0, 10)));
		panelInfoApplicantApplication.add(labelDateOfApplication);
		panelInfoApplicantApplication.add(Box.createRigidArea(new Dimension(
				0, 10)));
		labelDateOfApplication.setFont(fontTextField);
		panelInfoApplicantApplication.add(fieldDateOfApplication);
		fieldDateOfApplication.setEditable(false);
		fieldDateOfApplication.setFont(fontTextField);
		fieldDateOfApplication.setText(InfoApplicant.getDataSetDateApplication());
		panelInfoApplicantApplication.add(Box.createRigidArea(new Dimension(
				0, 10)));

		panelInfoApplicantApplication.add(labelVacancyID);
		labelVacancyID.setFont(fontTextField);
		panelInfoApplicantApplication.add(Box.createRigidArea(new Dimension(
				0, 10)));
		panelInfoApplicantApplication.add(fieldVacancyID);
		fieldVacancyID.setFont(fontTextField);
		fieldVacancyID.setEditable(false);
		fieldVacancyID.setText(InfoApplicant.getDataSetDateVacancyID());
		panelInfoApplicantApplication.add(Box.createRigidArea(new Dimension(
				0, 10)));

		panelInfoApplicantApplication.add(labelVacancy);
		labelVacancy.setFont(fontTextField);
		panelInfoApplicantApplication.add(Box.createRigidArea(new Dimension(
				0, 10)));
		panelInfoApplicantApplication.add(fieldVacancy);
		fieldVacancy.setFont(fontTextField);
		fieldVacancy.setEditable(false);
		fieldVacancy.setText(InfoApplicant.getDataSetVacancy());
		panelInfoApplicantApplication.add(Box.createRigidArea(new Dimension(
				0, 10)));

		panelInfoApplicantApplication.add(labelDateOfBirth);
		labelDateOfBirth.setFont(fontTextField);
		panelInfoApplicantApplication.add(Box.createRigidArea(new Dimension(
				0, 10)));
		panelInfoApplicantApplication.add(fieldDateOfBirth);
		fieldDateOfBirth.setFont(fontTextField);
		fieldDateOfBirth.setEditable(false);
		fieldDateOfBirth.setText(InfoApplicant.getDataSetDate());
		panelInfoApplicantApplication.add(Box.createRigidArea(new Dimension(
				0, 10)));
		
		panelInfoApplicantApplication.add(labelEducationalAchievement);
		labelEducationalAchievement.setFont(fontTextField);
		fieldEducationalAchievement.setFont(fontTextField);
		fieldEducationalAchievement.setEditable(false);
		fieldEducationalAchievement.setText(InfoApplicant.getDataSetEducationalAchievement());
		panelInfoApplicantApplication.add(Box.createRigidArea(new Dimension(
				0, 10)));
		panelInfoApplicantApplication.add(fieldEducationalAchievement);
		panelInfoApplicantApplication.add(Box.createRigidArea(new Dimension(
				0, 10)));
		DialogInfoApplicant.tabInfo.addTab("Bewerbung",
				panelInfoApplicantApplication);
	
	}
	
	public static void reset() {
		panelInfoApplicantApplication.removeAll();
		fieldDateOfBirth.setText("");
		fieldVacancyID.setText("");
		fieldVacancy.setText("");
		fieldDateOfApplication.setText("");
		fieldEducationalAchievement.setText("");
	}

}