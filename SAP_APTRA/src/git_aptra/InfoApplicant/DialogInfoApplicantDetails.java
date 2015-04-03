package git_aptra.InfoApplicant;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DialogInfoApplicantDetails {

	private static JPanel panelInfoApplicantManagementDetails = new JPanel();

	private static JLabel labelMarkApplicant = new JLabel("Eindruck des Bewerber:");
	private static JLabel labelMarkApplication = new JLabel("Eindruck der Bewerbung:");
	private static JLabel labelComplete = new JLabel("Vollständigkeit der Bewerbung:");
	private static JLabel labelCheckCL = new JLabel ("Anschreiben");
	private static JLabel labelCheckCV = new JLabel ("Lebenslauf");
	
	private static JCheckBox checkCL = new JCheckBox("Anschreiben");
	private static JCheckBox checkCV = new JCheckBox("Lebenslauf");
	
	private static Font fontTextField = new Font("Arial", Font.BOLD, 14);

	private static JTextField fieldMarkApplicant = new JTextField();
	private static JTextField fieldMarkApplication = new JTextField();
	
	public static void infoApplicantManagementDetails() {
		
		panelInfoApplicantManagementDetails.setBackground(Color.LIGHT_GRAY);
		panelInfoApplicantManagementDetails.setLayout(new BoxLayout(
				panelInfoApplicantManagementDetails, BoxLayout.Y_AXIS));
		panelInfoApplicantManagementDetails.add(Box
				.createRigidArea(new Dimension(0, 10)));
		panelInfoApplicantManagementDetails.add(labelMarkApplicant);
		panelInfoApplicantManagementDetails.add(Box
				.createRigidArea(new Dimension(0, 10)));
		panelInfoApplicantManagementDetails.add(fieldMarkApplicant);
		fieldMarkApplicant.setFont(fontTextField);
		panelInfoApplicantManagementDetails.add(Box
				.createRigidArea(new Dimension(0, 10)));
		panelInfoApplicantManagementDetails.add(labelMarkApplication);
		panelInfoApplicantManagementDetails.add(fieldMarkApplication);
		panelInfoApplicantManagementDetails.add(Box
				.createRigidArea(new Dimension(0, 10)));
		fieldMarkApplication.setFont(fontTextField);
		panelInfoApplicantManagementDetails.add(labelComplete);
		panelInfoApplicantManagementDetails.add(Box
				.createRigidArea(new Dimension(0, 10)));
		panelInfoApplicantManagementDetails.add(labelCheckCL);
		panelInfoApplicantManagementDetails.add(checkCL);
		panelInfoApplicantManagementDetails.add(Box
				.createRigidArea(new Dimension(0, 10)));
		panelInfoApplicantManagementDetails.add(labelCheckCV);
		panelInfoApplicantManagementDetails.add(checkCV);
		panelInfoApplicantManagementDetails.add(Box
				.createRigidArea(new Dimension(0, 10)));

		DialogInfoApplicant.tabInfo.addTab("Details",
				panelInfoApplicantManagementDetails);
	}
}
