package git_aptra.InfoVacancy;

import java.awt.Font;
import git_aptra.Oberflaeche;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import net.miginfocom.swing.MigLayout;

public class DialogInfoVacancy {
	private static JDialog dialogInfoVacancy = new JDialog(Oberflaeche.frame, true);
	 
	private static JPanel panelDialogInfoVacancy = new JPanel();
	
	private static JLabel labelInstruction = new JLabel("Stelleninformation");
	private static JLabel labelVacancyID = new JLabel("Stellen-ID:");
	private static JLabel labelArea = new JLabel("Arbeitsbereich:");
	private static JLabel labelPosition = new JLabel("Stellenbezeichnung:");
	private static JLabel labelRequirementLevel = new JLabel("Anforderung:");
	private static JLabel labelTermsOfEmployment = new JLabel("Anstellungsverhältnis:");
	private static JLabel labelVacancyStatus = new JLabel("Status:");
	private static JLabel labelEducationalAchievement = new JLabel("Höchster Bildungsabschluss:");
	private static JLabel labelLevel = new JLabel("Zusatz/Vermerk:");
	private static JLabel labelDeadline = new JLabel("Bewerbungsschluss:");
	private static JLabel labelVacancyIDContent = new JLabel();
	private static JLabel labelAreaContent = new JLabel();
	private static JLabel labelPositionContent = new JLabel();
	private static JLabel labelRequirementLevelContent = new JLabel();
	private static JLabel labelTermsOfEmploymentContent = new JLabel();
	private static JLabel labelVacancyStatusContent = new JLabel();
	private static JLabel labelEducationalAchievementContent = new JLabel();
	private static JLabel labelLevelContent = new JLabel();
	private static JLabel labelDeadlineContent = new JLabel();
	
	private static Font fontHeadline = new Font("Calibri", Font.BOLD, 16);
	private static Font fontSubHeadline = new Font("Calibri", Font.BOLD, 14);
	private static Font fontText = new Font("Calibri", Font.PLAIN, 14);
	
	public static void infoVacancy(){
		dialogInfoVacancy.setSize(425, 250);
		dialogInfoVacancy.setLocationRelativeTo(null);
		dialogInfoVacancy.setResizable(false);
		dialogInfoVacancy.setTitle("Stelleninformationen");
		SwingUtilities.updateComponentTreeUI(dialogInfoVacancy);
		dialogInfoVacancy.setLocationRelativeTo(Oberflaeche.frame);
		dialogInfoVacancy.add(panelDialogInfoVacancy);
		labelInstruction.setFont(fontHeadline);
		labelVacancyID.setFont(fontSubHeadline);
		labelArea.setFont(fontSubHeadline);
		labelPosition.setFont(fontSubHeadline);
		labelRequirementLevel.setFont(fontSubHeadline);
		labelTermsOfEmployment.setFont(fontSubHeadline);
		labelVacancyStatus.setFont(fontSubHeadline);
		labelEducationalAchievement.setFont(fontSubHeadline);
		labelLevel.setFont(fontSubHeadline);
		labelDeadline.setFont(fontSubHeadline);
		labelVacancyIDContent.setFont(fontText);
		labelAreaContent.setFont(fontText);
		labelPositionContent.setFont(fontText);
		labelRequirementLevelContent.setFont(fontText);
		labelTermsOfEmploymentContent.setFont(fontText);
		labelVacancyStatusContent.setFont(fontText);
		labelEducationalAchievementContent.setFont(fontText);
		labelLevelContent.setFont(fontText);
		labelDeadlineContent.setFont(fontText);
		labelVacancyIDContent.setText(InfoVacancy.getDataSetVacancyID());
		labelAreaContent.setText(InfoVacancy.getDataSetArea());
		labelPositionContent.setText(InfoVacancy.getDataSetPosition());
		labelRequirementLevelContent.setText(InfoVacancy.getDataSetRequirementLevel());
		labelTermsOfEmploymentContent.setText(InfoVacancy.getDataSetTermsOfEmployment());
		labelVacancyStatusContent.setText(InfoVacancy.getDataSetVacancyStatus());
		labelEducationalAchievementContent.setText(InfoVacancy.getDataSetEducationalAchievement());
		labelLevelContent.setText(InfoVacancy.getDataSetNote());
		labelDeadlineContent.setText(InfoVacancy.getDataSetDate());
		panelDialogInfoVacancy.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][][][][][][][][][][][][][]"));
		panelDialogInfoVacancy.add(labelInstruction,"cell 0 0 2 1,alignx center");
		panelDialogInfoVacancy.add(labelVacancyID, "cell 0 1,alignx left");
		panelDialogInfoVacancy.add(labelVacancyIDContent, "cell 0 1 1,alignx left");
		panelDialogInfoVacancy.add(labelArea, "cell 0 2,alignx left");
		panelDialogInfoVacancy.add(labelAreaContent, "cell 0 2 1,alignx left");
		panelDialogInfoVacancy.add(labelPosition, "cell 0 3,alignx left");
		panelDialogInfoVacancy.add(labelPositionContent, "cell 0 3 1,alignx left");
		panelDialogInfoVacancy.add(labelRequirementLevel, "cell 0 4,alignx left");
		panelDialogInfoVacancy.add(labelRequirementLevelContent, "cell 0 4 1,alignx left");
		panelDialogInfoVacancy.add(labelTermsOfEmployment, "cell 0 5,alignx left");
		panelDialogInfoVacancy.add(labelTermsOfEmploymentContent, "cell 0 5 1,alignx left");
		panelDialogInfoVacancy.add(labelVacancyStatus, "cell 0 6,alignx left");
		panelDialogInfoVacancy.add(labelVacancyStatusContent, "cell 0 6 1,alignx left");
		panelDialogInfoVacancy.add(labelEducationalAchievement, "cell 0 7,alignx left");
		panelDialogInfoVacancy.add(labelEducationalAchievementContent, "cell 0 7 1,alignx left");
		panelDialogInfoVacancy.add(labelLevel, "cell 0 8,alignx left");
		panelDialogInfoVacancy.add(labelLevelContent, "cell 0 8 1,alignx left");
		panelDialogInfoVacancy.add(labelDeadline, "cell 0 9,alignx left");
		panelDialogInfoVacancy.add(labelDeadlineContent, "cell 0 9 1,alignx left");
		dialogInfoVacancy.setVisible(true);
	}
}
