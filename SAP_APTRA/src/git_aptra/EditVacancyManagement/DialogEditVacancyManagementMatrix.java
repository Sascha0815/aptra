package git_aptra.EditVacancyManagement;


import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;



public class DialogEditVacancyManagementMatrix {

	private static JPanel panelDialogEditVacancyManagementMatrix = new JPanel();

	private static JSlider sliderImpression = new JSlider();	
	private static JSlider sliderExperience = new JSlider();
	private static JSlider sliderSocialEngagement = new JSlider();
	
	private static JLabel labelImpression = new JLabel("Persönlicher Eindruck");
	private static JLabel labelExperience = new JLabel("Vorerfahrung");
	private static JLabel labelSocialEngagement = new JLabel("Soziales Engangement");
	
	private static int scoreImpression;
	private static int scoreExperience;
	private static int scoreSocialEngagement;
	
	public static void editVacancyManagementMatrix() {
		panelDialogEditVacancyManagementMatrix.setBackground(Color.LIGHT_GRAY);
		panelDialogEditVacancyManagementMatrix.setLayout(new BoxLayout(
				panelDialogEditVacancyManagementMatrix, BoxLayout.Y_AXIS));
		panelDialogEditVacancyManagementMatrix.add(Box
				.createRigidArea(new Dimension(0, 10)));
		DialogEditVacancyManagement.tabEditVacancyManagment.addTab("Bewertung",
				panelDialogEditVacancyManagementMatrix);
		
		
		panelDialogEditVacancyManagementMatrix.add(Box
				.createRigidArea(new Dimension(0, 10)));
		panelDialogEditVacancyManagementMatrix.add(labelImpression);	
		panelDialogEditVacancyManagementMatrix.add(Box
				.createRigidArea(new Dimension(0, 10)));
				sliderImpression.setMinimum(0);
				sliderImpression.setMaximum(5);
				sliderImpression.setMajorTickSpacing(1);
				sliderImpression.createStandardLabels(1);
				sliderImpression.setPaintTicks(true);
				sliderImpression.setPaintLabels(true);
				sliderImpression.setValue(0);
		panelDialogEditVacancyManagementMatrix.add(sliderImpression);
				
		panelDialogEditVacancyManagementMatrix.add(Box
				.createRigidArea(new Dimension(0, 20)));
		panelDialogEditVacancyManagementMatrix.add(labelExperience);			
		panelDialogEditVacancyManagementMatrix.add(Box
				.createRigidArea(new Dimension(0, 10)));
				sliderExperience.setMinimum(0);
				sliderExperience.setMaximum(5);
				sliderExperience.setMajorTickSpacing(1);
				sliderExperience.createStandardLabels(1);
				sliderExperience.setPaintTicks(true);
				sliderExperience.setPaintLabels(true);
				sliderExperience.setValue(0);
		panelDialogEditVacancyManagementMatrix.add(sliderExperience);

		panelDialogEditVacancyManagementMatrix.add(Box
				.createRigidArea(new Dimension(0, 20)));
		panelDialogEditVacancyManagementMatrix.add(labelSocialEngagement);	
		panelDialogEditVacancyManagementMatrix.add(Box
				.createRigidArea(new Dimension(0, 10)));
				sliderSocialEngagement.setMinimum(0);
				sliderSocialEngagement.setMaximum(5);
				sliderSocialEngagement.setMajorTickSpacing(1);
				sliderSocialEngagement.createStandardLabels(1);
				sliderSocialEngagement.setPaintTicks(true);
				sliderSocialEngagement.setPaintLabels(true);
				sliderSocialEngagement.setValue(0);
		panelDialogEditVacancyManagementMatrix.add(sliderSocialEngagement);	
		panelDialogEditVacancyManagementMatrix.add(Box
				.createRigidArea(new Dimension(0, 10)));
				
		
		}

		
	

	public static void reset() {
		panelDialogEditVacancyManagementMatrix.removeAll();
		
	}
	
	public static void getMatrix() {
		try {
			scoreImpression = sliderImpression.getValue();
		} catch (Exception e) {
		}
		try {
			scoreExperience = sliderExperience.getValue();
		} catch (Exception e) {
		}
		try {
			scoreSocialEngagement = sliderSocialEngagement.getValue();
		} catch (Exception e) {
		}
		
	}
	
}


